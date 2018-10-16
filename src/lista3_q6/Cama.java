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


public class Cama {
    
    private final int id;
    
    private Quarto quarto;
    
    private boolean disponivel;
    
    Cama (int id) {
        this.id = id;
        this.disponivel = true;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void ocupa() {
        this.disponivel = false;
    }
    
    public void desocupa() {
        this.disponivel = true;
    }
    
    public boolean estaDisponivel() {
        return this.disponivel;
    }
    
    public Quarto getQuarto() {
        return this.quarto;
    }
    
    public void setQuarto(Quarto quarto) {
        //remove a cama de um quarto e adiciona a outro
        if (this.quarto != null)
            this.quarto.removerCama();
        this.quarto = quarto;
        try {
            this.quarto.adicionarCama();
        }
        catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
            this.quarto = null;
        }
    }
   
}
