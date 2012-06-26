/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes;

import projeto.academia.modelos.Professor;
import projeto.academia.ui.TelaEditarCliente;
import projeto.academia.ui.TelaEditarProfessor;
import projeto.academia.ui.TelaPrincipal;

/**
 *
 * @author Rodrigo
 */
public class ComandoEditarProfessor extends Comando {

    private Professor professor;

    public ComandoEditarProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public void executarComando() {
        new TelaEditarProfessor(TelaPrincipal.getInstance(), true, professor).setVisible(true);
    }
}
