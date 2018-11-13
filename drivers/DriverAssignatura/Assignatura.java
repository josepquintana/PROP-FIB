import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DriverAssignatura {
    
    private static void mostrar_menu(){
        System.out.println("Tria una opció (número) seguit dels paràmetres necessaris per comprovar el mètode:");
                System.out.println("\t 1) Assignatura()");
                System.out.println("\t 2) Assignatura(String codi)");
                System.out.println("\t 3) Assignatura(String codi, String nom, double credits, int nivell)");
                System.out.println("\t 4) Assignatura(String codi, String nom, double credits, int nivell, ArrayList<String> correqs, ArrayList<Grup> grups) (abans de cada llista escriure el número d'elements)");
                System.out.println("\t 5) Assignatura(Assignatura a)");
                System.out.println("\t 6) boolean equals(Assignatura a)(entrar el codi)");
                System.out.println("\t 7) boolean existeixRequisit(Assignatura assig(entrar el codi)");
                System.out.println("\t 8) boolean existeixRequisit(String codi)");
                System.out.println("\t 9) boolean afegirCorrequisitAssignatura(Assignatura a)");
                System.out.println("\t 10) boolean afegirCorrequisitAssignatura(String codi)");
                System.out.println("\t 11) boolean eliminarCorrequisitAssignatura(Assignatura a)");
                System.out.println("\t 12) boolean eliminarCorrequisitAssignatura(String codi)");
                System.out.println("\t 13) boolean existeixGrup(Grup g)");
                System.out.println("\t 14) boolean existeixGrup(int numGrup)");
                System.out.println("\t 15) boolean afegirGrupAssignatura(Grup g)");
                System.out.println("\t 16) boolean eliminarGrupAssignatura(Grup g)");
                System.out.println("\t 17) boolean eliminarGrupAssignatura(int i)");
                System.out.println("\t 18) boolean teCorrequisits()");
                System.out.println("\t 19) boolean teGrups()");
                System.out.println("\t 20) void setCodi(String codi)");
                System.out.println("\t 21) void setNom(String nom)");
                System.out.println("\t 22) void setCredits(double credits)");
                System.out.println("\t 23) void setNivell(int nivell)");
                System.out.println("\t 24) void setCorrequisits(ArrayList<String> correqs) (posar com a segon paràmetre el número d'assignatures que entraras a continuació)");
                System.out.println("\t 25) void setGrups(ArrayList<Grup> grups) (posar com a segon paràmetre el número de grups que entraràs a continuació i per cada grup cal entrar el codi, el número i la capacitat)");
                System.out.println("\t 26) String getCodi()");
                System.out.println("\t 27) String getNom()");
                System.out.println("\t 28) double getCredits()");
                System.out.println("\t 29) int getNivell()");
                System.out.println("\t 30) ArrayList<String> getCorrequisits()");
                System.out.println("\t 31) String getCorrequisit(int i)");
                System.out.println("\t 32) ArrayList<Grup> getGrups()");
                System.out.println("\t 33) Grup getGrup(int i)");
                System.out.println("\t 34) int getCapacitatAssignatura()");
                
                
                System.out.println("\t 0) Sortir");
    }
            
    public static void main(String[] args) {
        String nomClasse = "Assignatura";
        System.out.println("Driver " + nomClasse + ":");

        Assignatura A = new Assignatura();

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
                            A = new Assignatura();
                            break;
                        case "2":
                            A = new Assignatura(paraules[1]);
                        case "3":
                            String codi1 = paraules[1];
                            String nom1 = paraules[2];
                            double credits1 = Double.parseDouble(paraules[3]);
                            int nivell1 = Integer.parseInt(paraules[4]);
                            A = new Assignatura(codi1, nom1, credits1, nivell1);
                            break;
                        case "4":
                            String codi = paraules[1];
                            String nom = paraules[2];
                            double credits = Double.parseDouble(paraules[3]);
                            int nivell = Integer.parseInt(paraules[4]);
                            int cor = Integer.parseInt(paraules[5]);
                            ArrayList<String> correqs = new ArrayList<>();
                            for (int i = 6; i < cor + 6; ++i){
                                correqs.add(paraules[i]);
                            }
                            System.out.println("Afegits " + correqs.size() + " correquisits");
                            int gru = Integer.parseInt(paraules[6+cor]);
                            gru = gru*3;
                            ArrayList<Grup> grups = new ArrayList<>();
                            for (int j = 7+cor; j < gru+7+cor; j = j+3){
                                Grup g = new Grup(paraules[j], Integer.parseInt(paraules[j+1]), Integer.parseInt(paraules[j+2]));
                                grups.add(g);
                            }
                            System.out.println(grups.size() + " Grups creats");
                            A = new Assignatura(codi, nom, credits, nivell, correqs, grups);
                            break;
                        case "5":
                            Assignatura A2 = new Assignatura(paraules[1]);
                            A = new Assignatura(A2);
                            break;
                        case "6":
                            Assignatura A3 = new Assignatura(paraules[1]);
                            System.out.println("Resultat de comparar l'assignatura amb codi: " + A.getCodi() + "amb l'assignatura amb codi " + A3.getCodi() + ": " + A.equals(A3));
                            break;
                        case "7":
                            Assignatura A4 = new Assignatura(paraules[1]);
                            System.out.println("Existeix requisit: " + A.existeixRequisit(A4));
                            break;
                        case "8":
                            System.out.println("Existeix requisit: " + A.existeixRequisit(paraules[1]));
                            break;
                        case "9":
                            Assignatura A5 = new Assignatura(paraules[1]);
                            A.afegirCorrequisitAssignatura(A5);
                            break;
                        case "10":
                            A.afegirCorrequisitAssignatura(paraules[1]);
                            break;
                        case "11":
                            Assignatura A6 = new Assignatura(paraules[1]);
                            A.eliminarCorrequisitAssignatura(A6);
                            System.out.print("\n");
                            break; 
                        case "12":
                            A.eliminarCorrequisitAssignatura(paraules[1]);
                            break; 
                        case "13":
                            Grup G1 = new Grup(paraules[1], Integer.parseInt(paraules[2]), Integer.parseInt(paraules[3]));
                            System.out.println("Existeix grup: " + A.existeixGrup(G1));
                            break;
                        case "14":
                            System.out.println("Existeix grup: " + A.existeixGrup(Integer.parseInt(paraules[1])));
                            break;
                        case "15":
                            Grup G2 = new Grup(paraules[1], Integer.parseInt(paraules[2]), Integer.parseInt(paraules[3]));
                            A.afegirGrupAssignatura(G2);
                            break;
                        case "16":
                            Grup G3 = new Grup(paraules[1], Integer.parseInt(paraules[2]), Integer.parseInt(paraules[3]));
                            A.eliminarGrupAssignatura(G3);
                            break;
                        case "17":
                            A.eliminarGrupAssignatura(Integer.parseInt(paraules[1]));
                            break;
                        case "18":
                            System.out.println("Te correquisits " + A.teCorrequisits());
                            break;
                        case "19":
                            System.out.println("Te correquisits " + A.teGrups());
                            break;
                        case "20":
                            A.setCodi(paraules[1]);
                            break;
                        case "21":
                            A.setNom(paraules[1]);
                            break;
                        case "22":
                            A.setCredits(Double.parseDouble(paraules[1]));
                            break;
                        case "23":
                            A.setNivell(Integer.parseInt(paraules[1]));
                            break;
                        case "24":
                            int cor2 = Integer.parseInt(paraules[1]);
                            ArrayList<String> cor3 = new ArrayList<>();
                            for (int i = 2; i < cor2+2; ++i){
                                cor3.add(paraules[i]);
                            }
                            A.setCorrequisits(cor3);
                            break;
                        case "25":
                            int gru3 = Integer.parseInt(paraules[1]);
                            gru3 = gru3*3;
                            ArrayList<Grup> gru2 = new ArrayList<>();
                            for (int i = 2; i < gru3+2; i = i+3){
                                Grup g2 = new Grup(paraules[i], Integer.parseInt(paraules[i+1]), Integer.parseInt(paraules[i+1]));
                                gru2.add(g2);
                            }
                            A.setGrups(gru2);
                            break;
                        case "26":
                            System.out.println("El codi de l'assignatura és " + A.getCodi());
                            break;
                        case "27":
                            System.out.println("El nom de l'assignatura és " + A.getNom());
                            break;
                        case "28":
                            System.out.println("El número de crèdits és " + A.getCredits());
                            break;
                        case "29":
                            System.out.println("El nivell de l'assignatura és " + A.getNivell());
                            break;
                        case "30":
                            ArrayList<String> corr5 = new ArrayList<>();
                            corr5 = A.getCorrequisits();
                            System.out.println("Llistat de correquisits: ");
                            for (int i = 0; i < corr5.size(); ++i){
                                System.out.println(corr5.get(i) + " ");
                            }
                            break;
                        case "31":
                            int cor6 = Integer.parseInt(paraules[1]);
                            System.out.println("El correquisit " + cor6 + " de l'assignatura és " + A.getCorrequisit(cor6));
                            break;
                        case "32":
                            ArrayList<Grup> grups2 = new ArrayList<>();
                            grups2 = A.getGrups();
                            System.out.println("Llistat de grups: ");
                            for (int i = 0; i < grups2.size(); ++i){
                                System.out.println(grups2.get(i).getNumGrup() + " ");
                            }
                            break;
                        case "33":
                            Grup g3 = new Grup();
                            g3 = A.getGrup(Integer.parseInt(paraules[1]));
                            System.out.println("El grup obtingut és: " + g3.getNumGrup());
                            break;
                        case "34":
                            System.out.println("La capacitat de l'Assignatura és: " + A.getCapacitatAssignatura());
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
