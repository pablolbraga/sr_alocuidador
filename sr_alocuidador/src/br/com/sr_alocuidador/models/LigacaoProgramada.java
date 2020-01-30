package br.com.sr_alocuidador.models;

public class LigacaoProgramada {
    private String idligacao;
    private String dataprogramada;
    private Paciente paciente;
    private String nomepaciente;
    private String primeiraligacao;
    private CategoriaPergunta categoriapergunta;
    private int qtdeligacao;
    private String contatos;
    private String horainicio;
    private String horafim;
    private String status;

    public String getIdligacao() {
        return idligacao;
    }

    public void setIdligacao(String idligacao) {
        this.idligacao = idligacao;
    }

    public String getDataprogramada() {
        return dataprogramada;
    }

    public void setDataprogramada(String dataprogramada) {
        this.dataprogramada = dataprogramada;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getNomepaciente() {
        return nomepaciente;
    }

    public void setNomepaciente(String nomepaciente) {
        this.nomepaciente = nomepaciente;
    }

    public String getPrimeiraligacao() {
        return primeiraligacao;
    }

    public void setPrimeiraligacao(String primeiraligacao) {
        this.primeiraligacao = primeiraligacao;
    }

    public CategoriaPergunta getCategoriapergunta() {
        return categoriapergunta;
    }

    public void setCategoriapergunta(CategoriaPergunta categoriapergunta) {
        this.categoriapergunta = categoriapergunta;
    }

    public int getQtdeligacao() {
        return qtdeligacao;
    }

    public void setQtdeligacao(int qtdeligacao) {
        this.qtdeligacao = qtdeligacao;
    }

    public String getContatos() {
        return contatos;
    }

    public void setContatos(String contatos) {
        this.contatos = contatos;
    }

    public String getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(String horainicio) {
        this.horainicio = horainicio;
    }

    public String getHorafim() {
        return horafim;
    }

    public void setHorafim(String horafim) {
        this.horafim = horafim;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

        
}
