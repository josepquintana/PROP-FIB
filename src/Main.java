import domini.MyException;
import presentacio.ControladorPresentacio;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        javax.swing.SwingUtilities.invokeLater (
                new Runnable() {
                    public void run() {
                        ControladorPresentacio ctrlPresentacion = new ControladorPresentacio();
                        ctrlPresentacion.inicialitzarPresentacio();
                    }
                });
    }
}