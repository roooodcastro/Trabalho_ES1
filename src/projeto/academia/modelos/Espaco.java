/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.academia.modelos;

import java.util.ArrayList;
import java.util.List;
import projeto.academia.Arquivo;

/**
 *
 * @author Rodrigo
 */
public class Espaco extends ModeloAbstrato {

    private int id;
    private String nome;
    private static List<Espaco> espacos;

    public Espaco() {
    }

    @Override
    public void lerDoArquivo(String registro) {
        String[] campos = registro.split(Arquivo.SEPARADOR_PADRAO);
        this.id = Integer.parseInt(campos[0].trim());
        this.nome = campos[1].trim();
    }

    @Override
    public String gerarRegistroArquivo() {
        String registro = gerarCampoRegistro(id + "");
        registro += gerarCampoRegistro(nome);
        return registro;
    }

    public static void cadastrarEspaco(String nome) {
        Espaco novoEspaco = new Espaco();
        novoEspaco.nome = nome.replace(Arquivo.SEPARADOR_PADRAO, "");
        novoEspaco.incluir();
    }

    public static Espaco getPorId(int id) {
        recarregarEspacos();
        for (Espaco espaco : espacos) {
            if (espaco.getId() == id)
                return espaco;
        }
        return null;
    }

    @Override
    public boolean incluir() {
        try {
            recarregarEspacos();
            Arquivo arquivoEspaco = new Arquivo(Arquivo.ARQ_ESPACO, Arquivo.MODO_ESCRITA);
            id = gerarProximoId();
            arquivoEspaco.escreverRegistro(gerarRegistroArquivo());
            recarregarEspacos();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean alterar() {
        recarregarEspacos();
        try {
            Arquivo arquivoEspacos = new Arquivo(Arquivo.ARQ_ESPACO, Arquivo.MODO_ESCRITA);
            arquivoEspacos.limpar();
            for (Espaco espaco : espacos) {
                if (espaco.getId() == id) {
                    espaco = this;
                }
                arquivoEspacos.escreverRegistro(espaco.gerarRegistroArquivo());
            }
            recarregarEspacos();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static boolean excluir(Espaco esp) {
        recarregarEspacos();
        try {
            Arquivo arquivoEspacos = new Arquivo(Arquivo.ARQ_ESPACO, Arquivo.MODO_ESCRITA);
            arquivoEspacos.limpar();
            for (Espaco espaco : espacos) {
                if (espaco.getId() != esp.getId()) {
                    arquivoEspacos.escreverRegistro(espaco.gerarRegistroArquivo());
                }
            }
            recarregarEspacos();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static List<Espaco> getEspacos() {
        if (espacos == null)
            recarregarEspacos();
        return espacos;
    }

    public static void recarregarEspacos() {
        Arquivo arquivoEspacos = new Arquivo(Arquivo.ARQ_ESPACO, Arquivo.MODO_LEITURA);
        String registro = arquivoEspacos.lerRegistro();
        espacos = new ArrayList<Espaco>();
        while (registro != null && !registro.isEmpty()) {
            Espaco espaco = new Espaco();
            espaco.lerDoArquivo(registro);
            espacos.add(espaco);
            registro = arquivoEspacos.lerRegistro();
        }
    }

    private static int gerarProximoId() {
        recarregarEspacos();
        int maiorId = 0;
        for (Espaco espaco : espacos) {
            maiorId = Math.max(maiorId, espaco.getId());
        }
        return ++maiorId;
    }

    @Override
    public String[] getTableRow() {
        return new String[]{id + "", nome};
    }

    public static String[][] getTableData(List<Espaco> listaEspacos) {
        String[][] data = new String[listaEspacos.size()][];
        for (int i = 0; i < listaEspacos.size(); i++) {
            data[i] = listaEspacos.get(i).getTableRow();
        }
        return data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}