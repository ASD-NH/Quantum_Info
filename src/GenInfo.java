import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileInputStream;
import java.net.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.*;
import org.apache.commons.io.FileUtils;



public class GenInfo {
	private static JButton[] buttons;
	private static JPanel botPanel;
	private static JScrollPane scroll;
	private static JPanel topPanel;
	
	private static Text intro;
	private static Text finish;
	private static Text current;
	private static Text entanglment;
	private static Text quantumLogic;
	private static Text speed;
	private static Text superPostion;
	private static Text uses;
	private static Text[] text;
	
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
	
	public static void showVideo(String name,String u){
		JFrame videoFrame = new JFrame(name);
		JFXPanel videoPanel= new JFXPanel();
		videoFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		try {
		    File videoFile = new File(u);
			URL url = videoFile.toURI().toURL();
			MediaPlayer player = new MediaPlayer(new Media(u));
			player.play();
			videoPanel.setScene(new Scene(new Group(new MediaView(player))));
			videoFrame.add(videoPanel);
		}
		catch(Exception e){
			e.printStackTrace();
			Utils.showError("Error loading Video");
		}
		

	}
	
	public static void generatePanel(){
		botPanel = new JPanel(new GridBagLayout());
		topPanel = new JPanel(new BorderLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		text = new Text[8];
		text[0]=(intro = new Text());
		text[1]=(finish= new Text());
		text[2]=(entanglment = new Text());
		text[3]=(speed = new Text());
		text[4]=(superPostion = new Text());
		text[5]=(uses = new Text());
		text[6]=(current = new Text());
		text[7]=(quantumLogic = new Text()); 
		
		buttons = new JButton[7];
		back = new JButton("Back");
		exit  = new JButton("Exit");
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
			intro.append(FileUtils.readFileToString(new File("text/Intro.txt")));
			current.append(FileUtils.readFileToString(new File("text/CurrentState.txt")));
			finish.append(FileUtils.readFileToString(new File("text/Conclusion.txt")));
			entanglment.append(FileUtils.readFileToString(new File("text/Entanglment.txt")));
			quantumLogic.append(FileUtils.readFileToString(new File("text/QuantumLogic.txt")));
			speed.append(FileUtils.readFileToString(new File("text/Speed.txt")));
			superPostion.append(FileUtils.readFileToString(new File("text/SuperPosition.txt")));
			uses.append(FileUtils.readFileToString(new File("text/Uses.txt")));	
		}
		catch(Exception e){
			e.printStackTrace();
			Utils.showError("Error Loading Text.");
		}
		c.gridx=0;
		c.gridy=0;
		botPanel.add(back,c);
		c.gridy++;
		botPanel.add(intro,c);
		c.gridy++;
		botPanel.add(video1,c);
		c.gridy++;
		botPanel.add(superPostion,c);
		c.gridy++;
		botPanel.add(video2,c);
		c.gridy++;
		botPanel.add(entanglment,c);
		c.gridy++;
		botPanel.add(video3,c);
		c.gridy++;
		botPanel.add(quantumLogic,c);
		c.gridy++;
		botPanel.add(speed,c);
		c.gridy++;
		botPanel.add(uses,c);
		c.gridy++;
		botPanel.add(finish,c);
		c.gridy++;
		botPanel.add(paper1,c);
	    c.gridy++;
		botPanel.add(paper2,c);

		
		scroll = new JScrollPane(botPanel);
		scroll.setPreferredSize(new Dimension(800,450));
		scroll.getVerticalScrollBar().setUnitIncrement(16);
		scroll.getVerticalScrollBar().setValue(0);
		topPanel.add(scroll,BorderLayout.PAGE_START);
	}
}
