package presentacio;

import domini.Assignacio;
import domini.Horari;
import domini.HoraLectiva;

import java.io.*;
import java.nio.file.Paths;

public class WriteHorari
{
    private static PrintWriter writer;

    public static void main(Horari horari, String filename) throws Exception {
        openFile(filename);
        writeFile(horari);
        closeFile();
    }

    public static void openFile(String filename) throws IOException {

        if (!filename.endsWith(".csv")) { filename += ".csv"; }

        String workingDirectory = Paths.get(".\\output").toAbsolutePath().normalize().toString();
        File file = new File(workingDirectory, filename);

        System.out.println("Writing to file: " + file.getAbsolutePath());

        writer = new PrintWriter(file);
    }

    private static void writeFile(Horari horari) throws Exception {

        writer.println(",DILLUNS,DIMARTS,DIMECRES,DIJOUS,DIVENDRES");
        int outputCounter = 0;
        for (int h = 0; h < horari.getHores(); h++) {

            String hourFormat = WriteHorari.getHourFormat(h, horari.getHIni());
            writer.print(hourFormat + ",");

            for (int d = 0; d < horari.getDies(); d++) {
                HoraLectiva hL = horari.getHoraLectiva(d, h);
                for (int i_asg = 0; i_asg < hL.getAssignacions().size(); ++i_asg) {
                    Assignacio asg = hL.getAssignacio(i_asg);
                    String printASG = asg.getAssignacioPrintFormat();
                    writer.print(printASG);
                    if (i_asg == hL.getAssignacions().size() - 1) writer.print("\n");
                }
                if (d == horari.getDies() - 1) writer.print("\n");
                ++outputCounter;
            }
        }

        System.out.println("Written " + outputCounter + " horesLectives to output.\n");
    }

    private static void closeFile() {
        writer.close(); // Close PrintWriter
    }

    private static String getHourFormat(int h, int hIni) {
        String h0s = Integer.toString(h + hIni);
        String h1s = Integer.toString(h + hIni + 1);
        if (h0s.length() < 2) h0s = "0" + h0s;
        if (h1s.length() < 2) h1s = "0" + h1s;
        String str = "  " + h0s + " - " + h1s + "h";
        return str;
    }

}
