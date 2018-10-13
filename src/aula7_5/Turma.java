package aula7_5;

import java.util.ArrayList;

public class Turma {
	
	private Periodo periodo;
	private ArrayList<Aluno> alunos = new ArrayList<>();
	private Professor professor;
	private Pessoa monitor;
        private Disciplina disciplina;
	
	public Turma(Periodo periodo, ArrayList<Aluno> alunos, Professor professor, Disciplina disciplina) {
		super();
		this.periodo = periodo;
		this.alunos = alunos;
		this.professor = professor;
		this.disciplina = disciplina;
	}
        
        public void associarMonitor (Pessoa p) {
            if (p.podeSerMonitor(this.disciplina))
                this.monitor = p;
            else
                throw new IllegalArgumentException("Não é permitido que esta pessoa seja monitora");
            
        }
	
	

}
