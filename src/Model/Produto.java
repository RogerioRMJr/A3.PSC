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

    // 1. Construtor Padrão (Obrigatório para o DAO usar setters)
    public Produto() {
    }

    // 2. Construtor para NOVO PRODUTO (ID gerado pelo BD, data atual)
    public Produto(String nomeProduto, String descricaoProduto, String categoria,
                   String fornecedor, int quantidadeEstoque, double precoCusto, double precoVenda) {

        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
        this.quantidadeEstoque = quantidadeEstoque;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.dataCadastro = LocalDate.now();
    }

    // 3. Construtor COMPLETO (Para carregar do Banco de Dados)
    public Produto(int idProduto, String nomeProduto, String descricaoProduto, String categoria,
                   String fornecedor, int quantidadeEstoque, double precoCusto, double precoVenda, LocalDate dataCadastro) {

        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
        this.quantidadeEstoque = quantidadeEstoque;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.dataCadastro = dataCadastro;
    }

    // ==========================
    // GETTERS
    // ==========================
    public int getIdProduto() { return idProduto; }
    public String getNomeProduto() { return nomeProduto; }
    public String getDescricaoProduto() { return descricaoProduto; }
    public String getCategoria() { return categoria; }
    public String getFornecedor() { return fornecedor; }
    public int getQuantidadeEstoque() { return quantidadeEstoque; }
    public double getPrecoCusto() { return precoCusto; }
    public double getPrecoVenda() { return precoVenda; }
    public LocalDate getDataCadastro() { return dataCadastro; }
    
    // ==========================
    // SETTERS
    // ==========================
    public void setIdProduto(int idProduto) { this.idProduto = idProduto; }
    public void setNomeProduto(String nomeProduto) { this.nomeProduto = nomeProduto; }
    public void setDescricaoProduto(String descricaoProduto) { this.descricaoProduto = descricaoProduto; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public void setFornecedor(String fornecedor) { this.fornecedor = fornecedor; }
    public void setQuantidadeEstoque(int quantidadeEstoque) { this.quantidadeEstoque = quantidadeEstoque; }
    public void setPrecoCusto(double precoCusto) { this.precoCusto = precoCusto; }
    public void setPrecoVenda(double precoVenda) { this.precoVenda = precoVenda; }
    public void setDataCadastro(LocalDate dataCadastro) { this.dataCadastro = dataCadastro; }

    // ==========================
    // MÉTODOS DE NEGÓCIO
    // ==========================
    public double getLucro() {
        return precoVenda - precoCusto;
    }

    public double getValorTotal() {
        return precoVenda * quantidadeEstoque;
    }

    // ==========================
    // TOSTRING()
    // ==========================
    @Override
    public String toString() {
        String custoFormatado = String.format("R$%.2f", precoCusto);
        String vendaFormatado = String.format("R$%.2f", precoVenda);
        String lucroFormatado = String.format("R$%.2f", getLucro());
        String valorTotalFormatado = String.format("R$%.2f", getValorTotal());
        
        // Uso de StringBuilder para melhor performance (resolve o aviso de estilo)
        StringBuilder sb = new StringBuilder("Produto {\n");
        sb.append("  ID: ").append(idProduto).append("\n");
        sb.append("  Nome: '").append(nomeProduto).append("'\n");
        sb.append("  Descrição: '").append(descricaoProduto).append("'\n");
        sb.append("  Categoria: ").append(categoria).append("\n");
        sb.append("  Fornecedor: ").append(fornecedor).append("\n");
        sb.append("  Estoque: ").append(quantidadeEstoque).append(" unidades\n");
        sb.append("  Preço de Custo: ").append(custoFormatado).append("\n");
        sb.append("  Preço de Venda: ").append(vendaFormatado).append("\n");
        sb.append("  Lucro (Unidade): ").append(lucroFormatado).append("\n");
        sb.append("  Valor Total em Estoque: ").append(valorTotalFormatado).append("\n");
        sb.append("  Data de Cadastro: ").append(dataCadastro).append("\n");
        sb.append("}");
        
        return sb.toString();
    }
}