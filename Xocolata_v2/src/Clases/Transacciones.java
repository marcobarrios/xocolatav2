/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

/**
 *
 * @author Marco
 */
public class Transacciones {
    private int idTransaccion = 0;
    private String fechaTransaccion = "";
    private String fechaDevolucion = "";
    private int cantidadPRoductos = 0;
    private double subtotalTransaccion = 0.0;
    private double porcentajeOferta = 0.0;
    private double descuentoTransaccion = 0.0;
    private double totalTransccion = 0.0;
    private int idRegistroProducto = 0;

    /**
     * @return the idTransaccion
     */
    public int getIdTransaccion() {
        return idTransaccion;
    }

    /**
     * @param idTransaccion the idTransaccion to set
     */
    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    /**
     * @return the fechaTransaccion
     */
    public String getFechaTransaccion() {
        return fechaTransaccion;
    }

    /**
     * @param fechaTransaccion the fechaTransaccion to set
     */
    public void setFechaTransaccion(String fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    /**
     * @return the fechaDevolucion
     */
    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    /**
     * @param fechaDevolucion the fechaDevolucion to set
     */
    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    /**
     * @return the cantidadPRoductos
     */
    public int getCantidadPRoductos() {
        return cantidadPRoductos;
    }

    /**
     * @param cantidadPRoductos the cantidadPRoductos to set
     */
    public void setCantidadPRoductos(int cantidadPRoductos) {
        this.cantidadPRoductos = cantidadPRoductos;
    }

    /**
     * @return the subtotalTransaccion
     */
    public double getSubtotalTransaccion() {
        return subtotalTransaccion;
    }

    /**
     * @param subtotalTransaccion the subtotalTransaccion to set
     */
    public void setSubtotalTransaccion(double subtotalTransaccion) {
        this.subtotalTransaccion = subtotalTransaccion;
    }

    /**
     * @return the porcentajeOferta
     */
    public double getPorcentajeOferta() {
        return porcentajeOferta;
    }

    /**
     * @param porcentajeOferta the porcentajeOferta to set
     */
    public void setPorcentajeOferta(double porcentajeOferta) {
        this.porcentajeOferta = porcentajeOferta;
    }

    /**
     * @return the descuentoTransaccion
     */
    public double getDescuentoTransaccion() {
        return descuentoTransaccion;
    }

    /**
     * @param descuentoTransaccion the descuentoTransaccion to set
     */
    public void setDescuentoTransaccion(double descuentoTransaccion) {
        this.descuentoTransaccion = descuentoTransaccion;
    }

    /**
     * @return the totalTransccion
     */
    public double getTotalTransccion() {
        return totalTransccion;
    }

    /**
     * @param totalTransccion the totalTransccion to set
     */
    public void setTotalTransccion(double totalTransccion) {
        this.totalTransccion = totalTransccion;
    }

    /**
     * @return the idRegistroProducto
     */
    public int getIdRegistroProducto() {
        return idRegistroProducto;
    }

    /**
     * @param idRegistroProducto the idRegistroProducto to set
     */
    public void setIdRegistroProducto(int idRegistroProducto) {
        this.idRegistroProducto = idRegistroProducto;
    }

   
}
