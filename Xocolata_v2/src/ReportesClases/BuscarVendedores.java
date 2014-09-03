/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ReportesClases;

import ContenedorComboBox.Item;
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
public class BuscarVendedores {

  
    public BuscarVendedores() {
        
    }
    
    public void llenarNombres(){
        String[] titulos={"Nombres Vendedores"};
        Object[] registros = new Object[1];
        DefaultTableModel model= new DefaultTableModel(null,titulos){public boolean isCellEditable(int rowIndex,int columnIndex){return false;} };
        Connection conexion = ConexionDB.ObtenerConexion(); 
        if(conexion!=null)
        {
            try
            {
                Statement Query = conexion.createStatement();            
                ResultSet Datos = Query.executeQuery("select nombrePersona from tblPersonas WHERE idTipoPersona = '1' order by nombrePersona");
                Datos = Query.getResultSet();                    
                while (Datos.next()) 
                {
                    registros[0]=Datos.getString("nombrePersona");
                    model.addRow(registros);                  
                }       
                VentanaDatosVendedores.tblNombres.setModel(model);
            }
            catch (SQLException exp) 
            {
                JOptionPane.showMessageDialog(null, "No Existe ningún Vendedor");
            }
        }
    }
    
    public void llenarFormulario(String nombre){
        Connection conexion = ConexionDB.ObtenerConexion();
         try
            {
                 Statement Query = conexion.createStatement();
                 ResultSet dato = Query.executeQuery("select codigoPersona, nombrePersona, dpiPersona, direccionPersona from tblPersonas where nombrePersona = '" + nombre + "'");
                 dato = Query.getResultSet();
                while (dato.next()) 
                {
                    VentanaDatosVendedores.codigo.setText(dato.getString("codigoPersona"));
                    VentanaDatosVendedores.nombre.setText(dato.getString("nombrePersona"));
                    VentanaDatosVendedores.dpi.setText(dato.getString("dpiPersona"));
                    VentanaDatosVendedores.direccion.setText(dato.getString("direccionPersona"));
                }
                 dato.close();
                 conexion.close();
                 llenarTelefonos(nombre);
             }
             catch (SQLException ex)
             {
                 JOptionPane.showMessageDialog(null, "Error");
             }
    }
    
    private void llenarTelefonos(String nombre){
        String[] titulos={"Teléfono(s)"};
        Object[] registros = new Object[1];
        DefaultTableModel model= new DefaultTableModel(null,titulos){public boolean isCellEditable(int rowIndex,int columnIndex){return false;} };
        Connection conexion = ConexionDB.ObtenerConexion(); 
        if(conexion!=null)
        {
            try
            {
                Statement Query = conexion.createStatement();            
                ResultSet Datos = Query.executeQuery("select contactoPersona from tblContactoPersonas " +
                                                     "inner join tblPersonas on tblContactoPersonas.idPersona = tblPersonas.idPersona " +
                                                     "where tblPersonas.nombrePersona = '" + nombre + "'");
                Datos = Query.getResultSet();                    
                while (Datos.next()) 
                {
                    registros[0]=Datos.getString("contactoPersona");
                    model.addRow(registros);                  
                }       
                VentanaDatosVendedores.tblTelefonos.setModel(model);
            }
            catch (SQLException exp) 
            {
                JOptionPane.showMessageDialog(null, "No Existe ningún Vendedor");
            }
        }
    }
}
