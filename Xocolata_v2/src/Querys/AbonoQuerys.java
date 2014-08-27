/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Querys;

import Clases.Abonos;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import xocolata_v2.ConexionDB;

/**
 *
 * @author Marco
 */
public class AbonoQuerys {
    
    public static void cargarAbono(Abonos abono)
    {
        Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            try (Statement comando = (Statement)conexion.createStatement()) {
                comando.execute("insert into tblAbonoPersonas values('0','" + abono.getMontoAbono() + "','" + abono.getFechaAbono() + "','" + abono.getIdPersona() + "')");
                JOptionPane.showMessageDialog(null, "Abono cargado correctamente", "Abono Exitoso", 1);
            }
            conexion.close();
            actualizarSaldo(abono.getMontoAbono(), abono.getIdPersona());
        }
        catch (HeadlessException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }
    
    public static void actualizarSaldo(Double abono, int idPersona)
    {
        Connection conexion = ConexionDB.ObtenerConexion();
        String saldo = "";
        try
        {
            DecimalFormat df;
            double nuevoSaldo; 
            try (Statement comando = (Statement)conexion.createStatement()) {
                ResultSet dato = comando.executeQuery("select saldoPersona from tblPersonas where idPersona = '" + idPersona + "'");
                dato.next();
                saldo = dato.getString("saldoPersona");
                df = new DecimalFormat("0.00");
                nuevoSaldo = Double.parseDouble(saldo) - abono;
            }
            try (Statement comando2 = (Statement)conexion.createStatement()) {
                comando2.executeUpdate("update tblPersonas SET saldoPersona ='" + df.format(nuevoSaldo) + "' where idPersona = '" + idPersona + "'");
            }
            conexion.close();
        }
        catch (NumberFormatException | SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }
       
    public static double consultarSaldo(int idPersona) {
        double saldo = 0.0;
        Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            Statement comando = (Statement)conexion.createStatement();
            ResultSet dato = comando.executeQuery("select saldoPersona from tblPersonas where idPersona = '" + idPersona + "'"); 
            if (dato!=null)
            {
                dato.next();
                saldo = Double.parseDouble(dato.getString("saldoPersona"));
            }
            dato.close();
            comando.close();
            conexion.close();
            return saldo;

        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.toString());
            return saldo;

        }
    }
}
