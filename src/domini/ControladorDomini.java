package domini;

public class ControladorDomini implements Cloneable
{
    private String nomCentre;
    private PeriodeLectiu periodeLectiu;
    private JornadaLectiva jornadaLectiva;
    private Aules aules;
    private PlansDeEstudis plansDeEstudis;
    private Horari horari;

    public ControladorDomini() {
        this.nomCentre      = new String();
        this.periodeLectiu  = new PeriodeLectiu();
        this.jornadaLectiva = new JornadaLectiva();
        this.aules          = new Aules();
        this.plansDeEstudis = new PlansDeEstudis();
    }

    public ControladorDomini(String nomCentre, PeriodeLectiu periodeLectiu, JornadaLectiva jornadaLectiva) {
        this.nomCentre      = nomCentre;
        this.periodeLectiu  = new PeriodeLectiu(periodeLectiu);
        this.jornadaLectiva = new JornadaLectiva(jornadaLectiva);
        this.aules          = new Aules();
        this.plansDeEstudis = new PlansDeEstudis();
    }

    public ControladorDomini(String nomCentre, PeriodeLectiu periodeLectiu, JornadaLectiva jornadaLectiva, Aules aules, PlansDeEstudis plansDeEstudis) {
        this.nomCentre      = nomCentre;
        this.periodeLectiu  = new PeriodeLectiu(periodeLectiu);
        this.jornadaLectiva = new JornadaLectiva(jornadaLectiva);
        this.aules          = new Aules(aules);
        this.plansDeEstudis = new PlansDeEstudis(plansDeEstudis);
    }

    public ControladorDomini(ControladorDomini cd) {
        this.nomCentre = cd.getNomCentre();
        this.periodeLectiu = new PeriodeLectiu(cd.getPeriodeLectiu());
        this.jornadaLectiva = new JornadaLectiva(cd.getJornadaLectiva());
        this.aules          = new Aules();
        this.aules          = cd.getAules();
        this.plansDeEstudis = new PlansDeEstudis();
        this.plansDeEstudis = cd.getPlansDeEstudis();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        ControladorDomini cd = new ControladorDomini();
        try {
            cd = (ControladorDomini) super.clone();

            // mutable methods!
            cd.setPeriodeLectiu((PeriodeLectiu) this.getPeriodeLectiu().clone());
            cd.setJornadaLectiva((JornadaLectiva) this.getJornadaLectiva().clone());
            cd.setAules((Aules) this.getAules().clone());
            cd.setPlansDeEstudis((PlansDeEstudis) this.getPlansDeEstudis().clone());
        }
        catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return cd;
    }

    public void readInputFile(String filename) throws Exception {
        ReadInputFile.main(this, filename);
    }

    public void generateHorariPlaEstudis(String nomPla) throws MyException, CloneNotSupportedException {
        Horari horari = this.getPlansDeEstudis().getPlaEstudis(nomPla).getHorari();
//        horari.GenerarHorari(this.getPlaEstudis(nomPla).getAssignaturesDelPlaEstudis(), this.getAules());
    }

    public void generateHorariPlaEstudis(int numPla) throws MyException, CloneNotSupportedException {
        horari = new Horari(this.getPlaEstudis(numPla).getJornadaLectiva(), this.aules.mida());
        horari.generarHorari(this.getPlaEstudis(numPla).getAssignatures(), this.aules);
    }

    public boolean afegirPlaEstudis(PlaEstudis pe) {
        return this.plansDeEstudis.afegirPlaEstudis(pe);
    }

    public boolean eliminarPlaEstudis(PlaEstudis pe) {
        return this.plansDeEstudis.eliminarPlaEstudis(pe);
    }

    public boolean afegirAula(Aula a) throws MyException { return this.aules.afegirAula(a); }

    public boolean eliminarAula(Aula a) throws MyException { return this.aules.eliminarAula(a); }

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

    public String getNomCentre() {
        return this.nomCentre;
    }

    public PeriodeLectiu getPeriodeLectiu() {
        return this.periodeLectiu;
    }

    public JornadaLectiva getJornadaLectiva() {
        return this.jornadaLectiva;
    }

    public void setAules(Aules aules) {
        this.aules = aules;
    }

    public Aules getAules() {
        return aules;
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

    public void printCentreDocentLong() throws MyException {
        System.out.println("\n> CentreDocent [Long Format]:\n");
        System.out.println(" nomCentre: " + this.nomCentre + "\n");
        this.periodeLectiu.printPeriodeLectiu();                System.out.println("");
        this.jornadaLectiva.printJornadaLectivaLong();          System.out.println("");
        this.aules.printAulesLong(1);    System.out.println("");
        this.plansDeEstudis.printPlansDeEstudisLong();          System.out.println("");
        System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n\n");
    }

    public void printCentreDocent() throws MyException {
        System.out.println("\n> CentreDocent:");
        System.out.println(" nomCentre: " + this.nomCentre);
        this.periodeLectiu.printPeriodeLectiu();
        this.jornadaLectiva.printJornadaLectivaLong();
        this.aules.printAules(1);
        this.plansDeEstudis.printPlansDeEstudis();
        System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n\n");
    }

    public void printHorari(int numPla) throws CloneNotSupportedException {

        for (int i = 0; i < this.horari.getDies(); i++) {
            for (int j = 0; j < this.horari.getHores(); j++) {
                for (int k = 0; k < this.horari.getN_aules(); k++) {
                    System.out.print("Horari[" + i + "][" + j + "][" + k + "] \t = ");
                    if(null != horari.getAssignacioIJK(i,j,k)) horari.getAssignacioIJK(i,j,k).printAssignacio();
                    else System.out.println("[none]");
                }
            }
        }
    }





}

