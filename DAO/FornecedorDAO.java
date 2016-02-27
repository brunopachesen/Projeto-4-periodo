/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


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
public class FornecedorDAO {
    
     public static void inserir(FornecedorBean fornecedor) throws SQLException{

           Connection con = Conexao.getConexao();
           String sql = "insert into tb_fornecedor (cnpj,tel,id_end) values (?,?)";

           PreparedStatement stmt = con.prepareStatement(sql);
           stmt.setString(1, fornecedor.getCnpj());
           stmt.setString(2, fornecedor.getTelefone());
           stmt.setInt(3, fornecedor.getEndereço().getIdEndereco());
           stmt.execute();
           stmt.close();
           con.close();

        }

        public static void alterar(FornecedorBean fornecedor) throws SQLException {
            Connection con = Conexao.getConexao();
            String sql = "update tb_fornecedor set cnpj = ?, tel = ?,id_end = ? where id_for = ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, fornecedor.getCnpj());
            stmt.setString(2, fornecedor.getTelefone());
            stmt.setInt(3, fornecedor.getEndereço().getIdEndereco());
            stmt.setInt(4, fornecedor.getIdFornecedor());
            stmt.executeUpdate();
            stmt.close();
            con.close();

        }

        public static void excluir(FornecedorBean fornecedor) throws SQLException {
            Connection con = Conexao.getConexao();
            String sql = "delete from tb_fornecedor where id_for = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, fornecedor.getIdFornecedor());
            stmt.executeUpdate();
            stmt.close();
            con.close();
        }

        public static List<FornecedorBean> pesquisar() throws SQLException {
            List<FornecedorBean> listaFornecedor = new ArrayList<FornecedorBean>();
            Connection con = Conexao.getConexao();
            String sql = "select * from tb_fornecedor";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                FornecedorBean fornecedor = new FornecedorBean();
                fornecedor.setIdFornecedor((rs.getInt("id_for")));
                fornecedor.setCnpj((rs.getString("cnpj")));
                fornecedor.setTelefone((rs.getString("tel")));
                listaFornecedor.add(fornecedor);
            }
            rs.close();
            stmt.close();
            con.close();
            return listaFornecedor;
        }

        public static List<FornecedorBean> pesquisar(FornecedorBean pesqFor) throws SQLException {
            List<FornecedorBean> listaFornecedor = new ArrayList<FornecedorBean>();
            Connection con = Conexao.getConexao();
            String sql = "select * from tb_fornecedor where cnpj like '" + pesqFor.getCnpj() + "%'";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                FornecedorBean fornecedor = new FornecedorBean();
                fornecedor.setIdFornecedor((rs.getInt("id_for")));
                fornecedor.setCnpj((rs.getString("cnpj")));
                fornecedor.setTelefone((rs.getString("tel")));
                listaFornecedor.add(fornecedor);
            }
            stmt.close();
            rs.close();
            con.close();
            return listaFornecedor; 
        }
}
