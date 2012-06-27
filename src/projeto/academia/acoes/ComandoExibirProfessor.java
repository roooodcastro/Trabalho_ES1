/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.academia.acoes;

import projeto.academia.modelos.Professor;
import projeto.academia.ui.TelaExibirProfessor;
import projeto.academia.ui.TelaPrincipal;

/**
 *
 * @author Rodrigo
 */
public class ComandoExibirProfessor extends Comando {

    private Professor professor;
    
    public ComandoExibirProfessor(Professor professor) {
        this.professor = professor;
    }
    
    @Override
    public void executarComando() {
        new TelaExibirProfessor(TelaPrincipal.getInstance(), true, professor).setVisible(true);
    }
    
}
