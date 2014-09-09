/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package xocolata_v2;

import Interfaces.Xocolata;
import javax.swing.JFrame;

/**
 *
 * @author Marco
 */
public class Xocolata_v2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Xocolata ventana = new Xocolata();
        ventana.setTitle("Xocolata 2.0 - Distribuidora de Ropa");
        ventana.setName("Xocolata 2.0 - Distribuidora de Ropa");
        ventana.setLocationRelativeTo(null);
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventana.setVisible(true);
    }
    
}
