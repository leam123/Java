import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Game extends JPanel implements KeyListener{
    static JFrame jf = new JFrame();
    ArrayList<Block> blocks = new ArrayList<Block>();
    String pad = "line.png";
    String b = "ball.png";
    Block paddle = new Block(175,450,150,25,pad);
    Block ball = new Block(237,435,25,25,b);
    
    public Game(){
        for(int i=0;i<25;i++)
            blocks.add(new Block((i*60),20,20,10,"blue.jpg"));
        for(int i=0;i<25;i++)
            blocks.add(new Block((i*60),60,30,30,"black.png"));
        addKeyListener(this);
        setFocusable(true);
    }
    public void update(){
        ball.x += ball.posX;
        if(ball.x > (500 - 25) || ball.x<0){
            ball.posX = -ball.posX;
        }
        /*if(ball.y < 0 || ball.intersects(paddle)){
            ball.posY *= -1;
        }*/
        ball.y += ball.posY;
        for(Block b: blocks){
            if(ball.intersects(b) && !b.hit){
                ball.posY = -ball.posY;
                b.hit = true;
            }
        }
        repaint();
    }
    public void paintComponent(Graphics g){
        for(Block b: blocks){
            if(b.x<500){
                b.draw(g,this); 
            }
        }
        ball.draw(g,this);
        paddle.draw(g,this);
        //g.setColor(Color.black);
        //g.fillRect(175,450,150,25);
    }
    public void keyPressed(KeyEvent ke){
        if(ke.getKeyCode() == KeyEvent.VK_ENTER){
            new Thread(new Animate(this)).start();
        }
        if(ke.getKeyCode() == KeyEvent.VK_RIGHT && paddle.x<500){
                paddle.x += 10;
        }
        if(ke.getKeyCode() == KeyEvent.VK_LEFT && paddle.x>0){
                paddle.x -= 10;
        }
    }
    public void keyReleased(KeyEvent ke){}
    public void keyTyped(KeyEvent ke){}
    public static void main(String[] args){
        new Game();
        jf.getContentPane().add(new Game());
        //jf.setResizable(false);
        jf.setSize(500,500);
        jf.setVisible(true);
        jf.pack();
        
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}