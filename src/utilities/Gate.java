
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class Gate {
    public enum Type{
        AND,
        OR,
        NOR,
        NAND,
        INVALID
    }
    private Type gateType;
    private int numInputs;
    private BufferedImage img;
    private static int gateCount=0;
    private int gateID;
    private ArrayList<Integer> inputList;
    
    public Gate(String type){
        this(2,type);
    }
    public Gate(int inputs,String type){
        
        inputList = new ArrayList<Integer>();
        
        if(type.equals("||") && inputs >1){
            gateType = Type.OR;
            numInputs = inputs;
            try{
                img = ImageIO.read(new File("images/or.jpg"));
            }
            catch(Exception NullPointerException){
                Utils.showError("Error Loading gate images");
                NullPointerException.printStackTrace();
            }
        }
        
        else if(type.equals("&&") && inputs >1){
            gateType = Type.AND;
            numInputs = inputs;
            try{
                img = ImageIO.read(new File("images/and.jpg"));
            }
            catch(Exception NullPointerException){
                Utils.showError("Error Loading gate images");
                NullPointerException.printStackTrace();
            }
        }
        else if(type.equals("!||") && inputs > 1){
            gateType = Type.NOR;
            numInputs = inputs;
            try{
                img = ImageIO.read(new File("images/nor.jpg"));
            }
            catch(Exception NullPointerException){
                Utils.showError("Error Loading gate images");
                NullPointerException.printStackTrace();
            }
        }
        else if(type.equals("!&&") && inputs > 1){
            gateType = Type.NAND;
            numInputs = inputs;
            try{
                img = ImageIO.read(new File("images/nand.jpg"));
            }
            catch(Exception NullPointerException){
                Utils.showError("Error Loading gate images");
                NullPointerException.printStackTrace();
            }
        }
        else {
            gateType = Type.INVALID;
        }
        gateCount++;
        gateID = gateCount;
    }
    public void addInput(int input){
        inputList.add(new Integer(input));
    }
    public String toString(){
        String list="";
        for(int i : inputList){
            list += String.valueOf(i);
        }
        return gateType +" " + numInputs + " ID: " + gateID + " Inputs " + list;
    }
    public Type getType(){
        return gateType;
    }
    public BufferedImage getImage(){
        return img;
    }
    public int getID(){
        return gateID;
    }
    public int getCurrentInputSize(){
        return inputList.size();
    }
    public int getTotalInputSize(){
        return numInputs;
    }
    public String getTypeSymbol(){
        switch(gateType){
            case AND : return "&&";
            case OR : return "||";
            case NOR : return "!||";
            case NAND : return "!&&";
            default : return "INVALID";
        }        
    }    
}
