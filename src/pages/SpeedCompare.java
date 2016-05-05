package pages;
import java.awt.Font;
import java.io.File;
import javax.swing.*;

import java.lang.*;
import java.math.*;
import java.text.*;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

import utilities.Listener;
import utilities.Pair;
import utilities.Text;
import utilities.Utils;

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
    private static JButton calcBits;

    private static JLabel inputQLabel;
    private static JLabel inputCLabel;
    private static JLabel factorLabel;
    private static JLabel exampleLabel;
    private static JLabel problemLabel;
    private static JLabel outFactorLabelQ;
    private static JLabel outFactorLabelC;
    private static JLabel bitResultsLabel;

    private static Text inputQ;
    private static Text inputC;
    private static Text inputFactor;
    private static Text outFactorQ;
    private static Text outFactorC;
    private static Text factorInfoText;
    private static Text bitExplain;
    private static Text bitResults;

    private static JComboBox exampleSelect;
    private static JComboBox problemSelect;
    private static State state;

    private static ArrayList<Pair> bitList;

    public enum State{
        FACTOR,
        FACTORINFO,
        MENU,
        BITS,
        EXAMPLE
    }
    public SpeedCompare(){
        panel = new JPanel(new GridBagLayout());
        buttons = new JButton[9];
        buttons[0]=(back= new JButton("Back"));
        buttons[1]=(exit= new JButton("Exit"));
        buttons[2]=(bits= new JButton("Bit comparison"));
        buttons[3]=(factorPage= new JButton("Factoring Comparison"));
        buttons[4]=(factor= new JButton("Factor"));
        buttons[5]=(problems= new JButton("Problem speed Examples"));
        buttons[6]=(examples= new JButton("Compared to Current Computers"));
        buttons[7] =(factorInfo = new JButton("More info on how this is calculated"));
        buttons[8] =(calcBits = new JButton("Calculate"));

        for (int i =0;i<buttons.length;i++){
            buttons[i].addActionListener(new Listener());
        }
        generateMainPanel();
        try{
            bitList = new ArrayList<Pair>();
            String str = FileUtils.readFileToString(new File("text/BitList.txt"));
            String[] split = str.split(",");
            for(int i =0;i < split.length;i+=2){
                bitList.add(new Pair (split[i],split[i+1]));
            }
            System.out.println(bitList);

        }
        catch(Exception e){
            e.printStackTrace();
            Utils.showError("Error loading bit comparision text");
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

    public static void generateMainPanel(){
        panel = new JPanel(new GridBagLayout());
        back.setText("Back to Main Menu");

        state=State.MENU;
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
        double val = parseInput(input);
        outFactorQ.setText(timeToFactorQ(val));
        outFactorC.setText(timeToFactorC(val));
        inputFactor.setText("");
    }
    private static double parseInput(String input){
        double val=-1;
        try{
            val = Double.parseDouble(input);
        }
        catch(Exception NumberFormatException){
            Utils.showError("Please enter just a number");
        }
        return val;
    }
    private static String timeToFactorQ(double n){
        if(n!=-1){
            double shors = Math.pow(Math.log(n),2) * Math.log(Math.log(n))* Math.log(Math.log(Math.log(n)));
            double time = shors * Quantum.timePerOpp;
            double time_s = time * (1e-9);
            //            return ("The time to factor is approxximatly " + formatNum(time,5) + " nanoseconds " + formatNum(time_s,5)+ " or seconds");
            // return String.format("The time to factor is approxximatly %.4f  nanoseconds or %.4f seconds",time,time_s);
            return String.format("The time to factor is approxximatly %.4g nanoseconds or %.4g seconds",time,time_s);


        }
        else {
            return "invalid number";
        }


    }
    private static String timeToFactorC(double n){

        if (n!=-1){
            double opps = Math.sqrt(n);
            double time = opps * Quantum.timePerOpp;
            double time_s = time * (1e-9);
            return String.format("The time to factor is approxximatly %.4g nanoseconds or %.4g seconds",time,time_s);


        }
        else {
            return "invalid number";
        }
    }
    private static String formatNum(double num, int size){
        String temp = String.valueOf(num);
        temp = temp.substring(0,temp.indexOf('.'));

        if(temp.length()<size){
            return String.format("%.4f", num);
        }
        else {
            DecimalFormat formatter = new DecimalFormat("0.#####E0");
            return formatter.format(num);
        }


    }
    public static void generateFactorPanel(){
        panel = new JPanel(new GridLayout(0,2,10,10));
        state = State.FACTOR;
        factorLabel = new JLabel("Enter a number to be factored");
        outFactorLabelQ = new JLabel("The time on a quantum computer");
        outFactorLabelC = new JLabel("The time on a classical computer");	
        outFactorQ = new Text();
        outFactorC = new Text();
        inputFactor = new Text(true);
        back.setText("Back to other speed comparisons");


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
        state = State.FACTORINFO;
        factorInfoText = new Text();
        JScrollPane scroll = new JScrollPane(factorInfoText);
        scroll.getVerticalScrollBar().setUnitIncrement(16);

        try{
            factorInfoText.append(FileUtils.readFileToString(new File("text/Factor.txt")));
        }
        catch(Exception e){
            e.printStackTrace();
            Utils.showError("error loading text");
        }
        back.setText("Back to Factoring");

        panel.add(back);
        panel.add(scroll);



    }
    public static void generateExamplePanel(){
        panel = new JPanel(new GridBagLayout());
        state = State.EXAMPLE;

    }
    private static double log2(double val){
        return Math.log(val)/Math.log(2);
    }
    public static void calcBits(){
        double val;
        String outputText="";
        if(inputQ.getText().equals("") && !inputC.getText().equals("")){
            val = parseInput(inputC.getText());
            outputText += val + " classical bits can be represented as only "+ log2(val) + "  quantum bits";

        }
        else if (!inputQ.getText().equals("") && inputC.getText().equals("")){

            val = parseInput(inputQ.getText());
            outputText += val + " quantum bits  can be represented by " + Math.pow(2, val) +" classsical bits. That is more than ";

            for(int i = bitList.size()-1;i >=0 ;i--){
                if(Math.pow(2, val) > Double.parseDouble((String)bitList.get(i).getFirst())){
                    outputText += bitList.get(i).getSecond();
                    break;
                }
            }
        }
        else {
            Utils.showError("Please enter in one box");
            inputQ.setText("");
            inputC.setText("");
        }
        bitResults.setText(outputText);
        inputQ.setText("");
        inputC.setText("");
        
    }
    public static void generateBitPanel(){
        panel = new JPanel(new GridLayout(0,2,10,10));
        state = State.BITS;
        back.setText("Back to more speed comparisions");
        bitExplain = new Text();
        inputQ = new Text(true);
        inputC = new Text(true);
        bitResults = new Text();
        inputQLabel = new JLabel("number of Quantum Bits");
        inputCLabel = new JLabel ("number of classical bits");
        bitResultsLabel = new JLabel("Results of conversion");
        try{
            bitExplain.append(FileUtils.readFileToString(new File("text/BitExplain.txt")));
        }
        catch(Exception e){
            e.printStackTrace();
            Utils.showError("Error loading text");
        }
        panel.add(back);
        panel.add(exit);
        panel.add(bitExplain);
        panel.add(calcBits);
        panel.add(inputQLabel);
        panel.add(inputCLabel);
        panel.add(inputQ);
        panel.add(inputC);
        panel.add(bitResultsLabel);
        panel.add(bitResults);
       
        

    }
}
