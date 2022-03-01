import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class draw extends JPanel{
    public void draw(){
        repaint(); // call the paintComponent method
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.green);
        g.fillRect(5,15,50,75);
    }
}