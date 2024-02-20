package entidades.users;

import dao.ConsultaContador;

public class Tecnico extends Utilizador {


//CONSTRUCTOR
    public Tecnico(String idUser, String nome, String dataNascimento, String senha) {
        super(nome, dataNascimento, senha);
        this.nome = nome;
       // ConsultaContador cont = new ConsultaContador();
        this.idUser = "TEC"+idUser;//cont.contadorTecnico();
        //cont.incrementaTecnicos();
    }

    public Tecnico() {

       // ConsultaContador cont = new ConsultaContador();
        this.idUser = "TEC"; //cont.contadorTecnico();
       // cont.incrementaTecnicos();

    }

    @Override
    public void setIdUser(String idUser) {
        super.setIdUser("TEC"+idUser); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    

    @Override
    public String toString() {
        return "Tecnico: " + "Id Tecnico: " + super.getIdUser() + ", Nome: " + nome + ", Data de Nascimento:" + super.dataNascimento + "\n";
    }

//GETTRES E SETTERS
}
