/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista3_q6;

/**
 *
 * @author beto
 */

public class Diaria {
    
    private final Cliente cliente;
    private final Cama cama;
    private int qtdDiarias;
    private int valorDevido;
    
    Diaria (Cliente cliente, Cama cama, int dia) {
        this.cliente = cliente;
        this.cama = cama;
        this.cama.ocupa();
        this.contabilizarDiaria();
    }
    
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public Cama getCama() {
        return this.cama;
    }
    
    public void contabilizarDiaria() {
        this.qtdDiarias++;
        if (this.qtdDiarias >= this.cama.getQuarto().diariasParaDesconto())
            this.valorDevido += this.cama.getQuarto().valorComDesconto();
        else
            this.valorDevido += this.cama.getQuarto().valorDiaria();
        if (this.cliente.temDescontoFidelidade())
            this.valorDevido -= this.cliente.valorDescontoFidelidade();
    }
    
    public int fazerCheckout() {
        this.cama.desocupa();
        this.cliente.adicionaHistorico(this.qtdDiarias, this.cama);
        if (this.qtdDiarias >= 10)
            this.cliente.daDescontoFidelidade();
        return this.valorDevido;
    }
    
    
    
    
}
