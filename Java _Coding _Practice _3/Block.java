import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import javax.imageio.ImageIO;

public class Block extends Rectangle{
    Image img;
    public boolean hit = false;
    int posX, posY;
    
    public int x,y,w,h;
    String s;
    
    Block(int x, int y, int w, int h, String s){
        this.x = x;
        this.y = y;
        
        this.posX = 3;
        this.posY = 3;
    
        this.w = w;
        this.h = h;
        this.s = s;
        try{
            img = ImageIO.read(new File(s));
        }catch(Exception ex){}
    }
    public void draw(Graphics g, Component c){
        if(!hit)
            g.drawImage(img,x,y,w,h,c);
    }
}
