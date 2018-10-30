import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.sql.Time;
import java.util.Random;

import domini.*;

public class Main
{
    // Data Structures to store all the information
    static CentreDocent cd;
    static Aules aules;
    static PlansDeEstudis plansDeEstudis;
    static Assignatures assignatures;


    // Execution-control variables
    static boolean all = true;

    public static void main(String[] args) throws Exception
    {
        crearCentreDocent();
        crearAules();
        assignarAules();
        crearPlansDeEstudis();
        assignarPlansDeEstudis();
        crearAssignatures();
        assignarAssignatures();

        cd.printCentreDocentLong();

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

    public static void crearAules() throws MyException{
        Aula a;
        aules = new Aules();
        a = new Aula("A5E02", 120);
        aules.afegirAula(a);
        a = new Aula("A5S108", 30);
        aules.afegirAula(a);
        a = new Aula("A6201", 80);
        aules.afegirAula(a);
        a = new Aula("D6003", 15);
        aules.afegirAula(a);
        a = new Aula("A1S101", 30);
        aules.afegirAula(a);
        a = new Aula("C6S306", 20);
        aules.afegirAula(a);
        a = new Aula("B5S102", 25);
        aules.afegirAula(a);
        a = new Aula("A4105", 60);
        aules.afegirAula(a);
        a = new Aula("A5001", 90);
        aules.afegirAula(a);
    }

    public static void assignarAules() {
        cd.setAules(aules);
    }

    public static void crearPlansDeEstudis() {
        PlaEstudis pe;
        Titulacio titulacio;
        plansDeEstudis = new PlansDeEstudis();

        titulacio = new Titulacio("Enginyeria Informatica", "GRAU");
        pe = new PlaEstudis("Grau EngInformatica [FIB]", 132, 240-132, titulacio);
        plansDeEstudis.afegirPlaEstudis(pe);

        titulacio = new Titulacio("Master Inteligencia Artificial", "MASTER");
        pe = new PlaEstudis("Master IntelArtif [FIB]", 72, 120-72, titulacio);
        plansDeEstudis.afegirPlaEstudis(pe);
    }

    public static void assignarPlansDeEstudis() {
        cd.setPlansDeEstudis(plansDeEstudis);
    }

    public static void crearAssignatures() {
        Assignatura a = new Assignatura("PROP");

    }


    public static void assignarAssignatures()
    {

    }

}