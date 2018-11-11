package domini;

import java.util.ArrayList;

public class Horari
{
    private final int dies = 5;
    private int hIni;
    private int hores;
    private HoraLectiva[][] setmana;

    public Horari(JornadaLectiva jL) {
        this.hIni = jL.getHoraIni().getHours();
        this.hores = (jL.getHoraFi().getHours())-hIni;
        this.setmana = new HoraLectiva[dies][hores];
        this.iniSetmana();  // s'ha de inicialitzar, sino peta molt potent
    }

    public Horari(Horari horari) {
        this.hores = horari.getHores();
        this.setmana = new HoraLectiva[this.dies][this.hores];
    }

    public void GenerarHorari(PlaEstudis pe) throws MyException {
        Assignatures assignatures = new Assignatures(pe.getAssignatures());
        ArrayList<Aula> aulesPE = new ArrayList<>(pe.getAules().getAules());
        Aules aules = new Aules(aulesPE);

        ArrayList<HoraLectiva> horesLectives = new ArrayList<>();
        while (! assignatures.esBuit()) {
            HoraLectiva hL = GeneradorHora.ForwardChecking(assignatures, aules);
            horesLectives.add(hL);
            for (int i = 0; i < hL.getAssignacions().size(); i++) {
                Assignacio asg = new Assignacio(hL.getAssignacions().get(i));
                String codiAssig = asg.getGrupAssignat().getCodiAssig();
                //assignatures.getAssignatura(codiAssig).printAssignatura();
                Assignatura assig = new Assignatura(assignatures.getAssignatura(codiAssig));
                assig.eliminarGrupAssignatura(asg.getGrupAssignat());
                if (!assig.teGrups()) {
                    assignatures.eliminarAssignatura(codiAssig);
                }
            }
        }
        
        this.OmplirHorari(horesLectives);

    }

    private void OmplirHorari(ArrayList<HoraLectiva> horesLectives) {
        for (int j = 0; j < this.hores; j++) {
            for (int i = 0; i < this.dies; i++) {
                if(!horesLectives.isEmpty()){
                     HoraLectiva hL = horesLectives.remove(0);
                     this.setmana[i][j] = new HoraLectiva(hL);
                } else break;
                
            }
        }
    }

    public boolean existeixHoraLectiva(HoraLectiva hL) {
        for(int i = 0; i < dies; ++i) {
            for(int j = 0; j < hores; ++j) {
                if(this.setmana[i][j].equals(hL)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean afegirHoraLectiva(HoraLectiva hL) {
        if(existeixHoraLectiva(hL)){
            System.out.println(">>> afegirHora(): L' hora lectiva donada ja existeix");  return false;
        }
        for(int i = 0; i < dies; ++i) {
            for(int j = 0; j < hores; ++j) {
                if(this.setmana[i][j].esBuit()) {
                    this.setmana[i][j] = hL;
                    return true;
                }
            }
        }
        System.out.println(">>> afegirHora(): No queden horesLectives disponibles per assignar"); return false;
    }

    public boolean afegirHoraLectiva(HoraLectiva hL, int dia, int hora) {
        if(existeixHoraLectiva(hL)){
          System.out.println(">>> afegirHora_ij(): L' hora lectiva donada ja existeix"); return false;
        }
        hora = hora - this.hIni;
        if (hora < 0 || hora >= this.hores || dia < 0 || dia >= 5) {
          System.out.println(">>> afegirHora_ij(): Parametres hora i dia no valids."); return false;
        }
        if (!this.setmana[dia][hora].esBuit()) {
          System.out.println(">>> afegirHora_ij(): setmana[i][j] no esta buida."); return false;
        }
        this.setmana[dia][hora] = hL;
        return true;
    }
    
    public boolean eliminarHoraLectiva(HoraLectiva hL){
        for(int i = 0; i < dies; ++i) {
            for(int j = 0; j < hores; ++j) {
                if(this.setmana[i][j].equals(hL)) {
                    this.setmana[i][j] = new HoraLectiva();
                    return true;
                }
            }
        }
        System.out.println(">>> eliminarHoraLectiva(): L' hora lectiva donada no existeix");
        return false;
    }

    public boolean eliminarHoraLectiva(int dia, int hora) {
        hora = hora - this.hIni;
        if (hora >= 0 && hora < this.hores && dia >= 0 && dia < 5) {
            this.setmana[dia][hora] = new HoraLectiva();
            return true;
        }
        else {
            System.out.println(">>> eliminarHora_ij(): Parametres hora i dia no valids.");
            return false;
        }
    }

    public int getDies() {
        return dies;
    }

    public int getHores() {
        return hores;
    }

    private void iniSetmana() {
        for (int i = 0; i < dies; i++) {
            for (int j = 0; j < hores; j++) {
                this.setmana[i][j] = new HoraLectiva();
            }
        }
    }



    ////////////////////////////////////////////////////////////
    //// Molta tralla nomes per imprimir el horari

    private void printHoresIniFi(int h) {
        h = h + this.hIni;
        String h0s = Integer.toString(h);
        String h1s = Integer.toString(h+1);
        if (h0s.length() < 2) h0s = "0" + h0s;
        if (h1s.length() < 2) h1s = "0" + h1s;
        String str = "  " + h0s + " - " + h1s + "h";
        System.out.printf("%-2s %-10s", str, "");
    }

    private void printHL(int d, int h) {
        for (int i = 0; i < this.setmana[d][h].mida(); i++) {
            String str = this.setmana[d][h].getAssignacio(i).getAssignacioPrintFormat();
            if (d == 0 && i == 0) {
                System.out.printf("%-20.20s%n", str);
            }
            else System.out.printf("%-20.20s %-20.20s%n", "", str);
        }
    }

    public void printHorari() {

        System.out.println("\n\n   Horari Generat:\n");
        System.out.printf("%-20.20s %-21.21s %-21.21s %-21.21s %-21.21s %-21.21s%n", "", "DILLUNS", "DIMARTS", "DIMECRES", "DIJOUS", "DIVENDRES");

        for (int h = 0; h < this.hores; h++) {
            //this.printHoresIniFi(h);
            for (int d = 0; d < this.dies; d++) {
                this.printHL(d, h);
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public void printDay(int d) {
        for (int h = 0; h < this.hores; h++) {
            String h0s = Integer.toString(h + this.hIni);
            String h1s = Integer.toString(h + this.hIni +1);
            if (h0s.length() < 2) h0s = "0" + h0s;
            if (h1s.length() < 2) h1s = "0" + h1s;
            String str = "  " + h0s + " - " + h1s + "h";
            System.out.print(str + "   ");
            for (int i = 0; i < this.setmana[d][h].mida(); i++) {
                String s = this.setmana[d][h].getAssignacio(i).getAssignacioPrintFormat();
                System.out.print(s + "  ");
            }
            System.out.print("\n");
        }
    }

    public void printHorariEasy() {
        System.out.println("DILLUNS");
        this.printDay(0);
        System.out.println("DIMARTS");
        this.printDay(1);
        System.out.println("DIMECRES");
        this.printDay(2);
        System.out.println("DIJOUS");
        this.printDay(3);
        System.out.println("DIVENDRES");
        this.printDay(4);
    }
}