import java.awt.Font;
import java.io.File;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.apache.commons.io.FileUtils;

import java.awt.*;

public class SpeedCompare {
	private static JButton[] buttons;
	private static JPanel panel;
	
	private static JButton bits;
	private static JButton problems;
	private static JButton examples;
	private static JButton factorPage;
	private static JButton factor;
	private static JButton back;
	private static JButton exit;
	private static JButton factorInfo;
	
	private static JLabel inputQLabel;
	private static JLabel inputCLabel;
	private static JLabel factorLabel;
	private static JLabel exampleLabel;
	private static JLabel problemLabel;
	private static JLabel outFactorLabelQ;
	private static JLabel outFactorLabelC;
	
	private static Text inputQ;
	private static Text inputC;
	private static Text inputFactor;
	private static Text outFactorQ;
	private static Text outFactorC;
	private static Text factorInfoText;
	
	private static JComboBox exampleSelect;
	private static JComboBox problemSelect;
	private static int state;
	
	
	public SpeedCompare(){
	    panel = new JPanel(new GridBagLayout());
        buttons = new JButton[8];
        buttons[0]=(back= new JButton("Back"));
        buttons[1]=(exit= new JButton("Exit"));
        buttons[2]=(bits= new JButton("Bit comparison"));
        buttons[3]=(factorPage= new JButton("Factoring Comparison"));
        buttons[4]=(factor= new JButton("Factor"));
        buttons[5]=(problems= new JButton("Problem speed Examples"));
        buttons[6]=(examples= new JButton("Compared to Current Computers"));
        buttons[7] =(factorInfo = new JButton("More info on how this is calculated"));

        
        for (int i =0;i<buttons.length;i++){
            buttons[i].addActionListener(new Listener());
        }
	    generateMainPanel();
	}
	
	public static JPanel getPanel(){
		return panel;
	}
	public static JButton getButton(int n){
		return buttons[n];
	}
	public static int getState(){
	    return state;
	}
	
	public static void generateMainPanel(){
        panel = new JPanel(new GridBagLayout());

	    state=0;
	    GridBagConstraints c = new GridBagConstraints();
	    
	    c.gridy=0;
	    c.gridx=0;
	    c.anchor=c.NORTHWEST;
	    c.weightx=1;
	    c.weighty=1;
	    panel.add(back,c);
	    c.anchor=c.NORTHEAST;
	    panel.add(exit,c);

	    c.gridx=0;;
	    c.anchor=GridBagConstraints.NORTH;
	    c.gridy=1;
	    c.weighty=0;
	    panel.add(factorPage,c);
	    c.gridy++;
	    panel.add(examples,c);
	    c.gridy++;
	    panel.add(bits,c);
	    c.gridy++;
	    panel.add(problems,c);
	}
	public static void factor(){
	    String input = inputFactor.getText();
	    long val = parseInput(input);
	    outFactorQ.setText(timeToFactorQ(val));
	    outFactorC.setText(timeToFactorC(val));
	    inputFactor.setText("");
	}
	private static long parseInput(String input){
	    long val =-1;
	    try{
	        val = Long.parseLong(input);
	    }
	    catch(Exception NumberFormatException){
	        Utils.showError("Please enter just a number");
	    }
	    return val;
	}
	private static String timeToFactorQ(long n){
 
        double shors = Math.pow(Math.log(n),2) * Math.log(Math.log(n))* Math.log(Math.log(Math.log(n)));
        double time = shors * Quantum.timePerOpp;
        double time_s = time * (1e-9);
        return "The time to factor is approximatly " + time +" nanoseconds or " +  time_s + " seconds";
	    
	}
	private static String timeToFactorC(long n){
	    
	    double opps = Math.sqrt(n);
	    double time = opps * Quantum.timePerOpp;
        double time_s = time * (1e-9);
	    return "The time to factor is approxximatly " + time +" nanoseconds "  +  time_s + " seconds";
	}

	public static void generateFactorPanel(){
        panel = new JPanel(new GridLayout(0,2,10,10));
	    state=1;
	    factorLabel = new JLabel("Enter a number to be factored");
	    outFactorLabelQ = new JLabel("The time on a quantum computer");
	    outFactorLabelC = new JLabel("The time on a classical computer");	
	    outFactorQ = new Text();
	    outFactorC = new Text();
	    inputFactor = new Text(true);
     
        
        panel.add(back);
  	    panel.add(factor);
  	    
        panel.add(factorLabel);
	    panel.add(inputFactor);
	    
        panel.add(outFactorLabelQ);
        panel.add(outFactorLabelC);
        
        panel.add(outFactorQ);
        panel.add(outFactorC);
        
        panel.add(factorInfo);

	    
	    
	}
	public static void geneateFactorInfo(){
        panel = new JPanel(new GridLayout(0,1,10,10));
	    state =4;
	    factorInfoText = new Text();
	    try{
	        factorInfoText.append(FileUtils.readFileToString(new File("text/Factor.txt")));
	    }
	    catch(Exception e){
	        e.printStackTrace();
	        Utils.showError("error loading text");
	    }
	    back.setText("Back to Factoring");
	    
	    panel.add(back);
	    panel.add(factorInfoText);
	    
	    
	    
	}
	public static void generateExamplePanel(){
        panel = new JPanel(new GridBagLayout());
	    state=2;
	    
	}
	public static void generateBitPanel(){
        panel = new JPanel(new GridBagLayout());
	    state =3;
	}
}
