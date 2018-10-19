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

public class QuartoSimples extends Quarto {
        
    QuartoSimples (int id) {
        super(id);
    }
    
    @Override
    public int minCamas() {
        return 0; 
    }
    
    @Override
    public int maxCamas() {
        return 100; //sem limite teorico, valor por hipotese
    }
   
    @Override
    public int valorDiaria() {
        return 100;
    }

    @Override
    public int diariasParaDesconto() {
    //a partir de qual diaria consecutiva é cobrado o valor com desconto
        return 4; //se alterar, atualizar metodo valorComDesconto
    }
    
    @Override
    public int valorComDesconto() {
        return 80; //se alterar, não esqueça de definir a qtd de diarias em getDiariasParaDesconto
    }
    
    @Override
    public String descricao() {
        return super.descricao() + " - Quarto Simples ";
    }
}
