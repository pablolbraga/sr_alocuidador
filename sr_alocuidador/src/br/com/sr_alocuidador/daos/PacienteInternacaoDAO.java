package br.com.sr_alocuidador.daos;

import br.com.sr_alocuidador.conexao.Conexao;
import br.com.sr_alocuidador.models.PacienteInternacao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteInternacaoDAO {
    
    private static void incluir(PacienteInternacao c) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO CLIENTES_INTERNACAO (IDCLIENTE, IDHOSPITAL, DATAINI, DATAFIM, DIAGNOSTICO, MOTIVO, STATUS_LACE) ");
        sql.append("VALUES (?, ?, ?, ?, ?, ?, ?)");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, c.getPaciente().getCodigo());
        pst.setInt(2, c.getHospital().getCodigo());
        pst.setString(3, c.getDataini());
        pst.setString(4, c.getDatafim());
        pst.setString(5, c.getDiagnostico());
        pst.setInt(6, c.getIdmotivo().getIndice());
        pst.setString(7, c.getStatusLace());
        pst.execute();
        
    }
    
    private static void alterar(PacienteInternacao c) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE CLIENTES_INTERNACAO SET IDCLIENTE = ?, IDHOSPITAL = ?, DATAINI = ?, DATAFIM = ?, DIAGNOSTICO = ?, MOTIVO = ? WHERE IDCLIINTER = ? ");
        sql.append("VALUES (?, ?, ?, ?, ?, ?, ?)");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, c.getPaciente().getCodigo());
        pst.setInt(2, c.getHospital().getCodigo());
        pst.setString(3, c.getDataini());
        pst.setString(4, c.getDatafim());
        pst.setString(5, c.getDiagnostico());
        pst.setInt(6, c.getIdmotivo().getIndice());
        pst.setInt(7, c.getCodigo());
        pst.execute();
        
    }
    
    public static void excluir(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM CLIENTES_INTERNACAO WHERE IDCLIINTER = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        pst.execute();
        
    }
    
    private static boolean existeRegistro(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM CLIENTES_INTERNACAO CC WHERE CC.IDCLIINTER = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery();
        return rs.next();
        
    }
    
    public static void validaDados(PacienteInternacao c) throws SQLException{
        if (existeRegistro(c.getCodigo())){
            alterar(c);
        } else {
            incluir(c);
        }
    }
    
    public static PacienteInternacao buscarPorId(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT CC.*, C.NOME AS NMPACIENTE, CI.NOME AS NMMOTIVO, H.NOME AS NMHOSPITAL ");
        sql.append("FROM CLIENTES_INTERNACAO CC INNER JOIN CLIENTES C ON C.IDCLIENTE = CC.IDCLIENTE ");
        sql.append("INNER JOIN HOSPITAIS H ON H.IDHOSPITAL = CC.IDHOSPITAL ");
        sql.append("LEFT JOIN CONSTANTES_ITEM CI ON CI.INDICE = CC.MOTIVO AND CI.IDCONSTANTE = 24 ");
        sql.append("WHERE CC.IDCLIINTER = ? ORDER BY cc.DATAINI");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery();
        PacienteInternacao c = null;
        while(rs.next()){
            c = new PacienteInternacao();
            c.setCodigo(rs.getInt("IDCLIINTER"));
            c.setPaciente(PacienteDAO.buscarPorId( rs.getInt("IDCLIENTE")) );
            c.setHospital(HospitalDAO.buscarPorId( rs.getInt("IDHOSPITAL")) );
            c.setDataini(rs.getString("DATAINI"));
            c.setDatafim(rs.getString("DATAFIM"));
            c.setDiagnostico(rs.getString("DIAGNOSTICO"));            
            c.setIdmotivo(ConstantesItemDAO.buscarPorId(24, rs.getInt("MOTIVO")));
        }
        return c;
        
    }
    
    public static List<PacienteInternacao> listarConsultasPorPaciente(int paciente) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT CC.*, C.NOME AS NMPACIENTE, CI.NOME AS NMMOTIVO, H.NOME AS NMHOSPITAL ");
        sql.append("FROM CLIENTES_INTERNACAO CC INNER JOIN CLIENTES C ON C.IDCLIENTE = CC.IDCLIENTE ");
        sql.append("INNER JOIN HOSPITAIS H ON H.IDHOSPITAL = CC.IDHOSPITAL ");
        sql.append("LEFT JOIN CONSTANTES_ITEM CI ON CI.INDICE = CC.MOTIVO AND CI.IDCONSTANTE = 24 ");
        sql.append("WHERE CC.IDCLIENTE = ? ORDER BY cc.DATAINI");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, paciente);
        ResultSet rs = pst.executeQuery();
        List<PacienteInternacao> lista = new ArrayList<>();
        while(rs.next()){
            PacienteInternacao c = new PacienteInternacao();
            c.setCodigo(rs.getInt("IDCLIINTER"));
            c.setPaciente(PacienteDAO.buscarPorId( rs.getInt("IDCLIENTE")) );
            c.setHospital(HospitalDAO.buscarPorId( rs.getInt("IDHOSPITAL")) );
            c.setDataini(rs.getString("DATAINI"));
            c.setDatafim(rs.getString("DATAFIM"));
            c.setDiagnostico(rs.getString("DIAGNOSTICO"));            
            c.setIdmotivo(ConstantesItemDAO.buscarPorId(24, rs.getInt("MOTIVO")));
            lista.add(c);
        }
        return lista;
        
    }
    
    public List<PacienteInternacao> listarInternacaoGeral(int convenio, String periodoini, String periodofim) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT CC.*, C.NOME AS NMPACIENTE, CI.NOME AS NMMOTIVO, H.NOME AS NMHOSPITAL, CV.NMFANTASIA AS NMCONVENIO ");
        sql.append("FROM CLIENTES_INTERNACAO CC INNER JOIN CLIENTES C ON C.IDCLIENTE = CC.IDCLIENTE ");
        sql.append("INNER JOIN HOSPITAIS H ON H.IDHOSPITAL = CC.IDHOSPITAL ");
        sql.append("INNER JOIN CONVENIOS CV ON CV.IDCONVENIO = C.IDCONVENIO ");
        sql.append("LEFT JOIN CONSTANTES_ITEM CI ON CI.INDICE = CC.MOTIVO AND CI.IDCONSTANTE = 24 ");        
        sql.append("WHERE 1 = 1 ");
        if (convenio > 0){
            sql.append("AND C.IDCONVENIO = ? ");
        }
        if (!"".equals(periodoini)){
            sql.append("AND CC.DATAINI >= ? ");
        }
        if (!"".equals(periodofim)){
            sql.append("AND CC.DATAINI <= ? ");
        }
        sql.append("ORDER BY cc.DATAINI");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        int sequencia = 0;
        if (convenio > 0){
            sequencia = sequencia + 1;
            pst.setInt(sequencia, convenio);
        }
        if (!"".equals(periodoini)){
            sequencia = sequencia + 1;
            pst.setString(sequencia, periodoini + " 00:00:00");
        }
        if (!"".equals(periodofim)){
            sequencia = sequencia + 1;
            pst.setString(sequencia, periodofim + " 23:59:59");
        }
        
        ResultSet rs = pst.executeQuery();
        List<PacienteInternacao> lista = new ArrayList<>();
        while(rs.next()){
            PacienteInternacao c = new PacienteInternacao();
            c.setCodigo(rs.getInt("IDCLIINTER"));
            c.setPaciente(PacienteDAO.buscarPorId( rs.getInt("IDCLIENTE")) );
            c.setHospital(HospitalDAO.buscarPorId( rs.getInt("IDHOSPITAL")) );
            c.setDataini(rs.getString("DATAINI"));
            c.setDatafim(rs.getString("DATAFIM"));
            c.setDiagnostico(rs.getString("DIAGNOSTICO"));            
            c.setIdmotivo(ConstantesItemDAO.buscarPorId(24, rs.getInt("MOTIVO")));
            lista.add(c);
        }
        return lista;
        
    }
    
    public List<PacienteInternacao> listarInternacoesSemIndiceLace() throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT CC.*, C.NOME AS NMPACIENTE, CI.NOME AS NMMOTIVO, H.NOME AS NMHOSPITAL ");
        sql.append("FROM CLIENTES_INTERNACAO CC INNER JOIN CLIENTES C ON C.IDCLIENTE = CC.IDCLIENTE ");
        sql.append("INNER JOIN HOSPITAIS H ON H.IDHOSPITAL = CC.IDHOSPITAL ");
        sql.append("LEFT JOIN CONSTANTES_ITEM CI ON CI.INDICE = CC.MOTIVO AND CI.IDCONSTANTE = 24 ");
        sql.append("WHERE CC.STATUS_LACE = 'A' ORDER BY cc.IDCLIINTER DESC");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        ResultSet rs = pst.executeQuery();
        List<PacienteInternacao> lista = new ArrayList<>();
        while(rs.next()){
            PacienteInternacao c = new PacienteInternacao();
            c.setCodigo(rs.getInt("IDCLIINTER"));
            c.setPaciente(PacienteDAO.buscarPorId( rs.getInt("IDCLIENTE")) );
            c.setHospital(HospitalDAO.buscarPorId( rs.getInt("IDHOSPITAL")) );
            c.setDataini(rs.getString("DATAINI"));
            c.setDatafim(rs.getString("DATAFIM"));
            c.setDiagnostico(rs.getString("DIAGNOSTICO"));            
            c.setIdmotivo(ConstantesItemDAO.buscarPorId(24, rs.getInt("MOTIVO")));
            lista.add(c);
        }
        return lista;       
    }
    
    public PacienteInternacao InternacoesSemIndiceLacePorId(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT CC.*, C.NOME AS NMPACIENTE, CI.NOME AS NMMOTIVO, H.NOME AS NMHOSPITAL ");
        sql.append("FROM CLIENTES_INTERNACAO CC INNER JOIN CLIENTES C ON C.IDCLIENTE = CC.IDCLIENTE ");
        sql.append("INNER JOIN HOSPITAIS H ON H.IDHOSPITAL = CC.IDHOSPITAL ");
        sql.append("LEFT JOIN CONSTANTES_ITEM CI ON CI.INDICE = CC.MOTIVO AND CI.IDCONSTANTE = 24 ");
        sql.append("WHERE CC.STATUS_LACE = 'A' AND CC.IDCLIINTER = ? ORDER BY cc.IDCLIINTER DESC");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery();
        PacienteInternacao c = null;
        while(rs.next()){
            c = new PacienteInternacao();
            c.setCodigo(rs.getInt("IDCLIINTER"));
            c.setPaciente(PacienteDAO.buscarPorId( rs.getInt("IDCLIENTE")) );
            c.setHospital(HospitalDAO.buscarPorId( rs.getInt("IDHOSPITAL")) );
            c.setDataini(rs.getString("DATAINI"));
            c.setDatafim(rs.getString("DATAFIM"));
            c.setDiagnostico(rs.getString("DIAGNOSTICO"));            
            c.setIdmotivo(ConstantesItemDAO.buscarPorId(24, rs.getInt("MOTIVO")));
        }
        return c;
        
    }
    
    public void registrarIndiceLace(int codigo, int indice) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE CLIENTES_INTERNACAO SET STATUS_LACE = 'F', INDICE_LACE = ? WHERE IDCLIINTER = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, indice);
        pst.setInt(2, codigo);
        pst.execute();
        
    }
    
    public static int retornarUltimoIndiceLace(int paciente) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM CLIENTES_INTERNACAO WHERE STATUS_LACE = 'F' AND IDCLIENTE = ? ORDER BY IDCLIINTER DESC LIMIT 1 ");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, paciente);
        ResultSet rs = pst.executeQuery();
        if (rs.next()){
            return rs.getInt("INDICE_LACE");
        } else {
            return 0;
        }
        
    }
    
}
