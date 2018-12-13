package domini;

import java.util.ArrayList;
import java.util.Iterator;

public class Grup implements Cloneable
{
    private int numGrup;
    private int capacitat;
    private int horesTeoria; // sessions Teoria per setmana
    private ArrayList<SubGrup> subGrups;

    public Grup(){
        this.numGrup = 0;
        this.capacitat = 0;
        this.horesTeoria = 0;
        this.subGrups = new ArrayList<>();
    }
    
    public Grup(String codi, int numGrup, int capacitatGrup, int horesTeoria) {
        this.numGrup = numGrup;
        this.capacitat = capacitatGrup;
        this.horesTeoria = horesTeoria;
        this.subGrups = new ArrayList<>();
    }

    public Grup(Grup g) {
        this.numGrup = g.getNumGrup();
        this.capacitat = g.getCapacitat();
        this.horesTeoria = g.getHoresTeoria();
        this.subGrups = g.getSubGrups();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Grup g = new Grup();
        try {
            g = (Grup) super.clone();

            Iterator<SubGrup> it_subGrups  = this.subGrups.iterator();
            ArrayList<SubGrup> list_subGrups = new ArrayList<>();
            while(it_subGrups.hasNext()) {
                list_subGrups.add((SubGrup) it_subGrups.next().clone());
            }
            g.setSubGrups(list_subGrups);
        }
        catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return g;
    }

    public boolean afegirSubGrup(SubGrup sG) {
        this.subGrups.add(sG);
        return true;
    }

    public boolean afegirSubGrup(int numSubGrup, int horesLab, boolean teLabAmbPCs) {
        int capacitatSubGrup = this.capacitat / this.subGrups.size();
        SubGrup sG = new SubGrup(numSubGrup, capacitatSubGrup, horesLab, teLabAmbPCs);
        this.subGrups.add(sG);
        return true;
    }

    public boolean eliminarSubGrup(SubGrup sG) {
        for (int i = 0; i < this.subGrups.size(); i++) {
            if(this.subGrups.get(i).equals(sG)) this.subGrups.remove(i);
            return true;
        }
        return false;
    }
    
    public boolean eliminarSubgrup(int i){
        this.subGrups.remove(i);
        return true;
    }

    public boolean eliminarSubgrupAmbNum(int numSubGrup) {
        for (int i = 0; i < this.subGrups.size(); i++) {
            if(this.subGrups.get(i).getNumSubGrup() == numSubGrup) this.subGrups.remove(i);
            return true;
        }
        return false;
    }

    public boolean teSubGrups() {
        return (!this.subGrups.isEmpty());
    }

//    public boolean allSubGrupsBuits() {
//        for (int i = 0; i < this.subGrups.size(); i++) {
//            if (this.subGrups.get(i).getHoresLab() > 0) return false;
//        }
//        return true;
//    }

    public int getQuantsSubGrups() {
        return this.subGrups.size();
    }
   
    public int getCapacitat(){
        return this.capacitat;
    }
    
    public int getNumGrup(){
        return this.numGrup;
    }
    
    public int getHoresTeoria(){
        return this.horesTeoria;
    }
    
    public ArrayList<SubGrup> getSubGrups(){
        return this.subGrups;
    }

    public SubGrup getSubGrup(int i) { return this.subGrups.get(i); }

    public SubGrup getSubGrupAmbNum(int numSubGrup) {
        for (int i = 0; i < this.subGrups.size(); i++) {
            if(this.subGrups.get(i).getNumSubGrup() == numSubGrup) return this.subGrups.get(i);
        }
        return null;
    }

    public void setNumGrup(int numGrup){
        this.numGrup = numGrup;
    }
    
    public void setCapacitat(int capacitat){
        this.capacitat = capacitat;
    }
    
    public void setHoresTeoria(int horesTeoria){
        this.horesTeoria = horesTeoria;
    }

    public void setSubGrups(ArrayList<SubGrup> subGrups) {
        this.subGrups = subGrups;
    }

    protected void decrementHoresTeoria() { this.horesTeoria = this.horesTeoria - 1; }  // !! only during GenerarHorari()

    public String getGrupPrintFormat() {
        String s = "{ g" + this.numGrup + " (" + this.capacitat + "): g" + this.subGrups.get(0).getNumSubGrup() + "..g" + this.subGrups.get(this.subGrups.size()-1).getNumSubGrup() + " (" + this.subGrups.get(0).getCapacitatSG() + ") }";
        return s;
    }
    
//    public void printGrupXS(){
//        System.out.println("      Grup: [" + this.codiAssig + ", " + this.numGrup + "]");
//    }

//    public void printGrup() {
//        System.out.println("      Grup: " + this.codiAssig + " " + this.getGrupPrintFormat());
//    }

}
