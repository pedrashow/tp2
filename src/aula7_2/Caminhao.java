package aula7_2;

public class Caminhao extends Veiculo {
	private int cargaMaxima; //em Kg
	private int qtdEixos;
	public Caminhao(String cor, String proprietario, int ano, int cargaMaxima, int qtdEixos) {
		super(cor, proprietario, ano);
		this.cargaMaxima = cargaMaxima;
		this.qtdEixos = qtdEixos;
	}
	
	
}
