package entidades.users;

import entidades.acoes.Manutencao;
import entidades.enumerados.EstadoManutencao;
import entidades.users.Tecnico;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EquipeDeManutencao<T> {

    private ArrayList<Tecnico> tecnicos;
    private ArrayList<Manutencao> pedidoManutencao;

    public EquipeDeManutencao(ArrayList<Tecnico> tecnicos, ArrayList<Manutencao> pedidoManutencao) {
        this.tecnicos = tecnicos;
        this.pedidoManutencao = new ArrayList<>();
        this.tecnicos = new ArrayList<>();
        this.pedidoManutencao = pedidoManutencao;
        this.pedidoManutencao = new ArrayList<>();
    }

//FUNÇÕES
    //VER TODOS TECNICOS
    public void verTecnicos() {
        for (Tecnico t : this.tecnicos) {
            System.out.println(t);
        }
    }

    //REMOVER UM TECNICO
    public void removerTecnicos(Tecnico tecnico) {
        Tecnico veTecnico = verificarTecnico(tecnico.getIdTecnico());
        if (veTecnico != null) {
            this.tecnicos.remove(tecnico);
            JOptionPane.showMessageDialog(null, "REMOVIDO COM SUCESSO", "Detalhes de Técnico", 2);
        } else {
            JOptionPane.showMessageDialog(null, "Este Tecnico já não existe", "Detalhes de Técnico", 1);
        }
    }

    //ADICIONAR TECNICO
    public void adicionarTecnico(Tecnico tecnico) {
        Tecnico veTecnico = this.verificarTecnico(tecnico.getIdTecnico());
        if(veTecnico == null){
            this.tecnicos.add(tecnico);
            JOptionPane.showMessageDialog(null, "Adicionado com Sucesso", "Detalhes de Técnico", 2);
        }
        else
            JOptionPane.showMessageDialog(null, "Você já possui este técnico", "Detalhes de Técnico", 1);
    }
    
    //ADICIONAR PEDIDO DE MANUTENCAO
    public void adicionarPedido(Manutencao pedido){
        Manutencao veManutencao = verificarPedidoDeManutencao(pedido.getIdManutecao());
        if(veManutencao == null){
            this.pedidoManutencao.add(pedido);
            JOptionPane.showMessageDialog(null, pedido.toString(), "ADICIONADO COM SUCESSO!!", 2);
        }
        else
           JOptionPane.showMessageDialog(null, "Este pedido já se encontra: ",pedido.getEstado()+ "Detalhes de Manuteção", 1); 
    }

    //VER PEDIDOS DE MANUTENÇÃO
    public void verPedidosManutencao() {
        for (Manutencao m : this.pedidoManutencao) {
            System.out.println(m);
        }
    }

    //CONFIRMAR PEDIDO DE MANUTENÇÃO
    public void confirmarPedido(Manutencao manutencao) {
        Manutencao veManutencao = verificarPedidoDeManutencao(manutencao.getIdManutecao());
        if(veManutencao != null){
            manutencao.setEstado(EstadoManutencao.ANDAMENTO);
            JOptionPane.showMessageDialog(null, manutencao.toString(), "PEDIDO CONFIRMADO!!", 2);
        }
        else
            JOptionPane.showMessageDialog(null, manutencao.toString(), "PEDIDO FALHOU!!", 1);
    }
    
    //FAZER MANUTENÇÃO
    public void fazerManutencao(Manutencao manutencao){
        Manutencao veManutencao = verificarPedidoDeManutencao(manutencao.getIdManutecao()); 
        if(veManutencao != null && manutencao.getEstado().equals(EstadoManutencao.ANDAMENTO)){
            manutencao.setEstado(EstadoManutencao.CONCLUIDA);
            JOptionPane.showMessageDialog(null, manutencao.toString(), "MANUTENÇÂO FEITA!!", 2);
        }
        else
            JOptionPane.showMessageDialog(null, manutencao.toString(), "MANUTENÇÂO FALHOU!!", 1);
    }
    
    //CANCELAR MANUTENCAO
    public void cancelarManutencao(Manutencao manutencao){
        Manutencao veManutencao = verificarPedidoDeManutencao(manutencao.getIdManutecao()); 
        if(veManutencao != null){
            manutencao.setEstado(EstadoManutencao.CANCELADA);
            JOptionPane.showMessageDialog(null, manutencao.toString(), "MANUTENÇÂO FEITA!!", 2);
        }
        else
            JOptionPane.showMessageDialog(null, manutencao.toString(), "MANUTENÇÂO FALHOU!!", 1);
    }

//VERIFICAÇÕES
    //VERIFICAR A EXISTÊNCIA DE TÉCNICO
    public Tecnico verificarTecnico(String idTecnico) {
        if (!this.tecnicos.isEmpty()) {
            for (Tecnico t : this.tecnicos) {
                if (t.getIdTecnico() == idTecnico) {
                    return t;
                }
            }
        }
        return null;
    }

    //VERIFICAR SE EXISTE PEDIDO DE MANUTENÇÃO
    public Manutencao verificarPedidoDeManutencao(String id) {
        if(!this.pedidoManutencao.isEmpty()){
            for(Manutencao m: this.pedidoManutencao){
                if(m.getIdManutecao() == id)
                    return m;
            }
        }
        return null;
    }
}
