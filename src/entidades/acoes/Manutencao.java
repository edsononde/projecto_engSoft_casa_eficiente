package entidades.acoes;

import entidades.enumerados.EstadoManutencao;
import java.util.Date;

public class Manutencao {

    private String idManutecao;
    private Imovel imovel;
    private String problema;
    private EstadoManutencao estado;
    private String data;

//CONSTRUCTOR
    public Manutencao(String idManutecao, Imovel imovel, String problema, String data) {
        this.idManutecao = "MAN"+idManutecao;
        this.imovel = imovel;
        this.problema = problema;
        this.data = data;
        this.estado = EstadoManutencao.PENDENTE;
    }


    @Override
    public String toString() {
        return "Manutenção \nProblema: " + problema + "\nEstado: " + estado + "\nData: " + data;
    }

//GETTRS E SETTRS

    public String getIdManutecao() {
        return idManutecao;
    }

    public void setIdManutecao(String idManutecao) {
        this.idManutecao = idManutecao;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public EstadoManutencao getEstado() {
        return estado;
    }

    public void setEstado(EstadoManutencao estado) {
        this.estado = estado;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    
}
