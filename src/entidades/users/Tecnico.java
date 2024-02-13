package entidades.users;


public class Tecnico {
    private String idTecnico;
    private String nome;
    private String morada;


//CONSTRUCTOR

    public Tecnico(String idTecnico, String nome, String morada) {
        this.idTecnico = "TEC"+idTecnico;
        this.nome = nome;
        this.morada = morada;
    }

    @Override
    public String toString() {
        return "Tecnico{" + "Id Tecnico: " + idTecnico + ", Nome: " + nome + ", Morada:" + morada + '}';
    }
    
//GETTRES E SETTERS
    public String getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(String idTecnico) {
        this.idTecnico = idTecnico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }
    
}
