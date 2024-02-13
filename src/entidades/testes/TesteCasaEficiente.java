/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades.testes;

import entidades.acoes.Contrato;
import entidades.users.Cliente;
import entidades.users.Corretor;
import entidades.enumerados.*;
import javax.swing.JOptionPane;

/**
 *
 * @author edson
 */
public class TesteCasaEficiente {
    public static void main(String[] args) {
        Contrato contrato;
        Cliente cliente = new Cliente("123", "Edson", "22/12/2001", "123");
        //System.out.println(cliente);
        //JOptionPane.showMessageDialog(null, cliente.toString(), "Detalhes do Cliente", 2);
        
        Corretor corretor = new Corretor("123", "Paulo Pedro", "22/08/2023", "589");
        //System.out.println(corretor);
        
        contrato = new Contrato("Bla bla bla bala bala abjkncnfenwflfrk", "22/12/13", 15246.0, cliente, corretor);
        JOptionPane.showMessageDialog(null, contrato.toString(), "Detalhes do Contracto", 2);
        
        //Imovel imovel = new Imovel();
    }
    
}
