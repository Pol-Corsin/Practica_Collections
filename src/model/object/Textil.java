package model.object;

public class Textil extends Producte {
    private String composicio;

    public Textil(String nom, double preu, String codiBarres, String composicio) {
        super(nom, preu, codiBarres);
        this.composicio = composicio;
    }

    public String getComposicio() {
        return composicio;
    }

    public void setComposicio(String composicio) {
        this.composicio = composicio;
    }

    @Override
    public double calcularPreu() {
        return getPreu();
    }
}