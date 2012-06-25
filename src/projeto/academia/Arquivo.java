/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.academia;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * Essa classe deverá lidar com todas as operações de leitura e escrita de arquivos para salvar os dados do programa.
 *
 * Por padrão, cada registro será uma linha de texto.
 *
 * Para adicionar um novo registro, basta adicioná-lo ao final do arquivo;
 *
 * Para atualizar um registro, todo o arquivo será refeito, reescrevendo linha a linha exatamente igual, exceto a linha
 * do registro que quero atualizar.
 *
 * A chave dos registros varia de acordo com o tipo: para pessoas, a chave será o CPF, para os outros será um ID
 * gerado pelo sistema na hora de salvar o registro, e apenas será utilizado para referenciar o registro em outro
 * arquivo (como por exemplo o ID de um espaço em uma aula).
 *
 * @author Rodrigo
 */
public class Arquivo {

    public static final String ARQ_CLIENTE = "clientes.dat";
    public static final String ARQ_PROFESSOR = "professores.dat";
    public static final String ARQ_AULA = "aulas.dat";
    public static final String ARQ_PACOTE = "pacotes.dat";
    public static final String ARQ_ESPACO = "espaços.dat";
    public static final int MODO_LEITURA = 0;
    public static final int MODO_ESCRITA = 1;
    public static final String SEPARADOR_PADRAO = ";";
    private FileWriter out = null;
    private FileReader in = null;

    public Arquivo(String nomeArquivo, int modo) {
        try {
            if (modo == MODO_LEITURA) {
                in = new FileReader(nomeArquivo);
            } else {
                out = new FileWriter(nomeArquivo, true);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void escreverRegistro(String registro) {
        try {
            out.write(registro + "\n");
            out.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String lerRegistro() {
        try {
            String registro = "";
            char c = (char) in.read();
            while (c >= 0 && c != '\n' && c != '\uffff') {
                registro += c;
                c = (char) in.read();
            }
            return registro;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public FileReader getArquivoIn() {
        return in;
    }

    public FileWriter getArquivoOut() {
        return out;
    }

    public static void criarBackup(String nomeArquivo) {
        try {
            File arquivo = new File(nomeArquivo);
            arquivo.renameTo(new File(nomeArquivo + ".bkp"));
            arquivo = new File(nomeArquivo);
            arquivo.delete();
            arquivo.createNewFile();
        } catch (Exception ex) {
            new File(nomeArquivo + ".bkp").renameTo(new File(nomeArquivo));
        }
    }
}
