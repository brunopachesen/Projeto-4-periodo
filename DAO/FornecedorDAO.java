/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Bean.EnderecoBean;
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
           String sql = "insert into tb_fornecedor (cnpj,tel,id_end) values (?,?,?)";

           PreparedStatement stmt = con.prepareStatement(sql);
           stmt.setString(1, fornecedor.getCnpj());
           stmt.setString(2, fornecedor.getTelefone());
           stmt.setInt(3, fornecedor.getEndereco().getIdEndereco());
           stmt.execute();
           stmt.close();
           con.close();

        }

        public static void alterar(FornecedorBean fornecedor) throws SQLException {
            Connection con = Conexao.getConexao();
            String sql = "update tb_fornecedor set cnpj = ?, tel = ?,id_end = ? where id_forn = ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, fornecedor.getCnpj());
            stmt.setString(2, fornecedor.getTelefone());
            stmt.setInt(3, fornecedor.getEndereco().getIdEndereco());
            stmt.setInt(4, fornecedor.getIdFornecedor());
            stmt.executeUpdate();
            stmt.close();
            con.close();

        }

        public static void excluir(FornecedorBean fornecedor) throws SQLException {
            Connection con = Conexao.getConexao();
            String sql = "delete from tb_fornecedor where id_forn = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, fornecedor.getIdFornecedor());
            stmt.executeUpdate();
            stmt.close();
            con.close();
        }

        public static List<FornecedorBean> pesquisar() throws SQLException {
            List<FornecedorBean> listaFornecedor = new ArrayList<FornecedorBean>();
            Connection con = Conexao.getConexao();
            String sql = "select * from tb_cidade inner join tb_endereco on tb_cidade.id_cid = tb_endereco.id_cid "
                    + " inner join tb_fornecedor on tb_endereco.id_end = tb_fornecedor.id_end";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                FornecedorBean fornecedor = new FornecedorBean();
                fornecedor.setEndereco(new EnderecoBean());
                fornecedor.setIdFornecedor((rs.getInt("id_forn")));
                fornecedor.setCnpj((rs.getString("cnpj")));
                fornecedor.setTelefone((rs.getString("tel")));
                fornecedor.getEndereco().setIdEndereco(rs.getInt("id_end"));
                fornecedor.getEndereco().getCidade().setNome(rs.getString("nome_cid"));
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
            String sql = "select * from select * from tb_cidade inner join tb_endereco on tb_cidade.id_cid = tb_endereco.id_cid "
                    + " inner join tb_fornecedor on tb_endereco.id_end = tb_fornecedor.id_end where cnpj like '" + pesqFor.getCnpj() + "%'";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                FornecedorBean fornecedor = new FornecedorBean();
                fornecedor.setIdFornecedor((rs.getInt("id_forn")));
                fornecedor.setCnpj((rs.getString("cnpj")));
                fornecedor.setTelefone((rs.getString("tel")));
                fornecedor.getEndereco().setIdEndereco(rs.getInt("id_end"));
                listaFornecedor.add(fornecedor);
            }
            stmt.close();
            rs.close();
            con.close();
            return listaFornecedor; 
        }
}
