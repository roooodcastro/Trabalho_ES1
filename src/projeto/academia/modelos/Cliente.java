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
 * Formato do registro do arquivo:
 * [CPF];[Nome];[Endereco];[Nascimento];[RG];[Telefone];[Email];[ID do Pacote]
 *
 * @author Rodrigo
 */
public class Cliente extends Pessoa {

    private static List<Cliente> clientes;
    private List<Aula> aulas;
    private Pacote pacote;

    public static List<Cliente> buscar(String busca) {
        recarregarClientes();
        busca = busca.trim();
        List<Cliente> clientesAchados = new ArrayList<Cliente>();
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().contains(busca) || cliente.getNome().contains(busca)) {
                clientesAchados.add(cliente);
            }
        }
        return clientesAchados;
    }

    public static boolean excluir(Cliente cli) {
        recarregarClientes();
        try {
            Arquivo arquivoCliente = new Arquivo(Arquivo.ARQ_CLIENTE, Arquivo.MODO_ESCRITA);
            arquivoCliente.limpar();
            for (Cliente cliente : clientes) {
                if (!cliente.getCpf().equals(cli.getCpf())) {
                    arquivoCliente.escreverRegistro(cliente.gerarRegistroArquivo());
                }
            }
            recarregarClientes();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static void cadastrarCliente(String nome, String cpf, String rg, String telefone,
            String dataNascimento, String endereco, String email) {
        Cliente novoCliente = new Cliente();
        novoCliente.nome = nome.replace(Arquivo.SEPARADOR_PADRAO, "");
        novoCliente.cpf = cpf;
        novoCliente.rg = rg.replace(Arquivo.SEPARADOR_PADRAO, "");
        novoCliente.email = email.replace(Arquivo.SEPARADOR_PADRAO, "");
        novoCliente.dataNasc = dataNascimento;
        novoCliente.endereco = endereco.replace(Arquivo.SEPARADOR_PADRAO, "");
        novoCliente.telefone = telefone;
        novoCliente.incluir();
    }

    public static boolean jaExiste(String cpf) {
        getClientes();
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf))
                return true;
        }
        return false;
    }

    @Override
    public boolean incluir() {
        try {
            Arquivo arquivoCliente = new Arquivo(Arquivo.ARQ_CLIENTE, Arquivo.MODO_ESCRITA);
            arquivoCliente.escreverRegistro(gerarRegistroArquivo());
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean alterar() {
        recarregarClientes();
        try {
            Arquivo arquivoCliente = new Arquivo(Arquivo.ARQ_CLIENTE, Arquivo.MODO_ESCRITA);
            arquivoCliente.limpar();
            for (Cliente cliente : clientes) {
                if (cliente.getCpf().equals(cpf)) {
                    cliente = this;
                }
                arquivoCliente.escreverRegistro(cliente.gerarRegistroArquivo());
            }
            recarregarClientes();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public void lerDoArquivo(String registro) {
        String[] campos = registro.split(Arquivo.SEPARADOR_PADRAO);
        this.cpf = campos[0].trim();
        this.nome = campos[1].trim();
        this.endereco = campos[2].trim();
        this.dataNasc = campos[3].trim();
        this.rg = campos[4].trim();
        this.telefone = campos[5].trim();
        this.email = campos[6].trim();
        this.aulas = new ArrayList<Aula>();
        List<Aula> todasAulas = Aula.getAulas();
        for (Aula aula : todasAulas) {
            if (aula.isAlunoMatriculado(this)) {
                aulas.add(aula);
            }
        }
    }

    @Override
    public String gerarRegistroArquivo() {
        String registro = gerarCampoRegistro(cpf);
        registro += gerarCampoRegistro(nome);
        registro += gerarCampoRegistro(endereco);
        registro += gerarCampoRegistro(dataNasc);
        registro += gerarCampoRegistro(rg);
        registro += gerarCampoRegistro(telefone);
        registro += gerarCampoRegistro(email);
        if (pacote != null)
            registro += pacote.getId();
        else
            registro += " ";
        return registro;
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    public static List<Cliente> getClientes() {
        if (clientes == null)
            recarregarClientes();
        return clientes;
    }

    public Pacote getPacote() {
        return pacote;
    }

    public void setPacote(Pacote pacote) {
        this.pacote = pacote;
    }

    public static void recarregarClientes() {
        Arquivo arquivoClientes = new Arquivo(Arquivo.ARQ_CLIENTE, Arquivo.MODO_LEITURA);
        String registro = arquivoClientes.lerRegistro();
        clientes = new ArrayList<Cliente>();
        while (registro != null && !registro.isEmpty()) {
            Cliente cliente = new Cliente();
            cliente.lerDoArquivo(registro);
            clientes.add(cliente);
            registro = arquivoClientes.lerRegistro();
        }
    }

    @Override
    public String[] getTableRow() {
        return new String[]{cpf, nome, dataNasc};
    }

    public static String[][] getTableData(List<Cliente> listaClientes) {
        String[][] data = new String[listaClientes.size()][];
        for (int i = 0; i < listaClientes.size(); i++) {
            data[i] = listaClientes.get(i).getTableRow();
        }
        return data;
    }
}
