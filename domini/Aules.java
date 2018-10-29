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
            System.out.println(">>> afegirAula(): L'aula " + a.getCodi() + " ja existeix al sistema");
            return;
        }
        boolean ret = this.aules.add(a);
        if(!ret) throw new MyException(">>> Error: Aula no afegida"); // ¿ pot passar ?
    }

    public void eliminarAula(Aula a) {
        boolean ret = this.aules.remove(a);
        if(!ret) System.out.println(">>> eliminarAula(): L'aula " + a.getCodi() + " no existeix al sistema");
    }

    public Aula eliminarAula(int i) throws MyException {
        // This class is never used!
        Aula a = this.aules.remove(i);
        if (a == null) {
            System.out.println("eliminarAula(): L'aula " + this.aules.get(i).getCodi() + " no existeix al sistema");
        }
        return a;
    }

    public boolean modificarAula(Aula a, String newCodi) {
        for(int i = 0; i < this.aules.size(); ++i) {
            if(this.aules.get(i).equals(a)) {
                boolean ret = this.aules.get(i).setCodi(newCodi);
                return ret;
            }
        }
        return false;
    }

    public boolean modificarAula(Aula a, int newCapacitat) {
        for(int i = 0; i < this.aules.size(); ++i) {
            if(this.aules.get(i).equals(a)) {
                boolean ret = this.aules.get(i).setCapacitat(newCapacitat);
                return ret;
            }
        }
        return false;
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
