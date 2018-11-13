package domini;


public class Aula
{
    private String codi;
    private int capacitat;
    private boolean PC;

    public Aula() {
        this.codi = "";
        this.capacitat = 0;
    }

    public Aula(String codi, int capacitat, boolean tipus) {
        this.codi = codi;
        this.capacitat = capacitat;
        this.PC = tipus;
    }

    public Aula(Aula a) {
        this.codi = a.getCodi();
        this.capacitat = a.getCapacitat();
        this.PC = a.getTipus();
    }

    public boolean equals(Aula a) {
        if (this.codi.equals(a.getCodi())) return true;
        else return false;
    }

    public boolean setCodi(String codi) {
        // check if "codi" is valid
        this.codi = codi;
        return true;
    }

    public boolean setCapacitat(int capacitat) {
        // check if "capacitat" is valid
        this.capacitat = capacitat;
        return true;
    }
    
    public boolean setTipus(boolean tipus){
        this.PC = tipus;
        return true;
    }

    public String getCodi() {
        return this.codi;
    }

    public int getCapacitat() {
        return this.capacitat;
    }
    
    public boolean getTipus(){
        return this.PC;
    }

    public void printAulaLong(int indentation) {
        System.out.print("\n");
        if (indentation == 3) System.out.print("  ");
        System.out.print("  Aula:\n");
        if (indentation == 3) System.out.print("  ");
        System.out.print("    Codi: " + this.codi + ", \tcapacitat: " + this.capacitat);
    }

    public void printAula() {
        System.out.println("    Codi: " + this.codi + ", \tcapacitat: " + this.capacitat);
    }
}
