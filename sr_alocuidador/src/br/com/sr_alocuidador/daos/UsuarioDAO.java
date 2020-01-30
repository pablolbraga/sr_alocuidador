package br.com.sr_alocuidador.daos;

import br.com.sr_alocuidador.conexao.Conexao;
import br.com.sr_alocuidador.helpers.Uteis;
import br.com.sr_alocuidador.models.Usuario;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    
    private void incluir(Usuario c) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO USUARIOS (NOME, EMAIL, LOGIN, STATUS, ALERTA, NOVASENHA, PESQ_SAT_TI, PROFMEDICO, LACE, ADM) ");
        sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setString(1, c.getNome());
        pst.setString(2, c.getEmail());
        pst.setString(3, c.getLogin());
        pst.setString(4, "A");
        pst.setString(5, c.getAlerta());
        pst.setString(6, "N");
        pst.setInt(7, c.getPesqsatisfacao());
        pst.setString(8, c.getProfmedico());
        pst.setString(9, c.getLace());
        pst.setString(10, c.getAdministrador());
        pst.execute();
    }
    
    private void alterar(Usuario c) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE USUARIOS SET NOME = ?, EMAIL = ?, LOGIN = ?, STATUS = ?, ALERTA = ?, NOVASENHA = ?, ");
        sql.append("PESQ_SAT_TI = ?, PROFMEDICO = ?, LACE = ?, ADM = ? WHERE IDUSUARIO = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setString(1, c.getNome());
        pst.setString(2, c.getEmail());
        pst.setString(3, c.getLogin());
        pst.setString(4, "A");
        pst.setString(5, c.getAlerta());
        pst.setString(6, "N");
        pst.setInt(7, c.getPesqsatisfacao());
        pst.setString(8, c.getProfmedico());
        pst.setString(9, c.getLace());
        pst.setString(10, c.getAdministrador());
        pst.setInt(11, c.getCodigo());
        pst.execute();
    }
    
    public void excluir(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE USUARIOS SET STATUS = ? WHERE IDUSUARIO = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setString(1, "I");
        pst.setInt(2, codigo);
        pst.execute();
        
    }
    
    private boolean existeRegistro(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM USUARIOS WHERE IDUSUARIO = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery();
        return  rs.next();
        
    }
    
    public void validaDados(Usuario u) throws SQLException{
        
        if (existeRegistro(u.getCodigo()))
            alterar(u);
        else
            incluir(u);
        
    }
    
    public List<Usuario> listarTodos() throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM USUARIOS WHERE STATUS = 'A' ORDER BY NOME");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        ResultSet rs = pst.executeQuery();
        List<Usuario> lista = new ArrayList<>();
        while(rs.next()){
            Usuario c = new Usuario();
            c.setCodigo(rs.getInt("IDUSUARIO"));
            c.setNome(rs.getString("NOME"));
            c.setLogin(rs.getString("LOGIN"));
            c.setEmail(rs.getString("EMAIL"));
            c.setAlerta(rs.getString("ALERTA"));
            c.setPesqsatisfacao(rs.getInt("PESQ_SAT_TI"));
            c.setProfmedico(rs.getString("PROFMEDICO"));
            c.setLace(rs.getString("LACE"));
            c.setAdministrador(rs.getString("ADM"));
            lista.add(c);
        }
        return lista;
    }
    
    public Usuario buscarPorId(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM USUARIOS WHERE IDUSUARIO = ? AND STATUS = 'A'");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery();
        Usuario usuario = null;
        while(rs.next()){
            usuario = new Usuario();
            usuario.setCodigo(rs.getInt("IDUSUARIO"));
            usuario.setNome(rs.getString("NOME"));
            usuario.setLogin(rs.getString("LOGIN"));
            usuario.setEmail(rs.getString("EMAIL"));
            usuario.setSenha(rs.getString("SENHA2"));
            usuario.setAlerta(rs.getString("ALERTA"));
            usuario.setPesqsatisfacao(rs.getInt("PESQ_SAT_TI"));
            usuario.setProfmedico(rs.getString("PROFMEDICO"));
            usuario.setLace(rs.getString("LACE"));
            usuario.setAdministrador(rs.getString("ADM"));
        }
        return usuario;
        
    }
    
    public Usuario retornarUsuarioPorLoginSenha(String login, String senha) throws SQLException, NoSuchAlgorithmException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM USUARIOS WHERE LOGIN = ? AND UPPER(SENHA2) = ? AND STATUS = 'A'");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setString(1, login);
        pst.setString(2, Uteis.criptografia(senha.toUpperCase()));
        ResultSet rs = pst.executeQuery();
        Usuario usuario = null;
        while(rs.next()){
            usuario = new Usuario();
            usuario.setCodigo(rs.getInt("IDUSUARIO"));
            usuario.setNome(rs.getString("NOME"));
            usuario.setLogin(rs.getString("LOGIN"));
            usuario.setEmail(rs.getString("EMAIL"));
            usuario.setSenha(rs.getString("SENHA2"));
            usuario.setAlerta(rs.getString("ALERTA"));
            usuario.setPesqsatisfacao(rs.getInt("PESQ_SAT_TI"));
            usuario.setProfmedico(rs.getString("PROFMEDICO"));
            usuario.setLace(rs.getString("LACE"));
            usuario.setAdministrador(rs.getString("ADM"));
        }
        return usuario;
        
    }
    
    public Usuario buscarPorLogin(String login) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM USUARIOS WHERE LOGIN = ? AND STATUS = 'A'");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setString(1, login);
        ResultSet rs = pst.executeQuery();
        Usuario u = null;
        while(rs.next()){
            u = new Usuario();
            u.setCodigo(rs.getInt("IDUSUARIO"));
            u.setNome(rs.getString("NOME"));
            u.setLogin(rs.getString("LOGIN"));
            u.setEmail(rs.getString("EMAIL"));
            u.setSenha(rs.getString("SENHA2"));
            u.setAdministrador(rs.getString("ADM"));
        }
        return u;                
        
    }
    
    public void alterarNovaSenha(String login, String senha) throws SQLException, NoSuchAlgorithmException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE USUARIOS SET SENHA2 = ? WHERE LOGIN = ? AND STATUS = 'A'");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setString(2, login);
        pst.setString(1, Uteis.criptografia(senha));
        pst.execute();
        
    }
    
    public void alterarNovaSenhaPorId(int codigo, String senha) throws SQLException, NoSuchAlgorithmException{
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE USUARIOS SET SENHA2 = ? WHERE IDUSUARIO = ? AND STATUS = 'A'");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(2, codigo);
        pst.setString(1, Uteis.criptografia(senha.toUpperCase()));
        pst.execute();
    }
    
    
}
