/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views.Cliente;

import dao.ClienteDao;
import dao.ContratoDao;
import dao.ImovelDao;
import entidades.acoes.Contrato;
import entidades.acoes.Imovel;
import entidades.enumerados.EstadoContrato;
import entidades.enumerados.EstadoPagamentoContrato;
import entidades.users.Cliente;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Jason Matias
 */
public class TelaClienteImovel extends javax.swing.JFrame {

    /**
     * Creates new form TelaLoginCliente
     */
    Imovel imovel = new Imovel();
    ImovelDao imoveldao = new ImovelDao();
    ClienteDao clientedao = new ClienteDao();
    
    public TelaClienteImovel() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jColorChooser1 = new javax.swing.JColorChooser();
        jColorChooser2 = new javax.swing.JColorChooser();
        jColorChooser3 = new javax.swing.JColorChooser();
        jColorChooser4 = new javax.swing.JColorChooser();
        jColorChooser5 = new javax.swing.JColorChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtPesquisa = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        btnComprar = new javax.swing.JButton();
        btnAlugar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnVisualizar = new javax.swing.JButton();
        btnMeusImoveis = new javax.swing.JButton();
        btnIndisponiveis = new javax.swing.JButton();
        btnDisponiveis1 = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("IMÓVEIS DISPONÍVEIS");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(220, 20, 130, 30);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "ENDEREÇO", "Nº QUARTOS", "TIPO"
            }
        ));
        jTable1.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(150, 120, 510, 240);

        txtPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisaActionPerformed(evt);
            }
        });
        getContentPane().add(txtPesquisa);
        txtPesquisa.setBounds(390, 90, 170, 22);

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(btnPesquisar);
        btnPesquisar.setBounds(570, 90, 90, 22);

        btnComprar.setText("Comprar");
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });
        getContentPane().add(btnComprar);
        btnComprar.setBounds(10, 90, 80, 22);

        btnAlugar.setText("Alugar");
        btnAlugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAlugar);
        btnAlugar.setBounds(100, 90, 75, 22);

        jButton3.setText("VOLTAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(10, 370, 73, 22);

        btnVisualizar.setText("Visualizar");
        getContentPane().add(btnVisualizar);
        btnVisualizar.setBounds(190, 90, 90, 22);

        btnMeusImoveis.setText("Meus Imóveis");
        getContentPane().add(btnMeusImoveis);
        btnMeusImoveis.setBounds(10, 230, 110, 22);

        btnIndisponiveis.setText("Indisponíveis");
        btnIndisponiveis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIndisponiveisActionPerformed(evt);
            }
        });
        getContentPane().add(btnIndisponiveis);
        btnIndisponiveis.setBounds(10, 190, 100, 22);

        btnDisponiveis1.setText("Disponíveis");
        btnDisponiveis1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisponiveis1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnDisponiveis1);
        btnDisponiveis1.setBounds(10, 150, 100, 22);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        // TODO add your handling code here:
        if (!txtPesquisa.getText().isEmpty()) {
            Imovel imovel = imoveldao.buscarImovel(txtPesquisa.getText());
            if (imovel != null) {
                JOptionPane.showMessageDialog(null, imovel, "ENCONTRADO!", 1);
                if(imovel.getIdCorrector() != null){
                    TelaClienteLogin tcl = new TelaClienteLogin();
                    imoveldao.alugarImovel(txtPesquisa.getText(), tcl.getClienteLogin().getIdUser());
                    Contrato contrato = new Contrato();
                    ContratoDao contratodao = new ContratoDao();
                    contrato.setIdContrato(""+contratodao.contarContrato());
                    contrato.setCliente(tcl.getClienteLogin().getIdUser());
                    contrato.setData(Date.from(Instant.MIN));
                    contrato.setEstado(EstadoContrato.ATIVO);
                    contrato.setPagamento(EstadoPagamentoContrato.PENDENTE);
                    contrato.setInformacao(imovel.getIdCorrector());
                    contratodao.inserir(contrato);
                }
                else
                    JOptionPane.showMessageDialog(null, imovel.toString()+"\nCorrector: "+imovel.getIdCorrector(), "ESTE IMÓVEL AINDA NÃO TEM CORRECTOR", JOptionPane.ERROR_MESSAGE);
                
            } else {
                JOptionPane.showMessageDialog(null, "Id não encontrado", "NÃO EXISTE", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Escreva alguma coisa!", "Campo Vazio", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnComprarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnIndisponiveisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIndisponiveisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIndisponiveisActionPerformed

    private void btnDisponiveis1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisponiveis1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDisponiveis1ActionPerformed

    private void btnAlugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAlugarActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaClienteImovel.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaClienteImovel.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaClienteImovel.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaClienteImovel.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaClienteImovel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlugar;
    private javax.swing.JButton btnComprar;
    private javax.swing.JButton btnDisponiveis1;
    private javax.swing.JButton btnIndisponiveis;
    private javax.swing.JButton btnMeusImoveis;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnVisualizar;
    private javax.swing.JButton jButton3;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JColorChooser jColorChooser2;
    private javax.swing.JColorChooser jColorChooser3;
    private javax.swing.JColorChooser jColorChooser4;
    private javax.swing.JColorChooser jColorChooser5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
