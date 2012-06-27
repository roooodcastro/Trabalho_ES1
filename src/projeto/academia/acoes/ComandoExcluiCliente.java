/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.academia.acoes;

import javax.swing.JOptionPane;
import projeto.academia.modelos.Cliente;
import projeto.academia.ui.InterfaceUtils;

/**
 *
 * @author Rodrigo
 */
public class ComandoExcluiCliente extends Comando {

    private Cliente cliente;

    public ComandoExcluiCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public void executarComando() {
        if (JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir este cliente?", "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            if (Cliente.excluir(cliente)) {
                InterfaceUtils.exibeMensagem(null, "Sucesso", "Cliente excluído!");
            } else {
                InterfaceUtils.exibeAlerta(null, "Erro", "Houve um erro ao tentar excluir o cliente");
            }
        }
    }
}