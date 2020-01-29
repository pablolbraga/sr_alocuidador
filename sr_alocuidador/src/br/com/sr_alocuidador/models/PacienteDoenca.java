package br.com.sr_alocuidador.models;

public class PacienteDoenca {
    
    private int codigo;
    private Paciente paciente;
    private Doenca doenca;
    private String descricao;
    
    private String nmpaciente;
    private String nmdoenca;

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

    public Doenca getDoenca() {
        return doenca;
    }

    public void setDoenca(Doenca doenca) {
        this.doenca = doenca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNmpaciente() {
        return nmpaciente;
    }

    public void setNmpaciente(String nmpaciente) {
        this.nmpaciente = nmpaciente;
    }

    public String getNmdoenca() {
        return nmdoenca;
    }

    public void setNmdoenca(String nmdoenca) {
        this.nmdoenca = nmdoenca;
    }

    
    
    
    
}
