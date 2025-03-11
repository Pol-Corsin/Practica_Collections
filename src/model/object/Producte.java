package model.object;

public abstract class Producte {
    private String nom;
    private double preu;
    private String codiBarres;

    public Producte(String nom, double preu, String codiBarres) {
        this.nom = nom;
        this.preu = preu;
        this.codiBarres = codiBarres;
    }

    public String getNom() {
        return nom;
    }

    public double getPreu() {
        return preu;
    }

    public String getCodiBarres() {
        return codiBarres;
    }

    public abstract double calcularPreu();
}