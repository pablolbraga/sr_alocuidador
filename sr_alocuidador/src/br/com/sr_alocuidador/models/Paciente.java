package br.com.sr_alocuidador.models;

public class Paciente extends Endereco {
    
    private int codigo;
    private String nome;
    private String apelido;
    private String nascimento;
    private int sexo;
    private int estadocivil;
    private int escolaridade;
    private String conjuge;
    private Convenio convenio;    
    private String aph;
    private String matricula;
    private String animalestimacao;
    private String hobby;
    private int nivelcategoria;
    private String fonefixo;
    private String fonecelular;
    private String email;
    private int intervalo;
    private int nivelconsciencia;
    private int nivelorientacao;
    private int niveldependencia;
    private double peso;
    private double altura;
    private String ldl;
    private String hdl;
    private String Triglicerideos;
    private String colesteroltotal;
    private int alimentacao;
    private int alimentacaoenteral;
    private int alimentacaotipo;
    private String alimentacaosalgado;
    private String alimentacaoconserva;
    private String alimentacaoenlatado;
    private String alimentacaoindustrializado;
    private String alimentacaosaleiro;
    private int diurese;
    private String fralda;
    private int eliminacaointestinal;
    private int suporteoxigenio;
    private int lesaopele;
    private int historicoqueda;
    private String fratura;
    private String antibiotico;
    private String circunferenciaabdominal;
    private String glicemiajejum;
    private int mobilidade;
    private int mobilidadeacamado;
    private String habitoalimentar;
    private int ingestahidrica;
    private int atividadefisica;
    private String atividadefisicatipo;
    private String tabagismo;
    private String alcoolismo;
    private String consumoalcool;
    private int denticao;
    private int acuidadevisual;
    private int acuidadeauditiva;
    private String alergia;
    private String dtcad;
    private String dtexc;
    private String motexc;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public int getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(int estadocivil) {
        this.estadocivil = estadocivil;
    }

    public int getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(int escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getConjuge() {
        return conjuge;
    }

    public void setConjuge(String conjuge) {
        this.conjuge = conjuge;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public String getAph() {
        return aph;
    }

    public void setAph(String aph) {
        this.aph = aph;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getAnimalestimacao() {
        return animalestimacao;
    }

    public void setAnimalestimacao(String animalestimacao) {
        this.animalestimacao = animalestimacao;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public int getNivelcategoria() {
        return nivelcategoria;
    }

    public void setNivelcategoria(int nivelcategoria) {
        this.nivelcategoria = nivelcategoria;
    }

    public String getFonefixo() {
        return fonefixo;
    }

    public void setFonefixo(String fonefixo) {
        this.fonefixo = fonefixo;
    }

    public String getFonecelular() {
        return fonecelular;
    }

    public void setFonecelular(String fonecelular) {
        this.fonecelular = fonecelular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(int intervalo) {
        this.intervalo = intervalo;
    }

    public int getNivelconsciencia() {
        return nivelconsciencia;
    }

    public void setNivelconsciencia(int nivelconsciencia) {
        this.nivelconsciencia = nivelconsciencia;
    }

    public int getNivelorientacao() {
        return nivelorientacao;
    }

    public void setNivelorientacao(int nivelorientacao) {
        this.nivelorientacao = nivelorientacao;
    }

    public int getNiveldependencia() {
        return niveldependencia;
    }

    public void setNiveldependencia(int niveldependencia) {
        this.niveldependencia = niveldependencia;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getLdl() {
        return ldl;
    }

    public void setLdl(String ldl) {
        this.ldl = ldl;
    }

    public String getHdl() {
        return hdl;
    }

    public void setHdl(String hdl) {
        this.hdl = hdl;
    }

    public String getTriglicerideos() {
        return Triglicerideos;
    }

    public void setTriglicerideos(String Triglicerideos) {
        this.Triglicerideos = Triglicerideos;
    }

    public String getColesteroltotal() {
        return colesteroltotal;
    }

    public void setColesteroltotal(String colesteroltotal) {
        this.colesteroltotal = colesteroltotal;
    }

    public int getAlimentacao() {
        return alimentacao;
    }

    public void setAlimentacao(int alimentacao) {
        this.alimentacao = alimentacao;
    }

    public int getAlimentacaoenteral() {
        return alimentacaoenteral;
    }

    public void setAlimentacaoenteral(int alimentacaoenteral) {
        this.alimentacaoenteral = alimentacaoenteral;
    }

    public int getAlimentacaotipo() {
        return alimentacaotipo;
    }

    public void setAlimentacaotipo(int alimentacaotipo) {
        this.alimentacaotipo = alimentacaotipo;
    }

    public String getAlimentacaosalgado() {
        return alimentacaosalgado;
    }

    public void setAlimentacaosalgado(String alimentacaosalgado) {
        this.alimentacaosalgado = alimentacaosalgado;
    }

    public String getAlimentacaoconserva() {
        return alimentacaoconserva;
    }

    public void setAlimentacaoconserva(String alimentacaoconserva) {
        this.alimentacaoconserva = alimentacaoconserva;
    }

    public String getAlimentacaoenlatado() {
        return alimentacaoenlatado;
    }

    public void setAlimentacaoenlatado(String alimentacaoenlatado) {
        this.alimentacaoenlatado = alimentacaoenlatado;
    }

    public String getAlimentacaoindustrializado() {
        return alimentacaoindustrializado;
    }

    public void setAlimentacaoindustrializado(String alimentacaoindustrializado) {
        this.alimentacaoindustrializado = alimentacaoindustrializado;
    }

    public String getAlimentacaosaleiro() {
        return alimentacaosaleiro;
    }

    public void setAlimentacaosaleiro(String alimentacaosaleiro) {
        this.alimentacaosaleiro = alimentacaosaleiro;
    }

    public int getDiurese() {
        return diurese;
    }

    public void setDiurese(int diurese) {
        this.diurese = diurese;
    }

    public String getFralda() {
        return fralda;
    }

    public void setFralda(String fralda) {
        this.fralda = fralda;
    }

    public int getEliminacaointestinal() {
        return eliminacaointestinal;
    }

    public void setEliminacaointestinal(int eliminacaointestinal) {
        this.eliminacaointestinal = eliminacaointestinal;
    }

    public int getSuporteoxigenio() {
        return suporteoxigenio;
    }

    public void setSuporteoxigenio(int suporteoxigenio) {
        this.suporteoxigenio = suporteoxigenio;
    }

    public int getLesaopele() {
        return lesaopele;
    }

    public void setLesaopele(int lesaopele) {
        this.lesaopele = lesaopele;
    }

    public int getHistoricoqueda() {
        return historicoqueda;
    }

    public void setHistoricoqueda(int historicoqueda) {
        this.historicoqueda = historicoqueda;
    }

    public String getFratura() {
        return fratura;
    }

    public void setFratura(String fratura) {
        this.fratura = fratura;
    }

    public String getAntibiotico() {
        return antibiotico;
    }

    public void setAntibiotico(String antibiotico) {
        this.antibiotico = antibiotico;
    }

    public String getCircunferenciaabdominal() {
        return circunferenciaabdominal;
    }

    public void setCircunferenciaabdominal(String circunferenciaabdominal) {
        this.circunferenciaabdominal = circunferenciaabdominal;
    }

    public String getGlicemiajejum() {
        return glicemiajejum;
    }

    public void setGlicemiajejum(String glicemiajejum) {
        this.glicemiajejum = glicemiajejum;
    }

    public int getMobilidade() {
        return mobilidade;
    }

    public void setMobilidade(int mobilidade) {
        this.mobilidade = mobilidade;
    }

    public int getMobilidadeacamado() {
        return mobilidadeacamado;
    }

    public void setMobilidadeacamado(int mobilidadeacamado) {
        this.mobilidadeacamado = mobilidadeacamado;
    }

    public String getHabitoalimentar() {
        return habitoalimentar;
    }

    public void setHabitoalimentar(String habitoalimentar) {
        this.habitoalimentar = habitoalimentar;
    }

    public int getIngestahidrica() {
        return ingestahidrica;
    }

    public void setIngestahidrica(int ingestahidrica) {
        this.ingestahidrica = ingestahidrica;
    }

    public int getAtividadefisica() {
        return atividadefisica;
    }

    public void setAtividadefisica(int atividadefisica) {
        this.atividadefisica = atividadefisica;
    }

    public String getAtividadefisicatipo() {
        return atividadefisicatipo;
    }

    public void setAtividadefisicatipo(String atividadefisicatipo) {
        this.atividadefisicatipo = atividadefisicatipo;
    }

    public String getTabagismo() {
        return tabagismo;
    }

    public void setTabagismo(String tabagismo) {
        this.tabagismo = tabagismo;
    }

    public String getAlcoolismo() {
        return alcoolismo;
    }

    public void setAlcoolismo(String alcoolismo) {
        this.alcoolismo = alcoolismo;
    }

    public String getConsumoalcool() {
        return consumoalcool;
    }

    public void setConsumoalcool(String consumoalcool) {
        this.consumoalcool = consumoalcool;
    }

    public int getDenticao() {
        return denticao;
    }

    public void setDenticao(int denticao) {
        this.denticao = denticao;
    }

    public int getAcuidadevisual() {
        return acuidadevisual;
    }

    public void setAcuidadevisual(int acuidadevisual) {
        this.acuidadevisual = acuidadevisual;
    }

    public int getAcuidadeauditiva() {
        return acuidadeauditiva;
    }

    public void setAcuidadeauditiva(int acuidadeauditiva) {
        this.acuidadeauditiva = acuidadeauditiva;
    }

    public String getAlergia() {
        return alergia;
    }

    public void setAlergia(String alergia) {
        this.alergia = alergia;
    }

    public String getDtcad() {
        return dtcad;
    }

    public void setDtcad(String dtcad) {
        this.dtcad = dtcad;
    }

    public String getDtexc() {
        return dtexc;
    }

    public void setDtexc(String dtexc) {
        this.dtexc = dtexc;
    }

    public String getMotexc() {
        return motexc;
    }

    public void setMotexc(String motexc) {
        this.motexc = motexc;
    }
    
    
    
}
