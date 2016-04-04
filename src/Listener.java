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
		    SpeedCompare.generateMainPanel();
		    Quantum.showPanel(SpeedCompare.getPanel());
			
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
			GenInfo.showVideo("Test", "video/vid1.mp4");
		}
		else if (e.getSource()==GenInfo.getButton(3)){
			System.exit(0);
		}
		else if (e.getSource()==GenInfo.getButton(4)){
			System.exit(0);
		}
		else if (e.getSource()==GenInfo.getButton(5)){
			Utils.browseWeb("https://docs.oracle.com/javase/tutorial/uiswing/misc/desktop.html");
		}
		else if (e.getSource()==GenInfo.getButton(6)){
			Utils.browseWeb("https://xkcd.com");
		}
		//Speed Buttons
		else if (e.getSource()==SpeedCompare.getButton(0)){
		    if (SpeedCompare.getState()==0){
		        MainMenu.generatePanel();
		        Quantum.showPanel(MainMenu.getPanel());
		    }
		    else if (SpeedCompare.getState()==1){
		        SpeedCompare.generateMainPanel();
		        Quantum.showPanel(SpeedCompare.getPanel());
		    }
		    else if (SpeedCompare.getState()==2){
		        
		    }
            else if (SpeedCompare.getState()==3){
                
            }
            else if (SpeedCompare.getState()==4){
               SpeedCompare.generateFactorPanel();
               Quantum.showPanel(SpeedCompare.getPanel());
            }
            else {
                Utils.showError("Wrong state error SpeedCompare");
            }
		    
		}
        else if (e.getSource()==SpeedCompare.getButton(1)){
            System.exit(0);
        }
        else if (e.getSource()==SpeedCompare.getButton(2)){
            SpeedCompare.generateBitPanel();
            Quantum.showPanel(SpeedCompare.getPanel());
            
        }
        else if (e.getSource()==SpeedCompare.getButton(3)){
            SpeedCompare.generateFactorPanel();
            Quantum.showPanel(SpeedCompare.getPanel());
        }
        else if (e.getSource()==SpeedCompare.getButton(4)){
            SpeedCompare.factor();
        }
        else if (e.getSource()==SpeedCompare.getButton(5)){
            SpeedCompare.generateExamplePanel();
            Quantum.showPanel(SpeedCompare.getPanel());
        }
        else if (e.getSource()==SpeedCompare.getButton(6)){
        }
        else if (e.getSource()==SpeedCompare.getButton(7)){
            SpeedCompare.geneateFactorInfo();
            Quantum.showPanel(SpeedCompare.getPanel());
        }

		
		//QtoC buttons

	}
}
