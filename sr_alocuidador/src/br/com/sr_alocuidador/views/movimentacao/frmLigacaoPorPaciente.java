/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sr_alocuidador.views.movimentacao;

import br.com.sr_alocuidador.daos.LigacaoProgramadaDAO;
import br.com.sr_alocuidador.helpers.Uteis;
import br.com.sr_alocuidador.models.LigacaoProgramada;
import br.com.sr_alocuidador.models.Paciente;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author plima
 */
public class frmLigacaoPorPaciente extends javax.swing.JDialog {

    public Paciente xpaciente;
    
    /**
     * Creates new form frmLigacaoPorPaciente
     */
    public frmLigacaoPorPaciente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultado = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tblResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Data", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblResultado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblResultadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblResultado);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 721, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(757, 511));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            listarLigacoes();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar as ligações: " + ex.toString());
        }
    }//GEN-LAST:event_formWindowOpened

    private void tblResultadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultadoMouseClicked
        if (evt.getClickCount() > 1){
            if (Uteis.linhaSelecionada(tblResultado)){
                frmDadosLigacao form = new frmDadosLigacao(null, rootPaneCheckingEnabled);
                form.xcodligacao =  tblResultado.getValueAt(tblResultado.getSelectedRow(), 0).toString();
                form.setVisible(true);
            }
            
            
        }
    }//GEN-LAST:event_tblResultadoMouseClicked

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
            java.util.logging.Logger.getLogger(frmLigacaoPorPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLigacaoPorPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLigacaoPorPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLigacaoPorPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmLigacaoPorPaciente dialog = new frmLigacaoPorPaciente(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblResultado;
    // End of variables declaration//GEN-END:variables

    private void listarLigacoes() throws SQLException {
        int qtdeLigacaoRealizada = 0;
        int qtdeLigacaoNaoRealizada = 0;
        LigacaoProgramadaDAO dao = new LigacaoProgramadaDAO();
        DefaultTableModel modelo = (DefaultTableModel)tblResultado.getModel(); 
        modelo.setNumRows(0);
        for(LigacaoProgramada c : dao.listarLigacoesPorPaciente(xpaciente.getCodigo())){
            if ("REALIZADO".equals(c.getStatus())){
                qtdeLigacaoRealizada++;
            } else if ("NÃO REALIZADO".equals(c.getStatus())){
                qtdeLigacaoNaoRealizada++;
            }           
            
            modelo.addRow(new Object[]{
                c.getIdligacao(),
                Uteis.formatarDataHora(c.getHorainicio()),
                c.getStatus()
            });
        }
        
        this.setTitle("Ligações por Paciente. Realizadas (" + Integer.toString(qtdeLigacaoRealizada) + ") - Não Realizadas (" + Integer.toString(qtdeLigacaoNaoRealizada) + ") " + this.getTitle());
    }
}