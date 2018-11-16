package domini;

import java.util.ArrayList;
import java.util.Iterator;

public class PlansDeEstudis {

    private ArrayList<PlaEstudis> plansDeEstudis;

    public PlansDeEstudis() {
        this.plansDeEstudis = new ArrayList<>();
    }

    public PlansDeEstudis(ArrayList<PlaEstudis> plansDeEstudis) {
        this.plansDeEstudis = new ArrayList<>();
        this.plansDeEstudis = plansDeEstudis;
    }

    public PlansDeEstudis(PlansDeEstudis plansDeEstudis) {
        this.plansDeEstudis = new ArrayList<>();
        this.plansDeEstudis = plansDeEstudis.getPlansDeEstudis();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        PlansDeEstudis plansDeEstudisCloned = new PlansDeEstudis();
        try {
            for(int i = 0; i < this.plansDeEstudis.size(); ++i) {
                plansDeEstudisCloned.plansDeEstudis.add((PlaEstudis) this.plansDeEstudis.get(i).clone());
            }
        }
        catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return plansDeEstudisCloned;
    }

    public boolean existeixPlaEstudis(PlaEstudis pe) {
        for (int i = 0; i < this.plansDeEstudis.size(); i++) {
            if(this.plansDeEstudis.get(i).equals(pe)) return true;
        }
        return false;
    }

    public boolean afegirPlaEstudis(PlaEstudis pe) {
        if(existeixPlaEstudis(pe)) {
            System.out.println(">>> afegirPlaEstudis(): El Pla d'Estudis " + pe.getNomPla() + " ja existeix al sistema");
            return false;
        }
        boolean ret = this.plansDeEstudis.add(pe);
        return ret;
    }

    public boolean eliminarPlaEstudis(PlaEstudis pe) {
        boolean ret = this.plansDeEstudis.remove(pe);
        if(!ret) System.out.println(">>> eliminarPlaEstudis(): El Pla d'Estudis " + pe.getNomPla() + " no existeix al sistema");
        return ret;
    }

    public boolean eliminarPlaEstudis(int i) {
        PlaEstudis pe = this.plansDeEstudis.remove(i);
        if(pe == null) return false;
        return true;
    }

    public PlaEstudis getPlaEstudis(int i) {
        return this.plansDeEstudis.get(i);
    }

    public PlaEstudis getPlaEstudis(String nomPla) {
        for (int i = 0; i < this.plansDeEstudis.size(); i++) {
            if (this.plansDeEstudis.get(i).getNomPla().equals(nomPla)) return this.plansDeEstudis.get(i);
        }
        return null;
    }

    public ArrayList<PlaEstudis> getPlansDeEstudis() {
        return this.plansDeEstudis;
    }

    public void setPlansDeEstudis(ArrayList<PlaEstudis> plansDeEstudis) {
        this.plansDeEstudis = new ArrayList<>();
        this.plansDeEstudis = plansDeEstudis;
    }

    public int mida() {
        return this.plansDeEstudis.size();
    }

    public boolean esBuit() {
        return this.plansDeEstudis.isEmpty();
    }

    public void printPlansDeEstudisLong() {
        System.out.println(" Plans de Estudi: [Long Format]");
        for (int i = 0; i < this.plansDeEstudis.size(); i++) {
            this.plansDeEstudis.get(i).printPlaEstudisLong(i+1);
        }
    }

    public void printPlansDeEstudis() {
        System.out.println(" PlansDeEstudis:");
        for (int i = 0; i < this.plansDeEstudis.size(); i++) {
            this.plansDeEstudis.get(i).printPlaEstudis(i+1);
        }
    }

    public void printPlansDeEstudisXS() {
        System.out.println(" PlansDeEstudis:");
        for (int i = 0; i < this.plansDeEstudis.size(); i++) {
            this.plansDeEstudis.get(i).printPlaEstudisXS(i+1);
        }
    }

}
