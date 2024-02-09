package allumettes;

/**
 * Exception qui indique que l'opération demandée est interdite.
 *
 * @author Absobel
 */
public class OperationInterditeException extends RuntimeException {
    /**
     * Initaliser une OperationInterditeException avec le message précisé.
     *
     * @param message le message explicatif
     */
    public OperationInterditeException(String message) {
        super(message);
    }
}
