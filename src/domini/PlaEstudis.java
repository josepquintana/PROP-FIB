package domini;

public class PlaEstudis
{
    private String nomPla;
    private double credits;
    private Assignatures assignatures;
    private Titulacio titulacio;

    public PlaEstudis() {
        nomPla = new String();
        credits = 0;   
        assignatures = new Assignatures();
        titulacio = new Titulacio();
    }

    public PlaEstudis(String nomPla) {
        this.nomPla = nomPla;
        this.credits = 0;    
        this.assignatures = new Assignatures();
        this.titulacio = new Titulacio();
    }

    public PlaEstudis(String nomPla, Titulacio titulacio) {
        this.nomPla = nomPla;
        this.credits = 0; 
        this.assignatures = new Assignatures();
        this.titulacio = new Titulacio();
        this.titulacio = titulacio;
    }

    public PlaEstudis(String nomPla, Assignatures assignatures, Titulacio titulacio) {
        this.nomPla = nomPla;
        this.assignatures = new Assignatures();
        this.assignatures = assignatures;
        this.titulacio = new Titulacio();
        this.titulacio = titulacio;
        this.calculaCredits();
    }

    public PlaEstudis(PlaEstudis pe) {
        this.nomPla = pe.getNomPla();
        this.credits = pe.getCredits();
        this.assignatures = new Assignatures();
        this.assignatures = pe.getAssignatures();
        this.titulacio = new Titulacio();
        this.titulacio = pe.getTitulacio();
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

    public boolean equal(PlaEstudis pe) {
        if (this.nomPla.equals(pe.getNomPla()) && this.titulacio.equals(pe.getTitulacio())) return true;
        return false;
    }

    public String getNomPla() {
        return this.nomPla;
    }

    public double getCredits() {
        return this.credits;
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

    public Assignatura getAssignatura(String codi) {
        for (int i = 0; i < this.assignatures.mida(); i++) {
            if(this.assignatures.getAssignatura(i).getCodi().equals(codi)) return this.assignatures.getAssignatura(i);
        }
        return null;
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

    public void setCredits() {
        // funcio inutil...
        this.calculaCredits();
    }

    public void setAssignatures(Assignatures assignatures) {
        this.assignatures = assignatures;
        this.calculaCredits();
    }

    public void setTitulacio(Titulacio titulacio) {
        this.titulacio = titulacio;
    }

    public void calculaCredits(){
        this.credits = 0;
        for(int i = 0; i < this.assignatures.mida(); i++){
            this.credits += this.assignatures.getAssignatura(i).getCredits();
        }
    }

    public void printPlaEstudisLong(int numPla) {
        System.out.println("  Pla d'Estudis " + numPla + ":");
        this.titulacio.printTitulacioLong();
        System.out.println("   nomPlaEstudis: " + this.nomPla);
        System.out.println("   credits: " + this.credits + " ECTS");
        this.assignatures.printAssignaturesLong();
        System.out.print("\n");
    }

    public void printPlaEstudis(int numPla) {
        System.out.println("  Pla d'Estudis " + numPla + ":");
        this.titulacio.printTitulacio();
        System.out.println("   nomPlaEstudis: " + this.nomPla);
        System.out.println("   credits: " + (int)this.credits + " ECTS");
        this.assignatures.printAssignatures();
        System.out.print("\n");
    }

    public void printPlaEstudisXS(int numPla) {
        System.out.println("  Pla d'Estudis " + numPla + ":");
        this.titulacio.printTitulacio();
        System.out.println("   nomPlaEstudis: " + this.nomPla);
        System.out.println("   credits: " + (int)this.credits + " ECTS");
        System.out.print  ("   Assignatures: ");
        for (int i = 0; i < this.assignatures.mida(); i++) {
            if (i % 19 == 0) System.out.print("\n    ");                              // for indentation purposes
            System.out.print(this.assignatures.getAssignatura(i).getCodi());        // print codiAssignatura
            if (i < this.assignatures.mida() - 1) System.out.print(", ");           // for presentation purposes
        }
        System.out.print("\n");
    }

}
