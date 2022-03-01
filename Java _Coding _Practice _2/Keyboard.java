import java.awt.*;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Keyboard extends JPanel implements ActionListener, KeyListener{
    Timer tm = new Timer(0,this);
    int x=0, speedX=0, y=0, speedY=0;
    public Keyboard(){
        tm.start();
        addKeyListener(this);
        setFocusable(true); //enable arrow keys
        setFocusTraversalKeysEnabled(true); //don't use special keys 
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.green);
        g.fillRect(5,15,50,75);
    }
    public void keyPressed(KeyEvent key){
        int k = key.getKeyCode();
        switch (k){
            case KeyEvent.VK_LEFT:
                speedX = -1;
                speedY = 0;
                break;
            case KeyEvent.VK_RIGHT:
                speedX = 1;
                speedY = 0;
                break;
            case KeyEvent.VK_UP:
                speedX = 0;
                speedY = -1;
                break;
            case KeyEvent.VK_DOWN:
                speedX = 0;
                speedY = 1;
                break;
        }
    }
    public void actionPerformed(ActionEvent ae){
        x += speedX;
        y += speedY;
        repaint();
    }
    
    public void keyReleased(KeyEvent key){
        //speedX = 0;
        //speedY = 0;
    }
    public void keyTyped(KeyEvent key){}
    public static void main(String[] args){
        Keyboard k = new Keyboard();
        JFrame jf = new JFrame();
        jf.getContentPane().add(k);
        jf.setVisible(true);
        jf.setSize(500,500);
        jf.setTitle("Title");
        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //jf.add(k);
    }
}