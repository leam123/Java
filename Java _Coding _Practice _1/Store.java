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

public class Store extends JFrame  implements ActionListener{
    
    JPanel panel[] = new JPanel[3];
    String labelCaption[] = {"Code:","Name:","Cost:","Stocks:"};
    String buttonCaption[] = {"Purchase","Sell","Inventory","Clear"};
    JTextField tf[] = new JTextField[4];
    JButton btn[] = new JButton[4];
    JTextArea text = new JTextArea();
    
    public Store(){
        try{
                //create panel
               for(int i=0; i<panel.length; i++){
                    panel[i] = new JPanel();
               }   
                    
               panel[1].setLayout(new GridLayout(4,2,5,5));
               for(int i=0; i<tf.length; i++){
                   panel[1].add(new JLabel(labelCaption[i]));
                   panel[1].add(tf[i] = new JTextField(20));
               }
               
               panel[2].setLayout(new GridLayout(2,2,5,5));
               for(int i=0; i<btn.length; i++){
                   panel[2].add(btn[i] = new JButton(buttonCaption[i]));
                   btn[i].addActionListener(this);
               }
               
               //tf[3].setEnabled(false);
               
               text.setBounds(5,5,10,10);
               text.setBorder(BorderFactory.createLineBorder(Color.black,5));
               panel[0].setLayout(new BorderLayout());
               panel[0].add(panel[1], BorderLayout.NORTH);
               panel[0].add(new JScrollPane(text, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS), BorderLayout.CENTER);
               panel[0].add(panel[2], BorderLayout.SOUTH);
               
               setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }catch(Exception ex){
           JOptionPane.showMessageDialog(null,"Upon executing the program an error was encountered.");
        }finally{
            getContentPane().add(panel[0]);
            setResizable(true);
            setVisible(true);
            setSize(1500,1500);
            pack();
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
    public void actionPerformed(ActionEvent e){
        int stock = Integer.parseInt(tf[3].getText());
        ArrayList<String> arr = new ArrayList<String>();
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
                    arr.add("Product Code: " + tf[0].getText());
                    arr.add("Product Name: " + tf[1].getText());
                    arr.add("Product Cost: " + tf[2].getText());
                    arr.add("Number of Stocks: " + tf[3].getText());
                    
                for(String a: arr){
                    //displaying array list in the TextArea
                    text.append(a + "\n" + "\n");
                    //text.append(a + System.getProperty("line separator"));
                    for(int i=0;i<4;i++){
                        tf[i].setText("");
                    }
                }
            }
            else if(e.getSource().equals(btn[3])){
                for(int i=0;i<4;i++){
                    tf[i].setText(" ");
                }
            }
        }catch(Exception ex){
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }finally{
        }
    }
    public static void main(String[] args){
       new Store();
    }
}