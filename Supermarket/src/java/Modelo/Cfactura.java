/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

public class Cfactura {

    private int id_factura, total, id_producto;
    private long id_usuario;

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }
    private String f_factura, t_pago,C_nombre;

    public String getC_nombre() {
        return C_nombre;
    }

    public void setC_nombre(String C_nombre) {
        this.C_nombre = C_nombre;
    }
    private long cedula;

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getF_factura() {
        return f_factura;
    }

    public void setF_factura(String f_factura) {
        this.f_factura = f_factura;
    }

    public String getT_pago() {
        return t_pago;
    }

    public void setT_pago(String t_pago) {
        this.t_pago = t_pago;
    }
}
