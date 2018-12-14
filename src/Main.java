import domini.ControladorDomini;
import domini.MyException;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        printHello();
        ControladorDomini cd;
        cd = new ControladorDomini();
        String inputFileName  = args[0];        // filename for the data input

        cd.readInputFile(inputFileName);
        cd.printCentreDocent();

//        for (int i = 0; i < cd.getPlaEstudis(0).getAssignatures().mida(); i++) {
//            cd.getPlaEstudis(0).getAssignatures().getAssignatura(i).printAssignaturaGSG();
//        }

        cd.generateHorariPlaEstudis(0);
        cd.printHorari(0);


//        for (int i = 0; i < cd.getPlansDeEstudis().mida(); i++) {
//            cd.generateHorariPlaEstudis(i);
//            cd.printHorari(i);
//        }

    }



    private static void printHello() {
        System.out.print("\n");
        System.out.println("##########################################################################################");
        System.out.println("############################### PROP: GENERADOR DE HORARIS ###############################");
        System.out.println("##########################################################################################");
        System.out.print("\n");
    }

}
