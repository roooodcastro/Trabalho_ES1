/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.academia.acoes;

import projeto.academia.modelos.Espaco;
import projeto.academia.ui.TelaEditarEspaco;
import projeto.academia.ui.TelaPrincipal;

/**
 *
 * @author Rodrigo
 */
public class ComandoEditarEspaco extends Comando {

    private Espaco espaco;

    public ComandoEditarEspaco(Espaco espaco) {
        this.espaco = espaco;
    }

    @Override
    public void executarComando() {
        new TelaEditarEspaco(TelaPrincipal.getInstance(), true, espaco).setVisible(true);
    }
}