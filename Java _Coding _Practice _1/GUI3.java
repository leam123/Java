import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI3 extends JFrame implements ActionListener{

    Product prod = new Product();

    JPanel panel[] = new JPanel[3];
    JPanel panell = new JPanel();

    String labelCaption[] = {"Code:","Name:","Cost:","Stocks:"};
    String buttonCaption[] = {"Purchase","Sell","Inventory","Clear"};
    JTextField tf[] = new JTextField[4];
    JButton btn[] = new JButton[4];

    public GUI3(){
        try{
                //create panel
               for(int i=0; i<panel.length; i++){
                    panel[i] = new JPanel();
               }

               panel[1].setLayout(new GridLayout(5,2,5,5));
               for(int i=0; i<tf.length; i++){
                   panel[1].add(new JLabel(labelCaption[i]));
                   panel[1].add(tf[i] = new JTextField(20));
               }

               //panel[2].setLayout(new GridLayout(3,5));
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
            setResizable(false);
            setVisible(true);
            pack();
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
    public void actionPerformed(ActionEvent e){
       //int stock = Integer.parseInt(tf[3].getText());
       //int quantity = Integer.parseInt(JOptionPane.showInputDialog(panell.add(lbQuan)));
        try{
            if(e.getSource().equals(btn[0])){
                int stock = Integer.parseInt(tf[3].getText());
                int quantity = Integer.parseInt(JOptionPane.showInputDialog(null,"Quantity"));
                prod.setStock(stock);
                stock = prod.purchase(quantity);
                //stock = stock + quantity;
                prod.setStock(stock);
                JOptionPane.showMessageDialog(null,"Successfully Added");

                //tf[3].setText(String.valueOf(stock));
                //tf[3].setText(String.valueOf(prod.getStock()));
            }
            else if(e.getSource().equals(btn[1])){
                int stock = Integer.parseInt(tf[3].getText());
                int quantity = Integer.parseInt(JOptionPane.showInputDialog(null,"Quantity"));
                if(prod.sell(quantity)==true){
                   stock = prod.getStock() - quantity;
                }else{
                    JOptionPane.showMessageDialog(null,"Insuffient Stock");
                    quantity = Integer.parseInt(JOptionPane.showInputDialog(" "));
                    stock = prod.getStock() - quantity;
                }
                prod.setStock(stock);
                /*if(quantity<=stock){
                   stock = stock - quantity;
                }else{
                    JOptionPane.showMessageDialog(null,"Insuffient Stock");
                    quantity = Integer.parseInt(JOptionPane.showInputDialog(" "));
                }*/

                JOptionPane.showMessageDialog(null,"Stocks Sold");
                //tf[3].setText(String.valueOf(stock));
                //tf[3].setText(String.valueOf(prod.getStock()));
            }
            else if(e.getSource().equals(btn[2])){
                System.out.println("Product Code: " + tf[0].getText());
                tf[0].setText(" ");
                System.out.println("Product Name: " + tf[1].getText());
                tf[1].setText(" ");
                System.out.println("Product Cost: " + tf[2].getText());
                tf[2].setText(" ");
                System.out.println("Number of Stocks: " + tf[3].getText() + "\n");
                tf[3].setText(" ");
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
            tf[3].setText(String.valueOf(prod.getStock()));
        }
    }
    public static void main(String[] args){
       new GUI3();
    }
}