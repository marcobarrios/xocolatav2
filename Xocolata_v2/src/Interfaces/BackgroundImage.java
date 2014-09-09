/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaces;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.border.Border;

/**
 *
 * @author enrique
 */
public class BackgroundImage implements Border {
    public BufferedImage back;
 
    public BackgroundImage(){
        try {
            URL imagePath = new URL(BackgroundImage.class.getResource("/Imagenes/fondo5.jpg").toString());
            back = ImageIO.read(imagePath);
            
        } catch (Exception ex) {
             System.out.println("ERROR DE IMAGEN");
        }
    }
 
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawImage(back, (x + (width - back.getWidth())/2),(y + (height - back.getHeight())/2), null);
    }
 
    public Insets getBorderInsets(Component c) {
        return new Insets(0,0,0,0);
    }
 
    public boolean isBorderOpaque() {
        return false;
    }
    
}
