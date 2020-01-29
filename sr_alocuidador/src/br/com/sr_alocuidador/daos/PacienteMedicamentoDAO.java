package br.com.sr_alocuidador.daos;

import br.com.sr_alocuidador.conexao.Conexao;
import br.com.sr_alocuidador.models.PacienteMedicamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteMedicamentoDAO {
    
    private PacienteDAO daoPaciente;
    
    public PacienteMedicamentoDAO(){
        daoPaciente = new PacienteDAO();
    }
    
    private void incluir(PacienteMedicamento c) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO CLIENTES_MEDICAMENTOS (IDCLIENTE, DESCRICAO, DOSAGEM, ");
        sql.append("HORARIO, APRAZAMENTO, OBSERVACAO, PRESCRITOR, TURNO) VALUES ");
        sql.append("(?, ?, ?, ?, ?, ?, ?, ?)");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, c.getPaciente().getCodigo());
        pst.setString(2, c.getDescricao());
        pst.setString(3, c.getDosagem());
        pst.setString(4, c.getHorario());
        pst.setString(5, c.getAprazamento());
        pst.setString(6, c.getObservacao());
        pst.setString(7, c.getPrescritor());
        pst.setInt(8, c.getTurno().getIndice());
        pst.execute();
        
    }
    
    private void alterar(PacienteMedicamento c) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE CLIENTES_MEDICAMENTOS SET IDCLIENTE = ?, DESCRICAO = ?, DOSAGEM = ?, ");
        sql.append("HORARIO = ?, APRAZAMENTO = ?, OBSERVACAO = ?, PRESCRITOR = ?, TURNO = ? ");
        sql.append("WHERE IDCLIMEDICAMENTO = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, c.getPaciente().getCodigo());
        pst.setString(2, c.getDescricao());
        pst.setString(3, c.getDosagem());
        pst.setString(4, c.getHorario());
        pst.setString(5, c.getAprazamento());
        pst.setString(6, c.getObservacao());
        pst.setString(7, c.getPrescritor());
        pst.setInt(8, c.getTurno().getIndice());
        pst.setInt(9, c.getCodigo());
        pst.execute();
        
    }
    
    public void excluir(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM CLIENTES_MEDICAMENTOS WHERE IDCLIMEDICAMENTO = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        pst.execute();
        
    }
    
    private boolean existeRegistro(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM CLIENTES_MEDICAMENTOS WHERE IDCLIMEDICAMENTO = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery();
        return rs.next();
        
    }
    
    public void validaDados(PacienteMedicamento c) throws SQLException{
        
        if (existeRegistro(c.getCodigo())){
            alterar(c);
        } else {
            incluir(c);
        }
        
    }
    
    public PacienteMedicamento buscarPorId(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM CLIENTES_MEDICAMENTOS WHERE IDCLIMEDICAMENTO = ? ORDER BY TURNO");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery();
        PacienteMedicamento p = null;
        ConstantesItemDAO daoConstanteItem = new ConstantesItemDAO();
        while(rs.next()){
            p = new PacienteMedicamento();
            p.setCodigo(rs.getInt("IDCLIMEDICAMENTO"));
            p.setPaciente(daoPaciente.buscarPorId(rs.getInt("IDCLIENTE")));
            p.setDescricao(rs.getString("DESCRICAO"));
            p.setDosagem(rs.getString("DOSAGEM"));
            p.setHorario(rs.getString("HORARIO"));
            p.setAprazamento(rs.getString("APRAZAMENTO"));
            p.setObservacao(rs.getString("OBSERVACAO"));
            p.setPrescritor(rs.getString("PRESCRITOR"));
            p.setTurno(daoConstanteItem.buscarPorId(30, rs.getInt("TURNO")));
        }
        return p;
        
    }
    
    public List<PacienteMedicamento> listarMedicamentosPorPaciente(int paciente) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM CLIENTES_MEDICAMENTOS WHERE IDCLIENTE = ? ORDER BY TURNO");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, paciente);
        ResultSet rs = pst.executeQuery();
        List<PacienteMedicamento> lista = new ArrayList<>();
        ConstantesItemDAO daoConstanteItem = new ConstantesItemDAO();
        while(rs.next()){
            PacienteMedicamento p = new PacienteMedicamento();
            p.setCodigo(rs.getInt("IDCLIMEDICAMENTO"));
            p.setPaciente(daoPaciente.buscarPorId(rs.getInt("IDCLIENTE")));
            p.setDescricao(rs.getString("DESCRICAO"));
            p.setDosagem(rs.getString("DOSAGEM"));
            p.setHorario(rs.getString("HORARIO"));
            p.setAprazamento(rs.getString("APRAZAMENTO"));
            p.setObservacao(rs.getString("OBSERVACAO"));
            p.setPrescritor(rs.getString("PRESCRITOR"));
            p.setTurno(daoConstanteItem.buscarPorId(30, rs.getInt("TURNO")));
            lista.add(p);
        }
        return lista;
        
    }
    
}
