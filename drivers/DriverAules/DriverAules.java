import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DriverAules {
    public static void main(String[] args) {
        String nomClasse = "Aules";
        System.out.println("Driver " + nomClasse + ":");

        Aules As = new Aules();

        try {
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            boolean sortir = false;
            while (!sortir) {
                System.out.println("Tria una opció (número) seguit dels paràmetres necessaris per comprovar el mètode:");
                System.out.println("\t 1) Aules()");
                System.out.println("\t 2) Aules(ArrayList<Aula> aules)(introduir com a segon paràmetre el nombre d'aules que s'afegiran)");
                System.out.println("\t 3) boolean existeixAula(Aula aula)");
                System.out.println("\t 4) boolean afegirAula(Aula a)");
                System.out.println("\t 5) boolean eliminarAula(Aula a)");
                System.out.println("\t 6) Aula eliminarAula(int i)");
                System.out.println("\t 7) boolean modificarAula(Aula a, String newCodi)");
                System.out.println("\t 8) boolean modificarAula(Aula a, int newCapacitat)");
                System.out.println("\t 9) Aula getAula(int i)");
                System.out.println("\t 10) Aula getAula(String codi)");
                System.out.println("\t 11) ArrayList<Aula> getAules()");
                System.out.println("\t 12) int mida()");
                System.out.println("\t 13) boolean esBuit()");
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
                            As = new Aules();
                            break;
                        case "2":
                            int m = Integer.parseInt(paraules[1]);
                            m = m*2 + 2;
                            ArrayList<Aula> As2 = new ArrayList<>();
                            for (int i = 2; i < m-1; i = i+2){
                                Aula A = new Aula(paraules[i], Integer.parseInt(paraules[i+1]));
                                As2.add(A);
                            }
                            System.out.println("Afegim " + As2.size() + " aules");
                            As = new Aules(As2);
                            break;
                        case "3":
                            Aula B = new Aula((paraules[1]), Integer.parseInt(paraules[2]));
                            boolean c = As.existeixAula(B);
                            if (c) System.out.println("L'Aula amb codi: " + B.getCodi() + " existeix");
                            else System.out.println("L'Aula amb codi: " + B.getCodi() + " no existeix");
                            break;
                        case "4":
                            Aula C = new Aula((paraules[1]), Integer.parseInt(paraules[2]));
                            As.afegirAula(C);
                            break;
                        case "5":
                            Aula D = new Aula((paraules[1]), Integer.parseInt(paraules[2]));
                            As.eliminarAula(D);
                            break;
                        case "6":
                            int j = Integer.parseInt(paraules[1]);
                            As.eliminarAula(j);
                            break;
                        case "7":
                            Aula E = new Aula((paraules[1]), Integer.parseInt(paraules[2]));
                            String newco = paraules[3];
                            As.modificarAula(E, newco);
                            break;
                        case "8":
                            Aula F = new Aula((paraules[1]), Integer.parseInt(paraules[2]));
                            int newca = Integer.parseInt(paraules[3]);
                            As.modificarAula(F, newca);
                            break;
                        case "9":
                            int k = Integer.parseInt(paraules[1]);
                            As.getAula(k);
                            break;
                        case "10":
                            String codi = paraules[1];
                            Aula A2 = As.getAula(codi);
                            System.out.println("Es retorna l'Aula amb codi: " + A2.getCodi());
                            break;
                        case "11":
                            ArrayList<Aula> As4 = As.getAules();
                            System.out.print("Aules: ");
                            for (int i2 = 0; i2 < As4.size(); ++i2){
                                System.out.print(As4.get(i2).getCodi() + " ");
                            }
                            System.out.print("\n");
                            break; 
                        case "12":
                            int mid = As.mida();
                            System.out.println("El nombre d'aules és: " + mid);
                            break; 
                        case "13":
                            boolean buit = As.esBuit();
                            if (buit) System.out.println("No hi ha aules");
                            else System.out.println("Hi ha aules");
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
