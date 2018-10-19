/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista3_q6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author beto
 */
public class GerenciaDeQuartos {
    
    /**
     * listar ocupação, quartos com cama livre e camas ocupadas por quais clientes
     * solicitar ocupação em quarto simples/luxo
     * realizar checkout
     * rodar diárias
     * listar hospedagens por cliente
     */
    
    public static ArrayList <Cama> camas = new ArrayList<>();
    public static ArrayList <Diaria> diarias = new ArrayList<>();
    public static ArrayList <Cliente> clientes = new ArrayList<>();
    public static ArrayList <Quarto> quartos = new ArrayList<>();
    
     
    public static void cadastrarQuarto() {
        //Simples, Luxo Pequeno, Luxo grande : id
        // base hipotetica com quartos de 101 a 120
        try {
            Scanner entrada = new Scanner(new File("src/lista3_q6/quartos.txt"));
            entrada.nextLine(); // primeira linha contem cabeçalho
            int linha;
            Quarto q;
            while(entrada.hasNext()) {
                linha = Integer.parseInt(entrada.nextLine());
                if (linha % 10 == 0)
                    q = new QuartoLuxoGrande(linha);
                else if (linha % 2 != 0)
                    q = new QuartoSimples(linha);
                else
                    q = new QuartoLuxoPeq(linha);
                quartos.add(q);
            }
        }
        
        catch (FileNotFoundException ex) {
            System.out.println( "ERRO: Arquivo não encontrado." );
        }
    }

    public static void cadastrarCama() {
        //id..1 a90, depois associar a um quarto entre 101 e 120 - luxo grande são 110 e 120
        try {
            Scanner entrada = new Scanner(new File("src/lista3_q6/camas.txt"));
            entrada.nextLine(); // primeira linha contem cabeçalho
            int linha;
            Cama c;
            while(entrada.hasNext()) {
                linha = Integer.parseInt(entrada.nextLine());
                c = new Cama(linha);
                if (linha < 9) 
                    c.setQuarto(quartos.get(19)); //quarto luxo grande
                else if (linha < 18) 
                    c.setQuarto(quartos.get(9)); // quarto luxo grande
                else
                    c.setQuarto(quartos.get(linha % 20));
                camas.add(c);
            }
        }
        
        catch (FileNotFoundException ex) {
            System.out.println( "ERRO: Arquivo não encontrado." );
        }
    }
    
    public static void cadastrarCliente() {
        //nome
        
        try {
            Scanner entrada = new Scanner(new File("src/lista3_q6/clientes.txt"));
            entrada.nextLine(); // primeira linha contem cabeçalho
            String linha;
            while(entrada.hasNext()) {
                linha = entrada.nextLine();
                clientes.add(new Cliente(linha));
            }
        }
        
        catch (FileNotFoundException ex) {
            System.out.println( "ERRO: Arquivo não encontrado." );
        }
    }
    
    public static void fazerCheckin() {
        //cliente, cama
        for (int i = 0; i < 90; i+=5) {
            diarias.add(new Diaria(clientes.get(i*2),camas.get(i)));
        }
    }
    
    public static void main(String[] args) {
        cadastrarCliente();
        cadastrarQuarto();
        cadastrarCama();
        fazerCheckin();
        for (int i = 0; i < 15; i++) {
            for (Diaria d : diarias) {
                d.contabilizarDiaria();
            }
        }
        for (Diaria d : diarias) {
            d.fazerCheckout();
        }
        for (Cliente c : clientes) {
            c.imprimeHistorico();
        }

    }
    
}
