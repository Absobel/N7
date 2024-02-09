/**
 * CreneauInvalideException indique qu'une date n'est pas valide.
 */
public class CreneauInvalideException extends RuntimeException {
    public CreneauInvalideException(String message) {
        super(message);
    }

    public CreneauInvalideException(String message, Throwable cause) {
        super(message, cause);
    }
}
