/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes;

import javax.swing.JOptionPane;
import projeto.academia.modelos.Aula;
import projeto.academia.ui.InterfaceUtils;

/**
 *
 * @author Rodrigo
 */
public class ComandoExcluiAula extends Comando {

    private Aula aula;
    
    public ComandoExcluiAula(Aula aula) {
        this.aula = aula;
    }
    
    @Override
    public void executarComando() {
        if (JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir esta aula?", "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            if (Aula.excluir(aula)) {
                InterfaceUtils.exibeMensagem(null, "Sucesso", "Aula excluída!");
            } else {
                InterfaceUtils.exibeAlerta(null, "Erro", "Houve um erro ao tentar excluir a aula");
            }
        }
    }
    
}
