package br.com.sr_alocuidador.models;

public class PerguntaItem{
    
    private int codigo;
    private Pergunta pergunta;
    private String nome;
    private String alerta;
    private String opcao;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Pergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAlerta() {
        return alerta;
    }

    public void setAlerta(String alerta) {
        this.alerta = alerta;
    }

    public String getOpcao() {
        return opcao;
    }

    public void setOpcao(String opcao) {
        this.opcao = opcao;
    }

    
    
    @Override
    public String toString() {
        return this.nome; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
