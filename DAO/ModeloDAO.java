/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Bean.FabricanteBean;
import Bean.ModeloBean;
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
public class ModeloDAO {
public static void inserir(ModeloBean modelo) throws SQLException{

           Connection con = Conexao.getConexao();
           String sql = "insert into tb_modelo (nome_mod,id_fab) values (?,?)";

           PreparedStatement stmt = con.prepareStatement(sql);
           stmt.setString(1, modelo.getNome());
           stmt.setInt(2, modelo.getFabricante().getIdFabricante());
           stmt.execute();
           stmt.close();
           con.close();

        }

        public static void alterar(ModeloBean modelo) throws SQLException {
            Connection con = Conexao.getConexao();
            String sql = "update tb_modelo set nome_mod = ?, id_fab where id_mod = ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, modelo.getNome());
            stmt.setInt(2, modelo.getFabricante().getIdFabricante());
            stmt.setInt(3, modelo.getIdModelo());
            stmt.executeUpdate();
            stmt.close();
            con.close();

        }

        public static void excluir(ModeloBean modelo) throws SQLException {
            Connection con = Conexao.getConexao();
            String sql = "delete from tb_modelo where id_mod = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, modelo.getIdModelo());
            stmt.executeUpdate();
            stmt.close();
            con.close();
        }

        public static List<ModeloBean> pesquisar() throws SQLException {
            List<ModeloBean> listaModelo = new ArrayList<ModeloBean>();
            Connection con = Conexao.getConexao();
            String sql = "select * from tb_fabrica inner join tb_modelo on tb_fabrica.id_fab = tb_modelo.id_fab";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ModeloBean modelo = new ModeloBean();
                modelo.setFabricante(new FabricanteBean());
                modelo.setNome(rs.getString("nome_mod"));
                modelo.getFabricante().setIdFabricante(rs.getInt("id_fab"));
                modelo.setIdModelo((rs.getInt("id_mod")));
                modelo.getFabricante().setNome(rs.getString("nome_fab"));
                listaModelo.add(modelo);
            }
            rs.close();
            stmt.close();
            con.close();
            return listaModelo;
        }

        public static List<ModeloBean> pesquisar(ModeloBean pesqMod) throws SQLException {
            List<ModeloBean> listaModelo = new ArrayList<ModeloBean>();
            Connection con = Conexao.getConexao();
            String sql = "select * from tb_fabrica inner join tb_modelo on tb_fabrica.id_fab = tb_modelo.id_fab where nome_mod like '" + pesqMod.getNome() + "%' order by nome_mod";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ModeloBean modelo = new ModeloBean();
                modelo.setFabricante(new FabricanteBean());
                modelo.setNome(rs.getString("nome_mod"));
                modelo.getFabricante().setIdFabricante(rs.getInt("id_fab"));
                modelo.setIdModelo((rs.getInt("id_mod")));
                modelo.getFabricante().setNome(rs.getString("nome_fab"));
                listaModelo.add(modelo);
            }
            rs.close();
            stmt.close();
            con.close();
            return listaModelo; 
        }
        
        public static List<ModeloBean> pesquisar(int idFab) throws SQLException {
            List<ModeloBean> listaModelo = new ArrayList<ModeloBean>();
            Connection con = Conexao.getConexao();
            String sql = "select * from tb_fabrica inner join tb_modelo on tb_fabrica.id_fab = tb_modelo.id_fab where id_fab like '" + idFab + "%'";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ModeloBean modelo = new ModeloBean();
                modelo.setFabricante(new FabricanteBean());
                modelo.setNome(rs.getString("nome_mod"));
                modelo.getFabricante().setIdFabricante(rs.getInt("id_fab"));
                modelo.setIdModelo((rs.getInt("id_mod")));
                modelo.getFabricante().setNome(rs.getString("nome_fab"));
                listaModelo.add(modelo);
            }
            rs.close();
            stmt.close();
            con.close();
            return listaModelo; 
        }     
}
