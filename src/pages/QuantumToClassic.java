package pages;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import utilities.Gate;
import utilities.Listener;
import utilities.Text;

import java.awt.GridLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
public class QuantumToClassic {
    private static JButton back;
    private static JButton exit;
    private static JButton calculate;
    private static JButton explain;

    private static JLabel calcLabel;
    private static JLabel inLabel;
    private static JLabel outLabel;

    private static Text instructions;
    private static Text inText;
    private static Text explainText;

    private static JButton[] buttons;
    private static JPanel panel;
    
    private static State state;
    ArrayList<Gate> gates; 

    public enum State{
        INPUT,
        OUTPUT,
        EXPLAIN
    }       
    
    public QuantumToClassic(){
        gates = new ArrayList<Gate>();
        genInputPanel();
        buttons = new JButton[4];
        buttons[0] = (back = new JButton("Back"));
        buttons[1] = (exit= new JButton("Exit"));
        buttons[2] = (calculate = new JButton("Convert"));
        buttons[3] = (explain = new JButton("More about how this works"));
        
        for(JButton b:buttons){
            b.addActionListener(new Listener());
        }
        
    }

    public static JPanel getPanel(){
        return panel;
    }
    public static JButton getButton(int n){
        return buttons[n];
    }
    public static State getState(){
        return state;
    }
    public static void genInputPanel(){
        state = State.INPUT;
        panel = new JPanel(new GridLayout(0,2,10,10));
        inLabel = new JLabel("Input a a boolean logic gate sequence");
        instructions = new Text();
        inText = new Text(true);
        
        try{
            instructions.setText(FileUtils.readFileToString(new File("text/GateInstructions.txt")));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        panel.add(instructions);
        panel.add(inLabel);
        panel.add(calculate);
        panel.add(inText);
        
    }
    public static void genOutPanel(){
        state = State.OUTPUT;
        panel = new JPanel(new GridLayout(0,2,10,10));
        panel.add(back);
        panel.add(exit);
        calculate(inText.getText());

    }
    public static void genExplainPanel(){
        state = State.EXPLAIN;

    }
    public static void calculate(String str){
        parseBooleanGates(str);
        convert();
        drawOutput();
    }
    private static void convert(){

    }
    public static ArrayList<Gate> parseBooleanGates(String input){
        String[] stringGates = input.split(",");
        System.out.println(Arrays.toString(stringGates));       

        ArrayList<Gate> gates = new ArrayList<Gate>();
        for(int i = 0; i < stringGates.length;i++){
            int charCount = 0;
            int inputCount =0;

            for (char c : stringGates[i].toCharArray()) {
                if (c == 'A' || c == 'B' || c == 'C' || c == 'D') {
                    charCount++;
                }
            }

            if(stringGates[i].contains("||")){
                inputCount = StringUtils.countMatches(stringGates[i],"||");
                gates.add(new Gate(inputCount+1,"||"));
            }
            else if (stringGates[i].contains("&&")){
                inputCount = StringUtils.countMatches(stringGates[i],"&&");
                gates.add(new Gate(inputCount+1,"&&"));
            }
            else if(stringGates[i].contains("!&&")){
                inputCount = StringUtils.countMatches(stringGates[i],"!&&");
                gates.add(new Gate(inputCount+1,"!&&"));
            }
            else if(stringGates[i].contains("!||")){
                inputCount = StringUtils.countMatches(stringGates[i],"!||");
                gates.add(new Gate(inputCount+1,"!||"));
            }
            else{
                gates.add(new Gate("INVALID"));
            }

            String temp = stringGates[i];
            String[] splitTemp = temp.split(" ");
            System.out.println(splitTemp.length);
            System.out.println(charCount);
            System.out.println(Arrays.toString(splitTemp));
            String[] splitChar = new String[charCount];
            int splitCharCount =0;
            
            for(int k=0;k < splitTemp.length;k++){

                if(!(splitTemp[k].contains("&&") ||
                        splitTemp[k].contains("||") ||
                        splitTemp[k].equals(",") ||
                        splitTemp[k].isEmpty())){
                    
                    splitChar[splitCharCount] = splitTemp[k];
                    splitCharCount++;
                }
            }
            for(int j =0;j < charCount;j++){

                if(splitChar[j].contains("!")){
                    gates.get(i).addInput(-1);
                }
                else {
                    gates.get(i).addInput(0);
                }
            }
        }

        for(int i =0; i < gates.size();i ++){
            if(gates.get(i).getCurrentInputSize() < gates.get(i).getTotalInputSize()){

                String[] split = stringGates[i].split(gates.get(i).getTypeSymbol());

                if(split[0].equals("") || split[0].equals(" ")){
                    gates.get(i).addInput(gates.get(i-1).getID());
                }

                if (split[split.length-1].equals("") || split[split.length-1].equals(" ")){
                    gates.get(i).addInput(gates.get(i+1).getID());
                }
            }
        }
        for(int i =0;i < gates.size();i++){
            System.out.print(gates.get(i).toString()+", ");
        }
        return gates;
    }
    private static void drawOutput(){

    }

}
