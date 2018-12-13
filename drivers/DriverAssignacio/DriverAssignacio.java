package domini;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DriverAssignacio {
    
    private static void mostrar_menu(){
        System.out.println("\t Grup necessita els seguents paràmetres per crear-se: String codi, int num, int capacitat, int numSubGrups, int hores");
        System.out.println("\t Aula necessita els seguents paràmetres per crear-se: String codi, int capacitat, boolean tipus");
        System.out.println("\t Tria una opció (número) seguit dels paràmetres necessaris per comprovar el mètode:");
                System.out.println("\t 1) Assignacio()");
                System.out.println("\t 2) Assignacio(Grup grup, String aula)");
                System.out.println("\t 3) Assignacio(Grup grup, Aula aula)");
                System.out.println("\t 4) Assignacio(Assignacio asg)");
                System.out.println("\t 5) boolean equals(Assignacio asg)");
                System.out.println("\t 6) void setGrup(Grup grup)");
                System.out.println("\t 7) void setAula(String codi)");
                System.out.println("\t 8) Grup getGrupAssignat()");
                System.out.println("\t 9) String getCodiAulaAssignada()");
                System.out.println("\t 10) String getAssignacioPrintFormat()");
                
                System.out.println("\t 0) Sortir");
    }
            
    public static void main(String[] args) {
        String nomClasse = "Assignacio";
        System.out.println("Driver " + nomClasse + ":");

        Assignacio a = new Assignacio();

        try {
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            boolean sortir = false;
            while (!sortir) {
                mostrar_menu();
                String linea;
                String paraules[];
                String opcio;

                linea = br.readLine();
                paraules = linea.split(" ");
                opcio = paraules[0];
                try {
                    System.out.println("Opció " + opcio + " seleccionada.");
                    switch (opcio) {
                        case "1":
                            a = new Assignacio();
                            break;
                        case "2":
                            Grup g = new Grup(paraules[1], Integer.parseInt(paraules[2]), Integer.parseInt(paraules[3]), Integer.parseInt(paraules[4]), Integer.parseInt(paraules[5]));
                            a = new Assignacio(g, paraules[6]);
                            break;
                        case "3":
                            Grup g2 = new Grup(paraules[1], Integer.parseInt(paraules[2]), Integer.parseInt(paraules[3]), Integer.parseInt(paraules[4]), Integer.parseInt(paraules[5]));
                            Aula au = new Aula(paraules[6], Integer.parseInt(paraules[7]), Boolean.parseBoolean(paraules[8]));
                            a = new Assignacio(g2, au);
                            break;
                        case "4":
                            Grup g3 = new Grup(paraules[1], Integer.parseInt(paraules[2]), Integer.parseInt(paraules[3]), Integer.parseInt(paraules[4]), Integer.parseInt(paraules[5]));
                            Aula au2 = new Aula(paraules[6], Integer.parseInt(paraules[7]), Boolean.parseBoolean(paraules[8]));
                            Assignacio a2 = new Assignacio(g3, au2);
                            a = new Assignacio(a2);
                        case "5":
                            Grup g4 = new Grup(paraules[1], Integer.parseInt(paraules[2]), Integer.parseInt(paraules[3]), Integer.parseInt(paraules[4]), Integer.parseInt(paraules[5]));
                            Aula au3 = new Aula(paraules[6], Integer.parseInt(paraules[7]), Boolean.parseBoolean(paraules[8]));
                            Assignacio a3 = new Assignacio(g4, au3);
                            System.out.print("Les assignacions són iguals: " + a.equals(a3));
                            break;
                        case "6":
                            Grup g5 = new Grup(paraules[1], Integer.parseInt(paraules[2]), Integer.parseInt(paraules[3]), Integer.parseInt(paraules[4]), Integer.parseInt(paraules[5]));
                            a.setGrup(g5);
                            break;
                        case "7":
                            String au4 = paraules[1];
                            a.setAula(au4);
                            break;
                        case "8":
                            System.out.print("El grup assignat és: " + a.getGrupAssignat().getNumGrup());
                            break;
                        case "9":
                            System.out.print("L'aula assignada és: " + a.getCodiAulaAssignada());
                            break;
                        case "10":
                            System.out.print("L'assignació en print format és: " + a.getAssignacioPrintFormat());
                            break;    
                        case "0":
                            sortir = true;
                            break;
                        default:
                            System.out.println("La opció triada no existeix");
                            break;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.println("Final del driver");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
