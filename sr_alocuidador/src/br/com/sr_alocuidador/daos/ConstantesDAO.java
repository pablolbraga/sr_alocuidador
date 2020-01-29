package br.com.sr_alocuidador.daos;

import br.com.sr_alocuidador.conexao.Conexao;
import br.com.sr_alocuidador.models.Constantes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConstantesDAO {
    
    public Constantes buscarPorId(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM CONSTANTES WHERE IDCONSTANTE = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery();
        Constantes c = null;
        while(rs.next()){
            c = new Constantes();
            c.setCodigo(rs.getInt("IDCONSTANTE"));
            c.setNome(rs.getString("NOME"));
        }
        return c;
        
    }
    
}
