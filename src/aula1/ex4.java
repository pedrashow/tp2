package aula1;

public class ex4 {
	
	//Gerar a forma binaria (string de 0's e 1's) de um numero inteiro
	
	public static String retornaBinario (int x) {
		if (x == 0)
			return "";
		else
			return retornaBinario (x/2) + String.valueOf(x % 2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(retornaBinario(1023));
	}

}
