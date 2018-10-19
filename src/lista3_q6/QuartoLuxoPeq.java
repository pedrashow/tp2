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

public class QuartoLuxoPeq extends Quarto {
    
    
    QuartoLuxoPeq (int id) {
        super(id);
    }
    
    @Override
    public int minCamas() {
        return 0;
    }
    
    @Override
    public int maxCamas() {
        return 6;
    }
   
    @Override
    public int valorDiaria() {
        return 200;
    }

    @Override
    public int diariasParaDesconto() {
        return 1000;
    }
    
    @Override
    public int valorComDesconto() {
        return 200;
    }
    
    @Override
    public String descricao() {
        return super.descricao() + " - Quarto Luxo Pequeno";
    }

}
