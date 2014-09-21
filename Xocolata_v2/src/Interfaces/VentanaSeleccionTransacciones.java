/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import ContenedorComboBox.Item;
import java.awt.Color;
import java.awt.Graphics;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import xocolata_v2.ConexionDB;
import xocolata_v2.Rinventario;

/**
 *
 * @author Marco Barrios
 */
public class VentanaSeleccionTransacciones extends javax.swing.JInternalFrame {

    int tipoReporte;
    int idPersona;
    int idRegistroTransaccion;
    int idTransaccion;
    /**
     * Creates new form VentanaSeleccionTransacciones
     * @param tipo
     */
    public VentanaSeleccionTransacciones(int tipo) {
        initComponents();
        this.tipoReporte = tipo;
        mostrarGeneral();
        cargarPersonas();
    }

    public void mostrarGeneral() {
        if (tipoReporte == 1) {
            jLabel3.setVisible(false);
            cbTransaccion.setVisible(false);
        } else  {
            jLabel3.setVisible(true);
            cbTransaccion.setVisible(true);
        }
    }
    
    public void cargarPersonas() {
        ResultSet dato = null;
        Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            Statement comando = (Statement)conexion.createStatement();
            dato = comando.executeQuery("Select idPersona, nombrePersona from tblPersonas ORDER BY nombrePersona");
            while(dato.next())
            {
                Item persona = new Item(dato.getString("idPersona"), dato.getString("nombrePersona"));
                cbPersona.addItem(persona);
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
    
    public void cargarRegistroTransacciones() {
        ResultSet dato = null;
        Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            Statement comando = (Statement)conexion.createStatement();
            dato = comando.executeQuery("Select idRegistroTransaccion, codigoTransaccion from tblRegistroTransacciones WHERE idPersona = '" + idPersona + "' ORDER BY idRegistroTransaccion DESC");
            while(dato.next())
            {
                Item persona = new Item(dato.getString("idRegistroTransaccion"), dato.getString("codigoTransaccion"));
                cbRegistroTransaccion.addItem(persona);
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
    
    public void cargarTransacciones() {
        ResultSet dato = null;
        Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            Statement comando = (Statement)conexion.createStatement();
            dato = comando.executeQuery("Select idTransaccion, fechaTransaccion from tblTransacciones WHERE idRegistroTransaccion = '" + idRegistroTransaccion + "' ORDER BY idTransaccion DESC");
            while(dato.next())
            {
                Item persona = new Item(dato.getString("idTransaccion"), dato.getString("fechaTransaccion"));
                cbTransaccion.addItem(persona);
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
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pPrincipal = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbPersona = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cbRegistroTransaccion = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cbTransaccion = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        setClosable(true);

        pPrincipal.setLayout(new javax.swing.BoxLayout(pPrincipal, javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setPreferredSize(new java.awt.Dimension(460, 40));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Reporte de Transacciones");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(287, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        pPrincipal.add(jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Seleccione una Persona:");

        cbPersona.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbPersona.setPreferredSize(new java.awt.Dimension(32, 30));
        cbPersona.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbPersonaItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Seleccione una Transaccion:");

        cbRegistroTransaccion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbRegistroTransaccion.setPreferredSize(new java.awt.Dimension(32, 30));
        cbRegistroTransaccion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbRegistroTransaccionItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Seleccione una Fecha:");

        cbTransaccion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbTransaccion.setPreferredSize(new java.awt.Dimension(32, 30));
        cbTransaccion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTransaccionItemStateChanged(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 153, 0));
        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Generar Reporte");
        jButton1.setPreferredSize(new java.awt.Dimension(127, 30));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbPersona, 0, 240, Short.MAX_VALUE)
                            .addComponent(cbRegistroTransaccion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbTransaccion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(177, 177, 177))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbRegistroTransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbTransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pPrincipal.add(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbPersonaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbPersonaItemStateChanged
        Item persona = (Item)cbPersona.getSelectedItem();
        idPersona = Integer.parseInt(persona.getId());
        cargarRegistroTransacciones();
    }//GEN-LAST:event_cbPersonaItemStateChanged

    private void cbRegistroTransaccionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbRegistroTransaccionItemStateChanged
        Item registroTransaccion = (Item)cbRegistroTransaccion.getSelectedItem();
        idRegistroTransaccion = Integer.parseInt(registroTransaccion.getId());
        cargarTransacciones();
    }//GEN-LAST:event_cbRegistroTransaccionItemStateChanged

    private void cbTransaccionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTransaccionItemStateChanged
        Item transaccion = (Item)cbTransaccion.getSelectedItem();
        idTransaccion = Integer.parseInt(transaccion.getId());
    }//GEN-LAST:event_cbTransaccionItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (this.tipoReporte == 1) {
            int resultado = JOptionPane.showConfirmDialog(null, "¿Desea Generar Reporte con Precio Sugerido?", "Tipo de Reporte", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(resultado == JOptionPane.YES_OPTION)
        {
            //REPORTE CON PRECIO SUGERIDO 
            Rinventario Rinv=new Rinventario(String.valueOf(idRegistroTransaccion),"src\\Reportes\\H_ReporteTransaccionesPrecioSugerido.jasper");
            this.getParent().add(Rinv);        
            Rinv.show();
            try {
                Rinv.setSelected(true);
            } catch (PropertyVetoException ex) {
            }
        }
        else
        {
            //REPORTE SIN PRECIO SUGERIDO
            Rinventario Rinv=new Rinventario(String.valueOf(idRegistroTransaccion),"src\\Reportes\\H_ReporteTransaccionesSinPrecioSugerdio.jasper");
            this.getParent().add(Rinv);        
            Rinv.show();
            try {
                Rinv.setSelected(true);
            } catch (PropertyVetoException ex) {
            }
        }
        this.dispose();
        } 
        else {
        int resultado = JOptionPane.showConfirmDialog(null, "¿Desea Generar Reporte con Precio Sugerido?", "Tipo de Reporte", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(resultado == JOptionPane.YES_OPTION)
        {
            //REPORTE CON PRECIO SUGERIDO 
            Rinventario Rinv=new Rinventario(String.valueOf(idTransaccion),"src\\Reportes\\H_TransaccionesPrecioSugerido.jasper");
            this.getParent().add(Rinv);        
            Rinv.show();
            try {
                Rinv.setSelected(true);
            } catch (PropertyVetoException ex) {
            }
        }
        else
        {
            //REPORTE SIN PRECIO SUGERIDO
            Rinventario Rinv=new Rinventario(String.valueOf(idTransaccion),"src\\Reportes\\H_TransaccionesSinPrecioSugerdio.jasper");
            this.getParent().add(Rinv);        
            Rinv.show();
            try {
                Rinv.setSelected(true);
            } catch (PropertyVetoException ex) {
            }
        }
        this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public void setIcon(Icon anIcon){
        setFrameIcon(anIcon);
    }
     
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(new Color(100, 0, 4, 85));
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbPersona;
    private javax.swing.JComboBox cbRegistroTransaccion;
    private javax.swing.JComboBox cbTransaccion;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel pPrincipal;
    // End of variables declaration//GEN-END:variables
}
