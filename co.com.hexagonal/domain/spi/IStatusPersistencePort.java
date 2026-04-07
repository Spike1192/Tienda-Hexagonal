package co.com.hexagonal.domain.spi;

import java.util.List;
import co.com.hexagonal.domain.model.StatusModel;

public interface IStatusPersistencePort {

    StatusModel save(StatusModel status);

    StatusModel update(StatusModel status);

    void delete(StatusModel status);

    List<StatusModel> getAll();
}
