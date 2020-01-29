package br.com.sr_alocuidador.daos;

import br.com.sr_alocuidador.conexao.Conexao;
import br.com.sr_alocuidador.models.PacienteCuidador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteCuidadorDAO {
    
    private void incluir(PacienteCuidador c) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO CLIENTES_CUIDADOR (IDCLIENTE, NOME, DTNASC, CSTSEXO, CSTESTCIVIL, ENDERECO, BAIRRO, CIDADE, UF, CEP");
        sql.append(", CONTATOS, PARENTESCO, EMAIL, CELULAR, SITUACAOTRAB) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?");
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
        pst.setInt(12, c.getParentesco());
        pst.setString(13, c.getEmail());
        pst.setString(14, c.getTelefonecelular());
        pst.setInt(15, c.getSituacao());
        pst.execute();
        pst.close();
        
    }
    
    private void alterar(PacienteCuidador c) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE CLIENTES_CUIDADOR SET IDCLIENTE = ?, NOME = ?, DTNASC = ?, CSTSEXO = ?, CSTESTCIVIL = ?, ENDERECO = ?, BAIRRO = ?, CIDADE = ?, UF = ?, CEP = ?");
        sql.append(", CONTATOS = ?, PARENTESCO = ?, EMAIL = ?, CELULAR = ?, SITUACAOTRAB = ? WHERE IDCLICUIDADOR = ?");
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
        pst.setInt(12, c.getParentesco());
        pst.setString(13, c.getEmail());
        pst.setString(14, c.getTelefonecelular());
        pst.setInt(15, c.getSituacao());
        pst.setInt(16, c.getCodigo());
        pst.execute();
        pst.close();
        
    }
    
    public void excluir(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM CLIENTES_CUIDADOR WHERE IDCLICUIDADOR = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        pst.execute();
        pst.close();
        
    }
    
    private boolean existeRegistro(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM CLIENTES_CUIDADOR WHERE IDCLICUIDADOR = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        ResultSet rs =  pst.executeQuery();
        return rs.next();
        
    }
    
    public void validaDados(PacienteCuidador c) throws SQLException{
        
        if (existeRegistro(c.getCodigo()))
            alterar(c);
        else
            incluir(c);
        
    }
    
    public PacienteCuidador buscarPorId(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT CC.*, (SELECT GP.NOME FROM CONSTANTES_ITEM GP WHERE GP.IDCONSTANTE = 28 AND INDICE = CC.PARENTESCO) AS GRAUPARENTESCO FROM CLIENTES_CUIDADOR CC WHERE CC.IDCLICUIDADOR = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        ResultSet rs =  pst.executeQuery();
        PacienteCuidador pce = null;
        while(rs.next()){
            pce = new PacienteCuidador();
            pce.setCodigo(rs.getInt("IDCLICUIDADOR"));
            pce.setPaciente(rs.getInt("IDCLIENTE"));
            pce.setNome(rs.getString("NOME"));
            pce.setNascimento(rs.getString("DTNASC"));
            pce.setSexo(rs.getInt("CSTSEXO"));
            pce.setEstcivil(rs.getInt("CSTESTCIVIL"));
            pce.setEndereco(rs.getString("ENDERECO"));
            pce.setBairro(rs.getString("BAIRRO"));
            pce.setCidade(rs.getString("CIDADE"));
            pce.setUf(rs.getString("UF"));
            pce.setCep(rs.getString("CEP"));
            pce.setTelefonefixo(rs.getString("CONTATOS"));
            pce.setParentesco(rs.getInt("PARENTESCO"));
            pce.setNmparentesco(rs.getString("GRAUPARENTESCO"));
            pce.setEmail(rs.getString("EMAIL"));
            pce.setTelefonecelular(rs.getString("CELULAR"));
            pce.setSituacao(rs.getInt("SITUACAOTRAB"));
        }
        return pce;
        
    }
    
    public List<PacienteCuidador> listarCuidadores(int paciente){
        
        StringBuilder sql = new StringBuilder();
        List<PacienteCuidador> lista = new ArrayList<>();
        sql.append("SELECT CC.*, (SELECT GP.NOME FROM CONSTANTES_ITEM GP WHERE GP.IDCONSTANTE = 28 AND INDICE = CC.PARENTESCO) AS GRAUPARENTESCO FROM CLIENTES_CUIDADOR CC WHERE CC.IDCLIENTE = ?");
        PreparedStatement pst;
        try {
            pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
            pst.setInt(1, paciente);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                PacienteCuidador pce = new PacienteCuidador();
                pce.setCodigo(rs.getInt("IDCLICUIDADOR"));
                pce.setNome(rs.getString("NOME"));
                pce.setPaciente(rs.getInt("IDCLIENTE"));  
                pce.setParentesco(rs.getInt("PARENTESCO"));
                pce.setNmparentesco(rs.getString("GRAUPARENTESCO"));
                lista.add(pce);
            }            
        } catch (SQLException ex) {
            return null;
        }
        return lista;
    }
    
}
