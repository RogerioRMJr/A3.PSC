package DAO;

import Model.Produto;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.sql.DriverManager;

public class ProdutoDAO {

    public ProdutoDAO() {}

    // ==========================
    //  CONEXÃO COM BANCO (OK)
    // ==========================
    public Connection getConexao() {
        Connection connection = null;
        try {
            Properties props = loadConfigs();
            String host = props.getProperty("db.host");
            String port = props.getProperty("db.port");
            String database = props.getProperty("db.name");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://" + host + ":" + port + "/" + database
                    + "?useTimezone=true&serverTimezone=UTC";

            connection = DriverManager.getConnection(url, user, password);
            System.out.println(connection != null ? "Status: Conectado!" : "Status: NÃO CONECTADO!");
            return connection;

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
    }

    // ==========================
    // CARREGAR CONFIGS (OK)
    // ==========================
    private Properties loadConfigs() {
        Properties props = new Properties();
        String fileName = "config.properties";

        try (var input = getClass().getClassLoader().getResourceAsStream(fileName)) {
            if (input == null) return props;
            props.load(input);
        } catch (IOException e) {
            System.out.println("Erro ao carregar " + fileName + ": " + e.getMessage());
        }
        return props;
    }
    
    // ==========================
    // MAIOR ID (Refatorado com TWR)
    // ==========================
    public int maiorID() {
        String sql = "SELECT MAX(id_produto) id FROM tb_produtos";
        try (Connection conn = this.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet res = stmt.executeQuery(sql)) {

            if (conn == null) return 0;
            if (res.next()) {
                return res.getInt("id");
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar maior ID: " + ex.getMessage());
        }
        return 0;
    }

    // ==========================
    // LISTAR TODOS (Refatorado com TWR)
    // ==========================
    public ArrayList<Produto> getListaProdutos() {
        ArrayList<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM tb_produtos";

        try (Connection conn = this.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet res = stmt.executeQuery(sql)) {

            while (res.next()) {
                Produto p = new Produto();
                p.setIdProduto(res.getInt("id_produto"));
                p.setNomeProduto(res.getString("nome_produto"));
                p.setDescricaoProduto(res.getString("descricao_produto"));
                p.setCategoria(res.getString("categoria"));
                p.setFornecedor(res.getString("fornecedor"));
                p.setQuantidadeEstoque(res.getInt("quantidade_estoque"));
                p.setPrecoCusto(res.getDouble("preco_custo"));
                p.setPrecoVenda(res.getDouble("preco_venda"));

                if (res.getDate("data_cadastro") != null)
                    p.setDataCadastro(res.getDate("data_cadastro").toLocalDate());

                lista.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar produtos: " + ex.getMessage());
        }
        return lista;
    }

    // ==========================
    // INSERIR PRODUTO (Refatorado para AUTO-INCREMENTO e TWR)
    // ==========================
    public boolean inserirProdutoBD(Produto p) {
        String sql = """
        INSERT INTO tb_produtos
        (nome_produto, descricao_produto, categoria, fornecedor,
        quantidade_estoque, preco_custo, preco_venda, data_cadastro)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?)
        """; // ATENÇÃO: id_produto foi removido do INSERT

        try (Connection conn = this.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            if (conn == null) return false;

            // Define os 8 parâmetros restantes (sem o ID)
            stmt.setString(1, p.getNomeProduto());
            stmt.setString(2, p.getDescricaoProduto());
            stmt.setString(3, p.getCategoria());
            stmt.setString(4, p.getFornecedor());
            stmt.setInt(5, p.getQuantidadeEstoque());
            stmt.setDouble(6, p.getPrecoCusto());
            stmt.setDouble(7, p.getPrecoVenda());

            if (p.getDataCadastro() != null)
                stmt.setDate(8, java.sql.Date.valueOf(p.getDataCadastro()));
            else
                stmt.setDate(8, null);

            stmt.execute();

            // Obtém o ID gerado pelo banco e atualiza o objeto Model
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    p.setIdProduto(generatedKeys.getInt(1));
                }
            }
            return true;

        } catch (SQLException erro) {
            System.out.println("Erro ao inserir produto: " + erro.getMessage());
            return false;
        }
    }

    // ==========================
    // DELETAR (Refatorado para PreparedStatement e TWR - CORREÇÃO DE SEGURANÇA)
    // ==========================
    public boolean deleteProdutoBD(int idProduto) {
        String sql = "DELETE FROM tb_produtos WHERE id_produto = ?";
        
        try (Connection conn = this.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            if (conn == null) return false;

            stmt.setInt(1, idProduto); 
            
            int linhasAfetadas = stmt.executeUpdate();
            
            return linhasAfetadas > 0;

        } catch (SQLException erro) {
            System.out.println("Erro ao deletar produto: " + erro.getMessage());
            return false;
        }
    }

    // ==========================
    // ATUALIZAR (Refatorado com TWR)
    // ==========================
    public boolean updateProdutoBD(Produto p) {
        String sql = """
        UPDATE tb_produtos SET
        nome_produto = ?, descricao_produto = ?, categoria = ?, fornecedor = ?,
        quantidade_estoque = ?, preco_custo = ?, preco_venda = ?
        WHERE id_produto = ?
        """;

        try (Connection conn = this.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            if (conn == null) return false;

            stmt.setString(1, p.getNomeProduto());
            stmt.setString(2, p.getDescricaoProduto());
            stmt.setString(3, p.getCategoria());
            stmt.setString(4, p.getFornecedor());
            stmt.setInt(5, p.getQuantidadeEstoque());
            stmt.setDouble(6, p.getPrecoCusto());
            stmt.setDouble(7, p.getPrecoVenda());
            stmt.setInt(8, p.getIdProduto());

            int linhasAfetadas = stmt.executeUpdate();

            return linhasAfetadas > 0;

        } catch (SQLException erro) {
            System.out.println("Erro ao atualizar produto: " + erro.getMessage());
            return false;
        }
    }

    // ==========================
    // CARREGAR UM PRODUTO (Refatorado para PreparedStatement e TWR)
    // ==========================
    public Produto carregaProduto(int idProduto) {
        String sql = "SELECT * FROM tb_produtos WHERE id_produto = ?";
        Produto p = null;

        try (Connection conn = this.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            if (conn == null) return null;
            
            stmt.setInt(1, idProduto);
            
            try (ResultSet res = stmt.executeQuery()) {
                if (res.next()) {
                    p = new Produto(); 
                    p.setIdProduto(res.getInt("id_produto"));
                    p.setNomeProduto(res.getString("nome_produto"));
                    p.setDescricaoProduto(res.getString("descricao_produto"));
                    p.setCategoria(res.getString("categoria"));
                    p.setFornecedor(res.getString("fornecedor"));
                    p.setQuantidadeEstoque(res.getInt("quantidade_estoque"));
                    p.setPrecoCusto(res.getDouble("preco_custo"));
                    p.setPrecoVenda(res.getDouble("preco_venda"));

                    if (res.getDate("data_cadastro") != null)
                        p.setDataCadastro(res.getDate("data_cadastro").toLocalDate());
                }
            } 
        } catch (SQLException erro) {
            System.out.println("Erro ao carregar produto: " + erro.getMessage());
        }
        return p;
    }
}