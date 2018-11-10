package domini;

import java.util.ArrayList;

public class GeneradorHora {

    public static HoraLectiva ForwardChecking(Assignatures assignaturesPE, Aules aulesPE) throws MyException {
        ArrayList<Assignatura> assigs = new ArrayList<>();
        assigs = assignaturesPE.getAssignatures();
        Assignatures assignatures = new Assignatures(assigs);
        ArrayList<Aula> aulesCP = new ArrayList<>();
        aulesCP = aulesPE.getAules();
        Aules aules = new Aules(aulesCP);
        HoraLectiva solucion = new HoraLectiva();
        i_ForwardChecking(assignatures, aules, solucion);
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
            if(restriccioTamanyAula(g,a) && restriccioAssignaturesNivell(assig, solucion, assigFuturas) && restriccioAssignaturesCorrequisits(assig, solucion, assigFuturas)){  
                Assignacio asg = new Assignacio(g,a);
                solucion.afegirAssignacio(asg);
                
            } else i_ForwardChecking(assigFuturas,aulesFuturas,solucion);      

        }
    }
    private static boolean restriccioAssignaturesNivell(Assignatura assig, HoraLectiva sol, Assignatures assignatures){
        for(int i = 0; i < sol.mida(); ++i){
            String codiAssigSol = sol.getAssignacio(i).getGrupAssignat().getCodiAssig();
            Assignatura assigSol = new Assignatura();
            assigSol = assignatures.getAssignatura(codiAssigSol);
            if(assigSol.getNivell() == assig.getNivell()) return false;
        }
        return true;
    }
    
    private static boolean restriccioAssignaturesCorrequisits(Assignatura assig, HoraLectiva sol, Assignatures assignatures){
        for(int i = 0; i < sol.mida(); ++i){
            String codiAssigSol = sol.getAssignacio(i).getGrupAssignat().getCodiAssig();
            for(int j = 0; j < assig.getCorrequisits().size(); ++j){
                if(assig.getCorrequisit(j).equals(codiAssigSol)) return false;
            }
        }
        return true;
    }
    
    private static boolean restriccioTamanyAula(Grup g, Aula a){
        if(g.getCapacitat() > a.getCapacitat()) return false;
        else return true;
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
    

    
    
}

