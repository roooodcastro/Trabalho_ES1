/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes;

import projeto.academia.modelos.Aula;
import projeto.academia.modelos.Cliente;
import projeto.academia.ui.TelaIncluiAulaCliente;
import projeto.academia.ui.TelaPrincipal;

/**
 *
 * @author Rodrigo
 */
public class ComandoIncluiClienteAula extends Comando {

    private Cliente cliente;
    private Aula aula;
    
    public ComandoIncluiClienteAula(Cliente cliente, Aula aula) {
        this.cliente = cliente;
        this.aula = aula;
    }
    
    @Override
    public void executarComando() {
        new TelaIncluiAulaCliente(TelaPrincipal.getInstance(), true, cliente, aula).setVisible(true);
    }
    
}
