package domini;

import domini.ControladorDomini;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


public class maindomain
{
    private static String inputFile;

    public static void main(String[] args) throws Exception
    {
        printHello();
        ControladorDomini controladorDomini = new ControladorDomini();

        controladorDomini.loadData();

        controladorDomini.printCentreDocent();

        controladorDomini.generateHorariPlaEstudis(0);
        controladorDomini.printHorari(0);

//        ArrayList<String>[][] horari = controladorDomini.getHorari(0);
//
//        Scanner input = new Scanner(System.in);
//        while(input.nextInt() != -1){
//            int da, ha, aa, db, hb, ab;
//            da = input.nextInt();
//            ha = input.nextInt();
//            aa = input.nextInt();
//            db = input.nextInt();
//            hb = input.nextInt();
//            ab = input.nextInt();
//            controladorDomini.swapHorariPla(da, ha, aa, db, hb, ab,0);
//            controladorDomini.printHorari(0);
//        }

        controladorDomini.storeData();

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
        else { System.out.println(" > Usage: java -jar ." + File.separator + "GeneradorHoraris path\"" + File.separator + "\"to\"" + File.separator + "\"input\"" + File.separator + "\"file\n"); System.exit(0); }
    }

}
