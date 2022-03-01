/**
** Author: Garcia, Leamor T.
** Date: 12/20/19
** Logoff GUI
**/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Logoff extends JFrame implements ActionListener{
	private JPanel panel = new JPanel();
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();

	private JLabel msg =  new JLabel("Are you sure you  want to log-off?", JLabel.CENTER);
	private JButton btnYes =  new JButton("Yes");
	private JButton btnNo =  new JButton("No");

	public Logoff(){
		setTitle("Log-off");

		panel.setLayout(new GridLayout(2,1));
		msg.setForeground(Color.red);
		panel1.add(msg);
		panel2.add(btnYes);
		btnYes.addActionListener(this);
		panel2.add(btnNo);
		btnNo.addActionListener(this);

		panel.setLayout(new BorderLayout());
		panel.add(panel1, BorderLayout.NORTH);
		panel.add(panel2);

		getContentPane().add(panel);
		setVisible(true);
		setResizable(false);
		pack();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource().equals(btnYes)){
			dispose();
		}
		else if(ae.getSource().equals(btnNo)){

		}
	}
	public static void main(String[] args){
		new Logoff();
	}
}