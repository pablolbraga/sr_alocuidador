package br.com.sr_alocuidador.models;

public class Doenca {
    
    private int codigo;
    private CategoriaDoenca categoriadoenca;
    private String nome;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public CategoriaDoenca getCategoriadoenca() {
        return categoriadoenca;
    }

    public void setCategoriadoenca(CategoriaDoenca categoriadoenca) {
        this.categoriadoenca = categoriadoenca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.nome;
    }
    
    
    
}
