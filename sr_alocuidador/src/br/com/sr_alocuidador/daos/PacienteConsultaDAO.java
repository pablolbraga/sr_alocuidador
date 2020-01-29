package br.com.sr_alocuidador.daos;

import br.com.sr_alocuidador.conexao.Conexao;
import br.com.sr_alocuidador.models.PacienteConsulta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteConsultaDAO {
    
    private ConstantesItemDAO daoConstanteItem;
    
    public PacienteConsultaDAO(){        
        daoConstanteItem = new ConstantesItemDAO();        
    }
    
    private void incluir(PacienteConsulta c) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO CLIENTES_CONSULTAS (IDCLIENTE, IDHOSPITAL, DATA, EMERGENCIA, OBSERVACAO, MOTIVO) ");
        sql.append("VALUES (?, ?, ?, ?, ?, ?)");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, c.getPaciente().getCodigo());
        pst.setInt(2, c.getHospital().getCodigo());
        pst.setString(3, c.getData());
        pst.setString(4, c.getEmergencia());
        pst.setString(5, c.getObservacao());
        pst.setInt(6, c.getMotivo().getIndice());
        pst.execute();
        
    }
    
    private void alterar(PacienteConsulta c) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE CLIENTES_CONSULTAS SET IDCLIENTE = ?, IDHOSPITAL = ?, DATA = ?");
        sql.append(",  EMERGENCIA = ?, OBSERVACAO = ?, MOTIVO = ? WHERE ID = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, c.getPaciente().getCodigo());
        pst.setInt(2, c.getHospital().getCodigo());
        pst.setString(3, c.getData());
        pst.setString(4, c.getEmergencia());
        pst.setString(5, c.getObservacao());
        pst.setInt(6, c.getMotivo().getIndice());
        pst.setInt(7, c.getCodigo());
        pst.execute();
        
    }
    
    public void excluir(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM CLIENTES_CONSULTAS WHERE ID = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        pst.execute();
        
    }
    
    private boolean existeRegistro(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM CLIENTES_CONSULTAS CC WHERE CC.ID = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery();
        return rs.next();
        
    }
    
    public void validaDados(PacienteConsulta c) throws SQLException{
        if (existeRegistro(c.getCodigo())){
            alterar(c);
        } else {
            incluir(c);
        }
    }
    
    public PacienteConsulta buscarPorId(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT CC.*, C.NOME AS NMPACIENTE, CI.NOME AS NMMOTIVO, H.NOME AS NMHOSPITAL ");
        sql.append("FROM CLIENTES_CONSULTAS CC INNER JOIN CLIENTES C ON C.IDCLIENTE = CC.IDCLIENTE ");
        sql.append("INNER JOIN HOSPITAIS H ON H.IDHOSPITAL = CC.IDHOSPITAL ");
        sql.append("LEFT JOIN CONSTANTES_ITEM CI ON CI.INDICE = CC.MOTIVO AND CI.IDCONSTANTE = 23 ");
        sql.append("WHERE CC.ID = ? ORDER BY cc.DATA");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery();
        PacienteConsulta c = null;
        while(rs.next()){
            c = new PacienteConsulta();
            c.setCodigo(rs.getInt("ID"));
            c.setPaciente(PacienteDAO.buscarPorId( rs.getInt("IDCLIENTE")) );
            c.setHospital(HospitalDAO.buscarPorId( rs.getInt("IDHOSPITAL")) );
            c.setData(rs.getString("DATA"));
            c.setEmergencia(rs.getString("EMERGENCIA"));
            c.setObservacao(rs.getString("OBSERVACAO"));
            c.setMotivo(daoConstanteItem.buscarPorId(23, rs.getInt("MOTIVO")));
        }
        return c;
        
    }
    
    public List<PacienteConsulta> listarConsultasPorPaciente(int paciente) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT CC.*, C.NOME AS NMPACIENTE, CI.NOME AS NMMOTIVO, H.NOME AS NMHOSPITAL ");
        sql.append("FROM CLIENTES_CONSULTAS CC INNER JOIN CLIENTES C ON C.IDCLIENTE = CC.IDCLIENTE ");
        sql.append("INNER JOIN HOSPITAIS H ON H.IDHOSPITAL = CC.IDHOSPITAL ");
        sql.append("LEFT JOIN CONSTANTES_ITEM CI ON CI.INDICE = CC.MOTIVO AND CI.IDCONSTANTE = 23 ");
        sql.append("WHERE CC.IDCLIENTE = ? ORDER BY cc.DATA");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, paciente);
        ResultSet rs = pst.executeQuery();
        List<PacienteConsulta> lista = new ArrayList<>();
        while(rs.next()){
            PacienteConsulta c = new PacienteConsulta();
            c.setCodigo(rs.getInt("ID"));
            c.setPaciente(PacienteDAO.buscarPorId( rs.getInt("IDCLIENTE")) );
            c.setHospital(HospitalDAO.buscarPorId( rs.getInt("IDHOSPITAL")) );
            c.setData(rs.getString("DATA"));
            c.setEmergencia(rs.getString("EMERGENCIA"));
            c.setObservacao(rs.getString("OBSERVACAO"));
            c.setMotivo(daoConstanteItem.buscarPorId(23, rs.getInt("MOTIVO")));
            lista.add(c);
        }
        return lista;
        
    }
    
    public List<PacienteConsulta> listarConsultasGeral(int convenio, String periodoini, String periodofim, String emergencia) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT CC.*, C.NOME AS NMPACIENTE, CI.NOME AS NMMOTIVO, H.NOME AS NMHOSPITAL ");
        sql.append("FROM CLIENTES_CONSULTAS CC INNER JOIN CLIENTES C ON C.IDCLIENTE = CC.IDCLIENTE ");
        sql.append("INNER JOIN HOSPITAIS H ON H.IDHOSPITAL = CC.IDHOSPITAL ");
        sql.append("LEFT JOIN CONSTANTES_ITEM CI ON CI.INDICE = CC.MOTIVO AND CI.IDCONSTANTE = 23 ");
        sql.append("WHERE 1 = 1 ");
        if (convenio > 0){
            sql.append("AND C.IDCONVENIO = ? ");
        }
        if (!"".equals(periodoini)){
            sql.append("AND CC.DATA >= ? ");
        }
        if (!"".equals(periodofim)){
            sql.append("AND CC.DATA <= ? ");
        }
        if ("S".equals(emergencia)){
            sql.append("AND CC.EMERGENCIA = 'S' ");
        }
        sql.append("ORDER BY CC.DATA");        
        
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
        List<PacienteConsulta> lista = new ArrayList<>();
        while(rs.next()){
            PacienteConsulta c = new PacienteConsulta();
            c.setCodigo(rs.getInt("ID"));
            c.setPaciente(PacienteDAO.buscarPorId( rs.getInt("IDCLIENTE")) );
            c.setHospital(HospitalDAO.buscarPorId( rs.getInt("IDHOSPITAL")) );
            c.setData(rs.getString("DATA"));
            c.setEmergencia(rs.getString("EMERGENCIA"));
            c.setObservacao(rs.getString("OBSERVACAO"));
            c.setMotivo(daoConstanteItem.buscarPorId(23, rs.getInt("MOTIVO")));
            lista.add(c);
        }
        return lista;
        
    }
    
}
