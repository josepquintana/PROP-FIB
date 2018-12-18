package domini;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.text.DateFormatSymbols;
import java.util.Date;

public class Serializer
{
    @SuppressWarnings("deprecation")
    protected static String centreDocent(ControladorDomini controladorDomini)
    {
        String line = "Centre Docent, ";

        line += (controladorDomini.getNomCentre() + ", ");
        line += (controladorDomini.getJornadaLectiva().getHoraIni().getHours() + ", ");
        line += (controladorDomini.getJornadaLectiva().getHoraIni().getMinutes() + ", ");
        line += (controladorDomini.getJornadaLectiva().getHoraFi().getHours() + ", ");
        line += (controladorDomini.getJornadaLectiva().getHoraFi().getMinutes() + ", ");
        line += (controladorDomini.getPeriodeLectiu().getDataIni().getDate() + ", ");
        line += (new DateFormatSymbols().getMonths()[controladorDomini.getPeriodeLectiu().getDataIni().getMonth()].toUpperCase() + ", ");
        line += ((controladorDomini.getPeriodeLectiu().getDataIni().getYear() + 1900) + ", ");
        line += (controladorDomini.getPeriodeLectiu().getDataFi().getDate() + ", ");
        line += (new DateFormatSymbols().getMonths()[controladorDomini.getPeriodeLectiu().getDataFi().getMonth()].toUpperCase() + ", ");
        line += ((controladorDomini.getPeriodeLectiu().getDataFi().getYear() + 1900));

        return line;
    }

    public static String date(Date date)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        String line = sdf.format(date);
        return line;
    }

    public static String time(Time time)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String line = sdf.format(time);
        return line;
    }

    @SuppressWarnings("deprecation")
    protected static ArrayList<String> plansDeEstudis(PlansDeEstudis plansDeEstudis) throws MyException
    {
        ArrayList<String> lines = new ArrayList<>();

        for (PlaEstudis pe : plansDeEstudis.getPlansDeEstudis()) {
            String line = "Pla Estudis, ";
            line += (pe.getNomPla() + ", ");
            line += (pe.getTitulacio().getNomTitulacio() + ", ");
            line += (pe.getTitulacio().getTipusTitulacio() + ", ");
            line += (pe.getJornadaLectiva().getHoraIni().getHours() + ", ");
            line += (pe.getJornadaLectiva().getHoraFi().getHours());

            lines.add(line);
        }

        return lines;
    }

    protected static ArrayList<String> aules(Aules aules)
    {
        ArrayList<String> lines = new ArrayList<>();

        for (Aula aula : aules.getAules()) {
            String line = "Aula, ";
            line += (aula.getCodi() + ", ");
            line += (aula.getCapacitat() + ", ");
            line += (aula.isLab());

            lines.add(line);
        }

        return lines;
    }

    protected static ArrayList<String> assignatures(Assignatures assignatures, String nomPlaEstudis) throws MyException
    {
        ArrayList<String> lines = new ArrayList<>();

        for (Assignatura assignatura : assignatures.getAssignatures()) {
            String line = "Assignatura, ";
            line += (nomPlaEstudis + ", ");
            line += (assignatura.getCodi() + ", ");
            line += (assignatura.getNom() + ", ");
            line += (assignatura.getCredits() + ", ");
            line += (assignatura.getNivell() + ", ");
            line += (assignatura.getCapacitatAssignatura() + ", ");
            line += (assignatura.getNumGrupsGenerals() + ", ");
            line += (assignatura.getNumSubGrupsXGrup() + ", ");
            line += (assignatura.teLabAmbPCs());
            if (assignatura.teCorrequisits()) {
                for (String correq : assignatura.getCorrequisits()) {
                    line += (", " + correq);
                }
            }
            lines.add(line);
        }

        return lines;
    }

    protected static ArrayList<String>[][] horari(Assignacio[][][] horari) throws MyException
    {
        ArrayList<String>[][] matrix = new ArrayList[horari.length][horari[0].length];

        for (int i = 0; i < horari.length; i++) {
            for (int j = 0; j < horari[i].length; j++) {
                matrix[i][j] = new ArrayList<>();
                for (int k = 0; k < horari[i][j].length; k++) {
                    if (horari[i][j][k] != null) matrix[i][j].add(assignacio(horari[i][j][k]));
                    else matrix[i][j].add("      ---        ");
                }
            }
        }

        return matrix;
    }

    protected static String assignacio(Assignacio asg)
    {
        if(asg.isEmpty()) return "[assignacio buida]";
        String line = "[" + asg.getCodiAula() + ": " + asg.getCodiAssig() + "-" + asg.getNumGrup() + "]";
        int length = line.length();
        for (int i = 1; i <= (("[A5S108: PROP-10]").length() - length); i++) {
            line += " "; // indentation
        }

        return line;
    }

}
