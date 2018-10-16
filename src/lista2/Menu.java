/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author beto
 */
public class Menu {
    // para facilitar exibicao e escolhas de menu
        // a opcao 0 será sempre sair/voltar
        private ArrayList<String> itens = new ArrayList<>();
        
        public Menu (String... itens) {
            for (String item : itens)
                this.itens.add(item);
        }
        
        public void mostrarMenu(){
            System.out.println("Escolha uma opção:");
            for (int i = 0; i < this.itens.size(); i++)
                System.out.println(i+1 + " - " + this.itens.get(i) );
            System.out.println("0 - Sair");
        }
        
        public int tamanho() {
            return this.itens.size();
        }
}
