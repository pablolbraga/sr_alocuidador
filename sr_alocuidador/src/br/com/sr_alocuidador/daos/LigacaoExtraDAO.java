package br.com.sr_alocuidador.daos;

import br.com.sr_alocuidador.conexao.Conexao;
import br.com.sr_alocuidador.helpers.Uteis;
import br.com.sr_alocuidador.models.LigacaoExtra;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LigacaoExtraDAO {
    
    private final PacienteDAO daoPaciente;
    private final UsuarioDAO daoUsuario;
    
    public LigacaoExtraDAO(){
        daoPaciente = new PacienteDAO();
        daoUsuario = new UsuarioDAO();
    }
    
    public void incluir(LigacaoExtra c) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO LIGACOES_EXTRAS (IDCLIENTE, DATA, MOTIVO, DESCRICAO, IDUSUARIO, ATENDENTE, TIPO) VALUES (?, ?, ?, ?, ?, ?, ?)");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, c.getPaciente().getCodigo());
        pst.setString(2, c.getData());
        pst.setString(3, c.getMotivo());
        pst.setString(4, c.getDescricao());
        pst.setInt(5, c.getUsuario().getCodigo());
        pst.setString(6, c.getAtendente());
        pst.setString(7, c.getTipo());
        pst.execute();
        pst.close();
        
    }
    
    public void excluir(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM LIGACOES_EXTRAS WHERE IDLIGACAOEXTRA = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        pst.execute();
        pst.close();
        
    }
    
    public LigacaoExtra buscarPorId(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT LE.*, C.NOME AS NMCLIENTE, U.NOME AS NMUSUARIO FROM LIGACOES_EXTRAS LE INNER JOIN CLIENTES C ON C.IDCLIENTE = LE.IDCLIENTE INNER JOIN USUARIOS U ON U.IDUSUARIO = LE.IDUSUARIO ");
        sql.append("WHERE LE.IDLIGACAOEXTRA = ? ORDER BY LE.DATA");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery();
        LigacaoExtra c = null;
        while(rs.next()){
            c = new LigacaoExtra();
            c.setCodigo(rs.getInt("IDLIGACAOEXTRA"));
            c.setPaciente(daoPaciente.buscarPorId( rs.getInt("IDCLIENTE")) );
            c.setData(rs.getString("DATA"));
            c.setMotivo(rs.getString("MOTIVO"));
            c.setDescricao(rs.getString("DESCRICAO"));
            c.setUsuario(daoUsuario.buscarPorId( rs.getInt("IDUSUARIO")) );
            c.setAtendente(rs.getString("ATENDENTE"));
            c.setTipo(rs.getString("TIPO"));
        }
        return c;
    }
    
    public List<LigacaoExtra> listarPorPaciente(int paciente) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT LE.*, C.NOME AS NMCLIENTE, U.NOME AS NMUSUARIO FROM LIGACOES_EXTRAS LE INNER JOIN CLIENTES C ON C.IDCLIENTE = LE.IDCLIENTE INNER JOIN USUARIOS U ON U.IDUSUARIO = LE.IDUSUARIO ");
        sql.append("WHERE LE.IDCLIENTE = ? ORDER BY LE.DATA");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, paciente);
        ResultSet rs = pst.executeQuery();
        List<LigacaoExtra> lista = new ArrayList<>();
        while(rs.next()){
            LigacaoExtra c = new LigacaoExtra();
            c.setCodigo(rs.getInt("IDLIGACAOEXTRA"));
            c.setPaciente(daoPaciente.buscarPorId( rs.getInt("IDCLIENTE")) );
            c.setData(rs.getString("DATA"));
            c.setMotivo(rs.getString("MOTIVO"));
            c.setDescricao(rs.getString("DESCRICAO"));
            c.setUsuario(daoUsuario.buscarPorId( rs.getInt("IDUSUARIO")) );
            c.setAtendente(rs.getString("ATENDENTE"));
            c.setTipo(rs.getString("TIPO"));
            lista.add(c);
        }
        return lista;
    }
    
    public List<LigacaoExtra> listarTodos(int paciente, int convenio, String periodoini, String periodofim) throws SQLException{
        
        int seq = 0;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT le.*, c.nome as nmcliente, c.idconvenio, cv.nmfantasia as nmconvenio, u.nome as nmusuario, ");
        sql.append("(CASE LE.TIPO WHEN 'RET' THEN 'RETORNO' WHEN 'INT' THEN 'INTERNAÇÃO' WHEN 'DEP' THEN 'DEPRESSÃO' WHEN 'HIP' THEN 'HIPERTENSÃO' WHEN 'DIA' THEN 'DIABETES' ELSE '' END) AS NMSTATUS, ");
        sql.append("TIMEDIFF(le.dt_atend_fim, le.dt_atend_ini) as dif ");
        sql.append("from ligacoes_extras le inner join clientes c on c.idcliente = le.idcliente ");
        sql.append("inner join convenios cv on cv.idconvenio = c.idconvenio inner join usuarios u on u.idusuario = le.idusuario ");
        sql.append("where 1 = 1 ");
        if (paciente > 0){
            seq = seq + 1;
            sql.append("and c.idcliente = ? ");
        }
        if (convenio > 0){
            seq = seq + 1;
            sql.append("and cv.idconvenio = ? ");
        }
        if (!"".equals(periodoini)){
            seq = seq + 1;
            sql.append("and le.data >= ? ");
        }
        if (!"".equals(periodofim)){
            seq = seq + 1;
            sql.append("and le.data <= ? ");
        }
        sql.append("ORDER BY LE.DATA");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        seq = 0;
        if (paciente > 0){
            seq = seq + 1;
            pst.setInt(seq, paciente);
        }
        if (convenio > 0){
            seq = seq + 1;
            pst.setInt(seq, convenio);
        }
        if (!"".equals(periodoini)){
            seq = seq + 1;
            pst.setString(seq, Uteis.desformatarData(periodoini) + " 00:00:00");
        }
        if (!"".equals(periodofim)){
            seq = seq + 1;
            pst.setString(seq, Uteis.desformatarData(periodofim) + " 23:59:59");
        }
        ResultSet rs = pst.executeQuery();
        List<LigacaoExtra> lista = new ArrayList<>();
        while(rs.next()){
            LigacaoExtra c = new LigacaoExtra();
            c.setCodigo(rs.getInt("IDLIGACAOEXTRA"));
            c.setPaciente(daoPaciente.buscarPorId( rs.getInt("IDCLIENTE")) );
            c.setData(rs.getString("DATA"));
            c.setMotivo(rs.getString("MOTIVO"));
            c.setDescricao(rs.getString("DESCRICAO"));
            c.setUsuario(daoUsuario.buscarPorId( rs.getInt("IDUSUARIO")) );
            c.setAtendente(rs.getString("ATENDENTE"));
            c.setTipo(rs.getString("TIPO"));
            c.setDataatendimentoini(rs.getString("DT_ATEND_INI"));
            c.setDataatendimentofim(rs.getString("DT_ATEND_FIM"));
            c.setNmstatus(rs.getString("NMSTATUS"));
            c.setDifatendimento(rs.getString("DIF"));
            lista.add(c);
        }
        return lista;
        
    }
    
}
