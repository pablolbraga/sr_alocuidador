package br.com.sr_alocuidador.daos;

import br.com.sr_alocuidador.conexao.Conexao;
import br.com.sr_alocuidador.models.Vacina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VacinaDAO {
    
    private final String sqlInserir = "INSERT INTO VACINAS (NOME) VALUES (?)";
    private final String sqlAlterar = "UPDATE VACINAS SET NOME = ? WHERE IDVACINA = ?";
    private final String sqlExcluir = "DELETE FROM VACINAS WHERE IDVACINA = ?";
    
    private void incluir(Vacina c) throws SQLException{
        
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sqlInserir);
        pst.setString(1, c.getNome());
        pst.execute();
        
    }
    
    private void alterar(Vacina c) throws SQLException{
        
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sqlAlterar);
        pst.setString(1, c.getNome());
        pst.setInt(2, c.getCodigo());
        pst.execute();
        
    }
    
    public void excluir(int codigo) throws SQLException{
        
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sqlExcluir);
        pst.setInt(1, codigo);
        pst.execute();
        
    }
    
    private boolean existeRegistro(int codigo) throws SQLException{
        
        String sqlBuscarPorId = "SELECT * FROM VACINAS WHERE IDVACINA = ?";
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sqlBuscarPorId);
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery();
        return rs.next();
        
    }
    
    public void validaDados(Vacina c) throws SQLException{
        if (existeRegistro(c.getCodigo())){
            alterar(c);
        } else {
            incluir(c);
        }
    }
    
    public static Vacina buscarPorId(int codigo) throws SQLException{
        
        String sqlBuscarPorId = "SELECT * FROM VACINAS WHERE IDVACINA = ?";
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sqlBuscarPorId);
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery();
        Vacina c = null;
        while (rs.next()){
            c = new Vacina();
            c.setCodigo(rs.getInt("IDVACINA"));
            c.setNome(rs.getString("NOME"));
        }
        return c;
        
    }
    
    public static List<Vacina> listarVacinas(String filtro) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM VACINAS WHERE 1 = 1 ");
        if (!"".equals(filtro)){
            sql.append("AND NOME LIKE '%" + filtro + "%' ");
        }
        sql.append("ORDER BY NOME");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        ResultSet rs = pst.executeQuery();
        List<Vacina> lista = new ArrayList<>();
        while(rs.next()){
            Vacina c = new Vacina();
            c.setCodigo(rs.getInt("IDVACINA"));
            c.setNome(rs.getString("NOME"));
            lista.add(c);
        }
        return lista;
        
    }
    
}
