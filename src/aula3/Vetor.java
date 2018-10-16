package aula3;

import java.util.ArrayList;

public class Vetor {
	
	public ArrayList<Double> valores = new ArrayList<>();
	
	public double calculaNormaManhattan () {
		double normaManhattan = 0;
		for (double valor : valores) {
			normaManhattan += Math.abs(valor);
		}
		return normaManhattan;
	}
	
	public double calculaNormaEuclidiana () {
		double normaEuclidianaE2 = 0; //normaEuclidiana ao quadrado
		for (double valor : valores) {
			normaEuclidianaE2 += valor * valor;
		}
		return Math.sqrt(normaEuclidianaE2);
	}
	
	public double calculaNormaChebysev () {
		double normaChebysev = valores.get(0);
		for (double valor : valores) {
			if (Math.abs(valor) > normaChebysev)
				normaChebysev = Math.abs(valor);
		}
		return normaChebysev;
	}

	Vetor (double... numeros) {
		for (double num : numeros)
			valores.add(num);
	}

	public static void main(String[] args) {
		Vetor teste = new Vetor(10, 20, 30, 40, 60, 90);
		System.out.println(teste.calculaNormaManhattan());
		System.out.println(teste.calculaNormaChebysev());
		System.out.println(teste.calculaNormaEuclidiana());
	}

}
