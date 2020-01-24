package br.com.sr_alocuidador.models;

public class Usuario {
    
    private int codigo;
    private String nome;
    private String login;
    private String email;
    private String senha;
    
    private String alerta;
    private int pesqsatisfacao;
    private String profmedico;
    private String lace;
    private String administrador;

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getAlerta() {
        return alerta;
    }

    public void setAlerta(String alerta) {
        this.alerta = alerta;
    }

    public int getPesqsatisfacao() {
        return pesqsatisfacao;
    }

    public void setPesqsatisfacao(int pesqsatisfacao) {
        this.pesqsatisfacao = pesqsatisfacao;
    }

    public String getProfmedico() {
        return profmedico;
    }

    public void setProfmedico(String profmedico) {
        this.profmedico = profmedico;
    }

    public String getLace() {
        return lace;
    }

    public void setLace(String lace) {
        this.lace = lace;
    }

    public String getAdministrador() {
        return administrador;
    }

    public void setAdministrador(String administrador) {
        this.administrador = administrador;
    }
    
    
    
}
