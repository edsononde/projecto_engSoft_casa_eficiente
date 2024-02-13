package entidades.users;

import entidades.acoes.Contrato;
import entidades.acoes.Imovel;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public abstract class Utilizador {

    protected String idUser;
    protected String nome;
    protected String dataNascimento;
    protected String senha;

//CONSTRUCTOR    
    public Utilizador(String idUser, String nome, String dataNascimento, String senha) {
        this.idUser = "UTI"+idUser;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Utilizador Nº" + idUser + "\nNome: "+nome+"\nData De Nascimento: "+dataNascimento;
    }
    
//FUNÇÕES
    public abstract void fazerLogin();
    
    public void visualizarImovel(Imovel imovel) {
        JOptionPane.showMessageDialog(null, imovel.toString(), "Visualização de Imóvel", 2);
    }
    
//VERIFICAÇÕES
    //VERIRFICAR EXISTEÊNCIA DE IMÓVEL
    public Imovel verificarImovel(String idImovel, ArrayList<Imovel> imoveis) {
        if (!imoveis.isEmpty()) {
            for (Imovel aux : imoveis) {
                if (aux.getIdmovel().equals(idImovel)) {
                    return aux;
                }
            }
        }
        return null;
    }

    //VERIFICAR EXISTÊNCIA DE CONTRACTO
    public Contrato verificarContrato(String idContrato, ArrayList<Contrato> contratos) {
        if (!contratos.isEmpty()) {
            for (Contrato aux : contratos) {
                if (aux.getIdContrato().equals(idContrato)) {
                    return aux;
                }
            }
        }
        return null;
    }

    //GETTERS E SETTRS

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
