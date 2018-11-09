package domini;

public class CentreDocent
{
    private String nomCentre;
    private PeriodeLectiu periodeLectiu;
    private JornadaLectiva jornadaLectiva;
    private PlansDeEstudis plansDeEstudis;

    public CentreDocent() {
        this.nomCentre      = new String();
        this.periodeLectiu  = new PeriodeLectiu();
        this.jornadaLectiva = new JornadaLectiva();
        this.plansDeEstudis = new PlansDeEstudis();
    }

    public CentreDocent(String nomCentre, PeriodeLectiu periodeLectiu, JornadaLectiva jornadaLectiva) {
        this.nomCentre = nomCentre;
        this.periodeLectiu = new PeriodeLectiu(periodeLectiu);
        this.jornadaLectiva = new JornadaLectiva(jornadaLectiva);
        this.plansDeEstudis = new PlansDeEstudis();
    }

    /**
     * @param nomCentre
     * @param periodeLectiu
     * @param jornadaLectiva
     * @param plansDeEstudis
     */
    public CentreDocent(String nomCentre, PeriodeLectiu periodeLectiu, JornadaLectiva jornadaLectiva, PlansDeEstudis plansDeEstudis) {
        this.nomCentre = nomCentre;
        this.periodeLectiu = new PeriodeLectiu(periodeLectiu);
        this.jornadaLectiva = new JornadaLectiva(jornadaLectiva);
        this.plansDeEstudis = new PlansDeEstudis(plansDeEstudis);
    }

    public CentreDocent(CentreDocent cd) {
        this.nomCentre = cd.getNomCentre();
        this.periodeLectiu = new PeriodeLectiu(cd.getPeriodeLectiu());
        this.jornadaLectiva = new JornadaLectiva(cd.getJornadaLectiva());
        this.plansDeEstudis = new PlansDeEstudis();
        this.plansDeEstudis = cd.getPlansDeEstudis();
    }

    public boolean afegirPlaEstudis(PlaEstudis pe) {
        return this.plansDeEstudis.afegirPlaEstudis(pe);
    }

    public boolean eliminarPlaEstudis(PlaEstudis pe) {
        return this.plansDeEstudis.eliminarPlaEstudis(pe);
    }

    public boolean afegirAssignaturaAlPlaEstudis(String nomPla, Assignatura a) {
        return this.plansDeEstudis.getPlaEstudis(nomPla).afegirAssignaturaAlPlaEstudis(a);
    }

    public boolean elimnarAssignaturaDelPlaEstudis(String nomPla, Assignatura a) {
        return this.plansDeEstudis.getPlaEstudis(nomPla).eliminarAssignaturaDelPlaEstudis(a);
    }

    public boolean afegirAulaAlPlaEstudis(String nomPla, Aula a) throws MyException {
        return this.plansDeEstudis.getPlaEstudis(nomPla).afegirAulaAlPlaEstudis(a);
    }

    public boolean elimnarAulaDelPlaEstudis(String nomPla, Aula a) throws MyException {
        return this.plansDeEstudis.getPlaEstudis(nomPla).eliminarAulaDelPlaEstudis(a);
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

    public Aules getTotesLesAules() throws MyException {
        Aules aules = new Aules();
        for (int i = 0; i < this.plansDeEstudis.mida(); i++) {
            aules.afegirAula(this.plansDeEstudis.getPlaEstudis(i).getAula(i));
        }
        return aules;
    }

    public Aula getAulaDelPlaEstudis(String nomPla, String codi) {
        return this.plansDeEstudis.getPlaEstudis(nomPla).getAula(codi);
    }

    public PlansDeEstudis getPlansDeEstudis() {
        return this.plansDeEstudis;
    }

    public PlaEstudis getPlaEstudis(String nomPla) {
        for (int i = 0; i < this.plansDeEstudis.mida(); i++) {
            if (this.plansDeEstudis.getPlaEstudis(i).getNomPla().equals(nomPla)) return this.plansDeEstudis.getPlaEstudis(i);
        }
        return null;
    }

    public PlaEstudis getPlaEstudis(int i) {
        return this.plansDeEstudis.getPlaEstudis(i);
    }

    public void setNomCentre(String nomCentre) {
        this.nomCentre = new String(nomCentre);
    }

    public void setPeriodeLectiu(PeriodeLectiu periodeLectiu) {
        this.periodeLectiu = new PeriodeLectiu(periodeLectiu);
    }

    public void setJornadaLectiva(JornadaLectiva jornadaLectiva) {
        this.jornadaLectiva = new JornadaLectiva(jornadaLectiva);
    }

    public void setPlansDeEstudis(PlansDeEstudis plansDeEstudis) {
        this.plansDeEstudis = plansDeEstudis;
    }

    public void printCentreDocentLong() throws MyException {
        System.out.println("\n> CentreDocent [Long Format]:\n");
        System.out.println(" nomCentre: " + this.nomCentre + "\n");
        this.periodeLectiu.printPeriodeLectiu();       System.out.println("");
        this.jornadaLectiva.printJornadaLectiva();     System.out.println("");
        this.getTotesLesAules().printAulesLong();      System.out.println("");
        this.plansDeEstudis.printPlansDeEstudisLong(); System.out.println("");
    }

    public void printCentreDocent() throws MyException {
        System.out.println("\n> CentreDocent:");
        System.out.println(" nomCentre: " + this.nomCentre);
        this.periodeLectiu.printPeriodeLectiu();
        this.jornadaLectiva.printJornadaLectiva();
        this.getTotesLesAules().printAules();
        this.plansDeEstudis.printPlansDeEstudis();
    }

    public void printCentreDocentXS() throws MyException {
        System.out.println("\n> CentreDocent:");
        System.out.println(" nomCentre: " + this.nomCentre);
        this.periodeLectiu.printPeriodeLectiu();
        this.jornadaLectiva.printJornadaLectiva();
        this.getTotesLesAules().printAules();
        this.plansDeEstudis.printPlansDeEstudisXS();
    }
}

