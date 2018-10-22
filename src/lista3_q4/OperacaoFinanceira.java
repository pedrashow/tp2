/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista3_q4;

/**
 *
 * @author beto
 */
public class OperacaoFinanceira {
    
    public static enum TipoOperacao { SAQUE, DEPOSITO ;}
    
    private final TipoOperacao tipo;
    private final ContaBancaria conta;
    private final double valor;
    private boolean sucesso;
    
    public OperacaoFinanceira (TipoOperacao tipo, ContaBancaria c, double valor) {
        this.conta = c;
        this.valor = valor;
        this.tipo = tipo;
    }
    
    public void setSucesso (boolean status) {
        this.sucesso = status;
    }
    
    public ContaBancaria getConta() {
        return this.conta;
    }
    
    public String imprimir() {
        String status;
        if (this.sucesso)
            status = "Sucesso";
        else
            status = "Falha";
        return this.conta.getConta() + "\t" + this.tipo.toString() +  "\t" + this.valor + "\t" + status;
    }
    
}
