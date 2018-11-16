
package domini;

public class Grup implements Cloneable
{
    private String codiAssig;
    private int numGrup;
    private int capacitat;
    private int numSubGrups;
    private int capacitatSubGrups;
    private int horesLab;
    private int horesTeo;
    
    public Grup(){
        this.codiAssig = new String();
        this.numGrup = 0;
        this.capacitat = 0;
    }
    
    public Grup(String codi, int num, int capacitat, int numSubGrups, int horesLab, int horesTeo){
        this.codiAssig = codi;
        this.numGrup = num;
        this.capacitat = capacitat;
        this.numSubGrups = numSubGrups;
        this.capacitatSubGrups = capacitat / numSubGrups;
        this.horesLab = horesLab;
        this.horesTeo = horesTeo;

    }

    public Grup(Grup g) {
        this.codiAssig = g.getCodiAssig();
        this.numGrup = g.getNumGrup();
        this.capacitat = g.getCapacitat();
        this.numSubGrups = g.getSubGrups();
        if(g.getSubGrups() == 0) this.capacitatSubGrups = g.getCapacitat();
        else this.capacitatSubGrups = g.getCapacitat() / g.getSubGrups();
        this.horesLab = g.getHoresLab();
        this.horesTeo = g.getHoresTeo();
        
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Grup g = new Grup();
        try {
            g = (Grup) super.clone();
        }
        catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return g;
    }

    public boolean equals(Grup g) {
        return (this.codiAssig.equals(g.getCodiAssig()) && this.numGrup == g.getNumGrup());
    }

    public String getCodiAssig(){
        return this.codiAssig;
    }
    
    public void eliminarSubgrup(){
        --this.numSubGrups;
    }
   
    public int getCapacitat(){
        return this.capacitat;
    }
    
    public int getNumGrup(){
        return this.numGrup;
    }
    
    public int getHoresLab(){
        return this.horesLab;
    }
    
    public int getHoresTeo(){
        return this.horesTeo;
    }
    
    public int getSubGrups(){
        return this.numSubGrups;
    }
    
    public int getNumSubgrup(){
        return this.numGrup+this.numSubGrups;
    }
    
    public int getCapacitatSub(){
        return this.capacitatSubGrups;
    }
    
    public void setCodiAssig(String s){
        this.codiAssig = s;
    }
    
    public void setNumGrup(int n){
        this.numGrup = n;
    }
    
    public void setCapacitat(int n){
        this.capacitat = n;
    }
    
    public void setCapacitatSub(int n){
        this.capacitatSubGrups = n;
    }
    
    public void setHoresLab(int h){
        this.horesLab = h;
    }
    
    public void restarHoraLab(){
        --this.horesLab;
    }
    
    public void restarHoraTeo(){
        --this.horesTeo;
    }
    
    public void printGrup(){
        System.out.println("      Grup: [" + this.codiAssig + ", " + this.numGrup + "]");
        for(int i = 0; i < this.numSubGrups ; ++i){
            System.out.println("       Subgrup: " +(this.numGrup + i+1) );
        }
        System.out.println("       Hores Teoria: " +this.horesTeo + ", Hores Lab: "+  this.horesLab );
    }

    public void printGrupLong() {
        System.out.println("      Grup: [" + this.codiAssig + ", g:" + this.numGrup + ", " + this.capacitat + "pers]");
    }
}
