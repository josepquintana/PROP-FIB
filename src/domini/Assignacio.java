package domini;

public class Assignacio
{
    private Grup grup;
    private String codiAula;

    public Assignacio(){
        this.grup = new Grup();
        this.codiAula = new String();
    }

    public Assignacio(Grup grup, String aula){
        this.grup = new Grup();
        this.grup = grup;
        this.codiAula = aula;
    }

    public Assignacio(Grup grup, Aula aula){
        this.grup = new Grup();
        this.grup = grup;
        this.codiAula = aula.getCodi();
    }

    public Assignacio(Assignacio asg){
        this.grup = new Grup();
        this.grup = asg.getGrupAssignat();
        this.codiAula = asg.getCodiAulaAssignada();
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

    public String getAssignacioPrintFormat() {
        String str = "[" + this.grup.getCodiAssig() + ", " + this.grup.getNumGrup() + ", " + this.codiAula + "]";
        return str;
    }

    public void printAssignacioLong() {
        System.out.println("      Assignacio: " + this.grup.getCodiAssig() + ", " + this.grup.getNumGrup() + ", " + this.codiAula);
    }

    public void printAssignacio() {
        System.out.println("[" + this.grup.getCodiAssig() + ", " + this.grup.getNumGrup() + ", " + this.codiAula + "]");
    }

    public void printAssignacioXS() {
        System.out.print("[" + this.grup.getCodiAssig() + ", " + this.grup.getNumGrup() + ", " + this.codiAula + "] ");
    }
}
