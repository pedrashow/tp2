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

public class QuartoLuxoGrande extends Quarto {
    
    QuartoLuxoGrande (int id) {
        super(id,7);
    }
    
    @Override
    public int minCamas() {
        return 7; //nao esquecer de alterar o construtor se mudar este valor
    }
    
    @Override
    public int maxCamas() {
        return 100; //sem limite teorico, valor por hipotese
    }
   
    @Override
    public int valorDiaria() {
        return 150;
    }

    @Override
    public int diariasParaDesconto() {
        return 1000; //se alterar, atualizar metodo valorComDesconto
    }
    
    @Override
    public int valorComDesconto() {
        return 150; //se alterar, não esqueça de definir a qtd de diarias em getDiariasParaDesconto
    }
    
    @Override
    public String descricao() {
        return super.descricao() + " - Quarto Luxo Grande ";
    }
}
