package br.com.sr_alocuidador.models;

public class LigacaoExtra {

    private int codigo;
    private Paciente paciente;
    private String data;
    private String motivo;
    private String descricao;
    private Usuario usuario;
    private String atendente;
    private String tipo;    
    private String dataatendimentoini;
    private String dataatendimentofim;    
    private String difatendimento;
    private String nmstatus;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getAtendente() {
        return atendente;
    }

    public void setAtendente(String atendente) {
        this.atendente = atendente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDataatendimentoini() {
        return dataatendimentoini;
    }

    public void setDataatendimentoini(String dataatendimentoini) {
        this.dataatendimentoini = dataatendimentoini;
    }

    public String getDataatendimentofim() {
        return dataatendimentofim;
    }

    public void setDataatendimentofim(String dataatendimentofim) {
        this.dataatendimentofim = dataatendimentofim;
    }

    public String getDifatendimento() {
        return difatendimento;
    }

    public void setDifatendimento(String difatendimento) {
        this.difatendimento = difatendimento;
    }

    public String getNmstatus() {
        return nmstatus;
    }

    public void setNmstatus(String nmstatus) {
        this.nmstatus = nmstatus;
    }
    
    
       
}
