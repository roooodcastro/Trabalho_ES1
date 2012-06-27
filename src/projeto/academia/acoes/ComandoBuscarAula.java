/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.academia.acoes;

import projeto.academia.ui.TelaBuscarAula;
import projeto.academia.ui.TelaPrincipal;

/**
 *
 * @author Rodrigo
 */
public class ComandoBuscarAula extends Comando {

    @Override
    public void executarComando() {
        new TelaBuscarAula(TelaPrincipal.getInstance(), true).setVisible(true);
    }
}