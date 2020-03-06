/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dario.run;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author 629387
 */
public class Dario {
     private int height, width, x, y, vx, vy, hp, xp, score;
    private Rectangle bounds;
    private Color color;
    private final int SPEED = 15;
    
    
    public Dario(int cWidth,int cHeight) {
        this.x = cWidth / 2;
        this.y = cHeight / 2;
        this.vx = 0;
        this.vy = 0;
        this.width = 50;
        this.height = 50;
        this.hp = 100;
        this.xp = 0;
        this.score = 0;
        this.color = Color.GREEN;
        this.bounds = new Rectangle(this.x, this.y, this.width, this.height);
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
        g.setColor(this.color);
        Graphics2D g2d = (Graphics2D) g;
        g2d.fill(bounds);
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
}
    


