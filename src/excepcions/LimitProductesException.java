package excepcions;

public class LimitProductesException extends Exception {
    String message = "No es poden afegir més productes a la comanda.\n";
    public LimitProductesException(String message) {
        super(message);
    }
}