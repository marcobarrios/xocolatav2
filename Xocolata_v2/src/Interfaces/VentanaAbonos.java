/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaces;

import Clases.Abonos;
import ContenedorComboBox.Item;
import Querys.AbonoQuerys;
import java.awt.Color;
import java.awt.Graphics;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import xocolata_v2.ConexionDB;
import xocolata_v2.Rinventario;

/**
 *
 * @author Marco
 */
public class VentanaAbonos extends javax.swing.JInternalFrame {

    String tipoPersona = "";
    String fechaActual = "";
    /**
     * Creates new form VentanaAbonos
     */
    public VentanaAbonos(String persona) {
        initComponents();
        this.setFrameIcon(new ImageIcon(this.getClass().getResource("/Imagenes/xocolata.jpg")));

        
        this.tipoPersona = persona;
        cargarDatosPersona();
        Calendar fecha = new GregorianCalendar();
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int mes = fecha.get(Calendar.MONTH)+1;
        int año = fecha.get(Calendar.YEAR);
        fechaActual = Integer.toString(año) + "-" + Integer.toString(mes) + "-" + Integer.toString(dia);
    }

    private void cargarDatosPersona() {
            cbPersona.removeAllItems();
            if (this.tipoPersona.equals("Vendedor"))
            {
                ResultSet dato = null;
                Connection conexion = ConexionDB.ObtenerConexion();
                try
                {
                    Statement comando = (Statement)conexion.createStatement();
                    dato = comando.executeQuery("Select idPersona, nombrePersona from tblPersonas WHERE idTipoPersona = '1' ORDER BY nombrePersona");
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
            else
            {
                ResultSet dato = null;
                Connection conexion = ConexionDB.ObtenerConexion();
                try
                {
                    Statement comando = (Statement)conexion.createStatement();
                    dato = comando.executeQuery("Select idPersona, nombrePersona from tblPersonas WHERE idTipoPersona = '2' ORDER BY nombrePersona");
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
        
        jLabel5.setText("Abono de " + this.tipoPersona);
        jLabel1.setText(this.tipoPersona + ":");
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
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cbPersona = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        bConsultarSaldo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lSaldoActual = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tMontoAbono = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lNuevoSaldo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);

        pPrincipal.setLayout(new javax.swing.BoxLayout(pPrincipal, javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setBackground(new java.awt.Color(255, 0, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setPreferredSize(new java.awt.Dimension(489, 40));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Abono de");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(399, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        pPrincipal.add(jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        cbPersona.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cbPersona.setPreferredSize(new java.awt.Dimension(32, 30));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Persona:");

        bConsultarSaldo.setBackground(new java.awt.Color(255, 0, 51));
        bConsultarSaldo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        bConsultarSaldo.setForeground(new java.awt.Color(255, 255, 255));
        bConsultarSaldo.setText("Consultar Saldo");
        bConsultarSaldo.setPreferredSize(new java.awt.Dimension(147, 30));
        bConsultarSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConsultarSaldoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Saldo Actual: Q.");

        lSaldoActual.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lSaldoActual.setText("0");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Monto del Abono:");

        tMontoAbono.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tMontoAbono.setText("0");
        tMontoAbono.setPreferredSize(new java.awt.Dimension(4, 30));
        tMontoAbono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tMontoAbonoFocusGained(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 0, 51));
        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Abonar");
        jButton1.setPreferredSize(new java.awt.Dimension(147, 30));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Nuevo Saldo Q.");

        lNuevoSaldo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lNuevoSaldo.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel4)
                .addGap(3, 3, 3)
                .addComponent(tMontoAbono, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lSaldoActual)
                .addGap(74, 74, 74)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lNuevoSaldo)
                .addGap(85, 85, 85))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(cbPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(bConsultarSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(40, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lSaldoActual)
                    .addComponent(jLabel6)
                    .addComponent(lNuevoSaldo))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tMontoAbono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(bConsultarSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(134, Short.MAX_VALUE)))
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
            .addComponent(pPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bConsultarSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConsultarSaldoActionPerformed
        Item persona = (Item)cbPersona.getSelectedItem();
        int id = Integer.parseInt(persona.getId());
        
        lSaldoActual.setText(String.valueOf(AbonoQuerys.consultarSaldo(id)));
        lNuevoSaldo.setText("0");
    }//GEN-LAST:event_bConsultarSaldoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Item persona = (Item)cbPersona.getSelectedItem();
        int id = Integer.parseInt(persona.getId());
        Abonos abono = new Abonos();
        abono.setFechaAbono(fechaActual);
        abono.setMontoAbono(Double.parseDouble(tMontoAbono.getText()));
        abono.setIdPersona(id);
            
        AbonoQuerys.cargarAbono(abono);
        lNuevoSaldo.setText(String.valueOf(Double.parseDouble(lSaldoActual.getText())-Double.parseDouble(tMontoAbono.getText())));
        tMontoAbono.setText("");
        lSaldoActual.setText("0.0");
        
        Rinventario Rinv=new Rinventario(String.valueOf(id),"src\\Reportes\\Abonos.jasper");
        this.getParent().add(Rinv);        
        Rinv.show();
        try {
            Rinv.setSelected(true);
        } catch (PropertyVetoException ex) {
        }

        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tMontoAbonoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tMontoAbonoFocusGained
        tMontoAbono.selectAll();
    }//GEN-LAST:event_tMontoAbonoFocusGained

    public void setIcon(Icon anIcon){
        setFrameIcon(anIcon);
    }
     
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(new Color(100, 0, 4, 85));
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bConsultarSaldo;
    private javax.swing.JComboBox cbPersona;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lNuevoSaldo;
    private javax.swing.JLabel lSaldoActual;
    private javax.swing.JPanel pPrincipal;
    private javax.swing.JTextField tMontoAbono;
    // End of variables declaration//GEN-END:variables
}
