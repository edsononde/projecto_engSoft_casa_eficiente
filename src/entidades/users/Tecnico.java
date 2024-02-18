package entidades.users;

import dao.ConsultaContador;

public class Tecnico extends Utilizador {

    private int cont;

//CONSTRUCTOR
    public Tecnico(String idUser, String nome, String dataNascimento, String senha) {
        super(nome, dataNascimento, senha);
        this.nome = nome;
    }

    public Tecnico() {

        ConsultaContador cont = new ConsultaContador();
        this.idUser = "TEC" + cont.contadorTecnico();
        cont.incrementaTecnicos();

    }

    @Override
    public String toString() {
        return "Tecnico: " + "Id Tecnico: " + super.getIdUser() + ", Nome: " + nome + ", Data de Nascimento:" + super.dataNascimento + "\n";
    }

//GETTRES E SETTERS
}
