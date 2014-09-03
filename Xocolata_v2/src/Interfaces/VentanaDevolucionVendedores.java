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
import javax.swing.DefaultListCellRenderer;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import xocolata_v2.ConexionDB;

/**
 *
 * @author Marco
 */
public class VentanaDevolucionVendedores extends javax.swing.JInternalFrame {

    int idTransaccion;
    /**
     * Creates new form VentanaDevolucionVendedores
     */
    public VentanaDevolucionVendedores() {
        initComponents();
        cargarDatosVendedor();
        
        DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
        dlcr.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
        cbTransaccion.setRenderer(dlcr);
        cbVendedor.setRenderer(dlcr);
    }

    private void cargarDatosVendedor() {
        ResultSet dato = null;
        Connection conexion = ConexionDB.ObtenerConexion();
            try
            {
            try (Statement comando = (Statement)conexion.createStatement()) {
                dato = comando.executeQuery("Select idPersona, nombrePersona from tblPersonas WHERE idTipoPersona = '1' ORDER BY nombrePersona");
                while(dato.next())
                {
                    Item vendedor = new Item(dato.getString("idPersona"), dato.getString("nombrePersona"));
                    cbVendedor.addItem(vendedor);
                }
                dato.close();
            }
            conexion.close();
            }
            catch (SQLException ex)
            {
               JOptionPane.showMessageDialog(null, ex.getMessage());
            }
    }
    
    private void cargarDatosTransaccion() {
        Item gasto = (Item)cbVendedor.getSelectedItem();
        int id = Integer.parseInt(gasto.getId());
        cbTransaccion.removeAllItems();
        ResultSet dato = null;
        Connection conexion = ConexionDB.ObtenerConexion();
            try
            {
            try (Statement comando = (Statement)conexion.createStatement()) {
                dato = comando.executeQuery("Select idTransaccion, codigoTransaccion from tblTransacciones WHERE idPersona = '" + id + "' ORDER BY idTransaccion DESC");
                while(dato.next())
                {
                    Item transaccion = new Item(dato.getString("idTransaccion"), dato.getString("codigoTransaccion"));
                    cbTransaccion.addItem(transaccion);
                }
                dato.close();
            }
            conexion.close();
            }
            catch (SQLException ex)
            {
               JOptionPane.showMessageDialog(null, ex.getMessage());
            }
    }

    private void cargarTablaProductosTransaccion() {
        this.setVisible(true);
        
        String[] titulos={"Codigo","Marca","Tipo Producto","Talla","Genero","Color","Precio Venta","Precio Sugerido"};
        Object[] registros = new Object[8];      
        DefaultTableModel model= new DefaultTableModel(null,titulos){@Override
        public boolean isCellEditable(int rowIndex,int columnIndex){return false;} };
        Connection conexion = ConexionDB.ObtenerConexion();            
        if(conexion!=null)
        {
            try
            {
                Statement Query = conexion.createStatement();            
                ResultSet Datos = Query.executeQuery("SELECT tblProductos.idProducto, tblProductos.codigoProducto, tblMarcas.Marca, tblTipoProductos.TipoProducto, tblTallas.Talla, tblGeneros.Genero, tblProductos.colorProducto, tblProductos.precioVenta, tblProductos.precioSugerido FROM tblProductos "
                        + "INNER JOIN tblMarcas on tblProductos.idMarca = tblMarcas.idMarca "
                        + "INNER JOIN tblTipoProductos on tblProductos.idTipoProducto = tblTipoProductos.idTipoProducto "
                        + "INNER JOIN tblTallas on tblProductos.idTalla = tblTallas.idTalla "
                        + "INNER JOIN tblGeneros on tblProductos.idGenero = tblGeneros.idGenero "
                        + "INNER JOIN tblDetalleTransacciones on tblDetalleTransacciones.idProducto = tblProductos.idProducto "
                        + "INNER JOIN tblTransacciones on tblTransacciones.idTransaccion = tblDetalleTransacciones.idTransaccion "
                        + "WHERE tblTransacciones.idTransaccion = '" + idTransaccion + "' ORDER BY tblProductos.codigoProducto ASC");
                Datos = Query.getResultSet();                    
                while (Datos.next()) 
                {
                    registros[0]=new Item(Datos.getString("tblProductos.idProducto"),Datos.getString("tblProductos.codigoProducto"));
                    registros[1]=Datos.getString("tblMarcas.Marca");
                    registros[2]=Datos.getString("tblTipoProductos.TipoProducto");
                    registros[3]=Datos.getString("tblTallas.Talla");
                    registros[4]=Datos.getString("tblGeneros.Genero");
                    registros[5]=Datos.getString("tblProductos.colorProducto");
                    registros[6]=Datos.getString("tblProductos.precioVenta");
                    registros[7]=Datos.getString("tblProductos.precioSugerido");
                    model.addRow(registros);
                }
                tblProductosTransaccion.setModel(model);
            }
            catch (SQLException exp) 
            {
                JOptionPane.showMessageDialog(null, exp.toString());
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

        jPanel1 = new javax.swing.JPanel();
        cbVendedor = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbTransaccion = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductosTransaccion = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbVendedor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbVendedorItemStateChanged(evt);
            }
        });

        jLabel1.setText("Seleccione Vendedor");

        jLabel2.setText("Transacción");

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbTransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(94, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(cbTransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        tblProductosTransaccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblProductosTransaccion);

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cargar a Ventas");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setText("Código del Producto:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbVendedorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbVendedorItemStateChanged
        cargarDatosTransaccion();
    }//GEN-LAST:event_cbVendedorItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Item transaccion = (Item)cbTransaccion.getSelectedItem();
        idTransaccion =  Integer.parseInt(transaccion.getId());
        cargarTablaProductosTransaccion();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbTransaccion;
    private javax.swing.JComboBox cbVendedor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblProductosTransaccion;
    // End of variables declaration//GEN-END:variables
}
