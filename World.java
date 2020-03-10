/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dario.run;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
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

    public World() {
        super();
        background=new Background(0,0);
        dario = new Dario(800,600);
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 1000/12);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        background.draw(g);
        dario.draw(g);

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
