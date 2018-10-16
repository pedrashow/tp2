/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista2;

import java.util.*;

/**
 *
 * @author beto
 */
public class questao6 {
    
    public static Scanner entrada = new Scanner(System.in);
    public static ArrayList<ConjuntoInteiros> conjuntos = new ArrayList<>();
    
    public static void main(String[] args) {
        Menu menuPrincipal = new Menu ("Criar Conjunto", "Listar Conjuntos", "Manipular Conjuntos", "Operar Conjuntos", "Comparar Conjuntos");
        int opcao;
        do {
            System.out.println("== Sistema para manipular conjuntos ==");
            System.out.println("");
            menuPrincipal.mostrarMenu();
            opcao = lerInteiro(entrada,menuPrincipal.tamanho());
            switch (opcao) {
                case 1:
                    criarConjunto();
                    break;
                
                case 2:
                    listarConjuntos();
                    break;
                
                case 3:
                    manipularConjuntos();
                    break;
                
                case 4:
                    operarConjuntos();
                    break;
                
                case 5:
                    compararConjuntos();
                    break;
                
                case 0:
                    System.out.println("Até a próxima");
                
                default:
                    break;
            }
            if (opcao > 0 && opcao <= 5)
                aperteParaContinuar();
        } while (opcao != 0);
    }
    
    public static void aperteParaContinuar() {
        System.out.print("Aperte enter para continuar");
        entrada.nextLine();
        System.out.println("==============================");
    }
    
    public static int lerInteiro(Scanner in, int tamanho) { 
    //ler inteiro com ou sem restricao de maior e menor.
    //tamanho = 0 significa sem restricao
        try {
            int lido = Integer.parseInt(in.nextLine());
            if (tamanho != 0 && (lido > tamanho || lido < 0)) 
                throw new IllegalArgumentException( "Entrada Inválida" );
            return lido;
        } catch (NumberFormatException ex) {
            System.err.println("Entrada Inválida. Favor escolher um número.");
            return 999;
        } catch (IllegalArgumentException ex) {
            System.err.print(ex.getMessage() + 
                    ". Favor escolher entre 0 e " + tamanho);
            return 999;
        }
            
    }
    
    public static void criarConjunto() {
        System.out.println("Escolha um nome para seu novo conjunto");
        String nome = entrada.nextLine();
        ConjuntoInteiros conj = new ConjuntoInteiros(nome);
        conjuntos.add(conj);
        System.out.println("Conjunto Criado");
    }
    
    public static void listarConjuntos() {
        System.out.println("== Conjuntos Armazenados == ");
        int i =1;
        System.out.println("");
        for (ConjuntoInteiros conj : conjuntos) {
            System.out.print(i + " - ");
            conj.descrever();
            i++;
        }
        System.out.println("== total de conjuntos armazenados: " + --i + "==");
        System.out.println("");
    }
 
    public static void manipularConjuntos() {
        System.out.println("== Manipular Conjuntos == ");
        
        Menu menuManipular = new Menu ("Adicionar Elemento", "Excluir Elemento");
        int opcao;
        int conjuntoOperado;
        int elemento;
        
        System.out.println("Digite o conjunto que deseja manipular:");
        listarConjuntos();
        conjuntoOperado = lerInteiro(entrada,conjuntos.size());
        //se o conjunto nao existir ira retornar 999
        if (conjuntoOperado != 999) { 
            menuManipular.mostrarMenu();
            opcao = lerInteiro(entrada,menuManipular.tamanho());
            switch (opcao) {

                case 1:

                    System.out.println("Digite o elemento:");
                    elemento = lerInteiro(entrada,0);
                    try {
                        conjuntos.get(conjuntoOperado-1).adicionarInteiro(elemento);
                        System.out.println("Sucesso");
                    } catch (IllegalArgumentException ex) {
                        System.err.println(ex.getMessage());
                    }
                    conjuntos.get(conjuntoOperado-1).descrever();
                    break;

                case 2:

                    System.out.println("Digite o elemento:");
                    elemento = lerInteiro(entrada,0);
                    try {
                        conjuntos.get(conjuntoOperado-1).removerInteiro(elemento);
                        System.out.println("Sucesso");
                    } catch (IllegalArgumentException ex) {
                        System.err.println(ex.getMessage());
                    }
                    conjuntos.get(conjuntoOperado-1).descrever();
                    break;

                default:

                    break;
            }
        }
    }
 
    public static void operarConjuntos() {
        System.out.println("== Operar Conjuntos ==");
        int conjunto1, conjunto2, opcao;
        listarConjuntos();
        
        System.out.println("Selecione o primeiro conjunto");
        conjunto1 = lerInteiro (entrada,conjuntos.size());
        System.out.println("Selecione o segundo conjunto");
        conjunto2 = lerInteiro (entrada,conjuntos.size());
        
        if (conjunto1 != 999 && conjunto2 != 999 ) {
            Menu menuOperar = new Menu ("Uniao", "Intersecao", "Diferenca");
            menuOperar.mostrarMenu();
            opcao = lerInteiro (entrada, menuOperar.tamanho());
            System.out.println("Digite um nome para seu novo conjunto:");
            String nome = entrada.nextLine();
            switch (opcao) {
                case 1:
                    conjuntos.add(ConjuntoInteiros.uniao(nome, conjuntos.get(conjunto1-1), conjuntos.get(conjunto2-1)));
                    conjuntos.get(conjuntos.size()-1).descrever();
                    break;
                case 2:
                    conjuntos.add(ConjuntoInteiros.intersecao (nome, conjuntos.get(conjunto1-1), conjuntos.get(conjunto2-1)));
                    conjuntos.get(conjuntos.size()-1).descrever();
                    break;
                case 3:
                    conjuntos.add(ConjuntoInteiros.diferenca(nome, conjuntos.get(conjunto1-1), conjuntos.get(conjunto2-1)));
                    conjuntos.get(conjuntos.size()-1).descrever();
                    break;
                
                default:
                    break;
            }
        }
        
    }
    
    public static void compararConjuntos() {
        System.out.println("== Comparar Conjuntos ==");
        int conjunto1, conjunto2;
        listarConjuntos();
        
        System.out.println("Selecione o primeiro conjunto");
        conjunto1 = lerInteiro (entrada,conjuntos.size());
        System.out.println("Selecione o segundo conjunto");
        conjunto2 = lerInteiro (entrada,conjuntos.size());
        
        if (conjunto1 != 999 && conjunto2 != 999 ) {
            if (ConjuntoInteiros.saoIguais(conjuntos.get(conjunto1-1), conjuntos.get(conjunto2-1)))
                System.out.println("Os Conjuntos" + conjuntos.get(conjunto1-1).getNome()  + " e " + conjuntos.get(conjunto2-1).getNome() +  "são iguais");
            else if (ConjuntoInteiros.ehSubconjunto(conjuntos.get(conjunto1-1), conjuntos.get(conjunto2-1)))
                System.out.println("O Conjunto " + conjuntos.get(conjunto1-1).getNome() + " é " + "subconjunto de " + conjuntos.get(conjunto2-1).getNome());
            else if (ConjuntoInteiros.ehSubconjunto(conjuntos.get(conjunto2-1), conjuntos.get(conjunto1-1)))
                System.out.println("O Conjunto " + conjuntos.get(conjunto2-1).getNome() + " é " + "subconjunto de " + conjuntos.get(conjunto1-1).getNome());
            else
                System.out.println("Os conjuntos são diferentes");
        }
    }
}


