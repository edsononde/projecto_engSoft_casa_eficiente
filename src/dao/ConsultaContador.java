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
    
    
    
    public int contadorCorretor() {
        
        
        String sql = "SELECT MAX(contador) as ultimo_id FROM contCorretores;";
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
    
    public void incrementaClientes() {
       
        String sql = "INSERT INTO contClientes() VALUES ();";
        try {
            
            if(this.conexao.conectar()){
                
                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);
                
                
                sentenca.execute();
              
                sentenca.close();
                
                this.conexao.getConexao().close();
                
            }
            
          
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        
    
    }
    
    
    public void incrementaCorretores() {
       
        String sql = "INSERT INTO contCorretorres() VALUES ();";
        try {
            
            if(this.conexao.conectar()){
                
                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);
                
                
                sentenca.execute();
              
                sentenca.close();
                
                this.conexao.getConexao().close();
                
            }
            
          
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        
    
    }
    
    public int contadorGestor() {
        
        
        String sql = "SELECT MAX(contador) as ultimo_id FROM contgestor;";
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
    
    
    public void incrementaGestores() {
       
        String sql = "INSERT INTO contgestor() VALUES ();";
        try {
            
            if(this.conexao.conectar()){
                
                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);
                
                
                sentenca.execute();
              
                sentenca.close();
                
                this.conexao.getConexao().close();
                
            }
            
          
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        
    
    }
    
    public int contadorManutencao() {
        
        
        String sql = "SELECT MAX(contador) as ultimo_id FROM contmanutencao;";
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
    
    public void incrementaManutencoes() {
       
        String sql = "INSERT INTO contmanutencao() VALUES ();";
        try {
            
            if(this.conexao.conectar()){
                
                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);
                
                
                sentenca.execute();
              
                sentenca.close();
                
                this.conexao.getConexao().close();
                
            }
            
          
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        
    
    }
    
    public int contadorImovel() {
        
        
        String sql = "SELECT MAX(contador) as ultimo_id FROM contimovel;";
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
    
    public void incrementaImoveis() {
       
        String sql = "INSERT INTO contimovel() VALUES ();";
        try {
            
            if(this.conexao.conectar()){
                
                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);
                
                
                sentenca.execute();
              
                sentenca.close();
                
                this.conexao.getConexao().close();
                
            }
            
          
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        
    
    }
    
    public int contadorTecnico() {
        
        
        String sql = "SELECT MAX(contador) as ultimo_id FROM conttecnico;";
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
    
    public void incrementaTecnicos() {
       
        String sql = "INSERT INTO conttecnico() VALUES ();";
        try {
            
            if(this.conexao.conectar()){
                
                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);
                
                
                sentenca.execute();
              
                sentenca.close();
                
                this.conexao.getConexao().close();
                
            }
            
          
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        
    
    }
    
    
    
}
