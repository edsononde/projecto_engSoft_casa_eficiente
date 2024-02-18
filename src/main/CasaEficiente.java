
package main;

import dao.Conexao;
import entidades.acoes.Contrato;
import java.sql.Connection;
import javax.swing.JOptionPane;


public class CasaEficiente {


    public static void main(String[] args) {
       Contrato contrato = new Contrato();
        //System.out.println(contrato);
        //JOptionPane.showMessageDialog(null, contrato.toString(), "Detalhes do Contracto", 2);
        
        Conexao conectar = new Conexao();
        
        if(conectar.conectar())
            System.out.println("Boa");
        else
            System.out.println("FALHA");
    }
    
}
