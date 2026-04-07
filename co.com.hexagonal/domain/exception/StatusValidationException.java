package co.com.hexagonal.domain.exception;

public class StatusValidationException extends DomainValidationException {

    public StatusValidationException(String message) {
        super(message);
    }
}
