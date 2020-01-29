package br.com.sr_alocuidador.daos;

import br.com.sr_alocuidador.conexao.Conexao;
import br.com.sr_alocuidador.models.Hospital;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HospitalDAO {
        
    private void incluir(Hospital c) throws SQLException{
        
        String sqlInserir = "INSERT INTO HOSPITAIS (NOME, ENDERECO, BAIRRO, CIDADE, UF, CEP, CONTATOS) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sqlInserir);
        pst.setString(1, c.getNome());
        pst.setString(2, c.getEndereco());
        pst.setString(3, c.getBairro());
        pst.setString(4, c.getCidade());
        pst.setString(5, c.getUf());
        pst.setString(6, c.getCep());
        pst.setString(7, c.getContato());
        pst.execute();
        
    }
    
    private void alterar(Hospital c) throws SQLException{
        
        String sqlAlterar = "UPDATE HOSPITAIS SET NOME = ?, ENDERECO = ?, BAIRRO = ?, CIDADE = ?, UF = ?, CEP = ?, CONTATOS = ? WHERE IDHOSPITAL = ?";    
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sqlAlterar);
        pst.setString(1, c.getNome());
        pst.setString(2, c.getEndereco());
        pst.setString(3, c.getBairro());
        pst.setString(4, c.getCidade());
        pst.setString(5, c.getUf());
        pst.setString(6, c.getCep());
        pst.setString(7, c.getContato());
        pst.setInt(8, c.getCodigo());
        pst.execute();
        
    }
    
    public void excluir(int codigo) throws SQLException{
        
        String sqlExcluir = "DELETE FROM HOSPITAIS WHERE IDHOSPITAL = ?";
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sqlExcluir);
        pst.setInt(1, codigo);
        pst.execute();
        
    }
    
    private boolean existeRegistro(int codigo) throws SQLException{
        
        String sqlBuscarPorId = "SELECT * FROM HOSPITAIS WHERE IDHOSPITAL = ?";
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sqlBuscarPorId);
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery();
        return rs.next();
        
    }
    
    public void validaDados(Hospital c) throws SQLException{
        if (existeRegistro(c.getCodigo())){
            alterar(c);
        } else {
            incluir(c);
        }
    }
    
    public Hospital buscarPorId(int codigo) throws SQLException{
        
        String sqlBuscarPorId = "SELECT * FROM HOSPITAIS WHERE IDHOSPITAL = ?";
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sqlBuscarPorId);
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery();
        Hospital c = null;
        while (rs.next()){
            c = new Hospital();
            c.setCodigo(rs.getInt("IDHOSPITAL"));
            c.setNome(rs.getString("NOME"));
            c.setEndereco(rs.getString("ENDERECO"));
            c.setBairro(rs.getString("BAIRRO"));
            c.setCidade(rs.getString("CIDADE"));
            c.setUf(rs.getString("UF"));
            c.setCep(rs.getString("CEP"));
            c.setContato(rs.getString("CONTATOS"));
        }
        return c;
        
    }
    
    public List<Hospital> listarHospital(String filtro) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM HOSPITAIS WHERE 1 = 1 ");
        if (!"".equals(filtro)){
            sql.append("AND NOME LIKE '%" + filtro + "%' ");
        }
        sql.append("ORDER BY NOME");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        ResultSet rs = pst.executeQuery();
        List<Hospital> lista = new ArrayList<>();
        while(rs.next()){
            Hospital c = new Hospital();
            c.setCodigo(rs.getInt("IDHOSPITAL"));
            c.setNome(rs.getString("NOME"));
            c.setEndereco(rs.getString("ENDERECO"));
            c.setBairro(rs.getString("BAIRRO"));
            c.setCidade(rs.getString("CIDADE"));
            c.setUf(rs.getString("UF"));
            c.setCep(rs.getString("CEP"));
            c.setContato(rs.getString("CONTATOS"));
            lista.add(c);
        }
        return lista;
        
    }
    
}
