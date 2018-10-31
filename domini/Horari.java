package domini;

public class Horari
{
    private HoraLectiva[][] setmana;
    private int hores;
    private static final int dies = 5;
    
    public Horari(JornadaLectiva jL){
        int hIni = jL.getHoraIni().getHours();
        int hFi = jL.getHoraFi().getHours();
        this.hores = hFi-hIni;
        this.setmana = new HoraLectiva[hores][dies];
    }
    
    public Horari(HoraLectiva[][] set){
        this.setmana = set;
    }
    
    public boolean existeixHora(HoraLectiva h){
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
    
    
}
