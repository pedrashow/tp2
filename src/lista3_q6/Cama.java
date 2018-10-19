/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista3_q6;

import java.util.ArrayList;


/**
 *
 * @author beto
 */


public class Cama implements Comparable<Cama> {
    
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
    
    public Diaria buscaDiaria(ArrayList<Diaria> diarias) {
        if (this.disponivel)
            return null;
        else {
            for (Diaria diaria : diarias) {
                if (diaria.getCama() == this)
                    return diaria;
            }
        }
        return null;
    }
    
    @Override
    public int compareTo(Cama c) {
        /**
         * Ordena pelo número do quarto
         */
        if (this.getQuarto().getId() < c.getQuarto().getId())
            return -1;
        else if (this.getQuarto().getId() > c.getQuarto().getId())
            return 1;
        return 0;
    }
   
}
