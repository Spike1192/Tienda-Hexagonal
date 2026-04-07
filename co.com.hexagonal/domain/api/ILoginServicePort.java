package co.com.hexagonal.domain.api;

import java.util.List;
import co.com.hexagonal.domain.model.LoginModel;

public interface ILoginServicePort {

    void save(LoginModel login);

    void update(LoginModel login);

    void delete(LoginModel login);

    List<LoginModel> getAll();
}
