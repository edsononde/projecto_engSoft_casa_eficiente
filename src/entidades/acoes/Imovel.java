package entidades.acoes;

import entidades.enumerados.EstadoImovel;
import java.util.ArrayList;

public class Imovel {

    private String tipo;
    private String idmovel = "IM";
    private String cidade;
    private String bairro;
    private String rua;
    private int numeroCasa;
    private int numeroQuartos;
    private EstadoImovel estado;
    private Double valor;
    private ArrayList<Avaliacao> avaliacoes;
    private String numUser = null;
    private String idCorrector = null;
    private Contrato contrato;

    public Imovel(String tipo, String idmovel, String cidade, String bairro, String rua, int numeroCasa, int numeroQuartos) {
        this.tipo = tipo;
        this.idmovel = ""+idmovel;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numeroCasa = numeroCasa;
        this.numeroQuartos = numeroQuartos;
        this.estado = EstadoImovel.LIVRE;
        this.avaliacoes = new ArrayList<>();
    }

    public Imovel() {
    }

    @Override
    public String toString() {
        return "Imovel" + "\nTipo: " + tipo + "\nId Imóvel: " + idmovel + "\nCidade: " + cidade + "\nBairro: " 
                + bairro + "\nRua: " + rua + "\nNúmero da Casa: " + numeroCasa + "\nNúmero de Quartos:" + numeroQuartos;
    }

    public void avaliarImovel(int qtdEstrelas, String comentario, String nomeCliente) {
        Avaliacao avaliar = new Avaliacao(qtdEstrelas, comentario, nomeCliente);
        avaliacoes.add(avaliar);
    }

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
        this.idmovel = "IM"+idmovel;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(int numeroCasa) {
        this.numeroCasa = numeroCasa;
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

    public ArrayList<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(ArrayList<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public String getIdCorrector() {
        return idCorrector;
    }

    public void setIdCorrector(String idCorrector) {
        this.idCorrector = idCorrector;
    }
    
    
}
