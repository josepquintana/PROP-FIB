package domini;

import java.util.ArrayList;

public class Assignatura
{
    private String codi;
    private String nom;
    private int credits;
    private int nivell; //a l'esquema no hi és però crec que és necessari per aplicar les restriccions
    private ArrayList<Assignatura> requisits;
    private ArrayList<String> grups;
    // Requisits as a class?

    public Assignatura() {
        this.codi = new String();
        this.nom = new String();
        this.credits = 0;
        this.nivell = 0;
        requisits = new ArrayList<>();
        grups = new ArrayList<>();
    }

    public Assignatura(String codi) {
        this.codi = codi;
        this.nom = new String();
        this.credits = 0;
        this.nivell = 0;
        requisits = new ArrayList<>();
        grups = new ArrayList<>();
    }

    public Assignatura(String codi, String nom, int credits, int nivell) {
        this.codi = codi;
        this.nom = nom;
        this.credits = credits;
        this.nivell = nivell;
        requisits = new ArrayList<>();
        grups = new ArrayList<>();
    }

    public Assignatura(String codi, String nom, int credits, int nivell, ArrayList<Assignatura> reqs, ArrayList<String> grups) {
        this.codi = codi;
        this.nom = nom;
        this.credits = credits;
        this.nivell = nivell;
        this.requisits = new ArrayList<>();
        this.requisits = reqs;
        this.grups = new ArrayList<>();
        this.grups = grups;
    }

    public Assignatura(Assignatura a) {
        // clone Assignatura
        this.codi = a.getCodi();
        this.nom = a.getNom();
        this.credits = a.getCredits();
        this.nivell = a.getNivell();
        this.requisits = new ArrayList<>();
        this.requisits = a.getRequisits();
        this.grups = new ArrayList<>();
        this.grups = a.getGrups();
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

    public boolean existeixRequisit(String codi) {
        for (int i = 0; i < this.requisits.size(); i++) {
            if(this.requisits.get(i).getCodi().equals(codi)) return true;
        }
        return false;
    }
    
    public boolean existeixGrup(String codi) {
        for (int i = 0; i < this.grups.size(); i++) {
            if(this.grups.get(i).equals(codi)) return true;
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

    public boolean teRequisits() {
        return (!this.requisits.isEmpty());
    }
    
    public boolean afegirGrupAssignatura(String s) throws MyException{
        if(existeixGrup(s)) {
            System.out.println(">>> afegirGrupAssignatura(): L'assignatura " + this.codi + " ja té " + s + "com a grup");
            return false;
        }
        boolean ret = this.grups.add(s);
        if(!ret) throw new MyException(">>> Error: Assig.Grup no afegit"); 
        return ret;
    }

    public boolean eliminarGrupAssignatura(String s) {
        boolean ret = this.grups.remove(s);
        if(!ret) System.out.println(">>> eliminarGrupAssignatura(): L'assignatura " + this.codi + " no té " + s + " com a grup");
        return ret;
    }

    public boolean teGrups() {
        return (!this.grups.isEmpty());
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
    
    public void setGrups(ArrayList<String> grups) {
        this.grups = grups;
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

    public Assignatura getRequisit(int i) {
        return this.requisits.get(i);
    }
    
    
    public ArrayList<String> getGrups() {
        return this.grups;
    }

    public String getGrup(int i) {
        return this.grups.get(i);
    }

    private void printRequisits(){
        for (int i = 0; i < this.requisits.size(); i++) {
            System.out.print(this.requisits.get(i).getCodi());
            if (i < this.requisits.size() - 1) System.out.print(", ");
        }
        System.out.println("");
    }
    
    private void printGrups(){
        for (int i = 0; i < this.grups.size(); i++) {
            System.out.print(this.grups.get(i));
            if (i < this.grups.size() - 1) System.out.print(", ");
        }
        System.out.println("");
    }

    public void printAssignaturaLong() {
        System.out.println("    Assignatura:");
        System.out.println("     codi   : " + this.codi);
        System.out.println("     nom    : " + this.nom);
        System.out.println("     credits: " + this.credits);
        System.out.println("     nivell : " + this.nivell);
        System.out.println("     Requisits:");
        for (int i = 0; i < this.requisits.size(); i++) {
            System.out.println("      R" + (i+1) + ": codi: " + this.requisits.get(i).getCodi() + "  \t nivell: " + this.requisits.get(i).getNivell());
        }
        System.out.println("     Grups:");
        for (int i = 0; i < this.grups.size(); i++) {
            System.out.println("      Grup" + this.grups.get(i));
        }
    }

    public void printAssignatura() {
        System.out.print("    codi: " + this.codi + ",\t credits: " + this.credits);
        if (this.teRequisits()) System.out.print(",\t requisits: "); this.printRequisits();
        if (this.teGrups()) System.out.print(",\t grups: "); this.printGrups();
    }
}
