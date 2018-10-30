import java.io.*;
import java.net.Inet4Address;
import java.util.*;
import java.sql.Time;

import domini.*;

///////////////////////////////////////////////////////////////
// Hi ha molta xixa al main pq ho he fet rapid per debuggar, ya fare una nova classe
///////////////////////////////////////////////////////////////

public class Main
{
    // Read Input
    private static File file;
    private static FileInputStream fstream;
    private static BufferedReader br;
    private static String op;

    // Data Structures to store all the information
    private static CentreDocent cd;
    private static Aules aules;
    private static PlansDeEstudis plansDeEstudis;
    private static Assignatures assignatures;


    // Execution-control variables
    public boolean printLongFormat = true;
    static boolean printCentreDocent = false;
    static boolean all = true;

    public static void main(String[] args) throws Exception
    {
        openFile();

        while ((op = readNextLine()) != null) { evaluateCommand(op); }

        closeFile();

        //crearCentreDocent();
        //crearAules();
        //assignarAules();
        //crearAssignatures();
        //crearPlansDeEstudis();
        //assignarPlansDeEstudis();

        if (printCentreDocent) cd.printCentreDocentLong();

    }

    private static void evaluateCommand(String op) throws Exception {

        try {
            System.out.println(op);
            Scanner s = new Scanner(op).useDelimiter(", ");

            String tipo = s.next();
            if (tipo.equals("Centre Docent")) {
                String nomCentre = s.next();

                Time horaIni = new Time(Integer.parseInt(s.next()), Integer.parseInt(s.next()), 0);
                Time horaFi  = new Time(Integer.parseInt(s.next()), Integer.parseInt(s.next()), 0);

                int day = Integer.parseInt(s.next());
                String month = s.next(); // !!! Calcular be
                int year = Integer.parseInt(s.next());
                Date dataIni = new GregorianCalendar(year, Calendar.SEPTEMBER, day, horaIni.getHours(), horaIni.getMinutes()).getTime();

                day = Integer.parseInt(s.next());
                month = s.next(); // !!! Calcular be
                year = Integer.parseInt(s.next());
                Date dataFi  = new GregorianCalendar(year, Calendar.JANUARY, day, horaIni.getHours(), horaIni.getMinutes()).getTime();

                crearCentreDocent(nomCentre, dataIni, dataFi, horaIni, horaFi);
                cd.printCentreDocent();
            }
            else if (tipo.equals("Aula")) {

            }
            else if (tipo.equals("Assignatura")) {

            }
            else if (tipo.equals("Pla Esutdis")) {

            }
        }

        catch (Exception e) {
            //System.out.println("> !Error al evaluar comanda del fitxer");
            System.out.println(e.getMessage());
        }
    }


    public static void openFile() throws IOException {

        String workingDirectory = System.getProperty("user.dir");
        String filename =  "input.txt";
        file = new File(workingDirectory, filename);

        System.out.println("Reading file from: " + file.getAbsolutePath());

        fstream = new FileInputStream(file);
        br = new BufferedReader(new InputStreamReader(fstream));

        op = new String(); // Read line by line
    }

    public static void closeFile() throws IOException {
        br.close(); // Close BufferReader
    }

    public static String readNextLine() throws IOException {

        String strLine = br.readLine();
        return strLine;
    }

    public static void crearCentreDocent(String nomCentre, Date dataIni, Date dataFi, Time horaIni, Time horaFi) {
//        String nomCentre = new String("FIB");

//        Time horaIni = new Time(8, 0, 0);
//        Time horaFi =  new Time(20, 0, 0);
        JornadaLectiva jornadaLectiva = new JornadaLectiva(horaIni, horaFi);

//        Date dataIni = new GregorianCalendar(2018, Calendar.SEPTEMBER, 06, horaIni.getHours(), horaIni.getMinutes()).getTime();
//        Date dataFi  = new GregorianCalendar(2019, Calendar.JANUARY, 28, horaFi.getHours(), horaFi.getMinutes()).getTime();
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

    public static void crearAssignatures() throws MyException {
        Assignatura a1 = new Assignatura("PRO1",	"Projectes de Programació",6, 1);
//        Assignatura a2 = new Assignatura("F", 	    "Projectes de Programació",6, 1);
//        Assignatura a3 = new Assignatura("IC", 	"Projectes de Programació",6, 1);
//        Assignatura a4 = new Assignatura("FM", 	"Projectes de Programació",6, 1);
        Assignatura a5 = new Assignatura("PRO2",   "Projectes de Programació",6, 2);
//        Assignatura a6 = new Assignatura("EC", 	"Projectes de Programació",6, 2);
        Assignatura a7 = new Assignatura("M1", 	"Projectes de Programació",6, 2);
        Assignatura a8 = new Assignatura("M2", 	"Projectes de Programació",6, 2);
        Assignatura a9 = new Assignatura("EDA",	"Projectes de Programació",6, 3);
//        Assignatura a10 = new Assignatura("BD", 	"Projectes de Programació",6, 3);
//        Assignatura a11 = new Assignatura("CI", 	"Projectes de Programació",6, 3);
//        Assignatura a12 = new Assignatura("SO", 	"Projectes de Programació",6, 3);
        Assignatura a13 = new Assignatura("PE", 	"Projectes de Programació",6, 3);
//        Assignatura a14 = new Assignatura("IES",	"Projectes de Programació",6, 4);
//        Assignatura a15 = new Assignatura("IDI",	"Projectes de Programació",6, 4);
//        Assignatura a16 = new Assignatura("XC", 	"Projectes de Programació",6, 4);
//        Assignatura a17 = new Assignatura("AC", 	"Projectes de Programació",6, 4);
//        Assignatura a18 = new Assignatura("EEE",	"Projectes de Programació",6, 4);
//        Assignatura a19 = new Assignatura("PROP",	"Projectes de Programació",6, 5);
//        Assignatura a20 = new Assignatura("PAR",	"Paral·lelisme           ",6, 6);

        Main.assignatures = new Assignatures();

        Main.assignatures.afegirAssignatura(a1);
//        Main.assignatures.afegirAssignatura(a2);
//        Main.assignatures.afegirAssignatura(a3);
//        Main.assignatures.afegirAssignatura(a4);
        Main.assignatures.afegirAssignatura(a5);
//        Main.assignatures.afegirAssignatura(a6);
        Main.assignatures.afegirAssignatura(a7);
        Main.assignatures.afegirAssignatura(a8);
        Main.assignatures.afegirAssignatura(a9);
//        Main.assignatures.afegirAssignatura(a10);
//        Main.assignatures.afegirAssignatura(a11);
//        Main.assignatures.afegirAssignatura(a12);
        Main.assignatures.afegirAssignatura(a13);
//        Main.assignatures.afegirAssignatura(a14);
//        Main.assignatures.afegirAssignatura(a15);
//        Main.assignatures.afegirAssignatura(a16);
//        Main.assignatures.afegirAssignatura(a17);
//        Main.assignatures.afegirAssignatura(a18);
//        Main.assignatures.afegirAssignatura(a19);
//        Main.assignatures.afegirAssignatura(a20);

        ArrayList<Assignatura> reqs = new ArrayList<>();
        reqs.add(a1);
        reqs.add(a5);
        a9.setRequisits(reqs);

        a13.afegirRequisitAssignatura(a7);
        a13.afegirRequisitAssignatura(a8);

    }

    public static void crearPlansDeEstudis() {
        PlaEstudis pe;
        Titulacio titulacio;
        plansDeEstudis = new PlansDeEstudis();

        titulacio = new Titulacio("Enginyeria Informatica", "GRAU");
        pe = new PlaEstudis("Grau EngInformatica [FIB]", 132, 240-132, titulacio);
        pe.setAssignatures(assignatures);
        plansDeEstudis.afegirPlaEstudis(pe);

        titulacio = new Titulacio("Master Inteligencia Artificial", "MASTER");
        pe = new PlaEstudis("Master IntelArtif [FIB]", 72, 120-72, titulacio);
        Assignatura a = new Assignatura("Master1", "Assig Master 1", 6, 2);
        assignatures = new Assignatures();
        assignatures.afegirAssignatura(a);
        pe.setAssignatures(assignatures);
        plansDeEstudis.afegirPlaEstudis(pe);
    }

    public static void assignarPlansDeEstudis() {
        cd.setPlansDeEstudis(plansDeEstudis);
    }



}