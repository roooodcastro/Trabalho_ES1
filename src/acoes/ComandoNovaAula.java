/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes;

import projeto.academia.ui.TelaNovaAula;
import projeto.academia.ui.TelaPrincipal;

/**
 *
 * @author Rodrigo
 */
public class ComandoNovaAula extends Comando {

    @Override
    public void executarComando() {
        new TelaNovaAula(TelaPrincipal.getInstance(), true).setVisible(true);
    }
    
}
