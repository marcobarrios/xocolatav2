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
public class Pedido {
    private String codigo = "";
    private String fecha = "";
    private double subtotal = 0.0;
    private double impuesto = 0.0;
    private double envioUSA = 0.0;
    private double total = 0.0;
    private int cantidadProductos = 0;
    private double envioGTUnitario = 0.0;
    private double tipoCambio = 0.0;
    
    private double impuestoUnitario = 0.0;
    private double envioUSAUnitario = 0.0;

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
     * @return the subtotal
     */
    public double getSubtotal() {
        return subtotal;
    }

    /**
     * @param subtotal the subtotal to set
     */
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * @return the impuesto
     */
    public double getImpuesto() {
        return impuesto;
    }

    /**
     * @param impuesto the impuesto to set
     */
    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    /**
     * @return the envioUSA
     */
    public double getEnvioUSA() {
        return envioUSA;
    }

    /**
     * @param envioUSA the envioUSA to set
     */
    public void setEnvioUSA(double envioUSA) {
        this.envioUSA = envioUSA;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @return the cantidadProductos
     */
    public int getCantidadProductos() {
        return cantidadProductos;
    }

    /**
     * @param cantidadProductos the cantidadProductos to set
     */
    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    /**
     * @return the envioGTUnitario
     */
    public double getEnvioGTUnitario() {
        return envioGTUnitario;
    }

    /**
     * @param envioGTUnitario the envioGTUnitario to set
     */
    public void setEnvioGTUnitario(double envioGTUnitario) {
        this.envioGTUnitario = envioGTUnitario;
    }

    /**
     * @return the tipoCambio
     */
    public double getTipoCambio() {
        return tipoCambio;
    }

    /**
     * @param tipoCambio the tipoCambio to set
     */
    public void setTipoCambio(double tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    /**
     * @return the impuestoUnitario
     */
    public double getImpuestoUnitario() {
        return impuestoUnitario;
    }

    /**
     * @param impuestoUnitario the impuestoUnitario to set
     */
    public void setImpuestoUnitario(double impuestoUnitario) {
        this.impuestoUnitario = impuestoUnitario;
    }

    /**
     * @return the envioUSAUnitario
     */
    public double getEnvioUSAUnitario() {
        return envioUSAUnitario;
    }

    /**
     * @param envioUSAUnitario the envioUSAUnitario to set
     */
    public void setEnvioUSAUnitario(double envioUSAUnitario) {
        this.envioUSAUnitario = envioUSAUnitario;
    }
    
}
