/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dario.run;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author 629387
 */
public class Woomba extends Sprite{
     private static final int WIDTH = 10;
     private static final int HEIGHT = 15;
      private Image img4;
      private ImageIcon ii;

    public Woomba(int speed, int x, int y, int width, int height,Color color) {
        super(speed, x, y, width, height, color);
      
        this.ii = new ImageIcon(getClass().getResource("Dario-1.png.png"));
        this.img4 = ii.getImage();
    
    }
     public void draw(Graphics g) {
        if(true==alive){
          g.drawImage(img4, x, y, width, height, null);
        }
    }
}

