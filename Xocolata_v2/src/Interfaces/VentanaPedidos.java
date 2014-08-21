/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaces;

import Clases.Pedidos;
import Querys.PedidoQuerys;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Btn_Ingresar_Pedido = new javax.swing.JButton();
        tTotal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);

        tCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        tSubtotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tSubtotal.setText("0");

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel1.setText("Codigo del Pedido");

        tImpuesto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tImpuesto.setText("0");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel2.setText("Subtotal del Pedido ($)");

        tEnvio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tEnvio.setText("0");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel3.setText("Impuesto del Pedido ($)");

        tCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel4.setText("Envío del Pedido ($)");

        tEnvioGT.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel5.setText("Envío Guatemala (Q)");

        tCambio.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel6.setText("Tipo de Cambio");

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel7.setText("Ingreso de Pedidos");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel9.setText("Cantidad de Productos");

        Btn_Ingresar_Pedido.setText("Ingresar Datos de Pedido");
        Btn_Ingresar_Pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Ingresar_PedidoActionPerformed(evt);
            }
        });

        tTotal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tTotal.setText("0");

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel10.setText("Total del Pedido ($)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tEnvioGT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(83, 83, 83))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Btn_Ingresar_Pedido)
                        .addGap(68, 68, 68))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tEnvioGT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Btn_Ingresar_Pedido)
                .addContainerGap(23, Short.MAX_VALUE))
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Ingresar_Pedido;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
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
