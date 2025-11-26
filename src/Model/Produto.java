package Model;

import DAO.ProdutoDAO;
import java.sql.SQLException;
import java.util.ArrayList;

public class Produto {
    
    private int id;                 // id_produto
    private String nome;            // nome_produto
    private String descricao;       // descricao_produto
    private int quantidade;         // quantidade_estoque
    private double preco;           // preco
    private String dataCadastro;    // data_cadastro

    // Conexão com a DAO (para seguir o padrão do seu projeto anterior)
    private final ProdutoDAO dao;

    // --- Construtor Vazio (Necessário para a Tela criar o objeto antes de preencher) ---
    public Produto() {
        this.dao = new ProdutoDAO();
    }

    // --- Construtor Completo (Usado pela DAO para preencher a lista) ---
    public Produto(int id, String nome, String descricao, int quantidade, double preco, String dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco = preco;
        this.dataCadastro = dataCadastro;
        this.dao = new ProdutoDAO();
    }

    // --- MÉTODOS DE CONTROLE (Chamam a DAO) ---
    
    // Salvar novo produto
    public boolean InsertProdutoBD(String nome, String descricao, int quantidade, double preco) throws SQLException {
        // ID é gerado automaticamente, Data é gerada pelo Banco
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco = preco;
        
        // Chama a DAO para gravar
        this.dao.InsertProdutoBD(this);
        return true;
    }

    // Carregar a lista para a tabela
    public ArrayList<Produto> getMinhaLista() {
        return this.dao.getMinhaLista();
    }

    // Deletar
    public boolean DeleteProdutoBD(int id) {
        return this.dao.DeleteProdutoBD(id);
    }
    
    // Atualizar (Update)
    public boolean UpdateProdutoBD(int id, String nome, String descricao, int quantidade, double preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco = preco;
        return this.dao.UpdateProdutoBD(this);
    }

    // --- GETTERS E SETTERS ---
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public String getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(String dataCadastro) { this.dataCadastro = dataCadastro; }
    
    @Override
    public String toString() {
        return this.getNome(); // Para aparecer bonito se usar combobox
    }
}