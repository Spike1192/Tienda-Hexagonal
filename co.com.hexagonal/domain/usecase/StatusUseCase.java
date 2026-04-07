package co.com.hexagonal.domain.usecase;

import java.util.List;
import co.com.hexagonal.domain.api.IStatusServicePort;
import co.com.hexagonal.domain.exception.StatusValidationException;
import co.com.hexagonal.domain.model.StatusModel;
import co.com.hexagonal.domain.spi.IStatusPersistencePort;

public class StatusUseCase implements IStatusServicePort {

    private final IStatusPersistencePort statusPersistencePort;

    public StatusUseCase(IStatusPersistencePort statusPersistencePort) {
        if (statusPersistencePort == null) {
            throw new StatusValidationException("El puerto de persistencia de estado no puede ser nulo");
        }
        this.statusPersistencePort = statusPersistencePort;
    }

    @Override
    public void save(StatusModel status) {
        validate(status);
        statusPersistencePort.save(status);
    }

    @Override
    public void update(StatusModel status) {
        validate(status);
        statusPersistencePort.update(status);
    }

    @Override
    public void delete(StatusModel status) {
        validateNotNull(status, "El estado no puede ser nulo");
        statusPersistencePort.delete(status);
    }

    @Override
    public List<StatusModel> getAll() {
        return statusPersistencePort.getAll();
    }

    private void validate(StatusModel status) {
        validateNotNull(status, "El estado no puede ser nulo");
        if (isBlank(status.getDstatus())) {
            throw new StatusValidationException("La descripcion del estado es obligatoria");
        }
    }

    private void validateNotNull(Object value, String message) {
        if (value == null) {
            throw new StatusValidationException(message);
        }
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}
