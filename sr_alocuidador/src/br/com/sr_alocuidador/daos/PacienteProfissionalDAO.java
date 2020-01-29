package br.com.sr_alocuidador.daos;

import br.com.sr_alocuidador.conexao.Conexao;
import br.com.sr_alocuidador.models.PacienteProfissional;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteProfissionalDAO {
    
    private static void incluir(PacienteProfissional c) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO CLIENTES_PROFISSIONAL (IDCLIENTE, DESCRICAO, ESPECIALIDADE, ");
        sql.append("CONTATOS, EMAIL, CELULAR, REGISTRO) VALUES (?, ?, ?, ?, ?, ?, ?)");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, c.getPaciente().getCodigo());
        pst.setString(2, c.getDescricao());
        pst.setString(3, c.getEspecialidade());
        pst.setString(4, c.getContato());
        pst.setString(5, c.getEmail());
        pst.setString(6, c.getCelular());
        pst.setString(7, c.getRegistro());
        pst.execute();
        
    }
    
    private static void alterar(PacienteProfissional c) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE CLIENTES_PROFISSIONAL SET IDCLIENTE = ?, DESCRICAO = ?, ESPECIALIDADE = ?, ");
        sql.append("CONTATOS = ?, EMAIL = ?, CELULAR = ?, REGISTRO = ? WHERE IDCLIPROFISSIONAL = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, c.getPaciente().getCodigo());
        pst.setString(2, c.getDescricao());
        pst.setString(3, c.getEspecialidade());
        pst.setString(4, c.getContato());
        pst.setString(5, c.getEmail());
        pst.setString(6, c.getCelular());
        pst.setString(7, c.getRegistro());
        pst.setInt(8, c.getCodigo());
        pst.execute();
        
    }
    
    public static void excluir(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM CLIENTES_PROFISSIONAL WHERE IDCLIPROFISSIONAL = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        pst.execute();
        
    }
    
    private static boolean existeRegistro(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM CLIENTES_PROFISSIONAL WHERE IDCLIPROFISSIONAL = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery(); 
        return rs.next();
        
    }
    
    public static void validaDados(PacienteProfissional c) throws SQLException{
        if (existeRegistro(c.getCodigo()))
            alterar(c);
        else
            incluir(c);
    }
    
    public static PacienteProfissional buscarPorId(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM CLIENTES_PROFISSIONAL WHERE IDCLIPROFISSIONAL = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery(); 
        PacienteProfissional c = null;
        while(rs.next()){
            c = new PacienteProfissional();
            c.setCodigo(rs.getInt("IDCLIPROFISSIONAL"));
            c.setPaciente(PacienteDAO.buscarPorId(rs.getInt("IDCLIENTE")));
            c.setDescricao(rs.getString("DESCRICAO"));
            c.setEspecialidade(rs.getString("ESPECIALIDADE"));
            c.setContato(rs.getString("CONTATOS"));
            c.setEmail(rs.getString("EMAIL"));
            c.setCelular(rs.getString("CELULAR"));
            c.setRegistro(rs.getString("REGISTRO"));
        }
        return c;
        
    }
    
    public static List<PacienteProfissional> listarDados(int paciente) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM CLIENTES_PROFISSIONAL WHERE IDCLIENTE = ? ORDER BY IDCLIPROFISSIONAL");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, paciente);
        ResultSet rs = pst.executeQuery(); 
        List<PacienteProfissional> lista = new ArrayList<>();
        while(rs.next()){
            PacienteProfissional c = new PacienteProfissional();
            c.setCodigo(rs.getInt("IDCLIPROFISSIONAL"));
            c.setPaciente(PacienteDAO.buscarPorId(rs.getInt("IDCLIENTE")));
            c.setDescricao(rs.getString("DESCRICAO"));
            c.setEspecialidade(rs.getString("ESPECIALIDADE"));
            c.setContato(rs.getString("CONTATOS"));
            c.setEmail(rs.getString("EMAIL"));
            c.setCelular(rs.getString("CELULAR"));
            c.setRegistro(rs.getString("REGISTRO"));
            lista.add(c);
        }
        return lista;
        
    }
    
}
