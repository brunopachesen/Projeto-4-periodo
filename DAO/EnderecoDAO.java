/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Bean.CidadeBean;
import Bean.EnderecoBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.Conexao;

/**
 *
 * @author Bruno
 */
public class EnderecoDAO {
 

    public static void inserir(EnderecoBean endereco) throws SQLException{
        
       Connection con = Conexao.getConexao();
       String sql = "insert into tb_endereco (num, rua,id_cid) values (?,?,?)";
       
       PreparedStatement stmt = con.prepareStatement(sql);
       stmt.setString(1, endereco.getNum());
       stmt.setString(2, endereco.getRua());
       stmt.setInt(3, endereco.getCidade().getIdCidade());
       stmt.execute();
       stmt.close();
       con.close();
        
    }
    
    public static void alterar(EnderecoBean endereco) throws SQLException {
        Connection con = Conexao.getConexao();
        String sql = "update tb_endereco set num = ?, rua = ?, id_cid = ? where id_end = ? ";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, endereco.getNum());
        stmt.setString(2, endereco.getRua());
        stmt.setInt(3, endereco.getCidade().getIdCidade());
        stmt.setInt(4, endereco.getIdEndereco());
        stmt.executeUpdate();
        stmt.close();
        con.close();
         
    }
    
    public static void excluir(EnderecoBean endereco) throws SQLException {
        Connection con = Conexao.getConexao();
        String sql = "delete from tb_endereco where id_end = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, endereco.getIdEndereco());
        stmt.executeUpdate();
        stmt.close();
        con.close();
    }
    
    public static List<EnderecoBean> pesquisar() throws SQLException {
        List<EnderecoBean> listaEndereco = new ArrayList<EnderecoBean>();
        Connection con = Conexao.getConexao();
        String sql = "select * from tb_endereco order by id_end desc limit 1";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            EnderecoBean endereco = new EnderecoBean();
            endereco.setIdEndereco((rs.getInt("id_end")));
            endereco.setRua((rs.getString("rua")));
            endereco.setNum((rs.getString("num")));
            endereco.getCidade().setIdCidade((rs.getInt("id_cid")));
            listaEndereco.add(endereco);
        }
        rs.close();
        stmt.close();
        con.close();
        return listaEndereco;
    }
    
    public static EnderecoBean retornar() throws SQLException {
        Connection con = Conexao.getConexao();
        String sql = "select * from proj_integrador.tb_endereco order by id_end desc limit 1";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        EnderecoBean endereco = new EnderecoBean();
        endereco.setCidade(new CidadeBean());
        while (rs.next()){
            
            endereco.setIdEndereco((rs.getInt("id_end")));
            endereco.setRua((rs.getString("rua")));
            endereco.setNum((rs.getString("num")));
            endereco.getCidade().setIdCidade((rs.getInt("id_cid")));
        }
        rs.close();
        stmt.close();
        con.close();
        return endereco;
    }
    

}


