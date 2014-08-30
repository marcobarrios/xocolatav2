/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ReportesClases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import xocolata_v2.ConexionDB;

/**
 *
 * @author Gerson
 */
public class BuscarClientes {

  
    public BuscarClientes() {
        
    }
    
    public void llenarNombres(){
        String[] titulos={"Nombres Clientes"};
        Object[] registros = new Object[1];
        DefaultTableModel model= new DefaultTableModel(null,titulos){public boolean isCellEditable(int rowIndex,int columnIndex){return false;} };
        
        Connection conexion = ConexionDB.ObtenerConexion(); 
        if(conexion!=null)
        {
            try
            {
                Statement Query = conexion.createStatement();            
                ResultSet Datos = Query.executeQuery("select nombrePersona from tblPersonas where idTipoPersona = '2' order by nombrePersona");
                Datos = Query.getResultSet();                    
                while (Datos.next()) 
                {
                    registros[0]=Datos.getString("nombrePersona");
                    model.addRow(registros);                  
                }       
                VentanaDatosClientes.tblNombres.setModel(model);
            }
            catch (SQLException exp) 
            {
                JOptionPane.showMessageDialog(null, "No Existe ningún Cliente");
            }
        }
    }
    
    public void llenarFormulario(String nombre){
        Connection conexion = ConexionDB.ObtenerConexion();
         try
            {
                 Statement Query = conexion.createStatement();
                 ResultSet dato = Query.executeQuery("select nombrePersona, dpiPersona, direccionPersona from tblPersonas where nombrePersona = '" + nombre + "'");
                 dato = Query.getResultSet();
                while (dato.next()) 
                {
                    VentanaDatosClientes.nombre.setText(dato.getString("nombrePersona"));
                    VentanaDatosClientes.dpi.setText(dato.getString("dpiPersona"));
                    VentanaDatosClientes.direccion.setText(dato.getString("direccionPersona"));
                    //VentanaDatosClientes.telefono.setText(dato.getString("telefonoPersona"));
                }
                 dato.close();
                 conexion.close();
                 
             }
             catch (SQLException ex)
             {
                 JOptionPane.showMessageDialog(null, "Error");
             }
    }
    
    
}
