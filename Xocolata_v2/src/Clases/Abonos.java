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
public class Abonos {
    private String fechaAbono = "";
    private double montoAbono = 0.0;
    private int idPersona = 0;    

    /**
     * @return the fechaAbono
     */
    public String getFechaAbono() {
        return fechaAbono;
    }

    /**
     * @param fechaAbono the fechaAbono to set
     */
    public void setFechaAbono(String fechaAbono) {
        this.fechaAbono = fechaAbono;
    }

    /**
     * @return the montoAbono
     */
    public double getMontoAbono() {
        return montoAbono;
    }

    /**
     * @param montoAbono the montoAbono to set
     */
    public void setMontoAbono(double montoAbono) {
        this.montoAbono = montoAbono;
    }

    /**
     * @return the idPersona
     */
    public int getIdPersona() {
        return idPersona;
    }

    /**
     * @param idPersona the idPersona to set
     */
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }
}
