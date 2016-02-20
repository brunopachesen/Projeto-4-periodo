/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.ResultSet;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Bruno
 */
    
public class Relatorio {

    public static void gerarRelatorio(String caminho, ResultSet rs) throws JRException{
        try{
            //recebe um ResultSet vindo do banco de dados
            JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
            //imprime o relatorio
            JasperPrint jasperPrint = 
            JasperFillManager.fillReport
            (caminho, new HashMap(), jrRS);
            //Componente para visualizar o relatorio
            JasperViewer.viewReport(jasperPrint, false);                  
        } catch (Exception erro){
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Relatório não foi gerado.");
                }
    }
}
