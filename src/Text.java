import java.awt.Font;

import javax.swing.JTextArea;

public class Text extends JTextArea{
    
    public Text(){
        super();
        this.setSize(500, 500);
        this.setLineWrap(true);
        this.setWrapStyleWord(true);
        this.setFont(new Font("SERIF",Font.PLAIN,12));
        this.setEditable(false);
        this.setBackground(Quantum.getFrame().getBackground());
    }
    public Text(boolean bool){
        super();
        this.setSize(500, 500);
        this.setLineWrap(true);
        this.setWrapStyleWord(true);
        this.setFont(new Font("SERIF",Font.PLAIN,12));
        this.setEditable(bool);
        this.setBackground(Quantum.getFrame().getBackground());
    }


}
