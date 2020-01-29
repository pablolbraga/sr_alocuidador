/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sr_alocuidador.views.movimentacao;

import br.com.sr_alocuidador.daos.ConstantesItemDAO;
import br.com.sr_alocuidador.daos.HospitalDAO;
import br.com.sr_alocuidador.daos.PacienteConsultaDAO;
import br.com.sr_alocuidador.daos.PacienteDAO;
import br.com.sr_alocuidador.helpers.Uteis;
import br.com.sr_alocuidador.models.ConstantesItem;
import br.com.sr_alocuidador.models.Hospital;
import br.com.sr_alocuidador.models.PacienteConsulta;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author plima
 */
public class frmPacienteConsultaCad extends javax.swing.JDialog {

    private List<Hospital> listaHospital = new ArrayList<>();
    private List<ConstantesItem> listaMotivo = new ArrayList<>();
    
    public int xcodigo;
    public int xcodpaciente;    
    
    public frmPacienteConsultaCad(java.awt.Frame parent, boolean modal) {
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

        lblHospital = new javax.swing.JLabel();
        cmbHospital = new javax.swing.JComboBox<>();
        lblData = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        lblMotivo = new javax.swing.JLabel();
        cmbMotivo = new javax.swing.JComboBox<>();
        cbxEmergencia = new javax.swing.JCheckBox();
        lblObservacao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservacao = new javax.swing.JTextArea();
        btnGravar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta do Paciente");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHospital.setText("Hospital:");
        getContentPane().add(lblHospital, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        getContentPane().add(cmbHospital, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 350, -1));

        lblData.setText("Data:");
        getContentPane().add(lblData, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));
        getContentPane().add(txtData, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 120, -1));

        lblMotivo.setText("Motivo:");
        getContentPane().add(lblMotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        getContentPane().add(cmbMotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 350, -1));

        cbxEmergencia.setText("Emergência");
        getContentPane().add(cbxEmergencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        lblObservacao.setText("Observação:");
        getContentPane().add(lblObservacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        txtObservacao.setColumns(20);
        txtObservacao.setRows(5);
        jScrollPane1.setViewportView(txtObservacao);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 360, -1));

        btnGravar.setText("Gravar");
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGravar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        setSize(new java.awt.Dimension(399, 393));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            preencheHospital();
            preencheMotivo();
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
            java.util.logging.Logger.getLogger(frmPacienteConsultaCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPacienteConsultaCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPacienteConsultaCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPacienteConsultaCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmPacienteConsultaCad dialog = new frmPacienteConsultaCad(new javax.swing.JFrame(), true);
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
    private javax.swing.JCheckBox cbxEmergencia;
    private javax.swing.JComboBox<Object> cmbHospital;
    private javax.swing.JComboBox<Object> cmbMotivo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblHospital;
    private javax.swing.JLabel lblMotivo;
    private javax.swing.JLabel lblObservacao;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextArea txtObservacao;
    // End of variables declaration//GEN-END:variables

    private boolean validaDados(){
        
        if (cmbHospital.getSelectedIndex() < 0){
            JOptionPane.showMessageDialog(null, "Hospital não informado.");
            return false;
        } else if ("".equals(txtData.getText())){
            JOptionPane.showMessageDialog(null, "Data não informada.");
            return false;
        } else if (cmbMotivo.getSelectedIndex() < 0){
            JOptionPane.showMessageDialog(null, "Motivo não informado.");
            return false;
        } else if ("".equals(txtObservacao.getText())){
            JOptionPane.showMessageDialog(null, "Observação não informada.");
            return false;
        } else return true;        
        
    }
    
    private void gravar() throws SQLException{
        PacienteConsulta c = new PacienteConsulta();
        c.setCodigo(xcodigo);
        c.setPaciente(PacienteDAO.buscarPorId(xcodpaciente));
        c.setHospital(((Hospital)cmbHospital.getSelectedItem()));
        c.setData(Uteis.desformatarData(txtData.getText()));
        c.setMotivo(((ConstantesItem)cmbMotivo.getSelectedItem()));
        c.setEmergencia(cbxEmergencia.isSelected() ? "S" : "N");
        c.setObservacao(txtObservacao.getText());
        PacienteConsultaDAO.validaDados(c);        
    }
    
    private void pesquisar() throws SQLException {
        PacienteConsulta c = PacienteConsultaDAO.buscarPorId(xcodigo);
        if (c != null){
            for(int i = 0; i < listaHospital.size(); i++){
                if (listaHospital.get(i).getCodigo() == c.getHospital().getCodigo()){
                    cmbHospital.setSelectedIndex(i);
                }
            }
            
            txtData.setText(Uteis.formatarData(c.getData()));            
            
            for(int i = 0; i < listaMotivo.size(); i++){
                if (listaMotivo.get(i).getIndice() == c.getMotivo().getIndice()){
                    cmbMotivo.setSelectedIndex(i);
                }
            }
            
            cbxEmergencia.setSelected("S".equals(c.getEmergencia()));
            txtObservacao.setText(c.getObservacao());            
        }
    }

    private void preencheHospital() throws SQLException {
        cmbHospital.removeAllItems();
        listaHospital = HospitalDAO.listarHospital("");
        for(Hospital c : listaHospital){
            cmbHospital.addItem(c);
        }
        cmbHospital.setSelectedIndex(-1);
    }
    
    private void preencheMotivo() throws SQLException{
        cmbMotivo.removeAllItems();
        listaMotivo = ConstantesItemDAO.listarContantes(23);
        for(ConstantesItem c : listaMotivo){
            cmbMotivo.addItem(c);
        }
        cmbMotivo.setSelectedIndex(-1);
    }
}
