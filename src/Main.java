import domini.MyException;
import presentacio.ControladorPresentacio;

import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        javax.swing.SwingUtilities.invokeLater (
                new Runnable() {
                    public void run() {
                        ControladorPresentacio ctrlPresentacion = null;
                        try {
                            ctrlPresentacion = new ControladorPresentacio();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        ctrlPresentacion.inicialitzarPresentacio();
                    }
                });
    }
}