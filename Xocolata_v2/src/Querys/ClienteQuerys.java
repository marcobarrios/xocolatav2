/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Querys;

import Clases.Clientes;
import Clases.Vendedores;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import xocolata_v2.ConexionDB;

/**
 *
 * @author Marco
 */
public class ClienteQuerys {
    
    public static void insertarCliente(Clientes cliente) {
        Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            Statement comando = (Statement)conexion.createStatement();
            comando.execute("insert into tblClientes values('0','" + cliente.getNombre() + "','" + cliente.getDpi() + "','" + cliente.getDireccion() + "','" + cliente.getTelefono() + "','" + cliente.getSaldo() + "')");
            JOptionPane.showMessageDialog(null, "Cliente Ingresado Correctamente", "Ingreso Exitoso", 1);
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
    
    public static void editarClientes(Clientes p)
    {
        Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            Statement comando = (Statement)conexion.createStatement();
            ResultSet dato = comando.executeQuery("select idCliente from tblClientes where nombreCliente='"+ p.getNombre() + "'"); 
            dato.next();
            int id = dato.getInt("idCliente");
            comando.execute("Update tblClientes SET dpi='" + p.getDpi() + "', telefonoCliente = '" + p.getTelefono() + "', direccionCliente = '" + p.getDireccion() + "' where idCliente='" + id + "'");
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
    
    public static Clientes consultarVendedor(String nombre) {
        Connection conexion = ConexionDB.ObtenerConexion();
        Clientes persona = null;
        try
        {
            try (Statement comando = (Statement)conexion.createStatement()) {
                ResultSet dato = comando.executeQuery("select * from tblClientes where nombreCliente = '" + nombre + "'");
                dato.next();
                persona = new Clientes();
                persona.setNombre(dato.getString("nombreCliente"));
                persona.setDpi(dato.getString("dpi"));
                //persona.setCorreo(dato.getString("correoPersona"));
                persona.setDireccion(dato.getString("direccionCliente"));
                persona.setTelefono(dato.getString("telefonoCliente"));
            }
            conexion.close();
        }
        catch (NumberFormatException | SQLException ex)
        {
            return null;
        }
        return persona;
    }
}
