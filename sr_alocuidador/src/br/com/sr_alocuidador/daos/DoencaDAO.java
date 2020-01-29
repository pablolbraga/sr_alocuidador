/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sr_alocuidador.daos;

import br.com.sr_alocuidador.conexao.Conexao;
import br.com.sr_alocuidador.models.Doenca;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author plima
 */
public class DoencaDAO {
    
    private CategoriaDoencaDAO daoCategDoenca = null;
    
    public DoencaDAO(){
        daoCategDoenca = new CategoriaDoencaDAO();
    }
    
    private void Incluir(Doenca c) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO DOENCAS (IDDOENCACATEG,DESCRICAO) VALUES (?, ?)");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, c.getCategoriadoenca().getCodigo());
        pst.setString(2, c.getNome());
        pst.execute();
        pst.close();
        
    }
    
    private void Alterar(Doenca c) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE DOENCAS SET IDDOENCACATEG = ?, DESCRICAO = ? WHERE IDDOENCA = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, c.getCategoriadoenca().getCodigo());
        pst.setString(2, c.getNome());
        pst.setInt(3, c.getCodigo());
        pst.execute();
        pst.close();
        
    }
    
    public void Excluir(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM DOENCAS WHERE IDDOENCA = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        pst.execute();
        pst.close();
        
    }
    
    private boolean ExisteRegistro(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM DOENCAS WHERE IDDOENCA = ?");        
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery();
        return rs.next();
        
    }
    
    public void ValidaDados(Doenca c) throws SQLException{
        
        if (ExisteRegistro(c.getCodigo()))
            Alterar(c);
        else
            Incluir(c);
        
    }
    
    public Doenca BuscarPorId(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();        
        Doenca c = null;
        sql.append("SELECT * FROM DOENCAS WHERE IDDOENCA = ?");
        try (PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString())) {
            pst.setInt(1, codigo);
            ResultSet rs = pst.executeQuery();
            if (rs.next()){
                c = new Doenca();
                c.setCodigo(codigo);
                c.setCategoriadoenca(daoCategDoenca.BuscarPorId(rs.getInt("IDDOENCACATEG")));
                c.setNome(rs.getString("DESCRICAO"));
            }
        }
        return c;
        
    }
    
    public List<Doenca> ListarTodos(int categoria) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM DOENCAS WHERE 1 = 1");
        if (categoria > 0)
            sql.append(" AND IDDOENCACATEG = ?");
        sql.append(" ORDER BY DESCRICAO");        
        List<Doenca> lista;
        try (PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString())) {
            if (categoria > 0)
                pst.setInt(1, categoria);
            ResultSet rs = pst.executeQuery();
            lista = new ArrayList<>();
            while(rs.next()){
                Doenca c = new Doenca();
                c.setCodigo(rs.getInt("IDDOENCA"));
                c.setCategoriadoenca(daoCategDoenca.BuscarPorId(rs.getInt("IDDOENCACATEG")));
                c.setNome(rs.getString("DESCRICAO"));
                lista.add(c);
            }
        }
        return lista;
        
    }
    
}
