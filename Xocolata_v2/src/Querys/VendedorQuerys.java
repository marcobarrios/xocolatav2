/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Querys;

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
public class VendedorQuerys {
    
    public static void insertarVendedor(Vendedores vendedor) {
        Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            try (Statement comando = (Statement)conexion.createStatement()) {
                comando.execute("insert into tblVendedores values('0','" + vendedor.getCodigo() + "','" + vendedor.getNombre() + "','" + vendedor.getDpi() + "','" + vendedor.getDireccion() + "','" + vendedor.getSaldo() + "')");
                ResultSet dato = comando.executeQuery("select MAX(idVendedor) from tblVendedores");
                dato.next();
                String id = dato.getString("MAX(idVendedor)");
                comando.execute("insert into tblContactoVendedor values('0','" + vendedor.getTelefono() + "','" + id + "')");
                JOptionPane.showMessageDialog(null, "Vendedor Ingresado Correctamente", "Ingreso Exitoso", 1);
            }
            conexion.close();
        }
        catch (HeadlessException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }   
    
    public static void editarVendedor(Vendedores p)
    {
        Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            try (Statement comando = (Statement)conexion.createStatement()) {
                ResultSet dato = comando.executeQuery("select idVendedor from tblVendedores where nombreVendedor='"+ p.getNombre() + "'");
                dato.next();
                int id = dato.getInt("idVendedor");
                comando.execute("Update tblVendedores SET dpi='" + p.getDpi() + "', direccionVendedor='" + p.getDireccion()+"' where idVendedor='" + id + "'");
                comando.execute("Update tblcontactovendedor SET contacto = '" + p.getTelefono() + "' where idvendedor = '" + id + "' AND idcontacto = '1'");
                JOptionPane.showMessageDialog(null, "Edición Exitoso", "Cambio Exitoso", 1);
            }
            conexion.close();
        }
        catch (HeadlessException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public static Vendedores consultarVendedor(String nombre) {
        Connection conexion = ConexionDB.ObtenerConexion();
        Vendedores persona = null;
        try
        {
            try (Statement comando = (Statement)conexion.createStatement()) {
                ResultSet dato = comando.executeQuery("select * from tblVendedores INNER JOIN tblcontactovendedor on tblVendedores.idVendedor = tblcontactovendedor.idVendedor where nombreVendedor = '" + nombre + "'");
                dato.next();
                persona = new Vendedores();
                persona.setNombre(dato.getString("nombreVendedor"));
                persona.setDpi(dato.getString("dpi"));
                //persona.setCorreo(dato.getString("correoPersona"));
                persona.setDireccion(dato.getString("direccionVendedor"));
                int id = dato.getInt("idVendedor");
                dato = comando.executeQuery("select * from tblcontactovendedor where idVendedor = '" + id + "'");
                dato.next();
                persona.setTelefono(dato.getString("contacto"));
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
