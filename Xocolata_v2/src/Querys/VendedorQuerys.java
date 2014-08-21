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
            Statement comando = (Statement)conexion.createStatement();
            comando.execute("insert into tblVendedores values('0','" + vendedor.getCodigo() + "','" + vendedor.getNombre() + "','" + vendedor.getDpi() + "','" + vendedor.getDireccion() + "','" + vendedor.getSaldo() + "')");
            ResultSet dato = comando.executeQuery("select MAX(idVendedor) from tblVendedores"); 
            dato.next();
            String id = dato.getString("MAX(idVendedor)");
            comando.execute("insert into tblContactoVendedor values('0','" + vendedor.getTelefono() + "','" + id + "')");
            JOptionPane.showMessageDialog(null, "Vendedor Ingresado Correctamente", "Ingreso Exitoso", 1);
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
