package br.com.sr_alocuidador.views.movimentacao;

import br.com.sr_alocuidador.daos.ConvenioDAO;
import br.com.sr_alocuidador.daos.PacienteDAO;
import br.com.sr_alocuidador.models.Convenio;
import br.com.sr_alocuidador.models.Paciente;
import br.com.sr_alocuidador.helpers.Uteis;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmPacientePesq extends javax.swing.JDialog {

    /**
     * Creates new form frmPacientePesq
     */
    public frmPacientePesq(java.awt.Frame parent, boolean modal) {
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

        menuPopup = new javax.swing.JPopupMenu();
        mnPopupCuidador = new javax.swing.JMenuItem();
        mnPopupResponsavel = new javax.swing.JMenuItem();
        mnPopupCategoriaPergunta = new javax.swing.JMenuItem();
        mnPopupResponsavelAlerta = new javax.swing.JMenuItem();
        mnPopupDoenca = new javax.swing.JMenuItem();
        mnPopupMedicacao = new javax.swing.JMenuItem();
        mnPopupProfissionais = new javax.swing.JMenuItem();
        mnPopupLigacao = new javax.swing.JMenuItem();
        mnPopupInternacoes = new javax.swing.JMenuItem();
        mnPopupConsultas = new javax.swing.JMenuItem();
        mnPopupVacinas = new javax.swing.JMenuItem();
        mnPopupServicoMedico = new javax.swing.JMenuItem();
        mnPopupCirurgias = new javax.swing.JMenuItem();
        mnPopupLigacaoExtra = new javax.swing.JMenuItem();
        pnlBotao = new javax.swing.JPanel();
        btnAdicionar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        pnlFiltro = new javax.swing.JPanel();
        lblPesqConvenio = new javax.swing.JLabel();
        cmbPesqConvenio = new javax.swing.JComboBox<>();
        txtPesqPaciente = new javax.swing.JTextField();
        lblPesqPaciente = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();
        btnLimparFiltro = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultado = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        mnPopupCuidador.setLabel("Cuidador");
        mnPopupCuidador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnPopupCuidadorActionPerformed(evt);
            }
        });
        menuPopup.add(mnPopupCuidador);

        mnPopupResponsavel.setLabel("Responsável");
        mnPopupResponsavel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnPopupResponsavelActionPerformed(evt);
            }
        });
        menuPopup.add(mnPopupResponsavel);

        mnPopupCategoriaPergunta.setText("Categoria de Pergunta");
        mnPopupCategoriaPergunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnPopupCategoriaPerguntaActionPerformed(evt);
            }
        });
        menuPopup.add(mnPopupCategoriaPergunta);

        mnPopupResponsavelAlerta.setText("Responsável pelo Alerta");
        mnPopupResponsavelAlerta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnPopupResponsavelAlertaActionPerformed(evt);
            }
        });
        menuPopup.add(mnPopupResponsavelAlerta);

        mnPopupDoenca.setText("Doenças");
        mnPopupDoenca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnPopupDoencaActionPerformed(evt);
            }
        });
        menuPopup.add(mnPopupDoenca);

        mnPopupMedicacao.setText("Medicamentos");
        mnPopupMedicacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnPopupMedicacaoActionPerformed(evt);
            }
        });
        menuPopup.add(mnPopupMedicacao);

        mnPopupProfissionais.setText("Profissionais");
        mnPopupProfissionais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnPopupProfissionaisActionPerformed(evt);
            }
        });
        menuPopup.add(mnPopupProfissionais);

        mnPopupLigacao.setText("Ligações");
        mnPopupLigacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnPopupLigacaoActionPerformed(evt);
            }
        });
        menuPopup.add(mnPopupLigacao);

        mnPopupInternacoes.setText("Internações");
        mnPopupInternacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnPopupInternacoesActionPerformed(evt);
            }
        });
        menuPopup.add(mnPopupInternacoes);

        mnPopupConsultas.setText("Consultas");
        mnPopupConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnPopupConsultasActionPerformed(evt);
            }
        });
        menuPopup.add(mnPopupConsultas);

        mnPopupVacinas.setText("Vacinas");
        mnPopupVacinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnPopupVacinasActionPerformed(evt);
            }
        });
        menuPopup.add(mnPopupVacinas);

        mnPopupServicoMedico.setText("Serviços Médicos");
        mnPopupServicoMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnPopupServicoMedicoActionPerformed(evt);
            }
        });
        menuPopup.add(mnPopupServicoMedico);

        mnPopupCirurgias.setText("Cirúrgias");
        mnPopupCirurgias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnPopupCirurgiasActionPerformed(evt);
            }
        });
        menuPopup.add(mnPopupCirurgias);

        mnPopupLigacaoExtra.setText("Ligações Extras");
        mnPopupLigacaoExtra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnPopupLigacaoExtraActionPerformed(evt);
            }
        });
        menuPopup.add(mnPopupLigacaoExtra);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pacientes");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btnAdicionar.setText("Incluir");
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

        javax.swing.GroupLayout pnlBotaoLayout = new javax.swing.GroupLayout(pnlBotao);
        pnlBotao.setLayout(pnlBotaoLayout);
        pnlBotaoLayout.setHorizontalGroup(
            pnlBotaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdicionar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlBotaoLayout.setVerticalGroup(
            pnlBotaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBotaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionar)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblPesqConvenio.setText("Convênio:");

        cmbPesqConvenio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblPesqPaciente.setText("Paciente:");

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnLimparFiltro.setText("Limpar Filtro");

        javax.swing.GroupLayout pnlFiltroLayout = new javax.swing.GroupLayout(pnlFiltro);
        pnlFiltro.setLayout(pnlFiltroLayout);
        pnlFiltroLayout.setHorizontalGroup(
            pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbPesqConvenio, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPesqConvenio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFiltroLayout.createSequentialGroup()
                        .addComponent(txtPesqPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimparFiltro))
                    .addComponent(lblPesqPaciente))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlFiltroLayout.setVerticalGroup(
            pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPesqConvenio)
                    .addComponent(lblPesqPaciente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbPesqConvenio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPesqPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar)
                    .addComponent(btnLimparFiltro))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "Convênio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblResultado.setComponentPopupMenu(menuPopup);
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("Clique com o botão direito para abrir uma caixa de opções do paciente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlBotao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBotao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1099, 580));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            preencheConvenios();
        } catch (SQLException ex) {
            Logger.getLogger(frmPacientePesq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        try {
            pesquisar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar a consulta: " + ex.toString());
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        frmPacienteCad f = new frmPacienteCad(null, rootPaneCheckingEnabled);
        f.xcodigo = 0;
        f.setVisible(true);
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        alterar();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        try {
            excluir();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir o registro: " + ex.toString());
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tblResultadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultadoMouseClicked
        if (evt.getClickCount() > 1){
            alterar();
        }
    }//GEN-LAST:event_tblResultadoMouseClicked

    private void mnPopupInternacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnPopupInternacoesActionPerformed
        if (Uteis.linhaSelecionada(tblResultado)){
            
            frmPacienteInternacaoPesq f = new frmPacienteInternacaoPesq(null, rootPaneCheckingEnabled);
            f.xcodpaciente = Integer.parseInt(tblResultado.getValueAt(tblResultado.getSelectedRow(), 0).toString());
            f.setVisible(true);
            
        }
    }//GEN-LAST:event_mnPopupInternacoesActionPerformed

    private void mnPopupLigacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnPopupLigacaoActionPerformed
        if (Uteis.linhaSelecionada(tblResultado)){
            /*
            frmLigacaoPorPaciente f = new frmLigacaoPorPaciente(null, rootPaneCheckingEnabled);
            f.xcodpaciente = Integer.parseInt(tblResultado.getValueAt(tblResultado.getSelectedRow(), 0).toString());
            f.setVisible(true);
            */
        }
    }//GEN-LAST:event_mnPopupLigacaoActionPerformed

    private void mnPopupMedicacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnPopupMedicacaoActionPerformed
        if (Uteis.linhaSelecionada(tblResultado)){
            
            frmPacienteMedicamentoPesq f = new frmPacienteMedicamentoPesq(null, rootPaneCheckingEnabled);
            f.xcodpaciente = Integer.parseInt(tblResultado.getValueAt(tblResultado.getSelectedRow(), 0).toString());
            f.setVisible(true);
            
        }
    }//GEN-LAST:event_mnPopupMedicacaoActionPerformed

    private void mnPopupProfissionaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnPopupProfissionaisActionPerformed
        if (Uteis.linhaSelecionada(tblResultado)){
            
            frmPacienteProfissionalPesq f = new frmPacienteProfissionalPesq(null, rootPaneCheckingEnabled);
            f.xcodpaciente = Integer.parseInt(tblResultado.getValueAt(tblResultado.getSelectedRow(), 0).toString());
            f.setVisible(true);
            
        }
    }//GEN-LAST:event_mnPopupProfissionaisActionPerformed

    private void mnPopupConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnPopupConsultasActionPerformed
        if (Uteis.linhaSelecionada(tblResultado)){
            
            frmPacienteConsultaPesq f = new frmPacienteConsultaPesq(null, rootPaneCheckingEnabled);
            f.xcodpaciente = Integer.parseInt(tblResultado.getValueAt(tblResultado.getSelectedRow(), 0).toString());
            f.setVisible(true);
            
        }
    }//GEN-LAST:event_mnPopupConsultasActionPerformed

    private void mnPopupDoencaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnPopupDoencaActionPerformed
        if (Uteis.linhaSelecionada(tblResultado)){
            
            frmPacienteDoencaPesq f = new frmPacienteDoencaPesq(null, rootPaneCheckingEnabled);
            f.xcodpaciente = Integer.parseInt(tblResultado.getValueAt(tblResultado.getSelectedRow(), 0).toString());
            f.setVisible(true);
            
        }
    }//GEN-LAST:event_mnPopupDoencaActionPerformed

    private void mnPopupCuidadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnPopupCuidadorActionPerformed
        if (Uteis.linhaSelecionada(tblResultado)){
            
            frmPacienteCuidadorPesq f = new frmPacienteCuidadorPesq(null, rootPaneCheckingEnabled);
            f.xcodpaciente = Integer.parseInt(tblResultado.getValueAt(tblResultado.getSelectedRow(), 0).toString());
            f.setVisible(true);
            
        }
    }//GEN-LAST:event_mnPopupCuidadorActionPerformed

    private void mnPopupResponsavelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnPopupResponsavelActionPerformed
        if (Uteis.linhaSelecionada(tblResultado)){
            
            frmPacienteResponsavelPesq f = new frmPacienteResponsavelPesq(null, rootPaneCheckingEnabled);
            f.xcodpaciente = Integer.parseInt(tblResultado.getValueAt(tblResultado.getSelectedRow(), 0).toString());
            f.setVisible(true);
            
        }
    }//GEN-LAST:event_mnPopupResponsavelActionPerformed

    private void mnPopupCategoriaPerguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnPopupCategoriaPerguntaActionPerformed
        if (Uteis.linhaSelecionada(tblResultado)){
            
            frmPacienteCategoriaPerguntaPesq f = new frmPacienteCategoriaPerguntaPesq(null, rootPaneCheckingEnabled);
            f.xcodpaciente = Integer.parseInt(tblResultado.getValueAt(tblResultado.getSelectedRow(), 0).toString());
            f.setVisible(true);
            
        }
    }//GEN-LAST:event_mnPopupCategoriaPerguntaActionPerformed

    private void mnPopupResponsavelAlertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnPopupResponsavelAlertaActionPerformed
        if (Uteis.linhaSelecionada(tblResultado)){
            /*
            frmPacienteResponsavelAlertaCad f = new frmPacienteResponsavelAlertaCad(null, rootPaneCheckingEnabled);
            f.xcodpaciente = Integer.parseInt(tblResultado.getValueAt(tblResultado.getSelectedRow(), 0).toString());
            f.setVisible(true);
            */
        }
    }//GEN-LAST:event_mnPopupResponsavelAlertaActionPerformed

    private void mnPopupVacinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnPopupVacinasActionPerformed
        if (Uteis.linhaSelecionada(tblResultado)){
            
            frmPacienteVacinaPesq f = new frmPacienteVacinaPesq(null, rootPaneCheckingEnabled);
            f.xcodpaciente = Integer.parseInt(tblResultado.getValueAt(tblResultado.getSelectedRow(), 0).toString());
            f.setVisible(true);
            
        }
    }//GEN-LAST:event_mnPopupVacinasActionPerformed

    private void mnPopupServicoMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnPopupServicoMedicoActionPerformed
        if (Uteis.linhaSelecionada(tblResultado)){
            
            frmPacienteServicoMedicoPesq f = new frmPacienteServicoMedicoPesq(null, rootPaneCheckingEnabled);
            f.xcodpaciente = Integer.parseInt(tblResultado.getValueAt(tblResultado.getSelectedRow(), 0).toString());
            f.setVisible(true);
            
        }
    }//GEN-LAST:event_mnPopupServicoMedicoActionPerformed

    private void mnPopupCirurgiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnPopupCirurgiasActionPerformed
        if (Uteis.linhaSelecionada(tblResultado)){
            /*
            frmPacienteCirurgiaPesq f = new frmPacienteCirurgiaPesq(null, rootPaneCheckingEnabled);
            f.xcodpaciente = Integer.parseInt(tblResultado.getValueAt(tblResultado.getSelectedRow(), 0).toString());
            f.setVisible(true);
            */
        }
    }//GEN-LAST:event_mnPopupCirurgiasActionPerformed

    private void mnPopupLigacaoExtraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnPopupLigacaoExtraActionPerformed
        if (Uteis.linhaSelecionada(tblResultado)){
            /*
            frmPacienteLigacaoExtraPesq f = new frmPacienteLigacaoExtraPesq(null, rootPaneCheckingEnabled);
            f.xcodpaciente = Integer.parseInt(tblResultado.getValueAt(tblResultado.getSelectedRow(), 0).toString());
            f.setVisible(true);
            */
        }
    }//GEN-LAST:event_mnPopupLigacaoExtraActionPerformed

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
            java.util.logging.Logger.getLogger(frmPacientePesq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPacientePesq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPacientePesq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPacientePesq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmPacientePesq dialog = new frmPacientePesq(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnLimparFiltro;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JComboBox<Object> cmbPesqConvenio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPesqConvenio;
    private javax.swing.JLabel lblPesqPaciente;
    private javax.swing.JPopupMenu menuPopup;
    private javax.swing.JMenuItem mnPopupCategoriaPergunta;
    private javax.swing.JMenuItem mnPopupCirurgias;
    private javax.swing.JMenuItem mnPopupConsultas;
    private javax.swing.JMenuItem mnPopupCuidador;
    private javax.swing.JMenuItem mnPopupDoenca;
    private javax.swing.JMenuItem mnPopupInternacoes;
    private javax.swing.JMenuItem mnPopupLigacao;
    private javax.swing.JMenuItem mnPopupLigacaoExtra;
    private javax.swing.JMenuItem mnPopupMedicacao;
    private javax.swing.JMenuItem mnPopupProfissionais;
    private javax.swing.JMenuItem mnPopupResponsavel;
    private javax.swing.JMenuItem mnPopupResponsavelAlerta;
    private javax.swing.JMenuItem mnPopupServicoMedico;
    private javax.swing.JMenuItem mnPopupVacinas;
    private javax.swing.JPanel pnlBotao;
    private javax.swing.JPanel pnlFiltro;
    private javax.swing.JTable tblResultado;
    private javax.swing.JTextField txtPesqPaciente;
    // End of variables declaration//GEN-END:variables

    private void preencheConvenios() throws SQLException {
        cmbPesqConvenio.removeAllItems();
        for (Convenio c : ConvenioDAO.listarTodos("")) {
            cmbPesqConvenio.addItem(c);
        }
        cmbPesqConvenio.setSelectedIndex(-1);
    }

    private void pesquisar() throws SQLException {
        int convenio;

        if (cmbPesqConvenio.getSelectedIndex() > 0) {
            convenio = ((Convenio) cmbPesqConvenio.getSelectedItem()).getCodigo();
        } else {
            convenio = -1;
        }
        DefaultTableModel modelo = (DefaultTableModel) tblResultado.getModel();
        modelo.setNumRows(0);

        for (Paciente p : PacienteDAO.listarPacientes(convenio, txtPesqPaciente.getText())) {
            modelo.addRow(new Object[]{
                p.getCodigo(),
                p.getNome(),
                p.getConvenio().getNomefantasia()
            });
        }
    }

    private void alterar() {
        if (Uteis.linhaSelecionada(tblResultado)) {
            frmPacienteCad f = new frmPacienteCad(null, rootPaneCheckingEnabled);
            f.xcodigo = Integer.parseInt(tblResultado.getValueAt(tblResultado.getSelectedRow(), 0).toString());
            f.setVisible(true);
        }
    }

    private void excluir() throws SQLException {
        if (Uteis.linhaSelecionada(tblResultado)) {
            Object[] options = {"Confirmar", "Cancelar"};
            if (JOptionPane.showOptionDialog(null, "Deseja excluir o registro?", "Exclusão", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == 0) {

                JFrame frame = new JFrame("InputDialog Example #1");
                String code = JOptionPane.showInputDialog(
                        frame,
                        "Informe o motivo da exclusão:",
                        "Motivo da exclusão",
                        JOptionPane.WARNING_MESSAGE
                );
                
                if (!"".equals(code)){
                    //daoPaciente.excluir(Integer.parseInt(tblResultado.getValueAt(tblResultado.getSelectedRow(), 0).toString()), code);
                } else {
                    JOptionPane.showMessageDialog(null, "Motivo não informado.");
                }
                
            }
        }
    }
}
