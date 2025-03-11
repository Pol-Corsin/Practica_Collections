package model.object;

import java.time.LocalDate;

public class Alimentacio extends Producte {
    private LocalDate dataCaducitat;

    public Alimentacio(String nom, double preu, String codiBarres, LocalDate dataCaducitat) {
        super(nom, preu, codiBarres);
        this.dataCaducitat = dataCaducitat;
    }

    public LocalDate getDataCaducitat() {
        return dataCaducitat;
    }

    @Override
    public double calcularPreu() {
        LocalDate dataActual = LocalDate.now();
        long diesFalten = dataCaducitat.toEpochDay() - dataActual.toEpochDay();

        double preu = getPreu();
        return preu - preu * (1.0 / (diesFalten + 1)) + (preu * 0.1);
    }
}