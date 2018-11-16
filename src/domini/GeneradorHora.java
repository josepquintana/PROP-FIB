package domini;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

public class GeneradorHora {

    public static HoraLectiva GenerarHoraLectiva(Assignatures assigsPE, Aules aulesPE, Assignatures assigsDisponibles) throws MyException, CloneNotSupportedException{
        HoraLectiva solucio = new HoraLectiva();
        int i_aula = 0;
        Assignatures assigs = (Assignatures) assigsPE.clone();
        Assignatures assigsAll = (Assignatures) assigsDisponibles.clone();
        Aules aules = (Aules) aulesPE.clone();
        i_GenerarHoraLectiva(assigs, aules, solucio, i_aula, assigsAll);
        eliminarAssignacions(assigsPE, solucio);
        return solucio;
    }
    
    private static void i_GenerarHoraLectiva(Assignatures assigs, Aules aules, HoraLectiva solucio, int i_aula, Assignatures assigsAll) throws MyException{
        if(assigs.esBuit() || aules.esBuit() || i_aula >= aules.mida())i_aula = 0;
        else{
            Aula a = new Aula(aules.getAula(i_aula));
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
                                aules.eliminarAula(i_aula);
                            } else ++i_aula;
                        } else ++i_aula;
                    } else ++i_aula;
                }else{                                                          //Aula NO LAB
                    if(horesTeo(grup)){                                         //queden hores de teoria
                        if(capacitatAula(grup.getCapacitat(),a)){               //hi cap el grup a l'aula
                            Assignacio asg = new Assignacio(grup,a,grup.getNumGrup());
                            solucio.afegirAssignacio(asg);
                            assigs.getAssignatura(0).eliminarGrupAssignatura(0);
                            if(assigs.getAssignatura(0).getGrups().isEmpty()) assigs.eliminarAssignatura(0);
                            aules.eliminarAula(i_aula);
                        } else ++i_aula;
                    } else {                                                    //no queden hores de teoria
                        if(!assignaturaTipusEspecial(assig)){                   //la assignatura no es especial
                            if(capacitatAula(grup.getCapacitatSub(), a)){
                                Assignacio asg = new Assignacio(grup,a,grup.getNumSubgrup());
                                solucio.afegirAssignacio(asg);
                                assigs.getAssignatura(0).eliminarGrupAssignatura(0);
                                if(assigs.getAssignatura(0).getGrups().isEmpty()) assigs.eliminarAssignatura(0);
                                aules.eliminarAula(i_aula);
                            } else ++i_aula;
                        } else ++i_aula;
                    }
                }
            
            }else {
                assigs.eliminarAssignatura(0);
            }
            i_GenerarHoraLectiva(assigs,aules,solucio,i_aula,assigsAll);
        
        }
        
        
    }
    
    private static void eliminarAssignacions(Assignatures assigsPE, HoraLectiva assignacions){
        Assignacio actual = new Assignacio();
        String codi;
        for(int i_aula = 0; i_aula < assignacions.mida(); ++i_aula){
            actual = assignacions.getAssignacio(i_aula);
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
                            if(assigsPE.getAssignatura(codi).getGrup(j).getSubGrups() != 0) assigsPE.getAssignatura(codi).getGrup(j).setHoresLab(assigsPE.getAssignatura(codi).getSessionsLab());
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
        for(int i_aula = 0; i_aula<sol.mida();++i_aula){
            if(varios >= 2) return false;
            String s = sol.getAssignacio(i_aula).getGrupAssignat().getCodiAssig();
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
