/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.academia.acoes;

import projeto.academia.ui.TelaBuscarProfessores;
import projeto.academia.ui.TelaPrincipal;

/**
 *
 * @author Rodrigo
 */
public class ComandoBuscarProfessor extends Comando {

    @Override
    public void executarComando() {
        new TelaBuscarProfessores(TelaPrincipal.getInstance(), true).setVisible(true);
    }
    
}
