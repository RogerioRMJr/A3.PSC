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
        this.setLocationRelativeTo(null);
    }

    private void limparCampos() {
    t_id.setText("");
    t_produto.setText("");
    t_estoque.setText("");
    t_precovenda.setText("");
    t_precocusto.setText("");
    t_fornecedor.setText("");
    
    
    t_id.requestFocus(); 
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelID = new javax.swing.JLabel();
        t_id = new javax.swing.JTextField();
        jLabelProduto = new javax.swing.JLabel();
        t_produto = new javax.swing.JTextField();
        jLabelEstoque = new javax.swing.JLabel();
        t_estoque = new javax.swing.JTextField();
        jLabelPrecoVenda = new javax.swing.JLabel();
        jLabelPrecoCusto = new javax.swing.JLabel();
        t_precovenda = new javax.swing.JTextField();
        jLabelFornecedor = new javax.swing.JLabel();
        t_fornecedor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        BtnCancelar = new javax.swing.JButton();
        BtnCadastrar = new javax.swing.JButton();
        t_precocusto = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        JMenuGerenciamento = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelID.setText("ID:");

        jLabelProduto.setText("Produto:");

        jLabelEstoque.setText("Estoque:");

        t_estoque.addActionListener(this::t_estoqueActionPerformed);

        jLabelPrecoVenda.setText("Preço de Venda:");

        jLabelPrecoCusto.setText("Preço de Custo:");

        t_precovenda.addActionListener(this::t_precovendaActionPerformed);

        jLabelFornecedor.setText("Fornecedor:");

        jLabel1.setText("CADASTRO DE PRODUTOS");

        BtnCancelar.setText("Cancelar");
        BtnCancelar.addActionListener(this::BtnCancelarActionPerformed);

        BtnCadastrar.setText("Cadastrar");
        BtnCadastrar.addActionListener(this::BtnCadastrarActionPerformed);

        JMenuGerenciamento.setText("Menu");
        JMenuGerenciamento.addActionListener(this::JMenuGerenciamentoActionPerformed);

        jMenuItem1.setText("Gerenciamento ");
        jMenuItem1.addActionListener(this::jMenuItem1ActionPerformed);
        JMenuGerenciamento.add(jMenuItem1);

        jMenuBar1.add(JMenuGerenciamento);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelID, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(t_id, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelProduto))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(BtnCadastrar)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelPrecoVenda)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(t_precovenda, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(t_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelEstoque)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(t_estoque, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabelPrecoCusto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(t_precocusto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelFornecedor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(t_fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BtnCancelar)
                        .addGap(159, 159, 159))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(278, 278, 278))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelID)
                    .addComponent(t_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelProduto)
                    .addComponent(t_produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEstoque)
                    .addComponent(t_estoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPrecoVenda)
                    .addComponent(jLabelPrecoCusto)
                    .addComponent(t_precovenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFornecedor)
                    .addComponent(t_fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t_precocusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 127, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnCancelar)
                    .addComponent(BtnCadastrar))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCadastrarActionPerformed
try {
        
        String id = t_id.getText().trim();
        String produto = t_produto.getText().trim();
        String estoque = t_estoque.getText().trim();
        String fornecedor = t_fornecedor.getText().trim();
        String pCusto = t_precocusto.getText().trim();
        String pVenda = t_precovenda.getText().trim();

        
        if (id.isEmpty()) {
            avisoErro("Por favor, informe o ID do produto.");
            t_id.requestFocus();
            return;
        }
        if (produto.isEmpty()) {
            avisoErro("O nome do Produto é obrigatório.");
            t_produto.requestFocus();
            return;
        }
        if (estoque.isEmpty()) {
            avisoErro("Informe a quantidade em Estoque.");
            t_estoque.requestFocus();
            return;
        }
        if (fornecedor.isEmpty()) {
            avisoErro("Informe o nome do Fornecedor.");
            t_fornecedor.requestFocus();
            return;
        }
        if (pCusto.isEmpty()) {
            avisoErro("O Preço de Custo é obrigatório.");
            t_precocusto.requestFocus();
            return;
        }
        if (pVenda.isEmpty()) {
            avisoErro("O Preço de Venda é obrigatório.");
            t_precovenda.requestFocus();
            return;
        }

        
        double custo = Double.parseDouble(pCusto.replace(",", "."));
        double venda = Double.parseDouble(pVenda.replace(",", "."));
        double lucro = venda - custo;

        
        Object[] novaLinha = {
            id, produto, estoque, fornecedor, 
            String.format("R$ %.2f", custo), 
            String.format("R$ %.2f", venda), 
            String.format("R$ %.2f", lucro)
        };

        
        GerenciamentoProdutos.adicionarNaMemoria(novaLinha);

        
        String mensagemSucesso = "✅ PRODUTO CADASTRADO COM SUCESSO!\n\n" +
                                 "🆔 ID: " + id + "\n" +
                                 "📦 Produto: " + produto + "\n" +
                                 "🔢 Estoque: " + estoque + "\n" +
                                 "🏭 Fornecedor: " + fornecedor + "\n" +
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

    private void t_precovendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_precovendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_precovendaActionPerformed

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


this.dispose();        // TODO add your handling code here:
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
    private javax.swing.JLabel jLabelEstoque;
    private javax.swing.JLabel jLabelFornecedor;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelPrecoCusto;
    private javax.swing.JLabel jLabelPrecoVenda;
    private javax.swing.JLabel jLabelProduto;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JTextField t_estoque;
    private javax.swing.JTextField t_fornecedor;
    private javax.swing.JTextField t_id;
    private javax.swing.JTextField t_precocusto;
    private javax.swing.JTextField t_precovenda;
    private javax.swing.JTextField t_produto;
    // End of variables declaration//GEN-END:variables
}
