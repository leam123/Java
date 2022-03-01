import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Another extends JFrame implements ActionListener{
    JPanel panel = new JPanel();
    JButton btn= new JButton("Compute");
    JButton btn1= new JButton("Cancel");
    JLabel label1 = new JLabel("Number");
    JTextField tf1 = new JTextField(20);
    JLabel label2 = new JLabel("Number");
    JTextField tf2 = new JTextField(20);

    public Another(){
        try{
            panel.setLayout(new GridLayout(3,2));
            panel.add(label1); panel.add(tf1);
            panel.add(label2); panel.add(tf2);
            panel.add(btn); 
            btn.addActionListener(this);
            panel.add(btn1);
            btn1.addActionListener(this);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Exception");
        }finally{
            getContentPane().add(panel);
            setVisible(true);
            setResizable(true);
            pack();

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
    public void actionPerformed(ActionEvent ae){
        try{
        if(ae.getSource().equals(btn)){
            int i = Integer.parseInt(tf1.getText());
            int x = Integer.parseInt(tf2.getText());
            JOptionPane.showMessageDialog(null,"HI");
        }else if(ae.getSource().equals(btn1)){
            Main m = new Main();
            this.dispose();
        }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Exception");
        }
        finally{}
    }
    public static void main(String[] args){
        new Another();
    }
}

