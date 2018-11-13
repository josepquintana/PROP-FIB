package domini;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DriverAssignatura {
    
    private static void mostrar_menu(){
        System.out.println("Tria una opció (número) seguit dels paràmetres necessaris per comprovar el mètode:");
                System.out.println("\t 1) Assignatura()");
                System.out.println("\t 2) Assignatura(String codi)");
                System.out.println("\t 3) Assignatura(String codi, String nom, double credits, int nivell)");
                System.out.println("\t 4) Assignatura(String codi, String nom, double credits, int nivell, ArrayList<String> correqs, ArrayList<Grup> grups)");
                System.out.println("\t 5) Assignatura(Assignatura a)");
                System.out.println("\t 6) boolean equals(Assignatura a)");
                System.out.println("\t 7) boolean existeixRequisit(Assignatura assig)");
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
                System.out.println("\t 24) void setCorrequisits(ArrayList<String> correqs)");
                System.out.println("\t 25) void setGrups(ArrayList<Grup> grups)");
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
                            int newca = Integer.parseInt(paraules[3]);
                            As.modificarAula(E, newca);
                            break;
                        case "8":
                            Aula F = new Aula((paraules[1]), Integer.parseInt(paraules[2]));
                            int newco = Integer.parseInt(paraules[3]);
                            As.modificarAula(F, newco);
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
                        case "14":
                            Aula D = new Aula((paraules[1]), Integer.parseInt(paraules[2]));
                            As.eliminarAula(D);
                            break;
                        case "15":
                            Aula D = new Aula((paraules[1]), Integer.parseInt(paraules[2]));
                            As.eliminarAula(D);
                            break;
                        case "16":
                            Aula D = new Aula((paraules[1]), Integer.parseInt(paraules[2]));
                            As.eliminarAula(D);
                            break;
                        case "17":
                            Aula D = new Aula((paraules[1]), Integer.parseInt(paraules[2]));
                            As.eliminarAula(D);
                            break;
                        case "18":
                            Aula D = new Aula((paraules[1]), Integer.parseInt(paraules[2]));
                            As.eliminarAula(D);
                            break;
                        case "19":
                            Aula D = new Aula((paraules[1]), Integer.parseInt(paraules[2]));
                            As.eliminarAula(D);
                            break;
                        case "20":
                            Aula D = new Aula((paraules[1]), Integer.parseInt(paraules[2]));
                            As.eliminarAula(D);
                            break;
                        case "21":
                            Aula D = new Aula((paraules[1]), Integer.parseInt(paraules[2]));
                            As.eliminarAula(D);
                            break;
                        case "22":
                            Aula D = new Aula((paraules[1]), Integer.parseInt(paraules[2]));
                            As.eliminarAula(D);
                            break;
                        case "23":
                            Aula D = new Aula((paraules[1]), Integer.parseInt(paraules[2]));
                            As.eliminarAula(D);
                            break;
                        case "24":
                            Aula D = new Aula((paraules[1]), Integer.parseInt(paraules[2]));
                            As.eliminarAula(D);
                            break;
                        case "25":
                            Aula D = new Aula((paraules[1]), Integer.parseInt(paraules[2]));
                            As.eliminarAula(D);
                            break;
                        case "26":
                            Aula D = new Aula((paraules[1]), Integer.parseInt(paraules[2]));
                            As.eliminarAula(D);
                            break;
                        case "27":
                            Aula D = new Aula((paraules[1]), Integer.parseInt(paraules[2]));
                            As.eliminarAula(D);
                            break;
                        case "28":
                            Aula D = new Aula((paraules[1]), Integer.parseInt(paraules[2]));
                            As.eliminarAula(D);
                            break;
                        case "29":
                            Aula D = new Aula((paraules[1]), Integer.parseInt(paraules[2]));
                            As.eliminarAula(D);
                            break;
                        case "30":
                            Aula D = new Aula((paraules[1]), Integer.parseInt(paraules[2]));
                            As.eliminarAula(D);
                            break;
                        case "31":
                            Aula D = new Aula((paraules[1]), Integer.parseInt(paraules[2]));
                            As.eliminarAula(D);
                            break;
                        case "32":
                            Aula D = new Aula((paraules[1]), Integer.parseInt(paraules[2]));
                            As.eliminarAula(D);
                            break;
                        case "33":
                            Aula D = new Aula((paraules[1]), Integer.parseInt(paraules[2]));
                            As.eliminarAula(D);
                            break;
                        case "34":
                            Aula D = new Aula((paraules[1]), Integer.parseInt(paraules[2]));
                            As.eliminarAula(D);
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
