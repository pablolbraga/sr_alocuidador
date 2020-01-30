package br.com.sr_alocuidador.daos;

import br.com.sr_alocuidador.conexao.Conexao;
import br.com.sr_alocuidador.models.LigacaoItem;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LigacaoItemDAO {
    
    private LigacaoProgramadaDAO daoLigacao;
    private PerguntaItemDAO daoPerguntaItem;
    
    public LigacaoItemDAO(){
        daoLigacao = new LigacaoProgramadaDAO();
    }
    
    public void incluir(LigacaoItem li) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO LIGACOES_ITEM (IDLIGACAO, IDPERGITEM, OBSERVACAO) VALUES (?, ?, ?)");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setString(1, li.getLigacao().getIdligacao());
        pst.setInt(2, li.getPergitem().getCodigo());
        pst.setString(3, li.getObservacao());
        pst.execute();
        
    }
    
    public void excluirItensPorLigacao(String ligacao) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM LIGACOES_ITEM WHERE IDLIGACAO = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setString(1, ligacao);
        pst.execute();
        
    }
    
    public List<LigacaoItem> listarItensRespondidos(String ligacao) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT LI.*, PI.NOME AS NMRESPOSTA, P.NOME AS NMPERGUNTA FROM LIGACOES_ITEM LI ");
        sql.append("INNER JOIN PERGUNTAS_ITEM PI ON PI.IDPERGITEM = LI.IDPERGITEM ");
        sql.append("INNER JOIN PERGUNTAS P ON P.IDPERGUNTA = PI.IDPERGUNTA WHERE LI.IDLIGACAO = ? ORDER BY LI.ID");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setString(1, ligacao);
        ResultSet rs = pst.executeQuery();
        List<LigacaoItem> lista = new ArrayList<>();
        while(rs.next()){
            LigacaoItem li = new LigacaoItem();
            li.setLigacao(daoLigacao.buscarPorId(rs.getString("IDLIGACAO")));
            li.setPergitem(daoPerguntaItem.BuscarPorId(rs.getInt("IDPERGITEM")));
            li.setObservacao(rs.getString("OBSERVACAO"));
            li.setNmresposta(rs.getString("NMRESPOSTA"));
            lista.add(li);
        }
        return lista;
        
    }
    
}
