package domini;

import java.util.ArrayList;
import java.util.Iterator;

public class Assignatura implements Cloneable
{
    private String codi;
    private String nom;
    private double credits;                     // multiple de 1.5
    private int nivell;
    private ArrayList<String> correquisits;
    private ArrayList<Grup> grups;              // conte grups i subgrups
    private boolean labAmbPCs;
    private int horesTeo;
    private int horesLab;

    public Assignatura() {
        this.codi = new String();
        this.nom = new String();
        this.credits = 0;
        this.nivell = 0;
        this.correquisits = new ArrayList<>();
        this.grups = new ArrayList<>();
        this.labAmbPCs = false;
        this.horesLab = 0;
        this.horesTeo = 0;
    }

    public Assignatura(String codi, String nom, double credits, int nivell, boolean labAmbPCs) {
        this.codi = codi;
        this.nom = nom;
        this.credits = credits;
        this.nivell = nivell;
        this.correquisits = new ArrayList<>();
        this.grups = new ArrayList<>();
        this.labAmbPCs = labAmbPCs;
        setSessionsTeoria();
        setSessionsLab();
    }
    
    public Assignatura(String codi, String nom, double credits, int nivell, ArrayList<String> correqs, boolean ordinadors) {
        this.codi = codi;
        this.nom = nom;
        this.credits = credits;
        this.nivell = nivell;
        this.correquisits = new ArrayList<>(correqs);
        this.grups = new ArrayList<>(grups);
        this.labAmbPCs = ordinadors;
        setSessionsLab();
        setSessionsTeoria();
    }

    public Assignatura(String codi, String nom, double credits, int nivell, ArrayList<String> correqs, ArrayList<Grup> grups, boolean ordinadors) {
        this.codi = codi;
        this.nom = nom;
        this.credits = credits;
        this.nivell = nivell;
        this.correquisits = new ArrayList<>(correqs);
        this.grups = new ArrayList<>(grups);
        this.labAmbPCs = ordinadors;
        setSessionsLab();
        setSessionsTeoria();
    }

    public Assignatura(Assignatura a) {
        this.codi = a.getCodi();
        this.nom = a.getNom();
        this.credits = a.getCredits();
        this.nivell = a.getNivell();
        this.correquisits = new ArrayList<>(a.getCorrequisits());
        this.grups = new ArrayList<>(a.getGrups());
        this.labAmbPCs = a.teLabAmbPCs();
        setSessionsLab();
        setSessionsTeoria();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Assignatura a;
        try {
            a = (Assignatura) super.clone();

            // tractar mutable fields
            ArrayList<String> list_correq = (ArrayList<String>) this.getCorrequisits().clone();
            a.setCorrequisits(list_correq);

            Iterator<Grup> it_grups  = this.grups.iterator();
            ArrayList<Grup> list_grups = new ArrayList<>();
            while(it_grups.hasNext()) {
                list_grups.add((Grup) it_grups.next().clone());
            }
            a.setGrups(list_grups);

        }
        catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return a;
    }

    public boolean equals(Assignatura a) {
        if (this.codi.equals(a.getCodi())) return true;
        else return false;
    }

    public boolean existeixCorrequisit(Assignatura assig) {
        for (int i = 0; i < this.correquisits.size(); i++) {
            if(this.correquisits.get(i).equals(assig.getCodi())) return true;
        }
        return false;
    }

    public boolean existeixCorrequisit(String codi) {
        for (int i = 0; i < this.correquisits.size(); i++) {
            if(this.correquisits.get(i).equals(codi)) return true;
        }
        return false;
    }

    public boolean afegirCorrequisitAssignatura(String codi) throws MyException{
        boolean ret = this.correquisits.add(codi);
        if(!ret) throw new MyException("Requisit " + codi + " no afegit a " + this.codi + ".");
        return ret;
    }

    public boolean eliminarCorrequisitAssignatura(Assignatura a) throws MyException {
        boolean ret = this.correquisits.remove(a.getCodi());
        if(!ret) throw new MyException ("L'assignatura " + this.codi + " no té " + a.getCodi() + " com a requisit");
        return ret;
    }

    public boolean eliminarCorrequisitAssignatura(String codi) {
        boolean ret = this.correquisits.remove(codi);
        return ret;
    }

    public boolean existeixGrup(Grup g) {
        for (int i = 0; i < this.grups.size(); i++) {
            if(this.grups.get(i).getNumGrup() == g.getNumGrup()) return true;
        }
        return false;
    }

    public boolean existeixGrup(int numGrup) {
        for (int i = 0; i < this.grups.size(); i++) {
            if(this.grups.get(i).getNumGrup() == numGrup) return true;
        }
        return false;
    }

    public boolean afegirGrupAssignatura(Grup g) throws MyException{
        if(existeixGrup(g)) {
            throw new MyException("L'assignatura " + this.codi + " ja té grup " + g.getNumGrup() + " creat.");
        }
        boolean ret = this.grups.add(g);
        return ret;
    }

    public boolean eliminarGrupAssignatura(Grup g) {
        for(int i = 0; i< this.grups.size(); ++i){
            if(g.getNumGrup() == this.grups.get(i).getNumGrup()) this.grups.remove(i);
            return true;
        }
        return false;
    }

    public boolean eliminarGrupAssignatura(int i) {
        this.grups.remove(i);
        return true;
    }

    public boolean eliminarGrupAssignaturaAmbNum(int numGrup) {
        for (int i = 0; i < this.grups.size(); i++) {
            if(this.grups.get(i).getNumGrup() == numGrup) { this.grups.remove(i); return true; }
        }
        return false;
    }

    public boolean teCorrequisits() {
        return (!this.correquisits.isEmpty());
    }

    public boolean teGrups() {
        return (!this.grups.isEmpty());
    }

    public int getNumGrupsGenerals() {
        int lastGrup = (this.grups.get(this.grups.size() - 1).getGrupGeneral());
        return ((int) Math.floor(lastGrup / Math.pow(10, Math.floor(Math.log10(lastGrup)))));
    }

    public int getNumSubGrupsXGrup() {
        int nsubgrups = 0;
        for (int i = 0; i < this.grups.size(); i++) {
            if (this.grups.get(i).isLab()) ++nsubgrups;
            if ((i+1) < this.grups.size() && this.grups.get(i+1).getGrupGeneral() != this.grups.get(i).getGrupGeneral()) break;
        }
        return nsubgrups;
    }

    public int getNumTotalSubgrups() {
        int nsubgrups = 0;
        for (int i = 0; i < this.grups.size(); i++) {
            if (this.grups.get(i).isLab()) ++nsubgrups;
        }
        return nsubgrups;
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
        this.grups = new ArrayList<>(grups);
    }

    public void setLabAmbPCs(Boolean PCs) { this.labAmbPCs = PCs; }

    private void setSessionsLab(){
        this.horesLab = (int)(this.credits/1.5)/2;
    }

    private void setSessionsTeoria(){
        int hores = (int)(this.credits/1.5);
        if(hores%2 != 0) {
            ++hores;
        }
        this.horesTeo = hores/2;
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

    public Grup getGrupAmbNum(int numGrup) {
        for (int i = 0; i < this.grups.size(); i++) {
            if(this.grups.get(i).getNumGrup() == numGrup) return this.grups.get(i);
        }
        return null;
    }

    public boolean teLabAmbPCs(){
        return this.labAmbPCs;
    }

    public int getSessionsLab(){
        return this.horesLab;
    }

    public int getSessionsTeoria(){
        return this.horesTeo;
    }

    public int getSessionsTotals() { return (this.horesTeo + this.horesLab); }

    public int getCapacitatAssignatura() {
        int c = 0;
        for (int i = 0; i < this.grups.size(); i++) {
            if (!this.getGrup(i).isLab()) c += this.grups.get(i).getCapacitat();
        }
        return c;
    }

    protected int getIndexGrup(int numGrup) {
        for(int i = 0; i< this.grups.size();++i){
            if(grups.get(i).getNumGrup() == numGrup) return i;
        }
        return -1;
    }

}
