package domini;


import java.util.ArrayList;

public class Assignatura {
    private String codi;
    private String nom;
    private int credits;
    private int nivell; //a l'esquema no hi és però crec que és necessari per aplicar les restriccions
    private ArrayList<Assignatura> correquisits;

    public Assignatura(String codi) {
        this.codi = codi;
        correquisits = new ArrayList<Assignatura>();
    }

    public Assignatura(String codi, String nom, int credits, int nivell, ArrayList<Assignatura> corr) {
        this.codi = codi;
        this.nom = nom;
        this.credits = credits;
        this.nivell = nivell;
        this.correquisits = corr;
    }

    public Assignatura(Assignatura a) {
        // clone Assignatura
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
    
    public void setCorrequisits(ArrayList<Assignatura> corr) {
        this.correquisits = corr;
    }

    public String getCodi() {
        return this.codi;
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
    
    public ArrayList<Assignatura> getCorrequisits() {
        return correquisits;
    }

    public void printAssignatura() {
        System.out.println("\n> Assignatura:");
        System.out.println(" codi   : " + this.codi);
        System.out.println(" nom    : " + this.nom);
        System.out.println(" credits: " + this.credits);
        System.out.println(" nivell : " + this.nivell);
        System.out.println(" Correquisits:");
        for (int i = 0; i < this.correquisits.size(); i++) {
            System.out.println("  codi: " + this.correquisits.get(i).getCodi());
        }
    }
}
