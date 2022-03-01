import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Shape1 extends JPanel{
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.green);
        g.fillRect(5,15,50,75);
    }
    public static void main(String[] args){
        Shape1 s = new Shape1();
        JFrame jf = new JFrame();
        jf.setVisible(true);
        jf.setSize(500,500);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(s);
    }
}