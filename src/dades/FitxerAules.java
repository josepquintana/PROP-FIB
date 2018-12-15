package dades;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FitxerAules
{
    private File file;

    public FitxerAules() throws IOException {

        String workingDirectory = Paths.get("./fitxersDades/").toAbsolutePath().normalize().toString();
        file = new File(workingDirectory, "FitxerAules.txt");
        file.createNewFile();
    }

    public void saveAula(String aula) throws IOException {
        FileWriter fw = new FileWriter(file, true);
        fw.write(aula);
        fw.write("\n");
        fw.close();
    }

    public ArrayList<String> loadAules() throws IOException {
        ArrayList<String> aules = new ArrayList<>();
        if (!file.exists()) {
            System.out.println("No existeix el fitxer " + file.getName() + ".");
            return aules;
        }
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            aules.add(line);
        }
        return aules;
    }

    public void deleteContent() throws IOException {
        file.delete();
        file.createNewFile();
    }

}

