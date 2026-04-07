package co.com.hexagonal.domain.api;

import java.util.List;
import co.com.hexagonal.domain.model.StatusModel;

public interface IStatusServicePort {

    void save(StatusModel status);

    void update(StatusModel status);

    void delete(StatusModel status);

    List<StatusModel> getAll();
}
