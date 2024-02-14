package entidades.acoes;

import entidades.enumerados.EstadoManutencao;
import entidades.users.Tecnico;
import java.util.Date;

public class Manutencao {

    private String idManutecao;
    private String imovel;
    private String problema;
    private EstadoManutencao estado;
    private Date data;
    private String tecnico;
    
    //CONSTRUCTOR
    
    public Manutencao(String idManutecao, String problema, Date data) {
        this.idManutecao = "MAN"+idManutecao;
        this.imovel = imovel;
        this.problema = problema;
        this.data = data;
        this.estado = EstadoManutencao.PENDENTE;
    }
    
    public Manutencao(){}


    @Override
    public String toString() {
        return "Manutenção \nProblema: " + problema + "\nEstado: " + estado + "\nData: " + data;
    }

//GETTRS E SETTRS

    public String getIdManutecao() {
        return idManutecao;
    }

    public void setIdManutecao(String idManutecao) {
        this.idManutecao = "MAN"+idManutecao;
    }

    public String getImovel() {
        return imovel;
    }

    public void setImovel(String imovel) {
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

        public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }
    
     public void setEstado(String estado) {
         
        this.estado = EstadoManutencao.valueOf(estado);
    }
    
     public String getEstadoString() {
        return estado.getEstado();
    }
    
}
