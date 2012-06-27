/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.academia.acoes;

import projeto.academia.ui.TelaBuscarClientes;
import projeto.academia.ui.TelaPrincipal;

/**
 *
 * @author Rodrigo
 */
public class ComandoBuscarCliente extends Comando {

    @Override
    public void executarComando() {
        new TelaBuscarClientes(TelaPrincipal.getInstance(), true).setVisible(true);
    }
    
}
