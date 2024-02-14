package entidades.users;

import dao.ConsultaContador;


public class Tecnico extends Utilizador{
    private String morada;
    private int cont;

//CONSTRUCTOR

    public Tecnico(String morada, String idUser, String nome, String dataNascimento, String senha) {
        super(nome, dataNascimento, senha);
        this.nome = nome;
        this.morada = morada;
    }

    
    public Tecnico(){
        
        ConsultaContador cont = new ConsultaContador();
        this.idUser = "TEC"+cont.contadorTecnico();
        cont.incrementaTecnicos();
        
    }
    


    @Override
    public String toString() {
        return "Tecnico: " + "Id Tecnico: " + super.getIdUser() + ", Nome: " + nome + ", Morada:" + morada + "\n";
    }
    
//GETTRES E SETTERS
    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    @Override
    public void fazerLogin() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
