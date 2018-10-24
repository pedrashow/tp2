/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista3_q4;

import java.util.ArrayList;
import lista3_q4.OperacaoFinanceira.TipoOperacao; // enum com SAQUE e DEPOSITO

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
    
    public void sacar (double valor) {
        OperacaoFinanceira of = new OperacaoFinanceira (TipoOperacao.SAQUE, this, valor);
        if (valor <= 0) {
            of.setSucesso(false);
            Principal.operacoes.add(of);
            throw new IllegalArgumentException("Não é possível sacar um valor"
                    + " menor ou igual a zero - saque de " + valor + " não efetuado.");
        }
        else if (this.getSaldo() - valor <= 0) {
            of.setSucesso(false);
            Principal.operacoes.add(of);
            System.out.println("Não há saldo suficiente");
        }
        else {
            this.setSaldo(this.getSaldo() - valor);
            of.setSucesso(true);
            Principal.operacoes.add(of);
            System.out.println("Retire as notas abaixo");    
        }
    }
    
    public void depositar (double valor) {
        OperacaoFinanceira of = new OperacaoFinanceira (TipoOperacao.DEPOSITO, this, valor);
        if (valor < 0) {
            of.setSucesso(false);
            Principal.operacoes.add(of);
            throw new IllegalArgumentException("Não é possível depositar um valor negativo - deposito de " + valor + " não efetuado.");
        } 
        else {
            this.setSaldo(this.getSaldo()+valor);
            of.setSucesso(true);
            Principal.operacoes.add(of);
            System.out.println("Depósito efetuado com sucesso");
        }
    }
    
    public void imprimeDescricao() {
        System.out.println("Descrição da Conta");
        System.out.println("Titular: " + this.titular);
        System.out.println("Agencia: " + this.agencia);
        System.out.println("Conta: " + this.numero + "-" + this.digitoVerificador);
        System.out.println("==============");
    }
    
    public ArrayList<OperacaoFinanceira> historicoTransacoes (ArrayList<OperacaoFinanceira> ofs) {
        ArrayList<OperacaoFinanceira> histTransacoesIndividual = new ArrayList<>();
        for (OperacaoFinanceira of : ofs) {
            if (of.getConta().equals(this))
                histTransacoesIndividual.add(of);
        }
        return histTransacoesIndividual;
    }
    
    public void imprimeExtrato(ArrayList<OperacaoFinanceira> ofs) {
        this.imprimeDescricao();
        for (OperacaoFinanceira of : ofs) {
            System.out.println(of.imprimir());
        }
    }
    
}
