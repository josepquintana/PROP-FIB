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
        if (assigFuturas.esBuit() || aulesFuturas.esBuit()) return;
        else {
            Grup g = new Grup();
            Assignatura assig = new Assignatura();
            assig = assigFuturas.getAssignatura(0);
            g = assig.getGrup(0);
            assigFuturas.getAssignatura(0).eliminarGrupAssignatura(0);

            Aula a = new Aula();
            a = aulesFuturas.getAula(0);
            

            aulesFuturas.eliminarAula(0);
            if (assigFuturas.getAssignatura(0).getGrups().isEmpty()) {
                assigFuturas.eliminarAssignatura(0);
            }
            Assignacio asg = new Assignacio(g,a);
            solucion.afegirAssignacio(asg);
            
                     

        }
    }
    
    private static void podarAssignatures(Assignatures assigs, Assignatura a){
        int nivell = a.getNivell();
        for(int i = 0; i < assigs.getAssignatures().size(); ++i){
            if(assigs.getAssignatures().get(i).getNivell() == nivell)
                assigs.getAssignatures().remove(i);
        }
        for(int i = 0; i < assigs.getAssignatures().size(); ++i){
            for(int j = 0; j < a.getCorrequisits().size(); ++j){
                if(a.getCorrequisit(j).equals(assigs.getAssignatures().get(i).getCodi()))
                    assigs.getAssignatures().remove(i);
                }
        }
    }
    
    private static boolean comprobarRestriccionsAula(Grup g, Aula a){
        if(g.getCapacitat() > a.getCapacitat()) return false;
        else return true;
    }
    
    
}

