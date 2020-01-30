package br.com.sr_alocuidador.daos;

import br.com.sr_alocuidador.conexao.Conexao;
import br.com.sr_alocuidador.helpers.Uteis;
import br.com.sr_alocuidador.models.Usuario;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    
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
    
}
