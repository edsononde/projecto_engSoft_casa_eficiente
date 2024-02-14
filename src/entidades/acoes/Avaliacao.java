/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades.acoes;

/**
 *
 * @author edson
 */
public class Avaliacao {
    private String nomeCliente;
    private int numeroEstrelas;
    private String comentario;

//CONSTRUCTOR
    public Avaliacao(int numeroEstrelas, String comentario, String nomeCliente) {
        this.numeroEstrelas = numeroEstrelas;
        this.comentario = comentario;
        this.nomeCliente = nomeCliente;
    }

    @Override
    public String toString() {
        return "Avaliacão\nNúmeroEstrelas:" + numeroEstrelas + "\nComentário:" + comentario+"\nNome: "+nomeCliente;
    }
    
//MÉTODOS GETTRS E SETTERS
    public int getNumeroEstrelas() {
        return numeroEstrelas;
    }

    public void setNumeroEstrelas(int numeroEstrelas) {
        this.numeroEstrelas = numeroEstrelas;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    
    
    
}
