package br.com.sr_alocuidador.daos;

import br.com.sr_alocuidador.conexao.Conexao;
import br.com.sr_alocuidador.models.PacienteCategoriaPergunta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteCategoriaPerguntaDAO {
    
    private CategoriaPerguntaDAO daoCategPergunta;
    private PacienteDAO daoPaciente;
    
    public PacienteCategoriaPerguntaDAO(){
        daoCategPergunta = new CategoriaPerguntaDAO();
        daoPaciente = new PacienteDAO();
    }
    
    private void incluir(PacienteCategoriaPergunta c) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO CLIENTES_PERGCATEG (IDCLIENTE, IDPERGCATEG, SEQ) VALUES (?, ?, ?)");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, c.getPaciente().getCodigo());
        pst.setInt(2, c.getCategoriapergunta().getCodigo());
        pst.setInt(3, c.getSequencia());
        pst.execute();
        
    }
    
    private void alterar(PacienteCategoriaPergunta c) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE CLIENTES_PERGCATEG SET IDCLIENTE = ?, IDPERGCATEG = ?, SEQ = ? WHERE IDCLIPERGCATEG = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, c.getPaciente().getCodigo());
        pst.setInt(2, c.getCategoriapergunta().getCodigo());
        pst.setInt(3, c.getSequencia());
        pst.setInt(4, c.getCodigo());
        pst.execute();
        
    }
    
    public void excluir(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM CLIENTES_PERGCATEG WHERE ID = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        pst.execute();
        
    }
    
    private boolean existeRegistro(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM CLIENTES_PERGCATEG CC WHERE CC.ID = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery();
        return rs.next();
        
    }
    
    public void validaDados(PacienteCategoriaPergunta c) throws SQLException{
        if (existeRegistro(c.getCodigo())){
            alterar(c);
        } else {
            incluir(c);
        }
    }
    
    public PacienteCategoriaPergunta buscarPorId(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT CPC.*, PC.NOME AS NMPERGCATEG FROM CLIENTES_PERGCATEG CPC INNER JOIN PERGUNTAS_CATEGORIA PC ON PC.IDPERGCATEG = CPC.IDPERGCATEG WHERE CPC.IDCLIPERGCATEG = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery();
        PacienteCategoriaPergunta c = null;
        while(rs.next()){
            c = new PacienteCategoriaPergunta();
            c.setCodigo(rs.getInt("IDCLIPERGCATEG"));
            c.setPaciente(daoPaciente.buscarPorId(rs.getInt("IDCLIENTE")));
            c.setCategoriapergunta(daoCategPergunta.BuscarPorId(rs.getInt("IDPERGCATEG")));
            c.setSequencia(rs.getInt("SEQ"));
        }
        return c;
        
    }
    
    public List<PacienteCategoriaPergunta> listarCategoriasPorPaciente(int paciente) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT CPC.*, PC.NOME AS NMPERGCATEG FROM CLIENTES_PERGCATEG CPC INNER JOIN PERGUNTAS_CATEGORIA PC ON PC.IDPERGCATEG = CPC.IDPERGCATEG WHERE CPC.IDCLIENTE = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, paciente);
        ResultSet rs = pst.executeQuery();
        List<PacienteCategoriaPergunta> lista = new ArrayList<>();
        while(rs.next()){
            PacienteCategoriaPergunta c = new PacienteCategoriaPergunta();
            c.setCodigo(rs.getInt("IDCLIPERGCATEG"));
            c.setPaciente(daoPaciente.buscarPorId(rs.getInt("IDCLIENTE")));
            c.setCategoriapergunta(daoCategPergunta.BuscarPorId(rs.getInt("IDPERGCATEG")));
            c.setSequencia(rs.getInt("SEQ"));
            lista.add(c);
        }
        return lista;
        
    }
    
}
