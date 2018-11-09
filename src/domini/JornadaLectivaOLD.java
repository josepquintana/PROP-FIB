/*

/////////////////////////////////////////////////////////////////////////////////
///////////////////////   Implemented with integers    //////////////////////////
/////////////////////////////////////////////////////////////////////////////////

package domini;

import org.jetbrains.annotations.NotNull;

public class JornadaLectivaOLD
{
    private int horaIni;
    private int minutIni;
    private int horaFi;
    private int minutFi;

    public JornadaLectivaOLD(int horaIni, int minutIni, int horaFi, int minutFi) {
        this.horaIni  = horaIni;
        this.minutIni = minutIni;
        this.horaFi   = horaFi;
        this.minutFi  = minutFi;
        // missing correct time format check (?)
    }

    public JornadaLectivaOLD(@NotNull JornadaLectivaOLD jL) {
        this.horaIni  = jL.getHoraIni();
        this.minutIni = jL.getMinutIni();
        this.horaFi   = jL.getHoraFi();
        this.minutFi  = jL.getMinutFi();
    }

    public void setHoraMinutIni(int horaIni, int minutIni) {
        if ((horaIni >= 0 && horaIni < 24) && (minutIni >= 0 && minutIni < 60)) {
            this.horaIni = horaIni;
            this.minutIni = minutIni;
        }
        else {
            throw new IllegalArgumentException("Incorrect time format");
        }
    }

    public void setHoraMinutFi(int horaFi, int minutFi) {
        if ((horaFi >= 0 && horaFi < 24) && (minutFi >= 0 && minutFi < 60)) {
            this.horaFi = horaFi;
            this.minutFi = minutFi;
        }
        else {
            throw new IllegalArgumentException("Incorrect time format");
        }
    }

    public int getHoraIni() {
        return this.horaIni;
    }

    public int getMinutIni() {
        return this.minutIni;
    }

    public int getHoraFi() {
        return this.horaFi;
    }

    public int getMinutFi() {
        return this.minutFi;
    }

    public void printJornadaLectiva() {
        System.out.println(" horaIni: " + this.horaIni + ":" + this.minutIni + "h");
        System.out.println(" horaFi : " + this.horaFi  + ":" + this.minutFi  + "h");
    }
}*/
