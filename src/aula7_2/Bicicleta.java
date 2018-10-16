package aula7_2;

public class Bicicleta extends Veiculo {
	  private int qtdMarchas;
	  private boolean temCesta;
	
	  public Bicicleta(String cor, String proprietario, int ano, int qtdMarchas, boolean temCesta) {
		super(cor, proprietario, ano);
		this.qtdMarchas = qtdMarchas;
		this.temCesta = temCesta;
	}
	  
	  
	  
}
