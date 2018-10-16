package aula7_2;

public class Carro extends Veiculo {
	  private String tamanho;
	  private int qtdPassageiros;
	  private int qtdPortas;
	  private int velMax;
	
	  public Carro(String cor, String proprietario, int ano, String tamanho, int qtdPassageiros, int qtdPortas,
			int velMax) {
		super(cor, proprietario, ano);
		this.tamanho = tamanho;
		this.qtdPassageiros = qtdPassageiros;
		this.qtdPortas = qtdPortas;
		this.velMax = velMax;
	}

}
	
	
