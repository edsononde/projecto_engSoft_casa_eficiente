
package main;

import entidades.acoes.Contrato;
import javax.swing.JOptionPane;


public class CasaEficiente {


    public static void main(String[] args) {
       Contrato contrato = new Contrato();
        //System.out.println(contrato);
        JOptionPane.showMessageDialog(null, contrato.toString(), "Detalhes do Contracto", 2);
    }
    
}
