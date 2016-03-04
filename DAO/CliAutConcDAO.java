/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.CliAutConcBean;
import Bean.ClienteBean;
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
public class CliAutConcDAO {
 public static void inserir(CliAutConcBean cliAutConc) throws SQLException{

           Connection con = Conexao.getConexao();
           String sql = "insert into tb_cli_auto_conc (id_cli,id_auto,id_conc) values (?,?,?)";
           PreparedStatement stmt = con.prepareStatement(sql);
           stmt.setInt(1, cliAutConc.getCliente().getIdCliente());
           stmt.setInt(2, cliAutConc.getAutomovel().getIdAutomovel());
           stmt.setInt(3, cliAutConc.getConcessionaria().getIdConcessionaria());
           stmt.execute();
           stmt.close();
           con.close();

        }

        public static void alterar(CliAutConcBean cliAutConc) throws SQLException {
            Connection con = Conexao.getConexao();
            String sql = "update tb_cli_auto_conc set id_cli = ?, id_auto = ?,id_conc = ? where id_cli_auto_conc = ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
             stmt.setInt(1, cliAutConc.getCliente().getIdCliente());
           stmt.setInt(2, cliAutConc.getAutomovel().getIdAutomovel());
           stmt.setInt(3, cliAutConc.getConcessionaria().getIdConcessionaria());
            stmt.setInt(5, cliAutConc.getIdCliAutConc());
            stmt.executeUpdate();
            stmt.close();
            con.close();

        }

        public static void excluir(CliAutConcBean cliAutConc) throws SQLException {
            Connection con = Conexao.getConexao();
            String sql = "delete from tb_cli_auto_conc where id_cli_auto_conc = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, cliAutConc.getIdCliAutConc());
            stmt.executeUpdate();
            stmt.close();
            con.close();
        }

        public static List<CliAutConcBean> pesquisar() throws SQLException {
            List<CliAutConcBean> listaCliAutConc = new ArrayList<CliAutConcBean>();
            Connection con = Conexao.getConexao();
            String sql = "select * from tb_cli_auto_conc";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                CliAutConcBean cliAutConc = new CliAutConcBean();
                cliAutConc.getCliente().setIdCliente(rs.getInt("id_cli"));
                cliAutConc.getAutomovel().setIdAutomovel(rs.getInt("id_auto"));
                cliAutConc.getConcessionaria().setIdConcessionaria(rs.getInt("id_conc"));
                cliAutConc.setIdCliAutConc(rs.getInt("id_cli_auto_conc"));

                listaCliAutConc.add(cliAutConc);
            }
            rs.close();
            stmt.close();
            con.close();
            return listaCliAutConc;
        }

        public static List<CliAutConcBean> pesquisar(CliAutConcBean pesqCliAutConc) throws SQLException {
            List<CliAutConcBean> listaCliAutConc = new ArrayList<CliAutConcBean>();
            Connection con = Conexao.getConexao();
            String sql = "select * from tb_cli_auto_conc where id_cli_auto_conc = '"+ pesqCliAutConc.getIdCliAutConc()+ "'";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                CliAutConcBean cliAutConc = new CliAutConcBean();
                cliAutConc.getCliente().setIdCliente(rs.getInt("id_cli"));
                cliAutConc.getAutomovel().setIdAutomovel(rs.getInt("id_auto"));
                cliAutConc.getConcessionaria().setIdConcessionaria(rs.getInt("id_conc"));
                cliAutConc.setIdCliAutConc(rs.getInt("id_cli_auto_conc"));

                listaCliAutConc.add(cliAutConc);
            }
            rs.close();
            stmt.close();
            con.close();
            return listaCliAutConc;
        }           
}
