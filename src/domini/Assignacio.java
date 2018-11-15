package domini;

public class Assignacio implements Cloneable
{
    private Grup grup;
    private int numGrup;
    private String codiAula;

    public Assignacio(){
        this.grup = new Grup();
        this.codiAula = new String();
        this.numGrup = 0;
    }

    public Assignacio(Grup grup, String aula, int numGrup){
        this.grup = new Grup();
        this.grup = grup;
        this.codiAula = aula;
        this.numGrup = numGrup;
    }

    public Assignacio(Grup grup, Aula aula, int numGrup){
        this.grup = new Grup();
        this.grup = grup;
        this.codiAula = aula.getCodi();
        this.numGrup = numGrup;
    }

    public Assignacio(Assignacio asg){
        this.grup = new Grup();
        this.grup = asg.getGrupAssignat();
        this.codiAula = asg.getCodiAulaAssignada();
        this.numGrup = asg.getNumGrupAssignacio();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Assignacio asg = new Assignacio();
        try {
            asg = (Assignacio) super.clone();
            asg.setGrup((Grup) this.getGrupAssignat().clone());
        }
        catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return asg;
    }

    public boolean equals(Assignacio asg) {
        return (this.grup.equals(asg.getGrupAssignat()) && this.codiAula.equals(asg.getCodiAulaAssignada()));
    }

    public void setGrup(Grup grup){
        this.grup = new Grup();
        this.grup = grup;
    }

    public void setAula(String codi){
        this.codiAula = codi;
    }

    public Grup getGrupAssignat(){
        return this.grup;
    }

    public String getCodiAulaAssignada(){
        return this.codiAula;
    }

    public int getNumGrupAssignacio() {
        return this.numGrup; 
    }
    
    public void setNumGrupAssignacio(int numGrup){
        this.numGrup = numGrup;
    }
    
    public String getAssignacioPrintFormat() {
        String str = "[" + this.grup.getCodiAssig() + "-" + this.numGrup + ", " + this.codiAula + "]";
        return str;
    }

    public void printAssignacioLong() {
        System.out.println("      Assignacio: " + this.grup.getCodiAssig() + ", " + this.numGrup + ", " + this.codiAula);
    }

    public void printAssignacio() {
        System.out.println("[" + this.grup.getCodiAssig() + ", " + this.numGrup + ", " + this.codiAula + "]");
    }

    public void printAssignacioXS() {
        System.out.print("[" + this.grup.getCodiAssig() + ", " + this.numGrup + ", " + this.codiAula + "] ");
    }

    
}
