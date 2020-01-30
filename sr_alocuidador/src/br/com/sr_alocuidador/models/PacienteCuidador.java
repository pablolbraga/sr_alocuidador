package br.com.sr_alocuidador.models;

public class PacienteCuidador extends Endereco {
    
    private int codigo;
    private Paciente paciente;
    private String nome;
    private String nascimento;
    private ConstantesItem sexo;
    private ConstantesItem estcivil;    
    private ConstantesItem parentesco;
    private ConstantesItem situacao;
    private String telefonefixo;
    private String telefonecelular;
    private String email;

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public ConstantesItem getSexo() {
        return sexo;
    }

    public void setSexo(ConstantesItem sexo) {
        this.sexo = sexo;
    }

    public ConstantesItem getEstcivil() {
        return estcivil;
    }

    public void setEstcivil(ConstantesItem estcivil) {
        this.estcivil = estcivil;
    }

    public ConstantesItem getParentesco() {
        return parentesco;
    }

    public void setParentesco(ConstantesItem parentesco) {
        this.parentesco = parentesco;
    }

    public ConstantesItem getSituacao() {
        return situacao;
    }

    public void setSituacao(ConstantesItem situacao) {
        this.situacao = situacao;
    }

    public String getTelefonefixo() {
        return telefonefixo;
    }

    public void setTelefonefixo(String telefonefixo) {
        this.telefonefixo = telefonefixo;
    }

    public String getTelefonecelular() {
        return telefonecelular;
    }

    public void setTelefonecelular(String telefonecelular) {
        this.telefonecelular = telefonecelular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

        
}
