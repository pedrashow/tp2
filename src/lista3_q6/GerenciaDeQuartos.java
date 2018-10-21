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
    
    public static void fazerCheckIn(String nome, int idCama) {
        //cliente, cama
        Cliente cl = getClienteByName (nome);
        Cama c = getCamaById (idCama);
        diarias.add(new Diaria(cl,c));
    }
    
    public static void fazerCheckOut(int id) {
        Cama c = getCamaById(id);
        Diaria d = c.buscaDiaria(diarias);
        System.out.println("=== CHECKOUT ===");
        System.out.println(d.getCliente().getNome());
        System.out.println("Cama " + c.getId() + " Quarto: " + c.getQuarto().descricao());
        System.out.println("diarias: " + d.getQtdDiarias());
        System.out.println("a pagar: " + d.getValorDevido());
        d.encerrar();
        diarias.remove(d);
    }
    
    public static void rodarDiaria () {
        for (Diaria d : diarias) {
            d.contabilizarDiaria();
        }
    }
    
    public static void listaHospedagem(String nome) {
        Cliente c = getClienteByName (nome);
        c.imprimeHistorico();
    }
    
    public static void listaOcupacao (ArrayList<Cama> camas) {
        Collections.sort(camas); //ordena pelo numero do quarto
        Quarto q = new QuartoSimples(-1); //apenas para comparar e imprimir a descrição do quarto
        for (Cama c : camas) {
            if (c.getQuarto() != q)
                System.out.println("Quarto: " + c.getQuarto().descricao());
            if (c.estaDisponivel())
                System.out.println( "id Cama: " + c.getId() + "\tDisponível");
            else
                System.out.println( "id Cama: " + c.getId() + "\tOcupado por: " + c.buscaDiaria(diarias).getCliente().getNome());
            q = c.getQuarto();
        }
    }
    
    public static Cama getCamaById (int id) {
        for (Cama c : camas) {
            if (c.getId() == id)
                return c;
        }
        System.err.println("Cama não encontrada");
        return null;
    }
    
    public static Cliente getClienteByName (String nome) {
        for (Cliente c : clientes) {
            if (c.getNome().equals(nome) )
                return c;
        }
        System.err.println("Cliente não encontrado");
        return null;
    }
    
    public static void main(String[] args) {
    
    /**
     * listar ocupação, quartos com cama livre e camas ocupadas por quais clientes -- listaOcupacao
     * solicitar ocupação em quarto simples/luxo -- fazerCheckIn
     * realizar checkout -- fazerCheckOut
     * rodar diárias -- rodarDiarias
     * listar hospedagens por cliente -- listaHospedagem
     */

        cadastrarCliente();
        cadastrarQuarto();
        cadastrarCama();
        for (int i = 0; i < 90; i+=2) {
            fazerCheckIn(clientes.get(i*2).getNome(),i+1);
        }
        listaOcupacao(camas);
        fazerCheckOut(21);
        rodarDiaria();
        fazerCheckOut (9);
        listaHospedagem ("Dre Ferreira");
        listaHospedagem ("Francesco Castanie");
        fazerCheckIn ("Francesco Castanie", 36);
        for (int i = 0; i < 20; i++) {
            rodarDiaria();
        }
        fazerCheckOut (36);
        listaHospedagem ("Francesco Castanie");
        
    }
    
}
