import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class Music{
        JPanel panel = new JPanel();
    public Music(){
        try{
            Desktop.getDesktop().open(new File("C:/Users/HP/Downloads/safe inside.mp4"));
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Exception");
        }
    }
    public static void main(String[] args){
        new Music();
    }
}


