/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Aprendiz
 */
public class Casiste {
   private long codigo,user,curso;
   private String fecha, hora, estado, novedad,evento;

    /**
     * @return the codigo
     */
    public long getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the user
     */
    public long getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(long user) {
        this.user = user;
    }

    /**
     * @return the evento
     */
    public String getEvento() {
        return evento;
    }

    /**
     * @param evento the evento to set
     */
    public void setEvento(String evento) {
        this.evento = evento;
    }

    /**
     * @return the curso
     */
    public long getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(long curso) {
        this.curso = curso;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the novedad
     */
    public String getNovedad() {
        return novedad;
    }

    /**
     * @param novedad the novedad to set
     */
    public void setNovedad(String novedad) {
        this.novedad = novedad;
    }
   
    
}
