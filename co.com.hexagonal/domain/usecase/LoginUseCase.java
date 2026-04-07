package co.com.hexagonal.domain.usecase;

import java.util.List;
import co.com.hexagonal.domain.api.ILoginServicePort;
import co.com.hexagonal.domain.exception.LoginValidationException;
import co.com.hexagonal.domain.model.LoginModel;
import co.com.hexagonal.domain.spi.ILoginPersistencePort;

public class LoginUseCase implements ILoginServicePort {

    private final ILoginPersistencePort loginPersistencePort;

    public LoginUseCase(ILoginPersistencePort loginPersistencePort) {
        if (loginPersistencePort == null) {
            throw new LoginValidationException("El puerto de persistencia de login no puede ser nulo");
        }
        this.loginPersistencePort = loginPersistencePort;
    }

    @Override
    public void save(LoginModel login) {
        validate(login);
        loginPersistencePort.save(login);
    }

    @Override
    public void update(LoginModel login) {
        validate(login);
        loginPersistencePort.update(login);
    }

    @Override
    public void delete(LoginModel login) {
        validateNotNull(login, "El login no puede ser nulo");
        loginPersistencePort.delete(login);
    }

    @Override
    public List<LoginModel> getAll() {
        return loginPersistencePort.getAll();
    }

    private void validate(LoginModel login) {
        validateNotNull(login, "El login no puede ser nulo");
        if (isBlank(login.getNombre())) {
            throw new LoginValidationException("El nombre del usuario es obligatorio");
        }
        if (isBlank(login.getUsuario())) {
            throw new LoginValidationException("El usuario es obligatorio");
        }
        if (isBlank(login.getClave())) {
            throw new LoginValidationException("La clave es obligatoria");
        }
    }

    private void validateNotNull(Object value, String message) {
        if (value == null) {
            throw new LoginValidationException(message);
        }
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}
