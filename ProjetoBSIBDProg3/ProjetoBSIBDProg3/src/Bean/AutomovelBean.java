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
public class AutomovelBean {
    
    private String idAutomovel;
    private ModeloBean modelo;
    private String cor;
    private String Chassi;
    private int ano;

    /**
     * @return the idAutomovel
     */
    public String getIdAutomovel() {
        return idAutomovel;
    }

    /**
     * @param idAutomovel the idAutomovel to set
     */
    public void setIdAutomovel(String idAutomovel) {
        this.idAutomovel = idAutomovel;
    }

    /**
     * @return the modelo
     */
    public ModeloBean getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(ModeloBean modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the cor
     */
    public String getCor() {
        return cor;
    }

    /**
     * @param cor the cor to set
     */
    public void setCor(String cor) {
        this.cor = cor;
    }

    /**
     * @return the Chassi
     */
    public String getChassi() {
        return Chassi;
    }

    /**
     * @param Chassi the Chassi to set
     */
    public void setChassi(String Chassi) {
        this.Chassi = Chassi;
    }

    /**
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
    }
    
    
}
