package aula0;

import java.util.ArrayList;
import java.lang.Math;

public class aula0_entrega {

	public static void main(String[] args) {
		
		//ler as medidas de cada lado do triâgulo
		int l1 = 5;
		int l2 = 12;
		int l3 = 13;
		if (formaTriangulo(l1,l2,l3))
			System.out.printf("As medidas %d, %d e %d formam triângulo%n",l1,l2,l3);
		else
			System.out.printf("As medidas %d, %d e %d não formam triângulo%n",l1,l2,l3);
		
		// criar a lista de números	
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
		System.out.printf("Há %d números pares na lista%n",contaPares(lista));
		
		//ler a palavra para saber se é um palíndromo
		String texto = new String("abcba");
		if (ehPalindromo(texto))
			System.out.printf("O texto %s é um palíndromo%n", texto);
		else
			System.out.printf("O texto %s não é um palíndromo%n", texto);
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

}
