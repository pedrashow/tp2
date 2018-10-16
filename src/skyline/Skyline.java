/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skyline;

import java.io.File;
import java.io.FileNotFoundException;
//import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author labccet
 */
public class Skyline {

    public static int [] lerProximoPredio( Scanner entrada ) {
        // TAREFA 1: implementar esta função
        // para ler um número a partir da entrada: entrada.nextInt();
        int [] predio = new int [3];
        for (int i=0;i<3;i++)
            predio[i] = entrada.nextInt();
        return predio;
    }
    
    public static void adicionarPredio( int [] predio, int [] skyline ) {
        // TAREFA 2: implementar esta função
    	// predio[0] � a posi��o que sobre, predio[1] � a altura e predio[2] � a posicao que desce.
        for (int i = predio[0]; i < predio[2]; i++)
            if (skyline[i] < predio[1])
                skyline[i] = predio[1];
    }
    
    public static String gerarSaida( int [] skyline ) {
        // TAREFA 3: implementar esta função
    	String saida = new String();
    	for (int i = 0; i < skyline.length-1; i++)
    		if (skyline[i] != skyline[i+1]) {
    			saida += i+1;
    			saida += " ";
    			saida += skyline[i+1];
    			saida += " ";
    		}
        return saida;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Scanner entrada = new Scanner( new File( "src/skyline/testePDF.txt" ) );
            // para uso com Online Judge: comentar a linha de cima
            //                       e descomentar a linha de baixo
            // Scanner entrada = new Scanner( System.in );
            int X_MAX = 10000;
            
            // TAREFA 4: ver arquivo anexo tarefa4.txt
            int [] skyline = new int [X_MAX+1];
            int [] predio;
            
            while( entrada.hasNext() ) {
                predio = lerProximoPredio( entrada );
                adicionarPredio( predio, skyline );
            }

            String saida = gerarSaida( skyline );
            System.out.println( saida );
        }
        catch (FileNotFoundException ex) {
            System.out.println( "ERRO: Arquivo não encontrado." );
        }
        
    }
    
}
