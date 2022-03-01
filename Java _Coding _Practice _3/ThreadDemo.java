import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.lang.Thread;

public class ThreadDemo extends JPanel implements Runnable, KeyListener{
    String name;
    int x = 0, posX = 3;
    JFrame jf =  new JFrame();
    //public ThreadDemo(String name){
    //    name = name;
   // }
    public void run(){
        while(true){
            update();
            try{
                Thread.sleep(10000);
            }catch(InterruptedException ie){
                System.out.println(ie);
            }
        }
    }
    public void update(){
        if(x<0 || x>450){
            posX = -posX;
        }
        x += posX;
        repaint();
    }
    public void paintComponent(Graphics g){
        g.setColor(Color.black);
        g.fillRect(x,50,20,10);
    }
    public void keyPressed(KeyEvent ke){
        if(ke.getKeyCode() == KeyEvent.VK_ENTER){
            new Thread().start();
        }
    }
    public void keyReleased(KeyEvent ke){}
    public void keyTyped(KeyEvent ke){}
    public static void main(String[] args){
        new ThreadDemo();
    }
}