package german.springBoot.agencia.config;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }

    // Opcional: Si necesitas un constructor adicional
    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

