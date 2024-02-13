/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package entidades.enumerados;

/**
 *
 * @author edson
 */
public enum EstadoPagamentoContrato {
    PENDENTE("Pendente"), CANCELADO("Cancelado"), CONCLUIDO("Concluido");
    private String estado;

    private EstadoPagamentoContrato(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }
    
}
