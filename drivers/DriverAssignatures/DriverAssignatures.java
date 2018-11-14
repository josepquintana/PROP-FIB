package domini;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DriverAssignatures {
    
    private static void mostrar_menu(){
        System.out.println("\t Paràmetres necessaris per crear una assignatura: String codi, String nom, double credits, int nivell, boolean ordinadors");
        System.out.println("\t Tria una opció (número) seguit dels paràmetres necessaris per comprovar el mètode:");
                System.out.println("\t 1) Assignatures()");
                System.out.println("\t 2) Assignatures(ArrayList<Assignatura> assignatures)(abans d'escriure els paràmetres per crear assignatures escriure el número) ");
                System.out.println("\t 3) Assignatures(Assignatures assignaturesCP)");
                System.out.println("\t 4) boolean existeixAssignatura(Assignatura assig)");
                System.out.println("\t 5) boolean afegirAssignatura(Assignatura a)");
                System.out.println("\t 6) boolean eliminarAssignatura(Assignatura a)");
                System.out.println("\t 7) boolean eliminarAssignatura(int i)");
                System.out.println("\t 8) boolean eliminarAssignatura(String codi)");
                System.out.println("\t 9) Assignatura getAssignatura(int i)");
                System.out.println("\t 10) Assignatura getAssignatura(String codi)");
                System.out.println("\t 11) int mida()");
                System.out.println("\t 12) boolean esBuit()");
                System.out.println("\t 13) ArrayList<Assignatura> getAssignatures()");
                System.out.println("\t 14) void setAssignatures(ArrayList<Assignatura> assignatures)");
                
                System.out.println("\t 0) Sortir");
    }
            
    public static void main(String[] args) {
        String nomClasse = "Assignatures";
        System.out.println("Driver " + nomClasse + ":");

        Assignatures A = new Assignatures();

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
                            A = new Assignatures();
                            break;
                        case "2":
                            int numassig = Integer.parseInt(paraules[1]);
                            numassig = numassig*5;
                            ArrayList<Assignatura> aux = new ArrayList<>();
                            for (int i = 2; i < numassig; i = i+5){
                                Assignatura aux2 = new Assignatura(paraules[i], paraules[i+1], Double.parseDouble(paraules[i+2]), Integer.parseInt(paraules[i+3]), Boolean.parseBoolean(paraules[i+4]));
                                aux.add(aux2);
                            }
                            A = new Assignatures(aux);
                            break;
                        case "3":
                            int numassig2 = Integer.parseInt(paraules[1]);
                            numassig2 = numassig2*5;
                            ArrayList<Assignatura> aux3 = new ArrayList<>();
                            for (int i = 2; i < numassig2; i = i+5){
                                Assignatura aux2 = new Assignatura(paraules[i], paraules[i+1], Double.parseDouble(paraules[i+2]), Integer.parseInt(paraules[i+3]), Boolean.parseBoolean(paraules[i+4]));
                                aux3.add(aux2);
                            }
                            Assignatures A2 = new Assignatures(aux3);
                            A = new Assignatures(A2);
                            break;
                        case "4":
                            Assignatura A4 = new Assignatura(paraules[1], paraules[2], Double.parseDouble(paraules[3]), Integer.parseInt(paraules[4]), Boolean.parseBoolean(paraules[5]));
                            System.out.println("Existeix assignatura: " + A.existeixAssignatura(A4));
                            break;
                        case "5":
                            Assignatura A3 = new Assignatura(paraules[1], paraules[2], Double.parseDouble(paraules[3]), Integer.parseInt(paraules[4]), Boolean.parseBoolean(paraules[5]));
                            A.afegirAssignatura(A3);
                            break;
                        case "6":
                            Assignatura A5 = new Assignatura(paraules[1], paraules[2], Double.parseDouble(paraules[3]), Integer.parseInt(paraules[4]), Boolean.parseBoolean(paraules[5]));
                            A.eliminarAssignatura(A5);
                            break;
                        case "7":
                            int in = Integer.parseInt(paraules[1]);
                            A.eliminarAssignatura(in);
                            break;
                        case "8":
                            A.eliminarAssignatura(paraules[1]);
                            break;
                        case "9":
                            int as = Integer.parseInt(paraules[1]);
                            Assignatura auxx = A.getAssignatura(as);
                            System.out.print("L'assignatura obtinguda és: " + auxx.getNom());
                            break;
                        case "10":
                            Assignatura auxx2 = A.getAssignatura(paraules[1]);
                            System.out.print("L'assignatura obtinguda és: " + auxx2.getNom());
                            break; 
                        case "11":
                            System.out.print("La mida d'assignatures és " + A.mida());
                            break; 
                        case "12":
                            System.out.println("És buit = " + A.esBuit());
                            break;
                        case "13":
                            ArrayList<Assignatura> assigs2 = new ArrayList<>();
                            assigs2 = A.getAssignatures();
                            System.out.println("Llistat d'assignatures: ");
                            for (int i = 0; i < assigs2.size(); ++i){
                                System.out.println(assigs2.get(i).getNom() + " ");
                            }
                            break;
                        case "14":
                            int numassig22 = Integer.parseInt(paraules[1]);
                            numassig = numassig22*5;
                            ArrayList<Assignatura> aux22 = new ArrayList<>();
                            for (int i = 2; i < numassig; i = i+5){
                                Assignatura aux2 = new Assignatura(paraules[i], paraules[i+1], Double.parseDouble(paraules[i+2]), Integer.parseInt(paraules[i+3]), Boolean.parseBoolean(paraules[i+4]));
                                aux22.add(aux2);
                            }
                            A.setAssignatures(aux22);
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
