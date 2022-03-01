
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener{
    JPanel panel = new JPanel();
    String[] s = {"new JFrame" , "Youtube video", "Image in another JFrame"};
    JButton[] btn= new JButton[3];
    
    //ADD IMAGE
        //ImageIcon icon = new ImageIcon("C:/Users/HP/Downloads/cat.jpg");
        //JLabel label = new JLabel(icon);
    
    public Main(){
        try{
              panel.setLayout(new GridLayout(1,2));
              for(int ctr=0; ctr<btn.length; ctr++){
                  panel.add(btn[ctr] = new JButton(s[ctr]));
                  btn[ctr].addActionListener(this);
              }
            //ADD THE IMAGE TO THE PANEL  
              //panel.add(label);
            
            //ADD IMAGE TO A BUTTON
                //btn[0].setIcon(new ImageIcon("C:/Users/HP/Downloads/cat.jpg"));
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Exception");
        }finally{
            getContentPane().add(panel);
            setVisible(true);
            setResizable(true);
           
            pack();

            //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
    public void actionPerformed(ActionEvent ae){
        try{
            if(ae.getSource().equals(btn[0])){
                JOptionPane.showMessageDialog(null,"New Frame opened");
                Another a = new Another(); //new JFrame
                this.dispose(); //to automatically close a JFrame upon opening a new one on click
            }else if(ae.getSource().equals(btn[1])){
                Video v = new Video();
            }else if(ae.getSource().equals(btn[2])){
                Pic p = new Pic();
                this.dispose();
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Exception");
        }
        finally{}
    }
    public static void main(String[] args){
        new Main();
    }
}

