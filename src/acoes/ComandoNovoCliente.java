/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes;

import projeto.academia.ui.TelaNovoCliente;
import projeto.academia.ui.TelaPrincipal;


/**
 *
 * @author Rodrigo
 */
public class ComandoNovoCliente extends Comando {

    @Override
    public void executarComando() {
        new TelaNovoCliente(TelaPrincipal.getInstance(), true).setVisible(true);
    }

}
