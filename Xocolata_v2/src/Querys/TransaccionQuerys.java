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
    
    public static int crearRegistroTransaccion(int tipo, int idpersona)
    {
        int idTransaccion = 0;
        try {
            try (Connection conexion = ConexionDB.ObtenerConexion()) {
                PreparedStatement ps;
                ps = conexion.prepareStatement("INSERT INTO `tblRegistroTransacciones`(`idRegistroTransaccion`, `codigoTransaccion`, `tipoTransaccion`, `cantidadProductos`, `totalTransaccion`, `idPersona`) VALUES (?,?,?,?,?,?)");
                ps.setInt(1, 0);
                ps.setString(2, "");
                ps.setInt(3, tipo);
                ps.setInt(4, 0);
                ps.setDouble(5, 0.0);
                ps.setInt(6, idpersona);
                ps.executeUpdate();
                try ( //JOptionPane.showMessageDialog(null, "Producto ingresado correctamente", "Ingreso Exitoso", 1);
                        ResultSet dato = ps.executeQuery("select MAX(idRegistroTransaccion) from tblRegistroTransacciones")) {
                    dato.next();
                    idTransaccion = dato.getInt("MAX(idRegistroTransaccion)");
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
    
    public static int insertarTransaccion(Transacciones transaccion)
    {
        int idTransaccion = 0;
        try {
            try (Connection conexion = ConexionDB.ObtenerConexion()) {
                PreparedStatement ps;
                ps = conexion.prepareStatement("INSERT INTO `tblTransacciones`(`idTransaccion`,`fechaTransaccion`,`fechaDevolucion`,`cantidadProductos`,`subtotalTransaccion`,`porcentajeOferta`,`descuentoTransaccion`,`totalTransaccion`,`idRegistroTransaccion`) VALUES (?,?,?,?,?,?,?,?,?)");
                ps.setInt(1, 0);
                ps.setString(2, transaccion.getFechaTransaccion());
                ps.setString(3, transaccion.getFechaDevolucion());
                ps.setInt(4, transaccion.getCantidadPRoductos());
                ps.setDouble(5, transaccion.getSubtotalTransaccion());
                ps.setDouble(6, transaccion.getPorcentajeOferta());
                ps.setDouble(7, transaccion.getDescuentoTransaccion());
                ps.setDouble(8, transaccion.getTotalTransccion());
                ps.setInt(9, transaccion.getIdRegistroProducto());
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
    
    public static void ingresarDetalleTransaccion(int idTransaccion, int idProducto) {
        try {
            try (Connection conexion = ConexionDB.ObtenerConexion()) {
                PreparedStatement ps;
                ps = conexion.prepareStatement("INSERT INTO `tblDetalleTransacciones`(`idTransaccion`,`idProducto`) VALUES (?,?)");
                ps.setInt(1, idTransaccion);
                ps.setInt(2, idProducto);
                ps.executeUpdate();
                //JOptionPane.showMessageDialog(null, "Producto ingresado correctamente", "Ingreso Exitoso", 1);
                ps.close();
                conexion.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
    
    public static int contarProductosRegistroTransaccion(int idRegistroTransaccion) {
        int cantidad = 0;
                Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            try (Statement comando = (Statement)conexion.createStatement(); 
                    ResultSet dato = comando.executeQuery("SELECT COUNT(idProducto) FROM tblDetalleTransacciones "
                            + "INNER JOIN tblTransacciones ON tblTransacciones.idTransaccion = tblDetalleTransacciones.idTransaccion "
                            + "WHERE tblTransacciones.idRegistroTransaccion = '" + idRegistroTransaccion + "'")) {
                    dato.next();
                    cantidad = dato.getInt("COUNT(idProducto)");
            dato.close();
            comando.executeUpdate("UPDATE tblRegistroProductos SET cantidadProductos = '" + cantidad + "' WHERE idRegistroTransaccion = '" + idRegistroTransaccion + "'");
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
    
    public static double sumaPrecioVentaRegistroTransaccion(int idRegistroTransaccion) {
        double precio = 0;
                Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            try (Statement comando = (Statement)conexion.createStatement(); 
                    ResultSet dato = comando.executeQuery("SELECT SUM(tblProductos.precioVentaFinal) FROM tblProductos "
                            + "INNER JOIN tblDetalleTransacciones on tblProductos.idProducto = tblDetalleTransacciones.idProducto "
                            + "INNER JOIN tblTransacciones ON tblTransacciones.idTransaccion = tblDetalleTransacciones.idTransaccion "
                            + "WHERE tblTransacciones.idRegistroTransaccion = '" + idRegistroTransaccion + "'")) {
                    dato.next();
                    precio = dato.getInt("SUM(tblProductos.precioVentaFinal)");
            dato.close();
            comando.executeUpdate("UPDATE tblRegistroProductos SET totalTransaccion = '" + precio + "' WHERE idRegistroTransaccion = '" + idRegistroTransaccion + "'");
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
    
    public static void cancelarRegistroTransaccion(int idTransaccion, int idRegistroTransaccion) {
        Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            try (Statement comando = (Statement)conexion.createStatement()) {
                comando.executeUpdate("DELETE FROM tblDetalleTransacciones WHERE idTransaccion = '" + idTransaccion + "'");
                comando.executeUpdate("DELETE FROM tblTransacciones WHERE idTransaccion = '" + idTransaccion + "'");
                comando.executeUpdate("DELETE FROM tblRegistroTransacciones WHERE idRegistroTransaccion = '" + idRegistroTransaccion + "'");
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
