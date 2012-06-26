/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes;

import projeto.academia.modelos.Cliente;

/**
 *
 * @author Rodrigo
 */
public class ComandoIncluiClienteAula extends Comando {

    private Cliente cliente;
    
    public ComandoIncluiClienteAula(Cliente cliente) {
        this.cliente = cliente;
    }
    
    @Override
    public void executarComando() {
//        new Tela
    }
    
}
