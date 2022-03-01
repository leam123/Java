
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Riddles extends JFrame implements ActionListener{
    JPanel panel = new JPanel();
    JFrame jf = new JFrame();
    JPanel p = new JPanel();
     JTextField tf = new JTextField(20);
     JButton btn = new JButton("ok");
    //ArrayList<String> st = new ArrayList<String>();
    //ListIterator<String> li;
     String str2 = "What comes up when rain goes down?";
     String str3 = "What gets wet when it dries?";
     JLabel lbl = new JLabel(str2);
     JLabel lbl1 = new JLabel(str3);
     public Riddles(){
        panel.add(lbl);
        panel.add(tf);
        panel.add(btn);
        btn.addActionListener(this);
        getContentPane().add(panel);
        setVisible(true);
        pack();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
    /*public Riddles(){
        try{
        File file = new File("C:/Users/HP/Desktop/riddles.txt");
        Scanner s = new Scanner(file);
        
        while(s.hasNext()){
            st.add(s.next());
            li = st.listIterator();
        }
        
        for(String str: st)
            System.out.println(str);
        
        
        panel.add(tf);
        
        getContentPane().add(panel);
        setVisible(true);
        pack();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
      }catch(Exception ex){
          JOptionPane.showMessageDialog(null,"Exception");
      }
    }*/
    
    public void actionPerformed(ActionEvent ae){
        if(tf.getText().equalsIgnoreCase("Umbrella")){
            p.add(lbl1);
            
            jf.getContentPane().add(p);
            jf.setVisible(true);
            jf.pack();
            
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        /*if(tf.getText().equals("Answer")){
            if(li.hasNext()){
                System.out.println(li.next());
            }
        }*/
    }
    public static void main(String[] args){
        Riddles r = new Riddles();
        /*JFrame jf = new JFrame();
        jf.setSize(500,500);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(r);
        jf.add(lbl);
        jf.add(tf);
        jf.add(btn);*/
    }
}