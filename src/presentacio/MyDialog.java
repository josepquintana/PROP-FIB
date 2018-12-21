package presentacio;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyDialog {

    public static void throwError(String message) {
        JOptionPane.showMessageDialog(new JFrame(), message, "Error",
        JOptionPane.ERROR_MESSAGE);
    }
  
    public static void throwMessage(String message) {
        JOptionPane.showMessageDialog(new JFrame(), message, "Message",
        JOptionPane.INFORMATION_MESSAGE);
    }

}