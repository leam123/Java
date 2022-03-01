import java.util.*;
import javax.swing.*;
import java.awt.*; //package where Desktop is found
import java.net.*; //package where URI is found
import java.io.*;

public class Video extends JFrame{
    public Video(){
        try 
        {
            //TO OPEN THE BROWSER i.e YOUTUBE VIDEOS, FB, ETC.....
            //Desktop d=Desktop.getDesktop();
            //d.browse(new URI("https://www.youtube.com/watch?v=6J1-eYBbspA&list=RD6J1-eYBbspA&start_radio=1"));
            
            //TO PLAY VIDEO USING LOCAL MEDIAPLAYER
                Desktop.getDesktop().open(new File("F:/Movies/The Little Prince.mp4"));
            
        }
        catch(Exception ex) 
        {
           JOptionPane.showMessageDialog(null,"Exception");
        }
    }
    public static void main(String[] args){
      new Video();
    }
}