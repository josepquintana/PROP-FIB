package domini;

import java.util.ArrayList;
import java.util.Iterator;

public class PlaEstudis implements Cloneable
{
    private String nomPla;
    private double credits;
    private JornadaLectiva jornadaLectiva;
    private Titulacio titulacio;
    private Assignatures assignatures;
    private Aules aules; //// aules per cada pla de estudis
    private Horari horari;

    public PlaEstudis() {
        nomPla = new String();
        credits = 0;
        jornadaLectiva = new JornadaLectiva();
        titulacio = new Titulacio();
        assignatures = new Assignatures();
        aules = new Aules();
    }

    public PlaEstudis(String nomPla, JornadaLectiva jornadaLectiva, Titulacio titulacio) {
        this.nomPla = nomPla;
        this.credits = 0;
        this.jornadaLectiva = new JornadaLectiva(jornadaLectiva);
        this.titulacio = new Titulacio(titulacio);
        this.assignatures = new Assignatures();
        this.aules = new Aules();
        this.horari = new Horari(jornadaLectiva);
    }

    public PlaEstudis(PlaEstudis pe) {
        this.nomPla = pe.getNomPla();
        this.credits = pe.getCredits();
        this.jornadaLectiva = pe.getJornadaLectiva();
        this.titulacio = new Titulacio(pe.getTitulacio());
        this.assignatures = new Assignatures(pe.getAssignaturesDelPlaEstudis());
        this.aules = new Aules(pe.aules);
        this.horari = new Horari(pe.getHorari());
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        PlaEstudis pe = new PlaEstudis();
        try {
            pe = (PlaEstudis) super.clone();

            // tractar mutable fields
            pe.setJornadaLectiva((JornadaLectiva) this.getJornadaLectiva().clone());
            pe.setTitulacio((Titulacio) this.getTitulacio().clone());
            pe.setAssignatures((Assignatures) this.getAssignaturesDelPlaEstudis().clone());
            pe.setAules((Aules) this.getAules().clone());
//            pe.setHorari((Horari) this.getHorari().clone(pe.getJornadaLectiva())); // de moment es pot clonar el horari

        }
        catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        return pe;
    }

    public boolean existeixAssignaturaAlPlaEstudis(Assignatura a) {
        return this.assignatures.existeixAssignatura(a);
    }

    public boolean afegirAssignaturaAlPlaEstudis(Assignatura a) {
        boolean ret = this.assignatures.afegirAssignatura(a);
        if(ret) this.credits += a.getCredits();
        return ret;
    }

    public boolean eliminarAssignaturaDelPlaEstudis(Assignatura a) {
        boolean ret = this.assignatures.eliminarAssignatura(a);
        if(ret) this.credits -= a.getCredits();
        return ret;
    }

    public boolean afegirAulaAlPlaEstudis(Aula a) throws MyException{
        boolean ret = this.aules.afegirAula(a);
        return ret;
    }

    public boolean eliminarAulaDelPlaEstudis(Aula a) throws MyException {
        boolean ret = this.aules.eliminarAula(a);
        return ret;
    }

    public boolean equals(PlaEstudis pe) {
        if (this.nomPla.equals(pe.getNomPla()) && this.titulacio.equals(pe.getTitulacio())) return true;
        return false;
    }

    public String getNomPla() {
        return this.nomPla;
    }

    public double getCredits() {
        return this.credits;
    }

    public JornadaLectiva getJornadaLectiva() {
        return this.jornadaLectiva;
    }

    public Titulacio getTitulacio() {
        return this.titulacio;
    }

    public Assignatures getAssignaturesDelPlaEstudis() {
        return this.assignatures;
    }

   public ArrayList<Assignatura> getAssignaturesAL() {
        return this.assignatures.getAssignatures();
   }

    public Assignatura getAssignatura(int i) {
        return this.assignatures.getAssignatura(i);
    }

    public Assignatura getAssignatura(String codi) {
        for (int i = 0; i < this.assignatures.mida(); i++) {
            if(this.assignatures.getAssignatura(i).getCodi().equals(codi)) return this.assignatures.getAssignatura(i);
        }
        return null;
    }

    public Aules getAules() {
        return this.aules;
    }

    public Aula getAula(int i) {
        return this.aules.getAula(i);
    }

    public Aula getAula(String codi) {
        for (int i = 0; i < this.aules.mida(); i++) {
            if(this.aules.getAula(i).getCodi().equals(codi)) return this.aules.getAula(i);
        }
        return null;
    }

    public Horari getHorari() {
        return this.horari;
    }

    public boolean hiHaAssignatures() {
        return this.assignatures.esBuit();
    }

    public int quantesAssignatures() {
        return this.assignatures.mida();
    }

    public boolean hiHiAules() {
        return this.aules.esBuit();
    }

    public int quantesAules() {
        return this.aules.mida();
    }

    public void setNomPla(String nomPla) {
        this.nomPla = nomPla;
    }

    public void setCredits() {
        // funcio inutil...
        this.calculaCredits();
    }

    public void setJornadaLectiva(JornadaLectiva jornadaLectiva) {
        this.jornadaLectiva = jornadaLectiva;
    }

    public void setTitulacio(Titulacio titulacio) {
        this.titulacio = titulacio;
    }

    public void setAssignatures(Assignatures assignatures) {
        this.assignatures = assignatures;
        this.calculaCredits();
    }

    public void setAules(Aules aules) {
        this.aules = aules;
    }

    public void setHorari(Horari horari) {
        this.horari = horari;
    }

    public void calculaCredits() {
        this.credits = 0;
        for(int i = 0; i < this.assignatures.mida(); i++){
            this.credits += this.assignatures.getAssignatura(i).getCredits();
        }
    }

    public void generateHorari() throws MyException, CloneNotSupportedException {
        this.horari = new Horari(this.jornadaLectiva);
        this.horari.GenerarHorari(this);
    }

}
