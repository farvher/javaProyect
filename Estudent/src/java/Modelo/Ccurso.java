/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author FABIOLA
 */
public class Ccurso {

    private int codigo, dias, cupo;
    private String curso, nivel, dinicio, dfinal;
    private long instructor;

    public long getInstructor() {
        return instructor;
    }

    public void setInstructor(long instructor) {
        this.instructor = instructor;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    

    public String getDinicio() {
        return dinicio;
    }

    public void setDinicio(String dinicio) {
        this.dinicio = dinicio;
    }

    public String getDfinal() {
        return dfinal;
    }

    public void setDfinal(String dfinal) {
        this.dfinal = dfinal;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the horas
     */
    /**
     * @return the curso
     */
    public String getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }

    /**
     * @return the nivel
     */
    public String getNivel() {
        return nivel;
    }

    /**
     * @param nivel the nivel to set
     */
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}
