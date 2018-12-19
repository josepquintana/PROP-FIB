/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacio;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ErrorDialog {

  public static void throwError(String s) {
    JOptionPane.showMessageDialog(new JFrame(), s, "Error",
        JOptionPane.ERROR_MESSAGE);
  }
}