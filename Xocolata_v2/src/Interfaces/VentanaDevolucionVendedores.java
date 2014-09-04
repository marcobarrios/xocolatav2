/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaces;

import ContenedorComboBox.Item;
import Querys.PersonaQuerys;
import Querys.ProductoQuerys;
import Querys.TransaccionQuerys;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import xocolata_v2.ConexionDB;

/**
 *
 * @author Marco
 */
public class VentanaDevolucionVendedores extends javax.swing.JInternalFrame {

    int idTransaccion;
    HiloCalculos hilo;
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
        ResultSet dato;
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
        ResultSet dato;
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
        
        String[] titulos={"Codigo","Marca","Tipo Producto","Talla","Genero","Color","Precio Venta"};
        Object[] registros = new Object[7];      
        DefaultTableModel model= new DefaultTableModel(null,titulos){@Override
        public boolean isCellEditable(int rowIndex,int columnIndex){return false;} };
        Connection conexion = ConexionDB.ObtenerConexion();            
        if(conexion!=null)
        {
            try
            {
                Statement Query = conexion.createStatement();            
                ResultSet Datos = Query.executeQuery("SELECT tblProductos.idProducto, tblProductos.codigoProducto, tblMarcas.Marca, tblTipoProductos.TipoProducto, tblTallas.Talla, tblGeneros.Genero, tblProductos.colorProducto, tblProductos.precioVentaFinal FROM tblProductos "
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
                    registros[6]=Datos.getString("tblProductos.precioVentaFinal");
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

        pPrincipal = new javax.swing.JPanel();
        pTitulo = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        pContenedor = new javax.swing.JPanel();
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
        tProducto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lCantidad = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lSubtotal = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        pPrincipal.setLayout(new javax.swing.BoxLayout(pPrincipal, javax.swing.BoxLayout.Y_AXIS));

        pTitulo.setBackground(new java.awt.Color(204, 0, 102));
        pTitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pTitulo.setMaximumSize(new java.awt.Dimension(32767, 40));
        pTitulo.setPreferredSize(new java.awt.Dimension(922, 40));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Devolución de Vendedores");

        javax.swing.GroupLayout pTituloLayout = new javax.swing.GroupLayout(pTitulo);
        pTitulo.setLayout(pTituloLayout);
        pTituloLayout.setHorizontalGroup(
            pTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(670, Short.MAX_VALUE))
        );
        pTituloLayout.setVerticalGroup(
            pTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pPrincipal.add(pTitulo);

        pContenedor.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbVendedor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cbVendedor.setPreferredSize(new java.awt.Dimension(28, 30));
        cbVendedor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbVendedorItemStateChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Seleccione Vendedor");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Transacción");

        cbTransaccion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cbTransaccion.setPreferredSize(new java.awt.Dimension(32, 30));

        jButton1.setBackground(new java.awt.Color(204, 0, 102));
        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Aceptar");
        jButton1.setPreferredSize(new java.awt.Dimension(77, 30));
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
                .addContainerGap(91, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbTransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(182, Short.MAX_VALUE))
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
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tblProductosTransaccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblProductosTransaccion);

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Salir");
        jButton2.setPreferredSize(new java.awt.Dimension(59, 30));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 153, 0));
        jButton3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Cargar a Ventas");
        jButton3.setPreferredSize(new java.awt.Dimension(125, 30));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Código del Producto:");

        tProducto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tProducto.setEnabled(false);
        tProducto.setMinimumSize(new java.awt.Dimension(6, 30));
        tProducto.setPreferredSize(new java.awt.Dimension(6, 30));
        tProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tProductoKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Cantidad de Productos:");

        lCantidad.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lCantidad.setText("0");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("SubTotal: Q.");

        lSubtotal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lSubtotal.setText("0.0");

        javax.swing.GroupLayout pContenedorLayout = new javax.swing.GroupLayout(pContenedor);
        pContenedor.setLayout(pContenedorLayout);
        pContenedorLayout.setHorizontalGroup(
            pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 922, Short.MAX_VALUE)
            .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pContenedorLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pContenedorLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pContenedorLayout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lCantidad)
                            .addGap(41, 41, 41)
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lSubtotal)))
                    .addContainerGap()))
        );
        pContenedorLayout.setVerticalGroup(
            pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 415, Short.MAX_VALUE)
            .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pContenedorLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(lCantidad)
                        .addComponent(jLabel5)
                        .addComponent(lSubtotal))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap()))
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
            .addComponent(pPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
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
        
        tProducto.setEnabled(true);
        tProducto.requestFocus();
        
        hilo = new HiloCalculos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        TransaccionQuerys.agregarProductosVendidos(idTransaccion);
        JOptionPane.showMessageDialog(null, "Productos marcados como 'Vendidos'");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cargarProducto(String codigo) {
        int idProducto = ProductoQuerys.buscarIdProductoTransaccion(codigo);
        if (idProducto != 0) {
            TransaccionQuerys.devolverProductoTransaccion(idTransaccion, idProducto);
            ProductoQuerys.cambiarEstadoProducto(idProducto, 1);
            
            Item transaccion = (Item)cbVendedor.getSelectedItem();
            int idPersona =  Integer.parseInt(transaccion.getId());
            PersonaQuerys.cargarSaldo(idPersona, -1*ProductoQuerys.obtenerPrecioVentaProducto(idProducto));
        }
        cargarTablaProductosTransaccion();
    }
    
    private void tProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tProductoKeyPressed
        if(evt.getKeyCode() ==  KeyEvent.VK_ENTER)
        {
            cargarProducto(tProducto.getText());
            tProducto.setText("");
            tProducto.requestFocus();
        }
    }//GEN-LAST:event_tProductoKeyPressed

    public class HiloCalculos implements Runnable {
        private Thread t;
        DecimalFormat df = new DecimalFormat("0.00");
        public HiloCalculos() 
        {
            t = new Thread(this);
            t.start();
        }

        @Override
        public void run() 
        {
            while(true)
            {
                try 
                {
                    lCantidad.setText(String.valueOf(TransaccionQuerys.contarProductosRegistroTransaccion(idTransaccion)));
                    lSubtotal.setText(String.valueOf(TransaccionQuerys.sumaPrecioVentaRegistroTransaccion(idTransaccion)));
                    Thread.sleep(100);
                }
                catch(InterruptedException exp) 
                {
                }
            }
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
    private javax.swing.JComboBox cbTransaccion;
    private javax.swing.JComboBox cbVendedor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lCantidad;
    private javax.swing.JLabel lSubtotal;
    private javax.swing.JPanel pContenedor;
    private javax.swing.JPanel pPrincipal;
    private javax.swing.JPanel pTitulo;
    private javax.swing.JTextField tProducto;
    private javax.swing.JTable tblProductosTransaccion;
    // End of variables declaration//GEN-END:variables
}
