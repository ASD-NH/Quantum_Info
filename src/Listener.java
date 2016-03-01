import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Listener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Main Menu Buttons
		if (e.getSource()==MainMenu.getButton(0)){
			System.exit(0);
		}
	
		else if (e.getSource()==MainMenu.getButton(1)){
			GenInfo.generatePanel();
			Quantum.showPanel(GenInfo.getPanel());
		}
		
		else if (e.getSource()==MainMenu.getButton(2)){
			
		}
		
		else if (e.getSource()==MainMenu.getButton(3)){
			
		}
	
		//Gen Info Buttons
		else if (e.getSource()==GenInfo.getButton(0)){
			MainMenu.generatePanel();
			Quantum.showPanel(MainMenu.getPanel());
		}
		else if (e.getSource()==GenInfo.getButton(1)){
			System.exit(0);
		}
		else if (e.getSource()==GenInfo.getButton(2)){
			GenInfo.showVideo("Test", "https://www.youtube.com/watch?v=zbg9MbQS5xM");
		}
		else if (e.getSource()==GenInfo.getButton(3)){
			System.exit(0);
		}
		else if (e.getSource()==GenInfo.getButton(4)){
			System.exit(0);
		}
		else if (e.getSource()==GenInfo.getButton(5)){
			System.exit(0);
		}
		else if (e.getSource()==GenInfo.getButton(6)){
			System.exit(0);
		}
		//Speed Buttons
		
		
		//QtoC buttons

	}
}
