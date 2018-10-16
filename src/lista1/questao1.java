package lista1;

public class questao1 {

    public static double potenciaRecursiva (int n, int k) { //retornar double caso o expoente seja um inteiro negativo
        if (k<0)
            return 1/potenciaRecursiva(n, -k);
        else if (k==0)
            return 1;
        else 
            return n*potenciaRecursiva(n, k-1);
    }

    public static double potenciaIterativa (int n, int k) {
        int resultado = 1;
        if (k == 0)
            return 1;
        boolean negativo = false;
        if (k<0) {
            negativo = true;
            k = -k;
        }
        for (int i=1; i <= k; i++ )
            resultado *= n;
        if (negativo)
            return 1.0/resultado;
        else
            return resultado;
    }

    public static int somaDeQuadradosRecursiva (int n) {
        if (n == 1)
            return 1;
        else
            return  (int) potenciaRecursiva(n,2) + somaDeQuadradosRecursiva (n-1);
    }

    public static int somaDeQuadradosIterativa (int n) {
        int soma = 0;
        int INICIAL = 1;
        for (int i = INICIAL; i <= n; i++)
            soma += potenciaIterativa(i,2);
        return soma;
    }

    public static int calculaPellRecursiva (int n) {
        if (n == 1)
            return 0;
        else if (n == 2)
            return 1;
        else
            return 2 * calculaPellRecursiva(n-1) + calculaPellRecursiva(n-2);
    }

    public static int calculaPellIterativa (int n) {
        int n1 = 0;
        int n2 = 1;
        int auxiliar = 0;
        for (int i = 3; i <= n; i++) {
            auxiliar = n2;
            n2 = 2* n2 + n1;
            n1 = auxiliar;
        }
        return n2;

    }

    public static void main(String[] args) {
        int base =5;
        int expoente = 11;
        System.out.println(potenciaIterativa(base,expoente));
        System.out.println(potenciaRecursiva(base,expoente));
        System.out.println(somaDeQuadradosIterativa(100));
        System.out.println(somaDeQuadradosRecursiva(100));
        System.out.println(calculaPellRecursiva(15));
        System.out.println(calculaPellIterativa(15));
    }

}