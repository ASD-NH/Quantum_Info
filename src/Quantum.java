import java.awt.Dimension;
import javax.swing.*;

public class Quantum {
	private static JFrame mainFrame;
	private static MainMenu menu;
	private static final int MAXCOUNT = 10000;
	public static double timePerOpp; //in nanoseconds per operation
	
	public static void calculateTimePerOpp(){
	    double timeInit = System.nanoTime();
	    for (int i=0;i < MAXCOUNT;i++){
	        if((Math.random())==1){
	            
	        }
	    }
	    double timeFinal = System.nanoTime();
	    System.out.println(timeFinal-timeInit);
	    timePerOpp = (timeFinal-timeInit)/MAXCOUNT;
	}
	public static void showPanel(JPanel panel, JFrame frame){
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	public static void showPanel(JPanel panel){
		mainFrame.getContentPane().removeAll();
		mainFrame.getContentPane().add(panel);
		mainFrame.pack();
		mainFrame.setVisible(true);
		
		
	}
	public static void init(){
		GenInfo gen = new GenInfo();
//		QuantumToClassic QtoC = new QuantumToClassic();
		SpeedCompare speed = new SpeedCompare();
		menu= new MainMenu();
		calculateTimePerOpp();
		
	}
	public static void main(String[] args){
		
		mainFrame = new JFrame("Quauntum Info");
		mainFrame.setPreferredSize(new Dimension(800,450));
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		init();
		
		showPanel(menu.getPanel());

		
	}
	public static JFrame getFrame(){
		
		return mainFrame;
		
	}
	
}
