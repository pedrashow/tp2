package aula7_5;

import java.util.ArrayList;

public class Aluno extends Pessoa {
	private String matricula; //periodo + 6 digitos
	private Periodo periodoIngresso;
	private String curso;
	private Professor orientador;
	
	public Aluno(String primeiroNome, String ultimoNome, Data dtNascimento, String matricula, Periodo periodoIngresso,
			String curso) {
		super(primeiroNome, ultimoNome, dtNascimento);
		this.matricula = matricula;
		this.periodoIngresso = periodoIngresso;
		this.curso = curso;
	}

	public Aluno(String primeiroNome, String ultimoNome, int dia, int mes, int ano, String matricula,
			Periodo periodoIngresso, String curso) {
		super(primeiroNome, ultimoNome, dia, mes, ano);
		this.matricula = periodoIngresso.getPeriodo() +  matricula;
		this.periodoIngresso = periodoIngresso;
		this.curso = curso;
	}
        
        public Aluno(String primeiroNome, String ultimoNome, int dia, int mes, int ano, String matricula,
			int anoIngresso, int perIngresso, String curso) {
		super(primeiroNome, ultimoNome, dia, mes, ano);
		this.periodoIngresso = new Periodo(anoIngresso,perIngresso);
                this.matricula = this.periodoIngresso.getPeriodo() +  matricula;
		this.curso = curso;
        }

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Professor getOrientador() {
		return orientador;
	}

	public void setOrientador(Professor orientador) {
		this.orientador = orientador;
	}

	public String getMatricula() {
		return matricula;
	}

	public Periodo getPeriodoIngresso() {
		return periodoIngresso;
	}
        
        public boolean podeSerMonitor (Disciplina d) {
            if (this.orientador == d.getResponsavel())
                return true;
            return false;
        }
	
	
	
}
