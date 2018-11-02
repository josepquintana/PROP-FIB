import java.io.*;
import java.nio.file.Paths;
import java.util.*;
import java.sql.Time;

import domini.*;

///////////////////////////////////////////////////////////////
// Hi ha molta xixa al main pq ho he fet rapid per debuggar, ya fare una nova classe
///////////////////////////////////////////////////////////////

public class Main
{
    // Read Input
    private static BufferedReader br;
    private static String op;

    // Data Structures to store all the information
    private static CentreDocent cd;
    private static Titulacio t;
    private static PlaEstudis pe;
    private static Assignacio asg;

    // Execution-control variables
    private static boolean printInputLines      = !true; // counter // final #
    private static boolean printCentreDocent    = true;
    private static boolean printLongFormat      = !true;

    public static void main(String[] args) throws Exception
    {
        openFile();
        int inputCounter = 0;
        while ((op = readNextLine()) != null) {
            if (op.charAt(0) == '#') continue; // this input line is a comment
            if (printInputLines) System.out.println("· Input:   " + op);
            evaluateCommand(op);
            ++inputCounter;
        }

        System.out.println("Read " + inputCounter + " from the input file.");
        closeFile();

        if (printCentreDocent) {
            if (printLongFormat) cd.printCentreDocentLong();
            else cd.printCentreDocent();
        }

    }

    private static void evaluateCommand(String op) throws Exception {

        try {
            Scanner s = new Scanner(op).useDelimiter(", ");
            String categoria = s.next();

            if      (categoria.equals("Centre Docent")) {
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
            else if (categoria.equals("Aula")) {
                Aula aula = new Aula(s.next(), Integer.parseInt(s.next()));
                cd.assignarAulaAlCentreDocent(aula);
            }
            else if (categoria.equals("Titulacio")) {
                t = new Titulacio(s.next(), s.next());
            }
            else if (categoria.equals("Pla Estudis")) {
                pe = new PlaEstudis(s.next(), t);
                cd.afegirPlaEstudis(pe);
            }
            else if (categoria.equals("Assignatura")) {
                String nomPla = s.next();
                Assignatura a = new Assignatura(s.next(), s.next(), Double.parseDouble(s.next()), Integer.parseInt(s.next()));

                int ctotal = Integer.parseInt(s.next());
                int cgrup = Integer.parseInt(s.next());
                int ngrups = ctotal / cgrup;
                Grup g;
                for (int i = 10; i <= ngrups * 10; i = i + 10) {    // grups
                    g = new Grup(a.getCodi(), i, cgrup);
                    a.afegirGrupAssignatura(g);
                }

                Assignatura req;
                while (s.hasNext()) {   // requisits
                    req = new Assignatura();
                    req = cd.getPlaEstudis(nomPla).getAssignatura(s.next());
                    // TO DO: vigilar que no peti per haver posar una assig no valida!
                    a.afegirRequisitAssignatura(req);
                }
                cd.afegirAssignaturaAlPlaEstudis(nomPla, a);
            }
            
            else if (categoria.equals("Assignacio")) {  }
            else;
        }

        catch (Exception e) {
            System.out.print("> !Error al evaluar comanda del fitxer: " + e.getMessage() + "\n");
        }
    }

    public static void openFile() throws IOException {

        String workingDirectory = Paths.get(".\\src").toAbsolutePath().normalize().toString();

        String filename = "input.txt";
        File file = new File(workingDirectory, filename);

        System.out.println("Reading file from: " + file.getAbsolutePath());

        FileInputStream fstream = new FileInputStream(file);
        br = new BufferedReader(new InputStreamReader(fstream));

        op = new String(); // Read line by line
    }

    public static String readNextLine() throws IOException {

        String strLine = br.readLine();
        return strLine;
    }

    public static void closeFile() throws IOException {
        br.close(); // Close BufferReader
    }

    public static CentreDocent crearCentreDocent(String nomCentre, Date dataIni, Date dataFi, Time horaIni, Time horaFi) {
        JornadaLectiva jornadaLectiva = new JornadaLectiva(horaIni, horaFi);
        PeriodeLectiu periodeLectiu = new PeriodeLectiu(dataIni, dataFi);

        cd = new CentreDocent(nomCentre, periodeLectiu, jornadaLectiva);
        return cd;
    }

}