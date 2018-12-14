package domini;

public class Restriccions
{

    protected static boolean comprovarAssignatura(int i, int j, int n_aules, Assignatures assignatures, int g, int a, Assignacio[][][] horari) {
        if (!AssignaturesNivellCorrecte(i,j,n_aules,assignatures,a,horari)) return false;
        if (!AssignaturesCorrequisitsCorrecte(i,j,n_aules,assignatures,a,horari)) return false;
        return true;
    }

    protected static boolean comprovarAula(int i, int j, int k, Aula aula, Assignatura assignatura, int g, Assignacio[][][] horari) {
        if (!AulaDisponible(i,j,k,horari)) return false;
        Grup grup = assignatura.getGrup(g);
        if (!AulaTamanySuficient(grup, aula)) return false;
        if (grup.isLab() && !AulaTipusCorrecte(grup, aula)) return false; // nomes per Grups Lab

        return true;
    }

    protected static boolean AssignaturesNivellCorrecte(int i, int j, int n_aules, Assignatures assignatures, int a, Assignacio[][][] horari) {
        for(int k = 0; k < n_aules; ++k) {
            if(!horari[i][j][k].getCodiAssig().equals("none")) {
                if (horari[i][j][k].getCodiAssig().equals(assignatures.getAssignatura(a).getCodi())) continue;
                if (assignatures.getAssignatura(horari[i][j][k].getCodiAssig()).getNivell() == assignatures.getAssignatura(a).getNivell()) return false;
            }
        }
        return true;
    }

    protected static boolean AssignaturesCorrequisitsCorrecte(int i, int j, int n_aules, Assignatures assignatures, int a, Assignacio[][][] horari) {
        for (int k = 0; k < n_aules; k++) {
            for (int c = 0; c < assignatures.getAssignatura(a).getCorrequisits().size(); c++) {
                if(horari[i][j][k] != null) {
                    if (assignatures.getAssignatura(a).getCorrequisit(c).equals(assignatures.getAssignatura(horari[i][j][k].getCodiAssig()).getCodi())) return false;
                }
            }
        }
        return true;
    }

    protected static boolean AulaDisponible(int i, int j, int k, Assignacio[][][] horari) {
        if(horari[i][j][k] != null) return false;
        return true;
    }

    protected static boolean AulaTamanySuficient(Grup grup, Aula a) {
        return (grup.getCapacitat() <= a.getCapacitat());
    }

    protected static boolean AulaTipusCorrecte(Grup grup, Aula aula){
        return ((aula.isLab() && grup.isAmbPCs()) || (!aula.isLab() && !grup.isAmbPCs()));
    }



//
//    protected static boolean ColissioGrupTeoriaAmbLab(Assignacio asg, HoraLectiva solucion, Assignatures assignaturesPE) throws CloneNotSupportedException {
//        boolean isGrup = (asg.getNumGrup() % 10 == 0);
//        Assignatura assig = (Assignatura) assignaturesPE.getAssignatura(asg.getCodiAssig()).clone();
//        if(isGrup) {
//            int numGrup = asg.getNumGrup();
//            Grup g = assig.getGrupAmbNum(numGrup);
//            for (int i = 0; i < solucion.mida(); i++) {
//                for (int j = 0; j < g.getSubGrups().size(); j++) {
//                    if(solucion.getAssignacio(i).getNumGrup() == g.getSubGrup(j).getNumSubGrup()) return false;
//                }
//            }
//        }
//        else {
//            // si la ASG es de un SubGrup i a SOLUCION el GrupTeoria pare ja esta asignat -> return false
//            int numSubGrup = asg.getNumGrup();
//            int numGrup = (numSubGrup)-(Math.abs(numSubGrup) % 10);
//            for (int i = 0; i < solucion.mida(); i++) {
//                if (solucion.getAssignacio(i).getNumGrup() == numGrup) return false;
//            }
//        }
//        return true;
//    }


}
