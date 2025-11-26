package DAO;

import Model.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProdutoDAO {

    // Lista que vai popular a tabela na tela
    public static ArrayList<Produto> MinhaLista = new ArrayList<>();

    public ProdutoDAO() {
    }

    // 1. Conexão com o Banco de Dados
    public Connection getConexao() {
        Connection connection = null;
        try {
            // Carrega o driver do MySQL
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);

            // Configurações do Banco
            String server = "localhost";
            String database = "db_estoque"; // Se mudou o nome do banco, altere aqui
            String url = "jdbc:mysql://" + server + ":3306/" + database + "?useTimezone=true&serverTimezone=UTC";
            String user = "root";
            String password = "rootpass"; // <--- ATENÇÃO: Verifique a senha do seu MySQL aqui!

            connection = DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao carregar Driver JDBC: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro de Conexão com o Banco: " + e.getMessage());
        }
        return connection;
    }

    // 2. READ - Carrega a lista de produtos (SELECT)
    public ArrayList<Produto> getMinhaLista() {
        MinhaLista.clear(); // Limpa a lista antiga para não duplicar
        
        try {
            Statement stmt = this.getConexao().createStatement();
            // Seleciona todos os campos exigidos no PDF
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_produtos");
            
            while (res.next()) {
                // Mapeia as colunas do banco para variáveis
                int id = res.getInt("id_produto");
                String nome = res.getString("nome_produto");
                String descricao = res.getString("descricao_produto");
                int qtd = res.getInt("quantidade_estoque");
                double preco = res.getDouble("preco");
                String data = res.getString("data_cadastro"); // Pega a data gerada pelo banco

                // Cria o objeto Produto e adiciona na lista
                Produto p = new Produto(id, nome, descricao, qtd, preco, data);
                MinhaLista.add(p);
            }
            stmt.close();
            
        } catch (SQLException ex) {
            System.out.println("Erro ao listar produtos: " + ex.getMessage());
        }
        
        return MinhaLista;
    }

    // 3. CREATE - Cadastra novo Produto (INSERT)
    public boolean InsertProdutoBD(Produto objeto) throws SQLException {
        // SQL exato com os campos da tabela
        String sql = "INSERT INTO tb_produtos(id_produto, nome_produto, descricao_produto, quantidade_estoque, preco) VALUES(?,?,?,?,?)";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            // Preenche os ? com os dados do objeto
            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setString(3, objeto.getDescricao());
            stmt.setInt(4, objeto.getQuantidade());
            stmt.setDouble(5, objeto.getPreco());
            // Obs: A data_cadastro não é enviada aqui, pois definimos no banco como automática (DEFAULT CURRENT_TIMESTAMP)

            stmt.execute();
            stmt.close();
            
            return true;
            
        } catch (SQLException erro) {
            // Repassa o erro para a View exibir a mensagem
            throw erro;
        }
    }

    // 4. DELETE - Deleta um Produto pelo ID
    public boolean DeleteProdutoBD(int id) {
        try {
            Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM tb_produtos WHERE id_produto = " + id);
            stmt.close();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro ao deletar: " + erro.getMessage());
            return false;
        }
    }

    // 5. UPDATE - Atualiza os dados de um produto
    public boolean UpdateProdutoBD(Produto objeto) {
        String sql = "UPDATE tb_produtos SET nome_produto = ?, descricao_produto = ?, quantidade_estoque = ?, preco = ? WHERE id_produto = ?";
        
        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setString(1, objeto.getNome());
            stmt.setString(2, objeto.getDescricao());
            stmt.setInt(3, objeto.getQuantidade());
            stmt.setDouble(4, objeto.getPreco());
            stmt.setInt(5, objeto.getId()); // O ID é usado na cláusula WHERE

            stmt.execute();
            stmt.close();
            return true;
            
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }
    
    // 6. Utilitário - Busca o maior ID para gerar o próximo (Auto-numeração manual)
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
            // Se a tabela estiver vazia ou der erro, retorna 0 (o próximo será 1)
        }
        return maiorID;
    }
}