package domini;

public class Horari implements Cloneable
{
    private final int dies = 5;
    private int hores;
    private int n_aules;
    private int hIni;
    private Assignacio[][][] horari;

    private Assignatures assignatures;
    private Aules aules;

    public Horari() {
        this.hores = 0;
        this.n_aules = 0;
        this.hIni = 0;
        this.horari = new Assignacio[0][0][0];
    }

    @SuppressWarnings("deprecation")
    public Horari(JornadaLectiva jL, int n_aules) {
        this.hores = (jL.getHoraFi().getHours() - jL.getHoraIni().getHours());
        this.n_aules = n_aules;
        this.hIni = jL.getHoraIni().getHours();
        this.horari = new Assignacio[this.dies][this.hores][this.n_aules];
    }

    public Horari(Horari horari) {
        this.hores = horari.getHores();
        this.n_aules = horari.getN_aules();
        this.hIni = horari.getHIni();
        this.horari = horari.getHorari();
    }

    protected Object clone() throws CloneNotSupportedException {
        Horari h;
        try {
            h = (Horari) super.clone();

            // tractar mutable fields
            Assignacio[][][] new_horari = new Assignacio[this.dies][this.hores][this.n_aules];
            for (int i = 0; i < this.dies; i++) {
                for (int j = 0; j < this.hores; j++) {
                    for (int k = 0; k < this.n_aules; k++) {
                        if(horari[i][j][k] != null) {
                            new_horari[i][j][k] = (Assignacio) horari[i][j][k].clone();
                        }
                    }
                }
            }
            h.setHorari(new_horari);
        }
        catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return h;
    }

    public void generarHorari(Assignatures assignatures, Aules aules) throws CloneNotSupportedException {
        // horari esta ben inicialitzat
        System.out.println(" >> Generating Horari");

        this.assignatures = (Assignatures) assignatures.clone();
        this.aules = (Aules) aules.clone();



        boolean solucio = backtracking(0,0);
        if (!solucio) System.out.println("No hi ha solucio");
    }

    private boolean backtracking(int g, int a) {

        if(a == assignatures.mida()) return true;
        if(g == assignatures.getAssignatura(a).getGrups().size()) return backtracking(0, a+1);

        for (int i = 0; i < this.dies; i++) {
            for (int j = 0; j < this.hores; j++) {
                for (int k = 0; k < this.n_aules; k++) {
                    if (Restriccions.comprovar(i, j, k, dies, hores, n_aules, assignatures, aules.getAula(k), g, a, horari))
                    {
                        String codi = assignatures.getAssignatura(a).getCodi();
                        int grup = assignatures.getAssignatura(a).getGrup(g).getNumGrup();
                        String aula = aules.getAula(k).getCodi();
                        int horaIni = this.hIni + j;
                        int durada = 1;

                        horari[i][j][k] = new Assignacio(codi, grup, aula, horaIni, durada);
                        assignatures.getAssignatura(a).getGrup(g).decrementHores();

                        if (assignatures.getAssignatura(a).getGrup(g).getHoresNoAssignades() == 0) {
                            if (backtracking(g + 1, a)) return true;
                        }
                        else {
                            if (backtracking(g + 0, a)) return true;
                        }

                        assignatures.getAssignatura(a).getGrup(g).incrementHores();
                        horari[i][j][k] = null;
                    }
                }
            }
        }
        return false;
    }

    public Assignacio getAssignacioIJK(int dia, int hora, int aula) {
        return this.horari[dia][hora][aula];
    }

    public boolean empty() {
        if (horari.length == 0) return true;
        return false;
    }

    public int getDies() {
        return dies;
    }

    public int getHores() {
        return hores;
    }

    public int getN_aules() {
        return n_aules;
    }

    public int getHIni() {
        return hIni;
    }

    public Assignacio[][][] getHorari() { return horari; }

    public void setHores(int hores) {
        this.hores = hores;
    }

    public void setN_aules(int n_aules) {
        this.n_aules = n_aules;
    }

    public void setHIni(int hIni) {
        this.hIni = hIni;
    }

    public void setHorari(Assignacio[][][] horari) {
        this.horari = horari;
    }
}
