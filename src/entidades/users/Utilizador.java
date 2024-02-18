package entidades.users;

import entidades.acoes.Contrato;
import entidades.acoes.Imovel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public abstract class Utilizador {

    protected String idUser;
    protected String nome;
    protected String dataNascimento;
    protected String senha;
    private int cont;
//CONSTRUCTOR    
    public Utilizador(String nome, String dataNascimento, String senha) {
        this.idUser = "UTI"+cont;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.senha = senha;
        
    }
    
    public Utilizador(){}

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat();
        String date = sdf.format(dataNascimento);
        return "Utilizador Nº" + idUser + "\nNome: "+nome+"\nData De Nascimento: "+date;
    }
    
//FUNÇÕES
    public void fazerLogin(String id, String senha){
        this.idUser = id;
        this.senha = senha;
    }
    
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

    //GETTERS E SETTERS

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
