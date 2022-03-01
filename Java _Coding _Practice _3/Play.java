import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Play extends JFrame implements ActionListener{
    JPanel panel = new JPanel();
    JLabel label = new JLabel("WELCOME");
    JLabel lbl = new JLabel("\n");
    JButton btn = new JButton("Play");

    public Play(){
        setTitle("Play");

        /*System.out.println("WELCOME");
        System.out.println(" ");
        System.out.println(" ");*/
        panel.setLayout(new GridLayout(3,3));
        panel.setBounds(100,100,100,100);
        panel.setSize(500,500);
        panel.add(label);
        panel.add(lbl);
        panel.add(btn);
        btn.addActionListener(this);
        
        setSize(500,500);
        getContentPane().add(panel);
        setVisible(true);
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource().equals(btn)){
                Category ct = new Category();
                dispose();
        }
    }
    public static void main(String[] args){
        new Play();
    }
}