import java.awt.*;
import javax.swing.*;
public class Pic extends JFrame{
    JPanel panel = new JPanel();
    
    //ImageIcon icon = new ImageIcon("C:/Users/HP/Downloads/cat.jpg");
    //JLabel label = new JLabel(icon);
  
    public Pic(){
        //ADD THE IMAGE TO THE PANEL
            //panel.add(label);
        
        //ADDING IMAGE IN SHORTER VERSION
        panel.add(new JLabel(new ImageIcon("C:/Users/HP/Downloads/cat.jpg")));
        
        //ADD IMAGE TO A BUTTON
            //btn[0].setIcon(new ImageIcon("C:/Users/HP/Downloads/cat.jpg"));
            
        getContentPane().add(panel);
        setVisible(true);
        pack();
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args){
        new Pic();
    }
}