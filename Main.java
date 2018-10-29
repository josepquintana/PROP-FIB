import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.sql.Time;

import domini.*;

public class Main
{



    public static void main(String[] args) throws Exception
    {
        createCentreDocent();
    }

    public static void createCentreDocent() throws MyException {
        String nomCentre = new String("FIB");

        Time horaIni = new Time(8, 0, 0);
        Time horaFi =  new Time(20, 0, 0);
        JornadaLectiva jornadaLectiva = new JornadaLectiva(horaIni, horaFi);

        Date dataIni = new GregorianCalendar(2018, Calendar.SEPTEMBER, 06, horaIni.getHours(), horaIni.getMinutes()).getTime();
        Date dataFi  = new GregorianCalendar(2019, Calendar.JANUARY, 28, horaFi.getHours(), horaFi.getMinutes()).getTime();
        PeriodeLectiu periodeLectiu = new PeriodeLectiu(dataIni, dataFi);

        CentreDocent cd = new CentreDocent(nomCentre, periodeLectiu, jornadaLectiva);

        Aula a = new Aula("A5E02", 80);
        cd.assignarAulaACentreDocent(a);
        Aula b = new Aula("C6S308", 25);
        cd.assignarAulaACentreDocent(b);
        Aula c = new Aula("C6S309", 30);
        //cd.assignarAulaACentreDocent(c);

        cd.printCentreDocent();


        cd.desassignarAulaDeCentreDocent(c);

        cd.printCentreDocent();

    }

}