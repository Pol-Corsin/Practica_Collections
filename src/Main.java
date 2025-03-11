import view.Vista;
import model.object.Alimentacio;
import model.object.Producte;
import model.object.Textil;
import model.object.Electronica;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static List<Producte> magatzem = new ArrayList<>();
    private static Map<String, Producte> carretCompra = new HashMap<>();
    private static List<String> tiquetsCompra = new ArrayList<>();
    private static Vista vista = new Vista();

    public static void main(String[] args) {
        boolean sortir = false;
        while (!sortir) {
            vista.mostrarMissatge("BENVINGUT AL SUPERMERCAT");
            vista.mostrarMissatge("1) Gestió Magatzem i Compres");
            vista.mostrarMissatge("2) Introduir producte");
            vista.mostrarMissatge("3) Passar per caixa");
            vista.mostrarMissatge("4) Mostrar carro de la compra");
            vista.mostrarMissatge("0) Sortir");

            String opcio = vista.obtenirEntrada("Escull una opció:");

            switch (opcio) {
                case "1":
                    gestioMagatzem();
                    break;
                case "2":
                    introduirProducte();
                    break;
                case "3":
                    passarPerCaixa();
                    break;
                case "4":
                    mostrarCarroCompra();
                    break;
                case "0":
                    sortir = true;
                    break;
                default:
                    vista.mostrarMissatge("Opció no vàlida.");
            }
        }
    }

    private static void gestioMagatzem() {
        boolean tornar = false;
        while (!tornar) {
            vista.mostrarMissatge("1.1) Caducitat");
            vista.mostrarMissatge("1.2) Tiquets de compra");
            vista.mostrarMissatge("1.3) Composició tèxtil");
            vista.mostrarMissatge("1.0) Tornar");

            String opcio = vista.obtenirEntrada("Escull una opció:");

            switch (opcio) {
                case "1.1":
                    mostrarPerCaducitat();
                    break;
                case "1.2":
                    mostrarTiquetsCompra();
                    break;
                case "1.3":
                    mostrarPerComposicioTextil();
                    break;
                case "1.0":
                    tornar = true;
                    break;
                default:
                    vista.mostrarMissatge("Opció no vàlida.");
            }
        }
    }

    private static void introduirProducte() {
        boolean tornar = false;
        while (!tornar) {
            vista.mostrarMissatge("2.1) Alimentació");
            vista.mostrarMissatge("2.2) Tèxtil");
            vista.mostrarMissatge("2.3) Electrònica");
            vista.mostrarMissatge("2.0) Tornar");

            String opcio = vista.obtenirEntrada("Escull una opció:");

            switch (opcio) {
                case "2.1":
                    introduirAlimentacio();
                    break;
                case "2.2":
                    introduirTextil();
                    break;
                case "2.3":
                    introduirElectronica();
                    break;
                case "2.0":
                    tornar = true;
                    break;
                default:
                    vista.mostrarMissatge("Opció no vàlida.");
            }
        }
    }

    private static void introduirAlimentacio() {
        String nom = vista.obtenirEntrada("Nom del producte:");
        double preu = Double.parseDouble(vista.obtenirEntrada("Preu:"));
        String codiBarres = vista.obtenirEntrada("Codi de barres:");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataCaducitat = null;
        try {
            dataCaducitat = LocalDate.parse(vista.obtenirEntrada("Data de caducitat (dd/MM/yyyy):"), formatter);
        } catch (DateTimeParseException e) {
            vista.mostrarMissatge("Format de data incorrecte. Si us plau, introdueix la data en el format dd/MM/yyyy.");
            return;
        }

        Alimentacio aliment = new Alimentacio(nom, preu, codiBarres, dataCaducitat);
        magatzem.add(aliment);
    }

    private static void introduirTextil() {
        String nom = vista.obtenirEntrada("Nom del producte:");
        double preu = Double.parseDouble(vista.obtenirEntrada("Preu:"));
        String codiBarres = vista.obtenirEntrada("Codi de barres:");
        String composicio = vista.obtenirEntrada("Composició tèxtil:");

        Textil textil = new Textil(nom, preu, codiBarres, composicio);
        magatzem.add(textil);
    }

    private static void introduirElectronica() {
        String nom = vista.obtenirEntrada("Nom del producte:");
        double preu = Double.parseDouble(vista.obtenirEntrada("Preu:"));
        String codiBarres = vista.obtenirEntrada("Codi de barres:");
        int diesGarantia = Integer.parseInt(vista.obtenirEntrada("Dies de garantia:"));

        Electronica electronica = new Electronica(nom, preu, codiBarres, diesGarantia);
        magatzem.add(electronica);
    }

    private static void passarPerCaixa() {
        double total = 0;
        StringBuilder tiquet = new StringBuilder();
        tiquet.append("Data de la compra: ").append(LocalDate.now()).append("\n");
        tiquet.append("Nom del supermercat: SAPAMERCAT\n");
        tiquet.append("Detall de la compra:\n");

        for (Producte producte : carretCompra.values()) {
            double preu = producte.calcularPreu();
            tiquet.append(producte.getNom()).append(" - ").append(preu).append("€\n");
            total += preu;
        }

        tiquet.append("Total a pagar: ").append(total).append("€\n");
        vista.mostrarMissatge(tiquet.toString());
        tiquetsCompra.add(tiquet.toString());
        carretCompra.clear();
    }

    private static void mostrarCarroCompra() {
        for (Producte producte : carretCompra.values()) {
            vista.mostrarMissatge(producte.getNom());
        }
    }

    private static void mostrarPerCaducitat() {
        List<Alimentacio> aliments = new ArrayList<>();
        for (Producte producte : magatzem) {
            if (producte instanceof Alimentacio) {
                aliments.add((Alimentacio) producte);
            }
        }
        aliments.sort(Comparator.comparing(Alimentacio::getDataCaducitat));
        for (Alimentacio aliment : aliments) {
            vista.mostrarMissatge(aliment.getNom() + " - " + aliment.getDataCaducitat());
        }
    }

    private static void mostrarTiquetsCompra() {
        for (String tiquet : tiquetsCompra) {
            vista.mostrarMissatge(tiquet);
        }
    }

    private static void mostrarPerComposicioTextil() {
        List<Textil> textils = new ArrayList<>();
        for (Producte producte : magatzem) {
            if (producte instanceof Textil) {
                textils.add((Textil) producte);
            }
        }
        textils.sort(Comparator.comparing(Textil::getComposicio));
        for (Textil textil : textils) {
            vista.mostrarMissatge(textil.getNom() + " - " + textil.getComposicio());
        }

    }

}