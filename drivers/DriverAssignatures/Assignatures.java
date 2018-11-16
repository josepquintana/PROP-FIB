import java.util.ArrayList;
import java.util.Iterator;

public class Assignatures
{
    private ArrayList<Assignatura> assignatures;

    public Assignatures() {
        this.assignatures = new ArrayList<>();
    }

    public Assignatures(ArrayList<Assignatura> assignatures) throws CloneNotSupportedException {
        this.assignatures = new ArrayList<>();
        Iterator<Assignatura> it = assignatures.iterator();
        while(it.hasNext()) {
            // Add a clone of object i
            this.assignatures.add((Assignatura) it.next().clone());
        }
    }

    public Assignatures(Assignatures assignaturesCP) {
        this.assignatures = new ArrayList<>(assignaturesCP.assignatures);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Assignatures assignaturesCloned = new Assignatures();
        try {
            for(int i = 0; i < this.assignatures.size(); ++i) {
                assignaturesCloned.assignatures.add((Assignatura) this.assignatures.get(i).clone());
            }
        }
        catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return assignaturesCloned;
    }

    public boolean existeixAssignatura(Assignatura assig) {
        for (int i = 0; i < this.assignatures.size(); i++) {
            if(this.assignatures.get(i).equals(assig)) return true;
        }
        return false;
    }

    public boolean afegirAssignatura(Assignatura a) {
        if(existeixAssignatura(a)) {
            System.out.println(">>> afegirAssignatura(): L'assignatura " + a.getCodi() + " ja existeix al sistema.");
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

    ////// mirar si peta remove()
    public boolean eliminarAssignatura(int i) {
        Assignatura a = new Assignatura(this.assignatures.remove(i));
        if(a == null) System.out.println(">>> eliminarAssignatura(): L'assignatura " + a.getCodi() + " no existeix al sistema");
        return true;
    }
    
    public boolean eliminarAssignatura(String codi) {
        for(int i = 0; i< assignatures.size(); ++i){
            if(assignatures.get(i).getCodi().equals(codi)) {
                Assignatura a = new Assignatura(this.assignatures.remove(i));
                return true;
            }
         }
        return false;
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

    public void printAssignaturesXS() {
        System.out.print("   Assignatures: [" + this.assignatures.size() + "]");
        for (int i = 0; i < this.assignatures.size(); i++) {
            if (i % 11 == 0) System.out.print("\n    ");                                // for indentation purposes
            System.out.print(this.assignatures.get(i).getCodi() + "-[" + this.assignatures.get(i).getGrups().size() + "]");   // print codiAssignatura + nGrups
            if (i < this.assignatures.size() - 1) System.out.print(", ");               // for presentation purposes
        }
        System.out.print("\n");
    }

}

