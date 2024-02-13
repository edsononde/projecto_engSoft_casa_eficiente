/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package entidades.enumerados;

/**
 *
 * @author edson
 */
public enum EstadoImovel {
    LIVRE("Livre"), PENDENTE("Pendente"), OCUPADO("Ocupado");
    private String estado;
    
    EstadoImovel(String estado){
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }
    
    
}
