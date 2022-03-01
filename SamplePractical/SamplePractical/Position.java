/**
** Author: Garcia, Leamor T.
** Date: 12/20/19
** Position GUI
**/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Position extends JFrame implements ActionListener{
	private JPanel panel = new JPanel();
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();

	private JLabel psname =  new JLabel("Position Name:");
	private JLabel pscode =  new JLabel("Position Code:");
	private JLabel salary =  new JLabel("Salary:");

	private JTextField tfpsname=  new JTextField(10);
	private JTextField tfpscode=  new JTextField(10);
	private JTextField tfsalary=  new JTextField(10);

	private JButton btnAdd =  new JButton("Add");
	private JButton btnDelete =  new JButton("Delete");
	private JButton btnEdit =  new JButton("Edit");
	private JButton btnClear =  new JButton("Clear");
	private JButton btnExit =  new JButton("Exit");

	public Position(){
		setTitle("Position");
		panel1.setLayout(new GridLayout(3,2,5,5));
		panel1.add(psname);
		panel1.add(tfpsname);
		panel1.add(pscode);
		panel1.add(tfpscode);
		panel1.add(salary);
		panel1.add(tfsalary);

		panel2.add(btnAdd);
		btnAdd.addActionListener(this);
		panel2.add(btnDelete);
		btnDelete.addActionListener(this);
		panel2.add(btnEdit);
		btnEdit.addActionListener(this);
		panel2.add(btnClear);
		btnClear.addActionListener(this);
		panel2.add(btnExit);
		btnExit.addActionListener(this);

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
			if(ae.getSource().equals(btnAdd)){

			}
			else if(ae.getSource().equals(btnDelete)){

			}
			else if(ae.getSource().equals(btnEdit)){

			}
			else if(ae.getSource().equals(btnClear)){

			}
			else if(ae.getSource().equals(btnExit)){
				dispose();
			}
	}
	public static void main(String[] args){
		new Position();
	}
}