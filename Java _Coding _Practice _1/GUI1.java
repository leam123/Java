/*
 *  To add a new J/Frame upon clicking a button:
 *      - create a new class that extends JFrame
 *             //provide certain statements or action you want inside the class
 *      - create an object of that class in your GUI or main class
 *      - call its method if there are any...
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GUI1 extends JFrame  implements ActionListener{
    
    JPanel panel[] = new JPanel[3];
    String labelCaption[] = {"Code:","Name:","Cost:","Stocks:"};
    String buttonCaption[] = {"Purchase","Sell","Inventory","Clear"};
    JTextField tf[] = new JTextField[4];
    JButton btn[] = new JButton[4];
    
    public GUI1(){
        try{
                //create panel
               for(int i=0; i<panel.length; i++){
                    panel[i] = new JPanel();
               }   
                    
               panel[1].setLayout(new GridLayout(10,10));
               for(int i=0; i<tf.length; i++){
                   panel[1].add(new JLabel(labelCaption[i]));
                   panel[1].add(tf[i] = new JTextField(20));
               }
               
               panel[2].setLayout(new GridLayout(3,5));
               for(int i=0; i<btn.length; i++){
                   panel[2].add(btn[i] = new JButton(buttonCaption[i]));
                   btn[i].addActionListener(this);
               }
               
               //tf[3].setEnabled(false);
               
               panel[0].setLayout(new BorderLayout());
               panel[0].add(panel[1], BorderLayout.NORTH);
               panel[0].add(panel[2], BorderLayout.SOUTH);
               
               
               setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }catch(Exception ex){
           JOptionPane.showMessageDialog(null,"Upon executing the program an error was encountered.");
        }finally{
            getContentPane().add(panel[0]);
            setResizable(true);
            setVisible(true);
            pack();
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
    public void actionPerformed(ActionEvent e){
        int stock = Integer.parseInt(tf[3].getText());
        try{
            if(e.getSource().equals(btn[0])){
                int quantity = Integer.parseInt(JOptionPane.showInputDialog("Quantity"));
                stock = stock + quantity;
                JOptionPane.showMessageDialog(null,"Successfully Added");
               
                tf[3].setText(String.valueOf(stock));
            }
            else if(e.getSource().equals(btn[1])){
                int quantity = Integer.parseInt(JOptionPane.showInputDialog("Quantity"));
                if(quantity<=stock){
                   stock = stock - quantity;
                }else{
                    JOptionPane.showMessageDialog(null,"Insuffient Stock");
                    quantity = Integer.parseInt(JOptionPane.showInputDialog(" "));
                    stock = stock - quantity;
                }
                
                JOptionPane.showMessageDialog(null,"Stocks Sold");
                tf[3].setText(String.valueOf(stock));
            }
            else if(e.getSource().equals(btn[2])){
                
                Inventory i = new Inventory();
                /*ArrayList<String> arr = new ArrayList<String>();
                    arr.add(tf[0].getText());
                    arr.add(tf[1].getText());
                    arr.add(tf[2].getText());
                    arr.add(tf[3].getText());
                    
                for(String a: arr)
                    System.out.println(a);*/
            }
            else if(e.getSource().equals(btn[3])){
                tf[0].setText(" ");
                tf[1].setText(" ");
                tf[2].setText(" ");
                tf[3].setText(" ");
            }
        }catch(Exception ex){
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }finally{
            /*System.out.println("Product Code: " + tf[0].getText());
            System.out.println("Product Name: " + tf[1].getText());
            System.out.println("Product Cost: " + tf[2].getText());
            System.out.println("Number of Stocks: " + tf[3].getText() + "\n");*/
        }
    }
    public static void main(String[] args){
       new GUI1();
    }
}