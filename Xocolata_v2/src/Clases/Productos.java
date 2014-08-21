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
public class Productos {
    private String codigo = "";
    private int marca = 0;
    private int tipoProducto = 0;
    private int talla = 0;
    private int genero = 0;
    private String color = "";
    private String descripcion = "";
    private double precioDolar = 0.0;
    private double impuestoProducto = 0.0;
    private double envioProducto = 0.0;
    private double precioCostoDolar = 0.0;
    private double tipoCambio = 0.0;
    private double precioCostoQuetzal = 0.0;
    private double envioGt = 0.0;
    private double porcentajeGanancia = 0.0;
    private double gananciaEstimada = 0.0;
    private double precioVenta = 0.0;
    private double porcentajeGananciaSugerida = 0.0;
    private double gananciaSugerida = 0.0;
    private double precioSugeridoVendedor = 0.0;
    private int estadoProducto = 1;
    private int idPedido = 0;
    private double porcentajeOferta = 0.0;
    private double descuentoOferta = 0.0;
    private double precioOfertado = 0.0;
    private double precioOfertadoSugerido = 0.0;
    private double porcentajeOfertaVenta  = 0.0;
    private double descuentoVenta = 0.0;
    private double precioVentaFinal = 0.0;

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
     * @return the marca
     */
    public int getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(int marca) {
        this.marca = marca;
    }

    /**
     * @return the tipoProducto
     */
    public int getTipoProducto() {
        return tipoProducto;
    }

    /**
     * @param tipoProducto the tipoProducto to set
     */
    public void setTipoProducto(int tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    /**
     * @return the talla
     */
    public int getTalla() {
        return talla;
    }

    /**
     * @param talla the talla to set
     */
    public void setTalla(int talla) {
        this.talla = talla;
    }

    /**
     * @return the genero
     */
    public int getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(int genero) {
        this.genero = genero;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the precioDolar
     */
    public double getPrecioDolar() {
        return precioDolar;
    }

    /**
     * @param precioDolar the precioDolar to set
     */
    public void setPrecioDolar(double precioDolar) {
        this.precioDolar = precioDolar;
    }

    /**
     * @return the impuestoProducto
     */
    public double getImpuestoProducto() {
        return impuestoProducto;
    }

    /**
     * @param impuestoProducto the impuestoProducto to set
     */
    public void setImpuestoProducto(double impuestoProducto) {
        this.impuestoProducto = impuestoProducto;
    }

    /**
     * @return the envioProducto
     */
    public double getEnvioProducto() {
        return envioProducto;
    }

    /**
     * @param envioProducto the envioProducto to set
     */
    public void setEnvioProducto(double envioProducto) {
        this.envioProducto = envioProducto;
    }

    /**
     * @return the precioCostoDolar
     */
    public double getPrecioCostoDolar() {
        return precioCostoDolar;
    }

    /**
     * @param precioCostoDolar the precioCostoDolar to set
     */
    public void setPrecioCostoDolar(double precioCostoDolar) {
        this.precioCostoDolar = precioCostoDolar;
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
     * @return the precioCostoQuetzal
     */
    public double getPrecioCostoQuetzal() {
        return precioCostoQuetzal;
    }

    /**
     * @param precioCostoQuetzal the precioCostoQuetzal to set
     */
    public void setPrecioCostoQuetzal(double precioCostoQuetzal) {
        this.precioCostoQuetzal = precioCostoQuetzal;
    }

    /**
     * @return the envioGt
     */
    public double getEnvioGt() {
        return envioGt;
    }

    /**
     * @param envioGt the envioGt to set
     */
    public void setEnvioGt(double envioGt) {
        this.envioGt = envioGt;
    }

    /**
     * @return the porcentajeGanancia
     */
    public double getPorcentajeGanancia() {
        return porcentajeGanancia;
    }

    /**
     * @param porcentajeGanancia the porcentajeGanancia to set
     */
    public void setPorcentajeGanancia(double porcentajeGanancia) {
        this.porcentajeGanancia = porcentajeGanancia;
    }

    /**
     * @return the gananciaEstimada
     */
    public double getGananciaEstimada() {
        return gananciaEstimada;
    }

    /**
     * @param gananciaEstimada the gananciaEstimada to set
     */
    public void setGananciaEstimada(double gananciaEstimada) {
        this.gananciaEstimada = gananciaEstimada;
    }

    /**
     * @return the precioVenta
     */
    public double getPrecioVenta() {
        return precioVenta;
    }

    /**
     * @param precioVenta the precioVenta to set
     */
    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    /**
     * @return the porcentajeGananciaSugerida
     */
    public double getPorcentajeGananciaSugerida() {
        return porcentajeGananciaSugerida;
    }

    /**
     * @param porcentajeGananciaSugerida the porcentajeGananciaSugerida to set
     */
    public void setPorcentajeGananciaSugerida(double porcentajeGananciaSugerida) {
        this.porcentajeGananciaSugerida = porcentajeGananciaSugerida;
    }

    /**
     * @return the gananciaSugerida
     */
    public double getGananciaSugerida() {
        return gananciaSugerida;
    }

    /**
     * @param gananciaSugerida the gananciaSugerida to set
     */
    public void setGananciaSugerida(double gananciaSugerida) {
        this.gananciaSugerida = gananciaSugerida;
    }

    /**
     * @return the precioSugeridoVendedor
     */
    public double getPrecioSugeridoVendedor() {
        return precioSugeridoVendedor;
    }

    /**
     * @param precioSugeridoVendedor the precioSugeridoVendedor to set
     */
    public void setPrecioSugeridoVendedor(double precioSugeridoVendedor) {
        this.precioSugeridoVendedor = precioSugeridoVendedor;
    }

    /**
     * @return the estadoProducto
     */
    public int getEstadoProducto() {
        return estadoProducto;
    }

    /**
     * @param estadoProducto the estadoProducto to set
     */
    public void setEstadoProducto(int estadoProducto) {
        this.estadoProducto = estadoProducto;
    }

    /**
     * @return the idPedido
     */
    public int getIdPedido() {
        return idPedido;
    }

    /**
     * @param idPedido the idPedido to set
     */
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
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
     * @return the descuentoOferta
     */
    public double getDescuentoOferta() {
        return descuentoOferta;
    }

    /**
     * @param descuentoOferta the descuentoOferta to set
     */
    public void setDescuentoOferta(double descuentoOferta) {
        this.descuentoOferta = descuentoOferta;
    }

    /**
     * @return the precioOfertado
     */
    public double getPrecioOfertado() {
        return precioOfertado;
    }

    /**
     * @param precioOfertado the precioOfertado to set
     */
    public void setPrecioOfertado(double precioOfertado) {
        this.precioOfertado = precioOfertado;
    }

    /**
     * @return the porcentajeOfertaVenta
     */
    public double getPorcentajeOfertaVenta() {
        return porcentajeOfertaVenta;
    }

    /**
     * @param porcentajeOfertaVenta the porcentajeOfertaVenta to set
     */
    public void setPorcentajeOfertaVenta(double porcentajeOfertaVenta) {
        this.porcentajeOfertaVenta = porcentajeOfertaVenta;
    }

    /**
     * @return the descuentoVenta
     */
    public double getDescuentoVenta() {
        return descuentoVenta;
    }

    /**
     * @param descuentoVenta the descuentoVenta to set
     */
    public void setDescuentoVenta(double descuentoVenta) {
        this.descuentoVenta = descuentoVenta;
    }

    /**
     * @return the precioVentaFinal
     */
    public double getPrecioVentaFinal() {
        return precioVentaFinal;
    }

    /**
     * @param precioVentaFinal the precioVentaFinal to set
     */
    public void setPrecioVentaFinal(double precioVentaFinal) {
        this.precioVentaFinal = precioVentaFinal;
    }

    /**
     * @return the precioOfertadoSugerido
     */
    public double getPrecioOfertadoSugerido() {
        return precioOfertadoSugerido;
    }

    /**
     * @param precioOfertadoSugerido the precioOfertadoSugerido to set
     */
    public void setPrecioOfertadoSugerido(double precioOfertadoSugerido) {
        this.precioOfertadoSugerido = precioOfertadoSugerido;
    }

    
}
