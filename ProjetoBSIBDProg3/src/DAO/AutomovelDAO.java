/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.AutomovelBean;
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
public class AutomovelDAO {
   public static void inserir(AutomovelBean automovel) throws SQLException{

           Connection con = Conexao.getConexao();
           String sql = "insert into tb_automovel (id_mod,cor,chassi,ano) values (?,?,?,?)";

           PreparedStatement stmt = con.prepareStatement(sql);
           stmt.setInt(1, automovel.getModelo().getIdModelo());
           stmt.setString(2, automovel.getCor());
           stmt.setString(3, automovel.getChassi());
           stmt.setInt(4, automovel.getAno());
           stmt.execute();
           stmt.close();
           con.close();

        }

        public static void alterar(AutomovelBean automovel) throws SQLException {
            Connection con = Conexao.getConexao();
            String sql = "update tb_automovel set id_mod = ?, cor = ?, chassi = ?, ano = ? where id_auto = ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, automovel.getModelo().getIdModelo());
            stmt.setString(2, automovel.getCor());
            stmt.setString(3, automovel.getChassi());
            stmt.setInt(4, automovel.getAno());
            stmt.setInt(5, automovel.getIdAutomovel());
            stmt.executeUpdate();
            stmt.close();
            con.close();

        }

        public static void excluir(AutomovelBean automovel) throws SQLException {
            Connection con = Conexao.getConexao();
            String sql = "delete from tb_automovel where id_auto = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, automovel.getIdAutomovel());
            stmt.executeUpdate();
            stmt.close();
            con.close();
        }

        public static List<AutomovelBean> pesquisar() throws SQLException {
            List<AutomovelBean> listaAutomovel = new ArrayList<AutomovelBean>();
            Connection con = Conexao.getConexao();
            String sql = "select * from tb_automovel";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                AutomovelBean automovel = new AutomovelBean();
                automovel.setIdAutomovel(rs.getInt("id_auto"));
                automovel.setCor((rs.getString("cor")));
                automovel.setChassi((rs.getString("chassi")));
                automovel.setAno((rs.getInt("ano")));
                automovel.getModelo().setIdModelo((rs.getInt("id_mod")));
                listaAutomovel.add(automovel);
            }
            rs.close();
            stmt.close();
            con.close();
            return listaAutomovel;
        }

        public static List<AutomovelBean> pesquisar(AutomovelBean pesqAuto) throws SQLException {
            List<AutomovelBean> listaAutomovel = new ArrayList<AutomovelBean>();
            Connection con = Conexao.getConexao();
            String sql = "select * from tb_automovel where id_mod like '" + pesqAuto.getModelo().getIdModelo()+ "%' order by nome_mod";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                AutomovelBean automovel = new AutomovelBean();
                automovel.setIdAutomovel(rs.getInt("id_auto"));
                automovel.setCor((rs.getString("cor")));
                automovel.setChassi((rs.getString("chassi")));
                automovel.setAno((rs.getInt("ano")));
                automovel.getModelo().setIdModelo((rs.getInt("id_mod")));
                listaAutomovel.add(automovel);
            }
            rs.close();
            stmt.close();
            con.close();
            return listaAutomovel;
        }      
}
