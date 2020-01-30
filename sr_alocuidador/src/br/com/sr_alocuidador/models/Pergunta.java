package br.com.sr_alocuidador.models;

public class Pergunta {
    
    private int codigo;
    private CategoriaPergunta categoria;
    private String nome;
    private String destino;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public CategoriaPergunta getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaPergunta categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
    
        
}
