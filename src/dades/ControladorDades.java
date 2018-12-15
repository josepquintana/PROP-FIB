package dades;

import java.io.IOException;
import java.util.ArrayList;

public class ControladorDades
{
    private FitxerCentreDocent fitxerCentreDocent;
    private FitxerPlansDeEstudis fitxerPlansDeEstudis;
    private FitxerAules fitxerAules;
    private FitxerAssignatures fitxerAssignatures;

    public ControladorDades() throws IOException {
        fitxerCentreDocent      = new FitxerCentreDocent();
        fitxerPlansDeEstudis    = new FitxerPlansDeEstudis();
        fitxerAules             = new FitxerAules();
        fitxerAssignatures      = new FitxerAssignatures();
    }

    public void saveCentreDocent(String centreDocent) throws IOException {
        fitxerCentreDocent.saveCentreDocent(centreDocent);
    }

    public String loadCentreDocent() throws IOException {
        String centreDocent = fitxerCentreDocent.loadCentreDocent();
        return centreDocent;
    }

    public void savePlansDeEstudis(ArrayList<String> plansDeEstudis) throws IOException {
        for (String plaEstudis : plansDeEstudis) {
            fitxerPlansDeEstudis.savePlaEstudis(plaEstudis);
        }
    }

    public ArrayList<String> loadPlansDeEstudis() throws IOException {
        return (fitxerPlansDeEstudis.loadPlansDeEstudis());
    }

    public void saveAules(ArrayList<String> aules) throws IOException {
        for (String aula : aules) {
            fitxerAules.saveAula(aula);
        }
    }

    public ArrayList<String> loadAules() throws IOException {
        return (fitxerAules.loadAules());
    }

    public void saveAssignatures(ArrayList<String> assignatures) throws IOException {
        for (String assignatura : assignatures) {
            fitxerAssignatures.saveAssignatura(assignatura);
        }
    }

    public ArrayList<String> loadAssignatures() throws IOException {
        return (fitxerAssignatures.loadAssignatures());
    }
}
