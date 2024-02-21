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

    public Conexao() {
    }

    // Metodo para conectar a base de dados
    public boolean conectar() {

        String url = "jdbc:mysql://localhost:3306/gestao";

        String user = "root";
        String password = "SUPERincu1060";

        //Estabelecendo a conexao
        try {
            //Class.forName(driver);    // Nao é necessário pôr este metodo pq o driver já é posto automaticamente.
            this.conexao = DriverManager.getConnection(url, user, password);
            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

    }
    
    public void desconectar() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
                System.out.println("Conexão fechada com sucesso.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fechar conexão com o banco de dados: " + e.getMessage());
        }
    }

    public Connection getConexao() {
        return conexao;
    }

}
