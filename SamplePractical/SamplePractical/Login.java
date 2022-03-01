/**
** Author: Garcia, Leamor T.
** Date: 12/20/19
** Login GUI
**/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener{
	private JPanel panel = new JPanel();
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private static final String USERNAME = "CIT";
	private static final String PASS = "CIT";
	private JLabel username =  new JLabel("Username:");
	private JLabel password =  new JLabel("Password:");
	private JPasswordField pfpassword = new JPasswordField();
	private JTextField tfusername=  new JTextField(10);
	private JButton btnOk =  new JButton("Ok");
	private JButton btnCancel =  new JButton("Cancel");

	public Login(){
		setTitle("Log-in");
		panel1.setLayout(new GridLayout(3,2,5,5));
		panel1.add(username);
		panel1.add(tfusername);
		panel1.add(password);
		panel1.add(pfpassword);

		panel2.add(btnOk);
		btnOk.addActionListener(this);
		panel2.add(btnCancel);
		btnCancel.addActionListener(this);

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
		if(ae.getSource().equals(btnOk)){
			if(tfusername.getText().equals(USERNAME) && pfpassword.getText().equals(PASS)){
				System.out.println("WELCOME");
			}
			else if(!tfusername.getText().equals(USERNAME)){
				JOptionPane.showMessageDialog(null,"Wrong username");
			}
			else if(!pfpassword.getText().equals(PASS)){
				JOptionPane.showMessageDialog(null,"Wrong password");
			}
			else{
				JOptionPane.showMessageDialog(null,"Wrong password and username");
			}
		}
		else if(ae.getSource().equals(btnCancel)){
			dispose();
		}
	}
	public static void main(String[] args){
		new Login();
	}
}