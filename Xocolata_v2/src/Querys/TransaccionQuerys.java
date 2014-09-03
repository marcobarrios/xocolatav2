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
                PreparedStatement ps;
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
                try ( //JOptionPane.showMessageDialog(null, "Producto ingresado correctamente", "Ingreso Exitoso", 1);
                        ResultSet dato = ps.executeQuery("select MAX(idTransaccion) from tblTransacciones")) {
                    dato.next();
                    idTransaccion = dato.getInt("MAX(idTransaccion)");
                }
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
                PreparedStatement ps;
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
            return cantidad;
        }
    }
    
    public static double sumaPrecioVentaTransaccion(int idTransaccion) {
        double precio = 0;
                Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            try (Statement comando = (Statement)conexion.createStatement(); 
                    ResultSet dato = comando.executeQuery("SELECT SUM(tblProductos.precioVentaFinal) FROM tblProductos "
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
            return precio;
        }
    }
    
    public static double sumaPrecioSugeridoTransaccion(int idTransaccion) {
        double precio = 0;
                Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            try (Statement comando = (Statement)conexion.createStatement(); 
                                        ResultSet dato = comando.executeQuery("SELECT SUM(tblProductos.precioVentaFinal) FROM tblProductos "
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
            return precio;
        }
    }
    
    public static int contarProductosTransaccionUnica(int idTransaccion, String fecha) {
        int cantidad = 0;
                Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            try (Statement comando = (Statement)conexion.createStatement(); 
                    ResultSet dato = comando.executeQuery("SELECT COUNT(idProducto) FROM tblDetalleTransacciones WHERE idTransaccion = '" + idTransaccion + "' AND fechaDetalle = '" + fecha + "'")) {
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
            return cantidad;
        }
    }
    
    public static double sumaPrecioVentaTransaccionUnica(int idTransaccion, String fecha) {
        double precio = 0;
                Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            try (Statement comando = (Statement)conexion.createStatement(); 
                    ResultSet dato = comando.executeQuery("SELECT SUM(tblProductos.precioOfertado) FROM tblProductos "
                            + "INNER JOIN tblDetalleTransacciones on tblProductos.idProducto = tblDetalleTransacciones.idProducto WHERE tblDetalleTransacciones.idTransaccion = '" + idTransaccion + "' AND tblDetalleTransacciones.fechaDetalle = '" + fecha + "'")) {
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
            return precio;
        }
    }
    
    public static double sumaPrecioSugeridoTransaccionUnica(int idTransaccion, String fecha) {
        double precio = 0;
                Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            try (Statement comando = (Statement)conexion.createStatement(); 
                                        ResultSet dato = comando.executeQuery("SELECT SUM(tblProductos.precioOfertadoSugerido) FROM tblProductos "
                            + "INNER JOIN tblDetalleTransacciones on tblProductos.idProducto = tblDetalleTransacciones.idProducto WHERE tblDetalleTransacciones.idTransaccion = '" + idTransaccion + "' AND tblDetalleTransacciones.fechaDetalle = '" + fecha + "'")) {
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
            return precio;
        }
    }
    
    public static void agregarPreciosTransaccion(int idTransaccion, int cantidad, double subtotal, double porcentaje, double descuento, double total) {
        Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            try (Statement comando = (Statement)conexion.createStatement()) {
                comando.executeUpdate("UPDATE tblTransacciones SET cantidadProductos = '" + cantidad + "', subtotalTransaccion = '" + subtotal + "', porcentajeOferta = '" + porcentaje + "', descuentoTransaccion = '" + descuento +"', totalTransaccion = '" + total + "' WHERE idTransaccion = '" + idTransaccion + "'");
            }
            conexion.close();
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public static void devolverProductoTransaccion(int idTransaccion, int idProducto) {
        Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            try (Statement comando = (Statement)conexion.createStatement()) {
                comando.executeUpdate("DELETE FROM tblDetalleTransacciones WHERE idTransaccion = '" + idTransaccion + "' AND idProducto = '" + idProducto + "'");
            }
            conexion.close();
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public static void cancelarUltimaTransaccion(int idTransaccion, String fecha) {
        Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            try (Statement comando = (Statement)conexion.createStatement()) {
                comando.executeUpdate("DELETE FROM tblDetalleTransacciones WHERE idTransaccion = '" + idTransaccion + "' AND fechaDetalle = '" + fecha + "'");
            }
            conexion.close();
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public static void cancelarTransaccion(int idTransaccion) {
        Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            try (Statement comando = (Statement)conexion.createStatement()) {
                comando.executeUpdate("DELETE FROM tblDetalleTransacciones WHERE idTransaccion = '" + idTransaccion + "'");
                comando.executeUpdate("DELETE FROM tblTransacciones WHERE idTransaccion = '" + idTransaccion + "'");
            }
            conexion.close();
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
        
    public static void ingresarFechaLimite(int idTransaccion, String fecha) {
        Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            try (Statement comando = (Statement)conexion.createStatement()) {
                comando.executeUpdate("UPDATE tblTransacciones SET fechaDevolucion = '" + fecha +"' where idTransaccion = '" + idTransaccion + "'");
            }
            conexion.close();
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
    
    public static void agregarProductosVendidos(int idTransaccion) {
        Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            try (Statement comando = (Statement)conexion.createStatement()) {
                comando.executeUpdate("UPDATE tblProductos INNER JOIN tblDetalleTransacciones ON tblProductos.idProducto = tblDetalleTransacciones.idProducto SET idEstadoProducto = '3' WHERE tblDetalleTransacciones.idTransaccion = '" + idTransaccion + "'");
            }
            conexion.close();
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
}
