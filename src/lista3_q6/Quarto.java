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

public abstract class Quarto {
    
    private final int id;
    
    private int qtdCamas;
    
    Quarto (int id) {
        this.id = id;
    }
    
    Quarto (int id, int qtdCamas) {
        this.id = id;
        this.qtdCamas = qtdCamas;
    }
    
    public abstract int minCamas();
    
    public abstract int maxCamas();
    
    public void adicionarCama() {
        if (this.qtdCamas < this.maxCamas())
            this.qtdCamas++;
        else
            throw new IllegalArgumentException ("Não é possível adicionar camas a este quarto");
    }
    
    public void removerCama() {
        if (this.qtdCamas > this.minCamas())
            this.qtdCamas--;
        else
            throw new IllegalArgumentException ("Não é possível remover camas deste quarto");
    }
    
    public int getQtdCamas() {
        return this.qtdCamas;
    }
    
    public int getId() {
        return this.id;
    }
   
    public abstract int valorDiaria ();

    public abstract int diariasParaDesconto(); 
    //a partir de qual diaria consecutiva é cobrado o valor com descono
    
    public abstract int valorComDesconto ();
    
    public String descricao() {
        return this.id + " Camas: " + this.qtdCamas; 
    }
    
}
