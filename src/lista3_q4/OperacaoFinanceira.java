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
    
    private enum TipoOperacao { SAQUE, DEPOSITO ;}
    
    private TipoOperacao tipo;
    private ContaBancaria conta;
    private double valor;
    private boolean sucesso;
}
