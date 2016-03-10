import java.awt.Dimension;
import javax.swing.*;

public class Quantum {
	private static JFrame mainFrame;
	private static MainMenu menu;
	
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
//		SpeedCompare speed = new SpeedCompare();
		menu= new MainMenu();
		
	}
	public static void main(String[] args){
		
		mainFrame = new JFrame("mainFrame");
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
