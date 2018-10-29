package domini;

import java.util.ArrayList;

public class PlaEstudis
{
    private String nomPla;
    private int creditsObligatoris;
    private int creditsOptatius;
    private Ass assignatures;

    public PlaEstudis(String nomPla) {
        this.nomPla = nomPla;
        this.creditsObligatoris = 0;
        this.creditsOptatius = 0;
        this.assignatures = new ArrayList<Assignatura>();
    }

    public PlaEstudis(String nomPla, int credOblig, int credOpt) {
        this.nomPla = nomPla;
        this.creditsObligatoris = credOblig;
        this.creditsOptatius = credOpt;
        this.assignatures = new ArrayList<Assignatura>();
    }

    public PlaEstudis(String nomPla, int credOblig, int credOpt, ArrayList<Assignatura> assignatures) {
        this.nomPla = nomPla;
        this.creditsObligatoris = credOblig;
        this.creditsOptatius = credOpt;
        this.assignatures = assignatures;
    }

    public PlaEstudis(PlaEstudis pe) {
        this.nomPla = pe.getNomPla();
        this.creditsObligatoris = pe.getCreditsObligatoris();
        this.creditsOptatius = pe.getCreditsOptatius();
    }

    public afegirAssignaturaAlPlaEstudis(Assignatura a) {

    }

    public eliminarAssignaturaDelPlaEstudis(Assignatura) {

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

    public ArrayList<Assignatura> getAssignatures() {
        return this.assignatures;
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

    public void setAssignatures(ArrayList<Assignatura> assignatures) {
        this.assignatures = assignatures;
    }

    public void printPlaEstudis() {
        System.out.println("\n> Pla Estudis;");
        System.out.println(" nomPla      : " + this.nomPla);
        System.out.println(" creditsOblig: " + this.creditsObligatoris);
        System.out.println(" creditsOptat: " + this.creditsOptatius);
    }
}
