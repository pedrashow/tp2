package aula3;
 
public class Hora {
	
	public int horas;
	public int minutos;
	public int segundos;
	
	public void ajustarHora () { // formatar tempo para minutos e segundos entre 0 e 59 e para horas entre 0 e 23.
		if (segundos >= 60) {
			minutos += segundos / 60;
			segundos = segundos % 60;
		} else if (segundos < 0) {
			minutos -= 1 + (segundos * -1 / 60);
			segundos = 60 + (segundos % 60);
		}
		if (minutos >= 60) {
			horas += minutos / 60;
			minutos = minutos % 60;
		} else if (minutos < 0) {
			horas -= 1 + (minutos * -1 / 60);
			minutos = 60 + (minutos % 60);
		}
		if (horas >= 24 )
			horas = horas % 24;
		else if (horas < 0)
			horas = 24 + (horas % 24);
	}
	
	public void adicionarSegundos (int tempo) {
		segundos += tempo;
		ajustarHora();
	}
	
	public void removerSegundos (int tempo) {
		segundos -= tempo;
		ajustarHora();
	}

	public String ajustarDigitos (int x) {  // ajustar quantidade de dígitos para impressão
		String digitos = "";
		if (x > 9)
			digitos = String.valueOf(x);
		else 
			digitos = 0 + String.valueOf(x);
		return digitos;
	}
	
	public void imprimirHoraCurta () {
		String saida = "";
		saida += ajustarDigitos(horas);
		saida += ":";
		saida += ajustarDigitos(minutos);
		saida += ":";
		saida += ajustarDigitos(segundos);
		System.out.println(saida);
	}
	
	public void imprimirHoraLonga () {
		String saida = "";
		saida += String.valueOf(horas);
		saida += " horas, ";
		saida += String.valueOf(minutos);
		saida += " minutos e ";
		saida += String.valueOf(segundos);
		saida += " segundos.";
		System.out.println(saida);
	}
	
	Hora (int h, int m, int s) {
		horas = h;
		minutos = m;
		segundos = s;
		ajustarHora();
	}

	public static void main(String[] args) {
		Hora agora = new Hora(23,59,55);
		agora.imprimirHoraCurta();
		agora.imprimirHoraLonga();
		agora.adicionarSegundos(10);
		agora.imprimirHoraCurta();
		agora.imprimirHoraLonga();
		agora.removerSegundos(10);
		agora.imprimirHoraCurta();
		agora.imprimirHoraLonga();
		agora.adicionarSegundos(25*3600);
		agora.imprimirHoraCurta();
		agora.imprimirHoraLonga();
	}
	
}
