package domini;

import java.util.ArrayList;
import java.util.Iterator;
import domini.MyException;

public class Aules
{
    private ArrayList<Aula> aules;
    private Iterator<Aula> it;

    public Aules() {
        this.aules = new ArrayList<>();
        this.it = aules.iterator();
    }

    public Aules(ArrayList<Aula> aules) {
        this.aules = aules;
        this.it = this.aules.iterator();
    }

    public boolean existeixAula(Aula aula) {
        for (int i = 0; i < this.aules.size(); i++) {
            if (this.aules.get(i).equals(aula)) return true;
        }
        return false;
    }

    public void afegirAula(Aula a) throws MyException{
        if(existeixAula(a)) {
            System.out.println("afegirAula(): L'aula " + a.getCodi() + " ja existeix al sistema");
            return;
        }
        boolean ret = this.aules.add(a);
        if(!ret) throw new MyException("Error: Aula no afegida");
    }

    public void eliminarAula(Aula a) throws MyException{
        boolean ret = this.aules.remove(a);
        if(!ret) System.out.println("eliminarAula(): L'aula " + a.getCodi() + " no existeix al sistema");
    }

    //
    public Aula eliminarAula(int i) throws MyException{
        Aula a;
        if(!existeixAula(this.aules.get(i))) {
            System.out.println("eliminarAula(): L'aula " + this.aules.get(i).getCodi() + " no existeix al sistema");
            a = new Aula();
        }
        else {
            a = this.aules.remove(i);
            if (a == null) throw new MyException("Error: Aula no Eliminada");
        }
        return a;
    }
    //

    public boolean modificarAula(Aula a, int attribute) {
        if (attribute != 1 || attribute != 2) {
            System.out.println(">>> !! Error: Wrong attribute value");
            return false;
        }
        boolean ret = false;
        boolean found = false;
        for(int i = 0; i < this.aules.size() && !found; ++i) {
            if(this.aules.get(i).equals(a)) {
                found = true;
                if      (attribute == 1) ret = this.aules.get(i).setCodi(a.getCodi());
                else if (attribute == 2) ret = this.aules.get(i).setCapacitat(a.getCapacitat());
            }
        }

        return ret;
    }

    public Aula getAula(int i) {
        Aula a = this.aules.get(i);
        return a;
    }

    public int mida() {
        int ret = this.aules.size();
        return ret;
    }

    public boolean esBuit() {
        boolean ret = this.aules.isEmpty();
        return ret;
    }

    public void printAulesLong() {
        for (int i = 0; i < this.aules.size(); i++) {
            this.aules.get(i).printAula();
        }
    }

    public void printAules() {
        System.out.println(" Aules:");
        for (int i = 0; i < this.aules.size(); i++) {
            System.out.println("  codi: " + this.aules.get(i).getCodi() + ", capacitat: " + this.aules.get(i).getCapacitat());
        }
    }

}
