/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.academia;

/**
 *
 * @author Rodrigo
 */
public class Horario {
    
    public static final String DOMINGO = "Domingo";
    public static final String SEGUNDA = "2ª feira";
    public static final String TERCA = "3ª feira";
    public static final String QUARTA = "4ª feira";
    public static final String QUINTA = "5ª feira";
    public static final String SEXTA = "6ª feira";
    public static final String SABADO = "Sábado";
    private String dia;
    private String horaInicio;
    private String horaFim;
    
    public Horario(String dia, String horaInicio, String horaFim) {
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }
    
    public static Horario getFromString(String horario) {
        String[] campos = horario.split("-");
        String dia = campos[0];
        String horaInicio = campos[1];
        String horaFim = campos[2];
        return new Horario(dia, horaInicio, horaFim);
    }
    
    @Override
    public String toString() {
        return dia + "-" + horaInicio + "-" + horaFim;
    }
}
