package domini;

import org.jetbrains.annotations.NotNull;
import java.sql.Time;

public class JornadaLectiva
{
    private Time horaIni;
    private Time horaFi;

    public JornadaLectiva(Time horaIni, Time horaFi) {
        this.horaIni = new Time(horaIni.getTime());
        this.horaFi  = new Time(horaFi.getTime());
        // missing correct time format check (?)
    }

    public JornadaLectiva(@NotNull JornadaLectiva jL) {
        this.horaIni = new Time(jL.getHoraIni().getTime());
        this.horaFi  = new Time(jL.getHoraFi().getTime());
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

    public void printJornadaLectiva() {
        System.out.println(" horaIni: " + this.horaIni);
        System.out.println(" horaFi : " + this.horaFi);
    }
}