package br.com.sr_alocuidador.daos;

import br.com.sr_alocuidador.conexao.Conexao;
import br.com.sr_alocuidador.models.PacienteCirurgia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteCirurgiaDAO {
    
    private PacienteDAO daoPaciente;
    
    public PacienteCirurgiaDAO(){
        daoPaciente = new PacienteDAO();
    }
    
    private void incluir(PacienteCirurgia c) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO CLIENTES_CIRURGIAS (IDCLIENTE, DESCRICAO, TIPO) ");
        sql.append("VALUES (?, ?, ?)");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, c.getPaciente().getCodigo());
        pst.setString(2, c.getDescricao());
        pst.setString(3, c.getTipo());
        pst.execute();
        pst.close();
        
    }
    
    private void alterar(PacienteCirurgia c) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE CLIENTES_CIRURGIAS SET IDCLIENTE = ?, DESCRICAO = ?, TIPO = ? WHERE IDCLICIR = ? ");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, c.getPaciente().getCodigo());
        pst.setString(2, c.getDescricao());
        pst.setString(3, c.getTipo());
        pst.setInt(4, c.getCodigo());
        pst.execute();
        pst.close();
        
    }
    
    public void excluir(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM CLIENTES_CIRURGIAS WHERE IDCLICIR = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        pst.execute();
        pst.close();
        
    }
    
    private boolean existeRegistro(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM CLIENTES_CIRURGIAS CC WHERE CC.IDCLICIR = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery();
        return rs.next();
        
    }
    
    public void validaDados(PacienteCirurgia c) throws SQLException{
        if (existeRegistro(c.getCodigo())){
            alterar(c);
        } else {
            incluir(c);
        }
    }
    
    public PacienteCirurgia buscarPorId(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM CLIENTES_CIRURGIAS WHERE IDCLICIR = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery();
        PacienteCirurgia c = null;
        while(rs.next()){
            c = new PacienteCirurgia();
            c.setCodigo(rs.getInt("IDCLICIR"));
            c.setPaciente(daoPaciente.buscarPorId( rs.getInt("IDCLIENTE")) );
            c.setDescricao(rs.getString("DESCRICAO"));
            c.setTipo(rs.getString("TIPO"));
        }
        return c;
        
    }
    
    public List<PacienteCirurgia> listarServicosPorPaciente(int paciente) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM CLIENTES_CIRURGIAS WHERE IDCLIENTE = ? ORDER BY IDCLICIR");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, paciente);
        ResultSet rs = pst.executeQuery();
        List<PacienteCirurgia> lista = new ArrayList<>();
        while(rs.next()){
            PacienteCirurgia c = new PacienteCirurgia();
            c.setCodigo(rs.getInt("IDCLICIR"));
            c.setPaciente(daoPaciente.buscarPorId( rs.getInt("IDCLIENTE")) );
            c.setDescricao(rs.getString("DESCRICAO"));
            c.setTipo(rs.getString("TIPO"));
            lista.add(c);
        }
        return lista;
        
    }
    
}
