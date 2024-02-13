/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades.enumerados;

/**
 *
 * @author edson
 */
public enum EstadoManutencao {
    PENDENTE("Pendente"), ANDAMENTO("Em andamento"), CONCLUIDA("Concluida"),
    CANCELADA("Cancelada");
    private String estado;

    private EstadoManutencao(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }
}
