/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entidades.users.Corretor;
import entidades.users.Corretor;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jason Matias
 */
public class CorretorDao implements DaoGenerica<Corretor> {

    private Conexao conexao;

    public CorretorDao() {

        this.conexao = new Conexao();
    }

    @Override
    public void inserir(Corretor corretor) {

        String sql = "INSERT INTO USER(nomeUser, pass, dataNasc, tipoUsuario, nome) VALUES (?,?,?,?,?)";

        try {

            if (this.conexao.conectar()) {

                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);

                sentenca.setString(1, corretor.getIdUser());
                sentenca.setString(2, corretor.getSenha());
                sentenca.setString(3, corretor.getDataNascimento());
                sentenca.setString(4, "Corretor");
                sentenca.setString(5, corretor.getNome());

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
    public ArrayList<Corretor> consultar() {

        ArrayList<Corretor> corretores = new ArrayList<>();
        String sql = "SELECT * FROM user WHERE tipoUsuario = 'Corretor'  ";

        try {

            if (this.conexao.conectar()) {

                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);

                ResultSet resultado = sentenca.executeQuery();

                while (resultado.next()) {

                    Corretor corretor = new Corretor();

                    corretor.setIdUser(resultado.getString("nomeUser"));

                    corretor.setNome(resultado.getString("nome"));

                    corretor.setDataNascimento(resultado.getString("dataNasc"));

                    corretor.setSenha(resultado.getString("pass"));

                    corretores.add(corretor);

                }

                sentenca.close();

                this.conexao.getConexao().close();

            }

            return corretores;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void alterar(Corretor corretor) {

        String sql = "UPDATE USER SET pass = ? , dataNasc = ?  WHERE tipoUsuario = 'Corretor' and nomeUser = ?";
        try {

            if (this.conexao.conectar()) {

                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);

                sentenca.setString(1, corretor.getSenha());
                sentenca.setString(2, corretor.getDataNascimento());
                sentenca.setString(3, corretor.getIdUser());
                sentenca.execute();
                sentenca.close();

                this.conexao.getConexao().close();
                this.atualizarIdade();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void excluir(String nomeUser) {

        String sql = "DELETE FROM USER WHERE nomeUser = ?";

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

    public Corretor fazerLogin(String idUser, String senha) {
        String sql = "SELECT * FROM user WHERE tipoUsuario = 'Corretor' AND nomeUser = ? AND pass = ?";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);
                sentenca.setString(1, idUser);
                sentenca.setString(2, senha);
                ResultSet resultado = sentenca.executeQuery();
                if (resultado.next()) {
                    Corretor corretor = new Corretor();
                    corretor.setIdUser(resultado.getString("nomeUser"));
                    corretor.setNome(resultado.getString("nome"));
                    corretor.setDataNascimento(resultado.getString("dataNasc"));
                    corretor.setSenha(resultado.getString("pass"));
                    sentenca.close();
                    this.conexao.getConexao().close();
                    return corretor; // Retorna o gestor se o login for bem-sucedido
                }
                sentenca.close();
                this.conexao.getConexao().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null; // Retorna null se não encontrar um usuário com as credenciais fornecidas
    }
    
    public int contarCorretor() {
        String sql = "SELECT COUNT(*) FROM user WHERE tipoUsuario = 'Corretor'";
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
