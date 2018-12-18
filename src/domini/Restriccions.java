package domini;

public class Restriccions
{
    protected static boolean comprovar(int i, int j, int k, int dies, int hores, int n_aules, Assignatures assignatures, Aula aula, int g, int a, Assignacio[][][] horari)
    {
        if (!AulaCorrecte(i, j, k, assignatures, aula, g, a, horari)) return false;
        if (!GrupsCompatiblesHora(i, j, dies, hores, n_aules, assignatures, g, a, horari)) return false;
        if (!AssignaturesCompatibles(i, j, dies, hores, n_aules, assignatures, g, a, horari)) return false;
//        if (!GrupsCompatiblesDia(i, dies, hores, n_aules, assignatures, g, a, horari)) return false;
        return true;
    }

    protected static boolean AulaCorrecte(int i, int j, int k, Assignatures assignatures, Aula aula, int g, int a, Assignacio[][][] horari) {
        if (!AulaDisponible(i, j, k, horari)) return false;
        if (!AulaTamanySuficient(assignatures.getAssignatura(a).getGrup(g), aula)) return false;
        if (assignatures.getAssignatura(a).getGrup(g).isLab() && !AulaTipusCorrecte(assignatures.getAssignatura(a).getGrup(g), aula)) return false; // nomes per Grups Lab
        return true;
    }

    protected static boolean GrupsCompatiblesHora(int i, int j, int dies, int hores, int n_aules, Assignatures assignatures, int g, int a, Assignacio[][][] horari) {
        for (int k = 0; k < n_aules; k++) {
            if(horari[i][j][k] != null) {
                if (GrupJaAssignatAquestaHora(i, j, k, assignatures.getAssignatura(a), g, horari)) return false;
                if (!assignatures.getAssignatura(a).getGrup(g).isLab() && AltreGrupTeoriaJaEsFaAra(i, j, k, assignatures.getAssignatura(a), g, horari)) return false;
                if (assignatures.getAssignatura(a).getGrup(g).isLab()  && AltreSubGrupLabJaEsFaAra(i, j, k, assignatures.getAssignatura(a), g, horari)) return false;
                if (ColisionaTeoriaLab(i, j, k, assignatures.getAssignatura(a), g, a, horari)) return false;
            }
        }
        return true;
    }

    protected static boolean AssignaturesCompatibles(int i, int j, int dies, int hores, int n_aules, Assignatures assignatures, int g, int a, Assignacio[][][] horari) {
        for (int k = 0; k < n_aules; k++) {
            if(horari[i][j][k] != null) {
                if (AssignaturesSonCorrequisit(i, j, k, assignatures, g, a, horari)) return false;
                if (AssignaturesMateixNivell(i, j, k, assignatures, g, a, horari)) return false;
            }
        }
        return true;
    }

//    protected static boolean GrupsCompatiblesDia(int i, int dies, int hores, int n_aules, Assignatures assignatures, int g, int a, Assignacio[][][] horari) {
//        int num_vegades_grup_same = 0;
//        int ngrups;
//        if (!assignatures.getAssignatura(a).getGrup(g).isLab()) ngrups = assignatures.getAssignatura(a).getNumGrupsTeoria();
//        ngrups = assignatures.getAssignatura(a).getNumGrupsLab();
//
//        for (int j = 0; j < hores; j++) {
//            for (int k = 0; k < n_aules; k++) {
//                if(horari[i][j][k] != null) {
//                    if (ngrups <= dies || num_vegades_grup_same >= 1) {
//                        if (GrupJaAssignatAquestaHora(i, j, k, assignatures.getAssignatura(a), g, horari)) return false;
//                    }
//                    else {
//                        if (GrupJaAssignatAquestaHora(i, j, k, assignatures.getAssignatura(a), g, horari)) ++num_vegades_grup_same;
//                    }
//                }
//            }
//        }
//
//
//
//    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    private static boolean GrupJaAssignatAquestaHora(int i, int j, int k, Assignatura assignatura, int g, Assignacio[][][] horari) {
        if (assignatura.getCodi().equals(horari[i][j][k].getCodiAssig())) {
            if (assignatura.getGrup(g).getNumGrup() == horari[i][j][k].getNumGrup()) return true;
        }
        return false;
    }

    private static boolean AltreGrupTeoriaJaEsFaAra(int i, int j, int k, Assignatura assignatura, int g, Assignacio[][][] horari) {
        if (assignatura.getCodi().equals(horari[i][j][k].getCodiAssig())) {
            if(!assignatura.getGrupAmbNum(horari[i][j][k].getNumGrup()).isLab()) return true;
        }
        return false;
    }

    private static boolean AltreSubGrupLabJaEsFaAra(int i, int j, int k, Assignatura assignatura, int g, Assignacio[][][] horari) {
        if (assignatura.getCodi().equals(horari[i][j][k].getCodiAssig())) {
            if(assignatura.getGrupAmbNum(horari[i][j][k].getNumGrup()).isLab() && (getNumGrupGeneral(assignatura.getGrup(g).getNumGrup()) == getNumGrupGeneral(horari[i][j][k].getNumGrup()))) return true;
        }
        return false;
    }

    private static boolean ColisionaTeoriaLab(int i, int j, int k, Assignatura assignatura, int g, int a, Assignacio[][][] horari) {
        if (assignatura.getCodi().equals(horari[i][j][k].getCodiAssig())) {
            Grup grup = assignatura.getGrup(g);
            if (!grup.isLab()) { // Grup a assignar es Teoria
                if (assignatura.getGrupAmbNum(horari[i][j][k].getNumGrup()).isLab()) {
                    if (grup.teComASubgrup(horari[i][j][k].getNumGrup())) return true;
                }
            }
            else {  // Grup a assignar es Lab
                if (!assignatura.getGrupAmbNum(horari[i][j][k].getNumGrup()).isLab()) {
                    if (grup.pertanyAlGrupTeoria(horari[i][j][k].getNumGrup())) return true;
                }
            }
        }
        return false;
    }

    private static boolean GrupJaAssignatAquestDia(int i, int j, int k, int dies, Assignatura assignatura, int g, Assignacio[][][] horari) {
        if (assignatura.getNumGrupsTeoria() <= dies) {
            if (assignatura.getCodi().equals(horari[i][j][k].getCodiAssig())) {
                if (assignatura.getGrup(g).getNumGrup() == horari[i][j][k].getNumGrup()) return true;
            }
        }
        else {
            int num_vegades = 0;
        }
        return false;
    }

    private static boolean AltreGrupTeoriaJaEsFaAvui(int i, int j, int k, Assignatura assignatura, int g, Assignacio[][][] horari) {
        if (assignatura.getCodi().equals(horari[i][j][k].getCodiAssig())) {
            if(!assignatura.getGrupAmbNum(horari[i][j][k].getNumGrup()).isLab()) return true;
        }
        return false;
    }

    private static boolean AltreSubGrupLabJaEsFaAvui(int i, int j, int k, Assignatura assignatura, int g, Assignacio[][][] horari) {
        if (assignatura.getCodi().equals(horari[i][j][k].getCodiAssig())) {
            if(assignatura.getGrupAmbNum(horari[i][j][k].getNumGrup()).isLab() && (getNumGrupGeneral(assignatura.getGrup(g).getNumGrup()) == getNumGrupGeneral(horari[i][j][k].getNumGrup()))) return true;
        }
        return false;
    }

    private static boolean AssignaturesMateixNivell(int i, int j, int k, Assignatures assignatures, int g, int a, Assignacio[][][] horari) {
        if (!horari[i][j][k].getCodiAssig().equals(assignatures.getAssignatura(a).getCodi())) { // no comprovar nivell si estic comparant la mateixa assignatura
            // no poden coincidir assigs same nivell NOMES SI son el mateix grup
            if (getNumGrupGeneral(horari[i][j][k].getNumGrup()) == assignatures.getAssignatura(a).getGrup(g).getGrupGeneral()) {
                if (assignatures.getAssignatura(horari[i][j][k].getCodiAssig()).getNivell() == assignatures.getAssignatura(a).getNivell()) return true;
            }
        }
        return false;
    }

    private static boolean AssignaturesSonCorrequisit(int i, int j, int k, Assignatures assignatures, int g, int a, Assignacio[][][] horari) {
        for (int c = 0; c < assignatures.getAssignatura(a).getCorrequisits().size(); c++) {
            // no poden coincidir assigs correq NOMES SI son el mateix grup
            if (getNumGrupGeneral(horari[i][j][k].getNumGrup()) == assignatures.getAssignatura(a).getGrup(g).getGrupGeneral()) {
                if (assignatures.getAssignatura(a).getCorrequisit(c).equals(assignatures.getAssignatura(horari[i][j][k].getCodiAssig()).getCodi())) return true;
            }
        }
        return false;
    }

    private static boolean AulaDisponible(int i, int j, int k, Assignacio[][][] horari) {
        return (horari[i][j][k] == null);
    }

    private static boolean AulaTamanySuficient(Grup grup, Aula aula) {
        return (grup.getCapacitat() <= aula.getCapacitat());
    }

    private static boolean AulaTipusCorrecte(Grup grup, Aula aula){
        return ((aula.isLab() && grup.isAmbPCs()) || (!aula.isLab() && !grup.isAmbPCs()));
    }

    // aux methods

    private static int getNumGrupGeneral(int numGrup) {
        return (numGrup)-(Math.abs(numGrup) % 10);
    }

}
