package clv.project.com.springtest.Controller;


import clv.project.com.springtest.Model.Pagos;
import clv.project.com.springtest.Service.PagosService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/pagos")
@CrossOrigin({"*"})
public class PagosController {

    @Autowired
    PagosService pagosService;

    @GetMapping("/listar")
    @CircuitBreaker(name = "pagosService", fallbackMethod = "fallback")
    public List<Pagos> getAllPagos() {
        return pagosService.readAllPagos();
    }

    @GetMapping("/buscar/{idpagos}")
    @CircuitBreaker(name = "pagosService", fallbackMethod = "fallback")
    public Optional<Pagos> getPagosById(@PathVariable int idpagos) {
        return pagosService.readById(idpagos);
    }

    @GetMapping("/buscar/cod/{codigopago}")
    @CircuitBreaker(name = "pagosService", fallbackMethod = "fallback")
    public List<Pagos> getPagosByCodigo(@PathVariable int codigopago) {
        return pagosService.findByCodigopago(codigopago);
    }

    @PostMapping("/crear")
    @CircuitBreaker(name = "pagosService", fallbackMethod = "fallback")
    public Pagos create(@RequestBody Pagos pagos) {
        return pagosService.createPago(pagos);
    }

    @DeleteMapping("/borrar/{idpagos}")
    @CircuitBreaker(name = "pagosService", fallbackMethod = "fallback")
    public void delete(@PathVariable int idpagos) {
        pagosService.deletePago(idpagos);
    }

    // Fallback method
    public List<Pagos> fallback(Throwable t) {
        // Implementa un fallback apropiado aquí
        return null;
    }
}
