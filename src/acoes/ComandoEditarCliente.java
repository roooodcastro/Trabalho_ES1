/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes;

import projeto.academia.modelos.Cliente;
import projeto.academia.ui.TelaEditarCliente;
import projeto.academia.ui.TelaPrincipal;

/**
 *
 * @author Rodrigo
 */
public class ComandoEditarCliente extends Comando {

    private Cliente cliente;
    
    public ComandoEditarCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    @Override
    public void executarComando() {
        new TelaEditarCliente(TelaPrincipal.getInstance(), true, cliente).setVisible(true);
    }
    
}
