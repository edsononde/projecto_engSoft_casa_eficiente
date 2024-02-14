/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entidades.users.Cliente;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jason Matias
 */
public class ClienteDao implements DaoGenerica<Cliente> {

    private Conexao conexao;

    public ClienteDao() {

        this.conexao = new Conexao();
    }

    @Override
    public void inserir(Cliente cliente) {

        String sql = "INSERT INTO USER(nomeUser, pass, dataNasc, tipoUsuario, nome) VALUES (?,?,?,?,?)";
        try {

            if (this.conexao.conectar()) {

                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);

                //comentario
                sentenca.setString(1, cliente.getIdUser());
                sentenca.setString(2, cliente.getSenha());
                sentenca.setString(3, cliente.getDataNascimento());
                sentenca.setString(4, "Cliente");
                sentenca.setString(5, cliente.getNome());

                sentenca.execute();

                sentenca.close();

                this.conexao.getConexao().close();
                this.atualizarIdade();
            }

            System.out.println("Adicionado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public ArrayList<Cliente> consultar() {

        ArrayList<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM user where tipoUsuario = 'Cliente' ";

        try {

            if (this.conexao.conectar()) {

                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);

                ResultSet resultado = sentenca.executeQuery();

                while (resultado.next()) {

                    Cliente cliente = new Cliente();

                    cliente.setIdUser(resultado.getString("nomeUser"));

                    cliente.setNome(resultado.getString("nome"));

                    cliente.setDataNascimento(resultado.getString("dataNasc"));

                    cliente.setSenha(resultado.getString("pass"));

                    clientes.add(cliente);

                }

                sentenca.close();

                this.conexao.getConexao().close();

            }

            return clientes;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void alterar(Cliente cliente) {

        String sql = "UPDATE USER SET pass = ? , dataNasc = ?  WHERE tipoUsuario = 'Cliente' and nomeUser = ? ;" + "UPDATE user SET idade = FLOOR(DATEDIFF(CURDATE(), dataNasc) / 365);";
        try {

            if (this.conexao.conectar()) {

                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);

                sentenca.setString(1, cliente.getSenha());
                sentenca.setString(2, cliente.getDataNascimento());
                sentenca.setString(3, cliente.getIdUser());
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

            if (this.conexao.conectar()) {

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

    public Cliente busca(String nome) {

        String sql = "SELECT * FROM CLIENTE WHERE nomeUsuario = ?";

        try {

            if (this.conexao.conectar()) {

                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);
                sentenca.setString(1, nome);

                ResultSet resultado = sentenca.executeQuery();

                while (resultado.next()) {

                    Cliente cliente = new Cliente();

                    cliente.setIdUser(resultado.getString("nomeUser"));

                    cliente.setNome(resultado.getString("nome"));

                    cliente.setDataNascimento(resultado.getString("dataNasc"));

                    cliente.setSenha(resultado.getString("pass"));

                    return cliente;

                }

                sentenca.close();

                this.conexao.getConexao().close();

            }

            return null;

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }

    }

    public void atualizarIdade() {

        String sql = "SET SQL_SAFE_UPDATES = 0; UPDATE user SET idade = FLOOR(DATEDIFF(CURDATE(), dataNasc) / 365); ";

        try {

            if (this.conexao.conectar()) {

                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);

                sentenca.execute();
                sentenca.close();

                this.conexao.getConexao().close();

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    
    public Cliente fazerLogin(String idUser, String senha) {
        String sql = "SELECT * FROM user WHERE tipoUsuario = 'Cliente' AND nomeUser = ? AND pass = ?";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);
                sentenca.setString(1, idUser);
                sentenca.setString(2, senha);
                ResultSet resultado = sentenca.executeQuery();
                if (resultado.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setIdUser(resultado.getString("nomeUser"));
                    cliente.setNome(resultado.getString("nome"));
                    cliente.setDataNascimento(resultado.getString("dataNasc"));
                    cliente.setSenha(resultado.getString("pass"));
                    sentenca.close();
                    this.conexao.getConexao().close();
                    return cliente; // Retorna o gestor se o login for bem-sucedido
                }
                sentenca.close();
                this.conexao.getConexao().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null; // Retorna null se não encontrar um usuário com as credenciais fornecidas
    }

}
