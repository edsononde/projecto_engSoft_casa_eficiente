package entidades.users;

import dao.ConsultaContador;
import entidades.acoes.Contrato;
import entidades.acoes.Imovel;
import entidades.acoes.Notificacao;
import entidades.enumerados.*;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class Cliente extends Utilizador {

    private ArrayList<Contrato> contratos;
    private String endereco;
   
//CONSTRUCTORES
    public Cliente(String idUser, String nome, String dataNascimento, String senha) {
        super(nome, dataNascimento, senha);
        
    }
    
    public Cliente() {
        ConsultaContador cont = new ConsultaContador();
        
        this.idUser = "CLI"+cont.contadorCliente(); 
        cont.incrementaClientes();
    }
    
//METODOS    
    

    @Override
    public void setIdUser(String idUser) {
        this.idUser = "CLI"+idUser;
    }
    
    

//FUNÇÕES
    //ALUGAR IMOVEL
    
    public void alugarImovel(Imovel imovel, ArrayList<Imovel> imoveis, String info, Date data, Cliente cliente,
            Corretor corretor) {

        Imovel novoImovel = verificarImovel(imovel.getIdmovel(), imoveis);
        if (novoImovel != null && (imovel.getEstado().equals(EstadoImovel.LIVRE)|| imovel.getEstado().equals(EstadoImovel.PENDENTE))) {
            
            imovel.setEstado(EstadoImovel.PENDENTE);
            Contrato contrato = new Contrato(info, data, imovel.getValor(), cliente, corretor);
            contratos.add(contrato);
            
            JOptionPane.showMessageDialog(null, contrato.toString(),"Imóvel Alugado com SUCESSO!", 2);
        } else {
            JOptionPane.showMessageDialog(null, imovel.toString(), "FALHA ao Alugar o Imóvel", 1);
        }
    }
    
    
    //CANCELAR IMOVEL
    public void cancelarIMovel(Imovel imovel, Contrato contrato) {
        if (contrato.getEstado().equals(EstadoContrato.PENDENTE) || contrato.getEstado().equals(EstadoContrato.ATIVO)) {
            Contrato veContrato = verificarContrato(imovel.getIdmovel(), this.getContratos());
            if (veContrato != null) {
                veContrato.setEstado(EstadoContrato.CANCELADO);
                JOptionPane.showMessageDialog(null, "Cancelado com sucesso\n" + contrato.toString(), "Detalhe de Contrato", 2);
            }
            else
                JOptionPane.showMessageDialog(null, "FALHA! Você não possui este contrato\n" + contrato.toString(), "Detalhe de Contrato", 1);
        } else {
            JOptionPane.showMessageDialog(null, "Este contracto não pode ser Cancelado\n" + contrato.toString(), "Detalhe de Contrato", 1);
        }
    }

    //COMPRAR IMOVEL
    public void comprarImovel(Contrato contrato, ArrayList<Imovel> imoveis) {
        Contrato veContrato = verificarContrato(contrato.getIdContrato(), this.contratos);
        if (veContrato != null && veContrato.getEstado().equals(EstadoContrato.PENDENTE)) {
            veContrato.setPagamento(EstadoPagamentoContrato.CONCLUIDO);
            Imovel veImovel = verificarImovel(contrato.getCliente().idUser, imoveis);
            if (veImovel != null) {
                veImovel.setEstado(EstadoImovel.OCUPADO);
                System.out.println(veImovel);
            }
            else
                JOptionPane.showMessageDialog(null, "FALHA! Você não possui este contrato\n" + contrato.toString(), "Detalhe de Contrato", 1);
            //IMPRIMIR CONTRACTOS
        } else {
            JOptionPane.showMessageDialog(null, "Não é possível comprar o Imóvel", "Detalhes do Contrato", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //VER TODOS OS CONTRACTOS FEITOS PELO CLIENTE
    public void verContractos() {
        for(Contrato c: this.contratos)
            System.out.println(c);
    }

    //VER TODOS IMOVEIS DISPONIVEIS NA LOJA
    public void verImoveis(ArrayList<Imovel> imoveis) {
        for(Imovel i: imoveis)
            System.out.println(i);
    }

    //AVALIAR IMÓVEL
    public void avaliarImoveis(int NumEstrelas, String comentario, String idImovel, ArrayList<Imovel> imoveis) {
        Imovel veImovel = verificarImovel(idImovel, imoveis);
        if(veImovel != null){
            veImovel.avaliarImovel(NumEstrelas, comentario, this.nome);
            JOptionPane.showMessageDialog(null, "Obrigado pelo seu feedback!", "FEEDBACK", 1);
        }
    }
    
    //VER TODAS AS NOTIFICAÕES
    

    //GETTERS E SETTERS
    public ArrayList<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(ArrayList<Contrato> contratos) {
        this.contratos = contratos;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

   
}
