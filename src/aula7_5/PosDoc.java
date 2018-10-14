/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula7_5;

import java.util.ArrayList;

/**
 *
 * @author Beto
 */
public class PosDoc extends Pessoa implements Academico {
    
    private ArrayList<String> topicosDePesquisa = new ArrayList<>();
    
    PosDoc (String primeiroNome, String ultimoNome, int dia, int mes, int ano, String[] topicos) {
        super (primeiroNome, ultimoNome, dia, mes, ano);
        for (String topico : topicos) {
            topicosDePesquisa.add(topico);
        }
    }
    
    public boolean podeSerMonitor (Disciplina d) {
        return true;
    }
    
}
