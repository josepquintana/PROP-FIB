package domini;

import java.util.ArrayList;

public class Assignatura
{
    private String codi;
    private String nom;
    private double credits;
    private int nivell;
    private ArrayList<String> correquisits;            // Comprobar correquisits bidireccionals
    private ArrayList<Grup> grups;

    public Assignatura() {
        this.codi = new String();
        this.nom = new String();
        this.credits = 0;
        this.nivell = 0;
        this.correquisits = new ArrayList<>();
        this.grups = new ArrayList<>();
    }

    public Assignatura(String codi) {
        this.codi = codi;
        this.nom = new String();
        this.credits = 0;
        this.nivell = 0;
        this.correquisits = new ArrayList<>();
        this.grups = new ArrayList<>();
    }

    public Assignatura(String codi, String nom, double credits, int nivell) {
        this.codi = codi;
        this.nom = nom;
        this.credits = credits;
        this.nivell = nivell;
        this.correquisits = new ArrayList<>();
        this.grups = new ArrayList<>();
    }

    public Assignatura(String codi, String nom, double credits, int nivell, ArrayList<String> correqs, ArrayList<Grup> grups) {
        this.codi = codi;
        this.nom = nom;
        this.credits = credits;
        this.nivell = nivell;
        this.correquisits = new ArrayList<>();
        this.correquisits = correqs;
        this.grups = new ArrayList<>();
        this.grups = grups;
    }

    public Assignatura(Assignatura a) {
        // clone Assignatura
        this.codi = a.getCodi();
        this.nom = a.getNom();
        this.credits = a.getCredits();
        this.nivell = a.getNivell();
        this.correquisits = new ArrayList<>();
        this.correquisits = a.getCorrequisits();
        this.grups = new ArrayList<>();
        this.grups = a.getGrups();
    }

    public boolean equals(Assignatura a) {
        if (this.codi.equals(a.getCodi())) return true;
        else return false;
    }

    public boolean existeixRequisit(Assignatura assig) {
        for (int i = 0; i < this.correquisits.size(); i++) {
            if(this.correquisits.get(i).equals(assig.getCodi())) return true;
        }
        return false;
    }

    public boolean existeixRequisit(String codi) {
        for (int i = 0; i < this.correquisits.size(); i++) {
            if(this.correquisits.get(i).equals(codi)) return true;
        }
        return false;
    }

    public boolean afegirRequisitAssignatura(Assignatura a) throws MyException{
        if(existeixRequisit(a)) {
            System.out.println(">>> afegirRequisitAssignatura(): L'assignatura " + this.codi + " ja té " + a.getCodi() + "com a requisit");
            return false;
        }
        boolean ret = this.correquisits.add(a.getCodi());
        if(!ret) throw new MyException(">>> Error: Assig.Requisit no afegit"); // ¿ pot passar ?
        return ret;
    }

    public boolean eliminarRequisitAssignatura(Assignatura a) {
        boolean ret = this.correquisits.remove(a.getCodi());
        if(!ret) System.out.println(">>> eliminarRequisitAssignatura(): L'assignatura " + this.codi + " no té " + a.getCodi() + " com a requisit");
        return ret;
    }

    public boolean existeixGrup(Grup g) {
        for (int i = 0; i < this.grups.size(); i++) {
            if(this.grups.get(i).getNumGrup() == g.getNumGrup()) return true;
        }
        return false;
    }

    public boolean existeixGrup(int numGrup) {
        for (int i = 0; i < this.correquisits.size(); i++) {
            if(this.grups.get(i).getNumGrup() == numGrup) return true;
        }
        return false;
    }

    public boolean afegirGrupAssignatura(Grup g) throws MyException{
        if(existeixGrup(g)) {
            System.out.println(">>> afegirGrupAssignatura(): L'assignatura " + this.codi + " ja té grup " + g.getNumGrup() + " creat.");
            return false;
        }
        boolean ret = this.grups.add(g);
        if(!ret) throw new MyException(">>> Error: Assig.Grup no afegit"); // ¿ pot passar ?
        return ret;
    }

    public boolean eliminarGrupAssignatura(Grup g) {
        boolean ret = this.grups.remove(g);
        if(!ret) System.out.println(">>> eliminarGrupAssignatura(): L'assignatura " + this.codi + " no té grup " + g.getNumGrup() + " creat.");
        return ret;
    }

    public boolean eliminarGrupAssignatura(int i) {
        Grup g = new Grup();
        g = this.grups.remove(i);
        if(g == null) System.out.println(">>> eliminarGrupAssignatura(): L'assignatura " + this.codi + " no té grup " + g.getNumGrup() + " creat.");
        return true;
    }

    public boolean teCorrequisits() {
        return (!this.correquisits.isEmpty());
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
    
    public void setCredits(double credits) {
        this.credits = credits;
    }
    
    public void setNivell(int nivell) {
        this.nivell = nivell;
    }
    
    public void setCorrequisits(ArrayList<String> correqs) {
        this.correquisits = correqs;
    }

    public void setGrups(ArrayList<Grup> grups) {
        this.grups = grups;
    }

    public String getCodi() {
        return this.codi;
    }

    public String getNom() {
        return this.nom;
    }
    
    public double getCredits() {
        return this.credits;
    }
    
    public int getNivell() {
        return this.nivell;
    }
    
    public ArrayList<String> getCorrequisits() {
        return this.correquisits;
    }

    public String getCorrequisit(int i) {
        return this.correquisits.get(i);
    }

    public ArrayList<Grup> getGrups() {
        return this.grups;
    }

    public Grup getGrup(int i) {
        return this.grups.get(i);
    }

    public int getCapacitatAssignatura() {
        int c = 0;
        for (int i = 0; i < this.grups.size(); i++) {
            c += this.grups.get(i).getCapacitat();
        }
        return c;
    }

    private void printCorrequisits(){
        for (int i = 0; i < this.correquisits.size(); i++) {
            System.out.print(this.correquisits.get(i));
            if (i < this.correquisits.size() - 1) System.out.print(", ");
        }
    }

    private void printGrups(){
        for (int i = 0; i < this.grups.size(); i++) {
            System.out.print(this.grups.get(i).getNumGrup());
            if (i < this.grups.size() - 1) System.out.print(", ");
        }
    }

    public void printAssignaturaLong() {
        System.out.println("    Assignatura:");
        System.out.println("     codi   : " + this.codi);
        System.out.println("     nom    : " + this.nom);
        System.out.println("     credits: " + this.credits);
        System.out.println("     nivell : " + this.nivell);
        System.out.println("     Correquisits:");
        for (int i = 0; i < this.correquisits.size(); i++) {
            System.out.println("      CR" + (i+1) + ": codi: " + this.correquisits.get(i) + "  \t nivell: " + this.correquisits.get(i));                     ///BUSCAR NIVELL DEL CORREQUISIT
        }
        System.out.println("     Grups:");
        for (int i = 0; i < this.grups.size(); i++) {
            System.out.println("      G" + (i+1) + ":  num: " + this.grups.get(i).getNumGrup() + "  \t capacitat: " + this.grups.get(i).getCapacitat());
        }
    }

    public void printAssignatura() {
        System.out.print("    " + this.codi + "   \tlvl: " + this.nivell + "\t\tcred: ");
        if(this.credits == Math.floor(this.credits)) System.out.print((int)this.credits + " \t");
        else System.out.print(this.credits + "\t");
        System.out.print("\tnGrups: " + this.grups.size());
        if (this.teCorrequisits()) { System.out.print("\t\t correq: "); this.printCorrequisits(); }
        System.out.print("\n");
    }

}
