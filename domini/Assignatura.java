package domini;


public class Assignatura {
    private String codi;
    private String nom;
    private int credits;
    private int nivell; //a l'esquema no hi és però crec que és necessari per aplicar les restriccions
    private Assignatura[] correquisits; //no sé si voleu fer-ho així o amb una classe restriccions
    
    public Assignatura(String codi, String nom, int credits, int nivell, Assignatura[] corr) {
        this.codi = codi;
        this.nom = nom;
        this.credits = credits;
        this.nivell = nivell;
        this.correquisits = corr;
    }

    public Assignatura(Assignatura a) {
        this.codi = a.getCodi();
        this.nom = a.getNom();
        this.credits = a.getCredits();
        this.nivell = a.getNivell();
        this.correquisits = a.getCorrequisits();
    }


    public void setCodi(String codi) {
        this.codi = codi;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void setCredits(int credits) {
        this.credits = credits;
    }
    
    public void setNivell(int nivell) {
        this.nivell = nivell;
    }
    
    public void setCorrequisits(Assignatura[] corr) {
        this.correquisits = corr;
    }

    public String getCodi() {
        return codi;
    }

    public String getNom() {
        return nom;
    }
    
    public int getCredits() {
        return credits;
    }
    
    public int getNivell() {
        return nivell;
    }
    
    public Assignatura[] getCorrequisits() {
        return correquisits;
    }
}
