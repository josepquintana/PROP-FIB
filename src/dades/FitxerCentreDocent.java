package dades;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FitxerCentreDocent
{
    private File file;

    public FitxerCentreDocent() throws IOException {
        String workingDirectory = Paths.get("." + File.separator + "fitxersDades").toAbsolutePath().normalize().toString();
        file = new File(workingDirectory, "FitxerCentreDocent.txt");
        file.createNewFile();
    }

    public void saveCentreDocent(String centreDocent) throws IOException {
        FileWriter fw = new FileWriter(file, false);
        fw.write(centreDocent);
        fw.write("\n");
        fw.close();
    }

    public String loadCentreDocent() throws IOException {
        String centreDocent = new String();
        if (!file.exists()) {
            System.out.println(" > No existeix el fitxer  " + file.getName());
            return centreDocent;
        }
        BufferedReader br = new BufferedReader(new FileReader(file));
        centreDocent = br.readLine();
        br.close();
        return centreDocent;
    }

    public void deleteContent() throws IOException {
        file.delete();
        file.createNewFile();
    }

}