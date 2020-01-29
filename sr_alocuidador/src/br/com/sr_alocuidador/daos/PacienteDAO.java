package br.com.sr_alocuidador.daos;

import br.com.sr_alocuidador.conexao.Conexao;
import br.com.sr_alocuidador.helpers.Uteis;
import br.com.sr_alocuidador.models.Paciente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PacienteDAO {
    
    private ConvenioDAO daoConvenio;
    
    public PacienteDAO(){        
        daoConvenio = new ConvenioDAO();        
    }
    
    private void incluir(Paciente p) throws SQLException{
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date data = new Date();
        
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO CLIENTES (NOME, DTNASC, CSTSEXO, CSTESTCIVIL, CONJUGE, IDCONVENIO, ENDERECO, ");
        sql.append("BAIRRO, CIDADE, UF, CEP, CONTATOS, ANIMALESTIMACAO, STATUS, INTERVALOLIGACAO, APH, APELIDO, CS_CONSCIENCIA, ");
        sql.append("CS_ORIENTACAO, ALERGIA_DESC, CS_ALIMENTACAO, CS_ALIMENTACAO_ENT, CS_ALIMENTACAO_ENT_TIPO, CS_DIURESE, ");
        sql.append("CS_ELIMINACAO_INT, CS_SUPORTE_OXIG_TIPO, CS_LESAOPELE_TIPO, CS_QUEDA, ");
        sql.append("QUEDA_FRAT, EMAIL, CELULAR, FRALDA, ANTIBIOTICO, CS_MOBILIDADE, CS_MOBILIDADE_ACAMADO, ");
        sql.append("HABITOALIMENTAR, CS_INGESTAHIDRICA, CS_ATIVIDADEFISICA, CS_ATIVIDADEFISICA_DESC, ");
        sql.append("TABAGISMO, ALCOOLISMO, CS_DENTICAO, CS_ACUIDADEVISUAL, CS_ACUIDADEAUDITIVA, PESO, ALTURA, ");
        sql.append("MATRICULA, HOBBY, CSTDEPENDENCIA, DTCAD, ALIM_SALG, ALIM_CONS, ALIM_ENLA, ALIM_INDUS, ");
        sql.append("ALIM_SALEIRO, GLICEMIA_JEJUM, CIRC_ABD, CONS_ALCOOL, CS_ESCOLARIDADE, CLASSIFICACAO_NIVEL, ");
        sql.append("COLES_LDL, COLES_HDL, TRIGLICE, COLES_TOTAL) VALUES ");
        sql.append("(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ");
        sql.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ");
        sql.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ");
        sql.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ");
        sql.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ");
        sql.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ");
        sql.append("?, ?, ?, ?)");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setString(1, p.getNome());
        pst.setString(2, Uteis.desformatarData(p.getNascimento()));
        pst.setInt(3, p.getSexo());
        pst.setInt(4, p.getEstadocivil());
        pst.setString(5, p.getConjuge());
        pst.setInt(6, p.getConvenio().getCodigo());
        pst.setString(7, p.getEndereco());
        pst.setString(8, p.getBairro());
        pst.setString(9, p.getCidade());
        pst.setString(10, p.getUf());
        pst.setString(11, p.getCep());
        pst.setString(12, p.getFonefixo());
        pst.setString(13, p.getAnimalestimacao());
        pst.setString(14, "A");
        pst.setInt(15, p.getIntervalo());
        pst.setString(16, p.getAph());
        pst.setString(17, p.getApelido());
        pst.setInt(18, p.getNivelconsciencia());
        pst.setInt(19, p.getNivelorientacao());
        pst.setString(20, p.getAlergia());
        pst.setInt(21, p.getAlimentacao());
        pst.setInt(22, p.getAlimentacaoenteral());
        pst.setInt(23, p.getAlimentacaotipo());
        pst.setInt(24, p.getDiurese());
        pst.setInt(25, p.getEliminacaointestinal());
        pst.setInt(26, p.getSuporteoxigenio());
        pst.setInt(27, p.getLesaopele());
        pst.setInt(28, p.getHistoricoqueda());
        pst.setString(29, p.getFratura());
        pst.setString(30, p.getEmail());
        pst.setString(31, p.getFonecelular());
        pst.setString(32, p.getFralda());
        pst.setString(33, p.getAntibiotico());
        pst.setInt(34, p.getMobilidade());
        pst.setInt(35, p.getMobilidadeacamado());
        pst.setString(36, p.getHabitoalimentar());
        pst.setInt(37, p.getIngestahidrica());
        pst.setInt(38, p.getAtividadefisica());
        pst.setString(39, p.getAtividadefisicatipo());
        pst.setString(40, p.getTabagismo());
        pst.setString(41, p.getAlcoolismo());
        pst.setInt(42, p.getDenticao());
        pst.setInt(43, p.getAcuidadevisual());
        pst.setInt(44, p.getAcuidadeauditiva());
        pst.setDouble(45, p.getPeso());
        pst.setDouble(46, p.getAltura());
        pst.setString(47, p.getMatricula());
        pst.setString(48, p.getHobby());
        pst.setInt(49, p.getNiveldependencia());
        pst.setString(50, formato.format(data));
        pst.setString(51, p.getAlimentacaosalgado());
        pst.setString(52, p.getAlimentacaoconserva());
        pst.setString(53, p.getAlimentacaoenlatado());
        pst.setString(54, p.getAlimentacaoindustrializado());
        pst.setString(55, p.getAlimentacaosaleiro());
        pst.setString(56, p.getGlicemiajejum());
        pst.setString(57, p.getCircunferenciaabdominal());
        pst.setString(58, p.getConsumoalcool());
        pst.setInt(59, p.getEscolaridade());
        pst.setInt(60, p.getNivelcategoria());
        pst.setString(61, p.getLdl());
        pst.setString(62, p.getHdl());
        pst.setString(63, p.getTriglicerideos());
        pst.setString(64, p.getColesteroltotal());
        pst.execute();
    }
    
    private void alterar(Paciente p) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE CLIENTES SET NOME = ?, DTNASC = ?, CSTSEXO = ?, CSTESTCIVIL = ?, CONJUGE = ?, IDCONVENIO = ?, ENDERECO = ?, ");
        sql.append("BAIRRO = ?, CIDADE = ?, UF = ?, CEP = ?, CONTATOS = ?, ANIMALESTIMACAO = ?, INTERVALOLIGACAO = ?, APH = ?, APELIDO = ?, CS_CONSCIENCIA = ?, ");
        sql.append("CS_ORIENTACAO = ?, ALERGIA_DESC = ?, CS_ALIMENTACAO = ?, CS_ALIMENTACAO_ENT = ?, CS_ALIMENTACAO_ENT_TIPO = ?, ");
        sql.append("CS_DIURESE = ?, CS_ELIMINACAO_INT = ?, CS_SUPORTE_OXIG_TIPO = ?, CS_LESAOPELE_TIPO = ?, CS_QUEDA = ?, ");
        sql.append("QUEDA_FRAT = ?, EMAIL = ?, CELULAR = ?, FRALDA = ?, ANTIBIOTICO = ?, CS_MOBILIDADE = ?, CS_MOBILIDADE_ACAMADO = ?, ");
        sql.append("HABITOALIMENTAR = ?, CS_INGESTAHIDRICA = ?, CS_ATIVIDADEFISICA = ?, CS_ATIVIDADEFISICA_DESC = ?, ");
        sql.append("TABAGISMO = ?, ALCOOLISMO = ?, CS_DENTICAO = ?, CS_ACUIDADEVISUAL = ?, CS_ACUIDADEAUDITIVA = ?, PESO = ?, ALTURA = ?, ");
        sql.append("MATRICULA = ?, HOBBY = ?, CSTDEPENDENCIA = ?, ALIM_SALG = ?, ALIM_CONS = ?, ALIM_ENLA = ?, ALIM_INDUS = ?, ");
        sql.append("ALIM_SALEIRO = ?, GLICEMIA_JEJUM = ?, CIRC_ABD = ?, CONS_ALCOOL = ?, CS_ESCOLARIDADE = ?, CLASSIFICACAO_NIVEL = ?, ");
        sql.append("COLES_LDL = ?, COLES_HDL = ?, TRIGLICE = ?, COLES_TOTAL = ? WHERE IDCLIENTE = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setString(1, p.getNome());
        pst.setString(2, Uteis.desformatarData(p.getNascimento()));
        pst.setInt(3, p.getSexo());
        pst.setInt(4, p.getEstadocivil());
        pst.setString(5, p.getConjuge());
        pst.setInt(6, p.getConvenio().getCodigo());
        pst.setString(7, p.getEndereco());
        pst.setString(8, p.getBairro());
        pst.setString(9, p.getCidade());
        pst.setString(10, p.getUf());
        pst.setString(11, p.getCep());
        pst.setString(12, p.getFonefixo());
        pst.setString(13, p.getAnimalestimacao());
        pst.setInt(14, p.getIntervalo());
        pst.setString(15, p.getAph());
        pst.setString(16, p.getApelido());
        pst.setInt(17, p.getNivelconsciencia());
        pst.setInt(18, p.getNivelorientacao());
        pst.setString(19, p.getAlergia());
        pst.setInt(20, p.getAlimentacao());
        pst.setInt(21, p.getAlimentacaoenteral());
        pst.setInt(22, p.getAlimentacaotipo());
        pst.setInt(23, p.getDiurese());
        pst.setInt(24, p.getEliminacaointestinal());
        pst.setInt(25, p.getSuporteoxigenio());
        pst.setInt(26, p.getLesaopele());
        pst.setInt(27, p.getHistoricoqueda());
        pst.setString(28, p.getFratura());
        pst.setString(29, p.getEmail());
        pst.setString(30, p.getFonecelular());
        pst.setString(31, p.getFralda());
        pst.setString(32, p.getAntibiotico());
        pst.setInt(33, p.getMobilidade());
        pst.setInt(34, p.getMobilidadeacamado());
        pst.setString(35, p.getHabitoalimentar());
        pst.setInt(36, p.getIngestahidrica());
        pst.setInt(37, p.getAtividadefisica());
        pst.setString(38, p.getAtividadefisicatipo());
        pst.setString(39, p.getTabagismo());
        pst.setString(40, p.getAlcoolismo());
        pst.setInt(41, p.getDenticao());
        pst.setInt(42, p.getAcuidadevisual());
        pst.setInt(43, p.getAcuidadeauditiva());
        pst.setDouble(44, p.getPeso());
        pst.setDouble(45, p.getAltura());
        pst.setString(46, p.getMatricula());
        pst.setString(47, p.getHobby());
        pst.setInt(48, p.getNiveldependencia());
        pst.setString(49, p.getAlimentacaosalgado());
        pst.setString(50, p.getAlimentacaoconserva());
        pst.setString(51, p.getAlimentacaoenlatado());
        pst.setString(52, p.getAlimentacaoindustrializado());
        pst.setString(53, p.getAlimentacaosaleiro());
        pst.setString(54, p.getGlicemiajejum());
        pst.setString(55, p.getCircunferenciaabdominal());
        pst.setString(56, p.getConsumoalcool());
        pst.setInt(57, p.getEscolaridade());
        pst.setInt(58, p.getNivelcategoria());
        pst.setString(59, p.getLdl());
        pst.setString(60, p.getHdl());
        pst.setString(61, p.getTriglicerideos());
        pst.setString(62, p.getColesteroltotal());
        pst.setInt(63, p.getCodigo());
        pst.execute();
        
    }
    
    public static void excluir(int codigo, String motivo) throws SQLException{
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date data = new Date();
        
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE CLIENTES SET STATUS = 'I', DTEXC = ?, MOTEXC = ? WHERE IDCLIENTE = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setString(1, formato.format(data));
        pst.setString(2, motivo);
        pst.setInt(3, codigo);
        pst.execute();
        
    }
    
    private boolean existeRegistro(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM CLIENTES WHERE IDCLIENTE = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery();
        return rs.next();
        
    }
    
    public void validaDados(Paciente c) throws SQLException{
        
        if (existeRegistro(c.getCodigo()))
            alterar(c);
        else 
            incluir(c);
        
    }
    
    public Paciente buscarPorId(int codigo) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM CLIENTES WHERE IDCLIENTE = ?");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        pst.setInt(1, codigo);
        ResultSet rs = pst.executeQuery();
        Paciente paciente = null;
        while(rs.next()){
            paciente = new Paciente();
            paciente.setCodigo(rs.getInt("IDCLIENTE"));
            paciente.setNome(rs.getString("NOME"));
            paciente.setApelido(rs.getString("APELIDO"));
            paciente.setNascimento(rs.getString("DTNASC"));
            paciente.setSexo(rs.getInt("CSTSEXO"));
            paciente.setEstadocivil(rs.getInt("CSTESTCIVIL"));
            paciente.setEscolaridade(rs.getInt("CS_ESCOLARIDADE"));
            paciente.setConjuge(rs.getString("CONJUGE"));
            paciente.setConvenio(daoConvenio.buscarPorId(rs.getInt("IDCONVENIO")));            
            paciente.setAph(rs.getString("APH"));
            paciente.setMatricula(rs.getString("MATRICULA"));
            paciente.setEndereco(rs.getString("ENDERECO"));
            paciente.setBairro(rs.getString("BAIRRO"));
            paciente.setCidade(rs.getString("CIDADE"));
            paciente.setUf(rs.getString("UF"));
            paciente.setCep(rs.getString("CEP"));
            paciente.setFonefixo(rs.getString("CONTATOS"));
            paciente.setFonecelular(rs.getString("CELULAR"));
            paciente.setEmail(rs.getString("EMAIL"));
            paciente.setAnimalestimacao(rs.getString("ANIMALESTIMACAO"));
            paciente.setHobby(rs.getString("HOBBY"));
            paciente.setNivelcategoria(rs.getInt("CLASSIFICACAO_NIVEL"));
            paciente.setIntervalo(rs.getInt("INTERVALOLIGACAO"));
            paciente.setNivelconsciencia(rs.getInt("CS_CONSCIENCIA"));
            paciente.setNivelorientacao(rs.getInt("CS_ORIENTACAO"));
            paciente.setNiveldependencia(rs.getInt("CSTDEPENDENCIA"));
            paciente.setPeso(rs.getDouble("PESO"));
            paciente.setAltura(rs.getDouble("ALTURA"));
            paciente.setLdl(rs.getString("COLES_LDL"));
            paciente.setHdl(rs.getString("COLES_HDL"));
            paciente.setTriglicerideos(rs.getString("TRIGLICE"));
            paciente.setColesteroltotal(rs.getString("COLES_TOTAL"));
            paciente.setAlergia(rs.getString("ALERGIA_DESC"));
            paciente.setDiurese(rs.getInt("CS_DIURESE"));
            paciente.setFralda(rs.getString("FRALDA"));
            paciente.setEliminacaointestinal(rs.getInt("CS_ELIMINACAO_INT"));
            paciente.setAlimentacao(rs.getInt("CS_ALIMENTACAO"));
            paciente.setAlimentacaoenteral(rs.getInt("CS_ALIMENTACAO_ENT"));
            paciente.setAlimentacaosalgado(rs.getString("ALIM_SALG"));
            paciente.setAlimentacaoconserva(rs.getString("ALIM_CONS"));
            paciente.setAlimentacaoenlatado(rs.getString("ALIM_ENLA"));
            paciente.setAlimentacaoindustrializado(rs.getString("ALIM_INDUS"));
            paciente.setAlimentacaosaleiro(rs.getString("ALIM_SALEIRO"));
            paciente.setSuporteoxigenio(rs.getInt("CS_SUPORTE_OXIG_TIPO"));
            paciente.setLesaopele(rs.getInt("CS_LESAOPELE_TIPO"));
            paciente.setHistoricoqueda(rs.getInt("CS_QUEDA"));
            paciente.setFratura(rs.getString("QUEDA_FRAT"));
            paciente.setAntibiotico(rs.getString("ANTIBIOTICO"));
            paciente.setCircunferenciaabdominal(rs.getString("CIRC_ABD"));
            paciente.setGlicemiajejum(rs.getString("GLICEMIA_JEJUM"));
            paciente.setMobilidade(rs.getInt("CS_MOBILIDADE"));
            paciente.setMobilidadeacamado(rs.getInt("CS_MOBILIDADE_ACAMADO"));
            paciente.setHabitoalimentar(rs.getString("HABITOALIMENTAR"));
            paciente.setIngestahidrica(rs.getInt("CS_INGESTAHIDRICA"));
            paciente.setAtividadefisica(rs.getInt("CS_ATIVIDADEFISICA"));
            paciente.setAtividadefisicatipo(rs.getString("CS_ATIVIDADEFISICA_DESC"));
            paciente.setTabagismo(rs.getString("TABAGISMO"));
            paciente.setAlcoolismo(rs.getString("ALCOOLISMO"));
            paciente.setConsumoalcool(rs.getString("CONS_ALCOOL"));
            paciente.setDenticao(rs.getInt("CS_DENTICAO"));
            paciente.setAcuidadevisual(rs.getInt("CS_ACUIDADEVISUAL"));
            paciente.setAcuidadeauditiva(rs.getInt("CS_ACUIDADEAUDITIVA"));
            paciente.setDtcad(rs.getString("DTCAD"));
        }
        return paciente;
        
    }
    
    
    public List<Paciente> listarPacientes(int convenio, String descricao) throws SQLException{
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM CLIENTES WHERE STATUS = 'A' ");
        if (convenio > 0){
            sql.append("AND IDCONVENIO = ? ");
        }
        if (!"".equals(descricao)){
            sql.append("AND NOME LIKE ? ");
        }
        sql.append("ORDER BY NOME");
        PreparedStatement pst = Conexao.AbrirConexao().prepareStatement(sql.toString());
        int seq = 0;
        if (convenio > 0){
            seq = seq + 1;
            pst.setInt(seq, convenio);
        }
        if (!"".equals(descricao)){
            seq = seq + 1;
            pst.setString(seq, "%" + descricao + "%");
        }
        ResultSet rs = pst.executeQuery();
        List<Paciente> lista = new ArrayList<>();
        while(rs.next()){
            Paciente paciente = new Paciente();
            paciente.setCodigo(rs.getInt("IDCLIENTE"));
            paciente.setNome(rs.getString("NOME"));
            paciente.setApelido(rs.getString("APELIDO"));
            paciente.setNascimento(rs.getString("DTNASC"));
            paciente.setSexo(rs.getInt("CSTSEXO"));
            paciente.setEstadocivil(rs.getInt("CSTESTCIVIL"));
            paciente.setEscolaridade(rs.getInt("CS_ESCOLARIDADE"));
            paciente.setConjuge(rs.getString("CONJUGE"));
            paciente.setConvenio(daoConvenio.buscarPorId(rs.getInt("IDCONVENIO")));            
            paciente.setAph(rs.getString("APH"));
            paciente.setMatricula(rs.getString("MATRICULA"));
            paciente.setEndereco(rs.getString("ENDERECO"));
            paciente.setBairro(rs.getString("BAIRRO"));
            paciente.setCidade(rs.getString("CIDADE"));
            paciente.setUf(rs.getString("UF"));
            paciente.setCep(rs.getString("CEP"));
            paciente.setFonefixo(rs.getString("CONTATOS"));
            paciente.setFonecelular(rs.getString("CELULAR"));
            paciente.setEmail(rs.getString("EMAIL"));
            paciente.setAnimalestimacao(rs.getString("ANIMALESTIMACAO"));
            paciente.setHobby(rs.getString("HOBBY"));
            paciente.setNivelcategoria(rs.getInt("CLASSIFICACAO_NIVEL"));
            paciente.setIntervalo(rs.getInt("INTERVALOLIGACAO"));
            paciente.setNivelconsciencia(rs.getInt("CS_CONSCIENCIA"));
            paciente.setNivelorientacao(rs.getInt("CS_ORIENTACAO"));
            paciente.setNiveldependencia(rs.getInt("CSTDEPENDENCIA"));
            paciente.setPeso(rs.getDouble("PESO"));
            paciente.setAltura(rs.getDouble("ALTURA"));
            paciente.setLdl(rs.getString("COLES_LDL"));
            paciente.setHdl(rs.getString("COLES_HDL"));
            paciente.setTriglicerideos(rs.getString("TRIGLICE"));
            paciente.setColesteroltotal(rs.getString("COLES_TOTAL"));
            paciente.setAlergia(rs.getString("ALERGIA_DESC"));
            paciente.setDiurese(rs.getInt("CS_DIURESE"));
            paciente.setFralda(rs.getString("FRALDA"));
            paciente.setEliminacaointestinal(rs.getInt("CS_ELIMINACAO_INT"));
            paciente.setAlimentacao(rs.getInt("CS_ALIMENTACAO"));
            paciente.setAlimentacaoenteral(rs.getInt("CS_ALIMENTACAO_ENT"));
            paciente.setAlimentacaosalgado(rs.getString("ALIM_SALG"));
            paciente.setAlimentacaoconserva(rs.getString("ALIM_CONS"));
            paciente.setAlimentacaoenlatado(rs.getString("ALIM_ENLA"));
            paciente.setAlimentacaoindustrializado(rs.getString("ALIM_INDUS"));
            paciente.setAlimentacaosaleiro(rs.getString("ALIM_SALEIRO"));
            paciente.setSuporteoxigenio(rs.getInt("CS_SUPORTE_OXIG_TIPO"));
            paciente.setLesaopele(rs.getInt("CS_LESAOPELE_TIPO"));
            paciente.setHistoricoqueda(rs.getInt("CS_QUEDA"));
            paciente.setFratura(rs.getString("QUEDA_FRAT"));
            paciente.setAntibiotico(rs.getString("ANTIBIOTICO"));
            paciente.setCircunferenciaabdominal(rs.getString("CIRC_ABD"));
            paciente.setGlicemiajejum(rs.getString("GLICEMIA_JEJUM"));
            paciente.setMobilidade(rs.getInt("CS_MOBILIDADE"));
            paciente.setMobilidadeacamado(rs.getInt("CS_MOBILIDADE_ACAMADO"));
            paciente.setHabitoalimentar(rs.getString("HABITOALIMENTAR"));
            paciente.setIngestahidrica(rs.getInt("CS_INGESTAHIDRICA"));
            paciente.setAtividadefisica(rs.getInt("CS_ATIVIDADEFISICA"));
            paciente.setAtividadefisicatipo(rs.getString("CS_ATIVIDADEFISICA_DESC"));
            paciente.setTabagismo(rs.getString("TABAGISMO"));
            paciente.setAlcoolismo(rs.getString("ALCOOLISMO"));
            paciente.setConsumoalcool(rs.getString("CONS_ALCOOL"));
            paciente.setDenticao(rs.getInt("CS_DENTICAO"));
            paciente.setAcuidadevisual(rs.getInt("CS_ACUIDADEVISUAL"));
            paciente.setAcuidadeauditiva(rs.getInt("CS_ACUIDADEAUDITIVA"));
            paciente.setDtcad(rs.getString("DTCAD"));
            lista.add(paciente);
        }
        return lista;
        
    }
    
}
