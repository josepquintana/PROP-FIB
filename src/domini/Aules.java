package domini;

import java.util.ArrayList;
import java.util.Iterator;

public class Aules
{
    private ArrayList<Aula> aules;
    private Iterator<Aula> it;

    public Aules() {
        this.aules = new ArrayList<>();
        this.it = new ArrayList<Aula>().iterator();
        this.it = aules.iterator();
    }

    public Aules(ArrayList<Aula> aules) {
        this.aules = new ArrayList<>();
        this.aules = aules;
        this.it = new ArrayList<Aula>().iterator();
        this.it = this.aules.iterator();
    }

    public Aules(Aules aules) {
        this.aules = new ArrayList<>();
        this.aules = aules.getAules();
        this.it = new ArrayList<Aula>().iterator();
        this.it = this.aules.iterator();
    }

    public boolean existeixAula(Aula aula) {
        for (int i = 0; i < this.aules.size(); i++) {
            if (this.aules.get(i).equals(aula)) return true;
        }
        return false;
    }

    public boolean afegirAula(Aula a) throws MyException{
        if(existeixAula(a)) {
            System.out.println(">>> afegirAula(): L'aula " + a.getCodi() + " ja existeix al sistema");
            return false;
        }
        boolean ret = this.aules.add(a);
        if(!ret) throw new MyException(">>> Error: Aula no afegida"); // ¿ pot passar ?
        return ret;
    }

    public boolean eliminarAula(Aula a) {
        boolean ret = this.aules.remove(a);
        if(!ret) System.out.println(">>> eliminarAula(): L'aula " + a.getCodi() + " no existeix al sistema");
        return ret;
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
        return this.aules.get(i);
    }

    public Aula getAula(String codi) {
        for (int i = 0; i < this.aules.size(); i++) {
            if (this.aules.get(i).getCodi().equals(codi)) return this.aules.get(i);
        }
        return null;
    }

    public ArrayList<Aula> getAules() {
        return this.aules;
    }

    public void setAules(ArrayList<Aula> aules) {
        this.aules = new ArrayList<>();
        this.aules = aules;
    }

    public int mida() {
        return this.aules.size();
    }

    public boolean esBuit() {
        return this.aules.isEmpty();
    }

    public void printAulesLong() {
        System.out.println(" Aules: [Long Format]");
        for (int i = 0; i < this.aules.size(); i++) {
            this.aules.get(i).printAula();
        }
    }

    public void printAules() {
        System.out.print(" Aules:");
        for (int i = 0; i < this.aules.size(); i++) {
            if (i % 11 == 0) System.out.print("\n  ");                              // for indentation purposes
            System.out.print(this.aules.get(i).getCodi());                          // print codiAula
            if (i < this.aules.size() - 1) System.out.print(", ");                  // for presentation purposes
            if (this.aules.get(i).getCodi().length() == 5) System.out.print(" ");   // for indentation purposes
        }
        System.out.println("");
    }

}
