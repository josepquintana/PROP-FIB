package domini;

import java.util.ArrayList;

public class Aules
{
    private ArrayList<Aula> aules;

    public Aules() {
        this.aules = new ArrayList<>();
    }

    public Aules(ArrayList<Aula> aules) throws CloneNotSupportedException {
        this.aules = new ArrayList<>(aules);
    }

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
            throw new MyException("L'aula " + a.getCodi() + " ja existeix al sistema");
        }
        boolean ret = this.aules.add(a);
        if(!ret) throw new MyException("Aula no afegida"); // ¿ pot passar ?
        return ret;
    }

    public boolean eliminarAula(Aula a) throws MyException {
        boolean ret = this.aules.remove(a);
        if(!ret) throw new MyException("L'aula " + a.getCodi() + " no existeix al sistema");
        return ret;
    }

    public boolean eliminarAula(String codi) {
        for (int i = 0; i < this.aules.size(); i++) {
            if (this.aules.get(i).getCodi().equalsIgnoreCase(codi)) { this.aules.remove(i); return true; }
        }
        return false;
    }

    public Aula eliminarAula(int i) throws MyException {
        Aula a = this.aules.remove(i);
        if (a == null) {
            throw new MyException("L'aula " + this.aules.get(i).getCodi() + " no existeix al sistema");
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

}
