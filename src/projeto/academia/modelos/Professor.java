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
public class Professor extends Pessoa {

    private String salario;
    private String ocupacao;
    private static List<Professor> professores;
    private List<Aula> aulas;

    public Professor() {
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
        this.salario = campos[7].trim();
        this.ocupacao = campos[8].trim();
        this.aulas = new ArrayList<Aula>();
        List<Aula> todasAulas = Aula.getAulas();
        for (Aula aula : todasAulas) {
            if (aula.getProfessor().getCpf().equals(this.cpf)) {
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
        registro += gerarCampoRegistro(salario);
        registro += gerarCampoRegistro(ocupacao);
        return registro;
    }

    public static void cadastrarProfessor(String nome, String cpf, String rg, String telefone,
            String dataNascimento, String endereco, String email, String salario, String ocupacao) {
        Professor novoProfessor = new Professor();
        novoProfessor.nome = nome.replace(Arquivo.SEPARADOR_PADRAO, "");
        novoProfessor.cpf = cpf;
        novoProfessor.rg = rg.replace(Arquivo.SEPARADOR_PADRAO, "");
        novoProfessor.email = email.replace(Arquivo.SEPARADOR_PADRAO, "");
        novoProfessor.dataNasc = dataNascimento;
        novoProfessor.endereco = endereco.replace(Arquivo.SEPARADOR_PADRAO, "");
        novoProfessor.telefone = telefone;
        novoProfessor.salario = salario;
        novoProfessor.ocupacao = ocupacao.replace(Arquivo.SEPARADOR_PADRAO, "");
        novoProfessor.incluir();
    }

    public static List<Professor> buscar(String busca) {
        recarregarProfessores();
        busca = busca.trim();
        List<Professor> professoresAchados = new ArrayList<Professor>();
        for (Professor professor : professores) {
            if (professor.getCpf().contains(busca) || professor.getNome().contains(busca)) {
                professoresAchados.add(professor);
            }
        }
        return professoresAchados;
    }

    @Override
    public boolean incluir() {
        try {
            Arquivo arquivoProfessor = new Arquivo(Arquivo.ARQ_PROFESSOR, Arquivo.MODO_ESCRITA);
            arquivoProfessor.escreverRegistro(gerarRegistroArquivo());
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean alterar() {
        recarregarProfessores();
        try {
            Arquivo arquivoProfessor = new Arquivo(Arquivo.ARQ_PROFESSOR, Arquivo.MODO_ESCRITA);
            arquivoProfessor.limpar();
            for (Professor professor : professores) {
                if (professor.getCpf().equals(cpf)) {
                    professor = this;
                }
                arquivoProfessor.escreverRegistro(professor.gerarRegistroArquivo());
            }
            recarregarProfessores();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static boolean excluir(Professor prof) {
        recarregarProfessores();
        try {
            Arquivo arquivoProfessor = new Arquivo(Arquivo.ARQ_PROFESSOR, Arquivo.MODO_ESCRITA);
            arquivoProfessor.limpar();
            for (Professor professor : professores) {
                if (!professor.getCpf().equals(prof.getCpf())) {
                    arquivoProfessor.escreverRegistro(professor.gerarRegistroArquivo());
                }
            }
            recarregarProfessores();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static boolean jaExiste(String cpf) {
        getProfessores();
        for (Professor professor : professores) {
            if (professor.getCpf().equals(cpf))
                return true;
        }
        return false;
    }

    public static List<Professor> getProfessores() {
        if (professores == null)
            recarregarProfessores();
        return professores;
    }

    public static void recarregarProfessores() {
        Arquivo arquivoProfessores = new Arquivo(Arquivo.ARQ_PROFESSOR, Arquivo.MODO_LEITURA);
        String registro = arquivoProfessores.lerRegistro();
        professores = new ArrayList<Professor>();
        while (registro != null && !registro.isEmpty()) {
            Professor professor = new Professor();
            professor.lerDoArquivo(registro);
            professores.add(professor);
            registro = arquivoProfessores.lerRegistro();
        }
    }

    @Override
    public String[] getTableRow() {
        return new String[]{cpf, nome, ocupacao};
    }

    public static String[][] getTableData(List<Professor> listaProfessores) {
        String[][] data = new String[listaProfessores.size()][];
        for (int i = 0; i < listaProfessores.size(); i++) {
            data[i] = listaProfessores.get(i).getTableRow();
        }
        return data;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public List<Aula> getAulas() {
        return aulas;
    }
}