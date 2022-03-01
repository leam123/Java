import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Animation extends JPanel implements ActionListener{
    Timer tm = new Timer(4,this); //(timesleep, Actionlistener)
    //postion on the axis and speed of the shape
    int x=0, speedX=2; 
    
    /*
       NOTE: 
           Upon using multiple Timer, you can use loop...
       */
    
    public Animation(){
        tm.start(); //start() is default in method in java
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.green);
        g.fillRect(x,15,50,75); //for up and down change it to y
        //g,drawRect(int,int,int,int) to draw only the outline of the shape
    }
    public void actionPerformed(ActionEvent ae){
        //to prevent it from going offscreen
        if(x<0 || x>450){ //(x<0 || x>size)
            //cannot do this because it will stop moving
            /*posX = 0;
            x = 0;*/
            
            speedX = -speedX;
            
            /*  NOTE:
             *      posX -= posX is different from posX = -posX
             *      because if you use posX -= posX it will stop 
             *      at the side and won't continue moving
               */
        }
        //movement of the shape
        x += speedX;
        //call the paintComponent method
        repaint(); 
    }
    public static void main(String[] args){
        Animation a = new Animation();
        JFrame jf = new JFrame();
        jf.setVisible(true);
        jf.setSize(500,500);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(a);
    }
}