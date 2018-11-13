package domini;

import java.util.Iterator;

public class Titulacio {

    private String nom;
    private String tipus;

//    public enum tipusTitulacio {
//        "GRAU",
//        "MASTER";
//    }

    public Titulacio() {
        this.nom = new String();
        this.tipus = null;
    }

    public Titulacio(String nom, String tipus) {
        this.nom = nom;
        this.tipus = tipus;
    }

    public Titulacio(Titulacio t) {
        this.nom = t.getNomTitulacio();
        this.tipus = t.getTipusTitulacio();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Titulacio t = new Titulacio();
        try {
            t = (Titulacio) super.clone();
        }
        catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        return t;
    }

    public String getNomTitulacio() {
        return this.nom;
    }

    public String getTipusTitulacio() {
        return this.tipus;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public boolean equals(Titulacio t) {
        if ((this.nom.equals(t.getNomTitulacio())) && (this.tipus.equals(t.getTipusTitulacio()))) return true;
        return false;
    }

    public void printTitulacioLong() {
        System.out.println("   Titulacio:");
        System.out.println("    nomTitulacio: " + this.nom);
        System.out.println("    tipus       : " + this.tipus);
    }

    public void printTitulacio() {
        System.out.println("   Titulacio: " + this.nom + " [" + this.tipus + "]");
    }
}
