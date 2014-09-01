/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaces;

import ContenedorComboBox.Item;
import java.awt.Color;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import xocolata_v2.ConexionDB;

/**
 *
 * @author Equipo
 */
public class VentanaConsultaTransacciones extends javax.swing.JInternalFrame {

    String id ;
    public VentanaConsultaTransacciones() {
        initComponents();
        jTable1.setColumnSelectionAllowed(false);
        jTable1.setRowSelectionAllowed(true);
        cargarDatos();
        //this.setFrameIcon(new ImageIcon(this.getClass().getResource("/16x16/logo.png")));
    }

    public void cargarDatos() {
        try
        {
            ResultSet dato;
            try (Connection conexion = ConexionDB.ObtenerConexion(); 
                    Statement comando = (Statement)conexion.createStatement()) {
                dato = comando.executeQuery("Select idPersona, nombrePersona from tblPersonas ORDER BY nombrePersona");
                while(dato.next())
                {
                    Item persona = new Item(dato.getString("idPersona"), dato.getString("nombrePersona"));
                    cbPersona.addItem(persona);
                }
                dato.close();
            }
         }
         catch (SQLException ex)
         {
             JOptionPane.showMessageDialog(null, ex.getMessage());
         }
    }
    
    private void cargarTabla() {
        String[] titulos={"Código", "Fecha", "Cantidad de Productos", "SubTotal", "Oferta(%)", "Total"};
        Object[] registros = new Object[6];
        DefaultTableModel model= new DefaultTableModel(null,titulos){public boolean isCellEditable(int rowIndex,int columnIndex){return false;} };
        Connection conexion = ConexionDB.ObtenerConexion();            
        if(conexion!=null)
        {
            try
            {
                Statement Query = conexion.createStatement();            
                ResultSet Datos = Query.executeQuery("SELECT idTransaccion, codigoTransaccion, fechaTransaccion, cantidadProductos, subtotalTransaccion, porcentajeOferta, totalTransaccion "
                                                        + "from tblTransacciones where idPersona = '" + id + "' ORDER BY codigoTransaccion DESC");
                Datos = Query.getResultSet();                    
                while (Datos.next()) 
                {
                    registros[0]= new Item(Datos.getString("idTransaccion"),Datos.getString("codigoTransaccion"));
                    registros[1]=Datos.getString("fechaTransaccion");
                    registros[2]=Datos.getString("cantidadProductos");
                    registros[3]=Datos.getString("subtotalTransaccion");
                    registros[4]=Datos.getString("porcentajeOferta");
                    registros[5]=Datos.getString("totalTransaccion");
                    model.addRow(registros);
                }
                jTable1.setModel(model);
            }
            catch (SQLException exp) 
            {
                JOptionPane.showMessageDialog(null, exp.toString());
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pPrincipal = new javax.swing.JPanel();
        pTItulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pContenedor = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbPersona = new javax.swing.JComboBox();
        bAceptar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);

        pPrincipal.setLayout(new javax.swing.BoxLayout(pPrincipal, javax.swing.BoxLayout.Y_AXIS));

        pTItulo.setBackground(new java.awt.Color(255, 51, 0));
        pTItulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pTItulo.setMaximumSize(new java.awt.Dimension(32767, 40));
        pTItulo.setPreferredSize(new java.awt.Dimension(673, 40));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Consulta de Ventas");

        javax.swing.GroupLayout pTItuloLayout = new javax.swing.GroupLayout(pTItulo);
        pTItulo.setLayout(pTItuloLayout);
        pTItuloLayout.setHorizontalGroup(
            pTItuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTItuloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(501, Short.MAX_VALUE))
        );
        pTItuloLayout.setVerticalGroup(
            pTItuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTItuloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        pPrincipal.add(pTItulo);

        pContenedor.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Seleccione Persona:");

        cbPersona.setBackground(new java.awt.Color(255, 255, 255));
        cbPersona.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbPersona.setPreferredSize(new java.awt.Dimension(32, 30));

        bAceptar.setBackground(new java.awt.Color(255, 51, 0));
        bAceptar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bAceptar.setForeground(new java.awt.Color(255, 255, 255));
        bAceptar.setText("Aceptar");
        bAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bAceptar))
                .addContainerGap())
        );

        jTable1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout pContenedorLayout = new javax.swing.GroupLayout(pContenedor);
        pContenedor.setLayout(pContenedorLayout);
        pContenedorLayout.setHorizontalGroup(
            pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 687, Short.MAX_VALUE)
            .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pContenedorLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pContenedorLayout.createSequentialGroup()
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(jScrollPane1))
                    .addContainerGap()))
        );
        pContenedorLayout.setVerticalGroup(
            pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 441, Short.MAX_VALUE)
            .addGroup(pContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pContenedorLayout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
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

    private void bAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarActionPerformed
        Item persona = (Item)cbPersona.getSelectedItem();
        id = persona.getId();
        cargarTabla();
    }//GEN-LAST:event_bAceptarActionPerformed

    int temporal = -1;
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if(!evt.isMetaDown())
        {
            if(jTable1.getSelectedRow() == temporal)
            {
                Item idTransaccion = (Item)jTable1.getValueAt(temporal, 0);
                //////IMPLEMENTAR CÓDIGO llamar reporter Transaccion/venta
                //Rinventario Rinv=new Rinventario(idTransaccion.getId(),"src\\Reportes\\Historiales\\HistorialTransaccion.jasper");
                //Rinv.setVisible(true);
                //this.getParent().add(Rinv);        
                //Rinv.show();
                //try {
                //Rinv.setSelected(true);
                //} catch (PropertyVetoException ex) {
                //Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                //}

            }
            else
            {
                temporal = jTable1.getSelectedRow();
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    public void setIcon(Icon anIcon){
        setFrameIcon(anIcon);
    }
     
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(new Color(100, 0, 4, 85));
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAceptar;
    private javax.swing.JComboBox cbPersona;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel pContenedor;
    private javax.swing.JPanel pPrincipal;
    private javax.swing.JPanel pTItulo;
    // End of variables declaration//GEN-END:variables
}
