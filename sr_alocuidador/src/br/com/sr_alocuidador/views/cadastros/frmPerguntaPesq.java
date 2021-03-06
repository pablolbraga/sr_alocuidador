/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sr_alocuidador.views.cadastros;

import br.com.sr_alocuidador.daos.CategoriaPerguntaDAO;
import br.com.sr_alocuidador.daos.PerguntaDAO;
import br.com.sr_alocuidador.models.CategoriaPergunta;
import br.com.sr_alocuidador.models.Pergunta;
import br.com.sr_alocuidador.helpers.Uteis;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author plima
 */
public class frmPerguntaPesq extends javax.swing.JDialog {

    private PerguntaDAO daoPergunta;
    private CategoriaPerguntaDAO daoCategoriaPergunta;
    private List<CategoriaPergunta> listaCategoriaPergunta;
    
    public frmPerguntaPesq(java.awt.Frame parent, boolean modal) {
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

        btnAdicionar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultado = new javax.swing.JTable();
        pnlFiltro = new javax.swing.JPanel();
        lblCategoria = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        txtPesquisa = new javax.swing.JTextField();
        lblPesquisa = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();
        btnOpcao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pergunta");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btnAdicionar.setText("Novo");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        tblResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Categoria", "Destino"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
        if (tblResultado.getColumnModel().getColumnCount() > 0) {
            tblResultado.getColumnModel().getColumn(0).setMinWidth(0);
            tblResultado.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblResultado.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        pnlFiltro.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));

        lblCategoria.setText("Categoria:");

        lblPesquisa.setText("Descrição:");

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFiltroLayout = new javax.swing.GroupLayout(pnlFiltro);
        pnlFiltro.setLayout(pnlFiltroLayout);
        pnlFiltroLayout.setHorizontalGroup(
            pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCategoria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPesquisa)
                    .addGroup(pnlFiltroLayout.createSequentialGroup()
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisar)))
                .addContainerGap(235, Short.MAX_VALUE))
        );
        pnlFiltroLayout.setVerticalGroup(
            pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategoria)
                    .addComponent(lblPesquisa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar)))
        );

        btnOpcao.setText("Opções");
        btnOpcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpcaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOpcao)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pnlFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionar)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir)
                    .addComponent(btnOpcao))
                .addGap(18, 18, 18)
                .addComponent(pnlFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1216, 587));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        daoPergunta = new PerguntaDAO();
        daoCategoriaPergunta = new CategoriaPerguntaDAO();
        try {
            preencheCategoria();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro encontrado: " + ex.toString());
        }
    }//GEN-LAST:event_formWindowOpened

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        try {
            pesquisar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar a pesquisa: " + ex.toString());
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        try {
            incluir();
            btnPesquisarActionPerformed(evt);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro encontrado: " + ex.toString());
        }
        
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        if (Uteis.linhaSelecionada(tblResultado)){
            try {
                alterar();
                btnPesquisarActionPerformed(evt);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro encontrado: " + ex.toString());
            }            
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja excluir o registro?", "Exclusão", JOptionPane.YES_NO_OPTION);
        if (resposta == 0){
            try {
                excluir();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro encontrado: " + ex.toString());
            }
        }
        
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tblResultadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultadoMouseClicked
        if (evt.getClickCount() > 1){
            try {
                alterar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro encontrado: " + ex.toString());
            }
        }
    }//GEN-LAST:event_tblResultadoMouseClicked

    private void btnOpcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpcaoActionPerformed
        try {
            opcao();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro encontrado: " + ex.toString());
        }
    }//GEN-LAST:event_btnOpcaoActionPerformed

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
            java.util.logging.Logger.getLogger(frmPerguntaPesq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPerguntaPesq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPerguntaPesq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPerguntaPesq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmPerguntaPesq dialog = new frmPerguntaPesq(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnOpcao;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JComboBox<Object> cmbCategoria;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblPesquisa;
    private javax.swing.JPanel pnlFiltro;
    private javax.swing.JTable tblResultado;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables

    private void preencheCategoria() throws SQLException{
        
        listaCategoriaPergunta = daoCategoriaPergunta.listarTodos();
        cmbCategoria.removeAllItems();
        for(CategoriaPergunta cp : listaCategoriaPergunta){
            cmbCategoria.addItem(cp);
        }
        cmbCategoria.setSelectedIndex(-1);
        
    }
    
    private void pesquisar() throws SQLException {
        
        DefaultTableModel modelo = (DefaultTableModel)tblResultado.getModel();
        modelo.setNumRows(0);
        int categoria = 0;
        if (cmbCategoria.getSelectedIndex() >= 0 )
            categoria = ((CategoriaPergunta)cmbCategoria.getSelectedItem()).getCodigo();
        for(Pergunta p : daoPergunta.ListarTodos(categoria, txtPesquisa.getText())){
            modelo.addRow(new Object[]{ p.getCodigo(), p.getNome(), p.getCategoria().getNome(), "P".equals(p.getDestino()) ? "PACIENTE" : "CUIDADOR" });
        }
        
    }
    
    private void incluir() throws SQLException{
        
        frmPerguntaCad f = new frmPerguntaCad(null, rootPaneCheckingEnabled);
        f.xcodigo = 0;
        f.setVisible(true);
        pesquisar();
        
    }
    
    private void alterar() throws SQLException{
        
        if (Uteis.linhaSelecionada(tblResultado)){        
            frmPerguntaCad f = new frmPerguntaCad(null, rootPaneCheckingEnabled);
            f.xcodigo = Integer.parseInt(tblResultado.getValueAt(tblResultado.getSelectedRow(), 0).toString());
            f.setVisible(true);
            pesquisar();
        }
        
    }
    
    private void excluir() throws SQLException{
        
        if (Uteis.linhaSelecionada(tblResultado)){
            daoPergunta.excluir(Integer.parseInt(tblResultado.getValueAt(tblResultado.getSelectedRow(), 0).toString()));
            pesquisar();
        }
        
    }
    
    private void opcao() throws SQLException{
        
        if(Uteis.linhaSelecionada(tblResultado)){
            frmPerguntaItemPesq f = new frmPerguntaItemPesq(null, rootPaneCheckingEnabled);
            f.xpergunta = daoPergunta.BuscarPorId( Integer.parseInt(tblResultado.getValueAt(tblResultado.getSelectedRow(), 0).toString()) );
            f.setTitle("Itens da pergunta " + tblResultado.getValueAt(tblResultado.getSelectedRow(), 1).toString());
            f.setVisible(true);
        }
        
    }
}
