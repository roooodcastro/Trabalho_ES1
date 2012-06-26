/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes;

import projeto.academia.ui.TelaListarEspacos;
import projeto.academia.ui.TelaPrincipal;

/**
 *
 * @author Rodrigo
 */
public class ComandoListarEspacos extends Comando {

    @Override
    public void executarComando() {
        new TelaListarEspacos(TelaPrincipal.getInstance(), true).setVisible(true);
    }
    
}
