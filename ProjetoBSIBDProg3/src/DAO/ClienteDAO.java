/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.AutomovelBean;
import Bean.CidadeBean;
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
public class ClienteDAO {
   public static void inserir(ClienteBean cliente) throws SQLException{

           Connection con = Conexao.getConexao();
           String sql = "insert into tb_cliente (nome_cli,tel,cpf,id_auto,id_end) values (?,?,?,?,?)";
           PreparedStatement stmt = con.prepareStatement(sql);
           stmt.setString(1, cliente.getNome());
           stmt.setString(2, cliente.getTelefone());
           stmt.setString(3, cliente.getCpf());
           stmt.setInt(4,cliente.getAutomovel().getIdAutomovel());
           stmt.setInt(5, cliente.getEndereco().getIdEndereco());
           stmt.execute();
           stmt.close();
           con.close();

        }

        public static void alterar(ClienteBean cliente) throws SQLException {
            Connection con = Conexao.getConexao();
            String sql = "update tb_automovel set nome_cli = ?, tel = ?,cpf = ?, id_auto = ?, id_end = ? where id_cli = ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
           stmt.setString(2, cliente.getTelefone());
           stmt.setString(3, cliente.getCpf());
           stmt.setInt(4,cliente.getAutomovel().getIdAutomovel());
           stmt.setInt(5, cliente.getEndereco().getIdEndereco());
            stmt.setInt(6, cliente.getIdCliente());
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

        public static List<ClienteBean> pesquisar() throws SQLException {
            List<ClienteBean> listaCliente = new ArrayList<ClienteBean>();
            Connection con = Conexao.getConexao();
            String sql = "select * from tb_cliente";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ClienteBean cliente = new ClienteBean();
                cliente.setAutomovel(new AutomovelBean());
                cliente.setEndereco(new EnderecoBean());
                
                cliente.setIdCliente(rs.getInt("id_cli"));
                cliente.setNome(rs.getString("nome_cli"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setTelefone(rs.getString("tel"));
                cliente.getEndereco().setIdEndereco(rs.getInt("id_end"));
                cliente.getAutomovel().setIdAutomovel(rs.getInt("id_auto"));
                listaCliente.add(cliente);
            }
            rs.close();
            stmt.close();
            con.close();
            return listaCliente;
        }

        public static List<ClienteBean> pesquisar(ClienteBean pesqCliente) throws SQLException {
            List<ClienteBean> listaCliente = new ArrayList<ClienteBean>();
            Connection con = Conexao.getConexao();
            String sql = "select * from tb_cliente where id_cli like '" + pesqCliente.getIdCliente()+ "%' order by nome_cli";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ClienteBean cliente = new ClienteBean();
                cliente.setAutomovel(new AutomovelBean());
                cliente.setEndereco(new EnderecoBean());
                
                cliente.setIdCliente(rs.getInt("id_cli"));
                cliente.setNome(rs.getString("nome_cli"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setTelefone(rs.getString("tel"));
                cliente.getEndereco().setIdEndereco(rs.getInt("id_end"));
                cliente.getAutomovel().setIdAutomovel(rs.getInt("id_auto"));
                listaCliente.add(cliente);
            }
            rs.close();
            stmt.close();
            con.close();
            return listaCliente;
        }       
}
