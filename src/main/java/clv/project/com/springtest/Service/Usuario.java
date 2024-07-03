package clv.project.com.springtest.Service;

import clv.project.com.springtest.Model.User;

import java.util.List;
import java.util.Optional;
public interface Usuario {

    List<User> readAllUsuarios();
    Optional<User> readUsuario(int id);
    User updateUsuario(int id, User user);
    void deleteUsuario(int id);
}
