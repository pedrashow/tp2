/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista3_q6;

/**
 *
 * @author beto
 */


public class HistoricoHospedagem {
    private final int diasHospedados;
    private final Cama cama;

    HistoricoHospedagem(int diasHospedados, Cama cama) {
        this.cama = cama;
        this.diasHospedados = diasHospedados;
    }
    
    public String descricao() {
        return "Dias: " + this.diasHospedados + "\t" + "Cama: " + this.cama.getId() + "\t" + "Quarto: " + this.cama.getQuarto().descricao();
    }
}
