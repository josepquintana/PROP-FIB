import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DriverHoraLectiva {
    
    private static void mostrar_menu(){
        System.out.println("\t Assignacio necessita els seguents paràmetres per crear-se: Grup grup, Aula aula");
        System.out.println("\t Grup necessita els seguents paràmetres per crear-se: String codi, int num, int capacitat, int numSubGrups, int hores");
        System.out.println("\t Aula necessita els seguents paràmetres per crear-se: String codi, int capacitat, boolean tipus");
        System.out.println("\t Tria una opció (número) seguit dels paràmetres necessaris per comprovar el mètode:");
                System.out.println("\t 1) HoraLectiva()");
                System.out.println("\t 2) HoraLectiva(ArrayList<Assignacio> a) (abans d'introduir els paràmetres indicar el número d'assignacions que crearàs)");
                System.out.println("\t 3) HoraLectiva(HoraLectiva hL)(abans d'introduir els paràmetres indicar el número d'assignacions que crearàs)");
                System.out.println("\t 4) boolean equals(HoraLectiva hL)");
                System.out.println("\t 5) boolean esAssignacioValida(Assignacio asg)");
                System.out.println("\t 6) boolean existeixAssignacio(Assignacio asg)");
                System.out.println("\t 7) boolean afegirAssignacio(Assignacio asg)");
                System.out.println("\t 8) boolean elimnarAssignacio(Assignacio asg)");
                System.out.println("\t 9) ArrayList<Assignacio> getAssignacions()");
                System.out.println("\t 10) Assignacio getAssignacio(Grup g)");
                System.out.println("\t 11) Assignacio getAssignacio(int i)");
                System.out.println("\t 12) boolean esBuit()");
                System.out.println("\t 13) int mida()");
                
                System.out.println("\t 0) Sortir");
    }
            
    public static void main(String[] args) {
        String nomClasse = "HoraLectiva";
        System.out.println("Driver " + nomClasse + ":");

        HoraLectiva h = new HoraLectiva();

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
                            h = new HoraLectiva();
                            break;
                        case "2":
                            int its = Integer.parseInt(paraules[1]);
                            its = its*8;
                            ArrayList<Assignacio> a = new ArrayList<>();
                            for (int i = 2; i < its; i = i+8){
                                Grup g = new Grup(paraules[i], Integer.parseInt(paraules[i+1]), Integer.parseInt(paraules[i+2]), Integer.parseInt(paraules[i+3]), Integer.parseInt(paraules[i+4]));
                                Aula au = new Aula(paraules[i+5], Integer.parseInt(paraules[i+6]), Boolean.parseBoolean(paraules[i+7]));
                                Assignacio as = new Assignacio(g, au);
                                a.add(as);
                            }
                                
                            h = new HoraLectiva(a);
                            break;
                        case "3":
                            int its2 = Integer.parseInt(paraules[1]);
                            its2 = its2*8;
                            ArrayList<Assignacio> a2 = new ArrayList<>();
                            HoraLectiva h2 = new HoraLectiva();
                            for (int i = 2; i < its2; i = i+8){
                                Grup g = new Grup(paraules[i], Integer.parseInt(paraules[i+1]), Integer.parseInt(paraules[i+2]), Integer.parseInt(paraules[i+3]), Integer.parseInt(paraules[i+4]));
                                Aula au = new Aula(paraules[i+5], Integer.parseInt(paraules[i+6]), Boolean.parseBoolean(paraules[i+7]));
                                Assignacio as = new Assignacio(g, au);
                                a2.add(as);
                            }
                                
                            h2 = new HoraLectiva(a2);
                            h = new HoraLectiva(h2);
                            break;
                        case "4":
                            int its3 = Integer.parseInt(paraules[1]);
                            its3 = its3*8;
                            ArrayList<Assignacio> a3 = new ArrayList<>();
                            HoraLectiva h3 = new HoraLectiva();
                            for (int i = 2; i < its3; i = i+8){
                                Grup g = new Grup(paraules[i], Integer.parseInt(paraules[i+1]), Integer.parseInt(paraules[i+2]), Integer.parseInt(paraules[i+3]), Integer.parseInt(paraules[i+4]));
                                Aula au = new Aula(paraules[i+5], Integer.parseInt(paraules[i+6]), Boolean.parseBoolean(paraules[i+7]));
                                Assignacio as = new Assignacio(g, au);
                                a3.add(as);
                            }
                                
                            h3 = new HoraLectiva(a3);
                            System.out.print("Les Hores Lectives són iguals: " + h.equals(h3));
                        case "5":
                            Grup g = new Grup(paraules[1], Integer.parseInt(paraules[2]), Integer.parseInt(paraules[3]), Integer.parseInt(paraules[4]), Integer.parseInt(paraules[5]));
                            Aula au = new Aula(paraules[6], Integer.parseInt(paraules[7]), Boolean.parseBoolean(paraules[8]));
                            Assignacio as = new Assignacio(g, au);
                            System.out.print("L'assignació és valida: " + h.esAssignacioValida(as));
                            break;
                        case "6":
                            Grup g2 = new Grup(paraules[1], Integer.parseInt(paraules[2]), Integer.parseInt(paraules[3]), Integer.parseInt(paraules[4]), Integer.parseInt(paraules[5]));
                            Aula au2 = new Aula(paraules[6], Integer.parseInt(paraules[7]), Boolean.parseBoolean(paraules[8]));
                            Assignacio as2 = new Assignacio(g2, au2);
                            System.out.print("Existeix l'assignacio: " + h.existeixAssignacio(as2));
                            break;
                        case "7":
                            Grup g3 = new Grup(paraules[1], Integer.parseInt(paraules[2]), Integer.parseInt(paraules[3]), Integer.parseInt(paraules[4]), Integer.parseInt(paraules[5]));
                            Aula au3 = new Aula(paraules[6], Integer.parseInt(paraules[7]), Boolean.parseBoolean(paraules[8]));
                            Assignacio as3 = new Assignacio(g3, au3);
                            h.afegirAssignacio(as3);
                            break;
                        case "8":
                            Grup g4 = new Grup(paraules[1], Integer.parseInt(paraules[2]), Integer.parseInt(paraules[3]), Integer.parseInt(paraules[4]), Integer.parseInt(paraules[5]));
                            Aula au4 = new Aula(paraules[6], Integer.parseInt(paraules[7]), Boolean.parseBoolean(paraules[8]));
                            Assignacio as4 = new Assignacio(g4, au4);
                            h.eliminarAssignacio(as4);
                            break;
                        case "9":
                            System.out.print("Codis de grups i aula de les assignacions: ");
                            for (int i = 0; i < h.mida(); ++i){
                                System.out.print(h.getAssignacio(i).getGrupAssignat().getNumGrup() + " " + h.getAssignacio(i).getCodiAulaAssignada() + " ");
                            }
                            break;
                        case "10":
                            Grup g6 = new Grup(paraules[1], Integer.parseInt(paraules[2]), Integer.parseInt(paraules[3]), Integer.parseInt(paraules[4]), Integer.parseInt(paraules[5]));                         
                            System.out.print("L'assignació obtinguda eś: " + h.getAssignacio(g6).getGrupAssignat().getNumGrup() + " " + h.getAssignacio(g6).getCodiAulaAssignada());
                            break;
                        case "11":
                            int it6 = Integer.parseInt(paraules[1]);
                            System.out.print("L'assignació obtinguda eś: " + h.getAssignacio(it6).getGrupAssignat().getNumGrup() + " " + h.getAssignacio(it6).getCodiAulaAssignada());
                            break;
                        case "12":
                            System.out.print("L'hora lectiva està buida " + h.esBuit());
                            break;
                        case "13":
                            System.out.print("Mida de l'hora lectiva: " + h.mida());
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
