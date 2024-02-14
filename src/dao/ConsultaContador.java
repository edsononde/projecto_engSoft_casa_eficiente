/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entidades.users.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jason Matias
 */
public class ConsultaContador {
    private Conexao conexao;

    public ConsultaContador() {
        
        this.conexao = new Conexao();
    }
    public int contadorCliente() {
        
        
        String sql = "SELECT MAX(contador) as ultimo_id FROM contClientes;";
        int contador = 0;
        try {
            
            if(this.conexao.conectar()){
                
                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);
                
                ResultSet resultado = sentenca.executeQuery();
                while(resultado.next()){
                    
                    contador = resultado.getInt("ultimo_id");
                    
                }
                
                    
                    
                sentenca.close();
                
                this.conexao.getConexao().close();
                
            }
            
            return contador;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        
    }
    
}
