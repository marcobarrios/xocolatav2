/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaces;

import Clases.Gastos;
import ContenedorComboBox.Item;
import Querys.GastoQuerys;
import java.awt.Color;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import xocolata_v2.ConexionDB;

/**
 *
 * @author Marco
 */
public class VentanaGastos extends javax.swing.JInternalFrame {

    private String fechaFinal;
    /**
     * Creates new form VentanaGastos
     */
    public VentanaGastos() {
        initComponents();
        cargarTipoGastos();
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
        pTitulo = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        pContenedor = new javax.swing.JPanel();
        calendario = new com.toedter.calendar.JDateChooser();
        IngresarGasto = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tMontoGasto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        pPrincipal.setLayout(new javax.swing.BoxLayout(pPrincipal, javax.swing.BoxLayout.Y_AXIS));

        pTitulo.setBackground(new java.awt.Color(0, 153, 102));
        pTitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pTitulo.setPreferredSize(new java.awt.Dimension(490, 40));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ingreso de Gastos");

        javax.swing.GroupLayout pTituloLayout = new javax.swing.GroupLayout(pTitulo);
        pTitulo.setLayout(pTituloLayout);
        pTituloLayout.setHorizontalGroup(
            pTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(315, Short.MAX_VALUE))
        );
        pTituloLayout.setVerticalGroup(
            pTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTituloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        pPrincipal.add(pTitulo);

        pContenedor.setBackground(new java.awt.Color(255, 255, 255));

        calendario.setPreferredSize(new java.awt.Dimension(83, 30));

        IngresarGasto.setBackground(new java.awt.Color(0, 153, 102));
        IngresarGasto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        IngresarGasto.setForeground(new java.awt.Color(255, 255, 255));
        IngresarGasto.setText("Ingresar Gasto");
        IngresarGasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarGastoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Fecha del Gasto");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Monto del Gasto");

        tMontoGasto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tMontoGasto.setPreferredSize(new java.awt.Dimension(4, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Tipo de Gasto");

        jComboBox1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " Seleccione Tipo de Gasto", "---------------------------------------" }));

        jButton2.setText("+");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pContenedorLayout = new javax.swing.GroupLayout(pContenedor);
        pContenedor.setLayout(pContenedorLayout);
        pContenedorLayout.setHorizontalGroup(
            pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pContenedorLayout.createSequentialGroup()
                .addContainerGap(327, Short.MAX_VALUE)
                .addComponent(IngresarGasto)
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pContenedorLayout.createSequentialGroup()
                    .addGap(44, 44, 44)
                    .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(pContenedorLayout.createSequentialGroup()
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton2))
                        .addComponent(calendario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tMontoGasto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(56, Short.MAX_VALUE)))
        );
        pContenedorLayout.setVerticalGroup(
            pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pContenedorLayout.createSequentialGroup()
                .addContainerGap(181, Short.MAX_VALUE)
                .addComponent(IngresarGasto)
                .addGap(22, 22, 22))
            .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pContenedorLayout.createSequentialGroup()
                    .addGap(36, 36, 36)
                    .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addGap(18, 18, 18)
                    .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(tMontoGasto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2))
                    .addContainerGap(72, Short.MAX_VALUE)))
        );

        pPrincipal.add(pContenedor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IngresarGastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresarGastoActionPerformed
        Item gasto = (Item)jComboBox1.getSelectedItem();
        int id = Integer.parseInt(gasto.getId());
        Gastos nuevogasto = new Gastos();
        nuevogasto.setFecha(obtenerFecha());
        nuevogasto.setGasto(Double.parseDouble(tMontoGasto.getText()));
        nuevogasto.setIdTipoGasto(id);
        GastoQuerys.ingresarGasto(nuevogasto);
        tMontoGasto.setText("");
        cargarTipoGastos();
    }//GEN-LAST:event_IngresarGastoActionPerformed
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String tipogasto = JOptionPane.showInputDialog(null, "Ingrese Fabricante: ", "Fabricante", 1);
        if(tipogasto!=null)
        {
            Connection conexion = ConexionDB.ObtenerConexion();
            try
            {
                Statement comando = (Statement)conexion.createStatement();
                comando.execute("insert into tbltipogasto values('0','" + tipogasto + "')");
                comando.close();
                conexion.close();
            }
            catch (SQLException ex)
            {
                //JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        cargarTipoGastos();
    }//GEN-LAST:event_jButton2ActionPerformed

    public String obtenerFecha() {
        Calendar fecha = calendario.getCalendar();
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int mes = fecha.get(Calendar.MONTH);
        int año = fecha.get(Calendar.YEAR);
        this.fechaFinal = Integer.toString(año)+"-"+Integer.toString(mes)+"-"+Integer.toString(dia);
        return fechaFinal;
    }
    
    private void cargarTipoGastos() {
        jComboBox1.removeAllItems();
        ResultSet dato = null;
        Connection conexion = ConexionDB.ObtenerConexion();
            try
            {
                Statement comando = (Statement)conexion.createStatement();
                dato = comando.executeQuery("Select idTipoGasto, TipoGasto from tbltipogasto ORDER BY TipoGasto");
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
    
    public void setIcon(Icon anIcon){
        setFrameIcon(anIcon);
    }
     
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(new Color(100, 0, 4, 85));
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton IngresarGasto;
    private com.toedter.calendar.JDateChooser calendario;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel pContenedor;
    private javax.swing.JPanel pPrincipal;
    private javax.swing.JPanel pTitulo;
    private javax.swing.JTextField tMontoGasto;
    // End of variables declaration//GEN-END:variables
}
