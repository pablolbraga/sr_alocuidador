package br.com.sr_alocuidador.daos;

import br.com.sr_alocuidador.conexao.Conexao;
import br.com.sr_alocuidador.models.Paciente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {
    
    
    public static List<Paciente> listarPacientes(int convenio, String descricao) throws SQLException{
        
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
            paciente.setConvenio(ConvenioDAO.buscarPorId(rs.getInt("IDCONVENIO")));            
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
