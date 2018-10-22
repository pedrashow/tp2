/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista3_q4;

import lista3_q4.OperacaoFinanceira.TipoOperacao;

/**
 *
 * @author beto
 */
public class ContaBancaria {
    
    private final String agencia;
    private final String numero;
    private final int digitoVerificador;
    private final String titular;
    private double saldo;
    
    public ContaBancaria (String agencia, String numero, int digitoVerificador, String titular) {
        this.agencia = agencia;
        this.numero = numero;
        this.digitoVerificador = digitoVerificador;
        this.titular = titular;
        this.saldo = 0.0;
    }
    
    public ContaBancaria (String agencia, String numero, int digitoVerificador, String titular, double saldo) {
        this(agencia, numero, digitoVerificador, titular);
        this.saldo = saldo;
    }
    
    private void setSaldo(double valor) {
        this.saldo = valor;
    }
    
    public double getSaldo () {
        return this.saldo;
    }
    
    public String getConta () {
        return this.numero + "-" + String.valueOf(this.digitoVerificador);
    }
    
    public OperacaoFinanceira sacar (double valor) {
        OperacaoFinanceira of = new OperacaoFinanceira (TipoOperacao.SAQUE, this, valor);
        if (valor <= 0) {
            of.setSucesso(false);
            throw new IllegalArgumentException("Não é possível sacar um valor"
                    + " menor ou igual a zero");
        }
        else if (this.getSaldo() - valor <= 0) {
            of.setSucesso(false);
            System.out.println("Não há saldo suficiente");
        }
        else {
            this.setSaldo(this.getSaldo() - valor);
            of.setSucesso(true);
            System.out.println("Retire as notas abaixo");    
        }
        return of;
    }
    
    public OperacaoFinanceira depositar (double valor) {
        OperacaoFinanceira of = new OperacaoFinanceira (TipoOperacao.DEPOSITO, this, valor);
        if (valor < 0) {
            of.setSucesso(false);
            throw new IllegalArgumentException("Não é possível depositar um valor negativo");
        } 
        else {
            this.setSaldo(this.getSaldo()+valor);
            of.setSucesso(true);
            System.out.println("Depósito efetuado com sucesso");
        }
        return of;
    }
    
    public void imprimeDescricao() {
        System.out.println("Descrição da Conta");
        System.out.println("Titular: " + this.titular);
        System.out.println("Agencia: " + this.agencia);
        System.out.println("Conta: " + this.numero + "-" + this.digitoVerificador);
        System.out.println("==============");
    }
    
}
