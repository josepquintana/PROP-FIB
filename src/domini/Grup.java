package domini;

public class Grup implements Cloneable
{
    private int numGrup;
    private int capacitat;
    private boolean isLab;
    private int horesTeoria;    // sessions Teoria per setmana
    private int horesLab;       // sessions Lab per setmana
    private boolean ambPCs;

    public Grup(){
        this.numGrup = 0;
        this.capacitat = 0;
        this.isLab = false;
        this.horesTeoria = 0;
        this.horesLab = 0;
        this.ambPCs = false;
    }
    
    public Grup(int numGrup, int capacitat, boolean isLab, int horesTeoria, int horesLab, boolean ambPCs) {
        this.numGrup = numGrup;
        this.capacitat = capacitat;
        this.isLab = isLab;
        this.horesTeoria = horesTeoria;
        this.horesLab = horesLab;
        this.ambPCs = ambPCs;
    }

    public Grup(Grup grup) {
        this.numGrup = grup.getNumGrup();
        this.capacitat = grup.getCapacitat();
        this.isLab = grup.isLab();
        this.horesTeoria = grup.getHoresTeoria();
        this.horesLab = grup.getHoresLab();
        this.ambPCs = grup.isAmbPCs();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Grup g;
        try {
            g = (Grup) super.clone();
        }
        catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return g;
    }

    public boolean equals(Grup grup) {
        return (this.numGrup == grup.getNumGrup());
    }

    public int getGrupGeneral() {
        if (this.isLab) return this.numGrup;
        return (this.numGrup)-(Math.abs(this.numGrup) % 10);
    }

    public boolean teComASubgrup(int subgrup) {
        int aux = subgrup - this.numGrup;
        if (aux >= 1 && aux <= 9) return true;
        return false;
    }

    public boolean pertanyAlGrupTeoria(int grup) {
        int aux = this.numGrup - grup;
        if (aux >= 1 && aux <= 9) return true;
        return false;
    }

    public int getNumGrup(){
        return this.numGrup;
    }

    public int getCapacitat(){
        return this.capacitat;
    }

    public boolean isLab() {
        return isLab;
    }

    public int getHoresTeoria(){
        return this.horesTeoria;
    }

    public int getHoresLab(){
        return this.horesLab;
    }

    public boolean isAmbPCs() {
        return ambPCs;
    }

    public void setNumGrup(int numGrup){
        this.numGrup = numGrup;
    }
    
    public void setCapacitat(int capacitat){
        this.capacitat = capacitat;
    }

    public void setLab(boolean lab) {
        isLab = lab;
    }

    public void setHoresTeoria(int horesTeoria){
        this.horesTeoria = horesTeoria;
    }

    public void setHoresLab(int horesLab){
        this.horesLab = horesLab;
    }

    public void setAmbPC(boolean labAmbPC) {
        ambPCs = labAmbPC;
    }

    public void printGrupLong() {
        if (this.isLab) {
            System.out.println("       GrupL: " + this.numGrup + " " + this.isLab + " " + this.horesTeoria + " " + this.horesLab + " " + this.ambPCs);
        }
        else System.out.println("      GrupT: " + this.numGrup + " " + this.isLab + " " + this.horesTeoria + " " + this.horesLab + " " + this.ambPCs);
    }

}
