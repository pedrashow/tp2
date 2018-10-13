package aula7_4;

public class Partida {
        private final int rodada;
	private final Time timeCasa;
	private final Time timeFora;
	private int resultadoCasa;
	private int resultadoFora;
        private final String local;
	
        public Partida(int rodada, Time timeCasa, Time timeFora) {
		super();
                this.rodada = rodada;
		this.timeCasa = timeCasa;
		this.timeFora = timeFora;
                this.local = timeCasa.getLocal();
	}
        
        public void setResultado (int resultadoCasa, int resultadoFora) {
            this.resultadoCasa = resultadoCasa;
            this.resultadoFora = resultadoFora;
        }
        
        public void imprimePartida () {
            System.out.println(this.timeCasa + " " + this.resultadoCasa + " x " + this.resultadoFora + " " + this.timeFora);
            System.out.println(this.local);
        }
}
