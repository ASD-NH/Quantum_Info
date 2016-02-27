import javax.swing.JButton;
import javax.swing.JPanel;

public class QuantumToClassic {
	private static JButton[] buttons;
	private static JPanel panel;
	
	public static JPanel getPanel(){
		return panel;
	}
	public static JButton getButton(int n){
		return buttons[n];
	}
}
