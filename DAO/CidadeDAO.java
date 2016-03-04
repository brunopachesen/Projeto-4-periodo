    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package DAO;

    import Bean.CidadeBean;
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
    public class CidadeDAO {
        public static void inserir(CidadeBean cidade) throws SQLException{

           Connection con = Conexao.getConexao();
           String sql = "insert into tb_cidade (nome_cid, uf) values (?,?)";

           PreparedStatement stmt = con.prepareStatement(sql);
           stmt.setString(1, cidade.getNome());
           stmt.setString(2, cidade.getEstado());
           stmt.execute();
           stmt.close();
           con.close();

        }

        public static void alterar(CidadeBean cidade) throws SQLException {
            Connection con = Conexao.getConexao();
            String sql = "update tb_cidade set nome_cid = ?, uf = ? where id_cid = ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cidade.getNome());
            stmt.setString(2, cidade.getEstado());
            stmt.setInt(3, cidade.getIdCidade());
            stmt.executeUpdate();
            stmt.close();
            con.close();

        }

        public static void excluir(CidadeBean cidade) throws SQLException {
            Connection con = Conexao.getConexao();
            String sql = "delete from tb_cidade where id_cid = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, cidade.getIdCidade());
            stmt.executeUpdate();
            stmt.close();
            con.close();
        }

        public static List<CidadeBean> pesquisar() throws SQLException {
            List<CidadeBean> listaCidade = new ArrayList<CidadeBean>();
            Connection con = Conexao.getConexao();
            String sql = "select * from tb_cidade order by nome_cid";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                CidadeBean cidade = new CidadeBean();
                cidade.setIdCidade((rs.getInt("id_cid")));
                cidade.setNome((rs.getString("nome_cid")));
                cidade.setEstado((rs.getString("uf")));
                listaCidade.add(cidade);
            }
            rs.close();
            stmt.close();
            con.close();
            return listaCidade;
        }

        public static List<CidadeBean> pesquisar(CidadeBean cidPesq) throws SQLException {
            List<CidadeBean> listaCidade = new ArrayList<CidadeBean>();
            Connection con = Conexao.getConexao();
            String sql = "select * from tb_cidade where nome_cid like '" + cidPesq.getNome() + "%' order by nome_cid";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                CidadeBean cidade = new CidadeBean();
                cidade.setIdCidade(rs.getInt("id_cid"));
                cidade.setNome(rs.getString("nome_cid"));
                cidade.setEstado(rs.getString("uf"));
                listaCidade.add(cidade);
            }
            stmt.close();
            rs.close();
            con.close();
            return listaCidade; 
        }
        public static List<CidadeBean> pesquisar(String estado) throws SQLException {
            List<CidadeBean> listaCidade = new ArrayList<CidadeBean>();
            Connection con = Conexao.getConexao();
            String sql = "select * from tb_cidade where uf like '" + estado + "%' order by nome_cid";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                CidadeBean cidade = new CidadeBean();
                cidade.setIdCidade(rs.getInt("id_cid"));
                cidade.setNome(rs.getString("nome_cid"));
                cidade.setEstado(rs.getString("uf"));
                listaCidade.add(cidade);
            }        
            stmt.close();
            rs.close();
            con.close();
            return listaCidade;
        }

    }
