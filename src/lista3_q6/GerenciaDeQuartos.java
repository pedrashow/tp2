/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista3_q6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author beto
 */
public class GerenciaDeQuartos {
   
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
    
    public static void fazerCheckin(Cliente cl, Cama c) {
        //cliente, cama
        diarias.add(new Diaria(cl,c));

    }
    
    public static void rodarDiaria (ArrayList<Diaria> diaria) {
        for (Diaria d : diaria) {
            d.contabilizarDiaria();
        }
    }
    
    public static void listaHospedagem(ArrayList<Cliente> clientes) {
        for (Cliente c : clientes) {
            c.imprimeHistorico();
        }
    }
    
    public static void listaOcupacao (ArrayList<Cama> camas) {
        Collections.sort(camas); //ordena pelo numero do quarto
        for (Cama c : camas) {
            System.out.print("Quarto: " + c.getQuarto().descricao() + " Cama: " + c.getId());
            if (c.estaDisponivel())
                System.out.println("\tDisponível");
            else
                System.out.println("\tOcupado por:" + c.buscaDiaria(diarias).getCliente().getNome());
        }
    }
    
    public static void main(String[] args) {
    
    /**
     * listar ocupação, quartos com cama livre e camas ocupadas por quais clientes xx
     * solicitar ocupação em quarto simples/luxo
     * realizar checkout
     * rodar diárias xx
     * listar hospedagens por cliente xx
     */

        cadastrarCliente();
        cadastrarQuarto();
        cadastrarCama();
        listaOcupacao(camas);

        



    }
    
}
