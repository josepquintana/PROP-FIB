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

    public void printAssignacio() {

    }
}
