package br.com.sr_alocuidador.helpers;

import br.com.sr_alocuidador.models.Usuario;

public class VariaveisGlobais {
    
    private static VariaveisGlobais instance = new VariaveisGlobais();
    
    private Usuario dadosUsuario;

    public static VariaveisGlobais getInstance() {
        return instance;
    }

    public static void setInstance(VariaveisGlobais instance) {
        VariaveisGlobais.instance = instance;
    }

    public Usuario getDadosUsuario() {
        return dadosUsuario;
    }

    public void setDadosUsuario(Usuario dadosUsuario) {
        this.dadosUsuario = dadosUsuario;
    }
    
    
    
}
