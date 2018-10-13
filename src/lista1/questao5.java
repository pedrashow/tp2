package lista1;

public class questao5 {

    public static String codigoGray (int n) { 
        int numBits = calcNumBits(n); 
        int proximaPotencia = (int) ( Math.pow( 2,numBits ) ) - 1; // calcula o maior número representado por aquela quantidade de bits
        int proximoGray = proximaPotencia - n; // chega ao gray equivalente com menos bits
        if (numBits - calcNumBits(proximoGray) > 1) // Se o número de bits que falta completar exceder o numero de bits do proximo gray por dois ou mais
            return String.valueOf(1) + auxCodGray (proximoGray, numBits-1); // é necessário preencher o "miolo" com 0 e até que seja possível completá-lo
        if (n == 0) return String.valueOf(0);
        if (n == 1) return String.valueOf(1);
        return String.valueOf(1) + codigoGray (proximoGray);
    }

    public static String auxCodGray (int n, int bits) { //preenche com 0 até que o número de bits restantes seja igual ao número de bits do número
        int numBits = calcNumBits(n);
        if (numBits == bits) return codigoGray(n);    
        return String.valueOf(0) + auxCodGray (n, bits - 1);
    }

    public static int calcNumBits (int n) { //calcula quantos bits são necessários para expressar o inteiro em Codigo de Gray
        if (n==0) return 1;
        return 1 + (int) (Math.log(n) / Math.log(2));
    }

    public static void main(String[] args) {
        for (int i = 0; i < 32; i++) {
            System.out.println(i + " " + codigoGray(i));
        }
    }
}