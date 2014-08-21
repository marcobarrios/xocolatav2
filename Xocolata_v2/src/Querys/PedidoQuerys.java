/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Querys;

import Clases.Pedidos;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import xocolata_v2.ConexionDB;

/**
 *
 * @author Marco
 */
public class PedidoQuerys {
    
    public static void insertarPedido(Pedidos pedido) {
        Connection conexion = ConexionDB.ObtenerConexion();
        try
        {
            try (Statement comando = (Statement)conexion.createStatement()) {
                comando.execute("insert into tblPedidos values('0','" + pedido.getCodigo() 
                        + "','" + pedido.getSubtotal() + "','" + pedido.getImpuesto()
                        + "','" + pedido.getEnvioUSA() + "','" + pedido.getCantidadProductos()
                        + "','" + pedido.getImpuestoUnitario()+ "','" + pedido.getEnvioUSAUnitario()
                        + "','" + pedido.getFecha() + "','" + pedido.getTipoCambio() + "','" + pedido.getEnvioGTUnitario() + "')");
                JOptionPane.showMessageDialog(null, "Pedido ingresado correctamente", "Ingreso Exitoso", 1);
            }
            conexion.close();
        }
        catch (HeadlessException ex)
        {
            JOptionPane.showMessageDialog(null, ex.toString());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
         }
    }
    
     public static String[] buscarDatosPedido(String codigo) {
        Connection conexion = ConexionDB.ObtenerConexion();
        String datosPedido[] = null;
        try
        {
            Statement comando = (Statement)conexion.createStatement();
            ResultSet dato = comando.executeQuery("select idPedido, impuestoUnitario, envioUnitario, tipoCambio, envioGuate from tblPedidos where codigoPedido = '" + codigo + "'"); 
            if (dato!=null)
            {
                dato.next();
                datosPedido = new String[5];
                datosPedido[0] = dato.getString("idPedido");
                datosPedido[1] = dato.getString("impuestoUnitario");
                datosPedido[2] = dato.getString("envioUnitario");
                datosPedido[3] = dato.getString("tipocambioPedido");
                datosPedido[4] = dato.getString("enviogtPedido");
                comando.close();
                conexion.close();
            }
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.toString());
            return null;
        }
        return datosPedido;
     }
}
