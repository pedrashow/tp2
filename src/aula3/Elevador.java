package aula3;

import java.util.ArrayList;

public class Elevador {

    public int qtdAndares;
    public int andarAtual;
    public ArrayList<Integer> proximosDestinos = new ArrayList<>();
    public int capacidadeMax; // em quantidade de pessoas
    public int qtdPassageiros;
    public boolean parado;

    public void mover() {
        parado = false;
        andarAtual = proximosDestinos.get(0);
        parado = true;
        proximosDestinos.remove(0);
    }

    public void desembarcar(int pessoas) {
        if (parado) {
            qtdPassageiros -= pessoas;
            if (qtdPassageiros < 0)
                qtdPassageiros = 0;
        }
    }

    public void embarcar (int pessoas) {
        if (parado) {
            qtdPassageiros += pessoas;
            if (qtdPassageiros > capacidadeMax)
                qtdPassageiros = capacidadeMax;
        }
    }

    public void adicionarDestino (int andar) {
    /**
     * No futuro será necessário implementar um algoritmo para organizar os proximos destinos de maneira eficiente
     * A ideia é enquanto houver um passageiro que deseja ir na direcao atual, o elevador deve manter esta direção.
     * Quando exaurir os andares neste direção, o elevador deve mudar de direção se houver alguma requisição nesta
     * nova direção ou ficar parado esperando o próximo chamado.
     */
    
        proximosDestinos.add(andar);
    }
    
    public void pressionarDestino (int andar) { // quando botao interno é pressionado
        adicionarDestino(andar);
    }

    public void chamarElevador (int andar) { // quando botao externo é pressionado
        adicionarDestino(andar);
    }

    public void imprimeStatus () {
        System.out.print("Andar: " + andarAtual);
        System.out.print(" proximos: " + proximosDestinos);
        System.out.println(" passageiros: " + qtdPassageiros);

    }

    Elevador (int andares, int maxPassageiros) {
        qtdAndares = andares;
        capacidadeMax = maxPassageiros;
        andarAtual = 0;
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