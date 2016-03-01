/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import Bean.AutomovelBean;
import Bean.CidadeBean;
import Bean.ClienteBean;
import Bean.EnderecoBean;
import DAO.CidadeDAO;
import DAO.ClienteDAO;
import DAO.EnderecoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Talita
 */
public class jiCadCliente2 extends javax.swing.JInternalFrame {
    List<CidadeBean> listaCidade = new ArrayList<CidadeBean>();
    boolean salvar = false;
    int id = 0;
    
    /**
     * Creates new form jiCadCliente
     */
    public jiCadCliente2() {
        initComponents();
        salvar = true;
    }
    
    public jiCadCliente2(ClienteBean cliente) {
        initComponents();
        salvar = true;
        id = cliente.getIdCliente();
    }
    private void preencherCidades(){
        if(cbEstado.getSelectedIndex() == 0){
            
        }else{
    cbCidade.removeAllItems();
    cbCidade.addItem("Selecione");
    try {
        listaCidade = CidadeDAO.pesquisar(cbEstado.getSelectedItem().toString());
        for(CidadeBean cidade : listaCidade){
         cbCidade.addItem(cidade.getNome());
        }
    } catch (SQLException ex) {
        Logger.getLogger(CadFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    }
    
    /*private void preencherCampos(ClienteBean cliente){
    txCidade.setText(cliente.getNome());
    cbEstado.setSelectedItem(cliente.getEstado());
    }*/
     
     private EnderecoBean cadastraEndereco() throws SQLException{
       EnderecoBean endereco = new EnderecoBean();
       endereco.setCidade(listaCidade.get(cbCidade.getSelectedIndex()-1));
       endereco.setNum(txNum.getText());
       endereco.setRua(txRua.getText());
       endereco.setIdEndereco(id);
       EnderecoDAO.inserir(endereco);  
       return EnderecoDAO.retornar();
     }
     private ClienteBean retornaObjeto() throws SQLException{
        ClienteBean cliente = new ClienteBean();
        cliente.setNome(txNome.getText().toUpperCase());
        cliente.setCpf(ftxCpf.getText());
        cliente.setTelefone(ftxTelefone.getText());      
        //cliente.setEstado(cbEstado.getSelectedItem().toString());
        cliente.setIdCliente(id);
        cliente.setEndereco(cadastraEndereco());
        cliente.setAutomovel(new AutomovelBean());
        cliente.getAutomovel().setIdAutomovel(1);

        return cliente;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ftxCpf = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        ftxTelefone = new javax.swing.JFormattedTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txRua = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txNum = new javax.swing.JTextField();
        cbEstado = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbCidade = new javax.swing.JComboBox();
        btSalvar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        lbMensagem = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Cadastro de Cliente");
        setToolTipText("");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nome");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));
        jPanel1.add(txNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 279, -1));

        jLabel2.setText("CPF");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 20));

        try {
            ftxCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(ftxCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 120, -1));

        jLabel3.setText("Telefone");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, -1, 20));

        try {
            ftxTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(ftxTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 100, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 320, 10));

        jLabel4.setText("Dados Pessoais");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        jLabel5.setText("Endereço");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, -1, -1));

        jLabel6.setText("Rua");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, 20));
        jPanel1.add(txRua, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 200, -1));

        jLabel7.setText("Nº");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, -1, 20));
        jPanel1.add(txNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 50, -1));

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        cbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEstadoActionPerformed(evt);
            }
        });
        jPanel1.add(cbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        jLabel8.setText("UF");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, 20));

        jLabel9.setText("Cidade");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, -1, 20));

        cbCidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));
        jPanel1.add(cbCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 80, -1));

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botão salvar.png"))); // NOI18N
        btSalvar.setBorder(null);
        btSalvar.setBorderPainted(false);
        btSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btSalvarMouseReleased(evt);
            }
        });
        jPanel1.add(btSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 90, -1));

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botão cancelar.png"))); // NOI18N
        btCancelar.setBorder(null);
        btCancelar.setBorderPainted(false);
        jPanel1.add(btCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, -1, -1));
        jPanel1.add(lbMensagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 160, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(0, 0, 437, 332);
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSalvarMouseReleased
        try {
            ClienteDAO.inserir(retornaObjeto());
        } catch (SQLException ex) {
            Logger.getLogger(jiCadCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btSalvarMouseReleased

    private void cbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEstadoActionPerformed
      preencherCidades();
    }//GEN-LAST:event_cbEstadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox cbCidade;
    private javax.swing.JComboBox cbEstado;
    private javax.swing.JFormattedTextField ftxCpf;
    private javax.swing.JFormattedTextField ftxTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbMensagem;
    private javax.swing.JTextField txNome;
    private javax.swing.JTextField txNum;
    private javax.swing.JTextField txRua;
    // End of variables declaration//GEN-END:variables
}
