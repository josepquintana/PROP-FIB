package domini;

public class CentreDocent
{
    private String nomCentre;
    private PeriodeLectiu periodeLectiu;
    private JornadaLectiva jornadaLectiva;
    private Aules aules;
    private PlansDeEstudis plansDeEstudis;

    public CentreDocent() {
        this.nomCentre      = new String();
        this.periodeLectiu  = new PeriodeLectiu();
        this.jornadaLectiva = new JornadaLectiva();
        this.aules          = new Aules();
        this.plansDeEstudis = new PlansDeEstudis();
    }

    public CentreDocent(String nomCentre, PeriodeLectiu periodeLectiu, JornadaLectiva jornadaLectiva) {
        this.nomCentre = nomCentre;
        this.periodeLectiu = new PeriodeLectiu(periodeLectiu);
        this.jornadaLectiva = new JornadaLectiva(jornadaLectiva);
        this.aules = new Aules();
        this.plansDeEstudis = new PlansDeEstudis();
    }

    /**
     * @param nomCentre
     * @param periodeLectiu
     * @param jornadaLectiva
     * @param aules
     * @param plansDeEstudis
     */
    public CentreDocent(String nomCentre, PeriodeLectiu periodeLectiu, JornadaLectiva jornadaLectiva, Aules aules, PlansDeEstudis plansDeEstudis) {
        this.nomCentre = nomCentre;
        this.periodeLectiu = new PeriodeLectiu(periodeLectiu);
        this.jornadaLectiva = new JornadaLectiva(jornadaLectiva);
        this.aules = new Aules();
        this.aules = aules;
        this.plansDeEstudis = new PlansDeEstudis();
        this.plansDeEstudis = plansDeEstudis;
    }

    public CentreDocent(CentreDocent cd) {
        this.nomCentre = cd.getNomCentre();
        this.periodeLectiu = new PeriodeLectiu(cd.getPeriodeLectiu());
        this.jornadaLectiva = new JornadaLectiva(cd.getJornadaLectiva());
        this.aules = new Aules();
        this.aules = cd.getAules();
        this.plansDeEstudis = new PlansDeEstudis();
        this.plansDeEstudis = cd.getPlansDeEstudis();
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

    public Aula getAula(String codi) {
        for (int i = 0; i < this.aules.mida(); i++) {
            if (this.aules.getAula(i).getCodi().equals(codi)) return this.aules.getAula(i);
        }
        return null;
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

    public void setNomCentre(String nomCentre) {
        this.nomCentre = new String(nomCentre);
    }

    public void setPeriodeLectiu(PeriodeLectiu periodeLectiu) {
        this.periodeLectiu = new PeriodeLectiu(periodeLectiu);
    }

    public void setJornadaLectiva(JornadaLectiva jornadaLectiva) {
        this.jornadaLectiva = new JornadaLectiva(jornadaLectiva);
    }

    public void setAules(Aules aules) {
        this.aules = new Aules();
        this.aules = aules;
    }

    public void setPlansDeEstudis(PlansDeEstudis plansDeEstudis) {
        this.plansDeEstudis = plansDeEstudis;
    }

    public void printCentreDocentLong() {
        System.out.println("\n> CentreDocent [Long Format]:\n");
        System.out.println(" nomCentre: " + this.nomCentre + "\n");
        this.periodeLectiu.printPeriodeLectiu();       System.out.println("");
        this.jornadaLectiva.printJornadaLectiva();     System.out.println("");
        this.aules.printAulesLong();                   System.out.println("");
        this.plansDeEstudis.printPlansDeEstudisLong(); System.out.println("");
    }

    public void printCentreDocent() {
        System.out.println("\n> CentreDocent:");
        System.out.println(" nomCentre: " + this.nomCentre);
        this.periodeLectiu.printPeriodeLectiu();
        this.jornadaLectiva.printJornadaLectiva();
        this.aules.printAules();
        this.plansDeEstudis.printPlansDeEstudis();
    }

    public void printCentreDocentXS() {
        System.out.println("\n> CentreDocent:");
        System.out.println(" nomCentre: " + this.nomCentre);
        this.periodeLectiu.printPeriodeLectiu();
        this.jornadaLectiva.printJornadaLectiva();
        this.aules.printAules();
        this.plansDeEstudis.printPlansDeEstudisXS();
    }
}

