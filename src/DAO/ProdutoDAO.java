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
    
    public ProdutoDAO() {
    }
    
    // CONEXÃO COM O BANCO 
    
    public Connection getConexao() {

    Connection connection = null;

    try {
        // carrega as configs externas
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

        if (connection != null) {
            System.out.println("Status: Conectado!");
        } else {
            System.out.println("Status: NÃO CONECTADO!");
        }

        return connection;

    } catch (ClassNotFoundException e) {
        System.out.println("Driver não encontrado: " + e.getMessage());
        return null;

    } catch (SQLException e) {
        System.out.println("Erro ao conectar: " + e.getMessage());
        return null;
    }
}

    
    //MÉTODO PARA CARREGAR OS DADOS DO BANCO DE FORMA SEGURA
    
    private Properties loadConfigs() {
    Properties props = new Properties();
    String fileName = "config.properties";

    try (var input = getClass().getClassLoader().getResourceAsStream(fileName)) {
        if (input == null) {
            System.out.println("Arquivo " + fileName + " não encontrado no classpath.");
            return props;
        }
        props.load(input);
    } catch (IOException e) {
        System.out.println("Erro ao carregar " + fileName + ": " + e.getMessage());
    }

    return props;
}


    
    // MAIOR ID 
    
    public int maiorID() throws SQLException {
        int maiorID = 0;
        
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id_produto) id FROM tb_produtos");
            if (res.next()) {
                maiorID = res.getInt("id");
            }
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar maior ID: " + ex.getMessage());
        }

        return maiorID;
    }
    
    // LISTAR TODOS 
    
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
                p.setQuantidadeEstoque(res.getInt("quantidade_estoque"));
                p.setPreco(res.getDouble("preco"));
                
                // Se estiver usando DATE no banco:
                if (res.getDate("data_cadastro") != null) {
                    p.setDataCadastro(res.getDate("data_cadastro").toLocalDate());
                }
                
                lista.add(p);
            }

            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Erro ao listar produtos: " + ex.getMessage());
        }

        return lista;
    }
    
    //  INSERIR 
    
    public boolean inserirProdutoBD(Produto p) throws SQLException {
        String sql = "INSERT INTO tb_produtos(id_produto, nome_produto, descricao_produto, quantidade_estoque, preco, data_cadastro) "
                   + "VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            int novoId = this.maiorID() + 1;
            p.setIdProduto(novoId);

            stmt.setInt(1, p.getIdProduto());
            stmt.setString(2, p.getNomeProduto());
            stmt.setString(3, p.getDescricaoProduto());
            stmt.setInt(4, p.getQuantidadeEstoque());
            stmt.setDouble(5, p.getPreco());
            
            // dataCadastro já vem setada no construtor com LocalDate.now();
            if (p.getDataCadastro() != null) {
                stmt.setDate(6, java.sql.Date.valueOf(p.getDataCadastro()));
            } else {
                stmt.setDate(6, null);
            }

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }
    
    //  DELETAR 
    
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
    
    //  ATUALIZAR 
    
    public boolean updateProdutoBD(Produto p) {
        String sql = "UPDATE tb_produtos SET "
                   + "nome_produto = ?, "
                   + "descricao_produto = ?, "
                   + "quantidade_estoque = ?, "
                   + "preco = ? "
                   + "WHERE id_produto = ?";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setString(1, p.getNomeProduto());
            stmt.setString(2, p.getDescricaoProduto());
            stmt.setInt(3, p.getQuantidadeEstoque());
            stmt.setDouble(4, p.getPreco());
            stmt.setInt(5, p.getIdProduto());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }
    
    //  CARREGAR UM ÚNICO PRODUTO 
    
    public Produto carregaProduto(int idProduto) {
        Produto p = new Produto();
        p.setIdProduto(idProduto);
        
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_produtos WHERE id_produto = " + idProduto);
            
            if (res.next()) {
                p.setNomeProduto(res.getString("nome_produto"));
                p.setDescricaoProduto(res.getString("descricao_produto"));
                p.setQuantidadeEstoque(res.getInt("quantidade_estoque"));
                p.setPreco(res.getDouble("preco"));
                
                if (res.getDate("data_cadastro") != null) {
                    p.setDataCadastro(res.getDate("data_cadastro").toLocalDate());
                }
            }

            stmt.close();            
            
        } catch (SQLException erro) {
            System.out.println("Erro ao carregar produto: " + erro.getMessage());
        }
        
        return p;
    }
}