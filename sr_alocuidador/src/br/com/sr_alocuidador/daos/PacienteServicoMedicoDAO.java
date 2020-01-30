package br.com.sr_alocuidador.daos;

import br.com.sr_alocuidador.conexao.Conexao;
import br.com.sr_alocuidador.models.PacienteServicoMedico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteServicoMedicoDAO {
    
    private final PacienteDAO daoPaciente;
    private final ServicoMedicoDAO daoServicoMedico;
    
    public PacienteServicoMedicoDAO(){
        daoPaciente = new PacienteDAO();
        daoServicoMedico = new ServicoMedicoDAO();
    }
    
    private void incluir(PacienteServicoMedico c) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO CLIENTES_SERVICOS (IDCLIENTE, IDSERVICO, DATA, PROFISSIONAL, OBSERVACAO) ");
        sql.append("VALUES (?, ?, ?, ?, ?)");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, c.getPaciente().getCodigo());
        pst.setInt(2, c.getServico().getCodigo());
        pst.setString(3, c.getData());
        pst.setString(4, c.getProfissional());
        pst.setString(5, c.getObservacao());
        pst.execute();
        pst.close();
        
    }
    
    private void alterar(PacienteServicoMedico c) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE CLIENTES_SERVICOS SET IDCLIENTE = ?, IDSERVICO = ?, DATA = ?, PROFISSIONAL = ?, OBSERVACAO = ? WHERE ID = ? ");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, c.getPaciente().getCodigo());
        pst.setInt(2, c.getServico().getCodigo());
        pst.setString(3, c.getData());
        pst.setString(4, c.getProfissional());
        pst.setString(5, c.getObservacao());
        pst.setInt(6, c.getCodigo());
        pst.execute();
        pst.close();
    }
    
    public void excluir(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM CLIENTES_SERVICOS WHERE IDCLIINTER = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        pst.execute();
        pst.close();
        
    }
    
    private boolean existeRegistro(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM CLIENTES_SERVICOS CC WHERE CC.IDCLIINTER = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery();
        return rs.next();
        
    }
    
    public void validaDados(PacienteServicoMedico c) throws SQLException{
        if (existeRegistro(c.getCodigo())){
            alterar(c);
        } else {
            incluir(c);
        }
    }
    
    public PacienteServicoMedico buscarPorId(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT cv.*, c.nome as nmpaciente, v.nome as nmservico FROM CLIENTES_SERVICOS CV ");
        sql.append("inner join clientes c on c.IDCLIENTE = cv.IDCLIENTE inner join SERVICOS v on v.ID = cv.IDSERVICO ");
        sql.append("WHERE CV.ID = ? ");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery();
        PacienteServicoMedico c = null;
        while(rs.next()){
            c = new PacienteServicoMedico();
            c.setCodigo(rs.getInt("ID"));
            c.setPaciente(daoPaciente.buscarPorId(rs.getInt("IDCLIENTE")));
            c.setServico(daoServicoMedico.buscarPorId(rs.getInt("IDSERVICO")));
            c.setData(rs.getString("DATA"));
            c.setProfissional(rs.getString("PROFISSIONAL"));
            c.setObservacao(rs.getString("OBSERVACAO"));
        }
        return c;
        
    }
    
    public List<PacienteServicoMedico> listarServicosPorPaciente(int paciente) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT cv.*, c.nome as nmpaciente, v.nome as nmservico FROM CLIENTES_SERVICOS CV ");
        sql.append("inner join clientes c on c.IDCLIENTE = cv.IDCLIENTE inner join SERVICOS v on v.ID = cv.IDSERVICO ");
        sql.append("WHERE CV.IDCLIENTE = ? ORDER BY CV.DATA");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, paciente);
        ResultSet rs = pst.executeQuery();
        List<PacienteServicoMedico> lista = new ArrayList<>();
        while(rs.next()){
            PacienteServicoMedico c = new PacienteServicoMedico();
            c.setCodigo(rs.getInt("ID"));
            c.setPaciente(daoPaciente.buscarPorId(rs.getInt("IDCLIENTE")));
            c.setServico(daoServicoMedico.buscarPorId(rs.getInt("IDSERVICO")));
            c.setData(rs.getString("DATA"));
            c.setProfissional(rs.getString("PROFISSIONAL"));
            c.setObservacao(rs.getString("OBSERVACAO"));
            lista.add(c);
        }
        return lista;
        
    }
    
}
