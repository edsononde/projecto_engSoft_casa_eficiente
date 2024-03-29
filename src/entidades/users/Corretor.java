package entidades.users;

import entidades.enumerados.EstadoImovel;
import entidades.acoes.Contrato;
import entidades.acoes.Imovel;
import entidades.acoes.Manutencao;
import entidades.acoes.Notificacao;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Corretor extends Utilizador {

    private ArrayList<Imovel> listaDeImoveis;
    private ArrayList<Contrato> contratos;
    private ArrayList<Notificacao> notificacoes;

    public Corretor(String idUser, String nome, String dataNascimento, String senha) {
        super(idUser, nome, dataNascimento, senha);
        contratos = new ArrayList<>();
        notificacoes = new ArrayList<>();
        listaDeImoveis = new ArrayList<>();
        this.setIdUser("COR"+nome);
    }

    @Override
    public void fazerLogin() {
    }

    public void adicionarImovelPortifolio(Imovel imovel) {
        Imovel veImovel = this.verificarImovel(idUser, listaDeImoveis);
        if(veImovel == null){
            this.listaDeImoveis.add(imovel);
            JOptionPane.showMessageDialog(null, "Imovel adicionado SUCESSO!\n"+imovel.toString(), "Tela De Imoveis", 2);
        }
        else
            JOptionPane.showMessageDialog(null, "Você já Tem este Imóvel!\n"+imovel.toString(), "Tela De Imoveis", 1);
    }
    
    public void removerImovelPortifolio (Imovel imovel) {
        this.listaDeImoveis.remove(imovel);
    }

    public void alterarImovel(Imovel imovel, int opcao, String alteracao) {
        switch(opcao){
            case 1 -> imovel.setTipo(alteracao);
            case 2 -> imovel.setEndereco(alteracao);
            default -> JOptionPane.showMessageDialog(null, "Opção não Permitida", "INVÁLIDA", 1);
        }
        JOptionPane.showMessageDialog(null, imovel.toString(), "Detalhes de Imóvel", 1);
    }

    public void verContratos() {
        for(Contrato c: this.contratos)
            System.out.println(c);
    }
    
    public void pedirManutencao(Imovel imovel, String idManutencao, String problema, String data){
        Manutencao manutecao = new Manutencao(idManutencao, imovel, problema, data);
    }

}
