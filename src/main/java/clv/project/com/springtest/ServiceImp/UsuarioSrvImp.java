package clv.project.com.springtest.ServiceImp;



import clv.project.com.springtest.Model.User;
import clv.project.com.springtest.Repository.UserRepository;
import clv.project.com.springtest.Service.Usuario;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioSrvImp implements Usuario {

    @Autowired
    UserRepository userepo;


    @Override
    public List<User> readAllUsuarios() {
        return userepo.findAll();
    }

    @Override
    public Optional<User> readUsuario(int id) {
        return userepo.findById(id);
    }


    @Override
    public User updateUsuario(int id, User user) {
        return null;
    }


    @Override
    public void deleteUsuario(int id) {
        userepo.deleteById(id);
    }
}
