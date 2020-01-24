/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sr_alocuidador.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Pablo
 */
public class Conexao {
    
    private static Connection conn;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://192.168.0.197:3306/alocuidador";
    //private static final String URL = "jdbc:mysql://200.150.138.34:8746/alocuidador";
    private static final String USER = "root";
    private static final String PWD = "root";

    public static Connection AbrirConexao() {

        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PWD);
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            conn = null;
        }
        return conn;

    }
    
}
