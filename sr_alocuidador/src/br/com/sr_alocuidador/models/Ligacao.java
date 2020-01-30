/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sr_alocuidador.models;

/**
 *
 * @author plima
 */
public class Ligacao {
    
    private String idligacao;
    private Paciente paciente;
    private int idclicuidador;
    private String data;
    private String horainicio;
    private String horafim;
    private String observacao;
    private Usuario usuario;
    private String status;
    private PacienteCategoriaPergunta pacientecategpergunta;
    private String motivonaorealizado;

    public String getIdligacao() {
        return idligacao;
    }

    public void setIdligacao(String idligacao) {
        this.idligacao = idligacao;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public int getIdclicuidador() {
        return idclicuidador;
    }

    public void setIdclicuidador(int idclicuidador) {
        this.idclicuidador = idclicuidador;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(String horainicio) {
        this.horainicio = horainicio;
    }

    public String getHorafim() {
        return horafim;
    }

    public void setHorafim(String horafim) {
        this.horafim = horafim;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PacienteCategoriaPergunta getPacientecategpergunta() {
        return pacientecategpergunta;
    }

    public void setPacientecategpergunta(PacienteCategoriaPergunta pacientecategpergunta) {
        this.pacientecategpergunta = pacientecategpergunta;
    }

    public String getMotivonaorealizado() {
        return motivonaorealizado;
    }

    public void setMotivonaorealizado(String motivonaorealizado) {
        this.motivonaorealizado = motivonaorealizado;
    }

        
    
}
