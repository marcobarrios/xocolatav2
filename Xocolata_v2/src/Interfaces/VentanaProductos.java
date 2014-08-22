/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaces;

import ContenedorComboBox.Item;
import Querys.ProductoQuerys;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListCellRenderer;
import static javax.swing.GroupLayout.Alignment.CENTER;
import javax.swing.JOptionPane;
import xocolata_v2.ConexionDB;

/**
 *
 * @author Marco
 */
public class VentanaProductos extends javax.swing.JInternalFrame {

    /**
     * Creates new form VentanaProductos
     */
    public VentanaProductos() {
        initComponents();
        cargarCodigoPedidos();
        cargarMarcas();
        cargarTipos();
        cargarTallas();
        cargarGeneros();
        DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
        dlcr.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
        cbCodigoPedido.setRenderer(dlcr);
        cbMarca.setRenderer(dlcr);
        cbTipoProducto.setRenderer(dlcr);
        cbTalla.setRenderer(dlcr);
        cbGenero.setRenderer(dlcr);
    }
    
    private void cargarCodigoPedidos() {
        cbCodigoPedido.removeAllItems();
        ResultSet dato = null;
        Connection conexion = ConexionDB.ObtenerConexion();
            try
            {
                Statement comando = (Statement)conexion.createStatement();
                dato = comando.executeQuery("Select idPedido, codigoPedido from tblPedidos ORDER BY idPedido DESC");
                while(dato.next())
                {
                    Item pedido = new Item(dato.getString("idPedido"), dato.getString("codigoPedido"));
                    cbCodigoPedido.addItem(pedido);
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

    private void cargarMarcas() {
        ResultSet dato = null;
        Connection conexion = ConexionDB.ObtenerConexion();
        try
            {
                 cbMarca.removeAllItems();
                 cbMarca.addItem("- - - - Marca - - - -");
                 //MARCA 
                 Statement comando = (Statement)conexion.createStatement();
                 dato = comando.executeQuery("Select idMarca, Marca from tblMarcas ORDER BY Marca");
                 while(dato.next())
                 {
                     Item marca = new Item(dato.getString("idMarca"), dato.getString("Marca"));
                     cbMarca.addItem(marca);
                 }
                 dato.close();
                 comando.close();
                 conexion.close();
             }
             catch (SQLException ex)
             {
                 //JOptionPane.showMessageDialog(null, ex.getMessage());
             }
    }
    
    private void cargarTipos() {
        ResultSet dato = null;
        Connection conexion = ConexionDB.ObtenerConexion();
        try
            {
                 cbTipoProducto.removeAllItems();
                 cbTipoProducto.addItem("- - Tipo de Producto - -");
                 //MARCA 
                 Statement comando = (Statement)conexion.createStatement();
                 dato = comando.executeQuery("Select idTipoProducto, TipoProducto from tblTipoProductos ORDER BY TipoProducto");
                 while(dato.next())
                 {
                     Item tipos = new Item(dato.getString("idTipoProducto"), dato.getString("TipoProducto"));
                     cbTipoProducto.addItem(tipos);
                 }
                 dato.close();
                 comando.close();
                 conexion.close();
             }
             catch (SQLException ex)
             {
                 //JOptionPane.showMessageDialog(null, ex.getMessage());
             }
    }
    
    private void cargarTallas() {
        ResultSet dato = null;
        Connection conexion = ConexionDB.ObtenerConexion();
        try
            {
                 cbTalla.removeAllItems();
                 cbTalla.addItem("- - - - Talla - - - -");
                 //MARCA 
                 Statement comando = (Statement)conexion.createStatement();
                 dato = comando.executeQuery("Select idTalla, Talla from tblTallas ORDER BY Talla");
                 while(dato.next())
                 {
                     Item talla = new Item(dato.getString("idTalla"), dato.getString("Talla"));
                     cbTalla.addItem(talla);
                 }
                 dato.close();
                 comando.close();
                 conexion.close();
             }
             catch (SQLException ex)
             {
                 //JOptionPane.showMessageDialog(null, ex.getMessage());
             }
    }
    
    private void cargarGeneros() {
        ResultSet dato = null;
        Connection conexion = ConexionDB.ObtenerConexion();
        try
            {
                 cbGenero.removeAllItems();
                 cbGenero.addItem("- - - Género - - -");
                 //MARCA 
                 Statement comando = (Statement)conexion.createStatement();
                 dato = comando.executeQuery("Select idGenero, Genero from tblGenero ORDER BY Genero");
                 while(dato.next())
                 {
                     Item tipos = new Item(dato.getString("idGenero"), dato.getString("Genero"));
                     cbGenero.addItem(tipos);
                 }
                 dato.close();
                 comando.close();
                 conexion.close();
             }
             catch (SQLException ex)
             {
                 //JOptionPane.showMessageDialog(null, ex.getMessage());
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

        cbCodigoPedido = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductosPedido = new javax.swing.JTable();
        cbMarca = new javax.swing.JComboBox();
        cbTipoProducto = new javax.swing.JComboBox();
        cbTalla = new javax.swing.JComboBox();
        cbGenero = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        cbCodigoPedido.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Ingreso de Productos");

        jLabel2.setText("Seleccione Código de Pedido");

        tblProductosPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblProductosPedido);

        cbMarca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Marca" }));

        cbTipoProducto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tipo de Producto" }));

        cbTalla.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Talla" }));

        cbGenero.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Género" }));

        jButton1.setText("+");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("+");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("+");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("+");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel8.setText("Descripción");

        jTextArea1.setColumns(15);
        jTextArea1.setRows(5);
        jTextArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane2.setViewportView(jTextArea1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jTable1);

        jLabel9.setText("Color");

        jButton5.setBackground(new java.awt.Color(51, 204, 0));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Ingresar Precios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(321, 321, 321)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(cbMarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbTipoProducto, javax.swing.GroupLayout.Alignment.LEADING, 0, 150, Short.MAX_VALUE)
                                            .addComponent(cbTalla, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton1)
                                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cbGenero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton4))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField1)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbCodigoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCodigoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton1)
                                    .addComponent(cbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton2)
                                    .addComponent(cbTipoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton3)
                                    .addComponent(cbTalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton4)
                                    .addComponent(cbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String marca = JOptionPane.showInputDialog(null, "Ingrese Marca: ", "Marca", 1);
        if(marca!=null)
        {
            ProductoQuerys.insertarMarca(marca);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String tipo = JOptionPane.showInputDialog(null, "Ingrese Tipo de Producto: ", "Tipo de Producto", 1);
        if(tipo!=null)
        {
            ProductoQuerys.insertarTipoProducto(tipo);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String talla = JOptionPane.showInputDialog(null, "Ingrese Talla: ", "Talla", 1);
        if(talla!=null)
        {
            ProductoQuerys.insertarTalla(talla);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String genero = JOptionPane.showInputDialog(null, "Ingrese Género: ", "Género", 1);
        if(genero!=null)
        {
            ProductoQuerys.insertarGenero(genero);
        }
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbCodigoPedido;
    private javax.swing.JComboBox cbGenero;
    private javax.swing.JComboBox cbMarca;
    private javax.swing.JComboBox cbTalla;
    private javax.swing.JComboBox cbTipoProducto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblProductosPedido;
    // End of variables declaration//GEN-END:variables
}
