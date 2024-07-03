package clv.project.com.springtest.Controller;


import clv.project.com.springtest.Model.User;
import clv.project.com.springtest.Service.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/usuarios")
@CrossOrigin({"*"})
public class UsuarioController {

    @Autowired
    Usuario usuarioService;

    @GetMapping("/listar")
    public List<User> listar() {
        return usuarioService.readAllUsuarios();
    }

    @GetMapping("/buscar/{id}")
    public Optional<User> buscar(@PathVariable int id) {
        return usuarioService.readUsuario(id);
    }


    @DeleteMapping("/borrar/{id}")
    public void borrar(@PathVariable int id) {
        usuarioService.deleteUsuario(id);
    }






}
