package presentacio;

import domini.ControladorDomini;
import dades.ControladorDades;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladorPresentacio {
  private ControladorDomini ctrlDomini;
  private VistaPresentacio vistaPresentacio;
  private VistaPrincipal vistaPrincipal = null;    // (= null) innecesario


//////////////////////// Constructor y metodos de inicializacion


  public ControladorPresentacio() throws IOException {
    ctrlDomini = new ControladorDomini();
    vistaPresentacio = new VistaPresentacio(this);
    vistaPrincipal = new VistaPrincipal(this);
  }

  public void inicialitzarPresentacio() {
    //ctrlDomini.inicializarControladorDomini();
    vistaPresentacio.ferVisible();
  }


//////////////////////// Metodos de sincronizacion entre vistas


  public void sincronitzacioVistaPresentacio_a_Principal() {
    vistaPresentacio.setVisible(false);
        vistaPresentacio.desactivar();
        vistaPrincipal.setVisible(true);
        vistaPrincipal.ferVisible();
  }

  /*public void sincronizacionVistaSecundaria_a_Principal() {
    // Se hace invisible la vista secundaria (podria anularse)
    vistaSecundaria.hacerInvisible();
    vistaPrincipal.activar();
  }*/


//////////////////////// Llamadas al controlador de dominio


  /*public ArrayList<String> llamadaDominio1 (String selectedItem) {
    return ctrlDomini.llamadaDominio1(selectedItem);
  }

  public ArrayList<String> llamadaDominio2() {
    return ctrlDomini.llamadaDominio2();
  }*/
}
