/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaces;

import Clases.Productos;
import ContenedorComboBox.Item;
import Querys.ProductoQuerys;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import xocolata_v2.ConexionDB;

/**
 *
 * @author Marco
 */
public class VentanaProductos extends javax.swing.JInternalFrame {

    hiloProducto hilo;
    boolean modificado;
    int idProducto;
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
        hilo = new hiloProducto();
        modificado = false;
        idProducto = 0;
    }
    
    private void cargarCodigoPedidos() {
        cbCodigoPedido.removeAllItems();
        ResultSet dato = null;
        Connection conexion = ConexionDB.ObtenerConexion();
            try
            {
            try (Statement comando = (Statement)conexion.createStatement()) {
                dato = comando.executeQuery("Select idPedido, codigoPedido from tblPedidos ORDER BY idPedido DESC");
                while(dato.next())
                {
                    Item pedido = new Item(dato.getString("idPedido"), dato.getString("codigoPedido"));
                    cbCodigoPedido.addItem(pedido);
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

    private void cargarMarcas() {
        ResultSet dato = null;
        Connection conexion = ConexionDB.ObtenerConexion();
        try
            {
                 cbMarca.removeAllItems();
                 cbMarca.addItem("- - - - Marca - - - -");
            try ( //MARCA
                    Statement comando = (Statement)conexion.createStatement()) {
                dato = comando.executeQuery("Select idMarca, Marca from tblMarcas ORDER BY Marca");
                while(dato.next())
                {
                    Item marca = new Item(dato.getString("idMarca"), dato.getString("Marca"));
                    cbMarca.addItem(marca);
                }
                dato.close();
            }
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
            try ( //MARCA
                    Statement comando = (Statement)conexion.createStatement()) {
                dato = comando.executeQuery("Select idTipoProducto, TipoProducto from tblTipoProductos ORDER BY TipoProducto");
                while(dato.next())
                {
                    Item tipos = new Item(dato.getString("idTipoProducto"), dato.getString("TipoProducto"));
                    cbTipoProducto.addItem(tipos);
                }
                dato.close();
            }
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
            try ( //MARCA
                    Statement comando = (Statement)conexion.createStatement()) {
                dato = comando.executeQuery("Select idTalla, Talla from tblTallas ORDER BY Talla");
                while(dato.next())
                {
                    Item talla = new Item(dato.getString("idTalla"), dato.getString("Talla"));
                    cbTalla.addItem(talla);
                }
                dato.close();
            }
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
            try ( //MARCA
                    Statement comando = (Statement)conexion.createStatement()) {
                dato = comando.executeQuery("Select idGenero, Genero from tblGenero ORDER BY Genero");
                while(dato.next())
                {
                    Item tipos = new Item(dato.getString("idGenero"), dato.getString("Genero"));
                    cbGenero.addItem(tipos);
                }
                dato.close();
            }
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

        pPrincipal = new javax.swing.JPanel();
        pTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pContenedor = new javax.swing.JPanel();
        cbCodigoPedido = new javax.swing.JComboBox();
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
        jLabel9 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        pPrincipal.setLayout(new javax.swing.BoxLayout(pPrincipal, javax.swing.BoxLayout.Y_AXIS));

        pTitulo.setBackground(new java.awt.Color(255, 102, 0));
        pTitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pTitulo.setMaximumSize(new java.awt.Dimension(32767, 40));
        pTitulo.setPreferredSize(new java.awt.Dimension(869, 40));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ingreso de Productos");

        javax.swing.GroupLayout pTituloLayout = new javax.swing.GroupLayout(pTitulo);
        pTitulo.setLayout(pTituloLayout);
        pTituloLayout.setHorizontalGroup(
            pTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(666, Short.MAX_VALUE))
        );
        pTituloLayout.setVerticalGroup(
            pTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTituloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        pPrincipal.add(pTitulo);

        pContenedor.setBackground(new java.awt.Color(255, 255, 255));

        cbCodigoPedido.setBackground(new java.awt.Color(255, 255, 255));
        cbCodigoPedido.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        cbCodigoPedido.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCodigoPedidoItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Seleccione Código de Pedido");

        tblProductosPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblProductosPedido);

        cbMarca.setBackground(new java.awt.Color(255, 255, 255));
        cbMarca.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cbMarca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Marca" }));
        cbMarca.setPreferredSize(new java.awt.Dimension(71, 30));
        cbMarca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMarcaItemStateChanged(evt);
            }
        });

        cbTipoProducto.setBackground(new java.awt.Color(255, 255, 255));
        cbTipoProducto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cbTipoProducto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tipo de Producto" }));
        cbTipoProducto.setPreferredSize(new java.awt.Dimension(148, 30));
        cbTipoProducto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTipoProductoItemStateChanged(evt);
            }
        });

        cbTalla.setBackground(new java.awt.Color(255, 255, 255));
        cbTalla.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cbTalla.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Talla" }));
        cbTalla.setPreferredSize(new java.awt.Dimension(60, 30));
        cbTalla.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTallaItemStateChanged(evt);
            }
        });

        cbGenero.setBackground(new java.awt.Color(255, 255, 255));
        cbGenero.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cbGenero.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Género" }));
        cbGenero.setPreferredSize(new java.awt.Dimension(81, 30));
        cbGenero.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbGeneroItemStateChanged(evt);
            }
        });

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

        jTextField1.setPreferredSize(new java.awt.Dimension(4, 30));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Descripción");

        jTextArea1.setColumns(15);
        jTextArea1.setRows(5);
        jTextArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane2.setViewportView(jTextArea1);

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Color");

        jButton5.setBackground(new java.awt.Color(255, 102, 0));
        jButton5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Ingresar Precios");

        javax.swing.GroupLayout pContenedorLayout = new javax.swing.GroupLayout(pContenedor);
        pContenedor.setLayout(pContenedorLayout);
        pContenedorLayout.setHorizontalGroup(
            pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pContenedorLayout.createSequentialGroup()
                .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pContenedorLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pContenedorLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(4, 4, 4)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pContenedorLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jButton5))
                    .addGroup(pContenedorLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbTipoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbTalla, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jButton4)))
                    .addGroup(pContenedorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCodigoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        pContenedorLayout.setVerticalGroup(
            pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pContenedorLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pContenedorLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbCodigoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(cbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(cbTipoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(cbTalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(cbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pContenedorLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                        .addGap(20, 20, 20))))
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

    private void cbCodigoPedidoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCodigoPedidoItemStateChanged
        if (cbCodigoPedido.getItemCount() > 0) {
            cargarTablaProductosPedido();
        }
    }//GEN-LAST:event_cbCodigoPedidoItemStateChanged

    private void cbMarcaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMarcaItemStateChanged
        modificado = true;
    }//GEN-LAST:event_cbMarcaItemStateChanged

    private void cbTipoProductoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTipoProductoItemStateChanged
        modificado = true;
    }//GEN-LAST:event_cbTipoProductoItemStateChanged

    private void cbTallaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTallaItemStateChanged
        modificado = true;
    }//GEN-LAST:event_cbTallaItemStateChanged

    private void cbGeneroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbGeneroItemStateChanged
        modificado = true;
    }//GEN-LAST:event_cbGeneroItemStateChanged

    private void cargarTablaProductosPedido() {
        this.setVisible(true);
        Item gasto = (Item)cbCodigoPedido.getSelectedItem();
        int id = Integer.parseInt(gasto.getId());
        
        String[] titulos={"Código","Marca","Tipo Producto","Talla","Genero", "Color", "Descripción", "Precio en Dolares", "Precio Venta", "Precio Sugerido"};
        String[] registros=new String[10];      
        DefaultTableModel model= new DefaultTableModel(null,titulos){public boolean isCellEditable(int rowIndex,int columnIndex){return false;} };
        Connection conexion = ConexionDB.ObtenerConexion();            
        if(conexion!=null)
        {
            try
            {
                Statement Query = conexion.createStatement();            
                ResultSet Datos = Query.executeQuery("SELECT tblProductos.codigoProducto, tblMarcas.Marca, tblTipoProductos.TipoProducto, tblTallas.Talla, tblGenero.Genero, tblProductos.colorProducto, tblProductos.descripcionProducto, tblProductos.costoDolares, tblProductos.precioVenta, tblProductos.precioSugerido FROM tblProductos "
                        + "INNER JOIN tblMarcas on tblProductos.idMarca = tblMarcas.idMarca "
                        + "INNER JOIN tblTipoProductos on tblProductos.idTipoProducto = tblTipoProductos.idTipoProducto "
                        + "INNER JOIN tblTallas on tblProductos.idTalla = tblTallas.idTalla "
                        + "INNER JOIN tblGenero on tblProductos.idGenero = tblGenero.idGenero "
                        + "WHERE tblProductos.idPedido = '" + id + "' ORDER BY tblProductos.codigoProducto ASC");
                Datos = Query.getResultSet();                    
                while (Datos.next()) 
                {
                    registros[0]=Datos.getString("tblProductos.codigoProducto");
                    registros[1]=Datos.getString("tblMarcas.Marca");
                    registros[2]=Datos.getString("tblTipoProductos.TipoProducto");
                    registros[3]=Datos.getString("tblTallas.Talla");
                    registros[4]=Datos.getString("tblGenero.Genero");
                    registros[5]=Datos.getString("tblProductos.colorProducto");
                    registros[6]=Datos.getString("tblProductos.descripcionProducto");
                    registros[7]=Datos.getString("tblProductos.costoDolares");
                    registros[8]=Datos.getString("tblProductos.precioVenta");
                    registros[9]=Datos.getString("tblProductos.precioSugerido");
                    model.addRow(registros);
                }
                tblProductosPedido.setModel(model);

            }
            catch (SQLException exp) 
            {
                JOptionPane.showMessageDialog(null, exp.toString());
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
    
    private void buscarProducto() {
        
        if(cbMarca.getSelectedItem() != cbMarca.getItemAt(0)  && cbTipoProducto.getSelectedItem() != cbTipoProducto.getItemAt(0) && cbTalla.getSelectedItem() != cbTalla.getItemAt(0) && cbGenero.getSelectedItem()!= cbGenero.getItemAt(0)) 
        {
            try 
            {
                Productos producto = new Productos();
                Item auxiliar = (Item)cbMarca.getSelectedItem();
                String marca = auxiliar.getId();
                auxiliar = (Item)cbTipoProducto.getSelectedItem();
                String tipo = auxiliar.getId();
                auxiliar = (Item)cbTalla.getSelectedItem();
                String talla = auxiliar.getId();
                auxiliar = (Item)cbGenero.getSelectedItem();
                String genero = auxiliar.getId();

                producto.setMarca(Integer.parseInt(marca));
                producto.setTalla(Integer.parseInt(tipo));
                producto.setTipoProducto(Integer.parseInt(talla));
                producto.setGenero(Integer.parseInt(genero));
                
                JOptionPane.showMessageDialog(null, "MANDE " + producto.getMarca() + ", " + producto.getTipoProducto() + ", " + producto.getTalla() + ", " + producto.getGenero());
                idProducto = ProductoQuerys.buscarIDProducto(producto);
                JOptionPane.showMessageDialog(null, "ENCONTRE " + idProducto);

            }
            catch(HeadlessException | NumberFormatException exo) {
                System.out.println(exo.toString());
            }
        }    
    }
        
    public class hiloProducto implements Runnable
    {
        private final Thread t;
        public hiloProducto() 
        {
            t = new Thread(this);
            t.start();
        }
        @Override
        public void run() 
        {
            while(true)
            {
                try {
                    if(modificado)
                    {
                       buscarProducto();
                       modificado = false;
                    }
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(VentanaProductos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        
    }
    
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
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel pContenedor;
    private javax.swing.JPanel pPrincipal;
    private javax.swing.JPanel pTitulo;
    private javax.swing.JTable tblProductosPedido;
    // End of variables declaration//GEN-END:variables
}
