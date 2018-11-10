package domini;

public class GeneradorHora {

    public static HoraLectiva ForwardChecking(Assignatures assignatures, Aules aulesPE) throws MyException {

        Assignatures assigs = new Assignatures(assignatures);
        Aules aules = new Aules(aulesPE);
        HoraLectiva solucion = new HoraLectiva();
        i_ForwardChecking(assigs, aules, solucion);
        return solucion;
    }

    private static void i_ForwardChecking(Assignatures assigFuturas, Aules aulesFuturas, HoraLectiva solucion) throws MyException {
        if (assigFuturas.esBuit()) return;
        else {
            Grup g = new Grup();
            g = assigFuturas.getAssignatura(0).getGrup(0);
            assigFuturas.getAssignatura(0).eliminarGrupAssignatura(0);

            Aula a = new Aula();
            a = aulesFuturas.getAula(0);
            aulesFuturas.eliminarAula(0);

            if (assigFuturas.getAssignatura(0).getGrups().size() == 0) {
                assigFuturas.eliminarAssignatura(0);
            }
//            for ()

//                return
        }
    }
}

