/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista3_q7;

/**
 *
 * @author Beto
 */

public class PoligonoRegular implements FormaGeometrica {
    
    private final int numLados;
    private final Ponto centro;
    private final Ponto vertice;
    
    PoligonoRegular (int numLados, Ponto centro, Ponto vertice) {
        this.centro = centro;
        this.vertice = vertice;
        this.numLados = numLados;
    }
    
    @Override
    public int getNumLados() {
        return this.numLados;
    }
    
    @Override
    public double raio () {
        return Ponto.dist (this.centro,this.vertice);
    }
    
    @Override
    public double lado () {
        return 2 * this.raio() * Math.sin(Math.PI/this.numLados);
    }
    
    public double apotema() {
        return this.raio() * Math.cos(Math.PI/this.numLados);
    }
    
    @Override
    public double perimetro() {
        return numLados * this.lado();
    }
    
    @Override
    public double area() {
        return this.perimetro() * this.apotema() / 2;
    }
    
    @Override
    public String descricao() {
        return "Tenho " + numLados + " lados e meu lado tem comprimento " + this.lado();
    }
}
