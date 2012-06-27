/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.academia.acoes;

/**
 *
 * @author Rodrigo
 */
public class ComandoFechar extends Comando {

    @Override
    public void executarComando() {
        System.exit(0);
    }
    
}
