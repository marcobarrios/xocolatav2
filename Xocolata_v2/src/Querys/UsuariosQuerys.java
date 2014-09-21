/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Querys;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import xocolata_v2.ConexionDB;

/**
 *
 * @author Enrique
 */
public class UsuariosQuerys {
    
    public static String consultarUsuario(String nombreUsuario)
    {
        Connection conexion = ConexionDB.ObtenerConexion();
        String pass = null;
        try
        {
            Statement comando = (Statement) conexion.createStatement();
            ResultSet dato = comando.executeQuery("Select password from tblUsuarios where usuario = '"+ nombreUsuario +"'" );
            dato.next();
            pass = dato.getString("password");
            dato.close();
            comando.close();
            conexion.close();
            return pass;
        }
        catch (Exception e)
                {
                    return null;
                }
        
    }
    
}
