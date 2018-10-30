package domini;

import java.util.ArrayList;
import java.util.Iterator;

public class PlansDeEstudis {

    private ArrayList<PlaEstudis> plansDeEstudis;
    private Iterator<PlaEstudis> it;

    public PlansDeEstudis() {
        this.plansDeEstudis = new ArrayList<>();
        this.it = new ArrayList<PlaEstudis>().iterator();
        this.it = plansDeEstudis.iterator();
    }

    public PlansDeEstudis(ArrayList<PlaEstudis> plansDeEstudis) {
        this.plansDeEstudis = new ArrayList<>();
        this.plansDeEstudis = plansDeEstudis;
        this.it = new ArrayList<PlaEstudis>().iterator();
        this.it = plansDeEstudis.iterator();
    }

    public boolean existeixPlaEstudis(PlaEstudis pe) {
        for (int i = 0; i < this.plansDeEstudis.size(); i++) {
            if(this.plansDeEstudis.get(i).equal(pe)) return true;
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

    public boolean modificarPlaEstudis(PlaEstudis pe) {
        // no es pot -> s'ha de eliminar i crear amb els nous parametres
        return false;
    }

    public PlaEstudis getPlaEstudis(int i) {
        return this.plansDeEstudis.get(i);
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
            this.plansDeEstudis.get(i).printPlaEstudis(); System.out.println("");
        }
    }

    public void printPlansDeEstudis() {
        System.out.println("lsddmnd PlansDeEstudis:");
        for (int i = 0; i < this.plansDeEstudis.size(); i++) {
            System.out.println("  nomPlaEstudis: " + this.plansDeEstudis.get(i).getNomPla() + "\t Titulacio: " + this.plansDeEstudis.get(i).getTitulacio().getNomTitulacio());
        }
    }

}
