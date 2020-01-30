package br.com.sr_alocuidador.daos;

import br.com.sr_alocuidador.conexao.Conexao;
import br.com.sr_alocuidador.models.PerguntaItem;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PerguntaItemDAO {
    
    private PerguntaDAO daoPergunta;
    
    public PerguntaItemDAO(){
        daoPergunta = new PerguntaDAO();
    }
    
    private void incluir(PerguntaItem p) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO PERGUNTAS_ITEM (IDPERGUNTA, NOME, ALERTA, OPCAO) VALUES (?, ?, ?, ?)");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, p.getPergunta().getCodigo());
        pst.setString(2, p.getNome());
        pst.setString(3, p.getAlerta());
        pst.setString(4, p.getOpcao());
        pst.execute();
        pst.close();
        
    }
    
    private void alterar(PerguntaItem p) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE PERGUNTAS_ITEM SET IDPERGUNTA = ?, NOME = ?, ALERTA = ?, OPCAO = ? WHERE IDPERGITEM = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, p.getPergunta().getCodigo());
        pst.setString(2, p.getNome());
        pst.setString(3, p.getAlerta());
        pst.setString(4, p.getOpcao());
        pst.setInt(5, p.getCodigo());
        pst.execute();
        pst.close();
        
    }
    
    public void excluir(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM PERGUNTAS_ITEM WHERE IDPERGITEM = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        pst.execute();
        pst.close();
        
    }
    
    private boolean existeRegistro(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM PERGUNTAS_ITEM PI WHERE PI.IDPERGITEM = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery();
        return rs.next();
        
    }
    
    public void validaDados(PerguntaItem p) throws SQLException{
        
        if (existeRegistro(p.getCodigo()))
            alterar(p);
        else
            incluir(p);
        
    }
    
    public PerguntaItem BuscarPorId(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM PERGUNTAS_ITEM PI WHERE PI.IDPERGITEM = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery();
        PerguntaItem p = null;
        while(rs.next()){
            p = new PerguntaItem();
            p.setCodigo(rs.getInt("IDPERGITEM"));
            p.setPergunta(daoPergunta.BuscarPorId(rs.getInt("IDPERGUNTA")));
            p.setNome(rs.getString("NOME"));
            p.setAlerta(rs.getString("ALERTA"));
            p.setOpcao(rs.getString("OPCAO"));
        }
        return p;
    }
    
    public List<PerguntaItem> ListarDados(int pergunta) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM PERGUNTAS_ITEM WHERE IDPERGUNTA = ? ORDER BY IDPERGITEM");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, pergunta);
        ResultSet rs = pst.executeQuery();
        List<PerguntaItem> lista = new ArrayList<>();
        while(rs.next()){
            PerguntaItem p = new PerguntaItem();
            p.setCodigo(rs.getInt("IDPERGITEM"));
            p.setPergunta(daoPergunta.BuscarPorId(rs.getInt("IDPERGUNTA")));
            p.setNome(rs.getString("NOME"));
            p.setAlerta(rs.getString("ALERTA"));
            p.setOpcao(rs.getString("OPCAO"));
            lista.add(p);
        }
        return lista;
        
    }
    
}
