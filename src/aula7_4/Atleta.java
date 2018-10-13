package aula7_4;

public class Atleta {
	private final String nome;
	private final String apelido;
        private String posicao;
        private Time time;
	public Atleta(String nome, String apelido, String posicao) {
		this.nome = nome;
		this.apelido = apelido;
                this.posicao = posicao;
	}
        
        public Time getTime(){
            return this.time;
        }
	
        public String getApelido() {
            return this.apelido;
        }
        
        public void setTime (Time time) {
            this.time = time;
        }
}
