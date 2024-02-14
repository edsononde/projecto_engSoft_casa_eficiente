package entidades.acoes;

import entidades.users.Cliente;
import entidades.users.Corretor;
import entidades.enumerados.*;
import java.util.Date;


public class Contrato {
    private String idContrato = "CON";
    private String informacao;
    private Date data;
    private double valor;
    private Cliente cliente;
    private Corretor corretor;
    private EstadoPagamentoContrato pagamento;
    private EstadoContrato estado;
   
//CONSTRUTORES
    
    public Contrato() {
    }

    public Contrato(String informacao, Date data, double valor, Cliente cliente, Corretor corretor) {
        this.informacao = informacao;
        this.data = data;
        this.valor = valor;
        this.cliente = cliente;
        this.corretor = corretor;
        this.estado = EstadoContrato.ATIVO;
        this.pagamento = EstadoPagamentoContrato.PENDENTE;
    }

    @Override
    public String toString() {
        return "Contrato\nInformações: " + informacao + "\nData:" + data + "\nPreço:" + valor+" KZ" +"\nEstado do Pagamento: "
                +pagamento.getEstado()+"\nEstado do Contracto: " +estado+"\n"+"\n"+"Informações do Cliente\n"+cliente +
                "\n"+"\nInformações do Corrector\n" + corretor;
    }
    

//GETTRS E SETTRS
    public String getInformacao() {
        return informacao;
    }

    public void setInformacao(String informacao) {
        this.informacao = informacao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        
        this.valor = valor;
        
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void setCliente(String cliente) {
        this.cliente.setIdUser(cliente);
    }
    
    public String getClienteString() {
        return cliente.getIdUser();
    }
    
    public void setCorretor(String corretor) {
        this.corretor.setIdUser(corretor);
    }
    
    public String getCorretorString() {
        return corretor.getIdUser();
    }

    public Corretor getCorretor() {
        return corretor;
    }

    public void setCorretor(Corretor corretor) {
        this.corretor = corretor;
    }

    public String getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(String idContrato) {
        this.idContrato = idContrato;
    }

    public EstadoPagamentoContrato getPagamento() {
        return pagamento;
    }

    public void setPagamento(EstadoPagamentoContrato pagamento) {
        this.pagamento = pagamento;
    }
    
     public void setPagamento(String pagamento) {
        this.pagamento = EstadoPagamentoContrato.valueOf(pagamento.toUpperCase());
    }

    public EstadoContrato getEstado() {
        return estado;
    }

    public void setEstado(EstadoContrato estado) {
        this.estado = estado;
    }
    
    public void setEstado(String estado) {
        this.estado = EstadoContrato.valueOf(estado.toUpperCase());
    }
    
    
}
