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

    public boolean afegirPlaEstudis(PlaEstudis pe) throws MyException{
        if(existeixPlaEstudis(pe)) {
            throw new MyException("El Pla d'Estudis " + pe.getNomPla() + " ja existeix al sistema");
        }
        boolean ret = this.plansDeEstudis.add(pe);
        return ret;
    }

    public boolean eliminarPlaEstudis(PlaEstudis pe) throws MyException{
        boolean ret = this.plansDeEstudis.remove(pe);
        if(!ret) throw new MyException("El Pla d'Estudis " + pe.getNomPla() + " no existeix al sistema");
        return ret;
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

}
