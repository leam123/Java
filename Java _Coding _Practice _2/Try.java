import java.awt.*;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Try extends JPanel implements KeyListener{
    
    public Try(){
        addKeyListener(this);
        setFocusable(true); //enable arrow keys
        setFocusTraversalKeysEnabled(true); //don't use special keys 
    }
    public void keyPressed(KeyEvent key){
        int k = key.getKeyCode();
        switch (k){
            case KeyEvent.VK_LEFT:
                System.out.println("Left");
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("Right");
                break;
            case KeyEvent.VK_UP:
                System.out.println("UP");
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("Down");
                break;
        }
    }
    public void keyReleased(KeyEvent key){}
    public void keyTyped(KeyEvent key){}
    public static void main(String[] args){
        Try k = new Try();
        JFrame jf = new JFrame();
        jf.setVisible(true);
        jf.setSize(500,500);
        jf.setTitle("Title");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(k);
    }
}