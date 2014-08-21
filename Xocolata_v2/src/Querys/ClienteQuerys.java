/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Querys;

import Clases.Clientes;
import java.awt.HeadlessException;
import java.sql.Connection;
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
    
}
