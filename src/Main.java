import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.sql.Time;

import domini.CentreDocent;
import domini.PeriodeLectiu;
import domini.JornadaLectiva;

public class Main
{



    public static void main(String[] args) throws Exception
    {
        String nomCentre = new String("FIB");

        Time horaIni = new Time(8, 0, 0);
        Time horaFi =  new Time(20, 0, 0);
        JornadaLectiva jornadaLectiva = new JornadaLectiva(horaIni, horaFi);

        Date dataIni = new GregorianCalendar(2018, Calendar.SEPTEMBER, 06, horaIni.getHours(), horaIni.getMinutes()).getTime();
        Date dataFi  = new GregorianCalendar(2019, Calendar.JANUARY, 28, horaFi.getHours(), horaFi.getMinutes()).getTime();
        PeriodeLectiu periodeLectiu = new PeriodeLectiu(dataIni, dataFi);

        CentreDocent cd = new CentreDocent(nomCentre, periodeLectiu, jornadaLectiva);

        cd.printCentreDocent();

    }
}