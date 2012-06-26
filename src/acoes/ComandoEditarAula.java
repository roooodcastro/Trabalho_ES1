/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes;

import projeto.academia.modelos.Aula;
import projeto.academia.ui.TelaEditarAula;
import projeto.academia.ui.TelaPrincipal;

/**
 *
 * @author Rodrigo
 */
public class ComandoEditarAula extends Comando {

    private Aula aula;

    public ComandoEditarAula(Aula aula) {
        this.aula = aula;
    }

    @Override
    public void executarComando() {
        new TelaEditarAula(TelaPrincipal.getInstance(), true, aula).setVisible(true);
    }
}
