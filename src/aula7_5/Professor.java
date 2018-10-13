package aula7_5;

import java.util.ArrayList;

public class Professor extends Pessoa {
	private String matSiape; //7 digitos
	private String Departamento;
        
        private ArrayList<Disciplina> responsavelPor = new ArrayList<>();
	
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
        
        public void tornarResponsavel(Disciplina d) {
            this.responsavelPor.add(d);
        }
        
        public void removerResponsavel (Disciplina d) {
            this.responsavelPor.remove(d);
        }
        
        public boolean podeSerMonitor(Disciplina d) {
            for (Disciplina disciplina : this.responsavelPor) {
                if (disciplina == d)
                    return false;
            }
            return true;
        }
	
	

}
