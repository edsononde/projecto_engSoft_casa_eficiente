/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;

/**
 *
 * @author Jason Matias
 */
public class Conexao {
    
    Connection conexao = null;
    
    public Conexao(){}
    
    // Metodo para conectar a base de dados
    
    public boolean conectar() {

        
        String url = "jdbc:mysql://localhost:3312/gestao2";

        String user = "root";
        String password = "";

        //Estabelecendo a conexao
        try {
            //Class.forName(driver);    // Nao é necessário pôr este metodo pq o driver já é posto automaticamente.
            this.conexao = DriverManager.getConnection(url, user, password);
            return true;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
           
        }

    }

    public Connection getConexao() {
        return conexao;
    }
    
    
    

}
