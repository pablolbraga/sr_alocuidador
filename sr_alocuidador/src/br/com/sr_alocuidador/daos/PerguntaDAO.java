package br.com.sr_alocuidador.daos;

import br.com.sr_alocuidador.conexao.Conexao;
import br.com.sr_alocuidador.models.Pergunta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PerguntaDAO {
    
    private CategoriaPerguntaDAO daoCategPergunta;
    
    public PerguntaDAO(){
        daoCategPergunta = new CategoriaPerguntaDAO();
    }

    private void incluir(Pergunta c) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO PERGUNTAS (IDPERGCATEG, NOME, DESTINO) VALUES (?, ?, ?)");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, c.getCategoria().getCodigo());
        pst.setString(2, c.getNome());
        pst.setString(3, c.getDestino());
        pst.execute();
        pst.close();
        
    }
    
    private void alterar(Pergunta c) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE PERGUNTAS SET IDPERGCATEG = ?, NOME = ?, DESTINO = ? WHERE IDPERGUNTA = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, c.getCategoria().getCodigo());
        pst.setString(2, c.getNome());
        pst.setString(3, c.getDestino());
        pst.setInt(4, c.getCodigo());
        pst.execute();
        pst.close();
        
    }
    
    public void excluir(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM PERGUNTAS WHERE IDPERGUNTA = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        pst.execute();
        pst.close();
        
    }
    
    private boolean existeRegistro(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM PERGUNTAS WHERE IDPERGUNTA = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery();
        return rs.next();
        
    }
    
    public void validaDados(Pergunta p) throws SQLException{
        if (existeRegistro(p.getCodigo()))
            alterar(p);
        else
            incluir(p);
    }
    
    public List<Pergunta> BuscarSubPergunta(int item) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT p.*, pc.nome as nmpergcateg FROM perguntas_item_subpergunta pis "
                + "inner join perguntas p on p.idpergunta = pis.IDSUBPERGUNTA "
                + "inner join perguntas_categoria pc on pc.IDPERGCATEG = p.IDPERGCATEG "
                + "where pis.idpergitem = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, item);
        ResultSet rs = pst.executeQuery();
        List<Pergunta> lista = new ArrayList<>();
        while(rs.next()){
            Pergunta p = new Pergunta();
            p.setCodigo(rs.getInt("IDPERGUNTA"));
            p.setCategoria(daoCategPergunta.BuscarPorId(rs.getInt("IDPERGCATEG")));
            p.setNome(rs.getString("NOME"));
            p.setDestino(rs.getString("DESTINO"));
            lista.add(p);
        }
        return lista;
        
    }    
    
    public Pergunta BuscarPorId(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT P.*, pc.nome as nmpergcateg FROM PERGUNTAS P "
                + "inner join perguntas_categoria pc on pc.IDPERGCATEG = p.IDPERGCATEG  "
                + "WHERE IDPERGUNTA = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery();
        Pergunta p = null;
        while(rs.next()){
            p = new Pergunta();
            p.setCodigo(rs.getInt("IDPERGUNTA"));
            p.setCategoria(daoCategPergunta.BuscarPorId(rs.getInt("IDPERGCATEG")));
            p.setNome(rs.getString("NOME"));
            p.setDestino(rs.getString("DESTINO"));
        }
        return p;
    }
    
    public List<Pergunta> ListarTodos(int categoria, String descricao) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT P.*, pc.nome as nmpergcateg FROM PERGUNTAS P "
                + "inner join perguntas_categoria pc on pc.IDPERGCATEG = p.IDPERGCATEG  "
                + "WHERE 1 = 1 ");
        if (categoria > 0)
            sql.append("AND P.IDPERGCATEG = ? ");
        if (!"".equals(descricao)){
            sql.append("AND P.NOME LIKE ? ");
        }
        
        sql.append("ORDER BY PC.NOME, P.NOME");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        int sequencia = 0;
        if (categoria > 0){
            sequencia++;
            pst.setInt(sequencia, categoria);
        }            
        if (!"".equals(descricao)){
            sequencia++;
            pst.setString(sequencia, "%" + descricao + "%");
        }
        ResultSet rs = pst.executeQuery();
        List<Pergunta> lista = new ArrayList<>();
        while(rs.next()){
            Pergunta p = new Pergunta();
            p.setCodigo(rs.getInt("IDPERGUNTA"));
            p.setCategoria(daoCategPergunta.BuscarPorId(rs.getInt("IDPERGCATEG")));
            p.setNome(rs.getString("NOME"));
            p.setDestino(rs.getString("DESTINO"));
            lista.add(p);
        }
        return lista;
    }
    
}
