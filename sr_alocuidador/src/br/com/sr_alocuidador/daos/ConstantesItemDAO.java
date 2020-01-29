package br.com.sr_alocuidador.daos;

import br.com.sr_alocuidador.conexao.Conexao;
import br.com.sr_alocuidador.models.ConstantesItem;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConstantesItemDAO {
    
    private final ConstantesDAO daoConstante;
    
    public ConstantesItemDAO(){
        daoConstante = new ConstantesDAO();
    }
    
    public List<ConstantesItem> listarContantes(int constante) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM CONSTANTES_ITEM WHERE IDCONSTANTE = ? ORDER BY INDICE");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, constante);
        ResultSet rs = pst.executeQuery();
        List<ConstantesItem> lista = new ArrayList<>();
        while(rs.next()){
            ConstantesItem c = new ConstantesItem();
            c.setCodigo(rs.getInt("IDCONSTANTEITEM"));
            c.setConstante(daoConstante.buscarPorId(rs.getInt("IDCONSTANTE")));
            c.setNome(rs.getString("NOME"));
            c.setIndice(rs.getInt("INDICE"));
            lista.add(c);
        }
        return lista;
    }
    
    public ConstantesItem buscarPorId(int constante, int indice) throws SQLException{
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM CONSTANTES_ITEM WHERE IDCONSTANTE = ? AND INDICE = ? ORDER BY INDICE");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, constante);
        pst.setInt(2, indice);
        ResultSet rs = pst.executeQuery();
        ConstantesItem c = null;
        while(rs.next()){
            c = new ConstantesItem();
            c.setCodigo(rs.getInt("IDCONSTANTEITEM"));
            c.setConstante(daoConstante.buscarPorId(rs.getInt("IDCONSTANTE")));
            c.setNome(rs.getString("NOME"));
            c.setIndice(rs.getInt("INDICE"));            
        }
        return c;
    }
    
}
