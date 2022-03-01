/**
** Prelim
** @author LFeliz
** @date December 4, 2019
**/
import java.awt.*;
import java.awt.event.*;

public class Prelim extends Frame implements{
   private Button btnOk=new Button("OK");
   private Button btnExit=new Button("Exit");
   private Panel pnlUpper=new Panel(new GridLayout(2,1));
   public UIProcess(){
      super("Processes");
      initialize();
      pnlUpper.add(btnMsPaint);
      pnlUpper.add(btnNotepad);
      this.add(pnlUpper);
      this.setSize(500, 150);
      this.setVisible(true);
   }

   public void initialize(){
	  btnMsPaint.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae){
			ProcessBuilder pb=new ProcessBuilder("mspaint.exe");
			try {
		      pb.start();
		    }catch (IOException e) {
              e.printStackTrace();
	        }
		}
	  });
      btnNotepad.addActionListener(new ActionListener(){
	  		public void actionPerformed(ActionEvent ae){
	  			ProcessBuilder pb=new ProcessBuilder("notepad.exe");
	  			try {
	  		      pb.start();
	  		    }catch (IOException e) {
	                e.printStackTrace();
	  	        }
	  		}
	  });
   }

   public static void main(String args[]){
	   new UIProcess();
   }
}