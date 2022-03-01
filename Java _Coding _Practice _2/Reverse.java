import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Reverse extends JPanel implements ActionListener{
    Timer tm = new Timer(4,this); //(timesleep, Actionlistener)
    Timer tm2 = new Timer (4,this);
    Timer tm3 = new Timer (4,this);
    Timer tm4 = new Timer (4,this);
    
    //position of the shape
    int x=0, x2=450, x3=0, x4=450;
    //speed of the shape
    int speedX=1, revX=1, speedx3=1,revx4 = 1;
    public Reverse(){
        tm.start(); //start() is default in method in java
        tm2.start();
        tm3.start();
        tm4.start();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.green);
        g.fillRect(x,50,50,75);//x,y,width,height
        g.setColor(Color.black);
        g.fillRect(x2,150,50,75);
        g.setColor(Color.green);
        g.fillRect(x3,250,50,75);
        g.setColor(Color.black);
        g.fillRect(x4,350,50,75);
    }
    public void actionPerformed(ActionEvent ae){
        //to prevent it from going offscreen
        if(x<0 || x>450){
            //cannot do this because it will stop moving
            /*posX = 0;
            x = 0;*/
            
            speedX = -speedX;
            revX = -revX;
            speedx3 = -speedx3;
            revx4 = -revx4;
            /*  NOTE:
             *      posX -= posX is different from posX = -posX
             *      because if you use posX -= posX it will stop 
             *      at the side and won't continue moving
               */
        }
        //movement of the shapes
        x += speedX;
        x2 -= revX;
        x3 += speedx3;
        x4 -= revx4;
        
        //call the paintComponent method
        repaint(); 
        repaint();
        repaint();
        repaint();
    }
    public static void main(String[] args){
        Reverse r = new Reverse();
        JFrame jf = new JFrame();
        jf.setVisible(true);
        jf.setSize(500,500);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(r);
    }
}