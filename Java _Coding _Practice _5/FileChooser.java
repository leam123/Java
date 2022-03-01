import java.io.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.*;

public class FileChooser extends JFrame implements ActionListener{
	private JLabel label = new JLabel();
	private ImageIcon icon;
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	private JButton btnImage = new JButton("Add Image");
	private JButton btnVideo = new JButton("Play Video");
	private JButton btnExit = new JButton("Exit");
	private JFileChooser jfc = new JFileChooser();
	private FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG PNG GIF","jpg", "png", "gif");

	public FileChooser(){
		setTitle("JFileChooser");

		panel1.add(label);

		panel2.add(btnImage);
		btnImage.addActionListener(this);
		panel2.add(btnVideo);
		btnVideo.addActionListener(this);
		panel2.add(btnExit);
		btnExit.addActionListener(this);

		panel3.setLayout(new BorderLayout());
		panel3.add(panel1, BorderLayout.NORTH);
		panel3.add(panel2, BorderLayout.SOUTH);

		setPreferredSize(new Dimension(500,500));
		getContentPane().add(panel3);
		setVisible(true);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent ae){
		if(ae.getSource().equals(btnImage)){
			//jfc.setAcceptAllFileFilterUsed(false);
			jfc.addChoosableFileFilter(filter);
			//jfc.setFileFilter(filter);
			int x =  jfc.showSaveDialog(null);

			if(x == JFileChooser.APPROVE_OPTION){
				icon = new ImageIcon(new ImageIcon(jfc.getSelectedFile().getAbsolutePath()).getImage().getScaledInstance(450,430,0));
				label.setIcon(icon);

				//System.out.println(getFile(jfc.getSelectedFile().getName()));
			}
		}else if(ae.getSource().equals(btnVideo)){
			int x =  jfc.showSaveDialog(null);

			if(x == JFileChooser.APPROVE_OPTION){
				try{
					Desktop.getDesktop().open(new File(jfc.getSelectedFile().getAbsolutePath()));
				}catch(IOException ex){}
			}
		}else if(ae.getSource().equals(btnExit)){
			dispose();
		}
	}

	public String getFile(String filename){
		StringBuffer sb = new StringBuffer(20);
		//boolean ok = false;
		try{
			FileReader fr = new FileReader(filename);
			int i = 0;
			while((i = fr.read()) != -1){
				sb.append((char)i);
			}
			//ok = true;
		}catch(FileNotFoundException ex){

		}catch(IOException ie){}

		return sb.toString();
	}

	public static void main(String[] args){
		new FileChooser();
	}
}