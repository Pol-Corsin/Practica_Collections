package excepcions;

public class DataCaducitatException extends Exception {
    String message = "Format de data incorrecte. Si us plau, introdueix la data en el format dd/MM/yyyy.\n";
    public DataCaducitatException(String message) {
        super(message);
    }
}