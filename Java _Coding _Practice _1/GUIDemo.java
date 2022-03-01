import javax.swing.*;
import java.awt.*;

public class GUIDemo extends JFrame{
String choicesCombo[] = {"Cebu","Manila","Surigao","Bohol"};
	JPanel panel = new JPanel();
	JLabel label = new JLabel("Label");
	JTextArea tarea = new JTextArea(6,3);
	JScrollPane pane = new JScrollPane(tarea);
	JPasswordField passField = new JPasswordField();
	JTextField tf = new JTextField(20);
	JButton button= new JButton("Button");
	JComboBox combo = new JComboBox();
	JCheckBox chk1 = new JCheckBox("Check Box1");
	JCheckBox chk2 = new JCheckBox("Check Box2");

	ButtonGroup rgroup = new ButtonGroup();
	JRadioButton radioMale = new JRadioButton("Male");
	JRadioButton radioFemale = new JRadioButton("Female");

	public GUIDemo(){
		panel.setLayout(new GridLayout(5,2,3,3));
		panel.add(label);panel.add(pane);
		panel.add(passField);panel.add(tf);
		panel.add(button);panel.add(combo);
		panel.add(chk1);panel.add(chk2);
		panel.add(radioMale);panel.add(radioFemale);

		rgroup.add(radioMale);rgroup.add(radioFemale);

		//combo.addItem("Cebu");
		for(int ctr = 0; ctr < choicesCombo.length; ctr++)
			combo.addItem(choicesCombo[ctr]);

		getContentPane().add(panel);
		setVisible(true);
		pack();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args){
		new GUIDemo();
	}

}