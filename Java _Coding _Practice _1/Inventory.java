import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Inventory extends JFrame{
    JPanel panel = new JPanel();
    //String labelCaption[] = {"Code:","Name:","Cost:","Stocks:"};
    //String buttonCaption[] = {"Purchase","Sell","Inventory","Clear"};
    JTextField tf = new JTextField(20);
    JButton btn = new JButton("Ok");
    JLabel label = new JLabel("TextField");

    public Inventory(){
        try{
               panel.setLayout(new GridLayout(2,2));
               panel.add(label);
               panel.add(tf);
               panel.add(btn);

               setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }catch(Exception ex){
           JOptionPane.showMessageDialog(null,"Upon executing the program an error was encountered.");
        }finally{
            getContentPane().add(panel);
            setResizable(true);
            setVisible(true);
            pack();
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
    public static void main(String[] args){
        new Inventory();
    }

}