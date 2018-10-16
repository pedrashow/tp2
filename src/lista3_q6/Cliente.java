/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista3_q6;

import java.util.ArrayList;

/**
 *
 * @author beto
 */

public class Cliente {
    
    private final String nome;
    private boolean aptoDesconto;
    private final int DESCONTO_FIDELIDADE = 30;
    private ArrayList<HistoricoHospedagem> historico = new ArrayList<>();
    
    public String getNome() {
        return this.nome;
    }
    
    public void daDescontoFidelidade () {
        this.aptoDesconto = true;
    }
    
    public boolean temDescontoFidelidade () {
        return this.aptoDesconto;
    }
    
    public int valorDescontoFidelidade() {
        return this.DESCONTO_FIDELIDADE;
    }
    
    Cliente (String nome) {
        this.nome = nome;
        this.aptoDesconto = false;
    }
    
    public void adicionaHistorico(int diarias, Cama cama) {
        HistoricoHospedagem h = new HistoricoHospedagem(diarias,cama);
        this.historico.add(h);
    }
    
    public void imprimeHistorico() {
        for (HistoricoHospedagem hist : historico) {
            System.out.println(hist.descricao());
        }
    }
}
