package entidades.users;

import dao.ConsultaContador;
import entidades.acoes.*;
import entidades.enumerados.*;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class Gestor extends Utilizador {
    private ArrayList<Corretor> listaCorretores;
    private ArrayList<Imovel> imoveis;
    private EquipeDeManutencao listaTecnicos;
    private ArrayList<Notificacao> notificacoes;
    
//CONSTRUCTOR
    public Gestor(ArrayList<Corretor> listaCorretores, EquipeDeManutencao listaTecnicos, ArrayList<Imovel> imoveis, String idUser, String nome, String dataNascimento, String senha) {
        super(nome, dataNascimento, senha);
        this.listaCorretores = new ArrayList<>();
        this.listaCorretores = listaCorretores;
        this.listaTecnicos = listaTecnicos;
        this.imoveis = new ArrayList<>();
        this.notificacoes = new ArrayList<>();
        
    }
    
    public Gestor(){
        ConsultaContador cont = new ConsultaContador();
    this.idUser = "GES"+ cont.contadorGestor();
    cont.incrementaGestores();
    
    }
    
//FUNÇÕES
    public void pesquisarFuncionario(String id){
        if(this.listaTecnicos.verificarTecnico(id) != null)
            JOptionPane.showMessageDialog(null, "Técino de Manutencao encontrado com Sucesso", "Tácnico", 2);
        if(this.verificarCorrector(id) != null)
           JOptionPane.showMessageDialog(null, "Corrector encontrado com Sucesso", "Tácnico", 2); 
        else
            JOptionPane.showMessageDialog(null, "NÃO ENCONTRADO!", "Tácnico", 1);
    }
    
    public void eliminarFuncionario(String id){
        Tecnico tecnico = listaTecnicos.verificarTecnico(id);
        Corretor corretor = this.verificarCorrector(id);
        if(tecnico != null)
            this.listaTecnicos.removerTecnicos(tecnico);
        if(corretor != null){
            this.listaCorretores.remove(corretor);
            JOptionPane.showMessageDialog(null, "Apagado com Sucesso", "Tela Corrector", 2);
        }
        else
           JOptionPane.showMessageDialog(null, "NÃO ENCONTRADO!", "Funcionário", 1);   
    }
    
    public void verFuncionarios(){
        System.out.println("CORRECTORES\n");
        for(Corretor aux: this.listaCorretores)
            System.out.println(aux);
        this.listaTecnicos.verTecnicos();
    }
    
    public void adicionarCorretor(Corretor corrector){
        this.adicionarCorretor(corrector);
    }
    
    public void adicionarTecnico(Tecnico tecnico){
        this.listaTecnicos.adicionarTecnico(tecnico);
    }
    
    public void verPedidosManutencao(){
        this.listaTecnicos.verPedidosManutencao();
    }
    
    public void designarImovel(Imovel imovel, Corretor corretor){
        Imovel veImovel = this.verificarImovel(imovel.getIdmovel(), imoveis);
        Corretor veCorretor = this.verificarCorrector(corretor.getIdUser());
        if(veImovel != null && veCorretor != null){
            veCorretor.adicionarImovelPortifolio(imovel);
        }
    }
    
    public void criarImovel(String tipo, String idmovel, String endereco, int numeroQuartos){
        Imovel veImovel = this.verificarImovel(idmovel, imoveis);
        if(veImovel == null){
            veImovel = new Imovel(tipo, idmovel, endereco, numeroQuartos);
            imoveis.add(veImovel);
            JOptionPane.showMessageDialog(null, veImovel, "IMÓVEL CRIADO COM SUCESSO", 2);
        }
        else
            JOptionPane.showMessageDialog(null, "Este imóvel já existe", "FALHA AO CRIAR IMÓVEL!", 1);
        
    }
    
    public void apagarImovel(String idImovel){
        Imovel veImovel = this.verificarImovel(idImovel, imoveis);
        if(veImovel != null){
            imoveis.remove(veImovel);
            JOptionPane.showMessageDialog(null, "Imóvel APAGADO1", "FALAHA AO APAGAR!", 2);
        }
        else
            JOptionPane.showMessageDialog(null, "Este imóvel nem existe", "FALHA AO APAGAR!", 1);
    }
    
    public void pesquisarImovel(String id){
        Imovel veImovel = this.verificarImovel(id, imoveis);
        if(veImovel != null)
            JOptionPane.showMessageDialog(null, veImovel.toString(), "ENCONTRADO COM SUCESSO!", 2);
        else
            JOptionPane.showMessageDialog(null, "Imóvel não encontrado!", "FALHA AO PROCURAR", 1);
    }
    
    public void enviarNotificacao(Imovel imovel){
        Date data = new Date();
        Notificacao notificacao = new Notificacao(data, "Novo Imóvel", imovel.getIdmovel(), imovel.getTipo());
        this.notificacoes.add(notificacao);
    }
    
//CONSTRUCTOR
    
    
//VERIFICAÇÕES
    //VERIFICAR EXISTÊNCIA DE CORRECTOR
    public Corretor verificarCorrector(String idCorretor) {
        if (!this.listaCorretores.isEmpty()) {
            for (Corretor aux : listaCorretores) {
                if (aux.getIdUser().equals(idCorretor)) {
                    return aux;
                }
            }
        }
        return null;
    }
    //VERIFICAR EXISTÊNCIA DE
    
//MÉTODOS GETTRS E SETTRS
    public ArrayList<Corretor> getListaCorretores() {
        return listaCorretores;
    }

    public void setListaCorretores(ArrayList<Corretor> listaCorretores) {
        this.listaCorretores = listaCorretores;
    }

    public EquipeDeManutencao getListaTecnicos() {
        return listaTecnicos;
    }

    public void setListaTecnicos(EquipeDeManutencao listaTecnicos) {
        this.listaTecnicos = listaTecnicos;
    }

   
    
}
