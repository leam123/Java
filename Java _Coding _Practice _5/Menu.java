import java.awt.Image;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.border.BevelBorder;
import java.awt.FlowLayout;

public class Menu extends JFrame implements ActionListener{
    JPanel panel = new JPanel();
    JButton btnPlay = new JButton("Play");
    JButton btnExit = new JButton("Exit");
    ImageIcon img = new ImageIcon(new ImageIcon("machine logo.jpg").getImage().getScaledInstance(400,400,Image.SCALE_SMOOTH));
    JLabel lbl = new JLabel(img);
    JLabel lbl1 = new JLabel();

    public Menu(){
        setTitle("Menu");

        lbl.setLayout(new FlowLayout());
        lbl.add(btnPlay);
        btnPlay.addActionListener(this);
        lbl.add(btnExit);
        btnExit.addActionListener(this);

        getContentPane().add(lbl);
        setVisible(true);
        setResizable(false);
        setBounds(500,500,300,300);
        setPreferredSize(new Dimension(400,400));
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource().equals(btnPlay)){
           new SpinGUI2();
           new Spin();
           dispose();
       }
       else if(ae.getSource().equals(btnExit)){
           dispose();
       }
    }
    public static void main(String[] args){
        new Menu();
    }
}