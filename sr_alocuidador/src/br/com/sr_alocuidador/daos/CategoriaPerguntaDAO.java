package br.com.sr_alocuidador.daos;

import br.com.sr_alocuidador.conexao.Conexao;
import br.com.sr_alocuidador.models.CategoriaPergunta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaPerguntaDAO {
    
    private void incluir(CategoriaPergunta c) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO PERGUNTAS_CATEGORIA (NOME) VALUES (?)");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setString(1, c.getNome());
        pst.execute();                
        
    }
    
    private void alterar(CategoriaPergunta c) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE PERGUNTAS_CATEGORIA SET NOME = ? WHERE IDPERGCATEG = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setString(1, c.getNome());
        pst.setInt(2, c.getCodigo());
        pst.execute();                
        
    }
    
    public void excluir(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM PERGUNTAS_CATEGORIA WHERE IDPERGCATEG = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        pst.execute();   
        
    }
    
    private boolean existeRegistro(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM PERGUNTAS_CATEGORIA WHERE IDPERGCATEG = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery();
        return rs.next();
        
    }
    
    public void validaDados(CategoriaPergunta c) throws SQLException{
        
        if (existeRegistro(c.getCodigo())){
            alterar(c);
        } else {
            incluir(c);
        }
        
    }
    
    public CategoriaPergunta BuscarPorId(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM PERGUNTAS_CATEGORIA WHERE IDPERGCATEG = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery();
        CategoriaPergunta p = null;
        while(rs.next()){
            p = new CategoriaPergunta();
            p.setCodigo(rs.getInt("IDPERGCATEG"));
            p.setNome(rs.getString("NOME"));
        }
        return p;
    }
    
    public List<CategoriaPergunta> listarTodos() throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM PERGUNTAS_CATEGORIA ORDER BY NOME");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        ResultSet rs = pst.executeQuery();
        List<CategoriaPergunta> lista = new ArrayList<>();
        while(rs.next()){
            CategoriaPergunta c = new CategoriaPergunta();
            c.setCodigo(rs.getInt("IDPERGCATEG"));
            c.setNome(rs.getString("NOME"));
            lista.add(c);
        }
        return lista;
        
    }
    
}
