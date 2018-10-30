import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.sql.Time;
import java.lang.Object;

import domini.*;

public class Main
{
    static CentreDocent cd;

    public static void main(String[] args) throws Exception
    {
        crearCentreDocent();
        crearAules();
        assignarAules();
        crearPlansDeEstudis();
        assignarPlansDeEstudis();
        crearAssignatures();
        assignarAssignatures();

        cd.printCentreDocent();

    }

    public static void crearCentreDocent()
    {
        String nomCentre = new String("FIB");

        Time horaIni = new Time(8, 0, 0);
        Time horaFi =  new Time(20, 0, 0);
        JornadaLectiva jornadaLectiva = new JornadaLectiva(horaIni, horaFi);

        Date dataIni = new GregorianCalendar(2018, Calendar.SEPTEMBER, 06, horaIni.getHours(), horaIni.getMinutes()).getTime();
        Date dataFi  = new GregorianCalendar(2019, Calendar.JANUARY, 28, horaFi.getHours(), horaFi.getMinutes()).getTime();
        PeriodeLectiu periodeLectiu = new PeriodeLectiu(dataIni, dataFi);

        cd = new CentreDocent(nomCentre, periodeLectiu, jornadaLectiva);
    }

    public static void crearAules() {

    }

    public static void assignarAules() {

    }

    public static void crearPlansDeEstudis() {

    }

    public static void assignarPlansDeEstudis() {

    }

    public static void crearAssignatures() {

    }


    public static void assignarAssignatures()
    {

    }

}