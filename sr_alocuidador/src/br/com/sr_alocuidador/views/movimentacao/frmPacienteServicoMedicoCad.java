/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sr_alocuidador.views.movimentacao;

import br.com.sr_alocuidador.daos.PacienteDAO;
import br.com.sr_alocuidador.daos.PacienteServicoMedicoDAO;
import br.com.sr_alocuidador.daos.ServicoMedicoDAO;
import br.com.sr_alocuidador.helpers.Uteis;
import br.com.sr_alocuidador.models.PacienteServicoMedico;
import br.com.sr_alocuidador.models.ServicoMedico;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author plima
 */
public class frmPacienteServicoMedicoCad extends javax.swing.JDialog {

    private List<ServicoMedico> listaServicoMedico = new ArrayList<>();
    private PacienteDAO daoPaciente;
    private PacienteServicoMedicoDAO daoPacienteServicoMedico;
    
    public int xcodigo;
    public int xcodpaciente;    
    
    public frmPacienteServicoMedicoCad(java.awt.Frame parent, boolean modal) {
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

        lblServicoMedico = new javax.swing.JLabel();
        cmbServicoMedico = new javax.swing.JComboBox<>();
        lblDataIni = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        lblProfissional = new javax.swing.JLabel();
        txtProfissional = new javax.swing.JTextField();
        lblObservacao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservacao = new javax.swing.JTextArea();
        btnGravar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Serviços Médicos do Paciente");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblServicoMedico.setText("Serviço Médico:");
        getContentPane().add(lblServicoMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        getContentPane().add(cmbServicoMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 350, -1));

        lblDataIni.setText("Data:");
        getContentPane().add(lblDataIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));
        getContentPane().add(txtData, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 120, -1));

        lblProfissional.setText("Profissional:");
        getContentPane().add(lblProfissional, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));
        getContentPane().add(txtProfissional, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 360, -1));

        lblObservacao.setText("Observação:");
        getContentPane().add(lblObservacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        txtObservacao.setColumns(20);
        txtObservacao.setRows(5);
        jScrollPane1.setViewportView(txtObservacao);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 360, -1));

        btnGravar.setText("Gravar");
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGravar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        setSize(new java.awt.Dimension(399, 393));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            daoPaciente = new PacienteDAO();
            daoPacienteServicoMedico = new PacienteServicoMedicoDAO();
            preencheServicoMedico();
            pesquisar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro encontrado: " + ex.toString());
        }
        
    }//GEN-LAST:event_formWindowOpened

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        if (validaDados()){
            try {
                gravar();
                JOptionPane.showMessageDialog(null, "Registro gravado com sucesso.");
                this.setVisible(false);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao gravar o registro: "  + ex.toString());
            }
        }
    }//GEN-LAST:event_btnGravarActionPerformed

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
            java.util.logging.Logger.getLogger(frmPacienteServicoMedicoCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPacienteServicoMedicoCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPacienteServicoMedicoCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPacienteServicoMedicoCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmPacienteServicoMedicoCad dialog = new frmPacienteServicoMedicoCad(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnGravar;
    private javax.swing.JComboBox<Object> cmbServicoMedico;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDataIni;
    private javax.swing.JLabel lblObservacao;
    private javax.swing.JLabel lblProfissional;
    private javax.swing.JLabel lblServicoMedico;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextArea txtObservacao;
    private javax.swing.JTextField txtProfissional;
    // End of variables declaration//GEN-END:variables

    private boolean validaDados(){
        
        if (cmbServicoMedico.getSelectedIndex() < 0){
            JOptionPane.showMessageDialog(null, "Hospital não informado.");
            return false;
        } else if ("".equals(txtData.getText())){
            JOptionPane.showMessageDialog(null, "Data não informada.");
            return false;
        } else if ("".equals(txtProfissional.getText())){
            JOptionPane.showMessageDialog(null, "Local não informado.");
            return false;
        } else if ("".equals(txtObservacao.getText())){
            JOptionPane.showMessageDialog(null, "Observação não informada.");
            return false;
        } else return true;        
        
    }
    
    private void gravar() throws SQLException{
        PacienteServicoMedico c = new PacienteServicoMedico();
        c.setCodigo(xcodigo);
        c.setPaciente(daoPaciente.buscarPorId(xcodpaciente));
        c.setServico(((ServicoMedico)cmbServicoMedico.getSelectedItem()));        
        c.setData(Uteis.desformatarData(txtData.getText()));
        c.setProfissional(txtProfissional.getText());
        c.setObservacao(txtObservacao.getText());
        daoPacienteServicoMedico.validaDados(c);        
    }
    
    private void pesquisar() throws SQLException {
        PacienteServicoMedico c = daoPacienteServicoMedico.buscarPorId(xcodigo);
        if (c != null){
            for(int i = 0; i < listaServicoMedico.size(); i++){
                if (listaServicoMedico.get(i).getCodigo() == c.getServico().getCodigo()){
                    cmbServicoMedico.setSelectedIndex(i);
                }
            }
            
            txtData.setText(Uteis.formatarData(c.getData()));
            txtProfissional.setText(c.getProfissional());            
            txtObservacao.setText(c.getObservacao());            
        }
    }

    private void preencheServicoMedico() throws SQLException {
        cmbServicoMedico.removeAllItems();
        listaServicoMedico = ServicoMedicoDAO.listarServicoMedico("");
        for(ServicoMedico c : listaServicoMedico){
            cmbServicoMedico.addItem(c);
        }
        cmbServicoMedico.setSelectedIndex(-1);
    }
}
