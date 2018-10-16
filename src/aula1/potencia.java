package aula1;

public class potencia {
	
	public static void main(String[] args) {
		System.out.println(multiplicacao(5,2));
		System.out.println(calculaPotencia(5,4));
	}
	
	public static int multiplicacao (int fat1, int fat2) {
		if (fat1 == 0 || fat2 == 0)
			return 0;
		else if (fat2 == 1)
			return fat1;
		else
			return (fat1 + multiplicacao(fat1, fat2-1));
	}
	
	public static int calculaPotencia (int base, int expoente) {
		if (expoente == 0)
			return 1;
		else if (expoente == 1)
			return base;
		else
			return (multiplicacao(base, calculaPotencia(base,expoente-1)));
	}

}
