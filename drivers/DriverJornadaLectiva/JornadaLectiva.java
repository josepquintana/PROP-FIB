package domini;


import java.sql.Time;

public class JornadaLectiva implements Cloneable
{
    private Time horaIni;
    private Time horaFi;

    public JornadaLectiva() {
        this.horaIni = new Time(0);
        this.horaFi  = new Time(0);
    }

    public JornadaLectiva(Time horaIni, Time horaFi) {
        this.horaIni = new Time(horaIni.getTime());
        this.horaFi  = new Time(horaFi.getTime());
        // missing correct time format check (?)
    }

    public JornadaLectiva(JornadaLectiva jL) {
        this.horaIni = new Time(jL.getHoraIni().getTime());
        this.horaFi  = new Time(jL.getHoraFi().getTime());
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        JornadaLectiva jL = new JornadaLectiva();
        try {
            jL = (JornadaLectiva) super.clone();

            jL.setHoraIni((Time) this.getHoraIni().clone());
            jL.setHoraFi((Time) this.getHoraFi().clone());
        }
        catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return jL;
    }

    public void setHoraIni(Time horaIni) {
        this.horaIni = new Time(horaIni.getTime());
//        else {
//            throw new IllegalArgumentException("Incorrect time format");
//        }
    }

    public void setHoraFi(Time horaFi) {
        this.horaFi = new Time(horaFi.getTime());
//        else {
//            throw new IllegalArgumentException("Incorrect time format");
//        }
    }

    public Time getHoraIni() {
        return this.horaIni;
    }

    public Time getHoraFi() {
        return this.horaFi;
    }

    public void printJornadaLectivaLong() {
        System.out.println(" horaIni: " + this.horaIni);
        System.out.println(" horaFi : " + this.horaFi);
    }

    public void printJornadaLectiva() {
        System.out.println("   jornadaLectiva: " + this.horaIni + " - " + this.horaFi);
    }
}