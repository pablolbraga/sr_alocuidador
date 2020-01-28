package br.com.sr_alocuidador.daos;

import br.com.sr_alocuidador.conexao.Conexao;
import br.com.sr_alocuidador.models.PacienteResponsavel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteResponsavelDAO {
    
    private static void incluir(PacienteResponsavel c) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO CLIENTES_RESPONSAVEL (IDCLIENTE, NOME, DTNASC, CSTSEXO, CSTESTCIVIL, ENDERECO, BAIRRO, CIDADE, UF, CEP");
        sql.append(", CONTATOS, EMAIL, CELULAR) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, c.getPaciente());
        pst.setString(2, c.getNome());
        pst.setString(3, c.getNascimento());
        pst.setInt(4, c.getSexo());
        pst.setInt(5, c.getEstcivil());
        pst.setString(6, c.getEndereco());
        pst.setString(7, c.getBairro());
        pst.setString(8, c.getCidade());
        pst.setString(9, c.getUf());
        pst.setString(10, c.getCep());
        pst.setString(11, c.getTelefonefixo());
        pst.setString(12, c.getEmail());
        pst.setString(13, c.getTelefonecelular());
        pst.execute();
        
    }
    
    private static void alterar(PacienteResponsavel c) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE CLIENTES_RESPONSAVEL SET IDCLIENTE = ?, NOME = ?, DTNASC = ?, CSTSEXO = ?, CSTESTCIVIL = ?, ENDERECO = ?, BAIRRO = ?, CIDADE = ?, UF = ?, CEP = ?");
        sql.append(", CONTATOS = ?, EMAIL = ?, CELULAR = ? WHERE IDCLIRESPONSAVEL = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, c.getPaciente());
        pst.setString(2, c.getNome());
        pst.setString(3, c.getNascimento());
        pst.setInt(4, c.getSexo());
        pst.setInt(5, c.getEstcivil());
        pst.setString(6, c.getEndereco());
        pst.setString(7, c.getBairro());
        pst.setString(8, c.getCidade());
        pst.setString(9, c.getUf());
        pst.setString(10, c.getCep());
        pst.setString(11, c.getTelefonefixo());
        pst.setString(12, c.getEmail());
        pst.setString(13, c.getTelefonecelular());
        pst.setInt(14, c.getCodigo());
        pst.execute();
        
    }
    
    public static void excluir(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM CLIENTES_RESPONSAVEL WHERE IDCLIRESPONSAVEL = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        pst.execute();
    }
    
    private static boolean existeRegistro(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM CLIENTES_RESPONSAVEL WHERE IDCLIRESPONSAVEL = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        ResultSet rs =  pst.executeQuery();
        return rs.next();
        
    }
    
    public static void validaDados(PacienteResponsavel c) throws SQLException{
        if (existeRegistro(c.getCodigo()))
            alterar(c);
        else
            incluir(c);
    }
    
    public static PacienteResponsavel buscarPorId(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT CC.* FROM CLIENTES_RESPONSAVEL CC WHERE CC.IDCLIRESPONSAVEL = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        ResultSet rs =  pst.executeQuery();
        PacienteResponsavel pce = null;
        while(rs.next()){
            pce = new PacienteResponsavel();
            pce.setCodigo(rs.getInt("IDCLIRESPONSAVEL"));
            pce.setPaciente(rs.getInt("IDCLIENTE"));
            pce.setNome(rs.getString("NOME"));
            pce.setNascimento(rs.getString("DTNASC") == null ? "" : rs.getString("DTNASC"));
            pce.setSexo(rs.getInt("CSTSEXO"));
            pce.setEstcivil(rs.getInt("CSTESTCIVIL"));
            pce.setEndereco(rs.getString("ENDERECO"));
            pce.setBairro(rs.getString("BAIRRO"));
            pce.setCidade(rs.getString("CIDADE"));
            pce.setUf(rs.getString("UF"));
            pce.setCep(rs.getString("CEP"));
            pce.setTelefonefixo(rs.getString("CONTATOS"));
            pce.setEmail(rs.getString("EMAIL"));
            pce.setTelefonecelular(rs.getString("CELULAR"));
        }
        return pce;
        
    }
    
    public static List<PacienteResponsavel> listarCuidadores(int paciente){
        
        StringBuilder sql = new StringBuilder();
        List<PacienteResponsavel> lista = new ArrayList<>();
        sql.append("SELECT CC.* FROM CLIENTES_RESPONSAVEL CC WHERE CC.IDCLIENTE = ?");
        PreparedStatement pst;
        try {
            pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
            pst.setInt(1, paciente);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                PacienteResponsavel pce = new PacienteResponsavel();
                pce.setCodigo(rs.getInt("IDCLIRESPONSAVEL"));
                pce.setNome(rs.getString("NOME"));
                pce.setPaciente(rs.getInt("IDCLIENTE"));  
                lista.add(pce);
            }            
        } catch (SQLException ex) {
            return null;
        }
        return lista;
    }
    
}
