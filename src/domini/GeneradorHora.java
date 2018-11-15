package domini;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

public class GeneradorHora {
    
    
    
    public static HoraLectiva ForwardChecking(Assignatures assigsPE, Aules aulesPE, Assignatures assigsDisponibles) throws MyException, CloneNotSupportedException{
        HoraLectiva solucio = new HoraLectiva();
        int i = 0;
        Assignatures assigs = (Assignatures) assigsPE.clone();
        Assignatures assigsAll = (Assignatures) assigsDisponibles.clone();
        Aules aules = (Aules) aulesPE.clone();
        generarHoraLectiva(assigs, aules, solucio, i, assigsAll);
        eliminarAssignacions(assigsPE, solucio);
        return solucio;
    }
    
    private static void generarHoraLectiva(Assignatures assigs, Aules aules, HoraLectiva solucio, int i, Assignatures assigsAll) throws MyException{
        if(assigs.esBuit() || aules.esBuit() || i >= aules.mida())i = 0;
        else{
            Aula a = new Aula(aules.getAula(i));
            Assignatura assig = new Assignatura(assigs.getAssignatura(0));
            Grup grup = new Grup(assig.getGrup(0));

            //assig.printAssignaturaLong();
            //grup.printGrup();
            //a.printAula();
            //COMPROBAR RESTRICCIONS
            
            if(requisitsAssignatures(assig, solucio, assigsAll)){
                if(aulaTipusEspecial(a)){                                       //Aula LAB
                    if(assignaturaTipusEspecial(assig)){                        //assig lab
                        if(horesLab(grup)){                                     //queden hores de lab
                            if(capacitatAula(grup.getCapacitatSub(), a)){       //hi cap el grup a l'aula
                                Assignacio asg = new Assignacio(grup,a,grup.getNumSubgrup());
                                solucio.afegirAssignacio(asg);
                                assigs.getAssignatura(0).eliminarGrupAssignatura(0);
                                if(assigs.getAssignatura(0).getGrups().isEmpty()) assigs.eliminarAssignatura(0);
                                aules.eliminarAula(i);
                            } else ++i;
                        } else ++i;
                    } else ++i;
                }else{                                                          //Aula NO LAB
                    if(horesTeo(grup)){                                         //queden hores de teoria
                        if(capacitatAula(grup.getCapacitat(),a)){               //hi cap el grup a l'aula
                            Assignacio asg = new Assignacio(grup,a,grup.getNumGrup());
                            solucio.afegirAssignacio(asg);
                            assigs.getAssignatura(0).eliminarGrupAssignatura(0);
                            if(assigs.getAssignatura(0).getGrups().isEmpty()) assigs.eliminarAssignatura(0);
                            aules.eliminarAula(i);
                        } else ++i;
                    } else {                                                    //no queden hores de teoria
                        if(!assignaturaTipusEspecial(assig)){                   //la assignatura no es especial
                            if(capacitatAula(grup.getCapacitatSub(), a)){
                                Assignacio asg = new Assignacio(grup,a,grup.getNumSubgrup());
                                solucio.afegirAssignacio(asg);
                                assigs.getAssignatura(0).eliminarGrupAssignatura(0);
                                if(assigs.getAssignatura(0).getGrups().isEmpty()) assigs.eliminarAssignatura(0);
                                aules.eliminarAula(i);
                            } else ++i;
                        } else ++i;
                    }
                }
            
            }else {
                assigs.eliminarAssignatura(0);
            }
            generarHoraLectiva(assigs,aules,solucio,i,assigsAll);
        
        }
        
        
    }
    
    private static void eliminarAssignacions(Assignatures assigsPE, HoraLectiva assignacions){
        Assignacio actual = new Assignacio();
        String codi;
        for(int i = 0; i < assignacions.mida(); ++i){
            actual = assignacions.getAssignacio(i);
            codi = actual.getGrupAssignat().getCodiAssig();
            for(int j = 0; j < assigsPE.getAssignatura(codi).getGrups().size();++j){
                if(actual.getNumGrupAssignacio()%10 == 0) {
                    if(assigsPE.getAssignatura(codi).getGrup(j).getNumGrup() == actual.getNumGrupAssignacio()) {
                        assigsPE.getAssignatura(codi).getGrup(j).restarHoraTeo();
                    }
                } else {
                   if(assigsPE.getAssignatura(codi).getGrup(j).getNumSubgrup() == actual.getNumGrupAssignacio()) {
                        assigsPE.getAssignatura(codi).getGrup(j).restarHoraLab();
                        if(assigsPE.getAssignatura(codi).getGrup(j).getHoresLab() == 0) {
                            assigsPE.getAssignatura(codi).getGrup(j).eliminarSubgrup();
                            if(assigsPE.getAssignatura(codi).getGrup(j).getSubGrups() != 0) assigsPE.getAssignatura(codi).getGrup(j).setHoresLab();
                        }
                    } 
                }
                if(assigsPE.getAssignatura(codi).getGrup(j).getHoresTeo() == 0 && assigsPE.getAssignatura(codi).getGrup(j).getHoresLab() == 0) assigsPE.getAssignatura(codi).eliminarGrupAssignatura(j);
            }
            if(assigsPE.getAssignatura(codi).getGrups().isEmpty()) assigsPE.eliminarAssignatura(codi);
        }
    }
    
    private static boolean horesLab(Grup g){
        return g.getHoresLab() > 0;
    }
    
    private static boolean horesTeo(Grup g){
        return g.getHoresTeo() > 0;
    }
    
    private static boolean capacitatAula(int k, Aula a){
        //System.out.println("CAPACITAT:              ");
        //System.out.println(k);
        return a.getCapacitat() >= k;
    }
    
    private static boolean assignaturaTipusEspecial(Assignatura a){
        return a.isLab();
    }
    
    private static boolean aulaTipusEspecial(Aula a){
        return a.isLab();
    }
    
    private static boolean requisitsAssignatures(Assignatura a, HoraLectiva sol, Assignatures all){
        Assignatura b = new Assignatura();
        int varios = 0;
        for(int i = 0; i<sol.mida();++i){
            if(varios >= 2) return false;
            String s = sol.getAssignacio(i).getGrupAssignat().getCodiAssig(); 
            b = all.getAssignatura(s);
            if(a.getCodi().equals(b.getCodi())) ++varios;
            if(a.getNivell() == b.getNivell() && !a.getCodi().equals(s)) return false;
            for(int j = 0; j < a.getCorrequisits().size(); ++j){
                if(s.equals(a.getCorrequisit(j))) return false;
            }
        }
        return true;
    }
    
    }
    
    /*
    //private static final int maxAssignacionsHora = 0;
    private static final boolean randomize       = false;    // randomize Assigs and Aules arrays 
    
    
    
    
    public static HoraLectiva ForwardChecking(Assignatures assignaturesPE, Aules aulesPE) throws MyException, CloneNotSupportedException {

        System.out.println(" > " + Thread.currentThread().getStackTrace()[1]);

        // MIRAR COM FER BE LES COPIES DE OBJECTES!
       
        Assignatures assignatures = new Assignatures();
        assignatures = (Assignatures) assignaturesPE.clone();
        ArrayList<Aula> aulesCP = new ArrayList<>(aulesPE.getAules());
        Aules aules = new Aules();
        aules = (Aules)aulesPE.clone();
        HoraLectiva solucion = new HoraLectiva();
        
//        AtomicInteger i = new AtomicInteger(0);
        int i = 0;
        i_ForwardChecking(assignatures, aules, solucion, assignaturesPE, i);
        return solucion;
    }
    
    
    
    private static void bt_fordwardChecking(Assignatura assig,Assignatures assignatures, Aules aules, HoraLectiva solucio, Integer max){
        if(solucio.mida() == max || assignatures.esBuit() || aules.esBuit()) return;
        else{
            for(int i = 0; i < assignatures.mida(); ++i){
                if(!restriccioAssignatures(assig,assignatures.getAssignatura(i))) ;
                else{
                    for(int j = 0; j < aules.mida(); ++j){
                        for(int k = 0 ; k < assignatures.getAssignatura(i).getGrups().size(); ++k){
                            for(int l = 0; l < assignatures.getAssignatura(i).getGrup(k).getSubGrups(); ++k){
                                for(int h = 0; h < assignatures.getAssignatura(i).getGrup(j).getHoresLab(); ++h){

                                }
                            }
                        }
                    }
                    
                    /*for(int j = 0; j < assignatures.getAssignatura(i).getGrups().size(); ++j){
                        for(int k = 0; k < assignatures.getAssignatura(i).getGrup(j).getSubGrups(); ++k){
                            for(int h = 0; h < assignatures.getAssignatura(i).getGrup(j).getHoresLab(); ++h){

                            }
                        }
                    }
                }
            }
        
        }
        
    }
    
    
    
    

    private static void i_ForwardChecking(Assignatures assignatures, Aules aulesFuturas, HoraLectiva solucion, Assignatures assignaturesPE, Integer i) throws MyException,  CloneNotSupportedException  {

        //System.out.println(" > " + Thread.currentThread().getStackTrace()[1]);

        System.out.println(" iteracio");
        if (assignatures.esBuit() || aulesFuturas.esBuit() || i >= aulesFuturas.mida()) {
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
                                if(assignatures.getAssignatura(0).getGrup(0).getSubGrups() != 0) assignatures.getAssignatura(0).getGrup(0).setHoresLab();
                               }
                        }
                        else {
                            assignatures.getAssignatura(0).restarHoraTeo();
                            if(assignatures.getAssignatura(0).getSessionsTeoria() == 0){
                                assignatures.getAssignatura(0).eliminarGrupAssignatura(0);
                            }
                        }
                        solucion.afegirAssignacio(asg);
                        aulesFuturas.eliminarAula(i);
                    }
                    i++;
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
    
    private static boolean restriccioAssignatures(Assignatura a, Assignatura b){
        if(a.getNivell() == b.getNivell()) return false;
        else {
            for(int i = 0; i<a.getCorrequisits().size(); ++i){
                if(a.getCorrequisit(i).equals(b.getCodi())){
                    return false;
                }
            }
        }
        return true;
    }
    
    
    private static boolean restriccioTipusAula(Assignatura assig, Aula aula){
        return ((aula.isLab() && assig.isLab()) || (!aula.isLab() && !assig.isLab()));    }

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
    }*/



