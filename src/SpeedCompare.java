import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class SpeedCompare {
	private static JButton[] buttons;
	private static JPanel panel;
	private static JTextArea explain;
	
	public SpeedCompare(){
	    generatePanel();
	}
	
	public static JPanel getPanel(){
		return panel;
	}
	public static JButton getButton(int n){
		return buttons[n];
	}
	public static void generatePanel(){
	    explain = new Text();
 
        try{
            
        }
        catch(Exception e){
            e.printStackTrace();
            
        }

	    
	    
	}
}
