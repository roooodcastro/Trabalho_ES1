package projeto.academia.ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import javax.swing.JOptionPane;

/**
 * @author rodcastro
 *
 */
public class InterfaceUtils {

    public static void exibeAlerta(Window janela, String titulo, String mensagem) {
        JOptionPane.showMessageDialog(janela, mensagem, titulo, JOptionPane.WARNING_MESSAGE);
    }

    public static void exibeMensagem(Window janela, String titulo, String mensagem) {
        JOptionPane.showMessageDialog(janela, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void centralizarFrame(Window janela) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        //Calculate the frame location
        int x = (screenSize.width - janela.getWidth()) / 2;
        int y = (screenSize.height - janela.getHeight()) / 2;
        //Set the new frame location
        janela.setLocation(x, y);
    }

}
