package br.com.sr_alocuidador.daos;

import br.com.sr_alocuidador.conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PacienteInternacaoDAO {
    
    public static int retornarUltimoIndiceLace(int paciente) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM CLIENTES_INTERNACAO WHERE STATUS_LACE = 'F' AND IDCLIENTE = ? ORDER BY IDCLIINTER DESC LIMIT 1 ");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, paciente);
        ResultSet rs = pst.executeQuery();
        if (rs.next()){
            return rs.getInt("INDICE_LACE");
        } else {
            return 0;
        }
        
    }
    
}
