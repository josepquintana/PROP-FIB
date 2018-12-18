package dades;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FitxerAssignatures
{
    private static File file;

    public FitxerAssignatures() throws IOException {
        String workingDirectory = Paths.get("." + File.separator + "fitxersDades").toAbsolutePath().normalize().toString();
        file = new File(workingDirectory, "FitxerAssignatures.txt");
        file.createNewFile();
    }

    public void saveAssignatura(String assignatura) throws IOException {
        FileWriter fw = new FileWriter(file, true);
        fw.write(assignatura);
        fw.write("\n");
        fw.close();
    }

    public ArrayList<String> loadAssignatures() throws IOException {
        ArrayList<String> assignatures = new ArrayList<>();
        if (!file.exists()) {
            System.out.println("No existeix el fitxer " + file.getName());
            return assignatures;
        }
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            assignatures.add(line);
        }
        br.close();

        return assignatures;
    }

    public void deleteContent() throws IOException {
        file.delete();
        file.createNewFile();
    }

}
