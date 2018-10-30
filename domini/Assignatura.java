package domini;

import java.util.ArrayList;

public class Assignatura
{
    private String codi;
    private String nom;
    private int credits;
    private int nivell; //a l'esquema no hi és però crec que és necessari per aplicar les restriccions
    private ArrayList<Assignatura> requisits;
    // Requisits as a class?
    // Seria molt liat fer pre-requisits i cor-requists

    public Assignatura(String codi) {
        this.codi = codi;
        this.nom = new String();
        this.credits = 0;
        this.nivell = 0;
        requisits = new ArrayList<>();
    }

    public Assignatura(String codi, String nom, int credits, int nivell) {
        this.codi = codi;
        this.nom = nom;
        this.credits = credits;
        this.nivell = nivell;
        requisits = new ArrayList<>();
    }

    public Assignatura(String codi, String nom, int credits, int nivell, ArrayList<Assignatura> reqs) {
        this.codi = codi;
        this.nom = nom;
        this.credits = credits;
        this.nivell = nivell;
        this.requisits = new ArrayList<>();
        this.requisits = reqs;
    }

    public Assignatura(Assignatura a) {
        // clone Assignatura
        this.codi = a.getCodi();
        this.nom = a.getNom();
        this.credits = a.getCredits();
        this.nivell = a.getNivell();
        this.requisits = new ArrayList<>();
        this.requisits = a.getRequisits();
    }

    public boolean equals(Assignatura a) {
        if (this.codi.equals(a.getCodi())) return true;
        else return false;
    }

    public boolean existeixRequisit(Assignatura assig) {
        for (int i = 0; i < this.requisits.size(); i++) {
            if(this.requisits.get(i).equals(assig)) return true;
        }
        return false;
    }

    public boolean afegirRequisitAssignatura(Assignatura a) throws MyException{
        if(existeixRequisit(a)) {
            System.out.println(">>> afegirRequisitAssignatura(): L'assignatura " + this.codi + " ja té " + a.getCodi() + "com a requisit");
            return false;
        }
        boolean ret = this.requisits.add(a);
        if(!ret) throw new MyException(">>> Error: Assig.Requisit no afegit"); // ¿ pot passar ?
        return ret;
    }

    public boolean eliminarRequisitAssignatura(Assignatura a) {
        boolean ret = this.requisits.remove(a);
        if(!ret) System.out.println(">>> eliminarRequisitAssignatura(): L'assignatura " + this.codi + " no té " + a.getCodi() + " com a requisit");
        return ret;
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
    
    public void setRequisits(ArrayList<Assignatura> reqs) {
        this.requisits = reqs;
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
    
    public ArrayList<Assignatura> getRequisits() {
        return this.requisits;
    }

    public void printAssignatura() {
        System.out.println("   Assignatura:");
        System.out.println("    codi   : " + this.codi);
        System.out.println("    nom    : " + this.nom);
        System.out.println("    credits: " + this.credits);
        System.out.println("    nivell : " + this.nivell);
        System.out.println("    Requisits:");
        for (int i = 0; i < this.requisits.size(); i++) {
            System.out.println("     R" + (i+1) + ": codi: " + this.requisits.get(i).getCodi() + "\t nivell: " + this.requisits.get(i).getNivell());
        }
    }
}
