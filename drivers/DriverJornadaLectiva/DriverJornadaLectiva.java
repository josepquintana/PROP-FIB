import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.sql.Time;
import java.text.SimpleDateFormat;

public class DriverJornadaLectiva {
    
    private static void mostrar_menu(){
        System.out.println("\t Tria una opció (número) seguit dels paràmetres necessaris per comprovar el mètode:");
                System.out.println("\t 1) JornadaLectiva()");
                System.out.println("\t 2) JornadaLectiva(Time horaIni, Time horaFi)");
                System.out.println("\t 3) JornadaLectiva(JornadaLectiva jL)");
                System.out.println("\t 4) void setHoraIni(Time horaIni)");
                System.out.println("\t 5) void setHoraFi(Time horaFi)");
                System.out.println("\t 6) Time getHoraIni()");
                System.out.println("\t 7) Time getHoraFi()");
                
                System.out.println("\t 0) Sortir");
    }
            
    public static void main(String[] args) {
        String nomClasse = "Jornada Lectiva";
        System.out.println("Driver " + nomClasse + ":");

        JornadaLectiva j = new JornadaLectiva();

        try {
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            boolean sortir = false;
            while (!sortir) {
                mostrar_menu();
                String linea;
                String paraules[];
                String opcio;
                SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
                linea = br.readLine();
                paraules = linea.split(" ");
                opcio = paraules[0];
                try {
                    System.out.println("Opció " + opcio + " seleccionada.");
                    switch (opcio) {
                        case "1":
                            j = new JornadaLectiva();
                            break;
                        case "2":
                            Time horaini = new java.sql.Time(format.parse(paraules[1]).getTime());
                            Time horafi = new java.sql.Time(format.parse(paraules[2]).getTime());
                            j = new JornadaLectiva(horaini, horafi);
                            break;
                        case "3":
                            Time horaini2 = new java.sql.Time(format.parse(paraules[1]).getTime());
                            Time horafi2 = new java.sql.Time(format.parse(paraules[2]).getTime());
                            JornadaLectiva j2 = new JornadaLectiva(horaini2, horafi2);
                            j = new JornadaLectiva(j2);
                            break;
                        case "4":
                            Time horaini3 = new java.sql.Time(format.parse(paraules[1]).getTime());
                            j.setHoraIni(horaini3);
                        case "5":
                            Time horafi3 = new java.sql.Time(format.parse(paraules[1]).getTime());
                            j.setHoraFi(horafi3);
                            break;
                        case "6":           
                            System.out.print("L'hora d'inici de la jornada és: " + j.getHoraIni());
                            break;
                        case "7":
                            System.out.print("L'hora del final de la jornada és: " + j.getHoraFi());
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
