package domini;


public class Aula implements Cloneable
{
    private String codi;
    private int capacitat;
    private boolean PCs;

    public Aula() {
        this.codi = "";
        this.capacitat = 0;
    }

    public Aula(String codi, int capacitat, boolean PCs) {
        this.codi = codi;
        this.capacitat = capacitat;
        this.PCs = PCs;
    }

    public Aula(Aula a) {
        this.codi = a.getCodi();
        this.capacitat = a.getCapacitat();
        this.PCs = a.isLab();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Aula a = new Aula();
        try {
            a = (Aula) super.clone();
        }
        catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return a;
    }

    public boolean equals(Aula a) {
        if (this.codi.equals(a.getCodi())) return true;
        else return false;
    }

    public void setCodi(String codi) {
        // check if "codi" is valid
        this.codi = codi;
    }

    public void setCapacitat(int capacitat) {
        this.capacitat = capacitat;
    }
    
    public void setPCs(boolean PCs){
        this.PCs = PCs;
    }

    public String getCodi() {
        return this.codi;
    }

    public int getCapacitat() {
        return this.capacitat;
    }

    public boolean isLab() { return this.PCs; }

    public void printAulaLong(int indentation) {
        System.out.print("\n");
        if (indentation == 3) System.out.print("  ");
        System.out.print("  Aula:\n");
        if (indentation == 3) System.out.print("  ");
        System.out.println("    Codi: " + this.codi + ", \tcapacitat: " + this.capacitat + ", \tPCs: " + this.PCs);
    }

    public void printAula() {
        System.out.println("    Codi: " + this.codi + ", \tcapacitat: " + this.capacitat);
    }
}
