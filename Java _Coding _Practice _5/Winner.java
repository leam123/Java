import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.border.LineBorder;

public class Winner extends JFrame{
    JPanel panel = new JPanel();
    JLabel lbl;
    ImageIcon img;
    
    public Winner(){
        //use of getScaledInstance(int width,int height,int Image.SCALE_) method in java.awt.Image class 
        //to resize an image depending on the JFrame
        img = new ImageIcon(new ImageIcon("winner.gif").getImage().getScaledInstance(270,245,Image.SCALE_DEFAULT));
        lbl = new JLabel(img);
        
        lbl.setBorder(BorderFactory.createLineBorder(Color.black,5));
        panel.add(lbl);
        
        getContentPane().add(panel);
        setVisible(true);
        setPreferredSize(new Dimension(300,300));
        setBounds(500,150,500,500);
        pack();
        
        //use of DISPOSE_ON_CLOSE rather than exit to avoid closing the other JFrame    
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public static void main(String[] args){
        new Winner();
    }
}