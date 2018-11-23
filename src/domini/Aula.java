package domini;


public class Aula implements Cloneable
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
        this.PC = a.isLab();
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

    public boolean setCodi(String codi) {
        // check if "codi" is valid
        this.codi = codi;
        return true;
    }

    public boolean setCapacitat(int capacitat) {
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

    public boolean isLab() { return this.PC; }

}
