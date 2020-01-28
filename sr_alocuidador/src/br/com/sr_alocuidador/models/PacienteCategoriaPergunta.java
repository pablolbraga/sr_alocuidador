package br.com.sr_alocuidador.models;

public class PacienteCategoriaPergunta {
    
    private int codigo;
    private Paciente paciente;
    private CategoriaPergunta categoriapergunta;
    private int sequencia;

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

    public CategoriaPergunta getCategoriapergunta() {
        return categoriapergunta;
    }

    public void setCategoriapergunta(CategoriaPergunta categoriapergunta) {
        this.categoriapergunta = categoriapergunta;
    }

    public int getSequencia() {
        return sequencia;
    }

    public void setSequencia(int sequencia) {
        this.sequencia = sequencia;
    }

            
    
    
}
