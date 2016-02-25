/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import Bean.CidadeBean;
import DAO.CidadeDAO;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.border.LineBorder;

/**
 *
 * @author Talita
 */
public class jiCadCidade extends javax.swing.JInternalFrame {

    private boolean salvar =false;
    private int id = 0;
    
    public jiCadCidade() {
        initComponents();
        salvar = true;
    }
    
    public jiCadCidade(CidadeBean cidade) {
        initComponents();
            preencherCampos(cidade);
            salvar = false;
            id = cidade.getIdCidade();
    }
    
    private void preencherCampos(CidadeBean cidade){
    txCidade.setText(cidade.getNome());
    cbEstado.setSelectedItem(cidade.getEstado());
    }

    private CidadeBean retornaObjeto(){
        CidadeBean cidade = new CidadeBean();
        cidade.setNome(txCidade.getText().toUpperCase());
        cidade.setEstado(cbEstado.getSelectedItem().toString());
        cidade.setIdCidade(id);
        return cidade;
        
    }
    private boolean validaCampos(){
        boolean validador = true;
        txCidade.setText(txCidade.getText().trim());
        if(txCidade.getText().equals("")){
            validador = false;
            txCidade.setBorder(BorderFactory.createLineBorder(Color.red));
            lbMensagem.setText("*Campos obrigatorios não preenchidos!");
        }else{
            txCidade.setBorder(BorderFactory.createEmptyBorder());
        }
        if(cbEstado.getSelectedIndex() == 0) {
            validador = false;
            cbEstado.setBorder(new LineBorder(Color.RED));
        }else{
            cbEstado.setBorder(BorderFactory.createEmptyBorder());
        }
        return validador;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        try {
            jPanel1 =(javax.swing.JPanel)java.beans.Beans.instantiate(getClass().getClassLoader(), "telas.jiCadCidade_jPanel1");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        txCidade = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lbMensagem = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Cadastro de Cidades");
        setToolTipText("");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(txCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 176, -1));

        jLabel2.setText("Cidade");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 20));

        jLabel3.setText("UF");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 20, 20));

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        jPanel1.add(cbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 100, -1));

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botão salvar.png"))); // NOI18N
        btnSalvar.setBorder(null);
        btnSalvar.setBorderPainted(false);
        btnSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnSalvarMouseReleased(evt);
            }
        });
        jPanel1.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 90, -1));

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botão cancelar.png"))); // NOI18N
        btnCancelar.setBorder(null);
        btnCancelar.setBorderPainted(false);
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnCancelarMouseReleased(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, -1, -1));
        jPanel1.add(lbMensagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 236, 21));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        setBounds(0, 0, 374, 272);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarMouseReleased
        if (validaCampos()){
            try{
                if(salvar){
                    CidadeDAO.inserir(retornaObjeto());
                    lbMensagem.setText("Salvo com sucesso");
                }else{
                    CidadeDAO.alterar(retornaObjeto());
                    lbMensagem.setText("Salvo com sucesso");
                }
                this.dispose();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnSalvarMouseReleased

    private void btnCancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseReleased
        this.dispose();
    }//GEN-LAST:event_btnCancelarMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cbEstado;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbMensagem;
    private javax.swing.JTextField txCidade;
    // End of variables declaration//GEN-END:variables
}
