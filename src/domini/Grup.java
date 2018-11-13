
package domini;

public class Grup
{
    private String codiAssig;
    private int numGrup;
    private int capacitat;
    private int numSubGrups;
    private int capacitatSubGrups;
    private int horesLab;
    private int aux;
    
    public Grup(){
        this.codiAssig = new String();
        this.numGrup = 0;
        this.capacitat = 0;
    }
    
    public Grup(String codi, int num, int capacitat, int numSubGrups, int hores){
        this.codiAssig = codi;
        this.numGrup = num;
        this.capacitat = capacitat;
        this.numSubGrups = numSubGrups;
        this.capacitatSubGrups = capacitat / numSubGrups;
        this.horesLab = this.aux = hores;

    }

    public Grup(Grup g) {
        this.codiAssig = g.getCodiAssig();
        this.numGrup = g.getNumGrup();
        this.capacitat = g.getCapacitat();
        this.numSubGrups = g.getSubGrups();
        if(g.getSubGrups() == 0) this.capacitatSubGrups = g.getCapacitat();
        else this.capacitatSubGrups = g.getCapacitat() / g.getSubGrups();
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
    
    public int getSubGrups(){
        return this.numSubGrups;
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
    
    public void setHoresLab(){
        this.horesLab = aux;
    }
    
    public void restarHoraLab(){
        --this.horesLab;
    }
    
    public void printGrup(){
        System.out.println("      Grup: [" + this.codiAssig + ", " + this.numGrup + "]");
    }

    public void printGrupLong() {
        System.out.println("      Grup: [" + this.codiAssig + ", g:" + this.numGrup + ", " + this.capacitat + "pers]");
    }
}
