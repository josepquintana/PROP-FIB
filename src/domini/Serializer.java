package domini;

import java.util.ArrayList;
import java.text.DateFormatSymbols;

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
            line += (assignatura.getNumGrupsTeoria() + ", ");
            line += (assignatura.getNumGrupsLab() + ", ");
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

}
