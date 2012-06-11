/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.academia.modelos;

/**
 *
 * @author Rodrigo
 */
public class Pacote extends ModeloAbstrato {

    private int id;

    @Override
    public void lerDoArquivo(String registro) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String gerarRegistroArquivo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean incluir() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean alterar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}