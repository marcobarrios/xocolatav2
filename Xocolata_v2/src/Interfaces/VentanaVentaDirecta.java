/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaces;

import Clases.Transacciones;
import ContenedorComboBox.Item;
import Querys.PersonaQuerys;
import Querys.ProductoQuerys;
import Querys.TransaccionQuerys;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import xocolata_v2.ConexionDB;

/**
 *
 * @author Marco
 */
public class VentanaVentaDirecta extends javax.swing.JInternalFrame {

    int idTransaccion;
    double total;
    String fechaActual;
    HiloCalculos hilo;
    /**
     * Creates new form VentanaVentaDirecta
     */
    public VentanaVentaDirecta() {
        initComponents();
        cargarDatosCliente();
        
        Calendar fecha = new GregorianCalendar();
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int mes = fecha.get(Calendar.MONTH)+1;
        int año = fecha.get(Calendar.YEAR);
        fechaActual = Integer.toString(año) + "-" + Integer.toString(mes) + "-" + Integer.toString(dia);
        
        rPrecioVenta.setSelected(true);
        DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
        dlcr.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
        cbCliente.setRenderer(dlcr);
    }
    
    private void cargarDatosCliente() {
        ResultSet dato;
        Connection conexion = ConexionDB.ObtenerConexion();
            try
            {
            try (Statement comando = (Statement)conexion.createStatement()) {
                dato = comando.executeQuery("SELECT idPersona, nombrePersona FROM tblPersonas WHERE idTipoPersona = '2' ORDER BY nombrePersona");
                while(dato.next())
                {
                    Item cliente = new Item(dato.getString("idPersona"), dato.getString("nombrePersona"));
                    cbCliente.addItem(cliente);
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
        lTitulo = new javax.swing.JLabel();
        pContenedor = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbCliente = new javax.swing.JComboBox();
        bIniciarTransaccion = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductosTransaccion = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        rContado = new javax.swing.JRadioButton();
        rCredito = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        tProducto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lSubTotal = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lCantidad = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tOferta = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lTotal = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        rPrecioVenta = new javax.swing.JRadioButton();
        rPrecioSugerido = new javax.swing.JRadioButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        pPrincipal.setLayout(new javax.swing.BoxLayout(pPrincipal, javax.swing.BoxLayout.Y_AXIS));

        pTitulo.setBackground(new java.awt.Color(0, 153, 204));
        pTitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pTitulo.setMaximumSize(new java.awt.Dimension(32767, 40));
        pTitulo.setPreferredSize(new java.awt.Dimension(1090, 40));

        lTitulo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lTitulo.setText("Venta Directa");

        javax.swing.GroupLayout pTituloLayout = new javax.swing.GroupLayout(pTitulo);
        pTitulo.setLayout(pTituloLayout);
        pTituloLayout.setHorizontalGroup(
            pTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lTitulo)
                .addContainerGap(1035, Short.MAX_VALUE))
        );
        pTituloLayout.setVerticalGroup(
            pTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTituloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lTitulo)
                .addContainerGap())
        );

        pPrincipal.add(pTitulo);

        pContenedor.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Cliente:");

        cbCliente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbCliente.setMinimumSize(new java.awt.Dimension(32, 30));

        bIniciarTransaccion.setBackground(new java.awt.Color(0, 153, 204));
        bIniciarTransaccion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bIniciarTransaccion.setForeground(new java.awt.Color(255, 255, 255));
        bIniciarTransaccion.setText("Crear Venta");
        bIniciarTransaccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bIniciarTransaccionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bIniciarTransaccion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(bIniciarTransaccion))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton3.setBackground(new java.awt.Color(0, 153, 51));
        jButton3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Aceptar e Imprimir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Cancelar Venta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tblProductosTransaccion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblProductosTransaccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblProductosTransaccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosTransaccionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProductosTransaccion);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo Venta"));
        jPanel3.setMaximumSize(new java.awt.Dimension(288, 71));

        rContado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rContado.setText("Venta al Contado");
        rContado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rContadoActionPerformed(evt);
            }
        });

        rCredito.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rCredito.setText("Venta al Crédito");
        rCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rCreditoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rContado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rCredito)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rContado)
                    .addComponent(rCredito))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

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

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Codigo de producto");

        lSubTotal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lSubTotal.setText("0.0");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("SubTotal: Q. ");

        lCantidad.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lCantidad.setText("0");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Cantidad:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 495, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lCantidad)
                .addGap(63, 63, 63)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lSubTotal)
                .addGap(22, 22, 22))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(lSubTotal)
                    .addComponent(jLabel5)
                    .addComponent(lCantidad)
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Ofertar Venta"));
        jPanel4.setMaximumSize(new java.awt.Dimension(288, 71));
        jPanel4.setPreferredSize(new java.awt.Dimension(288, 71));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Oferta (%):");

        tOferta.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tOferta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tOferta.setText("0");

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 13)); // NOI18N
        jLabel6.setText("TOTAL: Q.");

        lTotal.setFont(new java.awt.Font("Arial Black", 1, 13)); // NOI18N
        lTotal.setText("0.0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lTotal)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tOferta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(lTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Precio a Usar"));
        jPanel5.setMaximumSize(new java.awt.Dimension(288, 71));

        rPrecioVenta.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rPrecioVenta.setText("Precio de Venta");
        rPrecioVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rPrecioVentaActionPerformed(evt);
            }
        });

        rPrecioSugerido.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rPrecioSugerido.setText("Precio Sugerido");
        rPrecioSugerido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rPrecioSugeridoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rPrecioVenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rPrecioSugerido)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rPrecioVenta)
                    .addComponent(rPrecioSugerido))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pContenedorLayout = new javax.swing.GroupLayout(pContenedor);
        pContenedor.setLayout(pContenedorLayout);
        pContenedorLayout.setHorizontalGroup(
            pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pContenedorLayout.createSequentialGroup()
                .addGap(304, 304, 304)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(271, 271, 271))
            .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pContenedorLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pContenedorLayout.createSequentialGroup()
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addContainerGap()))
        );
        pContenedorLayout.setVerticalGroup(
            pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pContenedorLayout.createSequentialGroup()
                .addContainerGap(401, Short.MAX_VALUE)
                .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pContenedorLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pContenedorLayout.createSequentialGroup()
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void bIniciarTransaccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bIniciarTransaccionActionPerformed
        Item persona = (Item)cbCliente.getSelectedItem();
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
        transaccion.setTipoTransccion(2);
        idTransaccion = TransaccionQuerys.insertarTransaccion(transaccion);

        habilitarPanel(false);
        cargarTablaProductosTransaccion();
        hilo = new HiloCalculos();
        tProducto.setEnabled(true);
        tProducto.requestFocus();
    }//GEN-LAST:event_bIniciarTransaccionActionPerformed

    private void habilitarPanel(boolean cambio) {

            Component[] lista = jPanel1.getComponents();
            for(int i = 0; i < jPanel1.getComponents().length; i++)
            {
                lista[i].setEnabled(cambio);
            }
        }
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        TransaccionQuerys.agregarPreciosTransaccion(idTransaccion, Integer.parseInt(lCantidad.getText()), Double.parseDouble(lSubTotal.getText()), Double.parseDouble(tOferta.getText()), Double.parseDouble(lSubTotal.getText())-Double.parseDouble(lTotal.getText()), Double.parseDouble(lTotal.getText()));
        if (rContado.isSelected()) {
            //LLAMAR REPORTE VENTA DIRECTA AL CONTADO 
        }
        else if (rCredito.isSelected()) {
            final Calendario ventana = new Calendario();
            Dimension desktopSize = this.getParent().getSize();
            Dimension jInternalFrameSize = ventana.getSize();
            ventana.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
                                (desktopSize.height- jInternalFrameSize.height)/2);
            this.getParent().add(ventana);
            ventana.show();
            ventana.addInternalFrameListener(new InternalFrameListener() {
			@Override
			public void internalFrameClosing(InternalFrameEvent arg0) {}
			@Override public void internalFrameOpened(InternalFrameEvent arg0)      {}
			@Override public void internalFrameIconified(InternalFrameEvent arg0)   {}
			@Override public void internalFrameDeiconified(InternalFrameEvent arg0) {}
			@Override public void internalFrameDeactivated(InternalFrameEvent arg0) {}
			@Override public void internalFrameClosed(InternalFrameEvent arg0)      
                        {
                            String fecha = ventana.getFechaFinal();
                            TransaccionQuerys.ingresarFechaLimite(idTransaccion, fecha);
                            cargarAbono();
                            //LLAMAR REPORTE VENTA DIRECTA AL CREDITO
                        }
			@Override public void internalFrameActivated(InternalFrameEvent arg0)   {}
		});

        }
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cargarAbono() {
        Item persona = (Item)cbCliente.getSelectedItem();
        int id =  Integer.parseInt(persona.getId());
        String abono = JOptionPane.showInputDialog(null, "Ingrese Abono sobre: " + total, 0);
        PersonaQuerys.cargarSaldo(id, total);
        PersonaQuerys.cargarAbono(Double.parseDouble(abono), fechaActual, id);
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int resultado = JOptionPane.showConfirmDialog(null, "¿Seguro desea cancelar esta transacción?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(resultado == JOptionPane.YES_OPTION)
        {
            TransaccionQuerys.cancelarTransaccion(idTransaccion);
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    int temporal=-1;
    private void tblProductosTransaccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosTransaccionMouseClicked
        if(!evt.isMetaDown())
        {
            if(tblProductosTransaccion.getSelectedRow() == temporal)
            {
                int resultado = JOptionPane.showConfirmDialog(null, "¿Seguro desea borrar este producto de la transacción?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if(resultado == JOptionPane.YES_OPTION)
                {
                    Item idProducto = (Item)tblProductosTransaccion.getValueAt(temporal, 0);
                    TransaccionQuerys.devolverProductoTransaccion(idTransaccion, Integer.parseInt(idProducto.getId()));
                    ProductoQuerys.cambiarEstadoProducto(Integer.parseInt(idProducto.getId()), 1);
                    cargarTablaProductosTransaccion();
                }
            }
            else
            {
                temporal = tblProductosTransaccion.getSelectedRow();
            }
        }
    }//GEN-LAST:event_tblProductosTransaccionMouseClicked

    private void rContadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rContadoActionPerformed
        rContado.setSelected(true);
        rCredito.setSelected(false);
    }//GEN-LAST:event_rContadoActionPerformed

    private void rCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rCreditoActionPerformed
        rContado.setSelected(false);
        rCredito.setSelected(true);
    }//GEN-LAST:event_rCreditoActionPerformed

    private void cargarProducto(String codigo) {
        int idProducto = ProductoQuerys.buscarIdProductoDisponible(codigo);
        if (idProducto != 0) {
            TransaccionQuerys.ingresarDetalleTransaccion(idTransaccion, idProducto, fechaActual);
            ProductoQuerys.cambiarEstadoProducto(idProducto, 3);
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

    private void rPrecioVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rPrecioVentaActionPerformed
        rPrecioVenta.setSelected(true);
        rPrecioSugerido.setSelected(false);
    }//GEN-LAST:event_rPrecioVentaActionPerformed

    private void rPrecioSugeridoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rPrecioSugeridoActionPerformed
        rPrecioVenta.setSelected(false);
        rPrecioSugerido.setSelected(true);
    }//GEN-LAST:event_rPrecioSugeridoActionPerformed

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
                            lTotal.setText(df.format(Double.parseDouble(lSubTotal.getText())*(100-Double.parseDouble(tOferta.getText()))/100));
                            total = Double.parseDouble(lTotal.getText());
                        }
                        catch(NumberFormatException exp)
                        {
                            int hasta = tOferta.getText().length() - 1;
                            String resultado = tOferta.getText().substring(0, hasta);
                            tOferta.setText(resultado);
                            tOferta.setCaretPosition(hasta);
                        }
                        lCantidad.setText(String.valueOf(TransaccionQuerys.contarProductosTransaccion(idTransaccion)));
                        if (rPrecioVenta.isSelected())
                            lSubTotal.setText(String.valueOf(TransaccionQuerys.sumaPrecioVentaTransaccion(idTransaccion)));
                        else if (rPrecioSugerido.isSelected())
                            lSubTotal.setText(String.valueOf(TransaccionQuerys.sumaPrecioSugeridoTransaccion(idTransaccion)));
                    }
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
    private javax.swing.JButton bIniciarTransaccion;
    private javax.swing.JComboBox cbCliente;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lCantidad;
    private javax.swing.JLabel lSubTotal;
    private javax.swing.JLabel lTitulo;
    private javax.swing.JLabel lTotal;
    private javax.swing.JPanel pContenedor;
    private javax.swing.JPanel pPrincipal;
    private javax.swing.JPanel pTitulo;
    private javax.swing.JRadioButton rContado;
    private javax.swing.JRadioButton rCredito;
    private javax.swing.JRadioButton rPrecioSugerido;
    private javax.swing.JRadioButton rPrecioVenta;
    private javax.swing.JTextField tOferta;
    private javax.swing.JTextField tProducto;
    private javax.swing.JTable tblProductosTransaccion;
    // End of variables declaration//GEN-END:variables
}
