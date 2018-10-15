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

public abstract class Solido {
        
    private final PoligonoRegular base;
    private final double altura;
    
    Solido(PoligonoRegular base, double altura) {
        this.base = base;
        this.altura = altura;
    }
    
    public PoligonoRegular getBase() {
        return this.base;
    }
    
    public double getAltura() {
        return this.altura;
    }
    
    public double areaDasBases() {
        return this.base.area() * 2;
    }
    
    public double areaLateral () {
        return this.base.perimetro() * this.altura;
    }
    
    public double areaSuperficie () {
        return this.areaDasBases() + this.areaLateral();
    }
    
    public double volume() {
        return this.altura * this.base.area();
    }
    
    public abstract String nome();
    
    public void imprimeDados() {
        System.out.println(this.nome());
        System.out.println("Perímetro da base: " + this.base.perimetro());
        System.out.println("Área da base: " + this.base.area());
        System.out.println("Volume: " + this.volume());
        System.out.println("Área da superfície: " + this.areaSuperficie());
    }
}
