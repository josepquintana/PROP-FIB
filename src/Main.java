import presentacio.ControladorPresentacio;

public class Main
{
    public static void main(String[] args)
    {
        javax.swing.SwingUtilities.invokeLater ( () -> {
            ControladorPresentacio ctrlPresentacion = null;
            ctrlPresentacion = new ControladorPresentacio();
            ctrlPresentacion.inicialitzarPresentacio();
        } );
    }
}