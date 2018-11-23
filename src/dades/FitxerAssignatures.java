package dades;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FitxerAssignatures
{
    private File file;

    public FitxerAssignatures() throws IOException {

        String workingDirectory = Paths.get("./fitxersDades/").toAbsolutePath().normalize().toString();
        file = new File(workingDirectory, "FitxerAssignatures.txt");
        file.createNewFile();
    }

    public void saveAssignatura(String assig) throws IOException {
        FileWriter fw = new FileWriter(file, true);
        fw.write(assig);
        fw.write("\n");
        fw.close();
    }

    public ArrayList<String> loadAssignatures() throws IOException {
        ArrayList<String> assigs = new ArrayList<>();
        if (!file.exists()) {
            System.out.println("No existeix el fitxer " + file.getName());
            return assigs;
        }
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            assigs.add(line);
        }
        return assigs;
    }

    public void deleteContent() throws IOException {
        file.delete();
        file.createNewFile();
    }

}
