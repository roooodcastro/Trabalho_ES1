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
    private int id;
    private String nome;
    private Professor professor;
    private List<Cliente> alunos;
    private List<Horario> horarios;
    private Espaco sala;

    public Aula() {
        alunos = new ArrayList<Cliente>();
        horarios = new ArrayList<Horario>();
    }
    
    public static List<Aula> getAulas() {
        if (aulas == null)
            carregarAulas();
        return aulas;
    }

    @Override
    public void lerDoArquivo(String registro) {
        String[] campos = registro.split(Arquivo.SEPARADOR_PADRAO);
        String cpfProfesor = campos[0].trim();
        if (!cpfProfesor.isEmpty())
            professor = Professor.buscar(campos[0].trim()).get(0);
        nome = campos[1].trim();
        sala = Espaco.getPorId(Integer.parseInt(campos[2].trim()));
        String horariosString = campos[3].trim();
        horarios = new ArrayList<Horario>();
        for (String horario : horariosString.split(",")) {
            horarios.add(Horario.getFromString(horario));
        }
        alunos = new ArrayList<Cliente>();
        for (int i = 4; i < campos.length; i++) {
            String cpf = campos[i].trim();
            if (!cpf.isEmpty())
                alunos.add(Cliente.buscar(campos[i].trim()).get(0));
        }
    }

    @Override
    public String gerarRegistroArquivo() {
        String registro = professor.getCpf();
        registro += Arquivo.SEPARADOR_PADRAO;
        registro += gerarCampoRegistro(nome);
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

    public static Aula buscarPorId(int id) {
        recarregarAulas();
        for (Aula aula : aulas) {
            if (aula.getId() == id)
                return aula;
        }
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

    public static void cadastrarAula(String nome, Professor professor, List<Horario> horarios, Espaco espaco) {
        Aula novaAula = new Aula();
        novaAula.setProfessor(professor);
        novaAula.setNome(nome);
        novaAula.setSala(espaco);
        novaAula.setHorarios(horarios);
        novaAula.incluir();
    }

    @Override
    public boolean incluir() {
        try {
            recarregarAulas();
            Arquivo arquivoAula = new Arquivo(Arquivo.ARQ_AULA, Arquivo.MODO_ESCRITA);
            id = gerarProximoId();
            arquivoAula.escreverRegistro(gerarRegistroArquivo());
            recarregarAulas();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean alterar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String[] getTableRow() {
        return new String[] {id + "", nome};
    }
    
    public static String[][] getTableData(List<Aula> listaAulas) {
        String[][] data = new String[listaAulas.size()][];
        for (int i = 0; i < listaAulas.size(); i++) {
            data[i] = listaAulas.get(i).getTableRow();
        }
        return data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private static void recarregarAulas() {
        Arquivo arquivoAulas = new Arquivo(Arquivo.ARQ_AULA, Arquivo.MODO_LEITURA);
        String registro = arquivoAulas.lerRegistro();
        aulas = new ArrayList<Aula>();
        while (registro != null && !registro.isEmpty()) {
            Aula aula = new Aula();
            aula.lerDoArquivo(registro);
            aulas.add(aula);
            registro = arquivoAulas.lerRegistro();
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }

    public void setAlunos(List<Cliente> alunos) {
        this.alunos = alunos;
    }
    
    private static int gerarProximoId() {
        recarregarAulas();
        int maiorId = 0;
        for (Aula aula : aulas) {
            maiorId = Math.max(maiorId, aula.getId());
        }
        return ++maiorId;
    }
}