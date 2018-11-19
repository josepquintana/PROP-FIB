package domini;

public class ControladorDomini implements Cloneable
{
    private String nomCentre;
    private PeriodeLectiu periodeLectiu;
    private JornadaLectiva jornadaLectiva;
    private PlansDeEstudis plansDeEstudis;

    public ControladorDomini() {
        this.nomCentre      = new String();
        this.periodeLectiu  = new PeriodeLectiu();
        this.jornadaLectiva = new JornadaLectiva();
        this.plansDeEstudis = new PlansDeEstudis();
    }

    public ControladorDomini(String nomCentre, PeriodeLectiu periodeLectiu, JornadaLectiva jornadaLectiva) {
        this.nomCentre = nomCentre;
        this.periodeLectiu = new PeriodeLectiu(periodeLectiu);
        this.jornadaLectiva = new JornadaLectiva(jornadaLectiva);
        this.plansDeEstudis = new PlansDeEstudis();
    }

    public ControladorDomini(String nomCentre, PeriodeLectiu periodeLectiu, JornadaLectiva jornadaLectiva, PlansDeEstudis plansDeEstudis) {
        this.nomCentre = nomCentre;
        this.periodeLectiu = new PeriodeLectiu(periodeLectiu);
        this.jornadaLectiva = new JornadaLectiva(jornadaLectiva);
        this.plansDeEstudis = new PlansDeEstudis(plansDeEstudis);
    }

    public ControladorDomini(ControladorDomini cd) {
        this.nomCentre = cd.getNomCentre();
        this.periodeLectiu = new PeriodeLectiu(cd.getPeriodeLectiu());
        this.jornadaLectiva = new JornadaLectiva(cd.getJornadaLectiva());
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

    public Aules getTotesLesAules() throws MyException {
        Aules aules = new Aules();
        for (int i = 0; i < this.plansDeEstudis.mida(); i++) {
            for (int j = 0; j < this.plansDeEstudis.getPlaEstudis(i).getAules().mida(); j++) {
                aules.afegirAula(this.plansDeEstudis.getPlaEstudis(i).getAula(j));
            }
        }
        return aules;
    }

    private void printIndentation(int size) {
        int n_spaces = 20 - size;
        String spaces = "";
        for (int i = 0; i < n_spaces; i++) { spaces += " "; }
        System.out.print(spaces);
    }

    private void printDiaHorari(Horari horari, int d) {
        for (int h = 0; h < horari.getHores(); h++) {
            String h0s = Integer.toString(h + horari.getHIni());
            String h1s = Integer.toString(h + horari.getHIni() +1);
            if (h0s.length() < 2) h0s = "0" + h0s;
            if (h1s.length() < 2) h1s = "0" + h1s;
            String str = "  " + h0s + " - " + h1s + "h";
            System.out.print(str + "   ");
            for (int i = 0; i < horari.getHoraLectiva(d,h).mida(); i++) {
                String s = horari.getHoraLectiva(d,h).getAssignacio(i).getAssignacioPrintFormat();
                System.out.print(s);
                this.printIndentation(s.length());
            }
            System.out.print("\n");
        }
    }

    public void printHorari(int numPla) throws CloneNotSupportedException {
        Horari horari = (Horari) this.plansDeEstudis.getPlaEstudis(numPla).getHorari().clone(this.jornadaLectiva);

        System.out.println(    "  >>>>>                              D  I  L  L  U  N  S                              <<<<<\n");
        this.printDiaHorari(horari, 0);
        System.out.println("\n\n  >>>>>                              D  I  M  A  R  T  S                              <<<<<\n");
        this.printDiaHorari(horari,1);
        System.out.println("\n\n  >>>>>                             D  I  M  E  C  R  E  S                            <<<<<\n");
        this.printDiaHorari(horari,2);
        System.out.println("\n\n  >>>>>                               D  I  J  O  U  S                                <<<<<\n");
        this.printDiaHorari(horari,3);
        System.out.println("\n\n  >>>>>                            D  I  V  E  N  D  R  E  S                          <<<<<\n");
        this.printDiaHorari(horari,4);
    }


}

