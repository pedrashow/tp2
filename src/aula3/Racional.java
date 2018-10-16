package aula3;

public class Racional {
	
	public int numerador;
	public int denominador;
	
	public String imprimeFormaFracao () {
		return numerador + "/" + denominador;
	}
	
	public double imprimeFormaDecimal () {
		return (double) numerador/denominador;
	}
	
	public void incremento (int n) {
		numerador += n * denominador;
	}
	
	public void complemento () {
		numerador = denominador - (numerador % denominador);
	}
	
	public static void main(String[] args) {
		Racional numero = new Racional();
		numero.numerador = 10;
		numero.denominador = 25;
		System.out.println(numero.imprimeFormaFracao());
		System.out.println(numero.imprimeFormaDecimal());
		numero.incremento(2);
		System.out.println(numero.imprimeFormaFracao());
		System.out.println(numero.imprimeFormaDecimal());
		numero.complemento();
		System.out.println(numero.imprimeFormaFracao());
		System.out.println(numero.imprimeFormaDecimal());
		
	}

}
	