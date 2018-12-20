package presentacio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ImportarFitxers {
    
    public static ArrayList<String> importAssignatures(File file) throws IOException {
        ArrayList<String> assignatures = new ArrayList<>();
        if (!file.exists()) {
            //System.out.println("No existeix el fitxer " + file.getName());
            return assignatures;
        }
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            if(line.startsWith("Assignatura")){
                assignatures.add(line);
            }
        }
        br.close();

        return assignatures;
    }
    
    public static ArrayList<String> importAules(File file) throws IOException {
        ArrayList<String> aules = new ArrayList<>();
        if (!file.exists()) {
            //System.out.println("No existeix el fitxer " + file.getName());
            return aules;
        }
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            if(line.startsWith("Aula")){
                aules.add(line);
            }
        }
        br.close();

        return aules;
    }
    
    public static ArrayList<String> importPlansDeEstudi(File file) throws IOException {
        ArrayList<String> plans = new ArrayList<>();
        if (!file.exists()) {
            //System.out.println("No existeix el fitxer " + file.getName());
            return plans;
        }
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            if(line.startsWith("Pla Estudis")){
                plans.add(line);
            }
        }
        br.close();

        return plans;
    }
    
    public static String importCentreDocent(File file) throws IOException {
        if (!file.exists()) {
            //System.out.println("No existeix el fitxer " + file.getName());
            return null;
        }
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            if(line.startsWith("Centre Docent")){
                 return line;
            }
        }
        br.close();

        return null;
    }
}
