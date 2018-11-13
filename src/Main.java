import domini.*;
import presentacio.ReadFile;
import presentacio.WriteHorari;

import java.util.ArrayList;

public class Main
{
    // Data Structures to store all the information --------> dades/
    private static CentreDocent cd;

    // Execution-control variables
    private static int    printMode      = 2;                    // 0 -> noPrint; 1 -> XS; 2 -> Normal; 3 -> Long
    private static String inputFileName  = "input-short";              // filename for the data input
    private static String outputFileName = "output";             // filename for the horari output

    public static void main(String[] args) throws Exception
    {
        printHello();
        cd = new CentreDocent();
        ReadFile.main(cd, inputFileName);
        printDades(cd, printMode);
//        cd.generateHorariPlaEstudis(0);
//        cd.getPlaEstudis(0).getHorari().printHorari();
//        WriteHorari.main(cd.getPlaEstudis(0).getHorari(), outputFileName);    // de moment no xuta..

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

        Aula a = (Aula) cd.getTotesLesAules().getAula(0).clone();

        a.printAula();




//        Assignatures assignatures = (Assignatures) cd.getPlaEstudis(0).getAssignaturesDelPlaEstudis().clone();
//
//        assignatures.getAssignatura(3).setCodi("ZZ");
//
//        cd.getPlaEstudis(0).getAssignatura(3).printAssignatura();
//        System.out.println("mods:");
//        assignatures.getAssignatura(3).printAssignatura();


    }

    private static void printHello() {
        System.out.print("\n");
        System.out.println("##########################################################################################");
        System.out.println("############################### PROP: GENERADOR DE HORARIS ###############################");
        System.out.println("##########################################################################################");
        System.out.print("\n");
    }

    private static void printDades(CentreDocent cd, int printMode) throws MyException {
        if      (printMode == 1) cd.printCentreDocentXS();
        else if (printMode == 2) cd.printCentreDocent();
        else if (printMode == 3) cd.printCentreDocentLong();
        else;    // doNotPrint()
    }

}
