package excepcions;

public class NegatiuException extends Exception {
    String message = "No es poden introduir valors negatius.\n";
    public NegatiuException(String message) {
        super(message);
    }
}