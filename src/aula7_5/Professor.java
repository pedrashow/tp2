package aula7_5;

public class Professor extends Pessoa {
	private String matSiape; //7 digitos
	private String Departamento;
	
	public Professor(String primeiroNome, String ultimoNome, Data dtNascimento, String matSiape, String departamento) {
		super(primeiroNome, ultimoNome, dtNascimento);
		this.matSiape = matSiape;
		Departamento = departamento;
	}

	public Professor(String primeiroNome, String ultimoNome, int dia, int mes, int ano, String matSiape,
			String departamento) {
		super(primeiroNome, ultimoNome, dia, mes, ano);
		this.matSiape = matSiape;
		Departamento = departamento;
	}

	public String getMatSiape() {
		return matSiape;
	}

	public String getDepartamento() {
		return Departamento;
	}
	
	

}
