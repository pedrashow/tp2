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

public class Cilindro extends Solido {
   
    Cilindro(Circulo base, double altura) {
        super(base,altura);
    }
    
    @Override
    public String nome() {
        return "Cilindro de altura " + this.getAltura() + " e com raio da base de tamanho " + this.getBase().raio();
    }    
}
