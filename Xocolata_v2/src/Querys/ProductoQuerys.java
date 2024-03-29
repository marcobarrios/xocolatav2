/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Querys;

import Clases.Productos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import xocolata_v2.ConexionDB;

/**
 *
 * @author Rosario
 */
public class ProductoQuerys {
    
    public static void insertarProducto(Productos producto) {
        DecimalFormat df = new DecimalFormat("0.00");
        try {
            try (Connection conexion = ConexionDB.ObtenerConexion()) {
                PreparedStatement ps;
                ps = conexion.prepareStatement("INSERT INTO `tblproductos`(`idProducto`, `codigoProducto`, `idMarca`, `idTipoProducto`, `idTalla`, `idGenero`, `colorProducto`, `descripcionProducto`, `costoDolares`, `impuestoProducto`, `envioProducto`, `totalDolares`, `tipoCambio`, `costoQuetzales`, `envioGuate`, `totalQuetzales`, `porcentajeGanancia`, `gananciaEstimada`, `precioVenta`, `porcentajeGananciaSugerida`, `gananciaSugerida`, `precioSugerido`, `idEstadoProducto`, `idPedido`, `porcentajeOferta`, `descuentoOferta`, `precioOfertado`, `precioOfertadoSugerido`, `porcentajeOfertaVenta`, `descuentoVenta`, `precioVentaFinal`, `activo`) "
                        + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
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
                ps.setDouble(14, Double.parseDouble(df.format(producto.getPrecioCostoQuetzal() - producto.getEnvioGt())));
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
                ps.setInt(32, 1);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Producto ingresado correctamente", "Ingreso Exitoso", 1);
                ps.close();
                conexion.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoQuerys.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public static void insertarMarca(String marca)
    {
        Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            try (Statement comando = (Statement)conexion.createStatement()) {
                comando.execute("insert into tblMarcas values('0','" + marca + "')");
            }
            conexion.close();
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
        public static void insertarTipoProducto(String tipo)
    {
        Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            try (Statement comando = (Statement)conexion.createStatement()) {
                comando.execute("insert into tblTipoProductos values('0','" + tipo + "')");
            }
            conexion.close();
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
        
    public static void insertarTalla(String talla)
    {
        Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            try (Statement comando = (Statement)conexion.createStatement()) {
                comando.execute("insert into tblTallas values('0','" + talla + "')");
            }
            conexion.close();
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public static void insertarGenero(String genero)
    {
        Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            try (Statement comando = (Statement)conexion.createStatement()) {
                comando.execute("insert into tblGeneros values('0','" + genero + "')");
            }
            conexion.close();
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public static String buscarMarca(int idmarca) {
        String marca = "";
        Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            try (Statement comando = (Statement)conexion.createStatement(); 
                    ResultSet dato = comando.executeQuery("SELECT marca FROM tblMarcas WHERE idMarca = '" + idmarca + "'")) {
                    dato.next();
                    marca = dato.getString("marca");
            dato.close();
            comando.close();
            conexion.close();
            return marca;
            }
        }
        catch (SQLException exp) {
            return marca;
        }
    }
    
    public static String buscarTipoProducto(int idtipo) {
        String tipo = "";
        Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            try (Statement comando = (Statement)conexion.createStatement(); 
                    ResultSet dato = comando.executeQuery("SELECT tipoproducto FROM tblTipoProductos WHERE idTipoProducto = '" + idtipo + "'")) {
                    dato.next();
                    tipo = dato.getString("tipoproducto");
            dato.close();
            comando.close();
            conexion.close();
            return tipo;
            }
        }
        catch (SQLException exp) {
            return tipo;
        }
    }
    
    public static int buscarIdProducto(String codigoProducto) {
        int idProducto = -1;
        Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            try (Statement comando = (Statement)conexion.createStatement(); 
                    ResultSet dato = comando.executeQuery("SELECT idProducto FROM tblProductos WHERE codigoProducto = '" + codigoProducto + "'")) {
                    dato.next();
                    idProducto = dato.getInt("idProducto");
            dato.close();
            comando.close();
            conexion.close();
            return idProducto;
            }
        }
        catch (SQLException ex)
        {
            return idProducto;
        }
    }
    
    public static int buscarIdProductoDisponible(String codigoProducto) {
        int idProducto = 0;
        Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            try (Statement comando = (Statement)conexion.createStatement(); 
                    ResultSet dato = comando.executeQuery("SELECT idProducto FROM tblProductos WHERE codigoProducto = '" + codigoProducto + "' AND idEstadoProducto = '1'")) {
                    dato.next();
                    idProducto = dato.getInt("idProducto");
            dato.close();
            comando.close();
            conexion.close();
            return idProducto;
            }

        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Producto no Disponible");
            return idProducto;
        }
    }
    
    public static int buscarIdProductoTransaccion(String codigoProducto) {
        int idProducto = 0;
        Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            try (Statement comando = (Statement)conexion.createStatement(); 
                    ResultSet dato = comando.executeQuery("SELECT idProducto FROM tblProductos WHERE codigoProducto = '" + codigoProducto + "'")) {
                    dato.next();
                    idProducto = dato.getInt("idProducto");
            dato.close();
            comando.close();
            conexion.close();
            return idProducto;
            }

        }
        catch (SQLException ex)
        {
            return idProducto;
        }
    }
    
    public static void cambiarEstadoProducto(int idProducto, int estado) {
        Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            try (Statement comando = (Statement)conexion.createStatement()) {
                comando.executeUpdate("UPDATE tblProductos SET idEstadoProducto = '" + estado + "' where idProducto = '" + idProducto + "'");
            }
            conexion.close();
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public static double obtenerPrecioVentaProducto(int idProducto) {
        double precio = 0;
        Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            try (Statement comando = (Statement)conexion.createStatement(); 
                    ResultSet dato = comando.executeQuery("SELECT precioVentaFinal FROM tblProductos WHERE idProducto = '" + idProducto + "'")) {
                    dato.next();
                    precio = dato.getDouble("precioVentaFinal");
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
    
    public static void actualizarPreciosFinales(int idProducto, double porcentaje, int tipoPrecio) {
        DecimalFormat df = new DecimalFormat("0.00");
        if (tipoPrecio == 1) {
            double precioFinal;
            double descuento;
            Connection conexion = ConexionDB.ObtenerConexion();
            try
            {
                try (Statement comando = (Statement)conexion.createStatement(); 
                        ResultSet dato = comando.executeQuery("SELECT precioOfertado FROM tblProductos WHERE idProducto = '" + idProducto + "'")) {
                        dato.next();
                        double precio = dato.getDouble("precioOfertado");
                        precioFinal = Double.parseDouble(df.format(precio * (100-porcentaje)/100));
                        descuento = Double.parseDouble(df.format(precio - precioFinal));
                comando.executeUpdate("UPDATE tblProductos SET porcentajeOfertaVenta = '" + porcentaje + "', descuentoVenta = '" + descuento + "', precioVentaFinal = '" + precioFinal + "' WHERE idProducto = '" + idProducto + "'");
                dato.close();
                comando.close();
                conexion.close();
                }

            }
            catch (SQLException ex)
            {
                JOptionPane.showMessageDialog(null, ex.toString());
            }
        } 
        else {
            double precioFinal;
            double descuento;
            Connection conexion = ConexionDB.ObtenerConexion();
            try
            {
                try (Statement comando = (Statement)conexion.createStatement(); 
                        ResultSet dato = comando.executeQuery("SELECT precioOfertadoSugerido FROM tblProductos WHERE idProducto = '" + idProducto + "'")) {
                        dato.next();
                        double precio = dato.getDouble("precioOfertadoSugerido");
                        precioFinal = Double.parseDouble(df.format(precio * (100-porcentaje)/100));
                        descuento = Double.parseDouble(df.format(precio - precioFinal));
                        comando.executeUpdate("UPDATE tblProductos SET porcentajeOfertaVenta = '" + porcentaje + "', descuentoVenta = '" + descuento + "', precioVentaFinal = '" + precioFinal + "' WHERE idProducto = '" + idProducto + "'");
                dato.close();
                comando.close();
                conexion.close();
                }

            }
            catch (SQLException ex)
            {
                JOptionPane.showMessageDialog(null, "error");
            }
        }
    }
    
    public static Productos obtenerProducto(String codigoProducto)
    {
        Productos producto = null;
        Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            try (Statement comando = (Statement)conexion.createStatement(); 
                    ResultSet dato = comando.executeQuery("SELECT * FROM tblProductos WHERE codigoProducto = '" + codigoProducto + "'")) {
                    dato.next();
                    producto = new Productos();
                    producto.setCodigo(dato.getString("codigoProducto"));
                    producto.setMarca(dato.getInt("idMarca"));
                    producto.setTipoProducto(dato.getInt("idTipoProducto"));
                    producto.setTalla(dato.getInt("idTalla"));
                    producto.setGenero(dato.getInt("idGenero"));
                    producto.setColor(dato.getString("colorProducto"));
                    producto.setDescripcion(dato.getString("descripcionProducto"));
                    producto.setPrecioDolar(dato.getDouble("costoDolares"));
                    producto.setImpuestoProducto(dato.getDouble("impuestoProducto"));
                    producto.setEnvioProducto(dato.getDouble("envioProducto"));
                    producto.setPrecioCostoDolar(dato.getDouble("totalDolares"));
                    producto.setTipoCambio(dato.getDouble("tipoCambio"));
                    producto.setEnvioGt(dato.getDouble("envioGuate"));
                    producto.setPrecioCostoQuetzal(dato.getDouble("totalQuetzales"));
                    producto.setPorcentajeGanancia(dato.getDouble("porcentajeGanancia"));
                    producto.setGananciaEstimada(dato.getDouble("gananciaEstimada"));
                    producto.setPrecioVenta(dato.getDouble("precioVenta"));
                    producto.setPorcentajeGananciaSugerida(dato.getDouble("porcentajeGananciaSugerida"));
                    producto.setGananciaSugerida(dato.getDouble("gananciaSugerida"));
                    producto.setPrecioSugeridoVendedor(dato.getDouble("precioSugerido"));
                    
            dato.close();
            comando.close();
            conexion.close();
            return producto;
            }

        }
        catch (SQLException ex)
        {
            return null;
        }
    }
    
    public static void ofertarProducto(Productos p) {
        Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            try (Statement comando = (Statement)conexion.createStatement()) {
                comando.executeUpdate("UPDATE tblProductos SET porcentajeOferta = '" + p.getPorcentajeOferta() + "', descuentoOferta = '" + p.getDescuentoOferta() + "', precioOfertado = '" + p.getPrecioOfertado() + "', precioOfertadoSugerido = '" + p.getPrecioOfertadoSugerido() + "' WHERE codigoProducto = '" + p.getCodigo() + "'");
            }
            conexion.close();
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
