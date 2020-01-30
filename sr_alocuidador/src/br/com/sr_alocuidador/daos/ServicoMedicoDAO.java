package br.com.sr_alocuidador.daos;

import br.com.sr_alocuidador.conexao.Conexao;
import br.com.sr_alocuidador.models.ServicoMedico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicoMedicoDAO {
        
    private void incluir(ServicoMedico c) throws SQLException{
        
        String sqlInserir = "INSERT INTO SERVICOS (NOME) VALUES (?)";
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sqlInserir);
        pst.setString(1, c.getNome());
        pst.execute();
        
    }
    
    private void alterar(ServicoMedico c) throws SQLException{
        
        String sqlAlterar = "UPDATE SERVICOS SET NOME = ? WHERE ID = ?";
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sqlAlterar);
        pst.setString(1, c.getNome());
        pst.setInt(2, c.getCodigo());
        pst.execute();
        
    }
    
    public void excluir(int codigo) throws SQLException{
        
        String sqlExcluir = "DELETE FROM SERVICOS WHERE ID = ?";
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sqlExcluir);
        pst.setInt(1, codigo);
        pst.execute();
        
    }
    
    private boolean existeRegistro(int codigo) throws SQLException{
        
        String sqlBuscarPorId = "SELECT * FROM SERVICOS WHERE ID = ?";
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sqlBuscarPorId);
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery();
        return rs.next();
        
    }
    
    public void validaDados(ServicoMedico c) throws SQLException{
        if (existeRegistro(c.getCodigo())){
            alterar(c);
        } else {
            incluir(c);
        }
    }
    
    public ServicoMedico buscarPorId(int codigo) throws SQLException{
        
        String sqlBuscarPorId = "SELECT * FROM SERVICOS WHERE ID = ?";
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sqlBuscarPorId);
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery();
        ServicoMedico c = null;
        while (rs.next()){
            c = new ServicoMedico();
            c.setCodigo(rs.getInt("ID"));
            c.setNome(rs.getString("NOME"));
        }
        return c;
        
    }
    
    public List<ServicoMedico> listarServicoMedico(String filtro) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM SERVICOS WHERE 1 = 1 ");
        if (!"".equals(filtro)){
            sql.append("AND NOME LIKE '%" + filtro + "%' ");
        }
        sql.append("ORDER BY NOME");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        ResultSet rs = pst.executeQuery();
        List<ServicoMedico> lista = new ArrayList<>();
        while(rs.next()){
            ServicoMedico c = new ServicoMedico();
            c.setCodigo(rs.getInt("ID"));
            c.setNome(rs.getString("NOME"));
            lista.add(c);
        }
        return lista;
        
    }
    
}
