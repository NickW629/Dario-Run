/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dario.run;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author 629387
 */
public class Dario {
     private int height, width, x, y, vx, vy, hp, xp, score;
    private Rectangle bounds;
    private Color color;
    private final int SPEED = 15;
    private ImageIcon ii;
    private Image img;
    private Image img2;
    private Image img3;
   
    
    
    public Dario(int cWidth,int cHeight) {
        this.x = cWidth / 2;
        this.y = cHeight / 2;
        this.vx = 0;
        this.vy = 0;
        this.width = 200;
        this.height = 200;
        this.hp = 100;
        this.xp = 0;
        this.score = 0;
      
        this.bounds = new Rectangle(this.x, this.y, this.width, this.height);
        this.ii = new ImageIcon(getClass().getResource("Dario-1.png.png"));
        this.img = ii.getImage();
        this.ii = new ImageIcon(getClass().getResource("Dario-2.png.png"));
        this.img2 = ii.getImage();
        this.ii = new ImageIcon(getClass().getResource("Dario-3.png.png"));
        this.img3 = ii.getImage();
    }
      public void move(String direction) {        
        if (direction.equals("right"))
            vx = SPEED;
        else if (direction.equals("left"))
            vx = -SPEED;
        else if (direction.equals("up"))
            vy = -SPEED;
        else if (direction.equals("down"))
            vy = SPEED;
    }
    
    public void draw(Graphics g) {
        if(vx==SPEED){
          g.drawImage(img2, x, y, width, height, null);
        }
        else if(vx==-SPEED){
          g.drawImage(img3, x, y, width, height, null);
        }
        else {
          g.drawImage(img, x, y, width, height, null);
                }
       
    }
    
    public void attack() {
        
    }
    
    public void collect() {
        
    }
    
    public void update() {
        this.x += vx;
        this.y += vy;
        this.bounds = new Rectangle(this.x, this.y, this.width, this.height);
    }

    public void stop() {
        this.vx = 0;
        this.vy = 0;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getVx() {
        return vx;
    }

    public void setVx(int vx) {
        this.vx = vx;
    }
     public Rectangle getBounds() {
        return bounds;
    }

    public int getVy() {
        return vy;
    }

    public void setVy(int vy) {
        this.vy = vy;
    }
    
}
    


