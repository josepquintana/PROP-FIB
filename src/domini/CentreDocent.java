package domini;

public class CentreDocent implements Cloneable
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

    @Override
    protected Object clone() throws CloneNotSupportedException {
        CentreDocent cd = new CentreDocent();
        try {
            cd = (CentreDocent) super.clone();

            // mutable methods!
            cd.setPeriodeLectiu((PeriodeLectiu) this.getPeriodeLectiu().clone());
            cd.setJornadaLectiva((JornadaLectiva) this.getJornadaLectiva().clone());
            cd.setPlansDeEstudis((PlansDeEstudis) this.getPlansDeEstudis().clone());
        }
        catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return cd;
    }

    public void generateHorariPlaEstudis(String nomPla) throws MyException, CloneNotSupportedException {
        this.plansDeEstudis.getPlaEstudis(nomPla).generateHorari();
    }

    public void generateHorariPlaEstudis(int numPla) throws MyException, CloneNotSupportedException {
        this.plansDeEstudis.getPlaEstudis(numPla).generateHorari();
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
            for (int j = 0; j < this.plansDeEstudis.getPlaEstudis(i).getAules().mida(); j++) {
                aules.afegirAula(this.plansDeEstudis.getPlaEstudis(i).getAula(j));
            }
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
        this.periodeLectiu.printPeriodeLectiu();                System.out.println("");
        this.jornadaLectiva.printJornadaLectivaLong();          System.out.println("");
        this.getTotesLesAules().printAulesLong(1);    System.out.println("");
        this.plansDeEstudis.printPlansDeEstudisLong();          System.out.println("");
        System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n\n");
    }

    public void printCentreDocent() throws MyException {
        System.out.println("\n> CentreDocent:");
        System.out.println(" nomCentre: " + this.nomCentre);
        this.periodeLectiu.printPeriodeLectiu();
        this.jornadaLectiva.printJornadaLectivaLong();
        this.getTotesLesAules().printAules(1);
        this.plansDeEstudis.printPlansDeEstudis();
        System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n\n");
    }

    public void printCentreDocentXS() throws MyException {
        System.out.println("\n> CentreDocent:");
        System.out.println(" nomCentre: " + this.nomCentre);
        this.periodeLectiu.printPeriodeLectiu();
        this.jornadaLectiva.printJornadaLectivaLong();
        this.getTotesLesAules().printAules(1);
        this.plansDeEstudis.printPlansDeEstudisXS();
        System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n\n");
    }
}

