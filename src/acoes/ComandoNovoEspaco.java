/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes;

import projeto.academia.ui.TelaNovoEspaco;
import projeto.academia.ui.TelaPrincipal;

/**
 *
 * @author Rodrigo
 */
public class ComandoNovoEspaco extends Comando {

    @Override
    public void executarComando() {
        new TelaNovoEspaco(TelaPrincipal.getInstance(), true).setVisible(true);
    }
    
}
