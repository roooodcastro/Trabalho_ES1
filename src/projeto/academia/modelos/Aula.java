/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.academia.modelos;

import java.util.ArrayList;
import java.util.List;
import projeto.academia.Arquivo;
import projeto.academia.Horario;

/**
 *
 * Estrutura do arquivo de aulas:
 *
 * [CPF Professor];[ID Espaco];[Horario1],[Horario2]...[HorarioN];[CPF Aluno1];[CPF Aluno2]...[CPF AlunoN]
 *
 * @author Rodrigo
 */
public class Aula extends ModeloAbstrato {

    private static List<Aula> aulas;
    private Professor professor;
    private List<Cliente> alunos;
    private List<Horario> horarios;
    private Espaco sala;

    public static List<Aula> getAulas() {
        if (aulas == null)
            carregarAulas();
        return aulas;
    }

    @Override
    public void lerDoArquivo(String registro) {
        String[] campos = registro.split(Arquivo.SEPARADOR_PADRAO);

    }

    @Override
    public String gerarRegistroArquivo() {
        String registro = professor.getCpf();
        registro += Arquivo.SEPARADOR_PADRAO;
        registro += sala.getId() + Arquivo.SEPARADOR_PADRAO;
        for (Horario horario : horarios) {
            registro += horario.toString() + ",";
        }
        registro = registro.substring(0, registro.length() - 1);
        registro += Arquivo.SEPARADOR_PADRAO;
        for (Cliente aluno : alunos) {
            registro += aluno.getCpf() + Arquivo.SEPARADOR_PADRAO;
        }
        return registro.substring(0, registro.length() - 1);
    }

    public static List<Aula> buscarAulas(String cpfProfessor, String nomeEspaco, Horario horario, String cpfAluno) {
        // Carregar todas as aulas e ver uma a uma se satisfaz todas as condições
        return null;
    }

    private static void carregarAulas() {
        Arquivo arquivoAulas = new Arquivo(Arquivo.ARQ_AULA, Arquivo.MODO_LEITURA);
        String registro = arquivoAulas.lerRegistro();
        aulas = new ArrayList<Aula>();
        while (registro != null) {
            Aula aula = new Aula();
            aula.lerDoArquivo(registro);
            aulas.add(aula);
            registro = arquivoAulas.lerRegistro();
        }
    }

    public List<Cliente> getAlunos() {
        return alunos;
    }

    public void addAluno(Cliente aluno) {
        this.alunos.add(aluno);
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Espaco getSala() {
        return sala;
    }

    public void setSala(Espaco sala) {
        this.sala = sala;
    }

    @Override
    public boolean incluir() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean alterar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String[] getTableRow() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}