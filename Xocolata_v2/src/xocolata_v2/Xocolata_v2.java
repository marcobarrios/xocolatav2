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
        System.out.println("Xocolata Version 2");
        Xocolata ventana = new Xocolata();
        ventana.setTitle("Xocolata 2.0");
        ventana.setName("Xocolata 2.0");
        ventana.setLocationRelativeTo(null);
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventana.setVisible(true);
    }
    
}
