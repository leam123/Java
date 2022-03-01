/**
** Author: Garcia, Leamor T.
** Date: 12/20/19
** Employee GUI
**/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Employee extends JFrame implements ActionListener{
	private JPanel panel = new JPanel();
	private JPanel p = new JPanel();
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	private JPanel panel4 = new JPanel();
	private JPanel panel5 = new JPanel();
	private JPanel panel6 = new JPanel();

	private JLabel empid =  new JLabel("Employee ID:");
	private JLabel lastname =  new JLabel("Last Name:");
	private JLabel firstname =  new JLabel("First Name:");
	private JLabel middlename =  new JLabel("Middle Name:");
	private JLabel bdate =  new JLabel("BirthDate:");
	private JLabel height =  new JLabel("Height:");
	private JLabel weight =  new JLabel("Weight:");
	private JLabel position =  new JLabel("Position:");
	private JLabel department =  new JLabel("Department:");
	private JLabel gender =  new JLabel("Gender:");
	private JLabel status =  new JLabel("Status:");
	private JLabel zodiac =  new JLabel("Zodiac Sign:");

	private JTextField tfempid=  new JTextField(5);
	private JTextField tflastname =  new JTextField(5);
	private JTextField tfirstname =  new JTextField(5);
	private JTextField tfmiddlename =  new JTextField(5);
	private JTextField tfbdate =  new JTextField(5);
	private JTextField tfheight =  new JTextField(5);
	private JTextField tfweight =  new JTextField(5);
	private JTextField tfposition =  new JTextField(5);
	private JTextField tfdepartment =  new JTextField(5);
	private JTextField tfzodiac =  new JTextField(10);

	private JRadioButton male =  new JRadioButton("Male");
	private JRadioButton female =  new JRadioButton("Female");
	private JRadioButton single =  new JRadioButton("Single");
	private JRadioButton married =  new JRadioButton("Married");

	private ButtonGroup btngroup = new ButtonGroup();

	private JButton btnAdd =  new JButton("Add");
	private JButton btnDelete =  new JButton("Delete");
	private JButton btnEdit =  new JButton("Edit");
	private JButton btnSearch =  new JButton("Search");
	private JButton btnClear =  new JButton("Clear");
	private JButton btnExit =  new JButton("Exit");

	public Employee(){
		setTitle("Employee");
		panel1.setLayout(new GridLayout(1,2,10,10));
		panel1.add(empid);
		panel1.add(tfempid);

		panel2.setLayout(new GridLayout(1,3,10,10));
		panel3.setLayout(new GridLayout(1,3,10,10));
		panel3.add(lastname);
		panel2.add(tflastname);
		panel3.add(firstname);
		panel2.add(tfirstname);
		panel3.add(middlename);
		panel2.add(tfmiddlename);

		p.setLayout(new BorderLayout());
		p.add(panel1, BorderLayout.NORTH);
		p.add(panel2, BorderLayout.CENTER);
		p.add(panel3, BorderLayout.SOUTH);

		panel4.setLayout(new GridLayout(5,2,10,10));
		panel4.add(bdate);
		panel4.add(tfbdate);
		panel4.add(height);
		panel4.add(tfheight);
		panel4.add(weight);
		panel4.add(tfweight);
		panel4.add(position);
		panel4.add(tfposition);
		panel4.add(department);
		panel4.add(tfdepartment);

		panel5.setLayout(new GridLayout(3,2,10,10));
		panel5.add(gender);
		panel5.add(male);
		panel5.add(female);
		panel5.add(status);
		panel5.add(status);
		panel5.add(single);
		panel5.add(married);
		panel5.add(zodiac);
		panel5.add(tfzodiac);

		panel6.setLayout(new GridLayout(2,3,10,10));
		panel6.add(btnAdd);
		btnAdd.addActionListener(this);
		panel6.add(btnDelete);
		btnDelete.addActionListener(this);
		panel6.add(btnEdit);
		btnEdit.addActionListener(this);
		panel6.add(btnSearch);
		btnSearch.addActionListener(this);
		panel6.add(btnClear);
		btnClear.addActionListener(this);
		panel6.add(btnExit);
		btnExit.addActionListener(this);

		panel.setLayout(new BorderLayout());
		panel.add(p, BorderLayout.NORTH);
		panel.add(panel4, BorderLayout.WEST);
		panel.add(panel5, BorderLayout.EAST);
		panel.add(panel6, BorderLayout.SOUTH);

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
		else if(ae.getSource().equals(btnSearch)){

		}
		else if(ae.getSource().equals(btnClear)){

		}
		else if(ae.getSource().equals(btnExit)){
			dispose();
		}
	}
	public static void main(String[] args){
		new Employee();
	}
}