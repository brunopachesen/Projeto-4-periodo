/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Bean.EnderecoBean;
import Bean.TransportadoraBean;
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
public class TransportadoraDAO {
        public static void inserir(TransportadoraBean transportadora) throws SQLException{

           Connection con = Conexao.getConexao();
           String sql = "insert into tb_concessinaria (nome_conc,tel,cnpj,id_end) values (?,?,?,?)";
           PreparedStatement stmt = con.prepareStatement(sql);
           stmt.setString(1, transportadora.getNome());
           stmt.setString(2, transportadora.getTelefone());
           stmt.setString(3, transportadora.getCnpj());
           stmt.setInt(4, transportadora.getEndereco().getIdEndereco());
           stmt.execute();
           stmt.close();
           con.close();

        }

        public static void alterar(ConcessionariaBean concessionaria) throws SQLException {
            Connection con = Conexao.getConexao();
            String sql = "update tb_concessionaria set nome_conc = ?, tel = ?,cpnj = ?, id_end = ? where id_conc = ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, concessionaria.getNome());
           stmt.setString(2, concessionaria.getTelefone());
           stmt.setString(3, concessionaria.getCnpj());
           stmt.setInt(4, concessionaria.getEndereco().getIdEndereco());
            stmt.setInt(5, concessionaria.getIdConcessionaria());
            stmt.executeUpdate();
            stmt.close();
            con.close();

        }

        public static void excluir(ConcessionariaBean concessionaria) throws SQLException {
            Connection con = Conexao.getConexao();
            String sql = "delete from tb_concessionaria where id_conc = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, concessionaria.getIdConcessionaria());
            stmt.executeUpdate();
            stmt.close();
            con.close();
        }

        public static List<ConcessionariaBean> pesquisar() throws SQLException {
            List<ConcessionariaBean> listaConcessionaria = new ArrayList<ConcessionariaBean>();
            Connection con = Conexao.getConexao();
            String sql = "select * from tb_concessionaria";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ConcessionariaBean concessionaria = new ConcessionariaBean();
                concessionaria.setEndereco(new EnderecoBean());
                
                concessionaria.setIdConcessionaria(rs.getInt("id_conc"));
                concessionaria.setNome(rs.getString("nome_conc"));
                concessionaria.setCnpj(rs.getString("cnpj"));
                concessionaria.setTelefone(rs.getString("tel"));
                concessionaria.getEndereco().setIdEndereco(rs.getInt("id_end"));
                listaConcessionaria.add(concessionaria);
            }
            rs.close();
            stmt.close();
            con.close();
            return listaConcessionaria;
        }

        public static List<ConcessionariaBean> pesquisar(ConcessionariaBean pesqConc) throws SQLException {
            List<ConcessionariaBean> listaConcessionaria = new ArrayList<ConcessionariaBean>();
            Connection con = Conexao.getConexao();
            String sql = "select * from tb_concessionaria where id_conc like '" + pesqConc.getIdConcessionaria()+ "%' order by nome_conc";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                                ConcessionariaBean concessionaria = new ConcessionariaBean();
                concessionaria.setEndereco(new EnderecoBean());
                
                concessionaria.setIdConcessionaria(rs.getInt("id_conc"));
                concessionaria.setNome(rs.getString("nome_conc"));
                concessionaria.setCnpj(rs.getString("cnpj"));
                concessionaria.setTelefone(rs.getString("tel"));
                concessionaria.getEndereco().setIdEndereco(rs.getInt("id_end"));
                listaConcessionaria.add(concessionaria);
            }
            rs.close();
            stmt.close();
            con.close();
            return listaConcessionaria;
        }  
}
