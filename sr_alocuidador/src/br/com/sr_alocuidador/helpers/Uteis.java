/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sr_alocuidador.helpers;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.InputMismatchException;
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
    
    public static boolean isCNPJ(String CNPJ) {
        // considera-se erro CNPJ's formados por uma sequencia de numeros iguais
        if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111") ||
            CNPJ.equals("22222222222222") || CNPJ.equals("33333333333333") ||
            CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555") ||
            CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777") ||
            CNPJ.equals("88888888888888") || CNPJ.equals("99999999999999") ||
           (CNPJ.length() != 14))
            return(false);
 
        char dig13, dig14;
        int sm, i, r, num, peso;
 
        // "try" - protege o código para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 2;
            for (i=11; i>=0; i--) {
                // converte o i-ésimo caractere do CNPJ em um número:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posição de '0' na tabela ASCII)
                num = (int)(CNPJ.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10)
                    peso = 2;
            }
 
            r = sm % 11;
            if ((r == 0) || (r == 1))
                dig13 = '0';
            else 
                dig13 = (char)((11-r) + 48);
 
            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 2;
            for (i=12; i>=0; i--) {
                num = (int)(CNPJ.charAt(i)- 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10)
                    peso = 2;
            }
 
            r = sm % 11;
            if ((r == 0) || (r == 1))
                dig14 = '0';
            else 
                dig14 = (char)((11-r) + 48);
 
            // Verifica se os dígitos calculados conferem com os dígitos informados.
            if ((dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13)))
                return(true);
            else 
                return(false);
        } catch (InputMismatchException erro) {
            return(false);
        }
    }
    
    
}
