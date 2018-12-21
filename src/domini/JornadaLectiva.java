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
    }

    public JornadaLectiva(JornadaLectiva jL) {
        this.horaIni = new Time(jL.getHoraIni().getTime());
        this.horaFi  = new Time(jL.getHoraFi().getTime());
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        JornadaLectiva jL;
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

    public boolean includedInJLec(JornadaLectiva jL) {
        if (this.horaIni.getTime() >= jL.getHoraIni().getTime() && this.horaFi.getTime() <= jL.getHoraFi().getTime()) return true;
        return false;
    }

    public void setHoraIni(Time horaIni) {
        this.horaIni = new Time(horaIni.getTime());
    }

    public void setHoraFi(Time horaFi) {
        this.horaFi = new Time(horaFi.getTime());
    }

    public Time getHoraIni() {
        return this.horaIni;
    }

    public Time getHoraFi() {
        return this.horaFi;
    }

}