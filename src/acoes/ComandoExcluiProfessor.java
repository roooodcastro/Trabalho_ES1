/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acoes;

import javax.swing.JOptionPane;
import projeto.academia.modelos.Professor;
import projeto.academia.ui.InterfaceUtils;

/**
 *
 * @author Rodrigo
 */
public class ComandoExcluiProfessor extends Comando {

    private Professor professor;
    
    public ComandoExcluiProfessor(Professor professor) {
        this.professor = professor;
    }
    
    @Override
    public void executarComando() {
        if (JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir este professor?", "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            if (Professor.excluir(professor)) {
                InterfaceUtils.exibeMensagem(null, "Sucesso", "Professor excluído!");
            } else {
                InterfaceUtils.exibeAlerta(null, "Erro", "Houve um erro ao tentar excluir o professor");
            }
        }
    }
    
}
