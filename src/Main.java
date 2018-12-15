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
//        inputFileName  = "input\\input-short.txt";        // filename for the data input

        cd.readInputFile(inputFileName);
        cd.printCentreDocent();

        cd.generateHorariPlaEstudis(0);
        cd.printHorari();

    }



    private static void printHello() {
        System.out.print("\n");
        System.out.println("##########################################################################################");
        System.out.println("############################### PROP: GENERADOR DE HORARIS ###############################");
        System.out.println("##########################################################################################");
        System.out.print("\n");
    }

}
