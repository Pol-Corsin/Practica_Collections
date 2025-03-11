package excepcions;

public class LimitCaracteresException extends Exception {
    String message = "Has superat el límit de caràcters.\n";
    public LimitCaracteresException(String message) {
        super(message);
    }
}