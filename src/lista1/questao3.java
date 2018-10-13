package lista1;

public class questao3 {

    public static int coefBinomial (int n, int k) {
        if (k > n || k < 0) //coordenadas fora do triangulo não influenciam o calculo
            return 0;
        else if (k == 0) // a primeira coluna é sempre 1
            return 1;
        else return coefBinomial (n-1, k-1) + coefBinomial(n-1, k);
    }

    public static int[] linhaPascal (int n) {
        int [] elementosLinha = new int[n+1];
        for (int coluna = 0; coluna <= n; coluna++) {
            elementosLinha[coluna] = coefBinomial (n-1,coluna-1) + coefBinomial(n-1,coluna);
        }
        return elementosLinha;
    }

    public static int somaElementos (int[] vetor) {
        int soma = 0;
        for (int elemento : vetor) {
            soma += elemento;
        }
        return soma;
    }

    public static int potenciaDeDois (int n) {
        if (n == 0)
            return 1;
        else
            return 2 * potenciaDeDois (n-1);
    }

    public static String imprimeLinha (int[] vetor) {
        String imprime = "";
        for (int i : vetor) {
            imprime += i;
            imprime += " ";
        }
        return imprime;
    }

    public static void main(String[] args) {
        //imprimir as linhas 5, 10, 15 e 20 do triangulo de pascal, a soma de seus elementos e uma String se a soma é uma potencia de 2
        String saida = new String();
        for (int i = 5; i <= 20; i += 5) {
            saida = "Linha " + i + ": ";
            int elementosLinha[] = linhaPascal(i);
            saida += imprimeLinha(elementosLinha);
            int soma = somaElementos(elementosLinha);
            saida += "soma:" + soma + " ";
            if (soma == potenciaDeDois(i) )
                saida += "Sim";
            else
                saida += "Não";
            System.out.println(saida);
        } 
    } 
}