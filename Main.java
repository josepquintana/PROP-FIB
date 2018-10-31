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
    private static Titulacio t;
    private static PlaEstudis pe;

    // Execution-control variables
    static boolean printCentreDocent = true;
    static public boolean printLongFormat = true;
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

        if (printCentreDocent) {
            if (printLongFormat) cd.printCentreDocentLong();
            else cd.printCentreDocent();
        }

    }

    private static void evaluateCommand(String op) throws Exception {

        try {
            System.out.println("·Input: " + op);
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

                cd = crearCentreDocent(nomCentre, dataIni, dataFi, horaIni, horaFi);
            }
            else if (tipo.equals("Aula")) {
                Aula a = new Aula(s.next(), Integer.parseInt(s.next()));
                cd.assignarAulaAlCentreDocent(a);
            }
            else if (tipo.equals("Titulacio")) {
                t = new Titulacio(s.next(), s.next());
            }
            else if (tipo.equals("Pla Estudis")) {
                pe = new PlaEstudis(s.next(), Integer.parseInt(s.next()), Integer.parseInt(s.next()), t);
                cd.afegirPlaDeEstudis(pe);
            }
            else if (tipo.equals("Assignatura")) {
                String nomPla = s.next();
                Assignatura a = new Assignatura(s.next(), s.next(), Integer.parseInt(s.next()), Integer.parseInt(s.next()));
                Assignatura req = new Assignatura();
                while (s.hasNext()) {   // requisits
                    req = cd.getPlansDeEstudis().getPlaEstudis(nomPla).getAssignatura(s.next());
                    a.afegirRequisitAssignatura(req);
                }
                cd.afegirAssignaturaAlPlaEstudis(nomPla, a);
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

    public static CentreDocent crearCentreDocent(String nomCentre, Date dataIni, Date dataFi, Time horaIni, Time horaFi) {
        JornadaLectiva jornadaLectiva = new JornadaLectiva(horaIni, horaFi);
        PeriodeLectiu periodeLectiu = new PeriodeLectiu(dataIni, dataFi);

        cd = new CentreDocent(nomCentre, periodeLectiu, jornadaLectiva);
        return cd;
    }

//    public static void crearPlansDeEstudis() {
//        PlaEstudis pe;
//        Titulacio titulacio;
//        plansDeEstudis = new PlansDeEstudis();
//
//        titulacio = new Titulacio("Enginyeria Informatica", "GRAU");
//        pe = new PlaEstudis("Grau EngInformatica [FIB]", 132, 240-132, titulacio);
//        pe.setAssignatures(assignatures);
//        plansDeEstudis.afegirPlaEstudis(pe);
//
//        titulacio = new Titulacio("Master Inteligencia Artificial", "MASTER");
//        pe = new PlaEstudis("Master IntelArtif [FIB]", 72, 120-72, titulacio);
//        Assignatura a = new Assignatura("Master1", "Assig Master 1", 6, 2);
//        assignatures = new Assignatures();
//        assignatures.afegirAssignatura(a);
//        pe.setAssignatures(assignatures);
//        plansDeEstudis.afegirPlaEstudis(pe);
//    }
//
//    public static void assignarPlansDeEstudis() {
//        cd.setPlansDeEstudis(plansDeEstudis);
//    }



}