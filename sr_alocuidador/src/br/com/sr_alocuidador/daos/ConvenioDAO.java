package br.com.sr_alocuidador.daos;

import br.com.sr_alocuidador.conexao.Conexao;
import br.com.sr_alocuidador.models.Convenio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConvenioDAO {
    
    public Convenio buscarPorId(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM CONVENIOS WHERE IDCONVENIO = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        Convenio c = null;
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            c = new Convenio();
            c.setCodigo(rs.getInt("IDCONVENIO"));
            c.setCnpj(rs.getString("CNPJ"));
            c.setInscricaoestadual(rs.getString("IE"));
            c.setRazaosocial(rs.getString("RZSOCIAL"));
            c.setNomefantasia(rs.getString("NMFANTASIA"));
            c.setEndereco(rs.getString("ENDERECO"));
            c.setBairro(rs.getString("BAIRRO"));
            c.setCidade(rs.getString("CIDADE"));
            c.setUf(rs.getString("UF"));
            c.setCep(rs.getString("CEP"));
            c.setContatos(rs.getString("CONTATOS"));   
            c.setVrcobranca(rs.getDouble("VRCOBRANCA"));
        }
        return c;
        
    }
    
    public List<Convenio> listarTodos(String nome) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM CONVENIOS WHERE 1 = 1 ");
        if (!"".equals(nome)){
            sql.append("AND (UPPER(RZSOCIAL) LIKE ? OR UPPER(NMFANTASIA) LIKE ? OR CNPJ = ?) ");
        }
        sql.append("ORDER BY RZSOCIAL");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        if (!"".equals(nome)){
            pst.setString(1, "%" + nome.toUpperCase() + "%");
            pst.setString(2, "%" + nome.toUpperCase() + "%");
            pst.setString(3, nome);
        }
        ResultSet rs = pst.executeQuery();
        List<Convenio> lista = new ArrayList<>();
        while(rs.next()){
            Convenio c = new Convenio();
            c.setCodigo(rs.getInt("IDCONVENIO"));
            c.setCnpj(rs.getString("CNPJ"));
            c.setInscricaoestadual(rs.getString("IE"));
            c.setRazaosocial(rs.getString("RZSOCIAL"));
            c.setNomefantasia(rs.getString("NMFANTASIA"));
            c.setEndereco(rs.getString("ENDERECO"));
            c.setBairro(rs.getString("BAIRRO"));
            c.setCidade(rs.getString("CIDADE"));
            c.setUf(rs.getString("UF"));
            c.setCep(rs.getString("CEP"));
            c.setContatos(rs.getString("CONTATOS"));   
            c.setVrcobranca(rs.getDouble("VRCOBRANCA"));
            lista.add(c);
        }
        return lista;
    }
    
}
