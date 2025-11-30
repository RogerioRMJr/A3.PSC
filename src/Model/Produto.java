package Model;

import java.time.LocalDate;

public class Produto {
    
    private int idProduto;
    private String categoria;
    private String nomeProduto;
    private String descricaoProduto;
    private int quantidadeEstoque;
    private String fornecedor;
    private double precoCusto;
    private double precoVenda;
    private LocalDate dataCadastro;
    
    public Produto() {}

    // onstrutores
    public Produto(int idProduto, String categoria, String nomeProduto, String descricaoProduto, 
                   int quantidadeEstoque, String fornecedor, double precoCusto, double precoVenda) {
        this.idProduto = idProduto;
        this.categoria = categoria;
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto; // VOLTOU AQUI
        this.quantidadeEstoque = quantidadeEstoque;
        this.fornecedor = fornecedor;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.dataCadastro = LocalDate.now();
    }

    // getters e Setters
    public int getIdProduto() { return idProduto; }
    public void setIdProduto(int idProduto) { this.idProduto = idProduto; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getNomeProduto() { return nomeProduto; }
    public void setNomeProduto(String nomeProduto) { this.nomeProduto = nomeProduto; }

    public String getDescricaoProduto() { return descricaoProduto; } // Getter
    public void setDescricaoProduto(String descricaoProduto) { this.descricaoProduto = descricaoProduto; } // Setter

    public int getQuantidadeEstoque() { return quantidadeEstoque; }
    public void setQuantidadeEstoque(int quantidadeEstoque) { this.quantidadeEstoque = quantidadeEstoque; }

    public String getFornecedor() { return fornecedor; }
    public void setFornecedor(String fornecedor) { this.fornecedor = fornecedor; }

    public double getPrecoCusto() { return precoCusto; }
    public void setPrecoCusto(double precoCusto) { this.precoCusto = precoCusto; }

    public double getPrecoVenda() { return precoVenda; }
    public void setPrecoVenda(double precoVenda) { this.precoVenda = precoVenda; }

    public LocalDate getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(LocalDate dataCadastro) { this.dataCadastro = dataCadastro; }
    
    public double getLucro() {
        return precoVenda - precoCusto;
    }
    
    @Override
    public String toString() {
        return getNomeProduto(); // Isso ajuda a exibir o nome se você usar combobox
    }
}