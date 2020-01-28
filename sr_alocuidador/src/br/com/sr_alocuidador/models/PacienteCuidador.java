package br.com.sr_alocuidador.models;

public class PacienteCuidador extends Endereco {
    
    private int codigo;
    private int paciente;
    private String nome;
    private String nascimento;
    private int sexo;
    private int estcivil;    
    private int parentesco;
    private int situacao;
    private String telefonefixo;
    private String telefonecelular;
    private String email;
    private String nmparentesco;

    public String getNmparentesco() {
        return nmparentesco;
    }

    public void setNmparentesco(String nmparentesco) {
        this.nmparentesco = nmparentesco;
    }

    
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getPaciente() {
        return paciente;
    }

    public void setPaciente(int paciente) {
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

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public int getEstcivil() {
        return estcivil;
    }

    public void setEstcivil(int estcivil) {
        this.estcivil = estcivil;
    }

    public int getParentesco() {
        return parentesco;
    }

    public void setParentesco(int parentesco) {
        this.parentesco = parentesco;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
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