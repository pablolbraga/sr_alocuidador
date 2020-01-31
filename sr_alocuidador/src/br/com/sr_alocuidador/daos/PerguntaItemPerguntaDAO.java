package br.com.sr_alocuidador.daos;

import br.com.sr_alocuidador.conexao.Conexao;
import br.com.sr_alocuidador.models.PerguntaItemPergunta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PerguntaItemPerguntaDAO {
    
    private final PerguntaDAO daoPergunta;
    private final CategoriaPerguntaDAO daoCategoriaPergunta;
    
    public PerguntaItemPerguntaDAO(){
        daoPergunta = new PerguntaDAO();
        daoCategoriaPergunta = new CategoriaPerguntaDAO();
    }
    
    public void incluir(int pergitem, int pergunta) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO PERGUNTAS_ITEM_SUBPERGUNTA (IDPERGITEM, IDSUBPERGUNTA) VALUES (?, ?)");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, pergitem);
        pst.setInt(2, pergunta);
        pst.execute();
        
    }
    
    public void excluir(int pergitem) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM PERGUNTAS_ITEM_SUBPERGUNTA WHERE IDPERGITEM = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, pergitem);
        pst.execute();
        
    }
    
    public List<PerguntaItemPergunta> listarPerguntas(String destino, int pergitem) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT DISTINCT P.*, PC.NOME AS NMPERGCATEG, (CASE WHEN PIS.IDSUBPERGUNTA IS NULL THEN 'N' ELSE 'S' END) AS EXISTE ");
        sql.append("FROM PERGUNTAS P INNER JOIN PERGUNTAS_CATEGORIA PC ON PC.IDPERGCATEG = P.IDPERGCATEG INNER JOIN PERGUNTAS_ITEM PI ON PI.IDPERGUNTA = P.IDPERGUNTA ");
        sql.append("LEFT JOIN PERGUNTAS_ITEM_SUBPERGUNTA PIS ON PIS.IDSUBPERGUNTA = P.IDPERGUNTA AND PIS.IDPERGITEM = ? ");
        sql.append("WHERE P.DESTINO = ? ORDER BY PC.NOME, P.NOME");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, pergitem);
        pst.setString(2, destino);
        ResultSet rs = pst.executeQuery();
        List<PerguntaItemPergunta> lista = new ArrayList<>();
        while(rs.next()){
            PerguntaItemPergunta p = new PerguntaItemPergunta();
            p.setPergunta(daoPergunta.BuscarPorId( rs.getInt("IDPERGUNTA")) );
            p.setPerguntacategoria(daoCategoriaPergunta.BuscarPorId(rs.getInt("IDPERGCATEG")));
            p.setDestino(rs.getString("DESTINO"));
            p.setExiste(rs.getString("EXISTE"));
            lista.add(p);
        }
        return lista;
        
    }
    
}
