package domini;

public class PlaEstudis
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

    public PlaEstudis(String nomPla) {
        this.nomPla = nomPla;
        this.credits = 0;
        this.jornadaLectiva = new JornadaLectiva();
        this.titulacio = new Titulacio();
        this.assignatures = new Assignatures();
        this.aules = new Aules();
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

    public PlaEstudis(String nomPla, Assignatures assignatures, Titulacio titulacio) {
        this.nomPla = nomPla;
        this.assignatures = new Assignatures(assignatures);
        this.titulacio = new Titulacio(titulacio);
        this.calculaCredits();
        this.aules = new Aules();
    }

    public PlaEstudis(PlaEstudis pe) {
        this.nomPla = pe.getNomPla();
        this.credits = pe.getCredits();
        this.jornadaLectiva = pe.getJornadaLectiva();
        this.titulacio = new Titulacio(pe.getTitulacio());
        this.assignatures = new Assignatures(pe.getAssignatures());
        this.aules = new Aules(pe.aules);
        this.horari = new Horari(pe.getHorari());
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

    public Assignatures getAssignatures() {
        return this.assignatures;
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

    public void calculaCredits() {
        this.credits = 0;
        for(int i = 0; i < this.assignatures.mida(); i++){
            this.credits += this.assignatures.getAssignatura(i).getCredits();
        }
    }

    public void generateHorari() throws MyException {
        this.horari = new Horari(this.jornadaLectiva);

        System.out.println("\n\n in PlaEstudis.generateHorari()");

        Grup g = new Grup("EDA", 10, 25);
        Grup j = new Grup("PROP", 10, 25);
        Grup k = new Grup("IDI", 10, 25);
        Grup q = new Grup("EDA", 20, 25);
        Grup w = new Grup("EDA", 30, 25);
        Grup t = new Grup("PROP", 20, 25);

        Assignacio a = new Assignacio(g, "A5101");
        Assignacio b = new Assignacio(j, "A5102");
        Assignacio c = new Assignacio(k, "A5103");
        Assignacio d = new Assignacio(q, "A5104");
        Assignacio e = new Assignacio(w, "A5105");
        Assignacio f = new Assignacio(t, "A5106");

        HoraLectiva hL = new HoraLectiva();
        hL.afegirAssignacio(a);
        hL.afegirAssignacio(b);
        hL.afegirAssignacio(c);
        hL.afegirAssignacio(d);


        HoraLectiva kk = new HoraLectiva();
        kk.afegirAssignacio(e);
        kk.afegirAssignacio(f);

        this.horari.afegirHoraLectiva(hL);
        this.horari.afegirHoraLectiva(kk, 3, 17);

        //this.horari.GenerarHorari(this);
    }

    public void printPlaEstudisLong(int numPla) {
        System.out.println("  Pla d'Estudis " + numPla + ":");
        System.out.println("   nomPlaEstudis: " + this.nomPla);
        this.titulacio.printTitulacioLong();
        System.out.println("   credits: " + this.credits + " ECTS");
        this.aules.printAulesLong(3);
        this.assignatures.printAssignaturesLong();
        System.out.print("\n");
    }

    public void printPlaEstudis(int numPla) {
        System.out.println("  Pla d'Estudis " + numPla + ":");
        System.out.println("   nomPlaEstudis: " + this.nomPla);
        this.titulacio.printTitulacio();
        System.out.println("   credits: " + (int)this.credits + " ECTS");
        this.jornadaLectiva.printJornadaLectiva();
        this.aules.printAules(3);
        this.assignatures.printAssignatures();
        System.out.print("\n");
    }

    public void printPlaEstudisXS(int numPla) {
        System.out.println("  Pla d'Estudis " + numPla + ":");
        System.out.println("   nomPlaEstudis: " + this.nomPla);
        this.titulacio.printTitulacio();
        System.out.println("   credits: " + (int)this.credits + " ECTS");
        this.jornadaLectiva.printJornadaLectiva();
        System.out.print  ("   Aules: ");
        for (int i = 0; i < this.aules.mida(); i++) {
            if (i % 11 == 0) System.out.print("\n    ");                                // for indentation purposes
            System.out.print(this.aules.getAula(i).getCodi());                          // print codiAula
            if (i < this.aules.mida() - 1) System.out.print(", ");                      // for presentation purposes
            if (this.aules.getAula(i).getCodi().length() == 5) System.out.print(" ");   // for indentation purposes

        }
        System.out.print("\n");
        System.out.print  ("   Assignatures: ");
        for (int i = 0; i < this.assignatures.mida(); i++) {
            if (i % 19 == 0) System.out.print("\n    ");                                // for indentation purposes
            System.out.print(this.assignatures.getAssignatura(i).getCodi());            // print codiAssignatura
            if (i < this.assignatures.mida() - 1) System.out.print(", ");               // for presentation purposes
        }
        System.out.print("\n");

        this.horari.printHorari();
    }

}
