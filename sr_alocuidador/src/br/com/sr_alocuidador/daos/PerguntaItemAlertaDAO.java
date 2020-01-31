package br.com.sr_alocuidador.daos;

import br.com.sr_alocuidador.conexao.Conexao;
import br.com.sr_alocuidador.models.PerguntaItemAlerta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PerguntaItemAlertaDAO {
    
    private final PerguntaItemDAO daoPerguntaItem;
    
    public PerguntaItemAlertaDAO(){
        daoPerguntaItem = new PerguntaItemDAO();
    }
    
    
    private void incluir(PerguntaItemAlerta p) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO PERGUNTAS_ITEM_ALERTA (IDPERGITEM, NOME) VALUES (?, ?)");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, p.getPerguntaitem().getCodigo());
        pst.setString(2, p.getNome());
        pst.execute();
        
    }
    
    private void alterar(PerguntaItemAlerta p) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE PERGUNTAS_ITEM_ALERTA SET IDPERGITEM = ?, NOME = ? WHERE IDPERGITEMALERTA = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, p.getPerguntaitem().getCodigo());
        pst.setString(2, p.getNome());
        pst.setInt(3, p.getCodigo());
        pst.execute();
        
    }
    
    public void excluir(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM PERGUNTAS_ITEM_ALERTA IDPERGITEMALERTA = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        pst.execute();
        
    }
    
    public boolean existeRegistro(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM PERGUNTAS_ITEM_ALERTA WHERE IDPERGITEMALERTA = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery();
        return rs.next();
        
    }
    
    public void validaDados(PerguntaItemAlerta p) throws SQLException{
        if (existeRegistro(p.getCodigo()))
            alterar(p);
        else
            incluir(p);
    }
    
    public PerguntaItemAlerta buscarPorId(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM PERGUNTAS_ITEM_ALERTA WHERE IDPERGITEMALERTA = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery();
        PerguntaItemAlerta p = null;
        while(rs.next()){
            p = new PerguntaItemAlerta();
            p.setCodigo(rs.getInt("IDPERGITEMALERTA"));
            p.setPerguntaitem(daoPerguntaItem.BuscarPorId(rs.getInt("IDPERGITEM")));
            p.setNome(rs.getString("NOME"));            
        }
        return p;
        
    }
    
    
    public List<PerguntaItemAlerta> listarAlertasPorItem(int item) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM PERGUNTAS_ITEM_ALERTA WHERE IDPERGITEM = ? ORDER BY IDPERGITEMALERTA");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, item);
        ResultSet rs = pst.executeQuery();
        List<PerguntaItemAlerta> lista = new ArrayList<>();
        while(rs.next()){
            PerguntaItemAlerta p = new PerguntaItemAlerta();
            p.setCodigo(rs.getInt("IDPERGITEMALERTA"));
            p.setPerguntaitem(daoPerguntaItem.BuscarPorId(rs.getInt("IDPERGITEM")));
            p.setNome(rs.getString("NOME"));
            lista.add(p);
        }
        return lista;
        
    }    
    
}
