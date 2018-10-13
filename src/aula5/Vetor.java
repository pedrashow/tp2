package aula5;

import java.util.ArrayList;

public class Vetor {
	
	private ArrayList<Double> valores = new ArrayList<>();
  
  	private int dimensoes;
	
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
  
  	private int contarDimensoes () {
      int numDimensoes = 0;
      for (double valores : this.valores) {
        numDimensoes++;
      }
      return numDimensoes;
    }
  
  	public static int calculaProdutoInterno (Vetor v1, Vetor v2) {
      int produtoInternoE2 = 0; //produto interno elevado a 2
      if (v2.dimensoes != v1.dimensoes)
          return 0;
      for (int i = 0; i < v1.dimensoes; i++)
        produtoInternoE2 += v1.valores.get(i) * v2.valores.get(i);
      return (int) Math.sqrt(produtoInternoE2);
    }
  
  	public static Vetor calculaProdutoVetorial3D (Vetor v1, Vetor v2) {
      if (v1.dimensoes != 3 || v2.dimensoes != 3) {
      	Vetor resposta = new Vetor (0,0,0);
        return resposta;
      }
      else { //gerar as coordenadas x, y, z do novo vetor
        double x = v1.valores.get(1) * v2.valores.get(2) - v1.valores.get(2) * v2.valores.get(1);
        double y = v1.valores.get(2) * v2.valores.get(0) - v1.valores.get(0) * v2.valores.get(2);
        double z = v1.valores.get(0) * v2.valores.get(1) - v1.valores.get(1) * v2.valores.get(0);
        Vetor resposta = new Vetor (x,y,z);
        return resposta;
      }
      
    }
  
  	public void imprimeVetor () {
      System.out.print("( ");
      for (double valor : this.valores)
        System.out.print(valor + " ");
      System.out.println(")");
      
    }

	Vetor (double... numeros) {
		for (double num : numeros)
			this.valores.add(num);
      	this.dimensoes = contarDimensoes();
	}

	public static void main(String[] args) {
		Vetor teste = new Vetor(10, 20, 30, 40, 60, 90);
		System.out.println(teste.calculaNormaManhattan());
		System.out.println(teste.calculaNormaChebysev());
		System.out.println(teste.calculaNormaEuclidiana());
      	Vetor v = new Vetor (1,2,3);
      	Vetor w = new Vetor (4,5,6);
      	System.out.println(calculaProdutoInterno(v,w));
      	Vetor v3 = calculaProdutoVetorial3D(v,w);
      	v3.imprimeVetor();
      	
	}

}