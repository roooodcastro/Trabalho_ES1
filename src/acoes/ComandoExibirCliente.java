/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes;

import projeto.academia.modelos.Cliente;
import projeto.academia.ui.TelaExibirCliente;
import projeto.academia.ui.TelaPrincipal;

/**
 *
 * @author Rodrigo
 */
public class ComandoExibirCliente extends Comando {

    private Cliente cliente;
    
    public ComandoExibirCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    @Override
    public void executarComando() {
        new TelaExibirCliente(TelaPrincipal.getInstance(), true, cliente).setVisible(true);
    }
    
}
