/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaces;

import ContenedorComboBox.Item;
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
public class VentanaSeleccionDatos extends javax.swing.JInternalFrame {

    String opcion;
    /**
     * Creates new form VentanaSeleccionDatos
     * @param opcion
     */
    public VentanaSeleccionDatos(String opcion) {
        initComponents();
        cargarDatos();
        this.opcion = opcion;
    }

        public void cargarDatos() {
        ResultSet dato = null;
        Connection conexion = ConexionDB.ObtenerConexion();
        if(opcion.equals("VentaVendedorEspecifico"))
        {    
            try
            {
                 Statement comando = (Statement)conexion.createStatement();
                 dato = comando.executeQuery("Select idPersona, nombrePersona from tblPersonas where idTipoPersona='1' ORDER BY nombrePersona");
                 while(dato.next())
                 {
                     Item vendedor = new Item(dato.getString("idPersona"), dato.getString("nombrePersona"));
                     jComboBox1.addItem(vendedor);
                 }
                 dato.close();
                 comando.close();
                 conexion.close();
             }
             catch (SQLException ex)
             {
                 JOptionPane.showMessageDialog(null, ex.getMessage());
             }
        }
        else if(opcion.equals("VentaClienteEspecifico"))
        {    
            try
            {
                 Statement comando = (Statement)conexion.createStatement();
                 dato = comando.executeQuery("Select idPersona, nombrePersona from tblPersonas where idTipoPersona='2' ORDER BY nombrePersona");
                 while(dato.next())
                 {
                     Item vendedor = new Item(dato.getString("idPersona"), dato.getString("nombrePersona"));
                     jComboBox1.addItem(vendedor);
                 }
                 dato.close();
                 comando.close();
                 conexion.close();
             }
             catch (SQLException ex)
             {
                 JOptionPane.showMessageDialog(null, ex.getMessage());
             }
        }
        else if(opcion.equals("ProductosMarca"))
        {
            try
            {
                 Statement comando = (Statement)conexion.createStatement();
                 dato = comando.executeQuery("Select idMarca, Marca from tblMarcas ORDER BY Marca");
                 while(dato.next())
                 {
                     Item vendedor = new Item(dato.getString("idMarca"), dato.getString("Marca"));
                     jComboBox1.addItem(vendedor);
                 }
                 dato.close();
                 comando.close();
                 conexion.close();
             }
             catch (SQLException ex)
             {
                 JOptionPane.showMessageDialog(null, ex.getMessage());
             }
        }
        else if(opcion.equals("ProductosTipo"))
        {
            try
            {
                 Statement comando = (Statement)conexion.createStatement();
                 dato = comando.executeQuery("Select idTipoProducto, TipoProducto from tblTipoProductos ORDER BY tipoProducto");
                 while(dato.next())
                 {
                     Item vendedor = new Item(dato.getString("idTipoProducto"), dato.getString("TipoProducto"));
                     jComboBox1.addItem(vendedor);
                 }
                 dato.close();
                 comando.close();
                 conexion.close();
             }
             catch (SQLException ex)
             {
                 JOptionPane.showMessageDialog(null, ex.getMessage());
             }
        }
        else if(opcion.equals("ProductosTalla"))
        {
            try
            {
                 Statement comando = (Statement)conexion.createStatement();
                 dato = comando.executeQuery("Select idTalla, Talla from tblTallas ORDER BY Talla");
                 while(dato.next())
                 {
                     Item vendedor = new Item(dato.getString("idTalla"), dato.getString("Talla"));
                     jComboBox1.addItem(vendedor);
                 }
                 dato.close();
                 comando.close();
                 conexion.close();
             }
             catch (SQLException ex)
             {
                 JOptionPane.showMessageDialog(null, ex.getMessage());
             }
        }
        else if(opcion.equals("PersonaVendedor"))
        {
            try
            {
                 Statement comando = (Statement)conexion.createStatement();
                 dato = comando.executeQuery("Select idPersona, nombrePersona from tblPersonas WHERE idTipoPersona = '1' ORDER BY nombrePersona");
                 while(dato.next())
                 {
                     Item vendedor = new Item(dato.getString("idPersona"), dato.getString("nombrePersona"));
                     jComboBox1.addItem(vendedor);
                 }
                 dato.close();
                 comando.close();
                 conexion.close();
             }
             catch (SQLException ex)
             {
                 JOptionPane.showMessageDialog(null, ex.getMessage());
             }
        }
        else if(opcion.equals("PersonaCliente"))
        {
            try
            {
                 Statement comando = (Statement)conexion.createStatement();
                 dato = comando.executeQuery("Select idPersona, nombrePersona from tblPersonas WHERE idTipoPersona = '2' ORDER BY nombrePersona");
                 while(dato.next())
                 {
                     Item vendedor = new Item(dato.getString("idPersona"), dato.getString("nombrePersona"));
                     jComboBox1.addItem(vendedor);
                 }
                 dato.close();
                 comando.close();
                 conexion.close();
             }
             catch (SQLException ex)
             {
                 JOptionPane.showMessageDialog(null, ex.getMessage());
             }
        }
        else if(opcion.equals("GastoEspecifico"))
        {
            try
            {
                 Statement comando = (Statement)conexion.createStatement();
                 dato = comando.executeQuery("Select idTipoGasto, TipoGasto from tblTipoGastos ORDER BY TipoGasto");
                 while(dato.next())
                 {
                     Item vendedor = new Item(dato.getString("idTipoGasto"), dato.getString("TipoGasto"));
                     jComboBox1.addItem(vendedor);
                 }
                 dato.close();
                 comando.close();
                 conexion.close();
             }
             catch (SQLException ex)
             {
                 JOptionPane.showMessageDialog(null, ex.getMessage());
             }
        }
        else if(opcion.equals("AbonoVendedorEspecifico"))
        {
            try
            {
                 Statement comando = (Statement)conexion.createStatement();
                 dato = comando.executeQuery("Select idPersona, nombrePersona from tblPersonas WHERE idTipoPersona = '1' ORDER BY nombrePersona");
                 while(dato.next())
                 {
                     Item vendedor = new Item(dato.getString("idPersona"), dato.getString("nombrePersona"));
                     jComboBox1.addItem(vendedor);
                 }
                 dato.close();
                 comando.close();
                 conexion.close();
             }
             catch (SQLException ex)
             {
                 JOptionPane.showMessageDialog(null, ex.getMessage());
             }
        }
        else if(opcion.equals("AbonoClienteEspecifico"))
        {
            try
            {
                 Statement comando = (Statement)conexion.createStatement();
                 dato = comando.executeQuery("Select idPersona, nombrePersona from tblPersonas WHERE idTipoPersona = '2' ORDER BY nombrePersona");
                 while(dato.next())
                 {
                     Item vendedor = new Item(dato.getString("idPersona"), dato.getString("nombrePersona"));
                     jComboBox1.addItem(vendedor);
                 }
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

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(169, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBox1;
    // End of variables declaration//GEN-END:variables
}
