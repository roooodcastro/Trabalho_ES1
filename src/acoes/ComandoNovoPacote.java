/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes;

import projeto.academia.ui.TelaNovoPacote;
import projeto.academia.ui.TelaPrincipal;

/**
 *
 * @author Rodrigo
 */
public class ComandoNovoPacote extends Comando {

    @Override
    public void executarComando() {
        new TelaNovoPacote(TelaPrincipal.getInstance(), true).setVisible(true);
    }
    
}
