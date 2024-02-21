/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entidades.acoes.Contrato;
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
public class ContratoDao implements DaoGenerica<Contrato> {

    private Conexao conexao;

    public ContratoDao() {

        this.conexao = new Conexao();
    }

    @Override
    public void inserir(Contrato con) {

        String sql = "INSERT INTO contrato(idContrato, nomeCliente, nomeCorretor, idContrato, estadoContrato, estadoPagamento, valor, infor, data) VALUES (?,?,?,?,?,?,?)";
        try {

            if (this.conexao.conectar()) {

                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);

                sentenca.setString(1, con.getIdContrato());
                sentenca.setString(2, con.getCliente().getIdUser());
                sentenca.setString(3, con.getCorretor().getIdUser());
                sentenca.setString(4, con.getIdContrato());
                sentenca.setString(5, con.getEstado().getEstado().toUpperCase());
                sentenca.setString(6, con.getPagamento().getEstado().toUpperCase());
                sentenca.setDouble(7, con.getValor());
                sentenca.setString(8, con.getInformacao());
                sentenca.setDate(9, (Date) con.getData());

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
    public ArrayList<Contrato> consultar() {

        ArrayList<Contrato> contratos = new ArrayList<>();
        String sql = "SELECT * FROM contrato ORDER BY idContrato ";

        try {

            if (this.conexao.conectar()) {

                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);

                ResultSet resultado = sentenca.executeQuery();

                while (resultado.next()) {

                    Contrato contrato = new Contrato();

                    contrato.setIdContrato(resultado.getString("idContrato"));

                    contrato.setCliente(resultado.getString("nomeCliente"));

                    contrato.setCorretor(resultado.getString("nomeCorretor"));

                    contrato.setInformacao(resultado.getString("infor"));

                    contrato.setEstado(resultado.getString("estadoContrato"));

                    contrato.setValor(resultado.getDouble("valor"));

                    contrato.setPagamento(resultado.getString("estadoContrato"));

                    contrato.setData(resultado.getDate("data"));
                    contrato.setInformacao("idImovel");

                    contratos.add(contrato);

                }

                sentenca.close();

                this.conexao.getConexao().close();

            }

            return contratos;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void alterar(Contrato contrato) {

        String sql = "UPDATE contrato SET nomeCliente = ? , nomeCorretor = ? , infor = ? , estadoContrato = ? , valor = ? , estadoPagamento = ? , data = ?   WHERE idContrato = ? ";
        try {

            if (this.conexao.conectar()) {

                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);

                sentenca.setString(1, contrato.getClienteString());
                sentenca.setString(2, contrato.getCorretorString());
                sentenca.setString(3, contrato.getInformacao());
                sentenca.setString(4, contrato.getEstado().getEstado());
                sentenca.setDouble(5, contrato.getValor());
                sentenca.setString(6, contrato.getPagamento().getEstado());
                sentenca.setDate(7, (Date) contrato.getData());
                sentenca.setString(8, contrato.getIdContrato());

                sentenca.execute();
                sentenca.close();

                this.conexao.getConexao().close();

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void excluir(String con) {

        String sql = "DELETE FROM contrato WHERE idContrato = ? ";

        try {

            if (this.conexao.conectar()) {

                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);

                sentenca.setString(1, con);

                sentenca.execute();
                sentenca.close();

                this.conexao.getConexao().close();

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Contrato busca(String nome) {

        String sql = "SELECT * FROM CLIENTE WHERE idContrato = ?";

        try {

            if (this.conexao.conectar()) {

                PreparedStatement sentenca = this.conexao.getConexao().prepareStatement(sql);
                sentenca.setString(1, nome);

                ResultSet resultado = sentenca.executeQuery();

                while (resultado.next()) {

                    Contrato contrato = new Contrato();

                    contrato.setIdContrato(resultado.getString("idContrato"));

                    contrato.setCliente(resultado.getString("nomeCliente"));

                    contrato.setCorretor(resultado.getString("nomeCorretor"));

                    contrato.setInformacao(resultado.getString("infor"));

                    contrato.setEstado(resultado.getString("estadoContrato"));

                    contrato.setValor(resultado.getDouble("valor"));

                    contrato.setPagamento(resultado.getString("estadoPagamento"));

                    contrato.setData(resultado.getDate("data"));

                    return contrato;

                }

                sentenca.close();

                this.conexao.getConexao().close();

            }

            return null;

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }

    }
    
    public int contarContrato() {
        String sql = "SELECT COUNT(*) FROM contrato";
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
