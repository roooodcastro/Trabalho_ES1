/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.academia.acoes;

import projeto.academia.ui.TelaNovoFuncionario;
import projeto.academia.ui.TelaPrincipal;

/**
 *
 * @author Rodrigo
 */
public class ComandoNovoProfessor extends Comando {

    @Override
    public void executarComando() {
        new TelaNovoFuncionario(TelaPrincipal.getInstance(), true).setVisible(true);
    }
    
}
