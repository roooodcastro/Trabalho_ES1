/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.academia;

import javax.swing.UIManager;
import projeto.academia.ui.TelaLogin;
import projeto.academia.ui.TelaPrincipal;

/**
 *
 * @author Rodrigo
 */
public class ProjetoAcademia {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
        }
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                TelaPrincipal.getInstance().setVisible(true);
//                new TelaLogin(null, true).setVisible(true);
            }
        });
    }
}
