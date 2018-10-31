package domini;

import java.util.ArrayList;

public class HoraLectiva {
    private ArrayList<Assignacio> assignacions;
    
    public HoraLectiva(){
        this.assignacions = new ArrayList<>();
    }
    
    public HoraLectiva(ArrayList<Assignacio> a){
        this.assignacions = a;
    }
    
    
    //Comprova que la Assignació assig no tingui ni l'aula ni l'assignatura assignades
    public boolean existeixAssignacio(Assignacio assig) {
        for (int i = 0; i < this.assignacions.size(); i++) {
            if(this.assignacions.get(i).getAssignatura().equals(assig.getAssignatura()) || this.assignacions.get(i).getAula().equals(assig.getAula())) return true;
        }
        return false;
    }
    
}
