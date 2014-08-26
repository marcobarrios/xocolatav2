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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import xocolata_v2.ConexionDB;

/**
 *
 * @author Rosario
 */
public class ProductoQuerys {
    
    public static String insertarProducto(Productos producto)
    {
        String idProducto = "";
        try {
            try (Connection conexion = ConexionDB.ObtenerConexion()) {
                PreparedStatement ps = null;
                ps = conexion.prepareStatement("INSERT INTO `tblproductos`(`idProducto`, `codigoProducto`, `idMarca`, `idTipoProducto`, `idTalla`, `idGenero`, `colorProducto`, `descripcionProducto`, `idEstadoProducto`, `idPedido`) VALUES (?,?,?,?,?,?,?,?,?,?)");
                ps.setInt(1, 0);
                ps.setString(2, "0");
                ps.setInt(3, producto.getMarca());
                ps.setInt(4, producto.getTipoProducto());
                ps.setInt(5, producto.getTalla());
                ps.setInt(6, producto.getGenero());
                ps.setString(7, producto.getColor());
                ps.setString(8, producto.getDescripcion());
                ps.setString(9, "1");
                ps.setInt(10, producto.getIdPedido());
                ps.executeUpdate();
                //JOptionPane.showMessageDialog(null, "Producto ingresado correctamente", "Ingreso Exitoso", 1);
                ResultSet dato = ps.executeQuery("select MAX(idProducto) from tblProductos"); 
                dato.next();
                idProducto = dato.getString("MAX(idProducto)");
                dato.close();
                ps.close();
                conexion.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoQuerys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idProducto;
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
}
