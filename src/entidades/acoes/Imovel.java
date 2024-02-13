package entidades.acoes;

import entidades.enumerados.EstadoImovel;
import entidades.users.Corretor;
import java.util.ArrayList;

public class Imovel {

    private String tipo;
    private String idmovel = "I";
    private String endereco;
    private int numeroQuartos;
    private EstadoImovel estado;
    private Double valor;
   // private ArrayList<Corretor> corretores;
    private ArrayList<Avaliacao> avaliacoes;

    //CONSTRUCTOR
    public Imovel(String tipo, String idmovel, String endereco, int numeroQuartos) {
        this.tipo = tipo;
        this.idmovel = idmovel;
        this.endereco = endereco;
        this.numeroQuartos = numeroQuartos;
        this.estado = EstadoImovel.LIVRE;
        this.avaliacoes = new ArrayList<>();
       // this.corretores = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Imovel" + "\nTipo: " + tipo + "\nId Imóvel: " + idmovel + "\nEndereço: " + endereco + "\nNúmero de Quartos:" + numeroQuartos;
    }
    
//FUNCOES
    //AVALIAR IMOVEL
    public void avaliarImovel(int qtdEstrelas, String comentario, String nomeCliente){
        Avaliacao avaliar = new Avaliacao(qtdEstrelas, comentario, nomeCliente);
        avaliacoes.add(avaliar);
    }
    
//MÉTODOS GETTRS E SETTRS
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getIdmovel() {
        return idmovel;
    }

    public void setIdmovel(String idmovel) {
        this.idmovel = idmovel;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumeroQuartos() {
        return numeroQuartos;
    }

    public void setNumeroQuartos(int numeroQuartos) {
        this.numeroQuartos = numeroQuartos;
    }

    public EstadoImovel getEstado() {
        return estado;
    }

    public void setEstado(EstadoImovel estado) {
        this.estado = estado;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    
    

}
