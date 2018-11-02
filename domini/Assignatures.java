package domini;


import java.util.ArrayList;
import java.util.Iterator;

public class Assignatures
{
    private ArrayList<Assignatura> assignatures;
    private Iterator<Assignatura> it;

    public Assignatures() {
        this.assignatures = new ArrayList<>();
        this.it = new ArrayList<Assignatura>().iterator();
        this.it = assignatures.iterator();
    }

    public Assignatures(ArrayList<Assignatura> assignatures) {
        this.assignatures = new ArrayList<>();
        this.assignatures = assignatures;
        this.it = new ArrayList<Assignatura>().iterator();
        this.it = assignatures.iterator();
    }

    // clone()

    public boolean existeixAssignatura(Assignatura assig) {
        for (int i = 0; i < this.assignatures.size(); i++) {
            if(this.assignatures.get(i).equals(assig)) return true;
        }
        return false;
    }

    public boolean afegirAssignatura(Assignatura a) {
        if(existeixAssignatura(a)) {
            System.out.println(">>> afegirAssignatura(): L'assignatura " + a.getCodi() + " ja existeix al sistema");
            return false;
        }
        boolean ret = this.assignatures.add(a);
        return ret;
    }

    public boolean eliminarAssignatura(Assignatura a) {
        boolean ret = this.assignatures.remove(a);
        if(!ret) System.out.println(">>> eliminarAssignatura(): L'assignatura " + a.getCodi() + " no existeix al sistema");
        return ret;
    }

    public boolean modificarAssignatura(Assignatura a) {
        // no es pot -> s'ha de eliminar i crear amb els nous parametres
        return false;
    }

    public Assignatura getAssignatura(int i) {
        return this.assignatures.get(i);
    }

    public Assignatura getAssignatura(String codi) {
        for (int i = 0; i < this.assignatures.size(); i++) {
            if(this.assignatures.get(i).getCodi().equals(codi)) return this.assignatures.get(i);
        }
        return null;
    }

    public int mida() {
        return this.assignatures.size();
    }

    public boolean esBuit() {
        return this.assignatures.isEmpty();
    }

    public ArrayList<Assignatura> getAssignatures() {
        return this.assignatures;
    }

    public void setAssignatures(ArrayList<Assignatura> assignatures) {
        this.assignatures = new ArrayList<>();
        this.assignatures = assignatures;
    }

    public void printAssignaturesLong() {
        System.out.println("   Assignatures [Long Format]:");
        for (int i = 0; i < this.assignatures.size(); i++) {
            this.assignatures.get(i).printAssignaturaLong();
        }
    }

    public void printAssignatures() {
        System.out.println("   Assignatures:");
        for (int i = 0; i < this.assignatures.size(); i++) {
            this.assignatures.get(i).printAssignatura();
        }
    }

}

