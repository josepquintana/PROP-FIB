
package domini;

public class Grup {
    private String codiAssig;
    private int numGrup;
    private int capacitat;
    
    public Grup(){
        this.codiAssig = new String();
        this.numGrup = 0;
        this.capacitat = 0;
    }
    
    public Grup(String codi, int num, int capacitat){
        this.codiAssig = codi;
        this.numGrup = num;
        this.capacitat = capacitat;
    }
    
    public String getCodiAssig(){
        return this.codiAssig;
    }
   
    public int getCapacitat(){
        return this.capacitat;
    }
    
    public int getNumGrup(){
        return this.numGrup;
    }
    
    public void setCodiAssig(String s){
        this.codiAssig = s;
    }
    
    public void setNumGrup(int n){
        this.numGrup = n;
    }
    
    public void setCapacitat(int n){
        this.capacitat = n;
    }
    
    public void printGrup(){
        System.out.println("   Grup:" + this.numGrup);
    }
}
