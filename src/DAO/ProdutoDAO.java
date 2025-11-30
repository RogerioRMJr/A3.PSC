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
    
    public ProdutoDAO() { }
    
    // conexao
    public Connection getConexao() {
        try {
            String host = "localhost";
            String port = "3306";
            String database = "db_vstock";
            String user = "root";
            
            String password = "admin"; 

            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String url = "jdbc:mysql://" + host + ":" + port + "/" + database + "?useTimezone=true&serverTimezone=UTC";

            return DriverManager.getConnection(url, user, password);

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
            e.printStackTrace();
        }
        return props;
    }

    // --- CRUD ---

    public int maiorID() throws SQLException {
        int maiorID = 0;
        try (Connection con = getConexao(); Statement stmt = con.createStatement()) {
            ResultSet res = stmt.executeQuery("SELECT MAX(id_produto) id FROM tb_produtos");
            if (res.next()) maiorID = res.getInt("id");
        }
        return maiorID;
    }
    
    public ArrayList<Produto> getListaProdutos() {
        ArrayList<Produto> lista = new ArrayList<>();
        try (Connection con = getConexao(); Statement stmt = con.createStatement()) {
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_produtos");
            while (res.next()) {
                Produto p = new Produto();
                p.setIdProduto(res.getInt("id_produto"));
                p.setCategoria(res.getString("categoria"));
                p.setNomeProduto(res.getString("nome_produto"));
                p.setDescricaoProduto(res.getString("descricao_produto"));
                p.setQuantidadeEstoque(res.getInt("quantidade_estoque"));
                p.setFornecedor(res.getString("fornecedor"));
                p.setPrecoCusto(res.getDouble("preco_custo"));
                p.setPrecoVenda(res.getDouble("preco_venda"));
                if (res.getDate("data_cadastro") != null)
                    p.setDataCadastro(res.getDate("data_cadastro").toLocalDate());
                lista.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar: " + ex.getMessage());
        }
        return lista;
    }
    
    public boolean inserirProdutoBD(Produto p) {
        String sql = "INSERT INTO tb_produtos(id_produto, categoria, nome_produto, descricao_produto, quantidade_estoque, fornecedor, preco_custo, preco_venda, data_cadastro) VALUES(?,?,?,?,?,?,?,?,?)";
        try (Connection con = getConexao(); PreparedStatement stmt = con.prepareStatement(sql)) {
            int novoId = this.maiorID() + 1;
            stmt.setInt(1, novoId);
            stmt.setString(2, p.getCategoria());
            stmt.setString(3, p.getNomeProduto());
            stmt.setString(4, p.getDescricaoProduto());
            stmt.setInt(5, p.getQuantidadeEstoque());
            stmt.setString(6, p.getFornecedor());
            stmt.setDouble(7, p.getPrecoCusto());
            stmt.setDouble(8, p.getPrecoVenda());
            stmt.setDate(9, p.getDataCadastro() != null ? java.sql.Date.valueOf(p.getDataCadastro()) : null);
            stmt.execute();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro ao inserir: " + erro.getMessage());
            return false;
        }
    }

    public boolean deleteProdutoBD(int idProduto) {
        try (Connection con = getConexao(); Statement stmt = con.createStatement()) {
            stmt.executeUpdate("DELETE FROM tb_produtos WHERE id_produto = " + idProduto);
            return true;
        } catch (SQLException erro) {
            return false;
        }
    }
    
    public boolean updateProdutoBD(Produto p) {
        String sql = "UPDATE tb_produtos SET categoria=?, nome_produto=?, descricao_produto=?, quantidade_estoque=?, fornecedor=?, preco_custo=?, preco_venda=? WHERE id_produto=?";
        try (Connection con = getConexao(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, p.getCategoria());
            stmt.setString(2, p.getNomeProduto());
            stmt.setString(3, p.getDescricaoProduto());
            stmt.setInt(4, p.getQuantidadeEstoque());
            stmt.setString(5, p.getFornecedor());
            stmt.setDouble(6, p.getPrecoCusto());
            stmt.setDouble(7, p.getPrecoVenda());
            stmt.setInt(8, p.getIdProduto());
            stmt.execute();
            return true;
        } catch (SQLException erro) {
            return false;
        }
    }
}