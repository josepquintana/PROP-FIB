package domini;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class PlaEstudis
{
    private String nomPla;
    private int creditsObligatoris;
    private int creditsOptatius;
    private Assignatures assignatures;
    private Titulacio titulacio;

    public PlaEstudis() {
        nomPla = "";
        creditsObligatoris = 0;
        creditsOptatius = 0;
        assignatures = new Assignatures();
        titulacio = new Titulacio();
    }

    public PlaEstudis(String nomPla) {
        this.nomPla = nomPla;
        this.creditsObligatoris = 0;
        this.creditsOptatius = 0;
        this.assignatures = new Assignatures();
        this.titulacio = new Titulacio();
    }

    public PlaEstudis(String nomPla, int credOblig, int credOpt) {
        this.nomPla = nomPla;
        this.creditsObligatoris = credOblig;
        this.creditsOptatius = credOpt;
        this.assignatures = new Assignatures();
        this.titulacio = new Titulacio();
    }

    public PlaEstudis(String nomPla, int credOblig, int credOpt, Assignatures assignatures, Titulacio titulacio) {
        this.nomPla = nomPla;
        this.creditsObligatoris = credOblig;
        this.creditsOptatius = credOpt;
        this.assignatures = new Assignatures();
        this.assignatures = assignatures;
        this.titulacio = new Titulacio();
        this.titulacio = titulacio;
    }

    public PlaEstudis(@NotNull PlaEstudis pe) {
        this.nomPla = pe.getNomPla();
        this.creditsObligatoris = pe.getCreditsObligatoris();
        this.creditsOptatius = pe.getCreditsOptatius();
        this.assignatures = pe.getAssignatures();
        this.titulacio = pe.getTitulacio();
    }

    public boolean existeixAssignatura(Assignatura a) {
        return this.assignatures.existeixAssignatura(a);
    }

    public boolean afegirAssignaturaAlPlaEstudis(Assignatura a) {
        return this.assignatures.afegirAssignatura(a);
    }

    public boolean eliminarAssignaturaDelPlaEstudis(Assignatura a) {
        return this.assignatures.eliminarAssignatura(a);
    }

    public boolean equal(PlaEstudis pe) {
        if (this.nomPla.equals(pe.getNomPla()) && this.titulacio.equals(pe.getTitulacio())) return true;
        return false;
    }

    public String getNomPla() {
        return this.nomPla;
    }

    public int getCreditsObligatoris() {
        return this.creditsObligatoris;
    }

    public int getCreditsOptatius() {
        return this.creditsOptatius;
    }

    public Assignatures getAssignatures() {
        return this.assignatures;
    }

    public Titulacio getTitulacio() {
        return this.titulacio;
    }

    public Assignatura getAssignatura(int i) {
        return this.assignatures.getAssignatura(i);
    }

    public boolean hiHaAssignatures() {
        return this.assignatures.esBuit();
    }

    public int quantesAssignatures() {
        return this.assignatures.mida();
    }

    public void setNomPla(String nomPla) {
        this.nomPla = nomPla;
    }

    public void setCreditsObligatoris(int creditsObligatoris) {
        this.creditsObligatoris = creditsObligatoris;
    }

    public void setCreditsOptatius(int creditsOptatius) {
        this.creditsOptatius = creditsOptatius;
    }

    public void setAssignatures(Assignatures assignatures) {
        this.assignatures = assignatures;
    }

    public void setTitulacio(Titulacio titulacio) {
        this.titulacio = titulacio;
    }

    public void printPlaEstudis() {
        System.out.println("\n> Pla Estudis;");
        System.out.println(" nomPla      : " + this.nomPla);
        System.out.println(" creditsOblig: " + this.creditsObligatoris);
        System.out.println(" creditsOptat: " + this.creditsOptatius);
        this.assignatures.printAssignatures();
        this.titulacio.printTitulacio();
    }
}
