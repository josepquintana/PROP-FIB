package domini;

import javafx.print.Collation;

import java.util.ArrayList;
import java.util.Collections;

public class GeneradorHora {

    private static final int maxAssignacionsHora = 100;
    private static final boolean randomize       = true;    // randomize Assigs and Aules arrays ?

    public static HoraLectiva ForwardChecking(Assignatures assignaturesPE, Aules aulesPE) throws MyException {

        // MIRAR COM FER BE LES COPIES DE OBJECTES!
        ArrayList<Assignatura> assignaturesCP = new ArrayList<>(assignaturesPE.getAssignatures());
        Assignatures assignatures = new Assignatures(assignaturesCP);
        ArrayList<Aula> aulesCP = new ArrayList<>(aulesPE.getAules());
        Aules aules = new Aules(aulesCP);
        HoraLectiva solucion = new HoraLectiva();
        
        int i = 0;
        i_ForwardChecking(assignatures, aules, solucion, assignaturesPE, i);
        return solucion;
    }

    private static void i_ForwardChecking(Assignatures assignatures, Aules aulesFuturas, HoraLectiva solucion, Assignatures assignaturesPE, int i) throws MyException {

        if (randomize) {
            Collections.shuffle(assignatures.getAssignatures());
            Collections.shuffle(aulesFuturas.getAules());
        }

        if (assignatures.esBuit() || aulesFuturas.esBuit() || i >= aulesFuturas.mida() || solucion.mida() >= maxAssignacionsHora){
            i = 0;
            return;
        }
        else {
            
            Aula a = new Aula(aulesFuturas.getAula(i));
            Assignatura assig = new Assignatura(assignatures.getAssignatura(0));
            Grup g = new Grup(assig.getGrup(0));
            
             if(restriccioTamanyAula(g,a)){
                if(restriccioAssignaturesNivell(assig, solucion, assignaturesPE) && restriccioAssignaturesCorrequisits(assig, solucion, assignaturesPE)){
                    if(restriccioTipusAula(assig, a)) {
                        Assignacio asg = new Assignacio(g,a);
                        if(g.getSubGrups() != 0){
                            assignatures.getAssignatura(0).getGrup(0).restarHoraLab();
                            if(g.getHoresLab() == 0) {
                                assignatures.getAssignatura(0).getGrup(0).eliminarSubgrup();
                                assignatures.getAssignatura(0).getGrup(0).setHoresLab();
                               }
                        }else {
                            assignatures.getAssignatura(0).restarHoraTeo();
                            if(assignatures.getAssignatura(0).getSessionsTeoria() == 0){
                                assignatures.getAssignatura(0).eliminarGrupAssignatura(0);
                            }
                        }
                        solucion.afegirAssignacio(asg);
                        aulesFuturas.eliminarAula(i);
                    } i++; 
                    if (assignatures.getAssignatura(0).getGrups().isEmpty()){
                        assignatures.eliminarAssignatura(0);
                        i = 0;
                    }
                }
                else {
                    assignatures.eliminarAssignatura(0);
                } 
            }
            else i++;
            i_ForwardChecking(assignatures,aulesFuturas,solucion, assignaturesPE, i);
        }
    }
    
    private static boolean restriccioTipusAula(Assignatura assig, Aula aula){
        return ((aula.getTipus() && assig.getLab()) || (!aula.getTipus() && !assig.getLab()));

    }

    private static boolean restriccioAssignaturesNivell(Assignatura assig, HoraLectiva sol, Assignatures assignaturesPE){
        for(int i = 0; i < sol.mida(); ++i){
            
            String codiAssigSol = sol.getAssignacio(i).getGrupAssignat().getCodiAssig();
            if(assignaturesPE.getAssignatura(codiAssigSol).getNivell() == assig.getNivell() ) return false;
        }
        return true;
    }
    
    private static boolean restriccioAssignaturesCorrequisits(Assignatura assig, HoraLectiva sol, Assignatures assignaturesPE){
        for(int i = 0; i < sol.mida(); ++i){
            String codiAssigSol = sol.getAssignacio(i).getGrupAssignat().getCodiAssig();
            for(int j = 0; j < assig.getCorrequisits().size(); ++j){
                if(assig.getCorrequisit(j).equals(codiAssigSol)) return false;
            }
        }
        return true;
    }
    
    private static boolean restriccioTamanyAula(Grup g, Aula a){
        if(g.getSubGrups() == 0) return (g.getCapacitat() <= a.getCapacitat());
        else return (g.getCapacitatSub() <= a.getCapacitat());

    }
    
    private static void podarAssignatures(Assignatures assigs, Assignatura a){
        int nivell = a.getNivell();
        for(int i = 0; i < assigs.getAssignatures().size(); ++i){
            if(assigs.getAssignatures().get(i).getNivell() == nivell)
                assigs.getAssignatures().remove(i);
        }
        for(int i = 0; i < assigs.getAssignatures().size(); ++i){
            for(int j = 0; j < a.getCorrequisits().size(); ++j){
                if(a.getCorrequisit(j).equals(assigs.getAssignatures().get(i).getCodi())) {
                    assigs.getAssignatures().remove(i);
                }
            }
        }
    }

}

