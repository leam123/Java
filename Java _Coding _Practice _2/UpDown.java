import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UpDown extends JPanel implements ActionListener{
    Timer[] tm1 = new Timer[4];
    
    int y=0, y2=450, y3=0, y4=450;
    int posy1=1, posy2=1, posy3=1, posy4=1;
    
    public UpDown(){
        for(int i=0;i<tm1.length;i++){
            tm1[i] = new Timer(5,this);
            tm1[i].start();
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.blue);
        g.drawRect(0,y,100,100);
        g.setColor(Color.cyan);
        g.drawRect(100,y2,100,100);
        g.setColor(Color.blue);
        g.drawRect(250,y3,100,100);
        g.setColor(Color.cyan);
        g.drawRect(350,y4,100,100);
    }
    public void actionPerformed(ActionEvent ae){
        if(y<0 || y>450){
            posy1 = -posy1;
            posy2 = -posy2;
            posy3 = -posy3;
            posy4 = -posy4;
        }
        y += posy1;
        y2 -= posy2;
        y3 += posy3;
        y4 -= posy4;
        for(int i=0;i<4;i++){
            repaint();
        }
    }
    public static void main(String[] args){
        UpDown ud = new UpDown();
        JFrame jf = new JFrame();
        jf.setVisible(true);
        jf.setSize(500,500);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(ud);
    }
}