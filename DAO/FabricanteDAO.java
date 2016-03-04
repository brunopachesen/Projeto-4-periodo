/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.EnderecoBean;
import Bean.FabricanteBean;
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
public class FabricanteDAO {
   public static void inserir(FabricanteBean fabricante) throws SQLException{

           Connection con = Conexao.getConexao();
           String sql = "insert into tb_fabrica (nome_fab,cnpj,tel,id_end) values (?,?,?,?)";

           PreparedStatement stmt = con.prepareStatement(sql);
           stmt.setString(1, fabricante.getNome());
           stmt.setString(2, fabricante.getCnpj());
           stmt.setString(3, fabricante.getTelefone());
           stmt.setInt(4, fabricante.getEndereco().getIdEndereco());
           stmt.execute();
           stmt.close();
           con.close();

        }

        public static void alterar(FabricanteBean fabricante) throws SQLException {
            Connection con = Conexao.getConexao();
            String sql = "update tb_fabrica set nome_fab = ?, cnpj = ?,tel = ?, id_end = ? where id_fab = ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, fabricante.getNome());
            stmt.setString(2, fabricante.getCnpj());
            stmt.setInt(3, fabricante.getEndereco().getIdEndereco());
            stmt.setInt(4, fabricante.getIdFabricante());
            stmt.executeUpdate();
            stmt.close();
            con.close();

        }

        public static void excluir(FabricanteBean fabricante) throws SQLException {
            Connection con = Conexao.getConexao();
            String sql = "delete from tb_fabrica where id_fab = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, fabricante.getIdFabricante());
            stmt.executeUpdate();
            stmt.close();
            con.close();
        }

        public static List<FabricanteBean> pesquisar() throws SQLException {
            List<FabricanteBean> listaFabrica = new ArrayList<FabricanteBean>();
            Connection con = Conexao.getConexao();
            String sql = "select * from tb_cidade inner join tb_endereco on tb_cidade.id_cid = tb_endereco.id_cid "
                    + "inner join tb_fabrica on tb_endereco.id_end = tb_fabrica.id_end";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                FabricanteBean fabricante = new FabricanteBean();
                fabricante.setEndereco(new EnderecoBean());
                fabricante.setNome(rs.getString("nome_fab"));
                fabricante.setIdFabricante((rs.getInt("id_fab")));
                fabricante.setCnpj((rs.getString("cnpj")));
                fabricante.setTelefone((rs.getString("tel")));
                fabricante.getEndereco().setIdEndereco(rs.getInt("id_end"));
                fabricante.getEndereco().getCidade().setNome(rs.getString("nome_cid"));
                listaFabrica.add(fabricante);
            }
            rs.close();
            stmt.close();
            con.close();
            return listaFabrica;
        }

        public static List<FabricanteBean> pesquisar(FabricanteBean pesqFab) throws SQLException {
            List<FabricanteBean> listaFabrica = new ArrayList<FabricanteBean>();
            Connection con = Conexao.getConexao();
            String sql = "select * from tb_fabrica where nome like '" + pesqFab.getNome() + "%'";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                FabricanteBean fabricante = new FabricanteBean();
                fabricante.setEndereco(new EnderecoBean());
                fabricante.setNome(rs.getString("nome"));
                fabricante.setIdFabricante((rs.getInt("id_fab")));
                fabricante.setCnpj((rs.getString("cnpj")));
                fabricante.setTelefone((rs.getString("tel")));
                fabricante.getEndereco().setIdEndereco(rs.getInt("id_end"));
                listaFabrica.add(fabricante);
            }
            stmt.close();
            rs.close();
            con.close();
            return listaFabrica; 
        }
        
        public static FabricanteBean pesquisar(String cnpj) throws SQLException {
            FabricanteBean fabricante = new FabricanteBean();
            Connection con = Conexao.getConexao();
            String sql = "select * from tb_fabrica where cnpj like '" + cnpj + "%'";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                fabricante.setEndereco(new EnderecoBean());
                fabricante.setNome(rs.getString("nome_fab"));
                fabricante.setIdFabricante((rs.getInt("id_fab")));
                fabricante.setCnpj((rs.getString("cnpj")));
                fabricante.setTelefone((rs.getString("tel")));
                fabricante.getEndereco().setIdEndereco(rs.getInt("id_end"));
            }
            stmt.close();
            rs.close();
            con.close();
            return fabricante; 
        }
}
