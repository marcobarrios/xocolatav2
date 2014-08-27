/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Querys;

import Clases.*;
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
 * @author Equipo
 */
public class PersonaQuerys {
    
    public static void insertarPersona(Personas persona) {
        Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            Statement comando = (Statement)conexion.createStatement();
            comando.execute("insert into tblPersonas values('0','','" + persona.getNombre() + "','" + persona.getDpi() + "','" + persona.getDireccion() + "','" + persona.getCorreo() + "','0.0','" + persona.getIdTipoPersona() + "')");
            ResultSet dato = comando.executeQuery("select MAX(idPersona) from tblPersonas"); 
            dato.next();
            String id = dato.getString("MAX(idPersona)");
            comando.execute("insert into tblContactoPersonas values('0','" + persona.getTelefono() + "','" + id + "')");
            JOptionPane.showMessageDialog(null, " Ingresado correctamente", "Ingreso Exitoso", 1);
            dato.close();
            comando.close();
            conexion.close();
        }
        catch (HeadlessException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
public static Personas consultarPersona(String nombrePersona, String tipoPersona) {
        Connection conexion = ConexionDB.ObtenerConexion();
        Personas persona = null;
        try
        {
            Statement comando = (Statement)conexion.createStatement();
            ResultSet dato = comando.executeQuery("select * from tblPersonas where nombrePersona='"+ nombrePersona +"' AND idTipoPersona='"+ Integer.parseInt(tipoPersona)+"'"); 
            dato.next();
            persona = new Personas();
            persona.setNombre(dato.getString("nombrePersona"));
            persona.setDpi(dato.getString("dpiPersona"));
            persona.setCorreo(dato.getString("correoPersona"));
            persona.setDireccion(dato.getString("direccionPersona"));
            int id = dato.getInt("idPersona");
            dato = comando.executeQuery("select * from tblContactoPersonas where idPersona='"+ id +"'");
            dato.next();
            persona.setTelefono(dato.getString("contactoPersona"));
            comando.close();
            conexion.close();
        }
        catch (NumberFormatException ex)
        {
            return null;
        } catch (SQLException ex) {
            return null;
        }
        return persona;
    }
    
    public static void editarPersona(Personas p)
    {
        Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            Statement comando = (Statement)conexion.createStatement();
            ResultSet dato = comando.executeQuery("select idPersona from tblPersonas where nombrePersona='"+ p.getNombre() +"' AND idTipoPersona='"+ p.getIdTipoPersona()+"'"); 
            dato.next();
            int id = dato.getInt("idPersona");
            comando.execute("Update tblPersonas SET dpiPersona='"+p.getDpi()+"', correoPersona='"+p.getCorreo()+"', direccionPersona='"+p.getDireccion()+"' where idPersona='"+id+"'");
            comando.execute("Update tblContactoPersonas SET contactoPersona='"+p.getTelefono()+"' where idPersona='"+id+"'");
            JOptionPane.showMessageDialog(null, "Edición Exitoso", "Cambio Exitoso", 1);
            comando.close();
            conexion.close();
        }
        catch (HeadlessException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public static void ingresarContacto(String idPersona, String telefono) {
        Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            Statement comando = (Statement)conexion.createStatement();
            comando.execute("insert into tblTelefonoPersonas values('0','" + idPersona + "', '" + telefono + "')");
            JOptionPane.showMessageDialog(null, "Telefono Ingresado correctamente", "Ingreso Exitoso", 1);
            comando.close();
            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public static String consultarSaldo(String idPersona) {
        Connection conexion = ConexionDB.ObtenerConexion();
        String saldo =null;
        try
        {
            Statement comando = (Statement)conexion.createStatement();
            ResultSet dato = comando.executeQuery("select saldoPersona from tblPersonas where idPersona='"+ idPersona +"'"); 
            dato.next();
            saldo = dato.getString("saldoPersona");
            comando.close();
            conexion.close();
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return saldo;
    }
    
    public static void cargarAbono(Double abono,String fecha, String id)
    {
        Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            Statement comando = (Statement)conexion.createStatement();
            comando.execute("insert into tblAbonoPersonas values('0','" + abono + "','" + fecha + "','" + id + "')");
            JOptionPane.showMessageDialog(null, "Abono cargado correctamente", "Abono Exitoso", 1);
            comando.close();
            conexion.close();
        }
        catch (HeadlessException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        actualizarSaldo(abono,id);
    }
    
    public static void actualizarSaldo(Double abono, String idPersona)
    {
        Connection conexion = ConexionDB.ObtenerConexion();
        String saldo =null;
        try
        {
            Statement comando = (Statement)conexion.createStatement();
            ResultSet dato = comando.executeQuery("select saldoPersona from tblPersonas where idPersona='"+ idPersona +"'"); 
            dato.next();
            saldo = dato.getString("saldoPersona");
            DecimalFormat df = new DecimalFormat("0.00");
            double resta = Double.parseDouble(saldo)-abono;
            comando.close();
            Statement comando2 = (Statement)conexion.createStatement();
            comando2.executeUpdate("update tblPersonas SET saldoPersona ='"+df.format(resta)+"' where idPersona='"+idPersona+"'");
            comando2.close();
            conexion.close();
        }
        catch (NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }
    
    public static void cargarSaldo(String idPersona, Double cargo) {
        Connection conexion = ConexionDB.ObtenerConexion();
        int existencia = 0;
        try
        {
            Statement comando = (Statement)conexion.createStatement();
            ResultSet dato = comando.executeQuery("select saldoPersona from tblPersonas where idPersona = '" + idPersona + "'"); 
            dato.next();
            Double saldo = dato.getDouble("saldoPersona");
            DecimalFormat df = new DecimalFormat("0.00");
            Double total = saldo + cargo;
            comando.executeUpdate("UPDATE tblPersonas SET saldoPersona = '" + total + "' where idPersona = '" + idPersona + "'");
            dato.close();
            comando.close();
            conexion.close();
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}

