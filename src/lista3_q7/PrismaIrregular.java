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
public class PrismaIrregular extends Solido {
    
    PrismaIrregular(PoligonoIrregular base, double altura) {
        super(base,altura);
    }
    
    @Override
    public String nome() {
        return "Prisma Irregular de altura " + this.getAltura() + "e base com " + this.getBase().getNumLados() + " lados.";
    }
}
