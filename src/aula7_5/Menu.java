/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula7_5;

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
        
        public void imprimirMenu(){
            System.out.println("Escolha uma opção:");
            for (int i = 0; i < this.itens.size(); i++)
                System.out.println(i+1 + " - " + this.itens.get(i) );
            System.out.println("0 - Sair");
        }
        
        public int tamanho() {
            return this.itens.size();
        }
        
        public int lerEscolha (Scanner in) { 
            /*
            * Ler a escolha do menu. Retorna o número escolhido
            * Retorna -1 para entrada inválida
            */
            try {
                int lido = Integer.parseInt(in.nextLine());
                if (lido > this.tamanho() || lido < 0) 
                    throw new IllegalArgumentException( "Entrada Inválida" );
                return lido;
            } catch (NumberFormatException ex) {
                System.err.println("Entrada Inválida. Favor escolher um número.");
                return -1;
            } catch (IllegalArgumentException ex) {
                System.err.println(ex.getMessage() + 
                        ". Favor escolher entre 0 e " + this.tamanho());
                return -1;
            }
        }
}
