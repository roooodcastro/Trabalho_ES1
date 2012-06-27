/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.academia.acoes;

import projeto.academia.ui.TelaSobre;

/**
 *
 * @author Rodrigo
 */
public class ComandoSobre extends Comando{

    @Override
    public void executarComando() {
        new TelaSobre(null, true).setVisible(true);
    }
    
}
