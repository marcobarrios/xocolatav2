/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaces;

import ContenedorComboBox.Item;
import java.awt.Color;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import xocolata_v2.CodBarra;
import xocolata_v2.ConexionDB;

/**
 *
 * @author Marco
 */
public class VentanaGenerarCodigoBarras extends javax.swing.JInternalFrame {

    /**
     * Creates new form VentanaGenerarCodigoBarras
     */
    public VentanaGenerarCodigoBarras() {
        initComponents();
        this.setFrameIcon(new ImageIcon(this.getClass().getResource("/Imagenes/xocolata.jpg")));
        cargarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jTable1.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 455, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargarTabla() {
        String[] titulos={"Código", "Fecha", "SubTotal","Impuesto","Envio","Cantidad", "EnvioGt", "TipoCambio"};
        Object[] registros = new Object[8];
        DefaultTableModel model= new DefaultTableModel(null,titulos){public boolean isCellEditable(int rowIndex,int columnIndex){return false;} };
        Connection conexion = ConexionDB.ObtenerConexion();            
        if(conexion!=null)
        {
            try
            {
                Statement Query = conexion.createStatement();            
                ResultSet Datos = Query.executeQuery("SELECT * from tblPedidos ORDER BY idPedido DESC");
                Datos = Query.getResultSet();                    
                while (Datos.next()) 
                {
                    registros[0]= new Item(Datos.getString("idPedido"),Datos.getString("codigoPedido"));
                    registros[1]=Datos.getString("fechaIngreso");
                    registros[2]=Datos.getString("subtotalPedido");
                    registros[3]=Datos.getString("impuestoPedido");
                    registros[4]=Datos.getString("envioPedido");
                    registros[5]=Datos.getString("cantidadProductos");
                    registros[6]=Datos.getString("envioGuate");
                    registros[7]=Datos.getString("tipocambio");
                    model.addRow(registros);
                }
                jTable1.setModel(model);
            }
            catch (SQLException exp) 
            {
                JOptionPane.showMessageDialog(null, exp.toString());
            }
        }
    }
    
    int temporal = -1;
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if(!evt.isMetaDown())
        {
            if(jTable1.getSelectedRow() == temporal)
            {
                Item idPedido = (Item)jTable1.getValueAt(temporal, 0);
                CodBarra.GenerarCodigos(Integer.parseInt(idPedido.getId()));
            }
            else
            {
                temporal = jTable1.getSelectedRow();
            }
        }

    }//GEN-LAST:event_jTable1MouseClicked

    public void setIcon(Icon anIcon){
        setFrameIcon(anIcon);
    }
     
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(new Color(100, 0, 4, 85));
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}