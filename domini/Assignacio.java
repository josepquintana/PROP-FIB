package domini;

public class Assignacio {
       
       private String codiAssig;
       private String codiAula;
       

       public Assignacio(){
           this.codiAssig = new String();
           this.codiAula = new String();
       }

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
       
       public String getAssignaturaAssignada(){
           return this.codiAssig;
       }
       
       public String getAulaAssignada(){
           return this.codiAula;
       }
}
