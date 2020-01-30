/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sr_alocuidador.views.movimentacao;

import br.com.sr_alocuidador.daos.ConstantesItemDAO;
import br.com.sr_alocuidador.daos.PacienteDAO;
import br.com.sr_alocuidador.daos.PacienteResponsavelDAO;
import br.com.sr_alocuidador.helpers.Uteis;
import br.com.sr_alocuidador.models.PacienteResponsavel;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author plima
 */
public class frmPacienteResponsavelCad extends javax.swing.JDialog {

    private PacienteResponsavelDAO daoPacienteResponsavel;
    private PacienteDAO daoPaciente;
    private ConstantesItemDAO daoConstanteItem;
    public int xcodpaciente;
    public int xcodigo;
    
    /**
     * Creates new form frmPacienteResponsavelCad
     */
    public frmPacienteResponsavelCad(java.awt.Frame parent, boolean modal) {
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

        pnlDados = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblNascimento = new javax.swing.JLabel();
        txtNascimento = new javax.swing.JTextField();
        lblSexo = new javax.swing.JLabel();
        cmbSexo = new javax.swing.JComboBox<>();
        lblEstadoCivil = new javax.swing.JLabel();
        cmbEstadoCivil = new javax.swing.JComboBox<>();
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
        lblFone = new javax.swing.JLabel();
        txtFoneFixo = new javax.swing.JTextField();
        lblFoneCelular = new javax.swing.JLabel();
        txtFoneCelular = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        pnlBotao = new javax.swing.JPanel();
        btnGravar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Responsável");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pnlDados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNome.setText("Nome:");
        pnlDados.add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));
        pnlDados.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 370, -1));

        lblNascimento.setText("Data de Nascimento:");
        pnlDados.add(lblNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, -1, -1));
        pnlDados.add(txtNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 130, -1));

        lblSexo.setText("Sexo:");
        pnlDados.add(lblSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, -1, -1));

        cmbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NÃO INFORMADO", "MASCULINO", "FEMININO" }));
        pnlDados.add(cmbSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 210, -1));

        lblEstadoCivil.setText("Estado Civil:");
        pnlDados.add(lblEstadoCivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, -1, -1));

        cmbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NÃO INFORMADO", "SOLTEIRO(A)", "CASADO(A)", "VIÚVO(A)", "SEPARADO(A)", "OUTROS" }));
        pnlDados.add(cmbEstadoCivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 40, 210, -1));

        lblEndereco.setText("Endereço:");
        pnlDados.add(lblEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));
        pnlDados.add(txtEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 410, -1));

        lblBairro.setText("Bairro:");
        pnlDados.add(lblBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, -1, -1));
        pnlDados.add(txtBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 270, -1));

        lblCidade.setText("Cidade:");
        pnlDados.add(lblCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 70, -1, -1));
        pnlDados.add(txtCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 90, 210, -1));

        lblUf.setText("UF:");
        pnlDados.add(lblUf, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 70, -1, -1));
        pnlDados.add(txtUf, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 90, 60, -1));

        lblCep.setText("CEP:");
        pnlDados.add(lblCep, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 70, -1, -1));
        pnlDados.add(txtCep, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 90, 100, -1));

        lblFone.setText("Telefone Fixo:");
        pnlDados.add(lblFone, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));
        pnlDados.add(txtFoneFixo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 300, -1));

        lblFoneCelular.setText("Telefone Celular:");
        pnlDados.add(lblFoneCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, -1, -1));
        pnlDados.add(txtFoneCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 300, -1));

        lblEmail.setText("Email:");
        pnlDados.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 120, -1, -1));
        pnlDados.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 140, 300, -1));

        btnGravar.setText("Gravar");
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBotaoLayout = new javax.swing.GroupLayout(pnlBotao);
        pnlBotao.setLayout(pnlBotaoLayout);
        pnlBotaoLayout.setHorizontalGroup(
            pnlBotaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGravar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlBotaoLayout.setVerticalGroup(
            pnlBotaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGravar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlDados, javax.swing.GroupLayout.DEFAULT_SIZE, 1210, Short.MAX_VALUE)
                    .addComponent(pnlBotao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlDados, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(pnlBotao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1252, 321));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            daoPacienteResponsavel = new PacienteResponsavelDAO();
            daoPaciente = new PacienteDAO();
            daoConstanteItem = new ConstantesItemDAO();
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
                JOptionPane.showMessageDialog(null, "Erro ao gravar o registro: " + ex.toString());
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
            java.util.logging.Logger.getLogger(frmPacienteResponsavelCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPacienteResponsavelCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPacienteResponsavelCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPacienteResponsavelCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmPacienteResponsavelCad dialog = new frmPacienteResponsavelCad(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> cmbEstadoCivil;
    private javax.swing.JComboBox<String> cmbSexo;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCep;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblEstadoCivil;
    private javax.swing.JLabel lblFone;
    private javax.swing.JLabel lblFoneCelular;
    private javax.swing.JLabel lblNascimento;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblUf;
    private javax.swing.JPanel pnlBotao;
    private javax.swing.JPanel pnlDados;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCep;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtFoneCelular;
    private javax.swing.JTextField txtFoneFixo;
    private javax.swing.JTextField txtNascimento;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtUf;
    // End of variables declaration//GEN-END:variables

    private void pesquisar() throws SQLException {
        
        PacienteResponsavel c = daoPacienteResponsavel.buscarPorId(xcodigo);
        if (c != null){
            txtNome.setText(c.getNome());
            txtNascimento.setText(Uteis.formatarData(c.getNascimento()));
            cmbSexo.setSelectedIndex(c.getSexo().getIndice());
            cmbEstadoCivil.setSelectedIndex(c.getEstcivil().getIndice());
            txtEndereco.setText(c.getEndereco());
            txtBairro.setText(c.getBairro());
            txtCidade.setText(c.getCidade());
            txtUf.setText(c.getUf());
            txtCep.setText(c.getCep());
            txtFoneFixo.setText(c.getTelefonefixo());
            txtFoneCelular.setText(c.getTelefonecelular());
            txtEmail.setText(c.getEmail());
        }
        
    }
    
    private boolean validaDados(){
        
        if ("".equals(txtNome.getText())){
            JOptionPane.showMessageDialog(null, "Nome não informado");
            txtNome.setFocusable(true);
            return false;
        }
        else if ("".equals(txtNascimento.getText())){
            JOptionPane.showMessageDialog(null, "Data de nascimento não informado");
            txtNascimento.setFocusable(true);
            return false;
        }
        else if (cmbSexo.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null, "Sexo não informado");
            cmbSexo.setFocusable(true);
            return false;
        }
        else if (cmbEstadoCivil.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null, "Estado civil não informado");
            cmbEstadoCivil.setFocusable(true);
            return false;
        }
        else if ("".equals(txtEndereco.getText())){
            JOptionPane.showMessageDialog(null, "Endereço não informado");
            txtEndereco.setFocusable(true);
            return false;
        }
        else if ("".equals(txtBairro.getText())){
            JOptionPane.showMessageDialog(null, "Bairro não informado");
            txtBairro.setFocusable(true);
            return false;
        }
        else if ("".equals(txtCidade.getText())){
            JOptionPane.showMessageDialog(null, "Cidade não informado");
            txtCidade.setFocusable(true);
            return false;
        }
        else if ("".equals(txtUf.getText())){
            JOptionPane.showMessageDialog(null, "UF não informado");
            txtUf.setFocusable(true);
            return false;
        }
        else if ("".equals(txtCep.getText())){
            JOptionPane.showMessageDialog(null, "CEP não informado");
            txtCep.setFocusable(true);
            return false;
        }
        else if ("".equals(txtFoneFixo.getText())){
            JOptionPane.showMessageDialog(null, "Telefone fixo não informado");
            txtFoneFixo.setFocusable(true);
            return false;
        }
        else return true;
        
    }
    
    private void gravar() throws SQLException{
        
        PacienteResponsavel c = new PacienteResponsavel();
        c.setCodigo(xcodigo);
        c.setPaciente(daoPaciente.buscarPorId(xcodpaciente));
        c.setNome(txtNome.getText());
        c.setNascimento(Uteis.desformatarData(txtNascimento.getText()));
        c.setSexo(daoConstanteItem.buscarPorId(1, cmbSexo.getSelectedIndex()));
        c.setEstcivil(daoConstanteItem.buscarPorId(2, cmbEstadoCivil.getSelectedIndex()));
        c.setEndereco(txtEndereco.getText());
        c.setBairro(txtBairro.getText());
        c.setCidade(txtCidade.getText());
        c.setUf(txtUf.getText());
        c.setCep(txtCep.getText());
        c.setTelefonefixo(txtFoneFixo.getText());
        c.setTelefonecelular(txtFoneCelular.getText());
        c.setEmail(txtEmail.getText());
        daoPacienteResponsavel.validaDados(c);        
        
    }
}
