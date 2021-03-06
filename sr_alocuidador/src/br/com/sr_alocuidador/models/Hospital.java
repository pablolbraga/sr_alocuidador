package br.com.sr_alocuidador.models;

public class Hospital extends Endereco {
    
    private int codigo;
    private String nome;
    private String contato;

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

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    @Override
    public String toString() {
        return this.nome;
    }
    
    
    
}
