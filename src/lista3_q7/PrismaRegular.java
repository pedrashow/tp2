/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista3_q7;

/**
 *
 * @author beto
 */
public class PrismaRegular extends Solido {
    
    PrismaRegular(PoligonoRegular base, double altura) {
        super(base,altura);
    }
    
    @Override
    public String nome() {
        return "Prisma Regular de altura " + this.getAltura() + "e base com " + this.getBase().getNumLados() + " lados de comprimento " + this.getBase().lado();
    }
}
