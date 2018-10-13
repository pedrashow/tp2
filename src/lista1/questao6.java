package lista1;

public class questao6 {
  
  /**
  * A soma das partições do numero "n" sempre é igual a "n", que deve ser nosso numero alvo em cada linha.
  * Se a maior particao é igual a "n" só há uma forma de escrever, que é "n".
  * O mesmo é válido se a maior particao é igual a "n - 1", que é a forma "n-1 1".
  * Entretanto, quando a maior partição da linha é um número menor, há mais de uma combinação
  * de outras partições que somam "n". Por exemplo, quando precisamos escrever 4 tendo 2
  * como maior parte, podemos tanto escrever "2 2" como "2 1 1".
  * Desta forma, é possível usar uma recursão que, ao começar uma linha com a maior partição "x", todas as
  * linhas derivadas (que tb começam com "x") terao como complemento a propria funcao, usando como argumentos a diferença "n-x" e como maior
  * particao todos os numeros entre "x" e 1.
  * Quando a maior particao for maior que o numero alvo, precisamos recomeçar, igualando o alvo e a maior partição
  * Ex. Imaginando que estou escrevendo o numero 7 com maior particao 4, as linhas escritas deverão começar com 4
  * e usar todas as particoes da diferenca (7-4 = 3) com maior particao 4 (vazio - recomeçar com 3, 3)
  * 3 (resp: 4 3), 2(resp: 4 2 1) e 1( resp: 4 1 1 1)
  */
  
  public static void enumParticoes (int n) {
    imprimeParticao(n,n,"");
  }
  
  public static void imprimeParticao(int n, int x, String linha) { //n é o número alvo, x é a maior partição da linha
    if (n == 0) // quando o proximo alvo for 0, imprime a linha agregada.
      System.out.println(linha);
	else if (x<=n) // se a particao for menor que o alvo, faço a diferença e repito até a maior particao ser 1
      for (int i = x; i>= 1; i--)
        imprimeParticao (n-i, i, linha + " " + i);
    else // se a maior particao for maior que o alvo, igualo a maior particao ao alvo e recomeço
      imprimeParticao(n, n, linha);
     
  }
  
  public static void main(String[] args) {
    enumParticoes(12);
    
  }
}
