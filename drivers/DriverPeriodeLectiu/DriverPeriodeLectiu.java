package domini;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class DriverPeriodeLectiu {
    
    private static void mostrar_menu(){
        System.out.println("\t Tria una opció (número) seguit dels paràmetres necessaris per comprovar el mètode:");
                System.out.println("\t 1) PeriodeLectiu()");
                System.out.println("\t 2) PeriodeLectiu(Date dataIni, Date dataFi)");
                System.out.println("\t 3) PeriodeLectiu(PeriodeLectiu pL)");
                System.out.println("\t 4) void setDataIni(Date dataIni)");
                System.out.println("\t 5) void setDataFi(Date dataFi)");
                System.out.println("\t 6) Date getDataIni()");
                System.out.println("\t 7) Date getDataFi()");
                
                System.out.println("\t 0) Sortir");
    }
            
    public static void main(String[] args) {
        String nomClasse = "Periode Lectiu";
        System.out.println("Driver " + nomClasse + ":");

        PeriodeLectiu p = new PeriodeLectiu();

        try {
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            boolean sortir = false;
            while (!sortir) {
                mostrar_menu();
                String linea;
                String paraules[];
                String opcio;
                SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
                linea = br.readLine();
                paraules = linea.split(" ");
                opcio = paraules[0];
                try {
                    System.out.println("Opció " + opcio + " seleccionada.");
                    switch (opcio) {
                        case "1":
                            p = new PeriodeLectiu();
                            break;
                        case "2":
                            Date dataini = new java.sql.Date(format.parse(paraules[1]).getDate());
                            Date datafi = new java.sql.Date(format.parse(paraules[2]).getDate());
                            p = new PeriodeLectiu(dataini, datafi);
                            break;
                        case "3":
                            Date dataini2 = new java.sql.Date(format.parse(paraules[1]).getDate());
                            Date datafi2 = new java.sql.Date(format.parse(paraules[2]).getDate());
                            PeriodeLectiu j2 = new PeriodeLectiu(dataini2, datafi2);
                            p = new PeriodeLectiu(j2);
                            break;
                        case "4":
                            Date dataini3 = new java.sql.Date(format.parse(paraules[1]).getDate());
                            p.setDataIni(dataini3);
                        case "5":
                            Date datafi3 = new java.sql.Date(format.parse(paraules[1]).getDate());
                            p.setDataFi(datafi3);
                            break;
                        case "6":           
                            System.out.print("L'data d'inici de la jornada és: " + p.getDataIni());
                            break;
                        case "7":
                            System.out.print("L'data del final de la jornada és: " + p.getDataFi());
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
