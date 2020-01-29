package br.com.sr_alocuidador.models;

public class PacienteConsulta {
    
    private int codigo;
    private Paciente paciente;
    private Hospital hospital;
    private String data;
    private String emergencia;
    private String observacao;
    private ConstantesItem motivo;

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

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEmergencia() {
        return emergencia;
    }

    public void setEmergencia(String emergencia) {
        this.emergencia = emergencia;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public ConstantesItem getMotivo() {
        return motivo;
    }

    public void setMotivo(ConstantesItem motivo) {
        this.motivo = motivo;
    }
           
    
}
