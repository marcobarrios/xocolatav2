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
        this.opcion = opcion;
        cargarDatos();
    }

        public void cargarDatos() {
        ResultSet dato;
        Connection conexion = ConexionDB.ObtenerConexion();
        switch (opcion) {
            case "VentaVendedorEspecifico":
                tTitulo.setText("Ventas de Vendedor");
                try
                {
                    try (Statement comando = (Statement)conexion.createStatement()) {
                        dato = comando.executeQuery("Select idPersona, nombrePersona from tblPersonas where idTipoPersona='1' ORDER BY nombrePersona");
                        while(dato.next())
                        {
                            Item vendedor = new Item(dato.getString("idPersona"), dato.getString("nombrePersona"));
                            jComboBox1.addItem(vendedor);
                        }
                        dato.close();
                    }
                    conexion.close();
                }
                catch (SQLException ex)
                {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }  break;
            case "VentaClienteEspecifico":
                tTitulo.setText("Ventas de Cliente");
                try
                {
                    try (Statement comando = (Statement)conexion.createStatement()) {
                        dato = comando.executeQuery("Select idPersona, nombrePersona from tblPersonas where idTipoPersona='2' ORDER BY nombrePersona");
                        while(dato.next())
                        {
                            Item vendedor = new Item(dato.getString("idPersona"), dato.getString("nombrePersona"));
                            jComboBox1.addItem(vendedor);
                        }
                        dato.close();
                    }
                    conexion.close();
                }
                catch (SQLException ex)
                {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }  break;
            case "ProductosMarca":
                tTitulo.setText("Productos por Marca");
                try
                {
                    try (Statement comando = (Statement)conexion.createStatement()) {
                        dato = comando.executeQuery("Select idMarca, Marca from tblMarcas ORDER BY Marca");
                        while(dato.next())
                        {
                            Item vendedor = new Item(dato.getString("idMarca"), dato.getString("Marca"));
                            jComboBox1.addItem(vendedor);
                        }
                        dato.close();
                    }
                    conexion.close();
                }
                catch (SQLException ex)
                {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }  break;
            case "ProductosTipo":
                tTitulo.setText("Productos por Tipo de Producto");
                try
                {
            try (Statement comando = (Statement)conexion.createStatement()) {
                dato = comando.executeQuery("Select idTipoProducto, TipoProducto from tblTipoProductos ORDER BY tipoProducto");
                while(dato.next())
                {
                    Item vendedor = new Item(dato.getString("idTipoProducto"), dato.getString("TipoProducto"));
                    jComboBox1.addItem(vendedor);
                }
                dato.close();
            }
                    conexion.close();
                }
                catch (SQLException ex)
                {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }  break;
            case "ProductosTalla":
                tTitulo.setText("Productos por Talla");
                try
                {
            try (Statement comando = (Statement)conexion.createStatement()) {
                dato = comando.executeQuery("Select idTalla, Talla from tblTallas ORDER BY Talla");
                while(dato.next())
                {
                    Item vendedor = new Item(dato.getString("idTalla"), dato.getString("Talla"));
                    jComboBox1.addItem(vendedor);
                }
                dato.close();
            }
                    conexion.close();
                }
                catch (SQLException ex)
                {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }  break;
            case "PersonaVendedor":
                tTitulo.setText("Vendedores");
                try
                {
            try (Statement comando = (Statement)conexion.createStatement()) {
                dato = comando.executeQuery("Select idPersona, nombrePersona from tblPersonas WHERE idTipoPersona = '1' ORDER BY nombrePersona");
                while(dato.next())
                {
                    Item vendedor = new Item(dato.getString("idPersona"), dato.getString("nombrePersona"));
                    jComboBox1.addItem(vendedor);
                }
                dato.close();
            }
                    conexion.close();
                }
                catch (SQLException ex)
                {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }  break;
            case "PersonaCliente":
                tTitulo.setText("Clientes");
                try
                {
            try (Statement comando = (Statement)conexion.createStatement()) {
                dato = comando.executeQuery("Select idPersona, nombrePersona from tblPersonas WHERE idTipoPersona = '2' ORDER BY nombrePersona");
                while(dato.next())
                {
                    Item vendedor = new Item(dato.getString("idPersona"), dato.getString("nombrePersona"));
                    jComboBox1.addItem(vendedor);
                }
                dato.close();
            }
                    conexion.close();
                }
                catch (SQLException ex)
                {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }  break;
            case "GastoEspecifico":
                tTitulo.setText("Gasto por Tipo");
                try
                {
            try (Statement comando = (Statement)conexion.createStatement()) {
                dato = comando.executeQuery("Select idTipoGasto, TipoGasto from tblTipoGastos ORDER BY TipoGasto");
                while(dato.next())
                {
                    Item vendedor = new Item(dato.getString("idTipoGasto"), dato.getString("TipoGasto"));
                    jComboBox1.addItem(vendedor);
                }
                dato.close();
            }
                    conexion.close();
                }
                catch (SQLException ex)
                {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }  break;
            case "AbonoVendedorEspecifico":
                tTitulo.setText("Abonos de Vendedor");
                try
                {
            try (Statement comando = (Statement)conexion.createStatement()) {
                dato = comando.executeQuery("Select idPersona, nombrePersona from tblPersonas WHERE idTipoPersona = '1' ORDER BY nombrePersona");
                while(dato.next())
                {
                    Item vendedor = new Item(dato.getString("idPersona"), dato.getString("nombrePersona"));
                    jComboBox1.addItem(vendedor);
                }
                dato.close();
            }
                    conexion.close();
                }
                catch (SQLException ex)
                {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }  break;
            case "AbonoClienteEspecifico":
                tTitulo.setText("Abonos de Cliente");
                try
                {
            try (Statement comando = (Statement)conexion.createStatement()) {
                dato = comando.executeQuery("Select idPersona, nombrePersona from tblPersonas WHERE idTipoPersona = '2' ORDER BY nombrePersona");
                while(dato.next())
                {
                    Item vendedor = new Item(dato.getString("idPersona"), dato.getString("nombrePersona"));
                    jComboBox1.addItem(vendedor);
                }
                dato.close();
            }
                 conexion.close();
             }
             catch (SQLException ex)
             {
                 JOptionPane.showMessageDialog(null, ex.getMessage());
             }  break;
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
        pTitulo = new javax.swing.JPanel();
        tTitulo = new javax.swing.JLabel();
        pContenedor = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);

        pPrincipal.setLayout(new javax.swing.BoxLayout(pPrincipal, javax.swing.BoxLayout.Y_AXIS));

        pTitulo.setBackground(new java.awt.Color(0, 153, 0));
        pTitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pTitulo.setPreferredSize(new java.awt.Dimension(494, 40));

        tTitulo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        tTitulo.setForeground(new java.awt.Color(255, 255, 255));
        tTitulo.setText("Selección de Datos");

        javax.swing.GroupLayout pTituloLayout = new javax.swing.GroupLayout(pTitulo);
        pTitulo.setLayout(pTituloLayout);
        pTituloLayout.setHorizontalGroup(
            pTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tTitulo)
                .addContainerGap(312, Short.MAX_VALUE))
        );
        pTituloLayout.setVerticalGroup(
            pTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTituloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tTitulo)
                .addContainerGap())
        );

        pPrincipal.add(pTitulo);

        pContenedor.setBackground(new java.awt.Color(255, 255, 255));

        jComboBox1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jComboBox1.setPreferredSize(new java.awt.Dimension(28, 30));

        jButton1.setBackground(new java.awt.Color(0, 153, 0));
        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Generar Reporte");
        jButton1.setPreferredSize(new java.awt.Dimension(127, 30));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Seleccione un Dato:");

        javax.swing.GroupLayout pContenedorLayout = new javax.swing.GroupLayout(pContenedor);
        pContenedor.setLayout(pContenedorLayout);
        pContenedorLayout.setHorizontalGroup(
            pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pContenedorLayout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );
        pContenedorLayout.setVerticalGroup(
            pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pContenedorLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
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
            .addComponent(pPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Item item = (Item)jComboBox1.getSelectedItem();
        String id = item.getId();
        Rinventario Rinv;
        switch (opcion) {
            case "VentaVendedorEspecifico":
                Rinv=new Rinventario(id,"src\\Reportes\\C_VentasNombre.jasper");
                this.getParent().add(Rinv);        
                Rinv.show();
                try {
                    Rinv.setSelected(true);
                } catch (PropertyVetoException ex) {
                }
                break;
            case "VentaClienteEspecifico":
                Rinv=new Rinventario(id,"src\\Reportes\\C_VentasNombre.jasper");
                this.getParent().add(Rinv);        
                Rinv.show();
                try {
                    Rinv.setSelected(true);
                } catch (PropertyVetoException ex) {
                }
                break;
            case "ProductosMarca":
                Rinv=new Rinventario(id,"src\\Reportes\\I_ProductosMarca.jasper");
                this.getParent().add(Rinv);        
                Rinv.show();
                try {
                    Rinv.setSelected(true);
                } catch (PropertyVetoException ex) {
                }
                break;
            case "ProductosTipo":
                Rinv=new Rinventario(id,"src\\Reportes\\I_ProductosTipoProducto.jasper");
                this.getParent().add(Rinv);        
                Rinv.show();
                try {
                    Rinv.setSelected(true);
                } catch (PropertyVetoException ex) {
                }
                break;
            case "ProductosTalla":
                Rinv=new Rinventario(id,"src\\Reportes\\I_ProductosTalla.jasper");
                this.getParent().add(Rinv);        
                Rinv.show();
                try {
                    Rinv.setSelected(true);
                } catch (PropertyVetoException ex) {
                }
                break;
            case "PersonaVendedor":
                //FALTA REPORTE
                break;
            case "PersonaCliente":
                //FALRA REPORTE
                break;
            case "GastoEspecifico":
                Rinv=new Rinventario(id,"src\\Reportes\\K_GastosTipo.jasper");
                this.getParent().add(Rinv);        
                Rinv.show();
                try {
                    Rinv.setSelected(true);
                } catch (PropertyVetoException ex) {
                }
                break;
            case "AbonoVendedorEspecifico":
                Rinv=new Rinventario(id,"src\\Reportes\\L_AbonosPersona.jasper");
                this.getParent().add(Rinv);        
                Rinv.show();
                try {
                    Rinv.setSelected(true);
                } catch (PropertyVetoException ex) {
                }
                break;
            case "AbonoClienteEspecifico":
                Rinv=new Rinventario(id,"src\\Reportes\\L_AbonosPersona.jasper");
                this.getParent().add(Rinv);        
                Rinv.show();
                try {
                    Rinv.setSelected(true);
                } catch (PropertyVetoException ex) {
                }
                break;
        }
        this.dispose();
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
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel pContenedor;
    private javax.swing.JPanel pPrincipal;
    private javax.swing.JPanel pTitulo;
    private javax.swing.JLabel tTitulo;
    // End of variables declaration//GEN-END:variables
}
