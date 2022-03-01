import java.io.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;
public class SpinThread implements Runnable{
    private JPanel[] panel =  new JPanel[4];
    private JLabel[] label = new JLabel[3]; //DISPLAY 3 IMAGE ON ONE PANEL
    private JLabel lbl = new JLabel("Win: ");
    private JTextField tf = new JTextField(3);
    private JButton spin = new JButton("Spin");
    private int rand,count=0;
    private int index1,index2,index3;
    private int i,i2,i3; //FOR THE ARRAY OF IMAGES
    private String[] images = {"7.png","bell.png","cloverleaf.png","money.png","grapes.png","berry.png","watermelon.png","horseshoe.png","lemon.png"};
    private Image img, img1, img2;
    
    public void run(){
    }
}