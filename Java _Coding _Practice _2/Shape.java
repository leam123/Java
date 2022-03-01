import java.util.*;
import java.awt.*;
//import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;

public class Shape extends JFrame{
    public Shape(){
        //setBackground(Color.white);
        //setForeground(Color.green);
        setVisible(true);
        setSize(500,500);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void paint(Graphics g){
        g.setColor(Color.blue);
        g.fillRect(10,50,50,50); //((pos - ver)x, (pos - hor)y, width, height)
    }
    public static void main(String[] args){
        Shape s = new Shape();
        s.paint(null); //null because it is already set in the paint method
    }
}