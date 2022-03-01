import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Category extends JFrame implements ActionListener{
    JPanel panel = new JPanel();
    JButton btn = new JButton("English");
    JButton btn2 = new JButton("Filipino");

    public Category(){
        setTitle("Category");

        //panel.setLayout(new FlowLayout(10));
        panel.setBounds(100,100,100,100);
        panel.setSize(500,500);
        panel.add(btn, new FlowLayout(10));
        panel.add(btn2, new GridLayout(1,2));
        btn.addActionListener(this);
        btn2.addActionListener(this);

        setSize(500,500);
        getContentPane().add(panel);
        setVisible(true);
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae){
        //if(ae.getSource().equals(btn)){

        //}
    }
    public static void main(String[] args){
        new Category();
    }
}