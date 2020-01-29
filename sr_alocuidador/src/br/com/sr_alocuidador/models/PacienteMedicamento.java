package br.com.sr_alocuidador.models;

public class PacienteMedicamento {
    
    private int codigo;
    private Paciente paciente;
    private String descricao;
    private String dosagem;
    private String horario;
    private String aprazamento;
    private String observacao;
    private String prescritor;
    private ConstantesItem turno;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getAprazamento() {
        return aprazamento;
    }

    public void setAprazamento(String aprazamento) {
        this.aprazamento = aprazamento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getPrescritor() {
        return prescritor;
    }

    public void setPrescritor(String prescritor) {
        this.prescritor = prescritor;
    }

    public ConstantesItem getTurno() {
        return turno;
    }

    public void setTurno(ConstantesItem turno) {
        this.turno = turno;
    }

        
}
