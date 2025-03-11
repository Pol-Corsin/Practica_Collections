package model.object;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Alimentacio extends Producte {
    private LocalDate dataCaducitat;

    public Alimentacio(String nom, double preu, String codiBarres, LocalDate dataCaducitat) {
        super(nom, preu, codiBarres);
        this.dataCaducitat = parseDataCaducitat(String.valueOf(dataCaducitat));
    }

    private LocalDate parseDataCaducitat(String dataCaducitat) {
        try {
            return LocalDate.parse(dataCaducitat, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Data de caducitat no valida.");
        }
    }

    public LocalDate getDataCaducitat() {
        return dataCaducitat;
    }

    public void setDataCaducitat(String dataCaducitat) {
        this.dataCaducitat = parseDataCaducitat(dataCaducitat);
    }

    @Override
    public double calcularPreu() {
        return 0;
    }
}