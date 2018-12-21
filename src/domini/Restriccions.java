package domini;

public class Restriccions
{
    protected static boolean comprovar(int i, int j, int k, int dies, int hores, int n_aules,int totals, Assignatures assignatures, Aula aula, int g, int a, Assignacio[][][] horari)
    {
        if (!AulaCorrecte(i, j, k, assignatures, aula, g, a, horari)) return false;
        if (!GrupsCompatiblesHora(i, j, dies, hores, n_aules, assignatures, g, a, horari)) return false;
        if (!AssignaturesCompatibles(i, j, dies, hores, n_aules, assignatures, g, a, horari)) return false;
        if (!HoresCompatibles(i,hores,n_aules,totals,assignatures, a, horari)) return false;
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
    
    protected static boolean HoresCompatibles(int i,int hores, int n_aules, int totals,Assignatures assignatures, int a, Assignacio[][][] horari){
        int horesDia = 0;
        for(int iN = 0; iN < hores; ++iN){
            for(int jN = 0; jN < n_aules; ++jN){
                if(horari[i][iN][jN]!= null){
                    if(horari[i][iN][jN].getCodiAssig().equals(assignatures.getAssignatura(a).getCodi())) ++horesDia;
                }
                if(horesDia > totals){ 
                    return false;
                }
            }
        }
        return true;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


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
        if (assignatura.getNumGrupsGenerals() <= dies) {
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

    
    protected static boolean restriccionsGenerals(int dies, int hores, int n_aules, Assignatures assignatures, Aules aules){
        if(!restriccioSlots(dies,  hores, n_aules, assignatures)) return false;
        if(!restriccioCapacitats( n_aules, assignatures, aules)) return false;
            
        return true;
    }
    
    private static boolean restriccioSlots(int dies, int hores, int n_aules, Assignatures assignatures){
        int assigsMax = dies * hores * n_aules;
        int assigsNecessaries = 0;
        for(int i = 0; i < assignatures.mida(); ++i){
            assigsNecessaries += (assignatures.getAssignatura(i).getNumTotalSubgrups()*assignatures.getAssignatura(i).getSessionsLab()) + (assignatures.getAssignatura(i).getNumGrupsGenerals()*assignatures.getAssignatura(i).getSessionsTeoria());
        }
        return !(assigsMax < assigsNecessaries);
    }
    
    private static boolean restriccioCapacitats(int n_aules,Assignatures assignatures, Aules aules){
        for(int i = 0; i < assignatures.mida(); ++i){
            boolean espai = false;
            for(int j = 0; j < n_aules; ++j){
                if(assignatures.getAssignatura(i).getGrup(0).getCapacitat() <= aules.getAula(j).getCapacitat()) espai = true;
            }
            if(!espai) return false;
        }
        return true;
    }

    /**
     * aux methods
     */
    private static int getNumGrupGeneral(int numGrup) {
        return (numGrup)-(Math.abs(numGrup) % 10);
    }

}
