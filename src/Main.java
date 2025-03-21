import excepcions.*;
import model.*;
import model.object.Alimentacio;
import model.object.Electronica;
import model.object.Producte;
import model.object.Textil;
import view.Vista;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Main {
    private static Vista vista = new Vista();
    private static Model model = new Model();
    private static final int LIMIT_PRODUCTES = 100;

    public static void main(String[] args) {
        try {
            iniciar();
        } catch (IOException e) {
            System.out.println("Error: Problema d'entrada/sortida.");
        }
    }

    public static void iniciar() throws IOException {
        boolean tornar = false;
        Scanner scanner = new Scanner(System.in);

        while (!tornar) {
            vista.mostrarMissatge("BENVINGUT AL SUPERMERCAT");
            vista.mostrarMissatge("1) Gestió Magatzem i Compres");
            vista.mostrarMissatge("2) Introduir producte");
            vista.mostrarMissatge("3) Passar per caixa");
            vista.mostrarMissatge("4) Mostrar carro de la compra");
            vista.mostrarMissatge("0) Sortir");
            String opcio = scanner.nextLine();
            try {
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
                        tornar = true;
                        break;
                    default:
                        throw new IllegalArgumentException("Opció no vàlida.");
                }
            } catch (IllegalArgumentException e) {
                vista.mostrarMissatge(e.getMessage());
            }
        }
    }

    private static void gestioMagatzem() throws IOException {
        boolean tornar = false;
        while (!tornar) {
            vista.mostrarMissatge("1) Caducitat");
            vista.mostrarMissatge("2) Tiquets de compra");
            vista.mostrarMissatge("3) Composició tèxtil");
            vista.mostrarMissatge("0) Tornar");

            String opcio = vista.obtenirEntrada("Escull una opció:");

            try {
                switch (opcio) {
                    case "1":
                        mostrarPerCaducitat();
                        break;
                    case "2":
                        mostrarTiquetsCompra();
                        break;
                    case "3":
                        mostrarPerComposicioTextil();
                        break;
                    case "0":
                        tornar = true;
                        break;
                    default:
                        vista.mostrarMissatge("Opció no vàlida.");
                }
            } catch (FileNotFoundException e) {
                vista.mostrarMissatge(e.getMessage());
            }
        }
    }

    private static void introduirProducte() {
        boolean tornar = false;
        while (!tornar) {
            vista.mostrarMissatge("1) Alimentació");
            vista.mostrarMissatge("2) Tèxtil");
            vista.mostrarMissatge("3) Electrònica");
            vista.mostrarMissatge("0) Tornar");

            String opcio = vista.obtenirEntrada("Escull una opció:");

            try {
                switch (opcio) {
                    case "1":
                        introduirAlimentacio();
                        break;
                    case "2":
                        introduirTextil();
                        break;
                    case "3":
                        introduirElectronica();
                        break;
                    case "0":
                        tornar = true;
                        break;
                    default:
                        vista.mostrarMissatge("Opció no vàlida.");
                }
            } catch (LimitProductesException | DataCaducitatException | NegatiuException | LimitCaracteresException e) {
                vista.mostrarMissatge(e.getMessage());
            } catch (InputMismatchException e) {
                vista.mostrarMissatge("Error: Entrada no vàlida.");
            }
        }
    }

    private static void introduirAlimentacio() throws LimitProductesException, DataCaducitatException, NegatiuException, LimitCaracteresException {
        if (model.getMagatzem().size() >= LIMIT_PRODUCTES) {
            throw new LimitProductesException("S'ha superat el límit de productes.");
        }

        String nom = vista.obtenirEntrada("Nom del producte:");
        if (nom.length() > 50) {
            throw new LimitCaracteresException("El nom del producte supera el límit de caràcters permès.");
        }

        double preu = Double.parseDouble(vista.obtenirEntrada("Preu:"));
        if (preu < 0) {
            throw new NegatiuException("El preu no pot ser negatiu.");
        }

        String codiBarres = vista.obtenirEntrada("Codi de barres:");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate dataCaducitat = null;
        try {
            dataCaducitat = LocalDate.parse(vista.obtenirEntrada("Data de caducitat (dd/MM/yyyy):"), formatter);
        } catch (DateTimeParseException e) {
            throw new DataCaducitatException("Format de data incorrecte. Si us plau, introdueix la data en el format dd/MM/yyyy.");
        }

        Alimentacio aliment = new Alimentacio(nom, preu, codiBarres, dataCaducitat);
        model.afegirProducte(aliment);
    }

    private static void introduirTextil() throws LimitProductesException, NegatiuException, LimitCaracteresException {
        if (model.getMagatzem().size() >= LIMIT_PRODUCTES) {
            throw new LimitProductesException("S'ha superat el límit de productes.");
        }

        String nom = vista.obtenirEntrada("Nom del producte:");
        if (nom.length() > 50) {
            throw new LimitCaracteresException("El nom del producte supera el límit de caràcters permès.");
        }

        double preu = Double.parseDouble(vista.obtenirEntrada("Preu:"));
        if (preu < 0) {
            throw new NegatiuException("El preu no pot ser negatiu.");
        }

        String codiBarres = vista.obtenirEntrada("Codi de barres:");
        String composicio = vista.obtenirEntrada("Composició tèxtil:");

        Textil textil = new Textil(nom, preu, codiBarres, composicio);
        model.afegirProducte(textil);
    }

    private static void introduirElectronica() throws LimitProductesException, NegatiuException, LimitCaracteresException {
        if (model.getMagatzem().size() >= LIMIT_PRODUCTES) {
            throw new LimitProductesException("S'ha superat el límit de productes.");
        }

        String nom = vista.obtenirEntrada("Nom del producte:");
        if (nom.length() > 50) {
            throw new LimitCaracteresException("El nom del producte supera el límit de caràcters permès.");
        }

        double preu = Double.parseDouble(vista.obtenirEntrada("Preu:"));
        if (preu < 0) {
            throw new NegatiuException("El preu no pot ser negatiu.");
        }

        String codiBarres = vista.obtenirEntrada("Codi de barres:");
        int diesGarantia = Integer.parseInt(vista.obtenirEntrada("Dies de garantia:"));

        Electronica electronica = new Electronica(nom, preu, codiBarres, diesGarantia);
        model.afegirProducte(electronica);
    }

    private static void passarPerCaixa() {
        double total = 0;
        StringBuilder tiquet = new StringBuilder();
        tiquet.append("Data de la compra: ").append(LocalDate.now()).append("\n");
        tiquet.append("Nom del supermercat: SAPAMERCAT\n");
        tiquet.append("Detall de la compra:\n");

        for (Producte producte : model.getMagatzem()) {
            double preu = producte.calcularPreu();
            tiquet.append(producte.getNom()).append(" - ").append(preu).append("€\n");
            total += preu;
        }

        tiquet.append("Total a pagar: ").append(total).append("€\n");
        vista.mostrarMissatge(tiquet.toString());
        model.afegirTiquet(tiquet.toString());
        model.buidarMagatzem();
    }

    private static void mostrarCarroCompra() {
        if (model.getMagatzem().isEmpty()) {
            vista.mostrarMissatge("El carro de la compra està buit.");
        } else {
            for (Producte producte : model.getMagatzem()) {
                vista.mostrarMissatge(producte.getNom());
            }
        }
    }

    private static void mostrarPerCaducitat() {
        List<Alimentacio> aliments = new ArrayList<>();
        for (Producte producte : model.getMagatzem()) {
            if (producte instanceof Alimentacio) {
                aliments.add((Alimentacio) producte);
            }
        }
        aliments.sort(Comparator.comparing(Alimentacio::getDataCaducitat));
        for (Alimentacio aliment : aliments) {
            vista.mostrarMissatge(aliment.getNom() + " - " + aliment.getDataCaducitat());
        }
    }

    private static void mostrarTiquetsCompra() throws FileNotFoundException {
        File file = new File("tiquets.txt");
        if (!file.exists()) {
            throw new FileNotFoundException("Fitxer de tiquets no trobat.");
        }
        for (String tiquet : model.getTiquetsCompra()) {
            vista.mostrarMissatge(tiquet);
        }
    }

    private static void mostrarPerComposicioTextil() {
        List<Textil> textils = new ArrayList<>();
        for (Producte producte : model.getMagatzem()) {
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


