package domini;

public class Aula
{
    private String codi;
    private int capacitat;

    public Aula(String codi, int capacitat) {
        this.codi = codi;
        this.capacitat = capacitat;
    }

    public Aula(Aula a) {
        this.codi = a.getCodi();
        this.capacitat = a.getCapacitat();
    }






    public void setCodi(String codi) {
        this.codi = codi;
    }

    public void setCapacitat(int capacitat) {
        this.capacitat = capacitat;
    }

    public String getCodi() {
        return codi;
    }

    public int getCapacitat() {
        return capacitat;
    }
}
