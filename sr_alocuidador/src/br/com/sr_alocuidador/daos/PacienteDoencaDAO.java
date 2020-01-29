package br.com.sr_alocuidador.daos;

import br.com.sr_alocuidador.conexao.Conexao;
import br.com.sr_alocuidador.models.Paciente;
import br.com.sr_alocuidador.models.PacienteDoenca;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteDoencaDAO {
    
    private DoencaDAO daoDoenca = null;
    private ConvenioDAO daoConvenio = null;
    private PacienteDAO daoPaciente = null;

    public PacienteDoencaDAO() {
        
        daoDoenca = new DoencaDAO();
        daoConvenio = new ConvenioDAO();
        daoPaciente = new PacienteDAO();
        
    }

    private void incluir(PacienteDoenca c) throws SQLException {

        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO CLIENTES_DOENCA (IDCLIENTE, IDDOENCA, DESCRICAO) VALUES (?, ?, ?)");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, c.getPaciente().getCodigo());
        pst.setInt(2, c.getDoenca().getCodigo());
        pst.setString(3, c.getDescricao());
        pst.execute();

    }

    private void alterar(PacienteDoenca c) throws SQLException {

        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE CLIENTES_DOENCA SET IDCLIENTE = ?, IDDOENCA = ?, DESCRICAO = ? WHERE IDCLIDOE = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, c.getPaciente().getCodigo());
        pst.setInt(2, c.getDoenca().getCodigo());
        pst.setString(3, c.getDescricao());
        pst.setInt(4, c.getCodigo());
        pst.execute();

    }

    public void excluir(int codigo) throws SQLException {

        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM CLIENTES_DOENCA WHERE IDCLIDOE = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        pst.execute();

    }

    private boolean existeRegistro(int codigo) throws SQLException {

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM CLIENTES_DOENCA CC WHERE CC.IDCLIDOE = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery();
        return rs.next();

    }

    public void validaDados(PacienteDoenca c) throws SQLException {
        if (existeRegistro(c.getCodigo())) {
            alterar(c);
        } else {
            incluir(c);
        }
    }

    public PacienteDoenca buscarPorId(int codigo) throws SQLException {

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT CD.*, C.NOME AS NMCLIENTE, D.DESCRICAO AS NMDOENCA ");
        sql.append("FROM CLIENTES_DOENCA CD INNER JOIN CLIENTES C ON C.IDCLIENTE = CD.IDCLIENTE ");
        sql.append("INNER JOIN DOENCAS D ON D.IDDOENCA = CD.IDDOENCA ");
        sql.append("WHERE CD.IDCLIDOE = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery();
        PacienteDoenca c = null;
        while (rs.next()) {
            c = new PacienteDoenca();
            c.setCodigo(rs.getInt("IDCLIDOE"));
            c.setPaciente(daoPaciente.buscarPorId(rs.getInt("IDCLIENTE")));
            c.setDoenca(daoDoenca.BuscarPorId(rs.getInt("IDDOENCA")));
            c.setDescricao(rs.getString("DESCRICAO"));
        }
        return c;

    }

    public List<PacienteDoenca> listarDoencasPorPaciente(int paciente) throws SQLException {

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT CD.*, C.NOME AS NMCLIENTE, D.DESCRICAO AS NMDOENCA ");
        sql.append("FROM CLIENTES_DOENCA CD INNER JOIN CLIENTES C ON C.IDCLIENTE = CD.IDCLIENTE ");
        sql.append("INNER JOIN DOENCAS D ON D.IDDOENCA = CD.IDDOENCA ");
        sql.append("WHERE CD.IDCLIENTE = ? ORDER BY CD.IDCLIDOE");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, paciente);
        ResultSet rs = pst.executeQuery();
        List<PacienteDoenca> lista = new ArrayList<>();
        while (rs.next()) {
            PacienteDoenca c = new PacienteDoenca();
            c.setCodigo(rs.getInt("IDCLIDOE"));
            c.setPaciente(daoPaciente.buscarPorId(rs.getInt("IDCLIENTE")));
            c.setDoenca(daoDoenca.BuscarPorId(rs.getInt("IDDOENCA")));
            c.setDescricao(rs.getString("DESCRICAO"));
            lista.add(c);
        }
        return lista;

    }

    public boolean existeDoencaNoPaciente(int paciente, int doenca) throws SQLException {

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM CLIENTES_DOENCA WHERE IDCLIENTE = ? AND IDDOENCA = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, paciente);
        pst.setInt(2, doenca);
        ResultSet rs = pst.executeQuery();
        return rs.next();

    }

    public List<Paciente> listarPacientesPorDoenca(String doencas, int qtde, int convenio) throws SQLException {

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT J.IDCLIENTE, J.NMCLIENTE, J.IDCONVENIO, COUNT(J.IDCLIENTE) AS QTDE FROM (");
        sql.append("SELECT CD.*, C.NOME AS NMCLIENTE, CV.IDCONVENIO FROM CLIENTES_DOENCA CD ");
        sql.append("INNER JOIN CLIENTES C ON C.IDCLIENTE = CD.IDCLIENTE AND STATUS = 'A' ");
        sql.append("INNER JOIN CONVENIOS CV ON CV.IDCONVENIO = C.IDCONVENIO ");
        if (convenio > 0) {
            sql.append("AND CV.IDCONVENIO = ").append(Integer.toString(convenio)).append(" ");
        }
        sql.append("WHERE CD.IDDOENCA IN (").append(doencas).append(") ");
        sql.append(") J GROUP BY J.IDCLIENTE, J.NMCLIENTE, J.IDCONVENIO HAVING COUNT(J.IDCLIENTE) = ? ");
        sql.append("ORDER BY J.NMCLIENTE");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, qtde);
        ResultSet rs = pst.executeQuery();
        List<Paciente> lista = new ArrayList<>();
        while (rs.next()) {
            Paciente c = new Paciente();
            c.setCodigo(rs.getInt("IDCLIENTE"));
            c.setNome(rs.getString("NMCLIENTE"));
            c.setConvenio(daoConvenio.buscarPorId(rs.getInt("IDCONVENIO")));
            lista.add(c);
        }
        return lista;

    }

    public String BuscarPorIdPorCliente(int doenca, int cliente) throws SQLException {

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM CLIENTES_DOENCA CD WHERE CD.IDCLIENTE = ? AND CD.IDDOENCA = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, cliente);
        pst.setInt(2, doenca);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            return "SIM";
        } else {
            return "NÃO";
        }
    }

    public int BuscarPorFaixaEtaria(String faixa, String clientes, int doenca) throws SQLException {

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT COUNT(*) AS QTDE FROM (SELECT CD.*, TIMESTAMPDIFF(YEAR, C.dtnasc, CURDATE()) as idade FROM CLIENTES_DOENCA CD "
                + "INNER JOIN CLIENTES C ON C.IDCLIENTE = CD.IDCLIENTE "
                + "WHERE CD.IDCLIENTE in (" + clientes + ") AND CD.IDDOENCA = ?) F WHERE F.IDADE " + faixa);
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, doenca);
        ResultSet rs = pst.executeQuery();
        int qtde = 0;
        while (rs.next()) {
            qtde = rs.getInt("QTDE");
        }
        return qtde;
    }

}
