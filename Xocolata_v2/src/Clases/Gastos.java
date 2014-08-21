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
public class Gastos {
    private String fecha = "";
    private double gasto = 0.0;
    private int idTipoGasto = 0;
    private String tipoGasto = "";

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
     * @return the gasto
     */
    public double getGasto() {
        return gasto;
    }

    /**
     * @param gasto the gasto to set
     */
    public void setGasto(double gasto) {
        this.gasto = gasto;
    }

    /**
     * @return the idTipoGasto
     */
    public int getIdTipoGasto() {
        return idTipoGasto;
    }

    /**
     * @param idTipoGasto the idTipoGasto to set
     */
    public void setIdTipoGasto(int idTipoGasto) {
        this.idTipoGasto = idTipoGasto;
    }

    /**
     * @return the tipoGasto
     */
    public String getTipoGasto() {
        return tipoGasto;
    }

    /**
     * @param tipoGasto the tipoGasto to set
     */
    public void setTipoGasto(String tipoGasto) {
        this.tipoGasto = tipoGasto;
    }
    
}
