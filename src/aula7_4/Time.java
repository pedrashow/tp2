package aula7_4;

import java.util.ArrayList;

public class Time {
	private final String nome;
	private final int anoFundacao;
	private final String corPrincipal;
	private final String corSecundaria;
	private final String corTerciaria;
	private final String cidade;
	private final String estadio;
        
        private int pontosGanhos;
        
	public Time(String nome, int anoFundacao, String corPrincipal, String corSecundaria, String corTerciaria,
			String cidade, String estadio) {
		super();
		this.nome = nome;
		this.anoFundacao = anoFundacao;
		this.corPrincipal = corPrincipal;
		this.corSecundaria = corSecundaria;
		this.corTerciaria = corTerciaria;
		this.cidade = cidade;
		this.estadio = estadio;
	}
        
        public String getTime () {
            return this.nome;
        }
        
        public int getPontosGanhos() {
            return this.pontosGanhos;
        }
        
        public String getLocal() {
            return this.cidade + " - " + this.estadio;
        }
        
        public void addPontosGanhos (int pts) {
            this.pontosGanhos += pts;
        }
        
        public ArrayList<Atleta> getJogadores(ArrayList<Atleta> atletas) {
            ArrayList<Atleta> jogadores = new ArrayList<>();
            for (Atleta atleta : atletas) {
                if (atleta.getTime() == this) {
                    jogadores.add(atleta);
                }
            }
            return jogadores;
        }
        
        public void imprimePontos() {
            System.out.println(this.nome + ": " + this.pontosGanhos);
        }
	
	
}
