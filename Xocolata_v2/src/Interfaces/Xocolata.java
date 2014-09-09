/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaces;

import ReportesClases.VentanaDatosClientes;
import ReportesClases.VentanaDatosVendedores;
import java.awt.Dimension;

/**
 *
 * @author Marco
 */
public class Xocolata extends javax.swing.JFrame {

    /**
     * Creates new form Xocolata
     */
    public Xocolata() {
        iniciarInterno();
        initComponents();
    }

    private void iniciarInterno()
    {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Xocolata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Xocolata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Xocolata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Xocolata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        jMenu5 = new javax.swing.JMenu();
        jMenu11 = new javax.swing.JMenu();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu13 = new javax.swing.JMenu();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu14 = new javax.swing.JMenu();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenu12 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();

        jMenu5.setText("jMenu5");

        jMenu11.setText("jMenu11");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane1.setBorder(new BackgroundImage());

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 811, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 438, Short.MAX_VALUE)
        );

        jMenu1.setText("Archivo");

        jMenuItem5.setText("Cerrar");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ingresar");

        jMenu4.setText("Pedido");

        jMenuItem3.setText("Ingresar Pedido");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        jMenu2.add(jMenu4);

        jMenu3.setText("Producto");

        jMenuItem1.setText("Ingresar Productos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem2.setText("Editar Producto");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem20.setText("Ofertar Productos");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem20);

        jMenu2.add(jMenu3);

        jMenuBar1.add(jMenu2);

        jMenu6.setText("Personas");

        jMenuItem6.setText("Vendedores");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem6);

        jMenuItem7.setText("Clientes");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem7);

        jMenu13.setText("Agregar Teléfonos");

        jMenuItem16.setText("Vendedor");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem16);

        jMenuItem17.setText("Cliente");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem17);

        jMenu6.add(jMenu13);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Transacciones");

        jMenuItem8.setText("Salida de Producto");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem8);

        jMenuItem9.setText("Venta Directa");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem9);

        jMenuItem10.setText("Gastos");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem10);

        jMenuBar1.add(jMenu7);

        jMenu8.setText("Abonos");

        jMenuItem11.setText("Vendedores");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem11);

        jMenuItem12.setText("Clientes");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem12);

        jMenuBar1.add(jMenu8);

        jMenu14.setText("Devoluciones");

        jMenuItem18.setText("de Vendedores");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem18);

        jMenuItem19.setText("de Clientes");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem19);

        jMenuBar1.add(jMenu14);

        jMenu12.setText("Consultas");

        jMenuItem4.setText("Pedidos");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem4);

        jMenuItem15.setText("Transacciones");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem15);

        jMenuBar1.add(jMenu12);

        jMenu9.setText("Reportes");

        jMenuItem21.setText("Generar Códigos de Barras");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem21);

        jMenu10.setText("Personas");

        jMenuItem13.setText("Clientes");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem13);

        jMenuItem14.setText("Vendedores");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem14);

        jMenu9.add(jMenu10);

        jMenuBar1.add(jMenu9);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        VentanaPedidos ventana = new VentanaPedidos();
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = ventana.getSize();
        ventana.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
                            (desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(ventana);
        ventana.show();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        VentanaPersonas ventana = new VentanaPersonas("Vendedor");
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = ventana.getSize();
        ventana.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
                            (desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(ventana);
        ventana.show();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        VentanaPersonas ventana = new VentanaPersonas("Cliente");
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = ventana.getSize();
        ventana.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
                            (desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(ventana);
        ventana.show();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        VentanaSalidaProducto ventana = new VentanaSalidaProducto();
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = ventana.getSize();
        ventana.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
                            (desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(ventana);
        ventana.show();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        VentanaGastos ventana = new VentanaGastos();
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = ventana.getSize();
        ventana.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
                            (desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(ventana);
        ventana.show();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        VentanaProductos ventana = new VentanaProductos();
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = ventana.getSize();
        ventana.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
                            (desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(ventana);
        ventana.show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        VentanaAbonos ventana = new VentanaAbonos("Vendedor");
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = ventana.getSize();
        ventana.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
                            (desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(ventana);
        ventana.show();
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        VentanaAbonos ventana = new VentanaAbonos("Cliente");
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = ventana.getSize();
        ventana.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
                            (desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(ventana);
        ventana.show();
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        VentanaDatosClientes ventana = new VentanaDatosClientes();
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = ventana.getSize();
        ventana.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
                            (desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(ventana);
        ventana.show();
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        VentanaDatosVendedores ventana = new VentanaDatosVendedores();
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = ventana.getSize();
        ventana.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
                            (desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(ventana);
        ventana.show();
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        VentanaVentaDirecta ventana = new VentanaVentaDirecta();
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = ventana.getSize();
        ventana.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
                            (desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(ventana);
        ventana.show();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        VentanaConsultaPedidos ventana = new VentanaConsultaPedidos();
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = ventana.getSize();
        ventana.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
                            (desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(ventana);
        ventana.show();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        VentanaConsultaTransacciones ventana = new VentanaConsultaTransacciones();
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = ventana.getSize();
        ventana.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
                            (desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(ventana);
        ventana.show();
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        VentanaAgregarContactos ventana = new VentanaAgregarContactos("1");
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = ventana.getSize();
        ventana.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
                            (desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(ventana);
        ventana.show();
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        VentanaAgregarContactos ventana = new VentanaAgregarContactos("2");
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = ventana.getSize();
        ventana.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
                            (desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(ventana);
        ventana.show();
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        VentanaDevolucionVendedores ventana = new VentanaDevolucionVendedores();
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = ventana.getSize();
        ventana.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
                            (desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(ventana);
        ventana.show();
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        VentanaDevolucionClientes ventana = new VentanaDevolucionClientes();
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = ventana.getSize();
        ventana.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
                            (desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(ventana);
        ventana.show();
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        VentanaOfertaProductos ventana = new VentanaOfertaProductos();
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = ventana.getSize();
        ventana.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
                            (desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(ventana);
        ventana.show();
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        VentanaEditarProductos ventana = new VentanaEditarProductos();
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = ventana.getSize();
        ventana.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
                            (desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(ventana);
        ventana.show();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        VentanaGenerarCodigoBarras ventana = new VentanaGenerarCodigoBarras();
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = ventana.getSize();
        ventana.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
                            (desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(ventana);
        ventana.show();
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Xocolata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Xocolata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Xocolata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Xocolata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Xocolata().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    // End of variables declaration//GEN-END:variables
}
