/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista3_q7;

import java.util.ArrayList;

/**
 *
 * @author beto
 */

public class PoligonoIrregular implements FormaGeometrica {
    
    private final ArrayList<Ponto> vertices = new ArrayList<>();
    
    PoligonoIrregular (Ponto... pontos) {
        for (Ponto ponto : pontos) {
            vertices.add(ponto);
        }
    }
    
    public double lado() {
        return 0;
    }
    
    public double raio() {
        return 0;
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
        int ULTIMO_PONTO = this.vertices.size() - 1;
        double arEmDobro = (this.vertices.get(ULTIMO_PONTO).getX() * this.vertices.get(0).getY()) - (this.vertices.get(0).getX() * this.vertices.get(ULTIMO_PONTO).getY());
        for (int i = 0; i < this.vertices.size()-2; i++)
            arEmDobro += (this.vertices.get(i).getX() * this.vertices.get(i+1).getY()) - (this.vertices.get(i+1).getX() * this.vertices.get(i).getY());
        return arEmDobro / 2;
    }
    
    @Override
    public String descricao() {
        return "Sou um polígono irregular de " + this.getNumLados() + " lados";
    }
}
