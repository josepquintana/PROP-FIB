package domini;

public class Assignacio {
       
       private String codiAssig;
       private String codiAula;
       private String codiAssignacio;
       

       public Assignacio(){
           this.codiAssig = new String();
           this.codiAula = new String();
           this.codiAssignacio = new String();
       }

       public Assignacio(String assignatura, String aula, String assignacio){
           this.codiAssig = assignatura;
           this.codiAula = aula;
           this.codiAssignacio = assignacio;
       }

       public Assignacio(Assignatura assig, Aula aula, String assignacio){
           this.codiAssig = assig.getCodi();
           this.codiAula = aula.getCodi();
           this.codiAssignacio = assignacio;
       }
       
       public void setAssignatura(String codi){
           this.codiAssig = codi;
       } 
       
       public void setAula(String codi){
           this.codiAssig = codi;
       }
       
       public void setCodi(String codi){
           this.codiAssignacio = codi;
       } 
       
       public String getAssignaturaAssignada(){
           return this.codiAssig;
       }
       
       public String getAulaAssignada(){
           return this.codiAula;
       }
       
       public String getCodi(){
           return this.codiAssignacio;
       }      
       
}
