/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista2;

import java.util.ArrayList;

/**
 *
 * @author beto
 */
public class ConjuntoInteiros {
    
    private String nome;
    private ArrayList<Integer> inteiros = new ArrayList<>();

    private boolean pertence(int x) {
        for (int y : this.inteiros)
            if (y == x)
                return true;
        return false;
    }
    
    public ConjuntoInteiros (String nome, int... numeros) {
        this.nome = nome;
        for (int x : numeros)
            this.adicionarInteiro(x);
    }
    
    public ConjuntoInteiros (String nome, ArrayList<Integer> numeros) { //para copiar os elementos de um conjunto para outro
        this.nome = nome;
        for (int x : numeros)
            this.adicionarInteiro(x);
    }
    
    public ConjuntoInteiros (String nome) {
        this.nome = nome;
    }
    
    
    public void adicionarInteiro (int numero) {
        if (!this.pertence(numero))
            this.inteiros.add(numero);
        else
            throw new IllegalArgumentException( "Numero não incluído pois já pertence a este conjunto" );
    }
    
    public void removerInteiro (int numero) {
        if (this.pertence(numero))
            this.inteiros.remove(Integer.valueOf(numero));
        else
            throw new IllegalArgumentException( "Impossível remover, numero não pertence a este conjunto" );
    }

    public int calculaCardinalidade() {
        return this.inteiros.size();
    }
    
    public ArrayList<Integer> elementos () {
        return this.inteiros;
    }
    
    public static ConjuntoInteiros uniao (String nome, ConjuntoInteiros a, ConjuntoInteiros b) {
        ConjuntoInteiros c = new ConjuntoInteiros (nome,a.elementos());
        for (int x : b.elementos() )
            c.adicionarInteiro(x);
        return c;
    }
    
    public static ConjuntoInteiros intersecao (String nome, ConjuntoInteiros a, ConjuntoInteiros b) {
        ConjuntoInteiros c = new ConjuntoInteiros(nome);
        for (int x : a.elementos())
            for (int y : b.elementos())
                if (x == y)
                    c.adicionarInteiro(y);
        return c;
    }
    
    public static ConjuntoInteiros diferenca (String nome, ConjuntoInteiros a, ConjuntoInteiros b) {
        ConjuntoInteiros c = new ConjuntoInteiros(nome, a.elementos());
        for (int x : b.elementos())
            for (int y : a.elementos())
                if (x == y)
                    c.removerInteiro(x);
        return c;
    }
    
    public static int contaInterseções (ConjuntoInteiros a, ConjuntoInteiros b) {
        return ConjuntoInteiros.intersecao("x", a, b).calculaCardinalidade();
    }
    
    public static boolean ehSubconjunto (ConjuntoInteiros a, ConjuntoInteiros b) {
        // é válido se todos os elementos de "a" pertecem a interseção entre "a" e "b"
        if (a.calculaCardinalidade() == ConjuntoInteiros.contaInterseções(a, b))
            return true;
        return false;
    }
    
    public static boolean saoIguais (ConjuntoInteiros a, ConjuntoInteiros b) {
        // é válido se "a" é subconjunto de "b" e se "b" é subconjunto de "a"
        if (ConjuntoInteiros.ehSubconjunto(a, b) && ConjuntoInteiros.ehSubconjunto(b, a))
            return true;
        return false;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void descrever() {
        System.out.print(this.nome + ": ");
        if (this.calculaCardinalidade() == 0)
            System.out.println("Conjunto vazio");
        else {
            StringBuilder descricao = new StringBuilder();
            descricao.append(String.valueOf(this.calculaCardinalidade()));
            descricao.append ("  elementos: { ");
            for (int x : this.elementos()) {
                descricao.append(String.valueOf(x));
                descricao.append(", ");
            }
            descricao.deleteCharAt(descricao.length()-2); //apaga a ultima virgula
            descricao.append("}");
            System.out.println(descricao);
        }
    }
    
    public static void main(String[] args) {
        ConjuntoInteiros a = new ConjuntoInteiros ("A",4,5,6);
        a.adicionarInteiro(4);
        a.removerInteiro(5);
        ConjuntoInteiros b = new ConjuntoInteiros ("B", 5,6, 10);
        ConjuntoInteiros c = ConjuntoInteiros.uniao("C", a, b);
        ConjuntoInteiros d = ConjuntoInteiros.intersecao("D", a, b);
        ConjuntoInteiros e = ConjuntoInteiros.diferenca("E", c, d);
        a.descrever();
        b.descrever();
        c.descrever();
        System.out.println(ConjuntoInteiros.contaInterseções(a, b));
        d.descrever();
        d.removerInteiro(6);
        d.descrever();
        e.descrever();
        System.out.println(ConjuntoInteiros.ehSubconjunto(d, c));
        System.out.println(ConjuntoInteiros.ehSubconjunto(b, a));
        System.out.println(ConjuntoInteiros.saoIguais(a, b));
        System.out.println(ConjuntoInteiros.saoIguais(a, a));

        
    }
}
