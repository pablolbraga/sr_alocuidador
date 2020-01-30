package br.com.sr_alocuidador.models;

public class LigacaoItem {
    
    private Ligacao ligacao;
    private PerguntaItem pergitem;
    private String observacao;
    private String nmresposta;

    public Ligacao getLigacao() {
        return ligacao;
    }

    public void setLigacao(Ligacao ligacao) {
        this.ligacao = ligacao;
    }

    public PerguntaItem getPergitem() {
        return pergitem;
    }

    public void setPergitem(PerguntaItem pergitem) {
        this.pergitem = pergitem;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getNmresposta() {
        return nmresposta;
    }

    public void setNmresposta(String nmresposta) {
        this.nmresposta = nmresposta;
    }
            
}
