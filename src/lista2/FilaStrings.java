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
public class FilaStrings {
    
    private ArrayList<String> palavras = new ArrayList<>();
    
    public FilaStrings (String... palavras) {
        for (String s : palavras)
            this.palavras.add(s);
    }
    
    public FilaStrings () {
        
    }
    
    public void inserirString (String s) {
        this.palavras.add(s);
    }
    
    public void removerString () {
        this.palavras.remove(0);
    }
    
    public String acessarString () {
        if (this.palavras.isEmpty())
            throw new IllegalArgumentException("FilaStrings está vazia");
        else
            return this.palavras.get(0);
    }
    
    public int contarStrings () {
        return this.palavras.size();
    }
    
    public void imprimeStatus () {
        System.out.println("String no inicio: " + this.acessarString());
        System.out.println("Strings na fila: " + this.contarStrings());
        System.out.println("==========");
    }
    
    public static void main(String[] args) {
        FilaStrings minhaLista = new FilaStrings();
        minhaLista.imprimeStatus();
        minhaLista.inserirString("mais uma");
        minhaLista.removerString();
        minhaLista.imprimeStatus();
        
    }
}
