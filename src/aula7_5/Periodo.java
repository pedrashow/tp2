package aula7_5;

public class Periodo {
	  private int ano;
	  private int semestre;
	  
	  public Periodo (int ano, int semestre) {
	    this.ano = ano;
	    this.semestre = semestre;
	  }
	  
	  public String getPeriodo() {
	    return String.valueOf(ano) + String.valueOf(semestre);
	  }
	  
}
