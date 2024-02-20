/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entidades.acoes.Manutencao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jason Matias
 */
public class ManutencaoDao implements DaoGenerica<Manutencao>{
    
    
    private Conexao conexao;

    public ManutencaoDao() {
        
        this.conexao = new Conexao();
    }

    @Override
    public void inserir(Manutencao man) {
      String sql = "INSERT INTO manutencao(idManutencao ,nomeUser, dataManutencao, imovel, estado) VALUES (?,?,?,?,?)";
        try {
            
            if(this.conexao.conectar()){
                
                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);
                
               
                    
                
                sentenca.setString(1, man.getIdManutecao());
                sentenca.setString(2, man.getTecnico());
                sentenca.setDate(3, (Date) man.getData());
                sentenca.setString(4,man.getImovel());
                sentenca.setString(5, man.getEstado().getEstado());
                
                
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
    public ArrayList<Manutencao> consultar() {
       
         ArrayList<Manutencao> manutencoes = new ArrayList<>();
        String sql = "SELECT * FROM manutencao ORDER BY idManutencao ";
        
        try {
            
            if(this.conexao.conectar()){
                
                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);
                
                ResultSet resultado = sentenca.executeQuery();
                
                while(resultado.next()){
                    
                    Manutencao manu = new Manutencao();
                    
                    manu.setIdManutecao(resultado.getString("idManutencao"));
                    
                    manu.setTecnico(resultado.getString("nomeUser"));
                    
                    manu.setProblema(resultado.getString("descricao"));
                    
                    manu.setData(resultado.getDate("dataManutencao"));
                    
                    manu.setImovel(resultado.getString("imovel"));
                    
                    manu.setEstado(resultado.getString("estado"));
                    
                    manutencoes.add(manu);
                    
                }
                
                
                
                sentenca.close();
                
                this.conexao.getConexao().close();
                
            }
            
            return manutencoes;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        
    }

    @Override
    public void alterar(Manutencao manu) {
       
        String sql = "UPDATE manutencao SET nomeUser = ? , dataManutencao = ? , imovel = ? , estado = ?  WHERE nomeManutencao = ? ";
        
        try {
            
            if(this.conexao.conectar()){
                
                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);
                
                
                sentenca.setString(1, manu.getTecnico());
                sentenca.setDate(2, (Date) manu.getData());
                sentenca.setString(3, manu.getImovel());
                sentenca.setString(4, manu.getEstadoString());
                sentenca.setString(5, manu.getIdManutecao());
                
                
                sentenca.execute();
                sentenca.close();
                
                
                this.conexao.getConexao().close();
                
            }
            
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }

    @Override
    public void excluir(String idManu) {
        
        String sql = "DELETE FROM manutencao WHERE idManutencao = ? ";
        
        try {
            
            if(this.conexao.conectar()){
                
                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);
                
                
                sentenca.setString(1, idManu);
                
                
                sentenca.execute();
                sentenca.close();
                
                
                this.conexao.getConexao().close();
                
            }
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }
    
    public int contarManutencao() {
        String sql = "SELECT COUNT(*) FROM manutencao";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);
                ResultSet resultado = sentenca.executeQuery();
                if (resultado.next()) {
                    int count = resultado.getInt(1);
                    sentenca.close();
                    this.conexao.getConexao().close();
                    return count;
                }
                return 0;
            }
            return 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
