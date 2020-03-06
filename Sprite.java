/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dario.run;

import java.awt.Color;
import java.awt.Rectangle;

/**
 *
 * @author 629387
 */
public class Sprite {
    private int speed;
    private int x, y, vx, vy;
    private int width, height;
    private Color color;
    private Rectangle bounds;
    private boolean alive = true;
    
     public Sprite(int speed, int x, int y, int width, int height, Color color) {
        this.speed = speed;
        this.x = x;
        this.y = y;
        this.vx = (int) (Math.random() * this.speed * 2 - this.speed);
        this.vy = (int) (Math.random() * this.speed * 2 - this.speed);
        this.width = width;
        this.height = height;
        this.color = color;
        this.bounds = new Rectangle(x, y, width, height);
        
        
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
      public void die() {
        this.alive = false;
    }
      
       public void update() {
        this.x += this.vx;
        this.y += this.vy;
        this.bounds = new Rectangle(x, y, width, height);
    }
       
    
    
      
}
