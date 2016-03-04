/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.EnderecoBean;
import Bean.FabFornBean;
import Bean.FornecedorBean;
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
public class FabFornDAO {
    public static void inserir(FabFornBean fabForn) throws SQLException{

           Connection con = Conexao.getConexao();
           String sql = "insert into tb_forn_fab (id_forn,id_fab) values (?,?)";
           PreparedStatement stmt = con.prepareStatement(sql);
           stmt.setInt(1, fabForn.getFornecedor().getIdFornecedor());
           stmt.setInt(2, fabForn.getFabricante().getIdFabricante());
           stmt.execute();
           stmt.close();
           con.close();

        }

        public static void alterar(FabFornBean fabForn) throws SQLException {
            Connection con = Conexao.getConexao();
            String sql = "update tb_forn_fab set id_forn = ?, id_fab = ? where id_forn_fab = ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
           stmt.setInt(1, fabForn.getFornecedor().getIdFornecedor());
           stmt.setInt(2, fabForn.getFabricante().getIdFabricante());
           stmt.setInt(3, fabForn.getIdFabForn());  
            stmt.executeUpdate();
            stmt.close();
            con.close();

        }

        public static void excluir(FabFornBean fabForn) throws SQLException {
            Connection con = Conexao.getConexao();
            String sql = "delete from tb_forn_fab where id_forn_fab = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, fabForn.getIdFabForn());
            stmt.executeUpdate();
            stmt.close();
            con.close();
        }

        public static List<FabFornBean> pesquisar() throws SQLException {
            List<FabFornBean> listaFabForn= new ArrayList<FabFornBean>();
            Connection con = Conexao.getConexao();
            String sql = "select * from tb_forn_fab";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                FabFornBean fabForn = new FabFornBean();
                fabForn.getFornecedor().setIdFornecedor(rs.getInt("id_forn"));
                fabForn.getFabricante().setIdFabricante(rs.getInt("id_fab"));
                fabForn.setIdFabForn(rs.getInt("id_forn_fab"));
                listaFabForn.add(fabForn);
            }
            rs.close();
            stmt.close();
            con.close();
            return listaFabForn;
        }

        public static List<FabFornBean> pesquisar(FabFornBean pesqFor) throws SQLException {
             List<FabFornBean> listaFabForn= new ArrayList<FabFornBean>();
            Connection con = Conexao.getConexao();
            String sql = "select * from tb_forn_fab where id_forn_fab like '" + pesqFor.getIdFabForn() + "%'";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                FabFornBean fabForn = new FabFornBean();
                fabForn.getFornecedor().setIdFornecedor(rs.getInt("id_forn"));
                fabForn.getFabricante().setIdFabricante(rs.getInt("id_fab"));
                fabForn.setIdFabForn(rs.getInt("id_forn_fab"));
                listaFabForn.add(fabForn);
            }
            stmt.close();
            rs.close();
            con.close();
            return listaFabForn; 
        }

}
