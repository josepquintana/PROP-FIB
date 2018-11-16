package domini;

import java.util.ArrayList;

public class HoraLectiva
{
    private ArrayList<Assignacio> assignacions;
    
    public HoraLectiva(){
        this.assignacions = new ArrayList<>();
    }
    
    public HoraLectiva(ArrayList<Assignacio> a){
        this.assignacions = new ArrayList<>();
        this.assignacions = a;
    }

    public HoraLectiva(HoraLectiva hL){
        this.assignacions = new ArrayList<>();
        this.assignacions = hL.getAssignacions();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        HoraLectiva hL = new HoraLectiva();
        try {
            for(int i = 0; i < this.assignacions.size(); ++i) {
                hL.assignacions.add((Assignacio) this.assignacions.get(i).clone());
            }
        }
        catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return hL;
    }

    public boolean equals(HoraLectiva hL) {
        return (this.assignacions.equals(hL.getAssignacions()));
    }

    // Comprova que la Assignació asg sigui valida: no tingui ni l'aula ni Assignatura:Grup assignades
    public boolean esAssignacioValida(Assignacio asg) {
        for (int i = 0; i < this.assignacions.size(); i++) {
            if(this.assignacions.get(i).getGrupAssignat().equals(asg.getGrupAssignat()) || this.assignacions.get(i).getCodiAulaAssignada().equals(asg.getCodiAulaAssignada())) return true;
        }
        return false;
    }

    public boolean existeixAssignacio(Assignacio asg) {
        for (int i = 0; i < this.assignacions.size(); i++) {
            if(this.assignacions.get(i).getGrupAssignat().equals(asg.getGrupAssignat()) && this.assignacions.get(i).getCodiAulaAssignada().equals(asg.getCodiAulaAssignada())) return true;
        }
        return false;
    }

    public boolean afegirAssignacio(Assignacio asg) {
        if(esAssignacioValida(asg)) {
            System.out.println(">>> afegirAssignacio(): L'assignacio [" + asg.getGrupAssignat().getCodiAssig() + ", " + asg.getGrupAssignat().getNumGrup() + ", " + asg.getCodiAulaAssignada() + "] ja existeix.");
            return false;
        }
        else return this.assignacions.add(asg);
    }

    public boolean elimnarAssignacio(Assignacio asg) {
        if(!existeixAssignacio(asg)) {
            System.out.println(">>> eliminarAssignacio(): L'assignacio [" + asg.getGrupAssignat().getCodiAssig() + ", " + asg.getGrupAssignat().getNumGrup() + ", " + asg.getCodiAulaAssignada() + "] no existeix.");
            return false;
        }
        else return this.assignacions.remove(asg);
    }

    public ArrayList<Assignacio> getAssignacions() {
        return this.assignacions;
    }

    public Assignacio getAssignacio(Grup g) {
        for (int i = 0; i < this.assignacions.size(); ++i) {
            if (this.assignacions.get(i).getGrupAssignat().equals(g)) return this.assignacions.get(i);
        }
        return null;
    }

    public Assignacio getAssignacio(int i) {
        return this.assignacions.get(i);
    }

    public boolean esBuit() {
        return (this.assignacions.isEmpty());
    }

    public int mida() {
        return this.assignacions.size();
    }

    public void printHoraLectivaLong() {
        System.out.println("    HoraLectiva: [Long Format]");
        for (int i = 0; i < this.assignacions.size(); i++) {
            this.assignacions.get(i).printAssignacioLong();
        }
    }

    public void printHoraLectiva() {
        System.out.println("    HoraLectiva:");
        for (int i = 0; i < this.assignacions.size(); i++) {
            this.assignacions.get(i).printAssignacio();
        }
    }

    public void printHoraLectivaXS() {
        System.out.print("    HoraLectiva: ");
        for (int i = 0; i < this.assignacions.size(); i++) {
            this.assignacions.get(i).printAssignacioXS();
        }
        System.out.print("\n");
    }
}
