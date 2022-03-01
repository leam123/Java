import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LabelClicked extends JFrame{
	JPanel panel = new JPanel();
	JLabel label = new JLabel("File");
	String[] choices = {"Java", "4.5", "4.5", "4.5"};
	JComboBox cb = new JComboBox(choices);

	public LabelClicked(){
		setTitle("Clickable JLabel");

		//panel.add(label);
		panel.add(cb);
		label.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent me){
				//action statements
			}
			/*public void mouseExited(MouseEvent me){}
			public void mouseReleased(MouseEvent me){}
			public void mouseEntered(MouseEvent me){}
			public void mousePressed(MouseEvent me){}*/
		});

		getContentPane().add(panel);
		setVisible(true);
		setResizable(true);
		pack();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	//public void actionPerformed(ActionEvent ae){}

	public static void main(String[] args){
		new LabelClicked();
	}
}