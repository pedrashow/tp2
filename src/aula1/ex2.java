package aula1;

public class ex2 {
	
	//Calcular o maximo divisor comum entre dois inteiros positivos
	
	public static int calculaMdc (int a, int b) {
		if (a<b)
			return calculaMdc(b,a);
		else if (a % b == 0)
			return b;
		else
			return calculaMdc(b, a % b);
	}

	
	public static void main(String[] args) {
		System.out.println(calculaMdc(25,15));
	}

}
