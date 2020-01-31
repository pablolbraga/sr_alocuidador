package br.com.sr_alocuidador.models;

public class PerguntaItemPergunta {
    
    private Pergunta pergunta;
    private CategoriaPergunta perguntacategoria;
    private String destino;
    private String existe;

    public Pergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }

    public CategoriaPergunta getPerguntacategoria() {
        return perguntacategoria;
    }

    public void setPerguntacategoria(CategoriaPergunta perguntacategoria) {
        this.perguntacategoria = perguntacategoria;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getExiste() {
        return existe;
    }

    public void setExiste(String existe) {
        this.existe = existe;
    }
    
    

    
        
}
