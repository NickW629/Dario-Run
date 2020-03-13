/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dario.run;

import java.awt.Color;
import static java.awt.Color.GREEN;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

/**
 *
 * @author 629387
 */
public class World extends JPanel {
     private Timer timer;
     private Dario dario;
     private Background background;
     private ArrayList<Sprite> sprites = new ArrayList<>();
     private ArrayList<Woomba> woombas = new ArrayList<>();
     

    public World() {
        super();
        background=new Background(0,0);
        dario = new Dario(800,600);
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 1000/12);
            for (int i = 0; i < 25; i++) {
            int x = (int) (Math.random() * 800);
            int y = (int) (Math.random() * 600);
            Woomba woomba = new Woomba(20,x,y,WIDTH,HEIGHT,GREEN);
            woombas.add(woomba);
            sprites.add(woomba);
        }  
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        background.draw(g);
        dario.draw(g);
       for (Sprite sprite : sprites) {
            sprite.draw(g);
            sprite.update();
            sprite.collideWorldBounds(800,600);
        }        

    }
      public void boundaries() {
            if(dario.getX()<=0){
                dario.setX(0);
            }
                  if(dario.getX()>=1350){
                dario.setX(1350);
                  }
                if (dario.getY()<=0){
                dario.setY(0);
                }
                if (dario.getY()>=800){
                      dario.setY(800);
                  }
      }
    private class ScheduleTask extends TimerTask {

        @Override
        public void run() {         
            dario.update();
            repaint();
        }
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            dario.move("right");
            System.out.println("right");
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            dario.move("left");
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            dario.move("up");
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            dario.move("down");
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            dario.stop();
        }
            
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            dario.stop();
        }
            
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            dario.stop();
        }
            
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            dario.stop();
        }
            
    }
    
    
}
