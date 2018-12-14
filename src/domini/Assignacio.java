package domini;

public class Assignacio implements Cloneable
{
    private String codiAssig;
    private int numGrup;    // o numSubGrup
    private String codiAula;
    private int horaIni;
    private int durada;

    public Assignacio(){
        this.codiAssig = new String();
        this.numGrup  = 0;
        this.codiAula = new String();
        this.horaIni  = 0;
        this.durada  = 0;
    }

    public Assignacio(boolean emtpy){
        this.codiAssig = "none";
        this.numGrup  = 0;
        this.codiAula = new String();
        this.horaIni  = 0;
        this.durada  = 0;
    }

    public Assignacio(String codiAssig, int numGrup, String codiAula, int horaIni, int durada){
        this.codiAssig = codiAssig;
        this.numGrup = numGrup;
        this.codiAula = codiAula;
        this.horaIni  = horaIni;
        this.durada  = durada;
    }

    public Assignacio(String codiAssig, int numGrup, Aula aula, int horaIni, int durada){
        this.codiAssig = codiAssig;
        this.numGrup = numGrup;
        this.codiAula = aula.getCodi();
        this.horaIni  = horaIni;
        this.durada  = durada;
    }

    public Assignacio(Assignacio asg){
        this.codiAssig = asg.getCodiAssig();
        this.numGrup = asg.getNumGrup();
        this.codiAula = asg.getCodiAula();
        this.horaIni = asg.getHoraIni();
        this.durada = asg.getDurada();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Assignacio asg = new Assignacio();
        try {
            asg = (Assignacio) super.clone();
        }
        catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return asg;
    }

    public boolean equals(Assignacio asg) {
        return (this.codiAssig.equals(asg.getCodiAssig()) && this.numGrup == asg.getNumGrup() && this.codiAula.equals(asg.getCodiAula()));
    }

    public boolean isEmpty() { return(this.numGrup == 0); }

    public void setCodiAssig(String codiAssig) {
        this.codiAssig = codiAssig;
    }

    public void setNumGrup(int numGrup) {
        this.numGrup = numGrup;
    }

    public void setCodiAula(String codiAula) {
        this.codiAula = codiAula;
    }

    public void setHoraIni(int horaIni) {
        this.horaIni = horaIni;
    }

    public void setDurada(int durada) {
        this.durada = durada;
    }

    public String getCodiAssig() {
        return codiAssig;
    }

    public int getNumGrup() {
        return numGrup;
    }

    public String getCodiAula() {
        return codiAula;
    }

    public int getHoraIni() {
        return horaIni;
    }

    public int getDurada() {
        return durada;
    }

    public String getAssignacioPrintFormat() {
        if(this.isEmpty()) return "[not assigned]";
        String str = "[" + this.codiAssig + "-g" + this.numGrup + ", " + this.codiAula + "]";
        return str;
    }

    public void printAssignacioLong() {
        System.out.println("      Assignacio: " + this.getAssignacioPrintFormat());
    }

    public void printAssignacio() {
        System.out.println(this.getAssignacioPrintFormat());
    }

    public void printAssignacioXS() {
        System.out.print(this.getAssignacioPrintFormat() + " ");
    }
}
