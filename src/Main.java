//grabbed some imports from a guide, but it seems they're not needed for now
//import javax.swing.*;
//import java.awt.*;
//even still im getting an error for having commented the code out

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Main extends Canvas {
    //variables for later
    //no clue what half of this means but idea told me to do it and it worked
    public static final float[] x = {200};
    public static final float[] y = {150};
    public static final int[] vertical = {0};
    public static final int[] horizontal = {0};

    public static void main(String[] args) {
        //frame init stuff??
        //also pretty confusing
        JFrame frame = new JFrame("silly lil window");
        Canvas canvas = new Main();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        canvas.setSize(400, 300);
        frame.add(canvas);

        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);

        //detect when keys are pressed and make a note of it
        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_W) {
                    vertical[0] = -1;
                } else if (keyCode == KeyEvent.VK_S) {
                    vertical[0] = 1;
                }
                if (keyCode == KeyEvent.VK_A) {
                    horizontal[0] = -1;
                } else if (keyCode == KeyEvent.VK_D) {
                    horizontal[0] = 1;
                }
            }
        });
        //detect when keys are released and make a note of it
        frame.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_W) {
                    vertical[0] = 0;
                }
                if (keyCode == KeyEvent.VK_S) {
                    vertical[0] = 0;
                }
                if (keyCode == KeyEvent.VK_A) {
                    horizontal[0] = 0;
                }
                if (keyCode == KeyEvent.VK_D) {
                    horizontal[0] = 0;
                }
            }
        });

    }

    //change x and y when keys are pressed, also draw the player thing
    public void paint(Graphics g) {
        g.fillRect(Math.round(x[0]), Math.round(y[0]), 20, 20);
        if (vertical[0] == 1) {
            y[0] += 0.1F;
        }
        if (vertical[0] == -1) {
            y[0] -= 0.1F;
        }
        if (horizontal[0] == 1) {
            x[0] += 0.1F;
        }
        if (horizontal[0] == -1) {
            x[0] -= 0.1F;
        }
        if (x[0] > 400){
            x[0] -= 400;
        } else if (x[0] < 0){
            x[0] +=400;
        }
        if (y[0] > 300) {
            y[0] -= 300;
        } else if (y[0] < 0){
            y[0] += 300;
        }

        repaint();
    }

}








