package domini;

public class Titulacio {

    private String nom;
    private tipusTitulacio tipus;

    public enum tipusTitulacio {
        GRAU,
        MASTER;
    }

    public Titulacio() {
        this.nom = new String();
        this.tipus = null;
    }

    public Titulacio(String nom, tipusTitulacio tipus) {
        this.nom = nom;
        this.tipus = tipus;
    }

    public String getNomTitulacio() {
        return this.nom;
    }

    public tipusTitulacio getTipusTitulacio() {
        return this.tipus;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setTipus(tipusTitulacio tipus) {
        this.tipus = tipus;
    }

    // @Override
    public boolean equals(Titulacio t) {
        if ((this.nom.equals(t.getNomTitulacio())) && (this.tipus.equals(t.getTipusTitulacio()))) return true;
        return false;
    }

    public void printTitulacio() {
        System.out.println("\n> Titulacio;");
        System.out.println(" nomTitulacio: " + this.nom);
        System.out.println(" tipus       : " + this.tipus.toString());
    }
}
