package domini;

public class Assignacio {
       
       private String codiAssig;
       private String codiAula;
       
       
       public Assignacio(String assignatura, String aula){
           this.codiAssig = assignatura;
           this.codiAula = aula;
       }
       
       public Assignacio(Assignatura assig, Aula aula){
           this.codiAssig = assig.getCodi();
           this.codiAula = aula.getCodi();
       }
       
       public void setAssignatura(String codi){
           this.codiAssig = codi;
       } 
       
       public void setAula(String codi){
           this.codiAssig = codi;
       } 
       
       public String getAssignatura(){
           return this.codiAssig;
       }
       
       public String getAula(){
           return this.codiAula;
       }
}
