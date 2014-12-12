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
import java.awt.Dimension;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import xocolata_v2.ConexionDB;

/**
 *
 * @author Marco
 */
public class VentanaProductos extends javax.swing.JInternalFrame {

    boolean modificado;
    int idProducto;
    boolean nuevoProducto;
    /**
     * Creates new form VentanaProductos
     */
    public VentanaProductos() {
        initComponents();
        this.setFrameIcon(new ImageIcon(this.getClass().getResource("/Imagenes/xocolata.jpg")));
        
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
        modificado = false;
        idProducto = 0;
        nuevoProducto = false;
        cbCodigoPedido.requestFocus();
    }
    
    private void cargarCodigoPedidos() {
        cbCodigoPedido.removeAllItems();
        ResultSet dato = null;
        Connection conexion = ConexionDB.ObtenerConexion();
            try
            {
            try (Statement comando = (Statement)conexion.createStatement()) {
                dato = comando.executeQuery("Select idPedido, codigoPedido, fechaIngreso from tblPedidos ORDER BY idPedido DESC");
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
                dato = comando.executeQuery("Select idGenero, Genero from tblGeneros ORDER BY Genero");
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
        tColor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tDescripcion = new javax.swing.JTextArea();
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

        cbMarca.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cbMarca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Marca" }));
        cbMarca.setMinimumSize(new java.awt.Dimension(71, 30));
        cbMarca.setPreferredSize(new java.awt.Dimension(71, 30));
        cbMarca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMarcaItemStateChanged(evt);
            }
        });

        cbTipoProducto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cbTipoProducto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tipo de Producto" }));
        cbTipoProducto.setPreferredSize(new java.awt.Dimension(148, 30));
        cbTipoProducto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTipoProductoItemStateChanged(evt);
            }
        });

        cbTalla.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cbTalla.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Talla" }));
        cbTalla.setPreferredSize(new java.awt.Dimension(60, 30));
        cbTalla.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTallaItemStateChanged(evt);
            }
        });

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

        tColor.setPreferredSize(new java.awt.Dimension(4, 30));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Descripción");

        tDescripcion.setColumns(15);
        tDescripcion.setRows(5);
        tDescripcion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane2.setViewportView(tDescripcion);

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Color");

        jButton5.setBackground(new java.awt.Color(255, 102, 0));
        jButton5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Ingresar Precios");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

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
                                .addComponent(tColor, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pContenedorLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jButton5))
                    .addGroup(pContenedorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCodigoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pContenedorLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbTipoProducto, 0, 200, Short.MAX_VALUE)
                            .addComponent(cbMarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbTalla, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbGenero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jButton1)
                            .addComponent(jButton3)
                            .addComponent(jButton4))))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        pContenedorLayout.setVerticalGroup(
            pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pContenedorLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pContenedorLayout.createSequentialGroup()
                        .addGap(0, 19, Short.MAX_VALUE)
                        .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbCodigoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbTipoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbTalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4))
                        .addGap(18, 18, 18)
                        .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)
                        .addContainerGap(29, Short.MAX_VALUE))
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
        cargarMarcas();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String tipo = JOptionPane.showInputDialog(null, "Ingrese Tipo de Producto: ", "Tipo de Producto", 1);
        if(tipo!=null)
        {
            ProductoQuerys.insertarTipoProducto(tipo);
        }
        cargarTipos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String talla = JOptionPane.showInputDialog(null, "Ingrese Talla: ", "Talla", 1);
        if(talla!=null)
        {
            ProductoQuerys.insertarTalla(talla);
        }
        cargarTallas();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String genero = JOptionPane.showInputDialog(null, "Ingrese Género: ", "Género", 1);
        if(genero!=null)
        {
            ProductoQuerys.insertarGenero(genero);
        }
        cargarGeneros();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cbCodigoPedidoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCodigoPedidoItemStateChanged
        if (cbCodigoPedido.getItemCount() > 0) {
            cargarTablaProductosPedido();
        }
    }//GEN-LAST:event_cbCodigoPedidoItemStateChanged

    private void cbMarcaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMarcaItemStateChanged
    }//GEN-LAST:event_cbMarcaItemStateChanged

    private void cbTipoProductoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTipoProductoItemStateChanged
    }//GEN-LAST:event_cbTipoProductoItemStateChanged

    private void cbTallaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTallaItemStateChanged
    }//GEN-LAST:event_cbTallaItemStateChanged

    private void cbGeneroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbGeneroItemStateChanged
    }//GEN-LAST:event_cbGeneroItemStateChanged

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
            Productos producto = new Productos();
            Item auxiliar = (Item)cbMarca.getSelectedItem();
            String marca = auxiliar.getId();
            producto.setMarca(Integer.parseInt(marca));
            auxiliar = (Item)cbTipoProducto.getSelectedItem();
            String tipo = auxiliar.getId();
            producto.setTipoProducto(Integer.parseInt(tipo));
            auxiliar = (Item)cbTalla.getSelectedItem();
            String talla = auxiliar.getId();
            producto.setTalla(Integer.parseInt(talla));
            auxiliar = (Item)cbGenero.getSelectedItem();
            String genero = auxiliar.getId();
            producto.setGenero(Integer.parseInt(genero));
            producto.setColor(tColor.getText());
            producto.setDescripcion(tDescripcion.getText());
            auxiliar = (Item)cbCodigoPedido.getSelectedItem();
            int pedido = Integer.parseInt(auxiliar.getId());
            producto.setIdPedido(pedido);
            
            VentanaIngresoPreciosProducto ventana = new VentanaIngresoPreciosProducto(pedido, producto);
            Dimension desktopSize = this.getParent().getSize();
            Dimension jInternalFrameSize = ventana.getSize();
            ventana.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
                                (desktopSize.height- jInternalFrameSize.height)/2);
            this.getParent().add(ventana);
            ventana.show();
            this.setVisible(false);
            ventana.addInternalFrameListener(new InternalFrameListener() {
			@Override
			public void internalFrameClosing(InternalFrameEvent arg0) {}
			@Override public void internalFrameOpened(InternalFrameEvent arg0)      {}
			@Override public void internalFrameIconified(InternalFrameEvent arg0)   {}
			@Override public void internalFrameDeiconified(InternalFrameEvent arg0) {}
			@Override public void internalFrameDeactivated(InternalFrameEvent arg0) {}
			@Override public void internalFrameClosed(InternalFrameEvent arg0)      
                        {
                            cargarTablaProductosPedido();
                        }
			@Override public void internalFrameActivated(InternalFrameEvent arg0)   {}
		});
    }//GEN-LAST:event_jButton5ActionPerformed

    private void cargarTablaProductosPedido() {
        this.setVisible(true);
        Item gasto = (Item)cbCodigoPedido.getSelectedItem();
        int id = Integer.parseInt(gasto.getId());
        
        String[] titulos={"Código","Marca","Tipo Producto","Talla","Genero", "Color", "Descripción", "Precio en Dolares", "Precio Venta", "Precio Sugerido"};
        String[] registros=new String[10];      
        DefaultTableModel model= new DefaultTableModel(null,titulos){@Override
        public boolean isCellEditable(int rowIndex,int columnIndex){return false;} };
        Connection conexion = ConexionDB.ObtenerConexion();            
        if(conexion!=null)
        {
            try
            {
                Statement Query = conexion.createStatement();            
                ResultSet Datos = Query.executeQuery("SELECT tblProductos.codigoProducto, tblMarcas.Marca, tblTipoProductos.TipoProducto, tblTallas.Talla, tblGeneros.Genero, tblProductos.colorProducto, tblProductos.descripcionProducto, tblProductos.costoDolares, tblProductos.precioVenta, tblProductos.precioSugerido FROM tblProductos "
                        + "INNER JOIN tblMarcas on tblProductos.idMarca = tblMarcas.idMarca "
                        + "INNER JOIN tblTipoProductos on tblProductos.idTipoProducto = tblTipoProductos.idTipoProducto "
                        + "INNER JOIN tblTallas on tblProductos.idTalla = tblTallas.idTalla "
                        + "INNER JOIN tblGeneros on tblProductos.idGenero = tblGeneros.idGenero "
                        + "WHERE tblProductos.idPedido = '" + id + "' ORDER BY tblProductos.codigoProducto ASC");
                Datos = Query.getResultSet();                    
                while (Datos.next()) 
                {
                    registros[0]=Datos.getString("tblProductos.codigoProducto");
                    registros[1]=Datos.getString("tblMarcas.Marca");
                    registros[2]=Datos.getString("tblTipoProductos.TipoProducto");
                    registros[3]=Datos.getString("tblTallas.Talla");
                    registros[4]=Datos.getString("tblGeneros.Genero");
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
    private javax.swing.JPanel pContenedor;
    private javax.swing.JPanel pPrincipal;
    private javax.swing.JPanel pTitulo;
    private javax.swing.JTextField tColor;
    private javax.swing.JTextArea tDescripcion;
    private javax.swing.JTable tblProductosPedido;
    // End of variables declaration//GEN-END:variables
}
