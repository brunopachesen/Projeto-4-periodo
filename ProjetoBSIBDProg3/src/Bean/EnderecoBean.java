/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author Bruno
 */
public class EnderecoBean {
    
    private int idEndereco;
    private CidadeBean Cidade;
    private String rua;
    private String num;

    /**
     * @return the idEndereco
     */
    public int getIdEndereco() {
        return idEndereco;
    }

    /**
     * @param idEndereco the idEndereco to set
     */
    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    /**
     * @return the idCidade
     */
    public CidadeBean getCidade() {
        return Cidade;
    }

    /**
     * @param idCidade the idCidade to set
     */
    public void setCidade(CidadeBean Cidade) {
        this.Cidade = Cidade;
    }

    /**
     * @return the rua
     */
    public String getRua() {
        return rua;
    }

    /**
     * @param rua the rua to set
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /**
     * @return the num
     */
    public String getNum() {
        return num;
    }

    /**
     * @param num the num to set
     */
    public void setNum(String num) {
        this.num = num;
    }
}
