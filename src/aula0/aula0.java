package aula0;

import java.util.ArrayList;
import java.lang.Math;

public class aula0 {

	public static void main(String[] args) {
		
		System.out.println(ehPrimo(180421597));
		System.out.println(formaTriangulo(348,567,937));
		System.out.println(formaTriangulo(3,4,5));
		System.out.println(ehPalindromo("ATTACGGAGGTCCATACTTGGTTCATCCTGGAGGCATTA"));
		System.out.println(ehPalindromo("socorrammesubinoonibusemmarrocos"));
		ArrayList<Integer> lista = new ArrayList<>();
		lista.add(169);
		lista.add(4);
		lista.add(100);
		lista.add(64);
		lista.add(9);
		lista.add(16);
		lista.add(225);
		lista.add(121);
		lista.add(81);
		lista.add(196);
		lista.add(25);
		lista.add(36);
		lista.add(144);
		lista.add(49);
		System.out.println(contaPares(lista));
		//System.out.println(Arrays.toString(calcMediaDesvio(lista)));
		System.out.println(ordenaLista(lista));
		

	}
	
	public static boolean ehPrimo(int x) {
		int divisor = 2;
		while (divisor < (x+1)/2) {
			if (x%divisor==0)
				return false;
			divisor++;			
		}
		return true;
	}
	
	public static boolean formaTriangulo(int lado1, int lado2, int lado3) {
		if ((lado1 < lado2 + lado3) && (lado1 > Math.abs(lado2 - lado3)) &&
			(lado2 < lado1 + lado3) && (lado2 > Math.abs(lado1 - lado3)) &&
			(lado3 < lado1 + lado2) && (lado3 > Math.abs(lado1 - lado2)))
			return true;
		return false;
	}

	public static int contaPares(ArrayList<Integer> x) {
		int qtd = 0;
		for (int numero : x) {
			if (numero % 2==0)
				qtd++;
		}
		return qtd;
	}
	
	public static double[] calcMediaDesvio (ArrayList<Integer> x) {
		double resultEstat[] = new double[2]; // [0] � a m�dia e [1] o desvio padr�o
		double soma = 0.0; 
		double desvio = 0.0;
		for (int numero : x) {
			soma += numero;
		}
		resultEstat[0] = soma / x.size(); //media
		for (int numero : x) {
			desvio += Math.pow(numero-resultEstat[0], 2);
		}
		resultEstat[1] = Math.sqrt(Math.abs(desvio / (x.size()))); //desvio padrao
		return resultEstat;
	}
	
	public static boolean ehPalindromo (String a) {
		int meio = (a.length()/2) - 1;
		int j = a.length();
		for (int i=0; i<=meio; i++) {
			j--;
			if (a.charAt(i)!=a.charAt(j))
				return false;
		}
		return true;
	}
	
	public static ArrayList<Integer> ordenaLista (ArrayList<Integer> x) {
		int auxiliar = 0;
		for (int i =0; i < x.size(); i++)
			for (int j = 0; j < x.size(); j++ )
				if (x.get(i) < x.get(j)) {
					auxiliar = x.get(i);
					x.set(i, x.get(j));
					x.set(j, auxiliar);
				}
		return x;
	}

}
