/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

/**
 *
 * @author IFPR
 */
public class Conexao {
    
    
 public static void main (String []args){
        try {
            getConexao();
            System.out.println("Conectado ao Banco de Dados!!");
        } catch (SQLException e){
            System.out.println("Erro ao conectar ao Banco de Dados \n \n");
            e.printStackTrace();
        }
    }
    public static Connection getConexao() throws SQLException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection 
        ("jdbc:mysql://localhost/proj_integrador", "root", "root");
        } catch (ClassNotFoundException e){
            throw new SQLDataException(e.getMessage());
        }
    }
}
