import domini.ControladorDomini;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main
{
    private static String inputFile;

    public static void main(String[] args) throws Exception
    {
        printHello();
        evaluateArgs(args);
        ControladorDomini controladorDomini = new ControladorDomini();

        controladorDomini.readDataFiles();

        controladorDomini.printCentreDocent();

        controladorDomini.generateHorariPlaEstudis(0);
        controladorDomini.printHorari(0);
    }

    private static void printHello() {
        System.out.print("\n");
        System.out.println(" ##########################################################################################");
        System.out.println(" ############################### PROP: GENERADOR DE HORARIS ###############################");
        System.out.println(" ##########################################################################################");
        System.out.print("\n");
    }

    private static void evaluateArgs(String[] args) {
        if (args.length == 1 && !args[0].equals("-h")) {
            Path path = Paths.get(args[0]).toAbsolutePath().normalize();
            if (Files.exists(path) && Files.isReadable(path)) inputFile = args[0];
            else { System.out.println(" > Invalid path.\n"); System.exit(0); }
        }
        else { System.out.println(" > Usage: java -jar ./GeneradorHoraris path/to/input/file\n"); System.exit(0); }
    }

}
