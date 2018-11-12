package presentacio;

import java.io.*;
import java.nio.file.Paths;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import domini.CentreDocent;
import domini.JornadaLectiva;
import domini.PeriodeLectiu;
import domini.Aula;
import domini.PlaEstudis;
import domini.Titulacio;
import domini.Assignatura;
import domini.Grup;


public class ReadFile
{
    // Read Input
    private static BufferedReader br;
    private static String op;

    // Execution-control variables
    private static int printInputLines = 0;     // 0 -> noPrint; 1 -> printInputLines  // counter // final #

    public static void main (CentreDocent cd, String filename) throws Exception {
        openFile(filename);
        readFile(cd);
        closeFile();
    }

    public static void openFile(String filename) throws IOException {

//        if (!filename.endsWith(".txt")) { filename += ".txt"; }

        String workingDirectory = Paths.get(".\\input").toAbsolutePath().normalize().toString();
        File file = new File(workingDirectory, filename);

        System.out.println("Reading file from: " + file.getAbsolutePath());

        FileInputStream fstream = new FileInputStream(file);
        br = new BufferedReader(new InputStreamReader(fstream));

        op = new String(); // Read line by line
    }

    private static void readFile(CentreDocent cd) throws Exception {

        int inputCounter = 0;
        //while ((op = readNextLine()).charAt(0) != '@') {
        while ((op = br.readLine()) != null) {
            if (op.charAt(0) == '#') continue; // this input line is a comment
            if (printInputLines == 1) System.out.println("· Input:   " + op);
            evaluateCommand(cd, op);
            ++inputCounter;
        }

        System.out.println("Read " + inputCounter + " input lines.\n");
    }

    private static void closeFile() throws IOException {
        br.close(); // Close BufferReader
    }

    private static void evaluateCommand(CentreDocent cd, String op) throws Exception {

        try {
            Scanner s = new Scanner(op).useDelimiter(", ");
            String categoria = s.next();

            if      (categoria.equals("Centre Docent")) {
                String nomCentre = s.next();

                Time horaIni = new Time(Integer.parseInt(s.next()), Integer.parseInt(s.next()), 0);
                Time horaFi  = new Time(Integer.parseInt(s.next()), Integer.parseInt(s.next()), 0);
                JornadaLectiva jornadaLectiva = new JornadaLectiva(horaIni, horaFi);

                int day = Integer.parseInt(s.next());
                String month = s.next(); // !!! Calcular be
                int year = Integer.parseInt(s.next());
                Date dataIni = new GregorianCalendar(year, Calendar.SEPTEMBER, day, horaIni.getHours(), horaIni.getMinutes()).getTime();

                day = Integer.parseInt(s.next());
                month = s.next(); // !!! Calcular be
                year = Integer.parseInt(s.next());
                Date dataFi  = new GregorianCalendar(year, Calendar.JANUARY, day, horaFi.getHours(), horaFi.getMinutes()).getTime();

                PeriodeLectiu periodeLectiu = new PeriodeLectiu(dataIni, dataFi);

                cd.setNomCentre(nomCentre);
                cd.setPeriodeLectiu(periodeLectiu);
                cd.setJornadaLectiva(jornadaLectiva);
            }
            else if (categoria.equals("Pla Estudis")) {
                String nomPlaEstudis = s.next();
                Titulacio t = new Titulacio(s.next(), s.next());
                PlaEstudis pe = new PlaEstudis(nomPlaEstudis, cd.getJornadaLectiva(), t); // El PE te la mateixa JL que CD
                cd.afegirPlaEstudis(pe);
            }
            else if (categoria.equals("Aula")) {
                String nomPla = s.next();
                Aula aula = new Aula(s.next(), Integer.parseInt(s.next()));
                cd.afegirAulaAlPlaEstudis(nomPla, aula);
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
                    a.afegirCorrequisitAssignatura(req/*.getCodi()*/);
                }
                cd.afegirAssignaturaAlPlaEstudis(nomPla, a);
            }
            else;
        }

        catch (Exception e) {
            System.out.print("> !Error al evaluar comanda del fitxer: " + e.getMessage() + "\n");
            throw new Exception();
        }
    }

}
