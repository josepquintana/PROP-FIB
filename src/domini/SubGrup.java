package domini;

public class SubGrup implements Cloneable
{
    private int numSubGrup;
    private int capacitatSG;
    private int horesLab; // sessions Lab per setmana
    private boolean ambPCs;

    public SubGrup() {
        this.numSubGrup = 0;
        this.capacitatSG = 0;
        this.horesLab = 0;
    }

    public SubGrup(int numSubGrup, int capacitatSG, int horesLab, boolean ambPCs) {
        this.numSubGrup = numSubGrup;
        this.capacitatSG = capacitatSG;
        this.horesLab = horesLab;
        this.ambPCs = ambPCs;
    }

    public SubGrup(SubGrup sG) {
        this.numSubGrup = sG.getNumSubGrup();
        this.capacitatSG = sG.getCapacitatSG();
        this.horesLab = sG.getHoresLab();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        SubGrup sG = new SubGrup();
        try {
            sG = (SubGrup) super.clone();
        }
        catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return sG;
    }

    public boolean equals(SubGrup sG) {
        return (this.numSubGrup == sG.getNumSubGrup());
    }

    public void setNumSubGrup(int numSubGrup) {
        this.numSubGrup = numSubGrup;
    }

    public void setCapacitatSG(int capacitatSG) {
        this.capacitatSG = capacitatSG;
    }

    public void setHoresLab(int horesLab) {
        this.horesLab = horesLab;
    }

    public void setAmbPCs(boolean ambPCs) { this.ambPCs = ambPCs; }

    public int getHoresLab() {
        return horesLab;
    }

    public int getCapacitatSG() {
        return capacitatSG;
    }

    public int getNumSubGrup() {
        return numSubGrup;
    }

    public boolean isAmbPCs() {
        return ambPCs;
    }

    protected void decrementHoresLab() { this.horesLab = this.horesLab - 1;}   // !! only during GenerarHorari()

    public int getGrupGeneral() {
        return (this.numSubGrup)-(Math.abs(this.numSubGrup) % 10);
    }

    public String getSubGrupPrintFormat() {
        String s = "{ g" + this.numSubGrup + " (" + this.capacitatSG + "): hLab = " + this.horesLab + " }";
        return s;
    }

    public void printSubGrup() {
        System.out.println("       SubGrup: " + this.getSubGrupPrintFormat());
    }

    public void printSubGrupXS(){
        System.out.println("        SubGrup: [g" + this.numSubGrup + ", " + this.capacitatSG + "p]");
    }

}
