import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CheckerBoard extends JFrame{
    public CheckerBoard(){
        
        setVisible(true);
        setSize(500,500);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void paint(Graphics g){
        for(int i=2;i<10;i++){
            for(int j=1;j<9;j++){
                int x = j*20;
                int y = i*20;
                if(i%2 == j%2){
                    g.setColor(Color.blue);
                }else{
                    g.setColor(Color.black);
                }
                g.fillRect(x,y,20,20);
            }
        }
    }
    public static void main(String[] args){
        CheckerBoard cb = new CheckerBoard();
        cb.paint(null);
    }
}