package co.com.hexagonal.domain.exception;

public class LoginValidationException extends DomainValidationException {

    public LoginValidationException(String message) {
        super(message);
    }
}
