package br.com.sr_alocuidador.daos;

import br.com.sr_alocuidador.conexao.Conexao;
import br.com.sr_alocuidador.models.Paciente;
import br.com.sr_alocuidador.models.PacienteVacina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteVacinaDAO {
    
    private static void incluir(PacienteVacina c) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO CLIENTES_VACINA (IDCLIENTE, IDVACINA, DATA, LOCAL, OBSERVACAO) ");
        sql.append("VALUES (?, ?, ?, ?, ?)");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, c.getPaciente().getCodigo());
        pst.setInt(2, c.getVacina().getCodigo());
        pst.setString(3, c.getData());
        pst.setString(4, c.getLocal());
        pst.setString(5, c.getObservacao());
        pst.execute();
        
    }
    
    private static void alterar(PacienteVacina c) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE CLIENTES_VACINA SET IDCLIENTE = ?, IDVACINA = ?, DATA = ?, LOCAL = ?, OBSERVACAO = ? WHERE ID = ? ");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, c.getPaciente().getCodigo());
        pst.setInt(2, c.getVacina().getCodigo());
        pst.setString(3, c.getData());
        pst.setString(4, c.getLocal());
        pst.setString(5, c.getObservacao());
        pst.setInt(6, c.getCodigo());
        pst.execute();
        
    }
    
    public static void excluir(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM CLIENTES_VACINA WHERE IDCLIINTER = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        pst.execute();
        
    }
    
    private static boolean existeRegistro(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM CLIENTES_VACINA CC WHERE CC.IDCLIINTER = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery();
        return rs.next();
        
    }
    
    public static void validaDados(PacienteVacina c) throws SQLException{
        if (existeRegistro(c.getCodigo())){
            alterar(c);
        } else {
            incluir(c);
        }
    }
    
    public static PacienteVacina buscarPorId(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT cv.*, c.nome as nmpaciente, v.nome as nmvacina FROM alocuidador.clientes_vacina cv ");
        sql.append("inner join clientes c on c.IDCLIENTE = cv.IDCLIENTE inner join vacinas v on v.IDVACINA = cv.IDVACINA ");
        sql.append("WHERE CV.ID = ? ");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery();
        PacienteVacina c = null;
        while(rs.next()){
            c = new PacienteVacina();
            c.setCodigo(rs.getInt("ID"));
            c.setPaciente(PacienteDAO.buscarPorId( rs.getInt("IDCLIENTE")) );
            c.setVacina(VacinaDAO.buscarPorId(rs.getInt("IDVACINA")));
            c.setData(rs.getString("DATA"));
            c.setLocal(rs.getString("LOCAL"));
            c.setObservacao(rs.getString("OBSERVACAO"));
        }
        return c;
        
    }
    
    public static List<PacienteVacina> listarVacinasPorPaciente(int paciente) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT cv.*, c.nome as nmpaciente, v.nome as nmvacina FROM alocuidador.clientes_vacina cv ");
        sql.append("inner join clientes c on c.IDCLIENTE = cv.IDCLIENTE inner join vacinas v on v.IDVACINA = cv.IDVACINA ");
        sql.append("WHERE CV.IDCLIENTE = ? ORDER BY CV.DATA");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, paciente);
        ResultSet rs = pst.executeQuery();
        List<PacienteVacina> lista = new ArrayList<>();
        while(rs.next()){
            PacienteVacina c = new PacienteVacina();
            c.setCodigo(rs.getInt("ID"));
            c.setPaciente(PacienteDAO.buscarPorId( rs.getInt("IDCLIENTE")) );
            c.setVacina(VacinaDAO.buscarPorId(rs.getInt("IDVACINA")));
            c.setData(rs.getString("DATA"));
            c.setLocal(rs.getString("LOCAL"));
            c.setObservacao(rs.getString("OBSERVACAO"));
            lista.add(c);
        }
        return lista;
        
    }
    
    public static List<Paciente> listarPacientesPorVacina(String vacinas, int qtde, int convenio) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT J.IDCLIENTE, J.NMCLIENTE, J.IDCONVENIO, COUNT(J.IDCLIENTE) AS QTDE FROM (");
        sql.append("SELECT CD.*, C.NOME AS NMCLIENTE, CV.IDCONVENIO FROM CLIENTES_VACINA CD ");
        sql.append("INNER JOIN CLIENTES C ON C.IDCLIENTE = CD.IDCLIENTE AND C.STATUS = 'A' ");
        sql.append("INNER JOIN CONVENIOS CV ON CV.IDCONVENIO = C.IDCONVENIO ");
        if (convenio > 0)
            sql.append("AND CV.IDCONVENIO = ").append(Integer.toString(convenio)).append(" ");
        sql.append("WHERE CD.IDVACINA IN (").append(vacinas).append(") ");
        sql.append(") J GROUP BY J.IDCLIENTE, J.NMCLIENTE, J.IDCONVENIO HAVING COUNT(J.IDCLIENTE) = ? ");
        sql.append("ORDER BY J.NMCLIENTE");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, qtde);
        ResultSet rs = pst.executeQuery();
        List<Paciente> lista = new ArrayList<>();
        while(rs.next()){
            Paciente c = new Paciente();
            c.setCodigo(rs.getInt("IDCLIENTE"));
            c.setNome(rs.getString("NMCLIENTE"));
            c.setConvenio(ConvenioDAO.buscarPorId(rs.getInt("IDCONVENIO")));
            lista.add(c);
        }
        return lista;
        
    }
    
}
