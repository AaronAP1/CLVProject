package clv.project.com.springtest.Repository;


import clv.project.com.springtest.Model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Clientes, Integer> {
}
