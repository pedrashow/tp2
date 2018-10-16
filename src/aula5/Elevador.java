package aula5;

import java.util.ArrayList;

public class Elevador {
  
  	private int qtdAndares;
    private int andarAtual;
    private ArrayList<Integer> proximosDestinos = new ArrayList<>();
    private int capacidadeMax; // em quantidade de pessoas
    private int qtdPassageiros;
    private Status estado;
  
  	// controlar o estado do elevador
  	private static enum Status { PARADO, SUBINDO, DESCENDO; }
  	
	public void setEstado (Status x) {
      this.estado = x;
    }

    public void mover() {
      	if (andarAtual < proximosDestinos.get(0))
          	setEstado(Status.SUBINDO);
      	else if (andarAtual > proximosDestinos.get(0))
          	setEstado (Status.DESCENDO);
        this.andarAtual = proximosDestinos.get(0);
        setEstado(Status.PARADO);
        this.proximosDestinos.remove(0);
    }

    public void desembarcar(int pessoas) {
        if (estado == Status.PARADO) {
            this.qtdPassageiros -= pessoas;
            if (qtdPassageiros < 0)
                this.qtdPassageiros = 0;
        }
    }

    public void embarcar (int pessoas) {
        if (estado == Status.PARADO) {
            this.qtdPassageiros += pessoas;
            if (qtdPassageiros > capacidadeMax)
                this.qtdPassageiros = capacidadeMax;
        }
    }

    public void adicionarDestino (int andar) {
    /**
     * TODO implementar um algoritmo para organizar os proximos destinos de maneira eficiente
     * A ideia é enquanto houver um passageiro que deseja ir na direcao atual, o elevador deve manter esta direção.
     * Quando exaurir os andares neste direção, o elevador deve mudar de direção caso haja alguma requisição nesta
     * nova direção ou ficar parado esperando o próximo chamado.
     */
    
        this.proximosDestinos.add(andar);
    }
    
    public void pressionarDestino (int andar) { // quando botao interno é pressionado
        this.adicionarDestino(andar);
    }

    public void chamarElevador (int andar) { // quando botao externo é pressionado
        this.adicionarDestino(andar);
    }

    public void imprimeStatus () {
        System.out.print("Andar: " + this.andarAtual);
        System.out.print(" proximos: " + this.proximosDestinos);
        System.out.println(" passageiros: " + this.qtdPassageiros);

    }

    //construtor
  	public Elevador (int qtdAndares, int capacidadeMax) {
        this.qtdAndares = qtdAndares;
        this.capacidadeMax = capacidadeMax;
        this.andarAtual = 0;
    }

    public static void main(String[] args) {
        Elevador teste = new Elevador (10, 10);
        teste.pressionarDestino(5);
        teste.imprimeStatus();
        teste.chamarElevador(8);
        teste.imprimeStatus();
        teste.mover();
        teste.imprimeStatus();
        teste.embarcar(6);
        teste.imprimeStatus();
        teste.mover();
        teste.desembarcar(4);
        teste.embarcar(6);
        teste.imprimeStatus();
        teste.pressionarDestino(0);
        teste.mover();
        teste.desembarcar(8);
        teste.imprimeStatus();
    }
  
}

