/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.academia.modelos;


/**
 *
 * @author Rodrigo
 */
public abstract class ModeloAbstrato {

    public abstract void lerDoArquivo(String registro);

    public abstract String gerarRegistroArquivo();

    public abstract boolean incluir();

    public abstract boolean alterar();

    public abstract String[] getTableRow();

}