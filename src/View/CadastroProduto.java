/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;
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
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    private void limparCampos() {
    t_categoria.setText("");
    t_produto.setText("");
    t_precovenda.setText("");
    t_estoque.setText("");
    t_precocusto.setText("");
    t_fornecedor.setText("");
    
    
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
        t_estoque = new javax.swing.JTextField();
        jLabelFornecedor = new javax.swing.JLabel();
        t_fornecedor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        BtnCancelar = new javax.swing.JButton();
        BtnCadastrar = new javax.swing.JButton();
        t_precovenda = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        t_precocusto = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        JMenuGerenciamento = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.darkGray);

        jLabelCategoria.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabelCategoria.setText("Categoria:");

        jLabelProduto.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabelProduto.setText("Produto:");

        jLabelEstoque.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabelEstoque.setText("Estoque:");

        jLabelPrecoVenda.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabelPrecoVenda.setText("Preço de Venda:");

        jLabelPrecoCusto.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabelPrecoCusto.setText("Preço de Custo:");

        t_estoque.addActionListener(this::t_estoqueActionPerformed);

        jLabelFornecedor.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabelFornecedor.setText("Fornecedor:");

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel1.setText("CADASTRO DE PRODUTOS");

        BtnCancelar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        BtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons8-vassoura-25.png"))); // NOI18N
        BtnCancelar.setText("Limpar");
        BtnCancelar.setMaximumSize(new java.awt.Dimension(108, 32));
        BtnCancelar.setMinimumSize(new java.awt.Dimension(108, 32));
        BtnCancelar.addActionListener(this::BtnCancelarActionPerformed);

        BtnCadastrar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        BtnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons8-salvar-25.png"))); // NOI18N
        BtnCadastrar.setText("Cadastrar");
        BtnCadastrar.addActionListener(this::BtnCadastrarActionPerformed);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons8-cadastro-50 (1).png"))); // NOI18N

        JMenuGerenciamento.setBackground(new java.awt.Color(204, 0, 0));
        JMenuGerenciamento.setForeground(new java.awt.Color(102, 0, 0));
        JMenuGerenciamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons8-sair-15.png"))); // NOI18N
        JMenuGerenciamento.addActionListener(this::JMenuGerenciamentoActionPerformed);

        jMenuItem1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jMenuItem1.setForeground(new java.awt.Color(153, 0, 0));
        jMenuItem1.setText("SAIR");
        jMenuItem1.addActionListener(this::jMenuItem1ActionPerformed);
        JMenuGerenciamento.add(jMenuItem1);

        jMenuBar1.add(JMenuGerenciamento);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelProduto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(t_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(58, 58, 58)
                                    .addComponent(t_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabelEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(t_estoque, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabelPrecoVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelPrecoCusto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabelFornecedor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t_precocusto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t_fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t_precovenda, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(BtnCadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCategoria)
                    .addComponent(t_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFornecedor)
                    .addComponent(t_fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelProduto)
                    .addComponent(t_produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPrecoCusto)
                    .addComponent(t_precocusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_estoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEstoque)
                    .addComponent(jLabelPrecoVenda)
                    .addComponent(t_precovenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnCadastrar)
                    .addComponent(BtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(95, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCadastrarActionPerformed
try {
        
        String categoria = t_categoria.getText().trim();
        String produto = t_produto.getText().trim();
        String estoque = t_precovenda.getText().trim();
        String fornecedor = t_fornecedor.getText().trim();
        String pCusto = t_precovenda.getText().trim();
        String pVenda = t_estoque.getText().trim();

        
        if (categoria.isEmpty()) {
            avisoErro("Por favor, informe o ID do produto.");
            t_categoria.requestFocus();
            return;
        }
        if (produto.isEmpty()) {
            avisoErro("O nome do Produto é obrigatório.");
            t_produto.requestFocus();
            return;
        }
        if (estoque.isEmpty()) {
            avisoErro("Informe a quantidade em Estoque.");
            t_precovenda.requestFocus();
            return;
        }
        if (fornecedor.isEmpty()) {
            avisoErro("Informe o nome do Fornecedor.");
            t_fornecedor.requestFocus();
            return;
        }
        if (pCusto.isEmpty()) {
            avisoErro("O Preço de Custo é obrigatório.");
            t_precovenda.requestFocus();
            return;
        }
        if (pVenda.isEmpty()) {
            avisoErro("O Preço de Venda é obrigatório.");
            t_estoque.requestFocus();
            return;
        }

        
        double custo = Double.parseDouble(pCusto.replace(",", "."));
        double venda = Double.parseDouble(pVenda.replace(",", "."));
        double lucro = venda - custo;

        
        Object[] novaLinha = {
            categoria, produto, estoque, fornecedor, 
            String.format("R$ %.2f", custo), 
            String.format("R$ %.2f", venda), 
            String.format("R$ %.2f", lucro)
        };

        
        GerenciamentoProdutos.adicionarNaMemoria(novaLinha);

        
        String mensagemSucesso = "✅ Produto Cadastrado!  \n\n" +
                                 "📋 Categoria: " + categoria + "\n" +
                                 "🛒 Produto: " + produto + "\n" +
                                 "🛍️ Estoque: " + estoque + "\n" +
                                 "✈️ Fornecedor: " + fornecedor + "\n" +
                                 "💲 Preço Custo: R$ " + String.format("%.2f", custo) + "\n" +
                                 "💰 Preço Venda: R$ " + String.format("%.2f", venda) + "\n" +
                                 "--------------------------------\n" +
                                 "📈 Lucro Estimado: R$ " + String.format("%.2f", lucro);

        javax.swing.JOptionPane.showMessageDialog(this, mensagemSucesso, "Sucesso", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        
        // 7. LIMPEZA
        limparCampos();

    } catch (NumberFormatException e) {
        avisoErro("Erro nos valores numéricos!\nVerifique se Preço e Estoque contêm apenas números.");
    } catch (Exception e) {
        avisoErro("Erro inesperado: " + e.getMessage());
    }
}


private void avisoErro(String msg) {
    javax.swing.JOptionPane.showMessageDialog(this, msg, "Atenção", javax.swing.JOptionPane.WARNING_MESSAGE);

    
                                
                                                
                                             
   

    }//GEN-LAST:event_BtnCadastrarActionPerformed

    private void t_estoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_estoqueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_estoqueActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
                                           
    
    limparCampos(); 
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void JMenuGerenciamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuGerenciamentoActionPerformed
    // TODO add your handling code here:
    }//GEN-LAST:event_JMenuGerenciamentoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        GerenciamentoProdutos tela = new GerenciamentoProdutos();

        tela.setLocationRelativeTo(null);

        tela.setVisible(true); 
         this.dispose();          // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
    private javax.swing.JMenu JMenuGerenciamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelCategoria;
    private javax.swing.JLabel jLabelEstoque;
    private javax.swing.JLabel jLabelFornecedor;
    private javax.swing.JLabel jLabelPrecoCusto;
    private javax.swing.JLabel jLabelPrecoVenda;
    private javax.swing.JLabel jLabelProduto;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JTextField t_categoria;
    private javax.swing.JTextField t_estoque;
    private javax.swing.JTextField t_fornecedor;
    private javax.swing.JTextField t_precocusto;
    private javax.swing.JTextField t_precovenda;
    private javax.swing.JTextField t_produto;
    // End of variables declaration//GEN-END:variables
}
