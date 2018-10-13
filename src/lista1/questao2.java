package lista1;

import java.util.ArrayList;

public class questao2 {

    public static float calculaMOS (ArrayList<Integer> avaliacoes) {
        int soma = 0;
        if (avaliacoes.size() == 0)
            return 0.0f;
        for (int opiniao : avaliacoes)
            soma += opiniao;
        float MOS = (float) soma / avaliacoes.size();
        return MOS;
    }

    public static float calculaGTS (ArrayList<Integer> avaliacoes) {
        int qtdPositivas = 0;
        if (avaliacoes.size() == 0)
            return 0.0f;
        for (int opiniao : avaliacoes)
            if (opiniao > 3)
                qtdPositivas += 1;
        float GTS = (float) qtdPositivas / avaliacoes.size();
        return GTS;
    }

    public static ArrayList<Integer> geraOpinioes (int tamanho) {
        ArrayList<Integer> avaliacoes = new ArrayList<>();
        for (int i = 0; i < tamanho ; i++)
            avaliacoes.add(i, geraUmaOpiniao(avaliacoes));
        return avaliacoes;
    }

    public static int geraUmaOpiniao (ArrayList<Integer> avaliacoes) {
        // Para gerar a próxima opinião de modo a se encaixar nos nossos objetivos é necessário analisar os índices a cada inserção
        // e inserir a melhor opinião para influenciar os índices na direção que queremos. 
        float MOS = calculaMOS(avaliacoes);
        float GTS = calculaGTS(avaliacoes);
        if (( MOS <= 3.0f && GTS >= 0.5f ) || (avaliacoes.size() < 1))
            return ((int) (Math.random() * 5)) + 1; // random gera um número entre 0.1 e 0.9
        else if ( MOS >= 3.0f && GTS >= 0.5f)
            return 1;
        else
            return 4;
    }
    
    public static void main(String[] args) {
        int TAMANHO = 2000;
        ArrayList<Integer> arrayOpinioes = new ArrayList<>(geraOpinioes(TAMANHO));
        boolean mosBaixo = (calculaMOS(arrayOpinioes) <= 3.0f);
        boolean gtsAlto = (calculaGTS(arrayOpinioes) >= 0.5f);
        //System.out.println(calculaMOS(arrayOpinioes) + " " + calculaGTS(arrayOpinioes) );
        System.out.println(mosBaixo && gtsAlto);
    }
} 