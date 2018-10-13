package aula7_5;

import java.util.ArrayList;

public class Turma {
	
	private Periodo periodo;
	private ArrayList<Aluno> alunos = new ArrayList<>();
	private Professor professor;
	private Pessoa monitor;
	
	public Turma(Periodo periodo, ArrayList<Aluno> alunos, Professor professor, Pessoa monitor) {
		super();
		this.periodo = periodo;
		this.alunos = alunos;
		this.professor = professor;
		this.monitor = monitor;
	}
	
	

}
