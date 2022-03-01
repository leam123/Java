import java.util.Iterator;
import java.util.ListIterator;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Array extends JFrame{
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	private JPanel panel4 = new JPanel();

	private JTextArea ta = new JTextArea(10,50);

	private JButton btn1 = new JButton("Add");
	private JButton btn2 = new JButton("Search");
	private JButton btn3 = new JButton("Edit");
	private JButton btn4 = new JButton("Delete");

	private JTextField tf = new JTextField(20);
	private JLabel label = new JLabel("Enter Name");

	ArrayList<String> list = new ArrayList<String>();

	public Array(){
		setTitle("Array");
		panel1.setLayout(new GridLayout(1,2));
		panel1.add(label);
		panel1.add(tf);

		panel2.add(btn1);
		btn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				if(ae.getSource().equals(btn1)){
					list.add(tf.getText());
					tf.setText("");
					//System.out.println(list);
					ta.setText(list + "\n");
				}
			}
		});

		panel2.add(btn2);
				btn2.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ae){
						if(ae.getSource().equals(btn2)){
							String str = JOptionPane.showInputDialog(null,"Name to Locate");
							for(int i=0;i<list.size();i++){
								if(list.get(i).equals(str)){
									ta.append(str + " is located at index " + i + "\n");
								}
							}
							/*ListIterator<String> it = list.listIterator();
							while(it.hasNext()){
								if(it.next().equals(str)){
									ta.append("ok");
								}
							}*/
						}
				}
		});

		panel2.add(btn3);
				btn3.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ae){
						if(ae.getSource().equals(btn3)){
						String str = JOptionPane.showInputDialog(null,"Search Name to Edit");
						String str1 = JOptionPane.showInputDialog(null,"Replace With");
						for(int i=0;i<list.size();i++){
							if(list.get(i).equals(str)){
								list.set(i,str1);
								ta.append(list + "\n");
							}
						}
						/*Iterator<String> it = list.iterator();
						while(it.hasNext()){
							if(it.next().equals(str)){
								list.set(list.get(it.next()), tf.getText());
							}
						}*/
					}
				}
		});

		panel2.add(btn4);
			btn4.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					if(ae.getSource().equals(btn4)){
						int count = 0;
						String str = JOptionPane.showInputDialog(null,"Search Name to Delete");
						for(int i=0;i<list.size();i++){
							for(int x=i + 1; x<list.size(); x++){
								if(list.get(i).equals(list.get(x))){
									count++;
								}
							}
						}
						for(int i=0;i<list.size();i++){
							if(list.get(i).equals(str)){
								if(count>0){
									int notif = Integer.parseInt(JOptionPane.showInputDialog(null,"There are 2 " + str + " in the list\n What index would you like to delete?"));
									list.remove(notif);
									count = 0;
								}else if(count==0){
									list.remove(i);
								}
								ta.append(list + "\n");
							}
						}
					}
				}
		});

		panel3.add(ta);

		panel4.setLayout(new BorderLayout());
		panel4.add(panel1, BorderLayout.NORTH);
		panel4.add(panel3, BorderLayout.CENTER);
		panel4.add(panel2, BorderLayout.SOUTH);

		getContentPane().add(panel4);
		setVisible(true);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args){
		new Array();
	}
}