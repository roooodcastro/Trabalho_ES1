/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.academia.acoes;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import javax.swing.Action;

/**
 *
 * @author Rodrigo
 */
public abstract class Comando implements Action {

    HashMap<String, Object> parametros = new HashMap<String, Object>();

    @Override
    public Object getValue(String key) {
        return parametros.get(key);
    }

    @Override
    public void putValue(String key, Object value) {
        parametros.put(key, value);
    }

    @Override
    public void setEnabled(boolean b) {
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        executarComando();
    }
    
    public abstract void executarComando();
}
