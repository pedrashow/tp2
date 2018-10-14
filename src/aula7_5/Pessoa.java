package aula7_5;

import java.util.ArrayList;

public class Pessoa {
	
	  private String primeiroNome;
	  private String ultimoNome;
	  private String login;
	  private Data dtNascimento;
	  
	  private Pessoa (String primeiroNome, String ultimoNome) {
		  this.primeiroNome = primeiroNome;
		  this.ultimoNome = ultimoNome;
		  this.login = primeiroNome + "." + ultimoNome + "@uniriotec.br";
	  }
	  
	  public Pessoa (String primeiroNome, String ultimoNome, int dia, int mes, int ano) {
		    this(primeiroNome, ultimoNome);
		    this.dtNascimento = new Data(dia,mes,ano);
	  }
	  
	  public Pessoa (String primeiroNome, String ultimoNome, Data dtNascimento) {
		this(primeiroNome, ultimoNome);
                this.dtNascimento = dtNascimento;
	  }
          
          public Pessoa() {
              
          }
	  
	  public String getNome() {
		  return primeiroNome + " " + ultimoNome;
	  }
	  
	  public String getLogin() {
		  return login;
	  }
	  
	  public Data getDtNascimento() {
		  return this.dtNascimento;
	  }
          
	  
	  
	  
}
