/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista3_Q7;

/**
 *
 * @author beto
 */
public class Circulo extends PoligonoRegular {
    // circulo é um polígono regular de infinitos lados
    
    Circulo (Ponto centro, Ponto vertice) {
        super(0,centro,vertice);
    }
    
    @Override
    public double apotema() {
        return this.raio();
    }
    
    @Override
    public double lado() {
        return 0;
    }
    
    @Override
    public double perimetro() {
        return 2 * Math.PI * this.raio();
    }
    
    @Override
    public double area () {
        return Math.PI * this.raio() * this.raio();
    }
    
    @Override
    public String descricao() {
        return "Sou um círculo de raio " + this.raio();
    }
    
}
