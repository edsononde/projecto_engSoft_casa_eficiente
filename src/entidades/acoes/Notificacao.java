
package entidades.acoes;

import java.util.Date;

public class Notificacao {
    private Date data;
    private String titulo;
    private String idImovel;
    private String tipoImovel;

//CONTRUCTOR
    public Notificacao(Date data, String titulo, String idImovel, String tipoImovel) {
        this.data = data;
        this.titulo = titulo;
        this.idImovel = idImovel;
        this.tipoImovel = tipoImovel;
    }

    @Override
    public String toString() {
        return "Notificação sobre" + titulo+" | "+data+"\n Id do Imóvel: "+idImovel+", Tipo: "+tipoImovel;
    }
    
//GETTRES E SETTRS
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(String idImovel) {
        this.idImovel = idImovel;
    }

    public String getTipoImovel() {
        return tipoImovel;
    }

    public void setTipoImovel(String tipoImovel) {
        this.tipoImovel = tipoImovel;
    }
    
    
}
