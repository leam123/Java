import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class Exe extends JFrame implements ActionListener{
    private JPanel panel = new JPanel();
    private String[] combolist = {"Calculator","Notepad","MS Paint"};
    private JComboBox comboBox = new JComboBox();

    public Exe(){
       initialize();
    }
    public void initialize(){
        setTitle("Opening an exe File");

        for(int i=0;i<combolist.length;i++){
            comboBox.addItem(combolist[i]);
        }
        panel.add(comboBox);
        comboBox.addActionListener(this);
        comboBox.setUI(new HideArrowButton());
        //comboBox.setBorder(BorderFactory.createLineBorder(Color.gray));

        getContentPane().add(panel);
        setResizable(false);
        setPreferredSize(new Dimension(400,200));
        setBounds(700,500,400,400);
        setVisible(true);
        pack();

       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae){
        if(comboBox.getSelectedItem().equals(combolist[0])){
            ProcessBuilder pb = new ProcessBuilder("calc.exe");
            try{
                pb.start();
            }catch(IOException ex){
                System.out.println(ex);
            }
        }else if(comboBox.getSelectedItem().equals(combolist[1])){
            ProcessBuilder pb = new ProcessBuilder("notepad.exe");
            try{
                pb.start();
            }catch(IOException ex){
                System.out.println(ex);
            }
        }else if(comboBox.getSelectedItem().equals(combolist[2])){
            ProcessBuilder pb = new ProcessBuilder("mspaint.exe");
            try{
                pb.start();
            }catch(IOException ex){
                System.out.println(ex);
            }
        }
    }
    public static void main(String[] args){
        new Exe();
    }
}