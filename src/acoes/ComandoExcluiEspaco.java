/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes;

import javax.swing.JOptionPane;
import projeto.academia.modelos.Espaco;
import projeto.academia.ui.InterfaceUtils;

/**
 *
 * @author Rodrigo
 */
public class ComandoExcluiEspaco extends Comando {

    private Espaco espaco;
    
    public ComandoExcluiEspaco(Espaco espaco) {
        this.espaco = espaco;
    }
    
    @Override
    public void executarComando() {
        if (JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir este espaço?", "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            if (Espaco.excluir(espaco)) {
                InterfaceUtils.exibeMensagem(null, "Sucesso", "Espaço excluído!");
            } else {
                InterfaceUtils.exibeAlerta(null, "Erro", "Houve um erro ao tentar excluir o espaço");
            }
        }
    }
    
}
