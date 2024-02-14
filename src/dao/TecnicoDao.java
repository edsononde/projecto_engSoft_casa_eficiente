/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entidades.users.Cliente;
import entidades.users.Tecnico;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jason Matias
 */
public class TecnicoDao implements DaoGenerica<Tecnico>{
    
    
    private Conexao conexao;

    public TecnicoDao() {
        
        this.conexao = new Conexao();
    }

    @Override
    public void inserir(Tecnico tec) {
        
        String sql = "INSERT INTO USER(nomeUser, pass, dataNasc, tipoUsuario, nome) VALUES (?,?,?,?,?)";
        try {
            
            if(this.conexao.conectar()){
                
                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);
                
               //comentario
                    
                
                sentenca.setString(1, tec.getIdTecnico());
                sentenca.setString(2, tec.getSenha());
                sentenca.setString(3,  tec.getDataNascimento());
                sentenca.setString(4,"Tecnico");
                sentenca.setString(5, tec.getNome());
                
                sentenca.execute();
              
                sentenca.close();
                
                this.conexao.getConexao().close();
                
            }
            
            
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }

    @Override
    public ArrayList<Tecnico> consultar() {
       
        ArrayList<Tecnico> tecnicos = new ArrayList<>();
        String sql = "SELECT * FROM user where tipoUsuario = 'Tecnico' ";
        
        try {
            
            if(this.conexao.conectar()){
                
                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);
                
                ResultSet resultado = sentenca.executeQuery();
                
                while(resultado.next()){
                    
                    Tecnico tec = new Tecnico();
                    
                    tec.setIdTecnico(resultado.getString("nomeUser"));
                    
                    tec.setNome(resultado.getString("nome"));
                    
                    tec.set(resultado.getString("dataNasc"));
                    
                    tec.setSenha(resultado.getString("pass"));
                    
                    tecnicos.add(tec);
                    
                }
                
                
                
                sentenca.close();
                
                this.conexao.getConexao().close();
                
            }
            
            return tecnicos;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        
        
    }

    @Override
    public void alterar(Tecnico tec) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void excluir(String tec) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

    
}
