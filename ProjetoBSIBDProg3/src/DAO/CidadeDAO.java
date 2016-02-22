/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.CidadeBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import util.Conexao;

/**
 *
 * @author Bruno
 */
public class CidadeDAO {
    public static void inserir(CidadeBean cidade) throws SQLException{
        
       Connection con = Conexao.getConexao();
       String sql = "insert into tbcidade (cidade, estado) values (?,?)";
       
       PreparedStatement stmt = con.prepareStatement(sql);
       stmt.setString(1, cidade.getNome());
       stmt.setString(2, cidade.getEstado());
       stmt.execute();
       stmt.close();
       con.close();
        
    }
    
    public static void alterar(CidadeBean cidade) throws SQLException {
        Connection con = Conexao.getConexao();
        String sql = "update tbcidade set cidade = ?, estado = ? where idCidade = ? ";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, cidade.getNome());
        stmt.setString(2, cidade.getEstado());
        stmt.setInt(3, cidade.getIdCidade());
        stmt.executeUpdate();
        stmt.close();
        con.close();
         
    }
}
