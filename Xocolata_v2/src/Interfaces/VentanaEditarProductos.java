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
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import xocolata_v2.ConexionDB;

/**
 *
 * @author Marco
 */
public class VentanaEditarProductos extends javax.swing.JInternalFrame {

    Productos p;
    /**
     * Creates new form VentanaEditarProducto
     */
    public VentanaEditarProductos() {
        initComponents();
        
        setJTexFieldChanged(tCodigoProducto);
   }
    
    
    private void cargarMarcas() {
        ResultSet dato;
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
                 JOptionPane.showMessageDialog(null, ex.getMessage());
             }
    }
    
    private void cargarTipos() {
        ResultSet dato;
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
                 JOptionPane.showMessageDialog(null, ex.getMessage());
             }
    }
    
    private void cargarTallas() {
        ResultSet dato;
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
                 JOptionPane.showMessageDialog(null, ex.getMessage());
             }
    }
    
    private void cargarGeneros() {
        ResultSet dato;
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
                 JOptionPane.showMessageDialog(null, ex.getMessage());
             }
    }
    
    private void setJTexFieldChanged(JTextField txt)
    {
        DocumentListener documentListener = new DocumentListener() {
 
        @Override
        public void changedUpdate(DocumentEvent documentEvent) {
            printIt(documentEvent);
        }
 
        @Override
        public void insertUpdate(DocumentEvent documentEvent) {
            printIt(documentEvent);
        }
 
        @Override
        public void removeUpdate(DocumentEvent documentEvent) {
            printIt(documentEvent);
        }
        };
        txt.getDocument().addDocumentListener(documentListener);
 
    }
    
    private void printIt(DocumentEvent documentEvent) {
        DocumentEvent.EventType type = documentEvent.getType();
 
        if (type.equals(DocumentEvent.EventType.CHANGE))
        {
            //tCorreo.setText("");
            //tDPI.setText("");
            //tDireccion.setText("");
            //tTelefono.setText("");
            //limpiarCampos();
 
        }
        else if (type.equals(DocumentEvent.EventType.INSERT))
        {
            editarProducto();
        }
        else if (type.equals(DocumentEvent.EventType.REMOVE))
        {
            editarProducto();
        }
    }
    
    private void editarProducto()
    {
        try 
        {
            p = ProductoQuerys.obtenerProducto(tCodigoProducto.getText());
            //Setea datos a los comboBox
            cargarMarcas();
            cargarTipos();
            cargarGeneros();
            cargarTallas();
            //cargarCbProductos(p);
            //Setear datos a los campos
            tColor.setText(p.getColor());
            tDescripción.setText(p.getDescripcion());
            tCostoDolares.setText(Double.toString(p.getPrecioDolar()));
            tImpuestoProducto.setText(String.valueOf(p.getImpuestoProducto()));
            tEnvioProducto.setText(String.valueOf(p.getEnvioProducto()));
            tTotalDolares.setText(String.valueOf(p.getPrecioCostoDolar()));
            tTipoCambio.setText(String.valueOf(p.getTipoCambio()));
            tEnvioGuate.setText(String.valueOf(p.getEnvioGt()));
            tTotalQ.setText(String.valueOf(p.getPrecioCostoQuetzal()));
            tPorcentajeGanancia.setText(String.valueOf(p.getPorcentajeGanancia()));
            tGananciaEstimada.setText(String.valueOf(p.getGananciaSugerida()));
            tPrecioVenta.setText(String.valueOf(p.getPrecioVenta()));
            tPorcentajeGananciaSugerida.setText(String.valueOf(p.getPorcentajeGananciaSugerida()));
            tGanaciaSugerida.setText(String.valueOf(p.getGananciaSugerida()));
            tPrecioSugerido.setText(String.valueOf(p.getPrecioSugeridoVendedor()));
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private void cargarCbProductos(Productos p)
    {
        ///Mostrar Marca Producto
            Item[] lm = (Item[]) cbMarca.getItemListeners();
            for (Item l1 : lm) {
                if (l1.getId().equals(p.getMarca())) {
                    cbMarca.setSelectedItem(l1);
                    break;
                }
            }
        ///Mostrar Tipo de Producto Producto
            Item[] ltp = (Item[]) cbTipoProducto.getItemListeners();
            for (Item l1 : ltp) {
                if (l1.getId().equals(p.getMarca())) {
                    cbMarca.setSelectedItem(l1);
                    break;
                }
            }
        ///Mostrar Talla Producto
            Item[] lt = (Item[]) cbTalla.getItemListeners();
            for (Item l1 : lt) {
                if (l1.getId().equals(p.getMarca())) {
                    cbMarca.setSelectedItem(l1);
                    break;
                }
            }
        ///Mostrar Genero Producto
            Item[] lg = (Item[]) cbGenero.getItemListeners();
            for (Item l1 : lg) {
                if (l1.getId().equals(p.getMarca())) {
                    cbMarca.setSelectedItem(l1);
                    break;
                }
            }
    }
    
    private void limpiarCampos()
    {
        cbMarca.removeAllItems();
        cbMarca.addItem("- - - - Marca - - - -");
        cbTipoProducto.removeAllItems();
        cbTipoProducto.addItem("- - Tipo de Producto - -");
        cbTalla.removeAllItems();
        cbTalla.addItem("- - - - Talla - - - -");
        cbGenero.removeAllItems();
        cbGenero.addItem("- - - Género - - -");
        
        
        tColor.setText("");
        tDescripción.setText("");
        tCostoDolares.setText("");
        tImpuestoProducto.setText("");
        tEnvioProducto.setText("");
        tTotalDolares.setText("");
        tTipoCambio.setText("");
        tEnvioGuate.setText("");
        tTotalQ.setText("");
        tPorcentajeGanancia.setText("");
        tGananciaEstimada.setText("");
        tPrecioVenta.setText("");
        tPorcentajeGananciaSugerida.setText("");
        tGanaciaSugerida.setText("");
        tPrecioSugerido.setText("");
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
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tCodigoProducto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbMarca = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cbTipoProducto = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cbTalla = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        cbGenero = new javax.swing.JComboBox();
        tColor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tDescripción = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        tCostoDolares = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tImpuestoProducto = new javax.swing.JTextField();
        tTotalDolares = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tEnvioProducto = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tCostosQ = new javax.swing.JTextField();
        tTotalQ = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tEnvioGuate = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        tTipoCambio = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        tPorcentajeGanancia = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        tGananciaEstimada = new javax.swing.JTextField();
        tPorcentajeGananciaSugerida = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        tPrecioVenta = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        tPrecioSugerido = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        tGanaciaSugerida = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        pPrincipal.setLayout(new javax.swing.BoxLayout(pPrincipal, javax.swing.BoxLayout.Y_AXIS));

        pTitulo.setBackground(new java.awt.Color(255, 153, 0));
        pTitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pTitulo.setMaximumSize(new java.awt.Dimension(32767, 40));
        pTitulo.setPreferredSize(new java.awt.Dimension(721, 40));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Edición de Productos");

        javax.swing.GroupLayout pTituloLayout = new javax.swing.GroupLayout(pTitulo);
        pTitulo.setLayout(pTituloLayout);
        pTituloLayout.setHorizontalGroup(
            pTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(838, Short.MAX_VALUE))
        );
        pTituloLayout.setVerticalGroup(
            pTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pPrincipal.add(pTitulo);

        pContenedor.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Código Producto");

        tCodigoProducto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tCodigoProducto.setMinimumSize(new java.awt.Dimension(4, 30));
        tCodigoProducto.setPreferredSize(new java.awt.Dimension(73, 30));
        tCodigoProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tCodigoProductoKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Marca");

        cbMarca.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cbMarca.setPreferredSize(new java.awt.Dimension(70, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Tipo de Producto");

        cbTipoProducto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cbTipoProducto.setPreferredSize(new java.awt.Dimension(70, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Talla");

        cbTalla.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cbTalla.setPreferredSize(new java.awt.Dimension(70, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Genero");

        cbGenero.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cbGenero.setPreferredSize(new java.awt.Dimension(70, 30));

        tColor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tColor.setMinimumSize(new java.awt.Dimension(4, 30));
        tColor.setPreferredSize(new java.awt.Dimension(73, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Color");

        tDescripción.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tDescripción.setMinimumSize(new java.awt.Dimension(4, 30));
        tDescripción.setPreferredSize(new java.awt.Dimension(73, 30));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Descripción");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbTipoProducto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbMarca, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tCodigoProducto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbTalla, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbGenero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tDescripción, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbTipoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbTalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tDescripción, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Costo Dolares:");

        tCostoDolares.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tCostoDolares.setMinimumSize(new java.awt.Dimension(4, 30));
        tCostoDolares.setPreferredSize(new java.awt.Dimension(73, 30));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("Impuesto:");

        tImpuestoProducto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tImpuestoProducto.setMinimumSize(new java.awt.Dimension(4, 30));
        tImpuestoProducto.setPreferredSize(new java.awt.Dimension(73, 30));

        tTotalDolares.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tTotalDolares.setMinimumSize(new java.awt.Dimension(4, 30));
        tTotalDolares.setPreferredSize(new java.awt.Dimension(73, 30));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setText("Envio");

        tEnvioProducto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tEnvioProducto.setMinimumSize(new java.awt.Dimension(4, 30));
        tEnvioProducto.setPreferredSize(new java.awt.Dimension(73, 30));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel12.setText("Total Dolares");

        tCostosQ.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tCostosQ.setMinimumSize(new java.awt.Dimension(4, 30));
        tCostosQ.setPreferredSize(new java.awt.Dimension(73, 30));

        tTotalQ.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tTotalQ.setMinimumSize(new java.awt.Dimension(4, 30));
        tTotalQ.setPreferredSize(new java.awt.Dimension(73, 30));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel13.setText("Envio Guate:");

        tEnvioGuate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tEnvioGuate.setMinimumSize(new java.awt.Dimension(4, 30));
        tEnvioGuate.setPreferredSize(new java.awt.Dimension(73, 30));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setText("Tipo Cambio");

        jLabel15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel15.setText("Total Q. :");

        tTipoCambio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tTipoCambio.setMinimumSize(new java.awt.Dimension(4, 30));
        tTipoCambio.setPreferredSize(new java.awt.Dimension(73, 30));

        jLabel16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel16.setText("Costos Q. :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tTotalQ, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tEnvioGuate, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tCostosQ, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tTipoCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tTotalDolares, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tEnvioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tImpuestoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tCostoDolares, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tCostoDolares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tImpuestoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tEnvioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(tTotalDolares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(tTipoCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(tCostosQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(tEnvioGuate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(tTotalQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel17.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel17.setText("% Ganancia");

        tPorcentajeGanancia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tPorcentajeGanancia.setMinimumSize(new java.awt.Dimension(4, 30));
        tPorcentajeGanancia.setPreferredSize(new java.awt.Dimension(73, 30));

        jLabel18.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel18.setText("Ganancia Estimada");

        tGananciaEstimada.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tGananciaEstimada.setMinimumSize(new java.awt.Dimension(4, 30));
        tGananciaEstimada.setPreferredSize(new java.awt.Dimension(73, 30));

        tPorcentajeGananciaSugerida.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tPorcentajeGananciaSugerida.setMinimumSize(new java.awt.Dimension(4, 30));
        tPorcentajeGananciaSugerida.setPreferredSize(new java.awt.Dimension(73, 30));

        jLabel19.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel19.setText("Precio Venta");

        tPrecioVenta.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tPrecioVenta.setMinimumSize(new java.awt.Dimension(4, 30));
        tPrecioVenta.setPreferredSize(new java.awt.Dimension(73, 30));

        jLabel20.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel20.setText("% Ganancia Sugerida");

        tPrecioSugerido.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tPrecioSugerido.setMinimumSize(new java.awt.Dimension(4, 30));
        tPrecioSugerido.setPreferredSize(new java.awt.Dimension(73, 30));

        jLabel22.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel22.setText("Ganancia Sugerida");

        tGanaciaSugerida.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tGanaciaSugerida.setMinimumSize(new java.awt.Dimension(4, 30));
        tGanaciaSugerida.setPreferredSize(new java.awt.Dimension(73, 30));

        jLabel24.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel24.setText("Precio Sugerido");

        jButton1.setBackground(new java.awt.Color(255, 153, 0));
        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Realizar Cambios");

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Cancelar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tPorcentajeGananciaSugerida, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tGananciaEstimada, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tPorcentajeGanancia, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tGanaciaSugerida, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tPrecioSugerido, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(tPorcentajeGanancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(tGananciaEstimada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(tPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(tPorcentajeGananciaSugerida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(tGanaciaSugerida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(tPrecioSugerido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pContenedorLayout = new javax.swing.GroupLayout(pContenedor);
        pContenedor.setLayout(pContenedorLayout);
        pContenedorLayout.setHorizontalGroup(
            pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pContenedorLayout.setVerticalGroup(
            pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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

    private void tCodigoProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tCodigoProductoKeyPressed
        if(evt.getKeyCode() ==  KeyEvent.VK_ENTER)
        {
         editarProducto();
        }
    }//GEN-LAST:event_tCodigoProductoKeyPressed

    public void setIcon(Icon anIcon){
        setFrameIcon(anIcon);
    }
     
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(new Color(100, 0, 4, 85));
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbGenero;
    private javax.swing.JComboBox cbMarca;
    private javax.swing.JComboBox cbTalla;
    private javax.swing.JComboBox cbTipoProducto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel pContenedor;
    private javax.swing.JPanel pPrincipal;
    private javax.swing.JPanel pTitulo;
    private javax.swing.JTextField tCodigoProducto;
    private javax.swing.JTextField tColor;
    private javax.swing.JTextField tCostoDolares;
    private javax.swing.JTextField tCostosQ;
    private javax.swing.JTextField tDescripción;
    private javax.swing.JTextField tEnvioGuate;
    private javax.swing.JTextField tEnvioProducto;
    private javax.swing.JTextField tGanaciaSugerida;
    private javax.swing.JTextField tGananciaEstimada;
    private javax.swing.JTextField tImpuestoProducto;
    private javax.swing.JTextField tPorcentajeGanancia;
    private javax.swing.JTextField tPorcentajeGananciaSugerida;
    private javax.swing.JTextField tPrecioSugerido;
    private javax.swing.JTextField tPrecioVenta;
    private javax.swing.JTextField tTipoCambio;
    private javax.swing.JTextField tTotalDolares;
    private javax.swing.JTextField tTotalQ;
    // End of variables declaration//GEN-END:variables
}
