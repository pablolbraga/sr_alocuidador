package br.com.sr_alocuidador.models;

public class ConstantesItem {
    
    private int codigo;
    private Constantes constante;
    private String nome;
    private int indice;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Constantes getConstante() {
        return constante;
    }

    public void setConstante(Constantes constante) {
        this.constante = constante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    @Override
    public String toString() {
        return this.nome;
    }
    
    
}
