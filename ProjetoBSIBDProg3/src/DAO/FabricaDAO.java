/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.EnderecoBean;
import Bean.FabricaBean;
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
public class FabricaDAO {
   public static void inserir(FabricaBean fabrica) throws SQLException{

           Connection con = Conexao.getConexao();
           String sql = "insert into tb_montadora (nome,cnpj,tel,id_end) values (?,?,?,?)";

           PreparedStatement stmt = con.prepareStatement(sql);
           stmt.setString(1, fabrica.getNome());
           stmt.setString(2, fabrica.getCnpj());
           stmt.setString(3, fabrica.getTelefone());
           stmt.setInt(4, fabrica.getEndereco().getIdEndereco());
           stmt.execute();
           stmt.close();
           con.close();

        }

        public static void alterar(FabricaBean fabrica) throws SQLException {
            Connection con = Conexao.getConexao();
            String sql = "update tb_fabrica set nome = ?, cnpj = ?,tel = ?, id_end = ? where id_fab = ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, fabrica.getNome());
            stmt.setString(2, fabrica.getCnpj());
            stmt.setInt(3, fabrica.getEndereco().getIdEndereco());
            stmt.setInt(4, fabrica.getIdFabrica());
            stmt.executeUpdate();
            stmt.close();
            con.close();

        }

        public static void excluir(FabricaBean fabrica) throws SQLException {
            Connection con = Conexao.getConexao();
            String sql = "delete from tb_fabrica where id_fab = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, fabrica.getIdFabrica());
            stmt.executeUpdate();
            stmt.close();
            con.close();
        }

        public static List<FabricaBean> pesquisar() throws SQLException {
            List<FabricaBean> listaFabrica = new ArrayList<FabricaBean>();
            Connection con = Conexao.getConexao();
            String sql = "select * from tb_fabrica";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                FabricaBean fabrica = new FabricaBean();
                fabrica.setEndereco(new EnderecoBean());
                fabrica.setNome(rs.getString("nome"));
                fabrica.setIdFabrica((rs.getInt("id_fab")));
                fabrica.setCnpj((rs.getString("cnpj")));
                fabrica.setTelefone((rs.getString("tel")));
                fabrica.getEndereco().setIdEndereco(rs.getInt("id_end"));
                listaFabrica.add(fabrica);
            }
            rs.close();
            stmt.close();
            con.close();
            return listaFabrica;
        }

        public static List<FabricaBean> pesquisar(FabricaBean pesqFab) throws SQLException {
            List<FabricaBean> listaFabrica = new ArrayList<FabricaBean>();
            Connection con = Conexao.getConexao();
            String sql = "select * from tb_fabrica where cnpj like '" + pesqFab.getCnpj() + "%'";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                FabricaBean fabrica = new FabricaBean();
                fabrica.setEndereco(new EnderecoBean());
                fabrica.setNome(rs.getString("nome"));
                fabrica.setIdFabrica((rs.getInt("id_fab")));
                fabrica.setCnpj((rs.getString("cnpj")));
                fabrica.setTelefone((rs.getString("tel")));
                fabrica.getEndereco().setIdEndereco(rs.getInt("id_end"));
                listaFabrica.add(fabrica);
            }
            stmt.close();
            rs.close();
            con.close();
            return listaFabrica; 
        } 
}
