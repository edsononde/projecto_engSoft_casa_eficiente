/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entidades.users.Cliente;
import entidades.users.Gestor;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jason Matias
 */
public class GestorDao implements DaoGenerica<Gestor>{
    
    
    private Conexao conexao;

    public GestorDao() {
        
        this.conexao = new Conexao();
    }
    
    

    @Override
    public void inserir(Gestor gestor) {
       
        String sql = "INSERT INTO USER(nomeUser, pass, dataNasc, tipoUsuario, nome) VALUES (?,?,?,?,?)"+ "UPDATE user SET idade = FLOOR(DATEDIFF(CURDATE(), dataNasc) / 365);";
        try {
            
            if(this.conexao.conectar()){
                
                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);
                
               
                    
                
                sentenca.setString(1, gestor.getIdUser());
                sentenca.setString(2, gestor.getSenha());
                sentenca.setString(3,  gestor.getDataNascimento());
                sentenca.setString(4,"Cliente");
                sentenca.setString(5, gestor.getNome());
                
                sentenca.execute();
              
                sentenca.close();
                
                this.conexao.getConexao().close();
                
            }
            
            System.out.println("Adicionado com sucesso!");
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        
    }

    @Override
    public ArrayList<Gestor> consultar() {
        
        ArrayList<Gestor> gestores = new ArrayList<>();
        String sql = "SELECT * FROM user where tipoUsuario = 'Gestor' ";
        
        try {
            
            if(this.conexao.conectar()){
                
                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);
                
                ResultSet resultado = sentenca.executeQuery();
                
                while(resultado.next()){
                    
                    Gestor gestor = new Gestor();
                    
                    gestor.setIdUser(resultado.getString("nomeUser"));
                    
                    gestor.setNome(resultado.getString("nome"));
                    
                    gestor.setDataNascimento(resultado.getString("dataNasc"));
                    
                    gestor.setSenha(resultado.getString("pass"));
                    
                    gestores.add(gestor);
                    
                }
                
                
                
                sentenca.close();
                
                this.conexao.getConexao().close();
                
            }
            
            return gestores;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        
    }

    @Override
    public void alterar(Gestor gestor) {
        
        
        String sql = "UPDATE USER SET pass = ? , dataNasc = ?  WHERE nomeUser = ? ";
        try {
            
            if(this.conexao.conectar()){
                
                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);
                
                
                
                sentenca.setString(1, gestor.getSenha());
                sentenca.setString(2, gestor.getDataNascimento());
                sentenca.setString(3, gestor.getIdUser());
                sentenca.execute();
                sentenca.close();
                
                this.conexao.getConexao().close();
                
            }
            
            
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }

    @Override
    public void excluir(String nomeUser) {
       
        String sql = "DELETE FROM USER WHERE nomeUser = ? ";
        
        try {
            
            if(this.conexao.conectar()){
                
                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);
                
                
                sentenca.setString(1, nomeUser);
                
                
                sentenca.execute();
                sentenca.close();
                
                this.conexao.getConexao().close();
                
            }
            
            
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        
    }

    
}
