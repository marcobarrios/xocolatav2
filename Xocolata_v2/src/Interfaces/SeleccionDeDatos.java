/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaces;

import ContenedorComboBox.Item;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import xocolata_v2.ConexionDB;
import xocolata_v2.Rinventario;

/**
 *
 * @author Equipo
 */
public class SeleccionDeDatos extends javax.swing.JInternalFrame {

    /**
     * Creates new form SeleccionDeDatos
     */
    String opcion;
    public SeleccionDeDatos(String opcion) {
        initComponents();
        this.opcion = opcion;
        lTitulo.setText("Seleccion de: " + opcion);
        this.setFrameIcon(new ImageIcon(this.getClass().getResource("/16x16/logo.png")));
        cargarDatos();
    }

    public void cargarDatos() {
        ResultSet dato = null;
        Connection conexion = ConexionDB.ObtenerConexion();
        if(opcion.equals("Vendedor"))
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
        else if(opcion.equals("Cliente"))
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
        else if(opcion.equals("Fabricante"))
        {
            try
            {
                 Statement comando = (Statement)conexion.createStatement();
                 dato = comando.executeQuery("Select idFabricante, nombreFabricante from tblFabricantes ORDER BY nombreFabricante");
                 while(dato.next())
                 {
                     Item vendedor = new Item(dato.getString("idFabricante"), dato.getString("nombreFabricante"));
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
        else if(opcion.equals("Producto"))
        {
            try
            {
                 Statement comando = (Statement)conexion.createStatement();
                 dato = comando.executeQuery("Select idnombre, nombreProducto from tblnombreProductos ORDER BY nombreProducto");
                 while(dato.next())
                 {
                     Item vendedor = new Item(dato.getString("idNombre"), dato.getString("nombreProducto"));
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
        else if(opcion.equals("Tipo Producto"))
        {
            try
            {
                 Statement comando = (Statement)conexion.createStatement();
                 dato = comando.executeQuery("Select idTipo, nombreTipo from tblTipos ORDER BY nombreTipo");
                 while(dato.next())
                 {
                     Item vendedor = new Item(dato.getString("idTipo"), dato.getString("nombreTipo"));
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
        else if(opcion.equals("Genero"))
        {
            try
            {
                 Statement comando = (Statement)conexion.createStatement();
                 dato = comando.executeQuery("Select idGenero, nombreGenero from tblGeneros ORDER BY nombreGenero");
                 while(dato.next())
                 {
                     Item vendedor = new Item(dato.getString("idGenero"), dato.getString("nombreGenero"));
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        lTitulo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel1.setText("Seleccione: ");

        jComboBox1.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N

        lTitulo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lTitulo.setText("Seleccion de ");

        jButton1.setText("Generar Reporte");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(lTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jButton1)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lTitulo)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generarReporte() throws PropertyVetoException {
         if(this.opcion.equals("Vendedor"))
        {
            Item item = (Item)jComboBox1.getSelectedItem();
            Rinventario Rinv=new Rinventario(item.getId(),"src\\Reportes\\.jasper");
            this.getParent().add(Rinv);        
            Rinv.show();
            Rinv.setSelected(true);
        }
        this.dispose();
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            generarReporte();
        } catch (PropertyVetoException ex) {
            JOptionPane.showMessageDialog(this, ex.toString());
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lTitulo;
    // End of variables declaration//GEN-END:variables
}
