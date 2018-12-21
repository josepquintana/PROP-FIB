package domini;

import java.util.ArrayList;
import java.util.Collections;
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
            this.assignatures.add((Assignatura) it.next().clone()); // Add a clone of object it
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

    public void shuffle() {
        Collections.shuffle(this.assignatures);
    }

    public boolean existeixAssignatura(Assignatura assig) {
        for (int i = 0; i < this.assignatures.size(); i++) {
            if(this.assignatures.get(i).equals(assig)) return true;
        }
        return false;
    }

    public boolean afegirAssignatura(Assignatura a) throws MyException{
        if(existeixAssignatura(a)) {
            throw new MyException("L'assignatura " + a.getCodi() + " ja existeix al sistema.");
        }
        else {
            boolean ret = this.assignatures.add(a);
            return ret;
        }
    }

    public boolean eliminarAssignatura(Assignatura a) {
        boolean ret = this.assignatures.remove(a);
        return ret;
    }

    public boolean eliminarAssignatura(String codi) {
        boolean removed = false;
        for(int i = 0; i < assignatures.size(); ++i){
            if(assignatures.get(i).getCodi().equals(codi)) {
                this.assignatures.remove(i);
                removed = true;
            }
        }

        for (int i = 0; i < assignatures.size(); i++) {
            this.assignatures.get(i).eliminarCorrequisitAssignatura(codi);
        }

        return removed;
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

    int getIndexAssignatura(String codiAssig) {
        for(int i = 0; i < this.assignatures.size() ; ++i){
            if(this.assignatures.get(i).getCodi().equals(codiAssig)) return i;
        }
        return -1;
    }

}

