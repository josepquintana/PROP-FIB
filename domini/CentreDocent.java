package domini;


import org.jetbrains.annotations.NotNull;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class CentreDocent
{
    private String nomCentre;
    private PeriodeLectiu periodeLectiu;
    private JornadaLectiva jornadaLectiva;
    private Aules aules;
    private PlaEstudis plaEstudis;

    public CentreDocent(String nomCentre)
    {
        this.nomCentre = nomCentre;
        this.periodeLectiu = new PeriodeLectiu();
        this.jornadaLectiva = new JornadaLectiva();
        this.aules = new Aules();
    }

    /**
     * @param nomCentre
     * @param periodeLectiu
     * @param jornadaLectiva
     */
    public CentreDocent(String nomCentre, PeriodeLectiu periodeLectiu, JornadaLectiva jornadaLectiva) {
        this.nomCentre = nomCentre;
        this.periodeLectiu = new PeriodeLectiu(periodeLectiu);
        this.jornadaLectiva = new JornadaLectiva(jornadaLectiva);
        this.aules = new Aules();
    }

    public CentreDocent(@NotNull CentreDocent cd) {
        this.nomCentre = cd.getNomCentre();
        this.periodeLectiu = new PeriodeLectiu(cd.getPeriodeLectiu());
        this.jornadaLectiva = new JornadaLectiva(cd.getJornadaLectiva());
    }

    public void assignarAulaAlCentreDocent(Aula aula) throws MyException {
        this.aules.afegirAula(aula);
    }

    public void desassignarAulaDelCentreDocent(Aula aula) throws MyException{
        this.aules.eliminarAula(aula);
    }

    public boolean modificarAulaDelCentreDocent(Aula aula, String newCodi) {
        boolean ret = this.aules.modificarAula(aula, newCodi);
        return ret;
    }

    public boolean modificarAulaDelCentreDocent(Aula aula, int newCapacitat) {
        boolean ret = this.aules.modificarAula(aula, newCapacitat);
        return ret;
    }

    public String getNomCentre() {
        return this.nomCentre;
    }

    public PeriodeLectiu getPeriodeLectiu() {
        return this.periodeLectiu;
    }

    public JornadaLectiva getJornadaLectiva() {
        return this.jornadaLectiva;
    }

    public Aules getAules() { return this.aules; }

    public void setNomCentre(String nomCentre) {
        this.nomCentre = new String(nomCentre);
    }

    public void setPeriodeLectiu(PeriodeLectiu periodeLectiu) {
        this.periodeLectiu = new PeriodeLectiu(periodeLectiu);
    }

    public void setJornadaLectiva(JornadaLectiva jornadaLectiva) {
        this.jornadaLectiva = new JornadaLectiva(jornadaLectiva);
    }

    public void printCentreDocent() {
        System.out.println("\n> CentreDocent:");
        System.out.println(" nomCentre: " + this.nomCentre);
        this.periodeLectiu.printPeriodeLectiu();
        this.jornadaLectiva.printJornadaLectiva();
        this.aules.printAules();
    }
}
