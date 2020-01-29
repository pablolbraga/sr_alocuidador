/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sr_alocuidador.daos;

import br.com.sr_alocuidador.conexao.Conexao;
import br.com.sr_alocuidador.models.CategoriaDoenca;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author plima
 */
public class CategoriaDoencaDAO{
    
    private static void Incluir(CategoriaDoenca c) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO DOENCAS_CATEGORIA (DESCRICAO) VALUES (?)");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setString(1, c.getNome());
        pst.execute();
        pst.close();
        
    }
    
    private static void Alterar(CategoriaDoenca c) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE DOENCAS_CATEGORIA SET DESCRICAO = ? WHERE IDDOENCACATEG = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setString(1, c.getNome());
        pst.setInt(2, c.getCodigo());
        pst.execute();
        pst.close();
        
    }
    
    public static void Excluir(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM DOENCAS_CATEGORIA WHERE IDDOENCACATEG = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        pst.execute();
        pst.close();
        
    }
    
    private static boolean ExisteRegistro(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM DOENCAS_CATEGORIA WHERE IDDOENCACATEG = ?");        
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery();
        return rs.next();
        
    }
    
    public static void ValidaDados(CategoriaDoenca c) throws SQLException{
        
        if (ExisteRegistro(c.getCodigo()))
            Alterar(c);
        else
            Incluir(c);
        
    }
    
    public static CategoriaDoenca BuscarPorId(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();        
        CategoriaDoenca c = null;
        sql.append("SELECT * FROM DOENCAS_CATEGORIA WHERE IDDOENCACATEG = ?");
        try (PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString())) {
            pst.setInt(1, codigo);
            ResultSet rs = pst.executeQuery();
            if (rs.next()){
                c = new CategoriaDoenca();
                c.setCodigo(codigo);
                c.setNome(rs.getString("DESCRICAO"));
            }
        }
;
        return c;
        
    }
    
    public static List<CategoriaDoenca> ListarTodos() throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM DOENCAS_CATEGORIA ORDER BY DESCRICAO");
        List<CategoriaDoenca> lista;
        try (PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString())) {
            ResultSet rs = pst.executeQuery();
            lista = new ArrayList<>();
            while(rs.next()){
                CategoriaDoenca c = new CategoriaDoenca();
                c.setCodigo(rs.getInt("IDDOENCACATEG"));
                c.setNome(rs.getString("DESCRICAO"));
                lista.add(c);
            }
        }
        return lista;
        
    }
    
}
