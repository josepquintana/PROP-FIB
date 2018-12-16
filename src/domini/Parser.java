package domini;

import java.sql.Time;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Parser
{
    @SuppressWarnings("deprecation")
    protected static void centreDocent(String line, ControladorDomini controladorDomini)
    {
        String[] fields = line.split(", ");
        String nomCentre = fields[1];

        Time horaIni = new Time(Integer.parseInt(fields[2]), Integer.parseInt(fields[3]), 0);
        Time horaFi  = new Time(Integer.parseInt(fields[4]), Integer.parseInt(fields[5]), 0);
        JornadaLectiva jornadaLectiva = new JornadaLectiva(horaIni, horaFi);

        int day = Integer.parseInt(fields[6]);
        String month = fields[7];
        int year = Integer.parseInt(fields[8]);
        Date dataIni = new GregorianCalendar(year, getMonthNumber(month), day, horaIni.getHours(), horaIni.getMinutes()).getTime();

        day = Integer.parseInt(fields[9]);
        month = fields[10];
        year = Integer.parseInt(fields[11]);
        Date dataFi  = new GregorianCalendar(year, getMonthNumber(month), day, horaFi.getHours(), horaFi.getMinutes()).getTime();

        PeriodeLectiu periodeLectiu = new PeriodeLectiu(dataIni, dataFi);

        controladorDomini.setNomCentre(nomCentre);
        controladorDomini.setPeriodeLectiu(periodeLectiu);
        controladorDomini.setJornadaLectiva(jornadaLectiva);
    }

    @SuppressWarnings("deprecation")
    protected static PlaEstudis plaEstudis(String line, JornadaLectiva jLect_CentreDocent) throws MyException
    {
        String[] fields = line.split(", ");

        String nomPlaEstudis = fields[1];
        Titulacio t = new Titulacio(fields[2], fields[3]);
        Time horaIni = new Time(Integer.parseInt(fields[4]), 0, 0);
        Time horaFi  = new Time(Integer.parseInt(fields[5]), 0, 0);
        JornadaLectiva jornadaLectiva = new JornadaLectiva(horaIni, horaFi);
        if (!jornadaLectiva.includedInJLec(jLect_CentreDocent)) {
            throw new MyException("La Jornada Lectiva del Pla d'Estudis no esta inclosa en la del Centre Docent");
        }
        PlaEstudis plaEstudis = new PlaEstudis(nomPlaEstudis, new JornadaLectiva(horaIni, horaFi), t);
        return plaEstudis;
    }

    protected static Aula aula(String line)
    {
        String[] fields = line.split(", ");

        String codiAula = fields[1];
        int capacitat = Integer.parseInt(fields[2]);
        Boolean teOrdinadors = fields[3].equals("true");
        Aula aula = new Aula(codiAula, capacitat, teOrdinadors);

        return aula;
    }

    protected static Assignatura assignatura(String line) throws MyException
    {
        String[] fields = line.split(", ");

        String nomPla = fields[1];
        String codi = fields[2];
        String descripcio = fields[3];
        Double credits = Double.parseDouble(fields[4]);
        int nivell = Integer.parseInt(fields[5]);

        int capacitatTotal = Integer.parseInt(fields[6]);
        int nGrups = Integer.parseInt(fields[7]);
        int nSubGrups = Integer.parseInt(fields[8]);
        Boolean teLabAmbPCs = fields[9].equals("true");

        Assignatura a = new Assignatura(codi, descripcio, credits, nivell, teLabAmbPCs);

        int capacitatGrupTeoria = capacitatTotal / nGrups;
        for (int i = 10; i <= nGrups * 10; i = i + 10) {    // grups
            Grup g = new Grup(i, capacitatGrupTeoria, false, a.getSessionsTeoria(), 0, false);
            a.afegirGrupAssignatura(g);

            int capacitatSubGrup = capacitatGrupTeoria / nSubGrups;
            for (int j = 1; j <= nSubGrups; j++) {
                int numSubGrup = g.getNumGrup() + j;
                Grup sG = new Grup(numSubGrup, capacitatSubGrup, true, 0, a.getSessionsLab(), a.teLabAmbPCs());
                a.afegirGrupAssignatura(sG);
            }
        }

        for (int i = 10; i < fields.length; i++) { // requisits
//            req = cd.getPlaEstudis(nomPla).getAssignatura(s.next()).getCodi();
            // TO DO: vigilar que no peti per haver posar una assig no valida!
            a.afegirCorrequisitAssignatura(fields[i]);
        }

        return a;
    }

    /**
     * auxiliar methods
     *
     */
    private static int getMonthNumber(String month) {
        if (month.equalsIgnoreCase("JANUARY"))   return 0;
        if (month.equalsIgnoreCase("FEBRUARY"))  return 1;
        if (month.equalsIgnoreCase("MARCH"))     return 2;
        if (month.equalsIgnoreCase("APRIL"))     return 3;
        if (month.equalsIgnoreCase("MAY"))       return 4;
        if (month.equalsIgnoreCase("JUNE"))      return 5;
        if (month.equalsIgnoreCase("JULY"))      return 6;
        if (month.equalsIgnoreCase("AUGUST"))    return 7;
        if (month.equalsIgnoreCase("SEPTEMBER")) return 8;
        if (month.equalsIgnoreCase("OCTOBER"))   return 9;
        if (month.equalsIgnoreCase("NOVEMBER"))  return 10;
        if (month.equalsIgnoreCase("DECEMBER"))  return 11;
        return 99;
    }

}
