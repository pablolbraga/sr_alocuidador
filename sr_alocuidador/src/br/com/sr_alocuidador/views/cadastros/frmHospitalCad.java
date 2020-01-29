/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sr_alocuidador.views.cadastros;

import br.com.sr_alocuidador.daos.HospitalDAO;
import br.com.sr_alocuidador.models.Hospital;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author plima
 */
public class frmHospitalCad extends javax.swing.JDialog {

    public int xcodigo;

    /**
     * Creates new form frmHospitalCad
     */
    public frmHospitalCad(java.awt.Frame parent, boolean modal) {
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

        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblEndereco = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        lblBairro = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        lblCidade = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        lblUf = new javax.swing.JLabel();
        txtUf = new javax.swing.JTextField();
        lblCep = new javax.swing.JLabel();
        txtCep = new javax.swing.JTextField();
        lblContato = new javax.swing.JLabel();
        txtContatos = new javax.swing.JTextField();
        btnGravar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Convênio");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNome.setText("Nome:");
        getContentPane().add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 520, -1));

        lblEndereco.setText("Endereço:");
        getContentPane().add(lblEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));
        getContentPane().add(txtEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 520, -1));

        lblBairro.setText("Bairro:");
        getContentPane().add(lblBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, -1, -1));
        getContentPane().add(txtBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, 350, -1));

        lblCidade.setText("Cidade:");
        getContentPane().add(lblCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));
        getContentPane().add(txtCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 350, -1));

        lblUf.setText("UF:");
        getContentPane().add(lblUf, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, -1, -1));
        getContentPane().add(txtUf, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 90, -1));

        lblCep.setText("CEP:");
        getContentPane().add(lblCep, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, -1, -1));
        getContentPane().add(txtCep, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 150, -1));

        lblContato.setText("Contatos:");
        getContentPane().add(lblContato, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));
        getContentPane().add(txtContatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 880, -1));

        btnGravar.setText("Gravar");
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGravar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        setSize(new java.awt.Dimension(987, 338));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        pesquisar();
        txtNome.grabFocus();
    }//GEN-LAST:event_formWindowOpened

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        if (validaDados()) {
            gravar();
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmHospitalCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmHospitalCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmHospitalCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmHospitalCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmHospitalCad dialog = new frmHospitalCad(new javax.swing.JFrame(), true);
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

    private void pesquisar() {
        try {
            Hospital hospital = HospitalDAO.buscarPorId(xcodigo);
            if (hospital != null) {
                txtNome.setText(hospital.getNome());
                txtEndereco.setText(hospital.getEndereco());
                txtBairro.setText(hospital.getBairro());
                txtCidade.setText(hospital.getCidade());
                txtUf.setText(hospital.getUf());
                txtCep.setText(hospital.getCep());
                txtContatos.setText(hospital.getContato());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de sql: " + ex.toString());
        }
    }

    private boolean validaDados() {
        if ("".equals(txtNome.getText())) {
            JOptionPane.showMessageDialog(null, "Razão não informado");
            txtNome.grabFocus();
            return false;
        }
        if ("".equals(txtEndereco.getText())) {
            JOptionPane.showMessageDialog(null, "Endereço não informado");
            txtEndereco.grabFocus();
            return false;
        } else if ("".equals(txtBairro.getText())) {
            JOptionPane.showMessageDialog(null, "Bairro não informado");
            txtBairro.grabFocus();
            return false;
        } else if ("".equals(txtCidade.getText())) {
            JOptionPane.showMessageDialog(null, "Cidade não informada");
            txtCidade.grabFocus();
            return false;
        } else if ("".equals(txtUf.getText())) {
            JOptionPane.showMessageDialog(null, "UF não informado");
            txtUf.grabFocus();
            return false;
        } else if ("".equals(txtCep.getText())) {
            JOptionPane.showMessageDialog(null, "CEP não informado");
            txtCep.grabFocus();
            return false;
        } else if ("".equals(txtContatos.getText())) {
            JOptionPane.showMessageDialog(null, "Contato não informado");
            txtContatos.grabFocus();
            return false;
        } else {
            return true;
        }
    }

    private void gravar() {
        Hospital hospital = new Hospital();
        hospital.setCodigo(xcodigo);
        hospital.setNome(txtNome.getText());
        hospital.setEndereco(txtEndereco.getText());
        hospital.setBairro(txtBairro.getText());
        hospital.setCidade(txtCidade.getText());
        hospital.setUf(txtUf.getText());
        hospital.setCep(txtCep.getText());
        hospital.setContato(txtContatos.getText());
        try {
            HospitalDAO.validaDados(hospital);
            JOptionPane.showMessageDialog(null, "Registro gravado com sucesso.");
            this.setVisible(false);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de sql: " + ex.toString());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGravar;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCep;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblContato;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblUf;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCep;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtContatos;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtUf;
    // End of variables declaration//GEN-END:variables
}