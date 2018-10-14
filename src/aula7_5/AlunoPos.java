/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula7_5;

/**
 *
 * @author Beto
 */
public class AlunoPos extends Aluno implements Academico {
    private String tituloDeTese;
    
    AlunoPos (String primeiroNome, String ultimoNome, int dia, int mes, int ano, String matricula,
			int anoIngresso, int perIngresso, String curso, Professor orientador, String tituloDeTese) {
        super(primeiroNome, ultimoNome, dia, mes, ano, matricula, anoIngresso, perIngresso, curso);
        super.setOrientador(orientador);
        this.tituloDeTese = tituloDeTese;
    }
    
    public boolean podeSerMonitor (Disciplina d) {
        if (super.getOrientador() == d.getResponsavel())
            return true;
        return false;
    }    
    
}
