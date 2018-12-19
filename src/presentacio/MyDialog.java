/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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