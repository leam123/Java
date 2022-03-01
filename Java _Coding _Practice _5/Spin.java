/**
** Author: Garcia, Leamor T.
** Date: 11/29/2019
*
**/
import java.awt.Color;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
//import java.util.Collection;
//import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.Timer;
//import javax.swing.JDialog;

public class Spin extends JFrame implements ActionListener{
    private JPanel[] panel =  new JPanel[4];
    private JLabel[] label = new JLabel[3]; //DISPLAY 3 IMAGE ON ONE PANEL
    private JLabel lbl = new JLabel("Chances: ");
    private JTextField tf = new JTextField(2);
    private JButton spin = new JButton("Spin");

    private int max = 20;
    private int rand, i, count=0, c=0, d=0, f=0;
    private int index1, index2, index3; //FOR THE ARRAY OF IMAGES
    //private String[] images = {"7.png","bell.png"};
    //private String[] images = {"p1.gif", "p2.gif", "p3.gif", "p4.gif", "p6.gif", "p7.gif", "p8.gif", "p9.gif"};
    //private String[] images = {"7.png","bell.png","cloverleaf.png","money.png","grapes.png","berry.png"};
    private String[] images = {"7.png","bell.png","cloverleaf.png","money.png","grapes.png","berry.png","watermelon.png","horseshoe.png"};

    Timer tm, tm1, tm2;

	//winner image
	ImageIcon winner = new ImageIcon(new ImageIcon("winner.gif").getImage().getScaledInstance(270,245,Image.SCALE_DEFAULT));
	JLabel picWinner = new JLabel(winner);

    public Spin(){
       setTitle("Slot Machine");
       setPanel();
    }

    public void setPanel(){
        //CREATING THE PANELS
        for(i=0;i<panel.length;i++){
            panel[i] = new JPanel();
        }

        //ASSIGN THE FIRST IMAGE TO BE DISPLAYED ON THE PANEL
        for(i=0;i<label.length;i++){
            label[i] = new JLabel(new ImageIcon(new ImageIcon(images[1]).getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH)));
           //label[i] = new JLabel(new ImageIcon(new ImageIcon(images[1]).getImage().getScaledInstance(150,150,0)));
        }

        panel[0].setLayout(new BorderLayout());
        setBorder();

        //PANEL FOR THE SLOT MACHINE
        panel[2].add(label[0]);
        panel[2].add(label[1]);
        panel[2].add(label[2]);

        //PANEL FOR LABELS AND TEXTFIELDS
        panel[1].add(lbl);
        tf.setText("20");
        tf.setEnabled(false);
        tf.setBackground(Color.black);
        panel[1].add(tf);


        //PANEL FOR THE BUTTONS
        panel[3].add(spin);
        spin.addActionListener(this);

        //ADDING THE OTHER PANELS INSIDE A ONE PANEL
        panel[0].add(panel[1], BorderLayout.WEST);
        panel[0].add(panel[2], BorderLayout.CENTER);
        panel[0].add(panel[3], BorderLayout.SOUTH);

        getContentPane().add(panel[0]);
        setPreferredSize(new Dimension(700,300));
        setBounds(500,150,500,500);
        setVisible(true);
        setResizable(false);
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //GENERATE RANDOM NUMBERS FOR THE INDEXES OF THE ARRAY
    public void randomNumbers1(){
        index1 = (int)(Math.random() * images.length);
    }

    public void randomNumbers2(){
        index2 = (int)(Math.random() * images.length);
    }

    public void randomNumbers3(){
        index3 = (int)(Math.random() * images.length);
    }

    //RANDOMLY SET THE IMAGES TO BE DISPLAYED BASED ON THE GENERATED RANDOM NUMBERS
    public void displayRandomImages1(int index1){
        label[0].setIcon(new ImageIcon(new ImageIcon(images[index1]).getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH)));
    	//label[0].setIcon(new ImageIcon(new ImageIcon(images[index1]).getImage().getScaledInstance(150,150,0)));
    }

    public void displayRandomImages2(int index2){
       label[1].setIcon(new ImageIcon(new ImageIcon(images[index2]).getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH)));
    	//label[1].setIcon(new ImageIcon(new ImageIcon(images[index2]).getImage().getScaledInstance(150,150,0)));
    }

    public void displayRandomImages3(int index3){
        label[2].setIcon(new ImageIcon(new ImageIcon(images[index3]).getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH)));
        //label[2].setIcon(new ImageIcon(new ImageIcon(images[index3]).getImage().getScaledInstance(150,150,0)));
    }
    //SETTING THE BORDERS FOR THE PANEL[0] AND FOR THE IMAGES
    public void setBorder(){
        for(i=0;i<3;i++){
            label[i].setBorder(BorderFactory.createCompoundBorder(new BevelBorder(BevelBorder.RAISED), new BevelBorder(BevelBorder.RAISED)));
        }
        panel[0].setBorder(BorderFactory.createCompoundBorder(new BevelBorder(BevelBorder.RAISED), new BevelBorder(BevelBorder.LOWERED)));
    }

    //IDENTIFY IF THE 3 IMAGES ARE THE SAME
    public boolean isWon(){
        boolean win = false;
        if(index1 == index2 && index2 == index3){
            win = true;
        }
        return win;
    }

    //INCREMENT THE NUMBER OF WINS
    public synchronized int countWin(){
       count = Integer.parseInt(tf.getText());
       if(isWon() == true){
           count++;
           if(count>20){
               count = max;
           }
       }
       else{
           count--;
           if(count==-1){
               int msg = JOptionPane.showConfirmDialog(null,"Sorry\nOut of Chances...Play Again?","\nOut of Chances", JOptionPane.YES_NO_OPTION);
               if(msg == JOptionPane.YES_OPTION){
                   count = max;
               }else{
                   dispose();
               }
           }
       }
	   spin.setEnabled(true);
       return count;
    }

    //FUNCTION WHEN THE SPIN BUTTON IS CLICK
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource().equals(spin)){
           Thread thread = new Thread(new Runnable(){
                public void run(){
                    tm = new Timer(50, new ActionListener(){
                        public void actionPerformed(ActionEvent ae){
                            randomNumbers1();
                            displayRandomImages1(index1);
                            if(c==images.length){
                                c = 0;
                                tm.stop();
                            }else{
                                c++;
                            }
                        }
                    });
                    tm.setInitialDelay(100);
                    tm.setRepeats(true);
                    tm.start();
                }
            });
            thread.start();

            Thread thread1 = new Thread(new Runnable(){
                public void run(){
                        tm1 = new Timer(50, new ActionListener(){
                        public void actionPerformed(ActionEvent ae){
                            randomNumbers2();
                            displayRandomImages2(index2);
                            if(d==images.length){
                                d = 0;
                                tm1.stop();
                            }else{
                                d++;
                            }
                        }
                    });
                    tm1.setInitialDelay(800);
                    tm1.setRepeats(true);
                    tm1.start();
                }
            });
			//thread1.start();

            Thread thread2 = new Thread(new Runnable(){
                public void run(){
                        tm2 = new Timer(50, new ActionListener(){
                        public void actionPerformed(ActionEvent ae){
                            randomNumbers3();
                            displayRandomImages3(index3);
                            if(f==images.length){
                                f = 0;
                                tm2.stop();
                                if(isWon() == true){
									//This method uses a new JFrame which contains the image of the word "WINNER".
                                    //new Winner();

                                    /*
                                    ** The use of JOptionPane here is a way so that if the player wins, an image of the word "WINNER"
                                    ** will appear which will then disable the player to spin again unless the player closes the pop up
                                    ** dialog box.
                                    */
									JOptionPane.showMessageDialog(null, picWinner, "YOU WIN!!!", JOptionPane.PLAIN_MESSAGE, null);

									//This method is almost the same as using JOptionPane but has a slight difference.
									/*JDialog dialog = new JDialog();
									//dialog.setUndecorated(true);
									dialog.add(picWinner);
									dialog.pack();
									dialog.setVisible(true);*/

                                    tf.setText(String.valueOf(countWin()));
                                    label[0].setIcon(new ImageIcon(new ImageIcon(images[index1]).getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH)));
                                    label[1].setIcon(new ImageIcon(new ImageIcon(images[index2]).getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH)));
                                    label[2].setIcon(new ImageIcon(new ImageIcon(images[index3]).getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH)));

                                    /*label[0].setIcon(new ImageIcon(new ImageIcon(images[index1]).getImage().getScaledInstance(150,150,0)));
									label[1].setIcon(new ImageIcon(new ImageIcon(images[index2]).getImage().getScaledInstance(150,150,0)));
                                    label[2].setIcon(new ImageIcon(new ImageIcon(images[index3]).getImage().getScaledInstance(150,150,0)));*/
                                }else{
                                    tf.setText(String.valueOf(countWin()));
                                }
                            }else{
                                f++;
                            }
                        }
                    });
                    tm2.setInitialDelay(1400);
                    tm2.setRepeats(true);
                    tm2.start();
                }
            });
            //thread2.start();

           try{
                thread.join();
            }catch(InterruptedException ie){}

            thread1.start();
            try{
                thread1.join();
            }catch(InterruptedException ie){}

            thread2.start();
            try{
			   thread2.join();
            }catch(InterruptedException ie){}
        }
        spin.setEnabled(false);
    }

    //MAIN CLASS
    public static void main(String[] args){
        Thread t = new Thread(new Runnable(){
			public void run(){
				new Spin();
			}
		});
        t.start();
    }
}