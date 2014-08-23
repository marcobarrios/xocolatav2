/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Querys;

import Clases.Gastos;
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
public class GastoQuerys {
    
    public static void ingresarGasto(Gastos gasto)
    {
        Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            Statement comando = (Statement)conexion.createStatement();
            comando.execute("insert into tblGastos values('0','" + gasto.getGasto() + "','" + gasto.getFecha() + "','" + gasto.getIdTipoGasto() + "')");
            JOptionPane.showMessageDialog(null, "Gasto cargado correctamente", "Registro de Gasto Exitoso", 1);
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
