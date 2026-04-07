package co.com.hexagonal.domain.exception;

public class ProductosValidationException extends DomainValidationException {

    public ProductosValidationException(String message) {
        super(message);
    }
}
