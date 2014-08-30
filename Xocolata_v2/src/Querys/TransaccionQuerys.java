/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Querys;

import Clases.Transacciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import xocolata_v2.ConexionDB;

/**
 *
 * @author Marco
 */
public class TransaccionQuerys {
    
    public static int insertarTransaccion(Transacciones transaccion)
    {
        int idTransaccion = 0;
        try {
            try (Connection conexion = ConexionDB.ObtenerConexion()) {
                PreparedStatement ps = null;
                ps = conexion.prepareStatement("INSERT INTO `tblTransacciones`(`idTransaccion`,`codigoTransaccion`,`idPersona`,`fechaTransaccion`,`fechaDevolucion`,`cantidadProductos`,`subtotalTransaccion`,`porcentajeOferta`,`descuentoTransaccion`,`totalTransaccion`,`tipoTransaccion`) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
                ps.setInt(1, 0);
                ps.setString(2, "0");
                ps.setInt(3, transaccion.getIdPersona());
                ps.setString(4, transaccion.getFechaTransaccion());
                ps.setString(5, transaccion.getFechaDevolucion());
                ps.setInt(6, transaccion.getCantidadPRoductos());
                ps.setDouble(7, transaccion.getSubtotalTransaccion());
                ps.setDouble(8, transaccion.getPorcentajeOferta());
                ps.setDouble(9, transaccion.getDescuentoTransaccion());
                ps.setDouble(10, transaccion.getTotalTransccion());
                ps.setInt(11, transaccion.getTipoTransccion());
                ps.executeUpdate();
                //JOptionPane.showMessageDialog(null, "Producto ingresado correctamente", "Ingreso Exitoso", 1);
                ResultSet dato = ps.executeQuery("select MAX(idTransaccion) from tblTransacciones"); 
                dato.next();
                idTransaccion = dato.getInt("MAX(idTransaccion)");
                dato.close();
                ps.close();
                conexion.close();
                return idTransaccion;

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
                    return idTransaccion;
        }
    }
    
    public static void ingresarDetalleTransaccion(int idTransaccion, int idProducto, String fecha) {
        try {
            try (Connection conexion = ConexionDB.ObtenerConexion()) {
                PreparedStatement ps = null;
                ps = conexion.prepareStatement("INSERT INTO `tblDetalleTransacciones`(`idTransaccion`,`idProducto`,`fechaDetalle`) VALUES (?,?,?)");
                ps.setInt(1, idTransaccion);
                ps.setInt(2, idProducto);
                ps.setString(3, fecha);
                ps.executeUpdate();
                //JOptionPane.showMessageDialog(null, "Producto ingresado correctamente", "Ingreso Exitoso", 1);
                ps.close();
                conexion.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
    
    public static int contarProductosTransaccion(int idTransaccion) {
        int cantidad = 0;
                Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            try (Statement comando = (Statement)conexion.createStatement(); 
                    ResultSet dato = comando.executeQuery("SELECT COUNT(idProducto) FROM tblDetalleTransacciones WHERE idTransaccion = '" + idTransaccion + "'")) {
                    dato.next();
                    cantidad = dato.getInt("COUNT(idProducto)");
            dato.close();
            comando.close();
            conexion.close();
            return cantidad;
            }
        }
        catch (SQLException ex)
        {
            //JOptionPane.showMessageDialog(null, "Producto no Disponible");
            return cantidad;
        }
    }
    
    public static double sumaPrecioVentaTransaccion(int idTransaccion) {
        double precio = 0;
                Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            try (Statement comando = (Statement)conexion.createStatement(); 
                    ResultSet dato = comando.executeQuery("SELECT SUM(tblProductos.precioOfertado) FROM tblProductos "
                            + "INNER JOIN tblDetalleTransacciones on tblProductos.idProducto = tblDetalleTransacciones.idProducto WHERE tblDetalleTransacciones.idTransaccion = '" + idTransaccion + "'")) {
                    dato.next();
                    precio = dato.getInt("SUM(tblProductos.precioOfertado)");
            dato.close();
            comando.close();
            conexion.close();
            return precio;
            }
        }
        catch (SQLException ex)
        {
            //JOptionPane.showMessageDialog(null, "Producto no Disponible");
            return precio;
        }
    }
    
    public static double sumaPrecioSugeridoTransaccion(int idTransaccion) {
        double precio = 0;
                Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            try (Statement comando = (Statement)conexion.createStatement(); 
                                        ResultSet dato = comando.executeQuery("SELECT SUM(tblProductos.precioOfertadoSugerido) FROM tblProductos "
                            + "INNER JOIN tblDetalleTransacciones on tblProductos.idProducto = tblDetalleTransacciones.idProducto WHERE tblDetalleTransacciones.idTransaccion = '" + idTransaccion + "'")) {
                    dato.next();
                    precio = dato.getInt("SUM(tblProductos.precioOfertadoSugerido)");
            dato.close();
            comando.close();
            conexion.close();
            return precio;
            }
        }
        catch (SQLException ex)
        {
            //JOptionPane.showMessageDialog(null, "Producto no Disponible");
            return precio;
        }
    }
}
