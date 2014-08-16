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
    
    public static void insertarRegistroProducto(Producto producto)
    {
        try {
            Connection conexion = ConexionDB.ObtenerConexion();
            PreparedStatement ps = null;
            ps = conexion.prepareStatement("INSERT INTO `tblproductos`(`idProducto`, `codigoProducto`, `idMarca`, `idTipoProducto`, `idTalla`, `idGenero`, `colorProducto`, `descripcionProducto`, `costoDolares`, `impuestoProducto`, `envioProducto`, `totalDolares`, `tipoCambio`, `costoQuetzaltes`, `envioGuate`, `totalQuetzales`, `porcentajeGanacia`, `gananciaEstimada`, `precioVenta`, `porcentajeGananciaSugerida`, `gananciaSugerida`, `precioSugerido`, `idEstadoProducto`, `idPedido`, `porcentajeOferta`, `descuentoOferta`, `precioOfertado`, `precioOfertadoSugerido`, `porcentajeOfertaVenta`, `descuentoVenta`, `precioVentaFinal`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, 0);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto ingresado correctamente", "Ingreso Exitoso", 1);
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoQuerys.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
