package excepcions;

public class EnumFailException extends Exception {
    String message = "No s'ha trobat cap element amb aquesta descripció.\n";
    public EnumFailException(String message) {
        super(message);
    }
}
