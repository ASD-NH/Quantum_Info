package utilities;
import java.awt.Desktop;
import java.net.URI;

import javax.swing.JOptionPane;

import pages.Quantum;

public class Utils {
    public static void showError(String message){
        JOptionPane.showMessageDialog(Quantum.getFrame(),message);
    }
    public static void browseWeb(String url){
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                URI uri = new URI(url);
                desktop.browse(uri);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(Quantum.getFrame(), "Browser error, could link to browser");
                e.printStackTrace();
            }
        }

    }
}
