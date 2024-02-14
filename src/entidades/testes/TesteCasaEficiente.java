/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades.testes;

import dao.ClienteDao;
import dao.ConsultaContador;
import entidades.acoes.Contrato;
import entidades.users.Cliente;
import entidades.users.Corretor;
import entidades.enumerados.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author edson
 */
public class TesteCasaEficiente {
    public static void main(String[] args) throws ParseException {
        //Contrato contrato;
        //Cliente cliente = new Cliente("123", "Edson", "22-12-2001", "123");
        //System.out.println(cliente);
        //JOptionPane.showMessageDialog(null, cliente.toString(), "Detalhes do Cliente", 2);
        
        /*String formato = "dd-MM-yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        String dataString = "22-11-2002";
        Date data = sdf.parse(dataString);
        String date = sdf.format(data);
        System.out.println(date);
        
        
        Corretor corretor = new Corretor("123", "Paulo Pedro", dataString, "589");
        System.out.println(corretor);
        
        //contrato = new Contrato("Bla bla bla bala bala abjkncnfenwflfrk", "22/12/13", 15246.0, cliente, corretor);
        //JOptionPane.showMessageDialog(null, contrato.toString(), "Detalhes do Contracto", 2);
        
        //Imovel imovel = new Imovel();
        */
        
        /*Cliente c = new Cliente();
        
        c.setIdUser("1");
        c.setNome("Edson Silva");
        c.setSenha("1000");
        c.setEndereco("Benfica");
        c.setDataNascimento("1987-11-21");*/
        
        
        
        ConsultaContador cont = new ConsultaContador();
        System.out.println(cont.contadorCliente());
    }
    
    
    public static String formataData(Date data){
    
        String formato = "dd-MM-yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        String date = sdf.format(data);
        return date;
    }
    
}
