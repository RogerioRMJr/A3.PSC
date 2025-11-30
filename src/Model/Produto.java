package Model;

import java.time.LocalDate;

public class Produto {

    private int idProduto;
    private String nomeProduto;
    private String descricaoProduto;
    private int quantidadeEstoque;
    private double preco;
    private LocalDate dataCadastro;

    // 1. Construtor Padrão
    public Produto() {
    }

    // 2. Construtor Completo (Para carregar do Banco de Dados)
    public Produto(int idProduto, String nomeProduto, String descricaoProduto, int quantidadeEstoque, double preco, LocalDate dataCadastro) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
        this.quantidadeEstoque = quantidadeEstoque;
        this.preco = preco;
        this.dataCadastro = dataCadastro; // Data Lida do BD
    }

    // 3. Construtor para NOVOS PRODUTOS (ID gerado pelo banco)
    public Produto(String nomeProduto, String descricaoProduto, int quantidadeEstoque, double preco) {
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
        this.quantidadeEstoque = quantidadeEstoque;
        this.preco = preco;
        this.dataCadastro = LocalDate.now(); // Define data atual
    }

    // Getters
    public int getIdProduto() {
        return idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public double getPreco() {
        return preco;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    // Setters
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    // Método de Negócio
    public double getValorTotal(){
        return preco * quantidadeEstoque;
    }

// toString() usando StringBuilder
@Override
public String toString(){
    String precoFormatado = String.format("R$%.2f", preco);
    String valorTotalFormatado = String.format("R$%.2f", getValorTotal());
    
    // Constrói a string de forma mais eficiente
    StringBuilder sb = new StringBuilder("Produto {\n");
    sb.append("  ID: ").append(idProduto).append("\n");
    sb.append("  Nome: '").append(nomeProduto).append("'\n");
    sb.append("  Descrição: '").append(descricaoProduto).append("'\n");
    sb.append("  Preço Unitário: ").append(precoFormatado).append("\n");
    sb.append("  Quantidade em Estoque: ").append(quantidadeEstoque).append("\n");
    sb.append("  Valor Total (Estoque): ").append(valorTotalFormatado).append("\n");
    sb.append("  Data de Cadastro: ").append(dataCadastro).append("\n");
    sb.append("}");
    
    return sb.toString();
}
}