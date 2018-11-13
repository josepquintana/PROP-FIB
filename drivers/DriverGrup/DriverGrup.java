import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DriverGrup {
    public static void main(String[] args) {
        String nomClasse = "Grup";
        System.out.println("Driver " + nomClasse + ":");

        Grup G = new Grup();

        try {
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            boolean sortir = false;
            while (!sortir) {
                System.out.println("Tria una opció (número) seguit dels paràmetres necessaris per comprovar el mètode:");
                System.out.println("\t 1) Grup()");
                System.out.println("\t 2) Grup(String codi, int num, int capacitat)");
                System.out.println("\t 3) Grup(Grup g) (hauràs d'introduir els paràmetres necessaris per cridar la constructora de la opció 2)");
                System.out.println("\t 4) boolean equals(Grup g) (hauràs d'introduir els paràmetres necessaris per cridar la constructora de la opció 2)");
                System.out.println("\t 5) String getCodiAssig()");
                System.out.println("\t 6) int getCapacitat()");
                System.out.println("\t 7) int getNumGrup()");
                System.out.println("\t 8) void setCodiAssig(String s)");
                System.out.println("\t 9) void setNumGrup(int n)");
                System.out.println("\t 10) void setCapacitat(int n)");
                System.out.println("\t 0) Sortir");

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
                            G = new Grup();
                            break;
                        case "2":
                            String codi = (paraules[1]);
                            Integer num = Integer.parseInt(paraules[2]);
                            Integer capacitat = Integer.parseInt(paraules[3]);
                            G = new Grup(codi, num, capacitat);
                            break;
                        case "3":
                            Grup A = new Grup(paraules[1], Integer.parseInt(paraules[2]), Integer.parseInt(paraules[3]));
                            G = new Grup(A);
                            break;
                        case "4":
                            Grup B = new Grup(paraules[1], Integer.parseInt(paraules[2]), Integer.parseInt(paraules[3]));
                            System.out.println("Comparació del grup amb codi assig: " + G.getCodiAssig() + " i número de grup: " + G.getNumGrup() + " amb el grup amb codi assig: " + B.getCodiAssig() + " i número de grup: " + B.getNumGrup() + ": " + G.equals(B));
                            break;
                        case "5":
                            System.out.println("Codi de l'assignatura del grup actual: " + G.getCodiAssig() + ".");
                            break;
                        case "6":
                            System.out.println("Capacitat del grup actual: " + G.getCapacitat() + ".");
                            break;
                        case "7":
                            System.out.println("Número del grup actual: " + G.getNumGrup() + ".");
                            break;
                        case "8":
                            G.setCodiAssig(paraules[1]);
                            break;
                        case "9":
                            G.setNumGrup(Integer.parseInt(paraules[1]));
                            break;
                        case "10":
                            G.setCapacitat(Integer.parseInt(paraules[1]));
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
