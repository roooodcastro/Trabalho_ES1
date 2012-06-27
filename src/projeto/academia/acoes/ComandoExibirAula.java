/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.academia.acoes;

import projeto.academia.modelos.Aula;
import projeto.academia.ui.TelaExibirAula;
import projeto.academia.ui.TelaPrincipal;

/**
 *
 * @author Rodrigo
 */
public class ComandoExibirAula extends Comando {

    private Aula aula;
    
    public ComandoExibirAula(Aula aula) {
        this.aula = aula;
    }
    
    @Override
    public void executarComando() {
        new TelaExibirAula(TelaPrincipal.getInstance(), true, aula).setVisible(true);
    }
    
}
