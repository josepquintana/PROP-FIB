package domini;

import java.io.*;
import java.nio.file.Paths;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class ReadInputFile
{
    // Read Input
    private static BufferedReader br;
    private static String op;

    public static void main (ControladorDomini cd, String filename) throws Exception {
        openFile(filename);
        readFile(cd);
        closeFile();
    }

    public static void openFile(String filename) throws IOException {

        if (!filename.endsWith(".txt")) { filename += ".txt"; }

        String workingDirectory = Paths.get(".").toAbsolutePath().normalize().toString();

        File file = new File(workingDirectory, filename);

        System.out.println("Reading file from: " + file.getAbsolutePath());

        FileInputStream fstream = new FileInputStream(file);
        br = new BufferedReader(new InputStreamReader(fstream));

        op = new String(); // Read line by line
    }

    private static void readFile(ControladorDomini cd) throws Exception {

        int inputCounter = 0;
        //while ((op = readNextLine()).charAt(0) != '@') {
        while ((op = br.readLine()) != null) {
            if (op.charAt(0) == '#') continue; // this input line is a comment
            evaluateCommand(cd, op);
            ++inputCounter;
        }

        System.out.println("Read " + inputCounter + " input lines.\n");
    }

    private static void closeFile() throws IOException {
        br.close(); // Close BufferReader
    }

    @SuppressWarnings("deprecation")
    private static void evaluateCommand(ControladorDomini cd, String op) throws Exception {

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
//                Time horaIni = new Time(Integer.parseInt(s.next()), Integer.parseInt(s.next()), 0);
//                Time horaFi  = new Time(Integer.parseInt(s.next()), Integer.parseInt(s.next()), 0);
//                JornadaLectiva jornadaLectiva = new JornadaLectiva(horaIni, horaFi);
                PlaEstudis pe = new PlaEstudis(nomPlaEstudis, cd.getJornadaLectiva(), t); // El PE te la mateixa JL que CD
//                PlaEstudis pe = new PlaEstudis(nomPlaEstudis, jornadaLectiva, t);
                cd.afegirPlaEstudis(pe);
            }
            else if (categoria.equals("Aula")) {
                String codiAula = s.next();
                int capacitat = Integer.parseInt(s.next());
                Boolean teOrdinadors = s.next().equals("true");
                Aula aula = new Aula(codiAula, capacitat, teOrdinadors);
                cd.afegirAula(aula);
            }
            else if (categoria.equals("Assignatura")) {
                String nomPla = s.next();
                String codi = s.next();
                String descripcio = s.next();
                Double credits = Double.parseDouble(s.next());
                int nivell = Integer.parseInt(s.next());
                
                int capacitatTotal = Integer.parseInt(s.next());
                int nGrups = Integer.parseInt(s.next());
                int nSubGrups = Integer.parseInt(s.next());
                Boolean teLabAmbPCs = s.next().equals("true");

                Assignatura a = new Assignatura(codi, descripcio, credits, nivell, teLabAmbPCs);

                Grup g;
                int capacitatGrupTeoria = capacitatTotal / nGrups;
                for (int i = 10; i <= nGrups * 10; i = i + 10) {    // grups

                    g = new Grup(i, capacitatGrupTeoria, false, a.getSessionsTeoria(), 0, false);
                    a.afegirGrupAssignatura(g);

                    int capacitatSubGrup = capacitatGrupTeoria / nSubGrups;
                    for (int j = 1; j <= nSubGrups; j++) {
                        int numSubGrup = g.getNumGrup() + j;
                        Grup sG = new Grup(numSubGrup, capacitatSubGrup, true, 0, a.getSessionsLab(), a.teLabAmbPCs());
                        a.afegirGrupAssignatura(sG);
                    }
                }

                String req;
                while (s.hasNext()) {   // requisits
                    req = cd.getPlaEstudis(nomPla).getAssignatura(s.next()).getCodi();
                    // TO DO: vigilar que no peti per haver posar una assig no valida!
                    a.afegirCorrequisitAssignatura(req/*.getCodi()*/);
                }
                cd.getPlaEstudis(nomPla).afegirAssignaturaAlPlaEstudis(a);
            }
            else;
        }

        catch (Exception e) {
            System.out.print("> !Error al evaluar comanda del fitxer: " + e.getMessage() + " @ input line: \"" + op + "\"\n");
            throw new Exception();
        }
    }

}
