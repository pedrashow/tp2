/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista3_q4;

import java.util.ArrayList;

/**
 *
 * @author beto
 */
public class Principal {
    
    public static ArrayList<ContaBancaria> contas = new ArrayList();
    public static ArrayList<OperacaoFinanceira> operacoes = new ArrayList();
    
    public static ContaBancaria getContaByNum (String numero, int digito) {
        String cc = numero + "-" + String.valueOf(digito);
        for (ContaBancaria conta : contas) {
            if (cc.equals(conta.getConta()))
                return conta;
        }
        return null;
    }
    
    
    
    public static void main(String[] args) {
        ContaBancaria minhaConta = new ContaBancaria("6179","12943",5,"Roberto Oliveira");
        try {
            operacoes.add(minhaConta.sacar(50.0));
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
        try {
            operacoes.add(minhaConta.depositar(80000.0));
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }        
        try {
            operacoes.add(minhaConta.sacar(-50.0));
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }        
        try {
            operacoes.add(minhaConta.depositar(-1000.0));
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }        
        try {
            operacoes.add(minhaConta.sacar(500.0));
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
        minhaConta.imprimeExtrato(minhaConta.historicoTransacoes(operacoes));
    }
}
