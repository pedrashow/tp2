/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista3_q2;

import java.util.ArrayList;

/**
 *
 * @author beto
 */
public class Serie {
    
    public enum Genero {
        ACAO, ANIMACAO, AVENTURA, COMEDIA, CULT, DOCUMENTARIO, DRAMA,  MUSICAL,
        FANTASIA, FAROESTE, FICCAO, ROMANCE, SUSPENSE, TERROR
    } 
    
    
    private String titulo;
    private int anoLancamento;
    private Genero genero;
    private ArrayList<Ator> elenco;
    
    public int qtdTemporadas() {
        return 0;
    }
    
    
    
}
