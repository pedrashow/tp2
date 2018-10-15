/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista3_Q7;

import java.util.ArrayList;

/**
 *
 * @author beto
 */

public class PoligonoIrregular implements FormaGeometrica {
    
    private ArrayList<Ponto> vertices = new ArrayList<>();
    
    PoligonoIrregular (Ponto... pontos) {
        for (Ponto ponto : pontos) {
            vertices.add(ponto);
        }
    }
    
    public int getNumLados() {
        return this.vertices.size();
    }
    
    @Override
    public double perimetro() {
        double per = 0;
        for (int i = 0; i < this.vertices.size()-1; i++)
            per += Ponto.dist(this.vertices.get(i), this.vertices.get(i+1));
        return per;
    }
    
    @Override
    public double area() {
        
        double arEmDobro = 0;
        
        
        return arEmDobro / 2;
    }
    
    @Override
    public String descricao() {
        return "Sou um polígono irregular de " + this.getNumLados() + " lados";
    }
}
