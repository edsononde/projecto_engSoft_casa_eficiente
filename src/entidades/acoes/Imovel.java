package entidades.acoes;

import entidades.enumerados.EstadoImovel;
import java.util.ArrayList;

public class Imovel {

    private String tipo;
    private String idmovel;
    private String endereco;
    private int numeroQuartos;
    private EstadoImovel estado;
    private Double valor;
    //private ArrayList<Corretor> corretores;
    private ArrayList<Avaliacao> avaliacoes;
    private String numUser;
    
    private Contrato contrato;
    
    //CONSTRUCTORES
    public Imovel(String tipo, String idmovel, String endereco, int numeroQuartos) {
        
        this.tipo = tipo;
        this.idmovel = "I"+idmovel;
        this.endereco = endereco;
        this.numeroQuartos = numeroQuartos;
        this.estado = EstadoImovel.LIVRE;
        this.avaliacoes = new ArrayList<>();
       
    }
    
    public Imovel(){}

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
        this.idmovel = "I"+idmovel;
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
    
    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getNumUser() {
        return numUser;
    }

    public void setNumUser(String numUser) {
        this.numUser = numUser;
    }

    public void setEstado(String estado) {
        
        this.estado = EstadoImovel.valueOf(estado.toUpperCase());
    }
    
    public void setEstado(EstadoImovel estado) {
        
        this.estado = estado;
    }

}
