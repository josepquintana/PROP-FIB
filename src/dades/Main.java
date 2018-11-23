package dades;

import java.io.IOException;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) throws IOException {
        String assig = "Assignatura, EngInf EEES, PROP, Projectes de Programació, 6, 5, 150, 3, 3, false, EDA, IES, IDI";
        FitxerAssignatures fa = new FitxerAssignatures();
        fa.saveAssignatura(assig);
        String assig2 = "holahola";
        fa.saveAssignatura(assig2);
        fa.saveAssignatura(assig);
        fa.saveAssignatura(assig2);
        fa.saveAssignatura(assig);
        fa.saveAssignatura("ya esta");

        ArrayList<String> assigs = new ArrayList<>();
        assigs = fa.loadAssignatures();

        for (int i = 0; i < assigs.size(); i++) {
            System.out.println(assigs.get(i));
        }

    }
}
