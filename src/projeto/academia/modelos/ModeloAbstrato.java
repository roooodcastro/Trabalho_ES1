/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.academia.modelos;

import projeto.academia.Arquivo;

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

    protected String gerarCampoRegistro(String campo) {
        if (campo == null || campo.isEmpty())
            campo = " ";
        return campo + Arquivo.SEPARADOR_PADRAO;
    }
}