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
    
    public static void cargarAbonoVendedor(Abonos abono)
    {
        Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            Statement comando = (Statement)conexion.createStatement();
            comando.execute("insert into tblAbonoVendedores values('0','" + abono.getFechaAbono() + "','" + abono.getMontoAbono() + "','" + abono.getIdPersona() + "')");
            JOptionPane.showMessageDialog(null, "Abono cargado correctamente", "Abono Exitoso", 1);
            comando.close();
            conexion.close();
            actualizarSaldoVendedor(abono.getMontoAbono(), abono.getIdPersona());
        }
        catch (HeadlessException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }
    
    public static void actualizarSaldoVendedor(Double abono, int idPersona)
    {
        Connection conexion = ConexionDB.ObtenerConexion();
        String saldo = "";
        try
        {
            DecimalFormat df;
            double nuevoSaldo; 
            try (Statement comando = (Statement)conexion.createStatement()) {
                ResultSet dato = comando.executeQuery("select saldoVendedor from tblVendedores where idVendedor='" + idPersona + "'");
                dato.next();
                saldo = dato.getString("saldoVendedor");
                df = new DecimalFormat("0.00");
                nuevoSaldo = Double.parseDouble(saldo) - abono;
            }
            try (Statement comando2 = (Statement)conexion.createStatement()) {
                comando2.executeUpdate("update tblVendedores SET saldoVendedor ='" + df.format(nuevoSaldo) + "' where idVendedor='" + idPersona + "'");
            }
            conexion.close();
        }
        catch (NumberFormatException | SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }
    
    public static void cargarAbonoCliente(Abonos abono)
    {
        Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            Statement comando = (Statement)conexion.createStatement();
            comando.execute("insert into tblAbonoClientes values('0','" + abono.getFechaAbono() + "','" + abono.getMontoAbono() + "','" + abono.getIdPersona() + "')");
            JOptionPane.showMessageDialog(null, "Abono cargado correctamente", "Abono Exitoso", 1);
            comando.close();
            conexion.close();
            actualizarSaldoCliente(abono.getMontoAbono(), abono.getIdPersona());
        }
        catch (HeadlessException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }
    
    public static void actualizarSaldoCliente(Double abono, int idPersona)
    {
        Connection conexion = ConexionDB.ObtenerConexion();
        String saldo = "";
        try
        {
            DecimalFormat df;
            double nuevoSaldo; 
            try (Statement comando = (Statement)conexion.createStatement()) {
                ResultSet dato = comando.executeQuery("select saldoCliente from tblClientes where idClientes='" + idPersona + "'");
                dato.next();
                saldo = dato.getString("saldoCliente");
                df = new DecimalFormat("0.00");
                nuevoSaldo = Double.parseDouble(saldo) - abono;
            }
            try (Statement comando2 = (Statement)conexion.createStatement()) {
                comando2.executeUpdate("update tblClientes SET saldoCliente ='" + df.format(nuevoSaldo) + "' where idCliente='" + idPersona + "'");
            }
            conexion.close();
        }
        catch (NumberFormatException | SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }   
    }
    
    public static double consultarSaldoVendedor(int idVendedor) {
        double saldo = 0.0;
        Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            Statement comando = (Statement)conexion.createStatement();
            ResultSet dato = comando.executeQuery("select saldoVendedor from tblVendedores where idVendedor = '" + idVendedor + "'"); 
            if (dato!=null)
            {
                dato.next();
                saldo = Double.parseDouble(dato.getString("saldoVendedor"));
                comando.close();
                conexion.close();
            }
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.toString());
            return 0.0;
        }
        return saldo;
    }
    
    public static double consultarSaldoCliente(int idCliente) {
        double saldo = 0.0;
        Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            Statement comando = (Statement)conexion.createStatement();
            ResultSet dato = comando.executeQuery("select saldoCliente from tblClientes where idCliente = '" + idCliente + "'"); 
            if (dato!=null)
            {
                dato.next();
                saldo = Double.parseDouble(dato.getString("saldoCliente"));
                comando.close();
                conexion.close();
            }
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.toString());
            return 0.0;
        }
        return saldo;
    }
}
