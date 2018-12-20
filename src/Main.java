import presentacio.ControladorPresentacio;

public class Main
{
    public static void main(String[] args)
    {
        javax.swing.SwingUtilities.invokeLater ( () -> {
            ControladorPresentacio ctrlPresentacion;
            ctrlPresentacion = new ControladorPresentacio();
            ctrlPresentacion.inicialitzarPresentacio();
        } );
    }
}