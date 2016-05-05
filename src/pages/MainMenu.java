package pages;
import java.awt.Color;
import java.awt.*;
import javax.swing.*;

import utilities.Listener;



public class MainMenu {
	private static JPanel panel;
	private static JButton exit;
	private static JButton info;
	private static JButton speed;
	private static JButton QtoC;
	private static JButton[] buttons;
	
		
	public MainMenu(){
		generatePanel();
	}
	public static JPanel getPanel(){
		return panel;
	}
	public static JButton getButton(int n){
		return buttons[n];
	}
	public static void generatePanel(){
		panel = new JPanel();
		panel.setSize(1000, 1000);
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		buttons = new JButton[4];
		
		exit = new JButton("Exit");
		info = new JButton("Introduction");
		speed = new JButton("Speed Comparisions");
		QtoC = new JButton("Quantum to Classical");
		
		buttons[0]=exit;
		buttons[1]=info;
		buttons[2]=speed;
		buttons[3]=QtoC;
		
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx=gbc.CENTER;
		
		for (int i =0; i< buttons.length;i++){
			buttons[i].addActionListener(new Listener());
			gbc.gridy=i;
			panel.add(buttons[i],gbc);
		}
		
		
		
	}
}
