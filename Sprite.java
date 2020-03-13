/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dario.run;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author 629387
 */
public abstract class Sprite {
    private int speed;
    int x;
     int y, vx, vy;
     final int SPEED = 4;
     int width, height;
     Color color;
    Rectangle bounds;
    boolean alive = true;
    
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
   public abstract void draw(Graphics g);
    public int getY() {
        return y;
    }
     public int getVx() {
        return vx;
    }

    public void setVx(int vx) {
        this.vx = vx;
    }

    public int getVy() {
        return vy;
    }

    public void setVy(int vy) {
        this.vy = vy;
    }
      public void die() {
        this.alive = false;
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
         public boolean collide(Sprite other) {
        boolean collided = this.bounds.intersects(other.bounds);
        if (collided) {
            this.didCollide();
            other.didCollide();
        }
        return collided;
    }
    public void collideWorldBounds(int cWidth,int cHeight){
        if (this.x < 0 || this.x + this.width > cWidth)
            this.vx = -this.vx;
        if (this.y < 0 || this.y + this.height > cHeight)
            this.vy = -this.vy;
    }
     public void didCollide() {
        this.vx = -this.vx;
        this.vy = -this.vy;
    }
       public void update() {
        this.x += this.vx;
        this.y += this.vy;
        this.bounds = new Rectangle(x, y, width, height);
    }
       
    
    
      
}
