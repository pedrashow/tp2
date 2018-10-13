package aula7_5;

public class Disciplina {
	private String nome;
	private String codigo;
	private String ementa;
	private int cargaHoraria; //por semana
	private Professor responsavel;
	
	public Disciplina(String nome, String codigo, String ementa, int cargaHoraria, Professor responsavel) {
		this.nome = nome;
		this.codigo = codigo;
		this.ementa = ementa;
		this.cargaHoraria = cargaHoraria;
		this.responsavel = responsavel;
	}
        
        public String imprimeDisciplina() {
            return this.nome + " - " + this.responsavel.getNome();
        }
	
	

}
