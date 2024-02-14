/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entidades.acoes.Imovel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jason Matias
 */
public class ImovelDao implements DaoGenerica<Imovel>{
    
    
    private Conexao conexao;

    public ImovelDao() {
        
        this.conexao = new Conexao();
    }
    
    

    @Override
    public void inserir(Imovel imovel) {
       
        String sql = "INSERT INTO IMOVEL(nomeImovel, tipo, endereco, n_Quartos,estado, nomeUser) VALUES (?,?,?,?,?,?)";
        try {
            
            if(this.conexao.conectar()){
                
                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);
                
               
                    
                
                sentenca.setString(1, imovel.getIdmovel());
                sentenca.setString(2, imovel.getTipo());
                sentenca.setString(3, imovel.getEndereco());
                sentenca.setInt(4,imovel.getNumeroQuartos());
                sentenca.setString(5, imovel.getEstado().getEstado());
                sentenca.setString(6,imovel.getNumUser() );
                
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
    public ArrayList<Imovel> consultar() {
        
        ArrayList<Imovel> imoveis = new ArrayList<>();
        String sql = "SELECT * FROM Imovel ORDER BY idImovel ";
        
        try {
            
            if(this.conexao.conectar()){
                
                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);
                
                ResultSet resultado = sentenca.executeQuery();
                
                while(resultado.next()){
                    
                    Imovel imovel = new Imovel();
                    
                    imovel.setIdmovel(resultado.getString("nomeImovel"));
                    
                    imovel.setTipo(resultado.getString("tipo"));
                    
                    imovel.setEndereco(resultado.getString("endereco"));
                    
                    imovel.setNumeroQuartos(resultado.getInt("n_Quartos"));
                    
                    imovel.setEstado(resultado.getString("estado"));
                    
                    imovel.setNumUser(resultado.getString("nomeUser"));
                    
                    imoveis.add(imovel);
                    
                }
                
                
                
                sentenca.close();
                
                this.conexao.getConexao().close();
                
            }
            
            return imoveis;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        
    }

    @Override
    public void alterar(Imovel imovel) {
        
        
        String sql = "UPDATE imovel SET tipo = ? , endereco = ? , n_Quartos = ? , estado = ? , nomeUser = ?  WHERE nomeImovel = ? ";
        try {
            
            if(this.conexao.conectar()){
                
                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);
                
                
                
                
                sentenca.setString(1, imovel.getTipo());
                sentenca.setString(2, imovel.getEndereco());
                sentenca.setInt(3, imovel.getNumeroQuartos());
                sentenca.setString(4, imovel.getEstado().getEstado());
                sentenca.setString(5, imovel.getNumUser());
                sentenca.setString(6, imovel.getIdmovel());
                sentenca.execute();
                sentenca.close();
                
                this.conexao.getConexao().close();
                
            }
            
            
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }

    @Override
    public void excluir(String nomeImovel) {
       
        String sql = "DELETE FROM imovel WHERE nomeImovel = ? ";
        
        try {
            
            if(this.conexao.conectar()){
                
                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);
                
                
                sentenca.setString(1, nomeImovel);
                
                
                sentenca.execute();
                sentenca.close();
                
                this.conexao.getConexao().close();
                
            }
            
            
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        
    }
    
    
}
