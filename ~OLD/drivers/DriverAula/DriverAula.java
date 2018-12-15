import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DriverAula {
    public static void main(String[] args) {
        String nomClasse = "Aula";
        System.out.println("Driver " + nomClasse + ":");

        Aula A = new Aula();

        try {
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            boolean sortir = false;
            while (!sortir) {
                System.out.println("Tria una opció (número) seguit dels paràmetres necessaris per comprovar el mètode:");
                System.out.println("\t 1) Aula()");
                System.out.println("\t 2) Aula(String codi, int capacitat, boolean tipus) (si el tipus = true serà aula de PCS)");
                System.out.println("\t 3) Aula(Aula a)");
                System.out.println("\t 4) bool equals(Aula a) (hauràs d'introduir el codi i la capacitat per crear l'aula que es passarà com a paràmetre)");
                System.out.println("\t 5) boolean setCodi(String codi)");
                System.out.println("\t 6) boolean setCapacitat(int capacitat)");
                System.out.println("\t 7) boolean setTipus(boolean tipus)"); 
                System.out.println("\t 8) String getCodi()");
                System.out.println("\t 9) int getCapacitat()"); 
                System.out.println("\t 10) boolean getTipus()");
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
                            A = new Aula();
                            break;
                        case "2":
                            String codi = (paraules[1]);
                            Integer capacitat = Integer.parseInt(paraules[2]);
                            Boolean tipus = Boolean.parseBoolean(paraules[3]);
                            A = new Aula(codi, capacitat, tipus);
                            break;
                        case "3":
                            Aula B = new Aula((paraules[1]), Integer.parseInt(paraules[2]), Boolean.parseBoolean(paraules[3]));
                            A = new Aula(B);
                            break;
                        case "4":
                            Aula C = new Aula((paraules[1]), Integer.parseInt(paraules[2]), Boolean.parseBoolean(paraules[3]));
                            System.out.println("Comparació de l'Aula amb codi: " + A.getCodi() + " amb l'Aula amb codi " + C.getCodi() + ":" + A.equals(C));
                            break;
                        case "5":
                            A.setCodi(paraules[1]);
                            break;
                        case "6":
                            A.setCapacitat(Integer.parseInt(paraules[1]));
                            break;
                        case "7":
                            A.setTipus(Boolean.parseBoolean(paraules[1]));
                            break;    
                        case "8":
                            System.out.println("Codi de l'aula actual: " + A.getCodi() + ".");
                            break;
                        case "9":
                            System.out.println("Capacitat de l'aula actual: " + A.getCapacitat() + ".");
                            break;
                        case "10":
                            Boolean tipus2 = A.getTipus();
                            if (tipus2) System.out.println("Tipus de l'aula actual: PCs.");
                            else System.out.println("Tipus de l'aula actual: no PCs.");
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