package DAO;

import Model.Produto;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.io.IOException;

public class ProdutoDAO {

    public ProdutoDAO() {}

    // ==========================
    //  CONEXÃO COM BANCO
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

            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);

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
    // CARREGAR CONFIGS
    // ==========================
    private Properties loadConfigs() {
        Properties props = new Properties();
        String fileName = "config.properties";

        try (var input = getClass().getClassLoader().getResourceAsStream(fileName)) {
            if (input == null)
                return props;

            props.load(input);
        } catch (IOException e) {
            System.out.println("Erro ao carregar " + fileName + ": " + e.getMessage());
        }

        return props;
    }

    // ==========================
    // MAIOR ID
    // ==========================
    public int maiorID() {
        int maiorID = 0;

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id_produto) id FROM tb_produtos");

            if (res.next()) maiorID = res.getInt("id");

            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar maior ID: " + ex.getMessage());
        }

        return maiorID;
    }

    // ==========================
    // LISTAR TODOS
    // ==========================
    public ArrayList<Produto> getListaProdutos() {
        ArrayList<Produto> lista = new ArrayList<>();

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_produtos");

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

            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Erro ao listar produtos: " + ex.getMessage());
        }

        return lista;
    }

    // ==========================
    // INSERIR PRODUTO
    // ==========================
    public boolean inserirProdutoBD(Produto p) {
        String sql = """
        INSERT INTO tb_produtos
        (id_produto, nome_produto, descricao_produto, categoria, fornecedor,
        quantidade_estoque, preco_custo, preco_venda, data_cadastro)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
        """;

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            int novoId = this.maiorID() + 1;
            p.setIdProduto(novoId);

            stmt.setInt(1, p.getIdProduto());
            stmt.setString(2, p.getNomeProduto());
            stmt.setString(3, p.getDescricaoProduto());
            stmt.setString(4, p.getCategoria());
            stmt.setString(5, p.getFornecedor());
            stmt.setInt(6, p.getQuantidadeEstoque());
            stmt.setDouble(7, p.getPrecoCusto());
            stmt.setDouble(8, p.getPrecoVenda());

            if (p.getDataCadastro() != null)
                stmt.setDate(9, java.sql.Date.valueOf(p.getDataCadastro()));
            else
                stmt.setDate(9, null);

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }

    // ==========================
    // DELETAR
    // ==========================
    public boolean deleteProdutoBD(int idProduto) {
        try {
            Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM tb_produtos WHERE id_produto = " + idProduto);
            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro ao deletar produto: " + erro.getMessage());
        }

        return true;
    }

    // ==========================
    // ATUALIZAR
    // ==========================
    public boolean updateProdutoBD(Produto p) {
        String sql = """
        UPDATE tb_produtos SET
        nome_produto = ?, descricao_produto = ?, categoria = ?, fornecedor = ?,
        quantidade_estoque = ?, preco_custo = ?, preco_venda = ?
        WHERE id_produto = ?
        """;

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setString(1, p.getNomeProduto());
            stmt.setString(2, p.getDescricaoProduto());
            stmt.setString(3, p.getCategoria());
            stmt.setString(4, p.getFornecedor());
            stmt.setInt(5, p.getQuantidadeEstoque());
            stmt.setDouble(6, p.getPrecoCusto());
            stmt.setDouble(7, p.getPrecoVenda());
            stmt.setInt(8, p.getIdProduto());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }

    // ==========================
    // CARREGAR UM PRODUTO
    // ==========================
    public Produto carregaProduto(int idProduto) {
        Produto p = new Produto();
        p.setIdProduto(idProduto);

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_produtos WHERE id_produto = " + idProduto);

            if (res.next()) {
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

            stmt.close();

        } catch (SQLException erro) {
            System.out.println("Erro ao carregar produto: " + erro.getMessage());
        }

        return p;
    }
}
