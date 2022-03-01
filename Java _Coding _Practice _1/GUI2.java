import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GUI2 extends JFrame implements ActionListener{
    String comboChoice[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    String label[] = {"Name", "Age"};
    JLabel lb1 = new JLabel("BirthMonth");
    JLabel lb2 = new JLabel("BirthMonth");
    String lbCheck[] = {"Male", "Female"};
    String btnLabel[] = {"Compute Age", "Clear"};
    JPanel panel[] = new JPanel[4];
    JLabel lb[] = new JLabel[2];
    JTextField tfield[] = new JTextField[2];
    JTextField tf = new JTextField(20);
    JPasswordField pass = new JPasswordField();
    JCheckBox checkBox[] = new JCheckBox[2];
    JScrollPane scpane = new JScrollPane(tf);
    JComboBox combo = new JComboBox();
    JButton btn[] = new JButton[2];

    public GUI2(){
        try{
            for(int i=0; i<panel.length; i++)
                panel[i] = new JPanel();

            panel[1].setLayout(new GridLayout(4,4));
            for(int i=0; i<lb.length; i++){
                panel[1].add(new JLabel(label[i]));
                panel[1].add(tfield[i] = new JTextField(20));
            }
            panel[1].add(lb1); panel[1].add(combo);
            panel[1].add(lb2); panel[1].add(pass);

            panel[2].setLayout(new GridLayout(4,4));
            for(int i=0; i<lbCheck.length; i++){
                panel[2].add(checkBox[i] = new JCheckBox(lbCheck[i]));
            }
            panel[3].setLayout(new GridLayout(4,4));
            for(int i=0; i<btnLabel.length; i++){
                panel[3].add(btn[i] = new JButton(btnLabel[i]));
                btn[i].addActionListener(this);
            }
            for(int i=0; i<comboChoice.length; i++){
                combo.addItem(comboChoice[i]);
            }
            combo.addActionListener(this);
                //combo.addItem("/item name/");  - individual addition

            panel[0].setLayout(new BorderLayout());
            panel[0].add(panel[1],BorderLayout.NORTH);
            panel[0].add(panel[2],BorderLayout.EAST);
            panel[0].add(panel[3],BorderLayout.SOUTH);

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error encountered");
        }finally{
            getContentPane().add(panel[0]);
            setResizable(true);
            setVisible(true);
            pack();

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
    public void actionPerformed(ActionEvent ae){
        try{
            if(combo.getSelectedItem().equals(comboChoice[0])){
                //Statements....
                System.out.println("it worked");
            }
        }catch(Exception ex){
        }finally{
        }
    }
    public static void main(String[] args){
        new GUI2();
    }
}