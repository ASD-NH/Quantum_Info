package utilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import pages.GenInfo;
import pages.MainMenu;
import pages.Quantum;
import pages.QuantumToClassic;
import pages.SpeedCompare;

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
            if(GenInfo.getState() == GenInfo.State.MAIN){
                MainMenu.generatePanel();
                Quantum.showPanel(MainMenu.getPanel());
            }
            else {
                GenInfo.generatePanel();
                Quantum.showPanel(GenInfo.getPanel());
            }

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
        else if (e.getSource()==GenInfo.getButton(7)){
            GenInfo.genLinkPanel();
            Quantum.showPanel(GenInfo.getPanel());
        }
        else if (e.getSource()==GenInfo.getButton(8)){
            Utils.browseWeb("https://xkcd.com");
        }
        else if (e.getSource()==GenInfo.getButton(9)){
            Utils.browseWeb("https://xkcd.com");
        }
        else if (e.getSource()==GenInfo.getButton(10)){
            Utils.browseWeb("https://xkcd.com");
        }
        else if (e.getSource()==GenInfo.getButton(11)){
            Utils.browseWeb("https://xkcd.com");
        }
        else if (e.getSource()==GenInfo.getButton(12)){
            Utils.browseWeb("https://xkcd.com");
        }
        else if (e.getSource()==GenInfo.getButton(13)){
            Utils.browseWeb("https://xkcd.com");
        }
        else if (e.getSource()==GenInfo.getButton(14)){
            Utils.browseWeb("https://xkcd.com");
        }
        //Speed Buttons
        else if (e.getSource()==SpeedCompare.getButton(0)){
            if (SpeedCompare.getState()== SpeedCompare.State.MENU){
                MainMenu.generatePanel();
                Quantum.showPanel(MainMenu.getPanel());
            }
            else if (SpeedCompare.getState() == SpeedCompare.State.BITS ||
                    SpeedCompare.getState() == SpeedCompare.State.FACTOR ||
                    SpeedCompare.getState( )== SpeedCompare.State.EXAMPLE){
                SpeedCompare.generateMainPanel();
                Quantum.showPanel(SpeedCompare.getPanel());
            }
            else if(SpeedCompare.getState()== SpeedCompare.State.FACTORINFO){
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
        else if (e.getSource()==SpeedCompare.getButton(8)){
            SpeedCompare.calcBits();
        }


        //QtoC buttons
        if(e.getSource()==QuantumToClassic.getButton(0)){
            if(QuantumToClassic.getState()==QuantumToClassic.State.INPUT){
                MainMenu.generatePanel();
                Quantum.showPanel(MainMenu.getPanel());
            }
            else if(QuantumToClassic.getState()==QuantumToClassic.State.OUTPUT){
                QuantumToClassic.genInputPanel();
                Quantum.showPanel(QuantumToClassic.getPanel());
            }
            else if(QuantumToClassic.getState()==QuantumToClassic.State.EXPLAIN){
                QuantumToClassic.genOutPanel();
                Quantum.showPanel(QuantumToClassic.getPanel());
            }
            
        }
        else if(e.getSource()==QuantumToClassic.getButton(1)){
            System.exit(0);
        }
        else if(e.getSource() == QuantumToClassic.getButton(2)){
            QuantumToClassic.genOutPanel();
            Quantum.showPanel(QuantumToClassic.getPanel());
          
        }
        else if(e.getSource()==QuantumToClassic.getButton(3)){
            QuantumToClassic.genExplainPanel();
            Quantum.showPanel(QuantumToClassic.getPanel());
        }

    }
}
