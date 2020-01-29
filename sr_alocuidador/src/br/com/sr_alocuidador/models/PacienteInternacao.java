package br.com.sr_alocuidador.models;

public class PacienteInternacao {
    
    private int codigo;
    private Paciente paciente;
    private Hospital hospital;
    private String dataini;
    private String datafim;
    private String diagnostico;
    private ConstantesItem idmotivo;
    private String statusLace;
    private int indiceLace;

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

    public String getDataini() {
        return dataini;
    }

    public void setDataini(String dataini) {
        this.dataini = dataini;
    }

    public String getDatafim() {
        return datafim;
    }

    public void setDatafim(String datafim) {
        this.datafim = datafim;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public ConstantesItem getIdmotivo() {
        return idmotivo;
    }

    public void setIdmotivo(ConstantesItem idmotivo) {
        this.idmotivo = idmotivo;
    }

    public String getStatusLace() {
        return statusLace;
    }

    public void setStatusLace(String statusLace) {
        this.statusLace = statusLace;
    }

    public int getIndiceLace() {
        return indiceLace;
    }

    public void setIndiceLace(int indiceLace) {
        this.indiceLace = indiceLace;
    }

                
}
