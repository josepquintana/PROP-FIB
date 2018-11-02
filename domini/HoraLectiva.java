package domini;

import java.util.ArrayList;

public class HoraLectiva
{
    private ArrayList<Assignacio> assignacions;
    
    public HoraLectiva(){
        this.assignacions = new ArrayList<>();
    }
    
    public HoraLectiva(ArrayList<Assignacio> a){
        this.assignacions = new ArrayList<>();
        this.assignacions = a;
    }

    //Comprova que la Assignació asg no tingui ni l'aula ni l'assignatura assignades
    public boolean existeixAssignacio(Assignacio asg) {
        for (int i = 0; i < this.assignacions.size(); i++) {
            if(this.assignacions.get(i).getGrupAssignat().equals(asg.getGrupAssignat()) || this.assignacions.get(i).getAulaAssignada().equals(asg.getAulaAssignada())) return true;
        }

        return false;
    }
    
    public boolean afegirAssignacio(Assignacio asg){
        if(existeixAssignacio(asg)) {
            System.out.println(">>> afegirAssignacio(): L'assignacio " + this.codi + " ja té " + a.getCodi() + "com a requisit");
            return false;
        }
        else return this.assignacions.add(asg);
    }

    public boolean esBuit() {
        return (this.assignacions.isEmpty());
    }

}
