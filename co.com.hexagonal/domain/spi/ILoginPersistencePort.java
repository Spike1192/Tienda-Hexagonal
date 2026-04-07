package co.com.hexagonal.domain.spi;

import java.util.List;
import co.com.hexagonal.domain.model.LoginModel;

public interface ILoginPersistencePort {

    LoginModel save(LoginModel login);

    LoginModel update(LoginModel login);

    void delete(LoginModel login);

    List<LoginModel> getAll();
}
