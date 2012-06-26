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
public class Pacote extends ModeloAbstrato {

    private int id;
    private String nome;
    private static List<Pacote> pacotes;

    public Pacote() {
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

    public static void cadastrarPacote(String nome) {
        Pacote novoPacote = new Pacote();
        novoPacote.nome = nome.replace(Arquivo.SEPARADOR_PADRAO, "");
        novoPacote.incluir();
    }

    public static Pacote getPorId(int id) {
        recarregarPacotes();
        for (Pacote pacote : pacotes) {
            if (pacote.getId() == id)
                return pacote;
        }
        return null;
    }

    @Override
    public boolean incluir() {
        try {
            recarregarPacotes();
            Arquivo arquivoPacote = new Arquivo(Arquivo.ARQ_PACOTE, Arquivo.MODO_ESCRITA);
            id = gerarProximoId();
            arquivoPacote.escreverRegistro(gerarRegistroArquivo());
            recarregarPacotes();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean alterar() {
        recarregarPacotes();
        try {
            Arquivo arquivoPacotes = new Arquivo(Arquivo.ARQ_PACOTE, Arquivo.MODO_ESCRITA);
            arquivoPacotes.limpar();
            for (Pacote pacote : pacotes) {
                if (pacote.getId() == id) {
                    pacote = this;
                }
                arquivoPacotes.escreverRegistro(pacote.gerarRegistroArquivo());
            }
            recarregarPacotes();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static boolean excluir(Pacote esp) {
        recarregarPacotes();
        try {
            Arquivo arquivoPacotes = new Arquivo(Arquivo.ARQ_PACOTE, Arquivo.MODO_ESCRITA);
            arquivoPacotes.limpar();
            for (Pacote pacote : pacotes) {
                if (pacote.getId() != esp.getId()) {
                    arquivoPacotes.escreverRegistro(pacote.gerarRegistroArquivo());
                }
            }
            recarregarPacotes();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static List<Pacote> getPacotes() {
        if (pacotes == null)
            recarregarPacotes();
        return pacotes;
    }

    public static void recarregarPacotes() {
        Arquivo arquivoPacotes = new Arquivo(Arquivo.ARQ_PACOTE, Arquivo.MODO_LEITURA);
        String registro = arquivoPacotes.lerRegistro();
        pacotes = new ArrayList<Pacote>();
        while (registro != null && !registro.isEmpty()) {
            Pacote pacote = new Pacote();
            pacote.lerDoArquivo(registro);
            pacotes.add(pacote);
            registro = arquivoPacotes.lerRegistro();
        }
    }

    private static int gerarProximoId() {
        recarregarPacotes();
        int maiorId = 0;
        for (Pacote pacote : pacotes) {
            maiorId = Math.max(maiorId, pacote.getId());
        }
        return ++maiorId;
    }

    @Override
    public String[] getTableRow() {
        return new String[]{id + "", nome};
    }

    public static String[][] getTableData(List<Pacote> listaPacotes) {
        String[][] data = new String[listaPacotes.size()][];
        for (int i = 0; i < listaPacotes.size(); i++) {
            data[i] = listaPacotes.get(i).getTableRow();
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