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
    
    
}
