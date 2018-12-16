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
        fitxerCentreDocent.deleteContent();
        fitxerCentreDocent.saveCentreDocent(centreDocent);
    }

    public void savePlansDeEstudis(ArrayList<String> plansDeEstudis) throws IOException {
        fitxerPlansDeEstudis.deleteContent();
        for (String plaEstudis : plansDeEstudis) {
            fitxerPlansDeEstudis.savePlaEstudis(plaEstudis);
        }
    }

    public void saveAules(ArrayList<String> aules) throws IOException, InterruptedException {
        fitxerAules.deleteContent();
        for (String aula : aules) {
            fitxerAules.saveAula(aula);
        }
    }

    public void saveAssignatures(ArrayList<String> assignatures) throws IOException {
        fitxerAssignatures.deleteContent();
        for (String assignatura : assignatures) {
            fitxerAssignatures.saveAssignatura(assignatura);
        }
    }

    public String loadCentreDocent() throws IOException {
        return (fitxerCentreDocent.loadCentreDocent());
    }

    public ArrayList<String> loadPlansDeEstudis() throws IOException {
        return (fitxerPlansDeEstudis.loadPlansDeEstudis());
    }

    public ArrayList<String> loadAules() throws IOException {
        return (fitxerAules.loadAules());
    }

    public ArrayList<String> loadAssignatures() throws IOException {
        return (fitxerAssignatures.loadAssignatures());
    }

}
