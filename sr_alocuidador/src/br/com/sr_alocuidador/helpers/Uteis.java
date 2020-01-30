/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sr_alocuidador.helpers;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Pablo
 */
public class Uteis {
    
    public static String criptografia(String senha) throws NoSuchAlgorithmException{
        
        String result = senha;
        if(senha != null) {
            MessageDigest md = MessageDigest.getInstance("SHA-1"); //or "SHA-1"
            md.update(senha.getBytes());
            BigInteger hash = new BigInteger(1, md.digest());
            result = hash.toString(16);
            while(result.length() < 40) { //40 for SHA-1
                result = "0" + result;
            }
        }        
        
        return result;
        
    }
    public static boolean linhaSelecionada(JTable table){
        
        if (table.getSelectedRowCount() > 0)
            return true;
        else{
            JOptionPane.showMessageDialog(null, "Nenhuma linha foi selecionada");
            return false;
        }
        
    }
    
    public static String formatarData(String data){
        
        // Transformar yyyy-MM-dd para dd/MM/yyyy
        if (data != null && !"".equals(data)){
        
            String[] xdatahora = data.split(" ");
            String[] xdata = xdatahora[0].split("-");
            String novadata = xdata[2] + "/" + xdata[1] + "/" + xdata[0];
            return novadata;        
        
        } else {
            
            return "";
            
        }
        
    }
    
    public static String calcularImc(double altura, double peso){
        
        //(C.PESO /  ((C.ALTURA / 100) * (C.ALTURA / 100)))
        double valor = (peso / ((altura / 100) * (altura / 100)));
        return retornarStatusImc(valor);
        
    }
    
    public static String retornarStatusImc(Double valor){
        
        if (valor == 0)
            return "Não informado";
        else if (valor < 22)
            return "Baixo peso (Desnutrição)";
        else if (valor >= 22 && valor <= 27)
            return "Normal (Eutrófico)";
        else if (valor > 27)
            return "Obesidade";
        else
            return "";
    }
    
    public static String desformatarData(String data){
        
        // Transformar de dd/mm/yyyy para yyyy-mm-dd
        if ("".equals(data)){
            return "";
        } else {
            String[] xdata = data.split("/");
            String novadata = xdata[2] + "-" + xdata[1] + "-" + xdata[0];
            return novadata;
        }
        
    }
    
    public static String zerosAEsquerda(String value, int n){
        
        String s = value.trim();
        StringBuffer resp = new StringBuffer();
        int fim = n - s.length();
        for (int x = 0; x < fim; x++){
            resp.append("0");
        }
        return resp + s;
        
    }
    
    public static String formatarDataHora(String datahora){
        if (!"".equals(datahora)){        
            String[] xdatahora = datahora.split(" ");
            //Formata data
            String[] xdata = xdatahora[0].split("-");
            String novadata = xdata[2] + "/" + xdata[1] + "/" + xdata[0];
            return novadata + " " + xdatahora[1]; 
        }
        else return "";
        
    }
    
    
}
