package DAO;

import Model.Produto;
<<<<<<< HEAD
=======
import java.io.IOException;
>>>>>>> main
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
<<<<<<< HEAD
import java.sql.Date;
import java.util.ArrayList;
import java.util.Properties;
import java.io.IOException;

public class ProdutoDAO {
    
    public ProdutoDAO() {
    }
    
    // --- 1. CONEXÃO COM O BANCO ---
=======
import java.util.ArrayList;
import java.util.Properties;
import java.sql.DriverManager;

public class ProdutoDAO {

    public ProdutoDAO() {}

    // ==========================
    //  CONEXÃO COM BANCO (OK)
    // ==========================
>>>>>>> main
    public Connection getConexao() {
        Connection connection = null;
        try {
            Properties props = loadConfigs();
            String host = props.getProperty("db.host");
            String port = props.getProperty("db.port");
            String database = props.getProperty("db.name");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");
<<<<<<< HEAD

            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            String url = "jdbc:mysql://" + host + ":" + port + "/" + database + "?useTimezone=true&serverTimezone=UTC";

            connection = DriverManager.getConnection(url, user, password);
            return connection;

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro de Conexão: " + e.getMessage());
            return null;
        }
    }

    private Properties loadConfigs() {
        Properties props = new Properties();
        try (var input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input != null) props.load(input);
        } catch (IOException e) {
            System.out.println("Erro config: " + e.getMessage());
        }
        return props;
    }

    // --- 2. LISTAR (SELECT) ---
=======
            
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
>>>>>>> main
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
<<<<<<< HEAD
                p.setDescricaoProduto(res.getString("descricao_produto")); // Usaremos como Categoria
                p.setQuantidadeEstoque(res.getInt("quantidade_estoque"));
                p.setPreco(res.getDouble("preco")); // Usaremos como Preço Venda
                
                if (res.getDate("data_cadastro") != null) {
                    p.setDataCadastro(res.getDate("data_cadastro").toLocalDate());
                }
=======
                p.setDescricaoProduto(res.getString("descricao_produto"));
                p.setCategoria(res.getString("categoria"));
                p.setFornecedor(res.getString("fornecedor"));
                p.setQuantidadeEstoque(res.getInt("quantidade_estoque"));
                p.setPrecoCusto(res.getDouble("preco_custo"));
                p.setPrecoVenda(res.getDouble("preco_venda"));

                if (res.getDate("data_cadastro") != null)
                    p.setDataCadastro(res.getDate("data_cadastro").toLocalDate());

>>>>>>> main
                lista.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar: " + ex.getMessage());
        }
        return lista;
    }
<<<<<<< HEAD
    
    // --- 3. INSERIR (INSERT) ---
    public boolean inserirProdutoBD(Produto p) {
        String sql = "INSERT INTO tb_produtos(nome_produto, descricao_produto, quantidade_estoque, preco, data_cadastro) VALUES(?,?,?,?,?)";
        
        try (Connection conn = this.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getNomeProduto());
            stmt.setString(2, p.getDescricaoProduto());
            stmt.setInt(3, p.getQuantidadeEstoque());
            stmt.setDouble(4, p.getPreco());
            stmt.setDate(5, p.getDataCadastro() != null ? Date.valueOf(p.getDataCadastro()) : null);
            
            stmt.execute();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro ao inserir: " + erro.getMessage());
            return false;
        }
    }
    
    // --- 4. ATUALIZAR (UPDATE) ---
    public boolean updateProdutoBD(Produto p) {
        String sql = "UPDATE tb_produtos SET nome_produto=?, descricao_produto=?, quantidade_estoque=?, preco=? WHERE id_produto=?";

        try (Connection conn = this.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, p.getNomeProduto());
            stmt.setString(2, p.getDescricaoProduto()); 
            stmt.setInt(3, p.getQuantidadeEstoque());
            stmt.setDouble(4, p.getPreco());
            stmt.setInt(5, p.getIdProduto());

            stmt.execute();
            return true;
        } catch (SQLException erro) {
            return false;
        }
    }
    
    // --- 5. DELETAR (DELETE) ---
    public boolean deleteProdutoBD(int id) {
        String sql = "DELETE FROM tb_produtos WHERE id_produto = ?";
        try (Connection conn = this.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
            return true;
=======

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
>>>>>>> main
        } catch (SQLException erro) {
            return false;
        }
<<<<<<< HEAD
=======
        return p;
>>>>>>> main
    }
}