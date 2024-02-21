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
import javax.swing.JOptionPane;

/**
 *
 * @author Jason Matias
 */
public class ImovelDao implements DaoGenerica<Imovel> {

    private Conexao conexao;

    public ImovelDao() {
        this.conexao = new Conexao();
    }

    @Override
    public void inserir(Imovel imovel) {
        String sql = "INSERT INTO IMOVEL(idImovel, tipo, cidade, bairro, rua, numero_casa, n_Quartos, estado, nomeUser) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);
                sentenca.setString(1, imovel.getIdmovel());
                sentenca.setString(2, imovel.getTipo());
                sentenca.setString(3, imovel.getCidade());
                sentenca.setString(4, imovel.getBairro());
                sentenca.setString(5, imovel.getRua());
                sentenca.setInt(6, imovel.getNumeroCasa());
                sentenca.setInt(7, imovel.getNumeroQuartos());
                sentenca.setString(8, imovel.getEstado().getEstado());
                sentenca.setString(9, imovel.getNumUser());
                sentenca.execute();
                sentenca.close();
                this.conexao.getConexao().close();
            }
            JOptionPane.showMessageDialog(null, "Adicionado com Sucesso!", "SUCESSO!", 1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Imovel> consultar() {
        ArrayList<Imovel> imoveis = new ArrayList<>();
        String sql = "SELECT * FROM Imovel ORDER BY idImovel ";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);
                ResultSet resultado = sentenca.executeQuery();
                while (resultado.next()) {
                    Imovel imovel = new Imovel();
                    imovel.setTipo(resultado.getString("tipo"));
                    imovel.setCidade(resultado.getString("cidade"));
                    imovel.setBairro(resultado.getString("bairro"));
                    imovel.setRua(resultado.getString("rua"));
                    imovel.setNumeroCasa(resultado.getInt("numero_casa"));
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
        String sql = "UPDATE imovel SET tipo = ?, cidade = ?, bairro = ?, rua = ?, numero_casa = ?, "
                + "n_Quartos = ?, estado = ?  WHERE idImovel = ?";
        PreparedStatement sentenca = null; 
        try {
            if (!this.conexao.conectar()) {
                // Tratar caso a conexão não seja estabelecida
                System.err.println("Não foi possível estabelecer conexão com o banco de dados.");
                return;
            }

            sentenca = this.conexao.getConexao().prepareStatement(sql);
            sentenca.setString(1, imovel.getTipo());
            sentenca.setString(2, imovel.getCidade());
            sentenca.setString(3, imovel.getBairro());
            sentenca.setString(4, imovel.getRua());
            sentenca.setInt(5, imovel.getNumeroCasa());
            sentenca.setInt(6, imovel.getNumeroQuartos());
            sentenca.setString(7, imovel.getEstado().getEstado());
            sentenca.setString(8, imovel.getIdmovel());
            sentenca.executeUpdate(); // Usar executeUpdate para instruções de atualização
            sentenca.close();
            this.conexao.desconectar(); // Desconectar após a conclusão da operação
        } catch (SQLException e) {
            // Tratar exceções SQL
            System.err.println("Erro durante a atualização do imóvel: " + e.getMessage());
            throw new RuntimeException(e);
        } finally {
            // Garantir que a conexão seja fechada mesmo em caso de exceção
            try {
                if (sentenca != null) {
                    sentenca.close();
                }
                this.conexao.desconectar();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }

    @Override
    public void excluir(String idImovel) {
        String sql = "DELETE FROM imovel WHERE idImovel = ? ";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);
                sentenca.setString(1, idImovel);
                sentenca.execute();
                sentenca.close();
                this.conexao.getConexao().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int contarImoveis() {
        String sql = "SELECT COUNT(*) FROM imovel";
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

    public Imovel buscarImovel(String idImovel) {
        String sql = "SELECT * FROM imovel WHERE idImovel = ?";
        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);
                sentenca.setString(1, idImovel);
                ResultSet resultado = sentenca.executeQuery();
                if (resultado.next()) {
                    Imovel imovel = new Imovel();
                    imovel.setIdmovel(resultado.getString("idImovel"));
                    imovel.setTipo(resultado.getString("tipo"));
                    imovel.setCidade(resultado.getString("cidade"));
                    imovel.setBairro(resultado.getString("bairro"));
                    imovel.setRua(resultado.getString("rua"));
                    imovel.setNumeroCasa(resultado.getInt("numero_casa"));
                    imovel.setNumeroQuartos(resultado.getInt("n_Quartos"));
                    imovel.setEstado(resultado.getString("estado"));
                    imovel.setNumUser(resultado.getString("nomeUser"));
                    sentenca.close();
                    this.conexao.getConexao().close();
                    return imovel;
                }
                sentenca.close();
                this.conexao.getConexao().close();
                return null;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
