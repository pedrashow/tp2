/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula7_5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;


/**
 *
 * @author beto
 */

public class Principal {
    
    private static ArrayList<Aluno> alunos = new ArrayList<>();
    private static ArrayList<Professor> professores = new ArrayList<>();
    private static ArrayList<Disciplina> disciplinas = new ArrayList<>();
    
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        Menu menuPrincipal = new Menu ("Cadastrar aluno", "Cadastrar professor",
                "Cadastrar disciplina", "Listar alunos" , "Listar professores",
                "Listar aniversários", "Listar disciplinas");
        int opcao;
        do {
            System.out.println("============================");
            menuPrincipal.imprimirMenu();
            opcao = menuPrincipal.lerEscolha(in);
            switch (opcao) {
                case 0:
                    break;
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    cadastrarProfessor();
                    break;
                case 3:
                    cadastrarDisciplina();
                    break;
                case 4:
                    listarAlunos();
                    break;
                case 5:
                    listarProfessores();
                    break;
                case 6:
                    listarAniversarios();
                    break;
                case 7:
                    listarDisciplinas();
                    break;
            }
        } while (opcao != 0);        
    }
    
    public static void cadastrarAluno() {
        //String primeiroNome, String ultimoNome, int dia, int mes, int ano, String matricula,
	//int anoIngresso, int perIngresso, String curso
        try {
            Scanner entrada = new Scanner( new File( "src/aula7_5/alunos.txt" ) );
            String linha;
            String[] partes;
            Aluno x;
            entrada.nextLine(); // primeira linha contem cabeçalho
            while( entrada.hasNext()) {
                linha = entrada.nextLine();
                partes = linha.split(",");//campos separados por virgula
                x = new Aluno(partes[0],partes[1],Integer.parseInt(partes[2]),Integer.parseInt(partes[3]),Integer.parseInt(partes[4]),
                        partes[5],Integer.parseInt(partes[6]), Integer.parseInt(partes[7]), partes[8]);
                alunos.add(x);
            }
        }
        
        catch (FileNotFoundException ex) {
            System.out.println( "ERRO: Arquivo não encontrado." );
        }
    }

    public static void cadastrarProfessor() {
        //String primeiroNome, String ultimoNome, int dia, int mes, int ano, String matSiape,
	//String departamento
        try {
            Scanner entrada = new Scanner( new File( "src/aula7_5/professores.txt" ) );
            String linha;
            String[] partes;
            Professor x;
            entrada.nextLine(); // primeira linha contem cabeçalho
            while( entrada.hasNext()) {
                linha = entrada.nextLine();
                partes = linha.split(",");//campos separados por virgula
                x = new Professor(partes[0],partes[1],Integer.parseInt(partes[2]),Integer.parseInt(partes[3]),Integer.parseInt(partes[4]),
                        partes[5], partes[6]);
                professores.add(x);
            }
        }
        
        catch (FileNotFoundException ex) {
            System.out.println( "ERRO: Arquivo não encontrado." );
        }        
    }
    
    public static void cadastrarDisciplina() {
        //String nome, String codigo, String ementa, int cargaHoraria, Professor responsavel
        try {
            Scanner entrada = new Scanner( new File( "src/aula7_5/disciplina.txt" ) );
            String linha;
            String[] partes;
            Disciplina x;
            entrada.nextLine(); // primeira linha contem cabeçalho
            int i = 0; //para incluir o professor responsável
            
            while( entrada.hasNext()) {
                linha = entrada.nextLine();
                partes = linha.split(",");//campos separados por virgula
                x = new Disciplina(partes[0],partes[1],"",Integer.parseInt(partes[2]),professores.get(i));
                disciplinas.add(x);
                // por hipótese apenas os primeiros professores serão responsaveis
                if (i>20) i = 0;
                else i++;
            }
        }
        
        catch (FileNotFoundException ex) {
            System.out.println( "ERRO: Arquivo não encontrado." );
        }
        catch (IndexOutOfBoundsException ex) {
            System.err.println("É necessário cadastrar professores antes de disciplinas");
        }
    }

    public static void listarAlunos() {
        for (Aluno x : alunos) {
            System.out.println(x.getNome() + " - " + x.getLogin());
        }
    }

    public static void listarProfessores() {
        for (Professor x : professores) {
            System.out.println(x.getNome() + " - " + x.getMatSiape());
        }
    }

    public static void listarAniversarios() {
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        pessoas.addAll(alunos);
        pessoas.addAll(professores);
        ordenarPorAniversario(pessoas);
        for (int i = 0; i < pessoas.size(); i++)  {
            System.out.println(pessoas.get(i).getDtNascimento().imprimeDataAniversario() + " - " + pessoas.get(i).getNome() );
        }
    }
    
    public static void ordenarPorAniversario(ArrayList<Pessoa> x) {
        Pessoa aux;
        for (int i = 0; i < x.size()-1; i++) {
            for (int j = i+1; j < x.size(); j++) {
                if (Data.menorDataAniversario(x.get(j).getDtNascimento(),x.get(i).getDtNascimento())) {
                    aux = x.get(i);
                    x.set(i, x.get(j));
                    x.set(j, aux);
                }    
            }
        }
    }

    public static void listarDisciplinas() {
        for (Disciplina x : disciplinas) {
            System.out.println(x.imprimeDisciplina());
        }
    }
}
