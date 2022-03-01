import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUI extends JFrame implements ActionListener{
    private JPanel[] panel = new JPanel[4];
    private JTextField tf = new JTextField(20);
    private JTextArea textarea = new JTextArea(10,50);
    private JLabel label = new JLabel("Input");
    private JButton btnOK = new JButton("OK");
    private JButton btnEXIT = new JButton("EXIT");
    public GUI(){
        setTitle("Prelim Exam");
        
        for(int i=0;i<panel.length;i++){
            panel[i] = new JPanel();
        }
        panel[1].setLayout(new GridLayout(1,2));
        panel[1].add(label);
        panel[1].add(tf);
        panel[2].add(btnOK);
        btnOK.addActionListener(this);
        panel[2].add(btnEXIT);
        btnEXIT.addActionListener(this);
        panel[3].add(textarea);
        
        panel[0].setLayout(new BorderLayout());
        panel[0].add(panel[1], BorderLayout.NORTH);
        panel[0].add(panel[2], BorderLayout.CENTER);
        panel[0].add(panel[3], BorderLayout.SOUTH);
        getContentPane().add(panel[0]);
        setVisible(true);
        setBounds(100,100,100,100);
        pack();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource().equals(btnOK)){
            textarea.append(tf.getText() + "\n");
            tf.setText("");
        }
        else if(ae.getSource().equals(btnEXIT)){
            dispose();
        }
    }
    public static void main(String[] args){
        new GUI();
    }
}

