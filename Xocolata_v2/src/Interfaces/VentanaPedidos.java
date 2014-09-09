/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaces;

import Clases.Pedidos;
import Querys.PedidoQuerys;
import java.awt.Color;
import java.awt.Graphics;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Marco
 */
public class VentanaPedidos extends javax.swing.JInternalFrame {

    Hilo hilo;
    String fechaActual;
    /**
     * Creates new form VentanaPedidos
     */
    public VentanaPedidos() {
        initComponents();
        this.setFrameIcon(new ImageIcon(this.getClass().getResource("/Imagenes/xocolata.jpg")));
        
        Calendar fecha = new GregorianCalendar();
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int mes = fecha.get(Calendar.MONTH)+1;
        int año = fecha.get(Calendar.YEAR);
        fechaActual = Integer.toString(año) + "-" + Integer.toString(mes) + "-" + Integer.toString(dia);
        tTotal.setEditable(false);
        hilo = new Hilo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pPrincipal = new javax.swing.JPanel();
        pTitulo = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        pContenedor = new javax.swing.JPanel();
        tCodigo = new javax.swing.JTextField();
        tSubtotal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tImpuesto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tEnvio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tCantidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tEnvioGT = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tCambio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Btn_Ingresar_Pedido = new javax.swing.JButton();
        tTotal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);

        pPrincipal.setLayout(new javax.swing.BoxLayout(pPrincipal, javax.swing.BoxLayout.Y_AXIS));

        pTitulo.setBackground(new java.awt.Color(0, 102, 255));
        pTitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pTitulo.setPreferredSize(new java.awt.Dimension(390, 40));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ingreso de Pedidos");

        javax.swing.GroupLayout pTituloLayout = new javax.swing.GroupLayout(pTitulo);
        pTitulo.setLayout(pTituloLayout);
        pTituloLayout.setHorizontalGroup(
            pTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(205, Short.MAX_VALUE))
        );
        pTituloLayout.setVerticalGroup(
            pTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTituloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        pPrincipal.add(pTitulo);

        pContenedor.setBackground(new java.awt.Color(255, 255, 255));

        tCodigo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tCodigo.setPreferredSize(new java.awt.Dimension(4, 30));

        tSubtotal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tSubtotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tSubtotal.setText("0");
        tSubtotal.setPreferredSize(new java.awt.Dimension(12, 30));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Codigo del Pedido");

        tImpuesto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tImpuesto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tImpuesto.setText("0");
        tImpuesto.setPreferredSize(new java.awt.Dimension(12, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Subtotal del Pedido ($)");

        tEnvio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tEnvio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tEnvio.setText("0");
        tEnvio.setMinimumSize(new java.awt.Dimension(4, 30));
        tEnvio.setPreferredSize(new java.awt.Dimension(12, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Impuesto del Pedido ($)");

        tCantidad.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tCantidad.setPreferredSize(new java.awt.Dimension(4, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Envío del Pedido ($)");

        tEnvioGT.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tEnvioGT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tEnvioGT.setPreferredSize(new java.awt.Dimension(4, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Envío Guatemala (Q)");

        tCambio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tCambio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tCambio.setPreferredSize(new java.awt.Dimension(4, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Tipo de Cambio");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Cantidad de Productos");

        Btn_Ingresar_Pedido.setBackground(new java.awt.Color(0, 102, 255));
        Btn_Ingresar_Pedido.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Btn_Ingresar_Pedido.setForeground(new java.awt.Color(255, 255, 255));
        Btn_Ingresar_Pedido.setText("Ingresar Pedido");
        Btn_Ingresar_Pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Ingresar_PedidoActionPerformed(evt);
            }
        });

        tTotal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tTotal.setText("0");
        tTotal.setFocusable(false);
        tTotal.setPreferredSize(new java.awt.Dimension(12, 30));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("Total del Pedido ($)");

        javax.swing.GroupLayout pContenedorLayout = new javax.swing.GroupLayout(pContenedor);
        pContenedor.setLayout(pContenedorLayout);
        pContenedorLayout.setHorizontalGroup(
            pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pContenedorLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pContenedorLayout.createSequentialGroup()
                                    .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                .addGroup(pContenedorLayout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addGap(43, 43, 43)))
                            .addGroup(pContenedorLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(23, 23, 23)))
                        .addGroup(pContenedorLayout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(35, 35, 35)))
                    .addGroup(pContenedorLayout.createSequentialGroup()
                        .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(23, 23, 23)))
                .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Btn_Ingresar_Pedido)
                    .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(tCambio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tEnvioGT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tCantidad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tTotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                        .addComponent(tCodigo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tSubtotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tImpuesto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tEnvio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        pContenedorLayout.setVerticalGroup(
            pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pContenedorLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tEnvioGT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Btn_Ingresar_Pedido)
                .addContainerGap(25, Short.MAX_VALUE))
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
            .addComponent(pPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_Ingresar_PedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Ingresar_PedidoActionPerformed
        PedidoQuerys.insertarPedido(crearPedido());
        limpiarCampos();
    }//GEN-LAST:event_Btn_Ingresar_PedidoActionPerformed

    public void limpiarCampos() {
        tCambio.setText("");
        tCantidad.setText("");
        tCodigo.setText("");
        tEnvio.setText("0");
        tEnvioGT.setText("");
        tImpuesto.setText("0");
        tSubtotal.setText("0");
    }
    
    private Pedidos crearPedido() {
        DecimalFormat formato = new DecimalFormat("0.00");
        Pedidos pedido = new Pedidos();
        
        pedido.setCodigo(tCodigo.getText());
        pedido.setFecha(fechaActual);
        pedido.setSubtotal(Double.parseDouble(formato.format(((Double.parseDouble(tSubtotal.getText()))))));
        pedido.setImpuesto(Double.parseDouble(formato.format(((Double.parseDouble(tImpuesto.getText()))))));
        pedido.setEnvioUSA(Double.parseDouble(formato.format(((Double.parseDouble(tEnvio.getText()))))));
        pedido.setCantidadProductos(Integer.parseInt((tCantidad.getText())));
        pedido.setEnvioGTUnitario(Double.parseDouble(formato.format(((Double.parseDouble(tEnvioGT.getText()))))));
        pedido.setTipoCambio(Double.parseDouble(formato.format(((Double.parseDouble(tCambio.getText()))))));
        
        pedido.setImpuestoUnitario(Double.parseDouble(formato.format(Double.parseDouble(tImpuesto.getText())*100 /(Double.parseDouble(tSubtotal.getText())))));
        pedido.setEnvioUSAUnitario(Double.parseDouble(formato.format(Double.parseDouble(tEnvio.getText())/ (Double.parseDouble(tCantidad.getText())))));

        return pedido;
    }
    
    public class Hilo implements Runnable {
        private final Thread t;
        DecimalFormat df = new DecimalFormat("0.00");
        public Hilo() 
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
                    if ((tSubtotal.getText().length() != 0) && (tImpuesto.getText().length() != 0) && (tEnvio.getText().length() != 0))
                    {
                        try
                        {
                            tTotal.setText(String.valueOf(df.format(Double.parseDouble(tSubtotal.getText()) + Double.parseDouble(tImpuesto.getText()) + Double.parseDouble(tEnvio.getText()))));
                        }
                        catch (NumberFormatException exp)
                        {

                        }
                    }
                    Thread.sleep(10);
                }
                catch (InterruptedException exp) {
                    
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
    private javax.swing.JButton Btn_Ingresar_Pedido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel pContenedor;
    private javax.swing.JPanel pPrincipal;
    private javax.swing.JPanel pTitulo;
    private javax.swing.JTextField tCambio;
    private javax.swing.JTextField tCantidad;
    private javax.swing.JTextField tCodigo;
    private javax.swing.JTextField tEnvio;
    private javax.swing.JTextField tEnvioGT;
    private javax.swing.JTextField tImpuesto;
    private javax.swing.JTextField tSubtotal;
    private javax.swing.JTextField tTotal;
    // End of variables declaration//GEN-END:variables
}
