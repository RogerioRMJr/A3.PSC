package Model;

import java.time.LocalDate;

public class Produto {

    private int idProduto;
    private String nomeProduto;
    private String descricaoProduto;
    private String categoria;
    private String fornecedor;
    private int quantidadeEstoque;
    private double precoCusto;
    private double precoVenda;
    private LocalDate dataCadastro;

    // Construtor vazio (obrigatório para DAO)
    public Produto() {
    }

    // Construtor completo (para criar objetos mais facilmente)
    public Produto(int idProduto, String nomeProduto, String descricaoProduto, String categoria,
                   String fornecedor, int quantidadeEstoque, double precoCusto, double precoVenda) {

        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
        this.quantidadeEstoque = quantidadeEstoque;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;

        // já define a data de cadastro automaticamente
        this.dataCadastro = LocalDate.now();
    }

    // GETTERS e SETTERS
    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    // LUCRO do produto (útil na tabela)
    public double getLucro() {
        return precoVenda - precoCusto;
    }

    // Total em estoque (se quiser usar)
    public double getValorTotal() {
        return precoVenda * quantidadeEstoque;
    }

    @Override
    public String toString() {
        return "Produto { " +
                "id=" + idProduto +
                ", nome='" + nomeProduto + '\'' +
                ", categoria='" + categoria + '\'' +
                ", fornecedor='" + fornecedor + '\'' +
                ", estoque=" + quantidadeEstoque +
                ", custo=" + precoCusto +
                ", venda=" + precoVenda +
                ", cadastro=" + dataCadastro +
                " }";
    }
}
