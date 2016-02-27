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
public class ConcessionariaBean {
    
   private int idConcessionaria;
   private String cnpj;
   private EnderecoBean endereco;
   private String telefone;
   private String nome;
   private CidadeBean cidade;

    /**
     * @return the idConcessionaria
     */
    public int getIdConcessionaria() {
        return idConcessionaria;
    }

    /**
     * @param idConcessionaria the idConcessionaria to set
     */
    public void setIdConcessionaria(int idConcessionaria) {
        this.idConcessionaria = idConcessionaria;
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the endereco
     */
    public EnderecoBean getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(EnderecoBean endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cidade
     */
    public CidadeBean getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(CidadeBean cidade) {
        this.cidade = cidade;
    }
}
