import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import org.apache.commons.io.FileUtils;

public class GenInfo {
	private static JButton[] buttons;
	private static JPanel botPanel;
	private static JScrollPane scroll;
	private static JPanel topPanel;
	private static JTextArea intro;
	private static JButton back;
	private static JButton video1;
	private static JButton video2;
	private static JButton video3;
	private static JButton paper1;
	private static JButton paper2;
	private static JButton exit;
	
	public GenInfo(){
		generatePanel();
	}
	public static JPanel getPanel(){
		return topPanel;
	}
	public static JButton getButton(int n){
		return buttons[n];
	}
	
	public static void showVideo(String name){
		JFrame videoFrame = new JFrame(name);
		JPanel videoPanel= new JPanel();
		videoFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		videoFrame.getContentPane().add(videoPanel);
		videoFrame.pack();
		videoFrame.setVisible(true);
	}
	
	public static void generatePanel(){
		botPanel = new JPanel(new GridBagLayout());
		topPanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		intro = new JTextArea(10,100);
		intro.setFont(new Font("SERIF",Font.PLAIN,12));
		intro.setEditable(false);
		buttons = new JButton[7];
		
		back = new JButton("back");
		exit  = new JButton("exit");
		video1 = new JButton("Super Postion Video");
		video2 = new JButton("Quantum Computers Intro");
		video3 = new JButton("Processing Advantages");
		paper1 = new JButton("Useful paper 1");
		paper2 = new JButton("Useful paper 2");
		
		
		buttons[0]=back;
		buttons[1]=exit;
		buttons[2]=video1;
		buttons[3]=video2;
		buttons[4]=video3;
		buttons[5]=paper1;
		buttons[6]=paper2;
		
		for (int i =0; i< buttons.length;i++){
			buttons[i].addActionListener(new Listener());
		}
	
		
		try{
			intro.append(FileUtils.readFileToString(new File("~/../text/Intro.txt")));
		}
		catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(Quantum.getFrame(), "Error Loading Text.");
		}
		
		c.gridx=0;
		c.gridy=0;
		c.anchor=GridBagConstraints.PAGE_START;
	
		botPanel.add(intro,c);
		
		scroll = new JScrollPane(botPanel);
		scroll.setPreferredSize(new Dimension(1000,1000));
		scroll.getVerticalScrollBar().setUnitIncrement(16);
		
		c.gridheight=10;
		c.gridwidth=10;
		topPanel.add(scroll,c);
		
//		topPanel.add(buttons[1],c);
//		
//		topPanel.add(buttons[0],c);
//	
			
	}
}
