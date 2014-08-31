/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaces;

import Clases.Transacciones;
import ContenedorComboBox.Item;
import Querys.ProductoQuerys;
import Querys.TransaccionQuerys;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import xocolata_v2.ConexionDB;

/**
 *
 * @author Marco
 */
public class VentanaSalidaProducto extends javax.swing.JInternalFrame {

    double total;
    int idTransaccion;
    String fechaActual = "";
    HiloCalculos hilo;
    /**
     * Creates new form VentanaSalidaProducto
     */
    public VentanaSalidaProducto() {
        initComponents();
        total = 0.0;
        cargarDatosVendedor();
        
        Calendar fecha = new GregorianCalendar();
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int mes = fecha.get(Calendar.MONTH)+1;
        int año = fecha.get(Calendar.YEAR);
        fechaActual = Integer.toString(año) + "-" + Integer.toString(mes) + "-" + Integer.toString(dia);
        
        rNuevaTransaccion.setSelected(true);
        rReusarTransaccion.setSelected(false);
        cbTransaccion.setVisible(false);
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
                tblProductosTrasaccion.setModel(model);
            }
            catch (SQLException exp) 
            {
                JOptionPane.showMessageDialog(null, exp.toString());
            }
        }
    }
    
    private void cargarProducto(String codigo) {
        int idProducto = ProductoQuerys.buscarIdProducto(codigo);
        if (idProducto != 0) {
            TransaccionQuerys.ingresarDetalleTransaccion(idTransaccion, idProducto, fechaActual);
            ProductoQuerys.cambiarEstadoProducto(idProducto, 2);
        }
        cargarTablaProductosTransaccion();
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
        jLabel2 = new javax.swing.JLabel();
        tProducto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductosTrasaccion = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lCantidad = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lSubtotal = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        tOferta = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lTotal = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbVendedor = new javax.swing.JComboBox();
        bTransaccion = new javax.swing.JButton();
        rNuevaTransaccion = new javax.swing.JRadioButton();
        rReusarTransaccion = new javax.swing.JRadioButton();
        cbTransaccion = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        pPrincipal.setLayout(new javax.swing.BoxLayout(pPrincipal, javax.swing.BoxLayout.Y_AXIS));

        pTitulo.setBackground(new java.awt.Color(255, 204, 0));
        pTitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pTitulo.setMaximumSize(new java.awt.Dimension(32767, 40));
        pTitulo.setPreferredSize(new java.awt.Dimension(1066, 40));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Salida de Producto");

        javax.swing.GroupLayout pTituloLayout = new javax.swing.GroupLayout(pTitulo);
        pTitulo.setLayout(pTituloLayout);
        pTituloLayout.setHorizontalGroup(
            pTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(886, Short.MAX_VALUE))
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

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Producto:");

        tProducto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tProducto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tProducto.setEnabled(false);
        tProducto.setMinimumSize(new java.awt.Dimension(4, 30));
        tProducto.setPreferredSize(new java.awt.Dimension(4, 30));
        tProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tProductoKeyPressed(evt);
            }
        });

        tblProductosTrasaccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblProductosTrasaccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosTrasaccionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProductosTrasaccion);

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Cancelar Transacción");

        jButton3.setBackground(new java.awt.Color(0, 153, 51));
        jButton3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Aceptar Transacción");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Cantidad de Productos:");

        lCantidad.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lCantidad.setText("0");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("SubTotal: Q.");

        lSubtotal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lSubtotal.setText("0.0");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Oferta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Oferta (%):");

        tOferta.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tOferta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tOferta.setText("0");
        tOferta.setPreferredSize(new java.awt.Dimension(12, 30));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("TOTAL: Q.");

        lTotal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lTotal.setText("0.0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lTotal)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tOferta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(lTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Vendedor:");

        cbVendedor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbVendedor.setPreferredSize(new java.awt.Dimension(32, 30));
        cbVendedor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbVendedorItemStateChanged(evt);
            }
        });

        bTransaccion.setBackground(new java.awt.Color(255, 204, 0));
        bTransaccion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bTransaccion.setForeground(new java.awt.Color(255, 255, 255));
        bTransaccion.setText("Crear Transacción");
        bTransaccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTransaccionActionPerformed(evt);
            }
        });

        rNuevaTransaccion.setText("Nueva Transacción");
        rNuevaTransaccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rNuevaTransaccionActionPerformed(evt);
            }
        });

        rReusarTransaccion.setText("Reusar Transacción");
        rReusarTransaccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rReusarTransaccionActionPerformed(evt);
            }
        });

        cbTransaccion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTransaccionItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rNuevaTransaccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rReusarTransaccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbTransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bTransaccion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rNuevaTransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rReusarTransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTransaccion, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(bTransaccion))
                .addContainerGap())
        );

        javax.swing.GroupLayout pContenedorLayout = new javax.swing.GroupLayout(pContenedor);
        pContenedor.setLayout(pContenedorLayout);
        pContenedorLayout.setHorizontalGroup(
            pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pContenedorLayout.createSequentialGroup()
                .addContainerGap(590, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(209, 209, 209))
            .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pContenedorLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pContenedorLayout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 427, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lCantidad)
                            .addGap(41, 41, 41)
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lSubtotal)
                            .addGap(15, 15, 15))
                        .addGroup(pContenedorLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addContainerGap()))
        );
        pContenedorLayout.setVerticalGroup(
            pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pContenedorLayout.createSequentialGroup()
                .addContainerGap(386, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pContenedorLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(lCantidad)
                        .addComponent(jLabel5)
                        .addComponent(lSubtotal))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(pPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tProductoKeyPressed
        if(evt.getKeyCode() ==  KeyEvent.VK_ENTER)
        {
            cargarProducto(tProducto.getText());
            tProducto.setText("");
            tProducto.requestFocus();
        }
    }//GEN-LAST:event_tProductoKeyPressed

    private void bTransaccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTransaccionActionPerformed
        if (rNuevaTransaccion.isSelected())
        {
            Item persona = (Item)cbVendedor.getSelectedItem();
            int id =  Integer.parseInt(persona.getId());
            
            Transacciones transaccion = new Transacciones();
            
            transaccion.setIdTransaccion(0);
            transaccion.setCodigoTransaccion("0");
            transaccion.setIdPersona(id);
            transaccion.setFechaTransaccion(fechaActual);
            transaccion.setFechaDevolucion(fechaActual);
            transaccion.setCantidadPRoductos(0);
            transaccion.setSubtotalTransaccion(0.0);
            transaccion.setPorcentajeOferta(0.0);
            transaccion.setDescuentoTransaccion(0.0);
            transaccion.setTotalTransccion(0.0);
            transaccion.setTipoTransccion(1);
            idTransaccion = TransaccionQuerys.insertarTransaccion(transaccion);
        }
        else if (rReusarTransaccion.isSelected())
        {
            Item transaccion = (Item)cbTransaccion.getSelectedItem();
            idTransaccion =  Integer.parseInt(transaccion.getId());            
        }
        habilitarPanel(false);
        cargarTablaProductosTransaccion();
        hilo = new HiloCalculos();
        tProducto.setEnabled(true);
        tProducto.requestFocus();
    }//GEN-LAST:event_bTransaccionActionPerformed

    private void habilitarPanel(boolean cambio) {

            Component[] lista = jPanel2.getComponents();
            for(int i = 0; i < jPanel2.getComponents().length; i++)
            {
                lista[i].setEnabled(cambio);
            }
        }
    
    private void cbVendedorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbVendedorItemStateChanged
        cargarDatosTransaccion();
    }//GEN-LAST:event_cbVendedorItemStateChanged

    private void rNuevaTransaccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rNuevaTransaccionActionPerformed
        rNuevaTransaccion.setSelected(true);
        rReusarTransaccion.setSelected(false);
        cbTransaccion.setVisible(false);
        bTransaccion.setText("Crear Transacción");
    }//GEN-LAST:event_rNuevaTransaccionActionPerformed

    private void rReusarTransaccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rReusarTransaccionActionPerformed
        rNuevaTransaccion.setSelected(false);
        rReusarTransaccion.setSelected(true);
        cbTransaccion.setVisible(true);
        bTransaccion.setText("Cargar Transacción");
    }//GEN-LAST:event_rReusarTransaccionActionPerformed

    private void cbTransaccionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTransaccionItemStateChanged
        if (cbTransaccion.getItemCount() > 0) {
        Item persona = (Item)cbTransaccion.getSelectedItem();
        idTransaccion =  Integer.parseInt(persona.getId());
        }
    }//GEN-LAST:event_cbTransaccionItemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        TransaccionQuerys.agregarPreciosTransaccion(idTransaccion, Integer.parseInt(lCantidad.getText()), Double.parseDouble(lSubtotal.getText()), Double.parseDouble(tOferta.getText()), Double.parseDouble(lSubtotal.getText())-Double.parseDouble(lTotal.getText()), Double.parseDouble(lTotal.getText()));
    }//GEN-LAST:event_jButton3ActionPerformed

    int temporal=-1;
    private void tblProductosTrasaccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosTrasaccionMouseClicked
        // TODO add your handling code here:
        if(!evt.isMetaDown())
        {
            if(tblProductosTrasaccion.getSelectedRow() == temporal)
            {
                Item idTransaccion = (Item)tblProductosTrasaccion.getValueAt(temporal, 0);
                //////IMPLEMENTAR CÓDIGO reporte Consulta cotizaciones.
                JOptionPane.showMessageDialog(null, "ID seleccionado = " + idTransaccion.getId() );
            }
            else
            {
                temporal = tblProductosTrasaccion.getSelectedRow();
            }
        }
    }//GEN-LAST:event_tblProductosTrasaccionMouseClicked

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
                    if(tOferta.getText().length() != 0) 
                    {
                        try
                        {
                            lTotal.setText(df.format(Double.parseDouble(lSubtotal.getText())*(100-Double.parseDouble(tOferta.getText()))/100));
                            total = Double.parseDouble(lTotal.getText());
                        }
                        catch(NumberFormatException exp)
                                {
                                    int hasta = tOferta.getText().length() - 1;
                                    String resultado = tOferta.getText().substring(0, hasta);
                                    tOferta.setText(resultado);
                                    tOferta.setCaretPosition(hasta);
                                }
                    }
                    ////////////////////////////////////////////////////////////
                    lCantidad.setText(String.valueOf(TransaccionQuerys.contarProductosTransaccion(idTransaccion)));
                    lSubtotal.setText(String.valueOf(TransaccionQuerys.sumaPrecioVentaTransaccion(idTransaccion)));
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
    private javax.swing.JButton bTransaccion;
    private javax.swing.JComboBox cbTransaccion;
    private javax.swing.JComboBox cbVendedor;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lCantidad;
    private javax.swing.JLabel lSubtotal;
    private javax.swing.JLabel lTotal;
    private javax.swing.JPanel pContenedor;
    private javax.swing.JPanel pPrincipal;
    private javax.swing.JPanel pTitulo;
    private javax.swing.JRadioButton rNuevaTransaccion;
    private javax.swing.JRadioButton rReusarTransaccion;
    private javax.swing.JTextField tOferta;
    private javax.swing.JTextField tProducto;
    private javax.swing.JTable tblProductosTrasaccion;
    // End of variables declaration//GEN-END:variables
}
