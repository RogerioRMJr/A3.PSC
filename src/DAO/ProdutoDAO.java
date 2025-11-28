package DAO;

import Model.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Properties;
import java.io.IOException;

public class ProdutoDAO {
    
    public ProdutoDAO() {
    }
    
    // --- 1. CONEXÃO COM O BANCO ---
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
                p.setDescricaoProduto(res.getString("descricao_produto")); // Usaremos como Categoria
                p.setQuantidadeEstoque(res.getInt("quantidade_estoque"));
                p.setPreco(res.getDouble("preco")); // Usaremos como Preço Venda
                
                if (res.getDate("data_cadastro") != null) {
                    p.setDataCadastro(res.getDate("data_cadastro").toLocalDate());
                }
                lista.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar: " + ex.getMessage());
        }
        return lista;
    }
    
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
        } catch (SQLException erro) {
            return false;
        }
    }
}