package dades;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FitxerPlansDeEstudis
{
    private File file;

    public FitxerPlansDeEstudis() throws IOException {
        String workingDirectory = Paths.get("." + File.separator + "fitxersDades").toAbsolutePath().normalize().toString();
        file = new File(workingDirectory, "FitxerPlansDeEstudis.txt");
        file.createNewFile();
    }

    public void savePlaEstudis(String plaEstudis) throws IOException {
        FileWriter fw = new FileWriter(file, true);
        fw.write(plaEstudis);
        fw.write("\n");
        fw.close();
    }

    public ArrayList<String> loadPlansDeEstudis() throws IOException {
        ArrayList<String> plansDeEstudis = new ArrayList<>();
        if (!file.exists()) {
            System.out.println("No existeix el fitxer  " + file.getName());
            return plansDeEstudis;
        }
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            plansDeEstudis.add(line);
        }
        br.close();
        return plansDeEstudis;
    }

    public void deleteContent() throws IOException {
        file.delete();
        file.createNewFile();
    }

}
