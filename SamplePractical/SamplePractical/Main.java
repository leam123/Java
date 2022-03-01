/**
** Author: Garcia, Leamor T.
** Date: 12/20/19
** Main GUI
**/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements ActionListener{
	private JPanel panel = new JPanel();
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();

	private ImageIcon img = new ImageIcon(new ImageIcon("Z:/L13X09W06/SamplePractical/citLogo.jpg").getImage().getScaledInstance(280,230,Image.SCALE_SMOOTH));
	private JLabel logo = new JLabel(img);

	private String[] combolist1 = {"Login","Logoff","Exit"};
	private String[] combolist2 = {"Employee","Position"};
	private String combolist3 = "Help";

	private JButton btnFile =  new JButton("File");

    private JComboBox comboBox1 = new JComboBox();
    private JComboBox comboBox2 = new JComboBox();
    private JComboBox comboBox3 = new JComboBox();

	public Main(){
		setTitle("Cebu Institute of Technology");

		for(int i=0;i<combolist1.length;i++){
		    comboBox1.addItem(combolist1[i]);
        }
        comboBox1.addActionListener(this);
		comboBox1.setUI(new HideArrowButton());
      	//btnFile.add(comboBox1);
        for(int i=0;i<combolist2.length;i++){
				    comboBox2.addItem(combolist2[i]);
        }
		comboBox2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				if(comboBox2.getSelectedItem().equals("Employee")){
					new Employee();
				}
				else if(comboBox2.getSelectedItem().equals("Position")){
					new Position();
				}
			}
		});
		comboBox2.setUI(new HideArrowButton());

		comboBox3.addItem(combolist3);
        comboBox3.addActionListener(this);
		comboBox3.setUI(new HideArrowButton());

		/*logo.setLayout(new FlowLayout());
		logo.add(comboBox1);
		logo.add(comboBox2);
		logo.add(comboBox3);
		panel.add(logo);
		*/

      	panel1.add(logo);

		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel2.setBackground(Color.gray);
		panel2.add(comboBox1);
		//panel2.add(btnFile);
		panel2.add(comboBox2);
		panel2.add(comboBox3);

		panel.setLayout(new BorderLayout());
		panel.add(panel1, BorderLayout.SOUTH);
		panel.add(panel2, BorderLayout.NORTH);

		getContentPane().add(panel);
		setPreferredSize(new Dimension(300,300));
		setVisible(true);
		setResizable(false);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae){
		if(comboBox1.getSelectedItem().equals("Login")){
				new Login();
		}
		else if(comboBox1.getSelectedItem().equals("Logoff")){
				new Logoff();
		}
		else if(comboBox1.getSelectedItem().equals("Exit")){
				dispose();
		}
	}
	public static void main(String[] args){
		new Main();
	}
}