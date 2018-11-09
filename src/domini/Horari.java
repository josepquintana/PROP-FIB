package domini;

import java.util.ArrayList;

public class Horari
{
    private final int dies = 5;
    private int hores;
    private HoraLectiva[][] setmana;

    public Horari(JornadaLectiva jL){
        int hIni = jL.getHoraIni().getHours();
        int hFi = jL.getHoraFi().getHours();
        this.hores = hFi-hIni;
        this.setmana = new HoraLectiva[dies][hores];
    }

    public Horari(Horari horari) {
        this.hores = horari.getHores();
        this.setmana = new HoraLectiva[this.dies][this.hores];
    }

    public void GenerarHorari(PlaEstudis pe) throws MyException {

        Assignatures assignatures = new Assignatures(pe.getAssignatures());
        Aules aules = new Aules(pe.getAules());

        ArrayList<HoraLectiva> horesLectives = new ArrayList<>();
        while (! assignatures.esBuit()) {
            HoraLectiva hL = GeneradorHora.ForwardChecking(assignatures, aules);
            horesLectives.add(hL);

            for (int i = 0; i < hL.getAssignacions().size(); i++) {
                Assignacio asg = new Assignacio(hL.getAssignacions().get(i));
                assignatures.getAssignatura(asg.getGrupAssignat().getCodiAssig()).eliminarGrupAssignatura(asg.getGrupAssignat());
                assignatures.getAssignatura(asg.getGrupAssignat().getCodiAssig())
            }
            Grup g = hL.
        }
        this.OmplirHorari(horesLectives);

    }

    public void OmplirHorari(ArrayList<HoraLectiva> horesLectives) {
        for (int j = 0; j < this.hores; j++) {
            for (int i = 0; i < this.dies; i++) {
                HoraLectiva hL = horesLectives.remove(0);
                this.setmana[i][j] = new HoraLectiva(hL);
            }
        }
    }

    public boolean existeixHora(HoraLectiva h) {
        for(int i = 0; i < hores; ++i){
            for(int j = 0; j < dies; ++j){
                if(this.setmana[i][j] == h) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean afegirHora(HoraLectiva hora){
          if(existeixHora(hora)){
              System.out.println(">>> afegirHora(): L' hora lectiva donada ja existeix");
              return false;
          } 
          for(int i = 0; i < hores; ++i){
            for(int j = 0; j < dies; ++j){
                if(this.setmana[i][j].esBuit()) {
                    this.setmana[i][j] = hora;
                    return true;
                }
            }
        }
        System.out.println(">>> afegirHora(): No queda hora disponible per assignar");  
        return false;
    }
    
    public boolean eliminarHora(HoraLectiva hora){
        for(int i = 0; i < hores; ++i){
            for(int j = 0; j < dies; ++j){
                if(this.setmana[i][j] == hora) {
                    this.setmana[i][j] = null;
                    return true;
                }
            }
        }
        return false;
    }

    public int getDies() {
        return dies;
    }

    public int getHores() {
        return hores;
    }

    public void printHorari() {

    }
}
