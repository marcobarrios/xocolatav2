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
import java.util.logging.Level;
import java.util.logging.Logger;
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
}
