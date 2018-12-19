/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacio;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyDialog {

  public static void throwError(String s) {
    JOptionPane.showMessageDialog(new JFrame(), s, "Error",
        JOptionPane.ERROR_MESSAGE);
  }
  
   public static void throwMessage(String s) {
    JOptionPane.showMessageDialog(new JFrame(), s, "Message",
        JOptionPane.INFORMATION_MESSAGE);
  }
}