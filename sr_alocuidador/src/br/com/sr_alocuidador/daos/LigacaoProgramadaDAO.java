package br.com.sr_alocuidador.daos;

import br.com.sr_alocuidador.conexao.Conexao;
import br.com.sr_alocuidador.helpers.Uteis;
import br.com.sr_alocuidador.models.Ligacao;
import br.com.sr_alocuidador.models.LigacaoProgramada;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class LigacaoProgramadaDAO {
    
    private final PacienteDAO daoPaciente;
    private final CategoriaPerguntaDAO daoCategoriaPergunta;
    private final UsuarioDAO daoUsuario;
    private final PacienteCategoriaPerguntaDAO daoPacienteCategPergunta;
    
    public LigacaoProgramadaDAO(){
        daoPaciente = new PacienteDAO();
        daoCategoriaPergunta = new CategoriaPerguntaDAO();
        daoUsuario = new UsuarioDAO();
        daoPacienteCategPergunta = new PacienteCategoriaPerguntaDAO();
    }
    
    private void incluir(Ligacao l) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO LIGACOES (IDLIGACAO, IDCLIENTE, IDCLICUIDADOR, DATA, HORA_INICIO, ");
        sql.append("HORA_FIM, OBSERVACAO, IDUSUARIO, STATUS, IDCLIPERGCATEG) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setString(1, l.getIdligacao());
        pst.setInt(2, l.getPaciente().getCodigo());
        pst.setInt(3, l.getIdclicuidador());
        pst.setString(4, l.getData());
        pst.setString(5, l.getHorainicio());
        pst.setString(6, l.getHorafim());
        pst.setString(7, l.getObservacao());
        pst.setInt(8, l.getUsuario().getCodigo());
        pst.setString(9, "R");
        pst.setInt(10, l.getPacientecategpergunta().getCodigo());
        pst.execute();
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyyMMddHHmmss");
        Date data = new Date();
        String novoCodigo = formato.format(data) + Uteis.zerosAEsquerda(Integer.toString(l.getPaciente().getCodigo()), 6);        
        String proximaData = retornarProximaData(l.getPaciente().getCodigo());
        int proximaCategoria = retornarProximaCategoria(l.getPaciente().getCodigo(), l.getPacientecategpergunta().getCodigo());
        incluirNovaLigacao(novoCodigo, l.getPaciente().getCodigo(), proximaData, proximaCategoria);
        
    }
    
    private void incluirLigacaoNaoRealizada(String ligacao, int cliente, String data, 
            String horainicio, String horafim, int idusuario, int categoria, String motivo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO LIGACOES (IDLIGACAO, IDCLIENTE, DATA, HORA_INICIO, ");
        sql.append("HORA_FIM, IDUSUARIO, STATUS, IDCLIPERGCATEG, MOTIVONAOREALIZADA) ");
        sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setString(1, ligacao);
        pst.setInt(2, cliente);
        pst.setString(3, data);
        pst.setString(4, horainicio);
        pst.setString(5, horafim);
        pst.setInt(6, idusuario);
        pst.setString(7, "N");
        pst.setInt(8, categoria);
        pst.setString(9, motivo);
        pst.execute();
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyyMMddHHmmss");
        Date dataNova = new Date();
        String novoCodigo = formato.format(dataNova) + Uteis.zerosAEsquerda(Integer.toString(cliente), 6);        
        String proximaData = data;
        int proximaCategoria = categoria;
        incluirNovaLigacao(novoCodigo, cliente, proximaData, proximaCategoria);
        
    }
    
    private void incluirNovaLigacao(String ligacao, int cliente, String data, int idclipergcateg) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO LIGACOES (IDLIGACAO, IDCLIENTE, DATA, STATUS, IDCLIPERGCATEG) ");
        sql.append("VALUES (?, ?, ?, ?, ?)");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setString(1, ligacao);
        pst.setInt(2, cliente);
        pst.setString(3, data);
        pst.setString(4, "P");
        pst.setInt(5, idclipergcateg);
        pst.execute();
        
    }
    
    private void alterar(Ligacao l) throws SQLException {
        
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE LIGACOES SET IDCLICUIDADOR = ?, HORA_INICIO = ?, HORA_FIM = ? ");
        sql.append(", OBSERVACAO = ?, IDUSUARIO = ?, STATUS = ? WHERE IDLIGACAO = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, l.getIdclicuidador());
        pst.setString(2, l.getHorainicio());
        pst.setString(3, l.getHorafim());
        pst.setString(4, l.getObservacao());
        pst.setInt(5, l.getUsuario().getCodigo());
        pst.setString(6, "R");
        pst.setString(7, l.getIdligacao());
        pst.execute();
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyyMMddHHmmss");
        Date data = new Date();
        String novoCodigo = formato.format(data) + Uteis.zerosAEsquerda(Integer.toString(l.getPaciente().getCodigo()), 6);        
        String proximaData = retornarProximaData(l.getPaciente().getCodigo());
        int proximaCategoria = retornarProximaCategoria(l.getPaciente().getCodigo(), l.getPacientecategpergunta().getCodigo());
        incluirNovaLigacao(novoCodigo, l.getPaciente().getCodigo(), proximaData, proximaCategoria);
        
    }
    
    private void alterarLigacaoNaoRealizada(String ligacao, String horainicio, String horafim, int idusuario, String motivo, int paciente, int categoria) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE LIGACOES SET HORA_INICIO = ?, HORA_FIM = ? ");
        sql.append(", IDUSUARIO = ?, STATUS = ?, MOTIVONAOREALIZADA = ? WHERE IDLIGACAO = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setString(1, horainicio);
        pst.setString(2, horafim);
        pst.setInt(3, idusuario);
        pst.setString(4, "N");
        pst.setString(5, motivo);
        pst.setString(6, ligacao);
        pst.execute();
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyyMMddHHmmss");
        SimpleDateFormat formato2 = new SimpleDateFormat("yyyy-MM-dd");
        Date data = new Date();
        String novoCodigo = formato.format(data) + Uteis.zerosAEsquerda(Integer.toString(paciente), 6);        
        String proximaData = formato2.format(data);
        int proximaCategoria = categoria;
        incluirNovaLigacao(novoCodigo, paciente, proximaData, proximaCategoria);
        
    }
    
    
    private String retornarProximaData(int idpaciente) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM CLIENTES WHERE IDCLIENTE = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, idpaciente);
        ResultSet rs = pst.executeQuery();
        int dias = 0;
        while (rs.next()){
            dias = rs.getInt("INTERVALOLIGACAO");
        }
        Date hoje = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(hoje);
        c.add(Calendar.DATE, dias);
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        return formato.format(c.getTime());
    }
    
    private int retornarProximaCategoria(int paciente, int idpergcateg) throws SQLException{
        
        // Busca qual o código da categoria
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM CLIENTES_PERGCATEG CP WHERE CP.IDCLIENTE = ? AND CP.IDCLIPERGCATEG = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, paciente);
        pst.setInt(2, idpergcateg); 
        ResultSet rs = pst.executeQuery();
        int seq = 0;
        if (rs.next()){
            seq = rs.getInt("SEQ");
        }
        
        // Busca qual o codigo da próxima categoria
        StringBuilder sql2 = new StringBuilder();
        sql2.append("SELECT * FROM CLIENTES_PERGCATEG CP WHERE CP.IDCLIENTE = ? AND CP.SEQ > ? order by cp.seq limit 1");
        PreparedStatement pst2 = Conexao.AbrirConexao().prepareStatement(sql2.toString());
        pst2.setInt(1, paciente);
        pst2.setInt(2, seq);
        ResultSet rs2 = pst2.executeQuery();
        int categoria = 0;
        while(rs2.next()){
            categoria = rs2.getInt("IDCLIPERGCATEG");                    
        }
        if (categoria == 0){
            StringBuilder sql3 = new StringBuilder();
            sql3.append("SELECT * FROM CLIENTES_PERGCATEG CP WHERE CP.IDCLIENTE = ? ORDER BY CP.SEQ LIMIT 1");
            PreparedStatement pst3 = Conexao.AbrirConexao().prepareStatement(sql3.toString());
            pst3.setInt(1, paciente);
            ResultSet rs3 = pst3.executeQuery();
            while(rs3.next()){
                categoria = rs3.getInt("IDCLIPERGCATEG");
            }
        }
        return categoria;
        
    }
    

    public void ValidaDados(Ligacao l) throws SQLException{
        if (ExisteLigacao(l.getIdligacao())){
            alterar(l);
        } else {
            incluir(l);
        }
    }
    
    public void ValidaDadosNaoRealizado(String ligacao, int idcliente, String data, String datahorainicio, String datahorafim, int idusuario, int idclipergcateg, String motivo) throws SQLException{
        if (ExisteLigacao(ligacao)){
            alterarLigacaoNaoRealizada(
                    ligacao, 
                    datahorainicio, 
                    datahorafim, 
                    idusuario, 
                    motivo, 
                    idcliente, 
                    idclipergcateg);
        } else {
            incluirLigacaoNaoRealizada(
                    ligacao, 
                    idcliente, 
                    data,                    
                    datahorainicio, 
                    datahorafim, 
                    idusuario, idclipergcateg, 
                    motivo);
        }
    }
    
    private boolean ExisteLigacao(String idligacao) throws SQLException {
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM LIGACOES WHERE IDLIGACAO = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setString(1, idligacao);
        ResultSet rs = pst.executeQuery();
        return rs.next();
        
    }
    
    
    public List<LigacaoProgramada> ListarLigacoesProgramadas(String nomePaciente){
        
        SimpleDateFormat formatoCodigo = new SimpleDateFormat("yyyyMMddHHmmss");
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date dataAtual = new Date();    
        
        String[] dataSeparada = new String[3];
        dataSeparada =  formato.format(dataAtual).split("-");       
        
        //Pegar o primeiro e ultimo dia do mes
        int ano = Integer.parseInt(dataSeparada[0]);
        int mes = Integer.parseInt(dataSeparada[1]);
        int dia = Integer.parseInt(dataSeparada[2]);
        Calendar c = new GregorianCalendar(ano, mes, dia);
        
        String primeiroDia = Uteis.zerosAEsquerda(dataSeparada[0], 4) + "-" + 
                             Uteis.zerosAEsquerda(dataSeparada[1], 2) + "-" +
                             Uteis.zerosAEsquerda(Integer.toString(c.getMinimum(c.DAY_OF_MONTH)), 2);   
                
        String ultimoDia = Uteis.zerosAEsquerda(dataSeparada[0], 4) + "-" + 
                             Uteis.zerosAEsquerda(dataSeparada[1], 2) + "-" +
                             Uteis.zerosAEsquerda(Integer.toString(c.getMaximum(c.DAY_OF_MONTH)), 2);
        
        StringBuilder sql = new StringBuilder();
        StringBuilder sqlNovos = new StringBuilder();
        
        List<LigacaoProgramada> lista = new ArrayList<>();
        
        sql.append("SELECT L.IDLIGACAO, L.DATA, L.IDCLIENTE, C.NOME AS NMCLIENTE, CV.NMFANTASIA AS NMCONVENIO, 'N' AS SITUACAO, ");
        sql.append("(SELECT COUNT(L2.IDLIGACAO) AS QTDE FROM LIGACOES L2 WHERE L2.STATUS = 'R' AND L2.HORA_INICIO BETWEEN ? AND ? AND L2.IDCLIENTE = L.IDCLIENTE) AS QTDELIGACAO, ");
        sql.append("C.CONTATOS, C.CELULAR, CPC.idpergcateg, C.DTCAD ");
        sql.append("FROM LIGACOES L ");
        sql.append("INNER JOIN CLIENTES C ON C.IDCLIENTE = L.IDCLIENTE AND C.STATUS = 'A' ");
        sql.append("INNER JOIN CONVENIOS CV ON CV.IDCONVENIO = C.IDCONVENIO ");
        sql.append("LEFT JOIN CLIENTES_PERGCATEG CPC ON CPC.IDCLIENTE = C.IDCLIENTE AND CPC.IDCLIPERGCATEG = L.IDCLIPERGCATEG ");
        sql.append("WHERE L.STATUS = 'P' AND L.DATA <= NOW() ");
        sql.append("UNION ALL ");
        sql.append("SELECT '0' AS IDLIGACAO, NOW() AS DATA, C.IDCLIENTE, C.NOME AS NMCLIENTE, CV.NMFANTASIA AS NMCONVENIO, 'S' AS SITUACAO, ");
        sql.append("0 AS QTDELIGACAO, C.CONTATOS, C.CELULAR, ");
        sql.append("(SELECT (case when cpc.idpergcateg is null then 0 else cpc.idpergcateg end) as idpergcateg FROM CLIENTES_PERGCATEG CPC WHERE cPC.IDCLIENTE IN (c.idcliente) ORDER BY CPC.SEQ LIMIT 1) AS idpergcateg, C.DTCAD ");
        sql.append("FROM CLIENTES C ");
        sql.append("INNER JOIN CONVENIOS CV ON CV.IDCONVENIO = C.IDCONVENIO ");
        sql.append("WHERE NOT C.IDCLIENTE IN (SELECT L.IDCLIENTE FROM LIGACOES L WHERE L.IDCLIENTE = C.IDCLIENTE) AND C.STATUS = 'A' ");
        sql.append("ORDER BY DATA ASC, IDLIGACAO ASC, IDCLIENTE ASC");

        
        /*sql.append("SELECT LIG.*, CLI.NOME AS NMCLIENTE, 'N' AS PRIMEIRALIGACAO, CLI.CONTATOS, CLI.CELULAR, CLI.EMAIL, ");
        sql.append("(");
        sql.append("SELECT (CASE WHEN COUNT(*) > 0 THEN COUNT(*) ELSE 0 END) AS QTDE FROM LIGACOES L WHERE L.STATUS = 'R' AND L.IDCLIENTE = LIG.IDCLIENTE AND L.HORA_INICIO BETWEEN '" + primeiroDia + " 00:00:00' AND '" + ultimoDia + " 23:59:59'");
        sql.append(") AS QTDELIGACAO, CPC.idpergcateg ");
        sql.append("FROM LIGACOES LIG INNER JOIN CLIENTES CLI ON CLI.IDCLIENTE = LIG.IDCLIENTE AND CLI.STATUS = 'A' ");
        sql.append("INNER JOIN CLIENTES_PERGCATEG CPC ON CPC.IDCLIENTE = CLI.IDCLIENTE ");
        sql.append("WHERE LIG.DATA <= '").append(formato.format(dataAtual)).append("' AND LIG.STATUS = 'P' AND CPC.IDCLIPERGCATEG = LIG.IDCLIPERGCATEG ");
        if (!"".equals(nomePaciente)){
            sql.append("AND UPPER(CLI.NOME) LIKE '%" + nomePaciente.toUpperCase() + "%' ");
        }
        sql.append("ORDER BY LIG.DATA, LIG.IDLIGACAO");
        
        //Sql para os novos pacientes
        sqlNovos.append("SELECT cli.*, (");
        sqlNovos.append("SELECT (case when cpc.idpergcateg is null then 0 else cpc.idpergcateg end) as idpergcateg 
        FROM CLIENTES_PERGCATEG CPC WHERE cPC.IDCLIENTE IN (cli.idcliente) ORDER BY CPC.SEQ LIMIT 1");
        sqlNovos.append(") as idpergcateg FROM CLIENTES CLI WHERE NOT CLI.IDCLIENTE IN (SELECT LIG.IDCLIENTE FROM LIGACOES LIG WHERE LIG.IDCLIENTE = CLI.IDCLIENTE) ");
        sqlNovos.append("AND CLI.STATUS = 'A' ");
        if (!"".equals(nomePaciente)){
            sqlNovos.append("AND UPPER(CLI.NOME) LIKE '%" + nomePaciente.toUpperCase() + "%' ");
        }*/
        
        try {
            PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
            pst.setString(1, primeiroDia + " 00:00:00");
            pst.setString(2, ultimoDia + " 23:59:59");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                LigacaoProgramada lp = new LigacaoProgramada();
                lp.setIdligacao(rs.getString("IDLIGACAO"));
                lp.setDataprogramada(Uteis.formatarData(rs.getString("DATA")));
                lp.setPaciente(daoPaciente.buscarPorId(rs.getInt("IDCLIENTE")));
                lp.setNomepaciente(rs.getString("NMCLIENTE"));                
                lp.setPrimeiraligacao(rs.getString("SITUACAO"));
                lp.setCategoriapergunta(daoCategoriaPergunta.BuscarPorId(rs.getInt("IDPERGCATEG")));
                lp.setQtdeligacao(rs.getInt("QTDELIGACAO"));
                lp.setContatos(rs.getString("CONTATOS") + " " + rs.getString("CELULAR"));
                lista.add(lp);
            }   
            
            // Percorre os dados dos novos clientes
            /*PreparedStatement pst2 = Conexao.AbrirConexao().prepareStatement(sqlNovos.toString());
            ResultSet rs2 = pst2.executeQuery();
            while(rs2.next()){
                Date datanova = new Date();
                String novoCodigo = formatoCodigo.format(datanova);
                
                LigacaoProgramadaEntidade lp = new LigacaoProgramadaEntidade();
                lp.setIdligacao(novoCodigo.concat(Uteis.zerosAEsquerda(rs2.getString("IDCLIENTE"), 6)));
                lp.setDataprogramada(Uteis.formatarData(formato.format(datanova)));
                lp.setIdpaciente(rs2.getInt("IDCLIENTE"));
                lp.setNomepaciente(rs2.getString("NOME"));                
                lp.setPrimeiraligacao("S");
                lp.setCategoriapergunta(rs2.getInt("IDPERGCATEG"));
                lp.setQtdeligacao(0);
                lp.setContatos(rs2.getString("CONTATOS") + " " + rs2.getString("CELULAR"));
                lista.add(lp);                
            }*/
        } catch (SQLException ex) {
            return null;
        }        
        return lista;
    }

    public void excluirLigacao(String ligacao) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE LIGACOES SET IDCLICUIDADOR = NULL, HORA_INICIO = NULL, HORA_FIM = NULL, ");
        sql.append("OBSERVACAO = '', IDUSUARIO = NULL, STATUS = 'P', MOTIVONAOREALIZADA = '' ");
        sql.append("WHERE IDLIGACAO = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setString(1, ligacao);
        pst.execute();
        
        StringBuilder sql2 = new StringBuilder();
        sql2.append("DELETE FROM LIGACOES WHERE IDLIGACAO != ? AND STATUS = 'P'");
        PreparedStatement pst2 = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst2.setString(1, ligacao);
        pst2.execute();
        
    }
    
    public List<LigacaoProgramada> listarLigacoesPorPaciente(int paciente) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM LIGACOES WHERE IDCLIENTE = ? AND STATUS IN ('R','N') ORDER BY HORA_INICIO DESC, DATA DESC");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, paciente);
        ResultSet rs = pst.executeQuery();
        List<LigacaoProgramada> lista = new ArrayList<>();
        while(rs.next()){
            LigacaoProgramada c = new LigacaoProgramada();
            c.setIdligacao(rs.getString("IDLIGACAO"));
            c.setPaciente(daoPaciente.buscarPorId( rs.getInt("IDCLIENTE")) );
            c.setDataprogramada(rs.getString("DATA"));
            c.setHorainicio(rs.getString("HORA_INICIO"));
            c.setHorafim(rs.getString("HORA_FIM"));
            c.setStatus("R".equals(rs.getString("STATUS")) ? "REALIZADO" : "NÃO REALIZADO");
            lista.add(c);
        }
        return lista;
        
    }
    
    public Ligacao buscarPorId(String ligacao) throws SQLException {
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM LIGACOES WHERE IDLIGACAO = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setString(1, ligacao);
        ResultSet rs = pst.executeQuery();
        Ligacao c = null;
        while(rs.next()){
            c = new Ligacao();
            c.setIdligacao(ligacao);
            c.setPaciente(daoPaciente.buscarPorId(rs.getInt("IDCLIENTE")));
            c.setIdclicuidador(rs.getInt("IDCLICUIDADOR"));
            c.setData(rs.getString("DATA"));
            c.setHorainicio(rs.getString("HORA_INICIO"));
            c.setHorafim(rs.getString("HORA_FIM"));
            c.setObservacao(rs.getString("OBSERVACAO"));
            c.setUsuario(daoUsuario.buscarPorId(rs.getInt("IDUSUARIO")));
            c.setStatus(rs.getString("STATUS"));
            c.setPacientecategpergunta(daoPacienteCategPergunta.buscarPorId(rs.getInt("IDCLIPERGCATEG")));
            c.setMotivonaorealizado(rs.getString("MOTIVONAOREALIZADA"));
        }
        return c;
    }

    public List<Ligacao> listarLigacoesPorPeriodo(String data) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM LIGACOES WHERE DATA = ? ORDER BY IDLIGACAO");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setString(1, Uteis.desformatarData(data));
        ResultSet rs = pst.executeQuery();
        List<Ligacao> lista = new ArrayList<>();
        while(rs.next()){
            Ligacao c = new Ligacao();
            c.setIdligacao(rs.getString("IDLIGACAO"));
            c.setPaciente(daoPaciente.buscarPorId(rs.getInt("IDCLIENTE")));
            c.setIdclicuidador(rs.getInt("IDCLICUIDADOR"));
            c.setData(rs.getString("DATA"));
            c.setHorainicio(rs.getString("HORA_INICIO"));
            c.setHorafim(rs.getString("HORA_FIM"));
            c.setObservacao(rs.getString("OBSERVACAO"));
            c.setUsuario(daoUsuario.buscarPorId(rs.getInt("IDUSUARIO")));
            c.setStatus(rs.getString("STATUS"));
            c.setPacientecategpergunta( daoPacienteCategPergunta.buscarPorId(rs.getInt("IDCLIPERGCATEG")) );
            c.setMotivonaorealizado(rs.getString("MOTIVONAOREALIZADA"));
            lista.add(c);
        }
        return lista;
    }
    
    public void alterarDataAntecipacao(String ligacao, String data) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE LIGACOES SET DATA = ? WHERE IDLIGACAO = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setString(1, data);
        pst.setString(2, ligacao);
        pst.execute();
    }
    
}
