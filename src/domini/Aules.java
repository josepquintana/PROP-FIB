package domini;

import java.util.ArrayList;
import java.util.Iterator;

public class Aules
{
    private ArrayList<Aula> aules;

    public Aules() {
        this.aules = new ArrayList<>();
    }

    public Aules(ArrayList<Aula> aules) throws CloneNotSupportedException {
        this.aules = new ArrayList<>(aules);
    }

//    public Aules(ArrayList<Aula> aules) throws CloneNotSupportedException {
//        this.aules = new ArrayList<>();
//        Iterator<Aula> it = aules.iterator();
//        while(it.hasNext()) {
//            // Add a clone of object i
//            this.aules.add((Aula) it.next().clone());
//        }
//    }

    public Aules(Aules aules) {
        this.aules = new ArrayList<>();
        this.aules = aules.getAules();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Aules aulesCloned = new Aules();
        try {
            for(int i = 0; i < this.aules.size(); ++i) {
                aulesCloned.aules.add((Aula) this.aules.get(i).clone());
            }
        }
        catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return aulesCloned;
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
                this.aules.get(i).setCodi(newCodi);
                return true;
            }
        }
        return false;
    }

    public boolean modificarAula(Aula a, int newCapacitat) {
        for(int i = 0; i < this.aules.size(); ++i) {
            if(this.aules.get(i).equals(a)) {
                this.aules.get(i).setCapacitat(newCapacitat);
                return true;
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

   /* public void setAules(ArrayList<Aula> aules) {
        this.aules = new ArrayList<>();
        this.aules = aules;
    }*/

    public int mida() {
        return this.aules.size();
    }

    public boolean esBuit() {
        return this.aules.isEmpty();
    }

    public void printAulesLong(int indentation) {
        if (indentation == 1) System.out.println(" Aules: [Long Format]");
        if (indentation == 3) System.out.println("   Aules: [Long Format]");
        for (int i = 0; i < this.aules.size(); i++) {
            this.aules.get(i).printAulaLong(indentation);
        }
    }

    public void printAules(int indentation) {                                       //int indentation: blank sapces depend on calling method
        if (indentation == 1) System.out.print(" Aules:");
        if (indentation == 3) System.out.print("   Aules:");
        for (int i = 0; i < this.aules.size(); i++) {
            if (i % 11 == 0 && indentation == 1) System.out.print("\n  ");          // for indentation purposes (1)
            if (i % 11 == 0 && indentation == 3) System.out.print("\n    ");        // for indentation purposes (1)
            System.out.print(this.aules.get(i).getCodi());                          // print codiAula
            if (i < this.aules.size() - 1) System.out.print(", ");                  // for presentation purposes
            if (this.aules.get(i).getCodi().length() == 5) System.out.print(" ");   // for indentation purposes
        }
        System.out.print("\n");
    }

    public void printAulesXS(int indentation) {                                     //int indentation: blank sapces depend on calling method
        if (indentation == 1) System.out.print(" Aules:");
        if (indentation == 3) System.out.print("   Aules:");
        for (int i = 0; i < this.aules.size(); i++) {
            if (i % 11 == 0) System.out.print("\n    ");                            // for indentation purposes
            System.out.print(this.aules.get(i).getCodi());                          // print codiAula
            if (i < this.aules.size() - 1) System.out.print(", ");                  // for presentation purposes
            if (this.aules.get(i).getCodi().length() == 5) System.out.print(" ");   // for indentation purposes
        }
        System.out.print("\n");
    }

}
