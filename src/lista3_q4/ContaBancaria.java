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
public class ContaBancaria {
    
    private final String agencia;
    private final String numero;
    private final int digitoVerificador;
    private final String titular;
    private double saldo;
    private  int TRANSACOES_A_GUARDAR  = 3; //qtd de transacoes que devem ser armazenadas
    private double[] transacoes = new double[TRANSACOES_A_GUARDAR]; //valor positivo para depósitos e negativo para saques
    
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
    
    public void sacar (double valor) {
        if (valor <= 0)
            throw new IllegalArgumentException("Não é possível sacar um valor"
                    + " menor ou igual a zero");
        else if (this.getSaldo() - valor <= 0)
            System.out.println("Não há saldo suficiente");
        else {
            this.setSaldo(this.getSaldo() - valor);
            this.registraTransacao(-1 * valor); //como é um saque, multiplico o valor por -1
            System.out.println("Retire as notas abaixo");    
        }
        
    }
    
    public void depositar (double valor) {
        if (valor < 0) 
            throw new IllegalArgumentException("Não é possível depositar um valor negativo");
        else {
            this.setSaldo(this.getSaldo()+valor);
            this.registraTransacao(valor);
            System.out.println("Depósito efetuado com sucesso");
        }
    }
    
    public void registraTransacao (double valor) {
        for (int i = this.TRANSACOES_A_GUARDAR -1; i > 0;  i--)
            this.transacoes[i] = this.transacoes[i-1];
        this.transacoes[0] = valor;
    }
    
    public void imprimeDescricao() {
        System.out.println("Descrição da Conta");
        System.out.println("Titular: " + this.titular);
        System.out.println("Agencia: " + this.agencia);
        System.out.println("Conta: " + this.numero + "-" + this.digitoVerificador);
        System.out.println("==============");
    }
    
    public void imprimeTransacoes() {
        System.out.println("Ultimas " + this.TRANSACOES_A_GUARDAR + " transações:");
        for (double valor : this.transacoes) {
            if (valor < 0 )
                System.out.printf("saque: %.2f  %n", -1 * valor);
            else
                System.out.printf("deposito: %.2f  %n", valor);
        }
    }
    
    public void imprimeExtrato () {
        this.imprimeDescricao();
        this.imprimeTransacoes();
    }
    
    public static void main(String[] args) {
        ContaBancaria minhaConta = new ContaBancaria("6179","12943",5,"Roberto Oliveira");
        minhaConta.sacar(50.0);
        minhaConta.depositar(500.0);
        minhaConta.sacar(30.0);
        minhaConta.sacar(35.0);
        minhaConta.imprimeExtrato();
        
    }
    
}
