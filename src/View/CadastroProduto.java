/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;
import DAO.ProdutoDAO;
import Model.Produto;
import javax.swing.JOptionPane;
import View.GerenciamentoProdutos;
/**
 *
 * @author Luiz
 */
public class CadastroProduto extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CadastroProduto.class.getName());

    /**
     * Creates new form CadastroProduto
     */
    public CadastroProduto() {
        initComponents();
        
    try {
      
        java.awt.Image iconeTitulo = java.awt.Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagens/logoicon.png"));
        
      
        this.setIconImage(iconeTitulo);
        
    } catch (Exception e) {
        System.out.println("Imagem do ícone não encontrada!");
    }
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    private void limparCampos() {
    t_categoria.setText("");
    t_produto.setText("");
    t_estoque.setText("");
    t_precovenda.setText("");
    t_precocusto.setText("");
    t_fornecedor.setText("");
    t_descricao.setText("");
    
    
    t_categoria.requestFocus(); 
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelCategoria = new javax.swing.JLabel();
        t_categoria = new javax.swing.JTextField();
        jLabelProduto = new javax.swing.JLabel();
        t_produto = new javax.swing.JTextField();
        jLabelEstoque = new javax.swing.JLabel();
        jLabelPrecoVenda = new javax.swing.JLabel();
        jLabelPrecoCusto = new javax.swing.JLabel();
        t_precovenda = new javax.swing.JTextField();
        jLabelFornecedor = new javax.swing.JLabel();
        t_fornecedor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        BtnCancelar = new javax.swing.JButton();
        BtnCadastrar = new javax.swing.JButton();
        t_estoque = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        t_precocusto = new javax.swing.JTextField();
        BtnCancelar1 = new javax.swing.JButton();
        jLabelDescricao = new javax.swing.JLabel();
        t_descricao = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.darkGray);

        jLabelCategoria.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabelCategoria.setText("Categoria:");

        t_categoria.addActionListener(this::t_categoriaActionPerformed);

        jLabelProduto.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabelProduto.setText("Produto:");

        jLabelEstoque.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabelEstoque.setText("Estoque:");

        jLabelPrecoVenda.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabelPrecoVenda.setText("Preço de Venda:");

        jLabelPrecoCusto.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabelPrecoCusto.setText("Preço de Custo:");

        t_precovenda.addActionListener(this::t_precovendaActionPerformed);

        jLabelFornecedor.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabelFornecedor.setText("Fornecedor:");

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel1.setText("CADASTRO DE PRODUTOS");

        BtnCancelar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        BtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8-vassoura-25.png"))); // NOI18N
        BtnCancelar.setText("Limpar");
        BtnCancelar.setMaximumSize(new java.awt.Dimension(108, 32));
        BtnCancelar.setMinimumSize(new java.awt.Dimension(108, 32));
        BtnCancelar.addActionListener(this::BtnCancelarActionPerformed);

        BtnCadastrar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        BtnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8-salvar-25.png"))); // NOI18N
        BtnCadastrar.setText("Cadastrar");
        BtnCadastrar.addActionListener(this::BtnCadastrarActionPerformed);

        t_estoque.addActionListener(this::t_estoqueActionPerformed);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8-cadastro-50 (1).png"))); // NOI18N

        t_precocusto.addActionListener(this::t_precocustoActionPerformed);

        BtnCancelar1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        BtnCancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8-voltar-24 (1).png"))); // NOI18N
        BtnCancelar1.setText("Voltar");
        BtnCancelar1.setMaximumSize(new java.awt.Dimension(108, 32));
        BtnCancelar1.setMinimumSize(new java.awt.Dimension(108, 32));
        BtnCancelar1.addActionListener(this::BtnCancelar1ActionPerformed);

        jLabelDescricao.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabelDescricao.setText("Descrição:");
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelProduto)
                    .addComponent(jLabelEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDescricao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(t_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addGap(135, 135, 135))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(t_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(t_estoque, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabelFornecedor)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(t_fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabelPrecoVenda)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(t_precovenda, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabelPrecoCusto)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(t_precocusto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(t_descricao))
                        .addGap(50, 50, 50))))
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(BtnCadastrar)
                .addGap(74, 74, 74)
                .addComponent(BtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(BtnCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t_fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFornecedor)
                    .addComponent(jLabelCategoria))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_precocusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPrecoCusto)
                    .addComponent(jLabelProduto)
                    .addComponent(t_produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_precovenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPrecoVenda)
                    .addComponent(t_estoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEstoque))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDescricao))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnCadastrar)
                    .addComponent(BtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCadastrarActionPerformed
                                          
    try {
       
        String descricao = t_descricao.getText().trim(); 
        
       
        String categoria = t_categoria.getText().trim();
        String produtoNome = t_produto.getText().trim();
        String estoqueStr = t_estoque.getText().trim();
        String fornecedor = t_fornecedor.getText().trim();
        String pCustoStr = t_precocusto.getText().trim();
        String pVendaStr = t_precovenda.getText().trim();

      
        if (categoria.isEmpty() || produtoNome.isEmpty() || estoqueStr.isEmpty()
                || fornecedor.isEmpty() || pCustoStr.isEmpty() || pVendaStr.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Atenção", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

      
        int quantidade = Integer.parseInt(estoqueStr);
        
       
        double precoCusto = Double.parseDouble(pCustoStr.replace("R$", "").replace(".", "").replace(",", ".").trim());
        double precoVenda = Double.parseDouble(pVendaStr.replace("R$", "").replace(".", "").replace(",", ".").trim());
        
        double lucro = precoVenda - precoCusto;

        
        Model.Produto obj = new Model.Produto();
        
      
        obj.setDescricaoProduto(descricao); 
        
        obj.setCategoria(categoria);
        obj.setNomeProduto(produtoNome);
        obj.setQuantidadeEstoque(quantidade);
        obj.setFornecedor(fornecedor);
        obj.setPrecoCusto(precoCusto);
        obj.setPrecoVenda(precoVenda);

       
        DAO.ProdutoDAO dao = new DAO.ProdutoDAO();
        
        
        if (dao.inserirProdutoBD(obj)) {
            
            String mensagemSucesso = "✅ Produto Cadastrado com Sucesso!  \n\n" +
                                     "📋 Categoria: " + categoria + "\n" +
                                     "🛒 Produto: " + produtoNome + "\n" +
                                     "📝 Descrição: " + descricao + "\n" + // Adicionei na mensagem para você conferir
                                     "🛍️ Estoque: " + quantidade + "\n" +
                                     "✈️ Fornecedor: " + fornecedor + "\n" +
                                     "💲 Preço Custo: R$ " + String.format("%.2f", precoCusto) + "\n" +
                                     "💰 Preço Venda: R$ " + String.format("%.2f", precoVenda) + "\n" +
                                     "--------------------------------\n" +
                                     "📈 Lucro Estimado: R$ " + String.format("%.2f", lucro);

            javax.swing.JOptionPane.showMessageDialog(this, mensagemSucesso, "Sucesso", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
            limparCampos(); 
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "❌ Erro ao cadastrar no banco de dados.");
        }

    } catch (NumberFormatException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Erro nos números: Verifique se Preço e Estoque são válidos.", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Erro inesperado: " + e.getMessage());
    }
    }


private void avisoErro(String msg) {
    javax.swing.JOptionPane.showMessageDialog(this, msg, "Atenção", javax.swing.JOptionPane.WARNING_MESSAGE);

    
                                
                                                
                                             
   

    }//GEN-LAST:event_BtnCadastrarActionPerformed

    private void t_precovendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_precovendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_precovendaActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
                                           
    
    limparCampos(); 
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void t_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_categoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_categoriaActionPerformed

    private void BtnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelar1ActionPerformed

        GerenciamentoProdutos tela = new GerenciamentoProdutos();

        tela.setLocationRelativeTo(null);

        tela.setVisible(true); 
         this.dispose();           // TODO add your handling code here:
    }//GEN-LAST:event_BtnCancelar1ActionPerformed

    private void t_precocustoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_precocustoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_precocustoActionPerformed

    private void t_estoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_estoqueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_estoqueActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new CadastroProduto().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCadastrar;
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnCancelar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelCategoria;
    private javax.swing.JLabel jLabelDescricao;
    private javax.swing.JLabel jLabelEstoque;
    private javax.swing.JLabel jLabelFornecedor;
    private javax.swing.JLabel jLabelPrecoCusto;
    private javax.swing.JLabel jLabelPrecoVenda;
    private javax.swing.JLabel jLabelProduto;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTextField t_categoria;
    private javax.swing.JTextField t_descricao;
    private javax.swing.JTextField t_estoque;
    private javax.swing.JTextField t_fornecedor;
    private javax.swing.JTextField t_precocusto;
    private javax.swing.JTextField t_precovenda;
    private javax.swing.JTextField t_produto;
    // End of variables declaration//GEN-END:variables
}
