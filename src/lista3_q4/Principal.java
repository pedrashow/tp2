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
        double[] valores = {50.0, 8000.0, -50.0, -1000.0, 500.0};
        ContaBancaria minhaConta = new ContaBancaria("6179","12943",5,"Roberto Oliveira");
        for (int i = 0; i < valores.length; i++) {
            if (i%2 == 0) {
                try {
                    minhaConta.sacar(valores[i]);
                } catch (IllegalArgumentException ex) {
                    System.err.println(ex.getMessage());
                }
            }
            else {
                try {
                    minhaConta.depositar(valores[i]);
                } catch (IllegalArgumentException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
        minhaConta.imprimeExtrato(minhaConta.historicoTransacoes(operacoes));
    }
}
