/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Querys;

import Clases.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import xocolata_v2.ConexionDB;

/**
 *
 * @author Rosario
 */
public class ProductoQuerys {
    
    public static void insertarProducto(Producto producto)
    {
        try {
            Connection conexion = ConexionDB.ObtenerConexion();
            PreparedStatement ps = null;
            ps = conexion.prepareStatement("INSERT INTO `tblproductos`(`idProducto`, `codigoProducto`, `idMarca`, `idTipoProducto`, `idTalla`, `idGenero`, `colorProducto`, `descripcionProducto`, `costoDolares`, `impuestoProducto`, `envioProducto`, `totalDolares`, `tipoCambio`, `costoQuetzaltes`, `envioGuate`, `totalQuetzales`, `porcentajeGanacia`, `gananciaEstimada`, `precioVenta`, `porcentajeGananciaSugerida`, `gananciaSugerida`, `precioSugerido`, `idEstadoProducto`, `idPedido`, `porcentajeOferta`, `descuentoOferta`, `precioOfertado`, `precioOfertadoSugerido`, `porcentajeOfertaVenta`, `descuentoVenta`, `precioVentaFinal`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, 0);
            ps.setString(2, "0");
            ps.setInt(3, producto.getMarca());
            ps.setInt(4, producto.getTipoProducto());
            ps.setInt(5, producto.getTalla());
            ps.setInt(6, producto.getGenero());
            ps.setString(7, producto.getColor());
            ps.setString(8, producto.getDescripcion());
            ps.setDouble(9, producto.getPrecioDolar());
            ps.setDouble(10, producto.getImpuestoProducto());
            ps.setDouble(11, producto.getEnvioProducto());
            ps.setDouble(12, producto.getPrecioCostoDolar());
            ps.setDouble(13, producto.getTipoCambio());
            ps.setDouble(14, producto.getPrecioCostoDolar() * producto.getTipoCambio());
            ps.setDouble(15, producto.getEnvioGt());
            ps.setDouble(16, producto.getPrecioCostoQuetzal());
            ps.setDouble(17, producto.getPorcentajeGanancia());
            ps.setDouble(18, producto.getGananciaEstimada());
            ps.setDouble(19, producto.getPrecioVenta());
            ps.setDouble(20, producto.getPorcentajeGananciaSugerida());
            ps.setDouble(21, producto.getGananciaSugerida());
            ps.setDouble(22, producto.getPrecioSugeridoVendedor());
            ps.setInt(23, producto.getEstadoProducto());
            ps.setInt(24, producto.getIdPedido());
            ps.setDouble(25, producto.getPorcentajeOferta());
            ps.setDouble(26, producto.getDescuentoOferta());
            ps.setDouble(27, producto.getPrecioOfertado());
            ps.setDouble(28, producto.getPrecioOfertadoSugerido());
            ps.setDouble(29, producto.getPorcentajeOfertaVenta());
            ps.setDouble(30, producto.getDescuentoVenta());
            ps.setDouble(31, producto.getPrecioVentaFinal());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto ingresado correctamente", "Ingreso Exitoso", 1);
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoQuerys.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
