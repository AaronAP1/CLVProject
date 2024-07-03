package clv.project.com.springtest.Service;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class ServiceResilencia {

    @CircuitBreaker(name = "myService", fallbackMethod = "fallback")
    @Retry(name = "myService")
    @TimeLimiter(name = "myService")
    public CompletableFuture<String> performOperation() {
        return CompletableFuture.supplyAsync(() -> {
            // Simula una operación de larga duración
            if (Math.random() > 0.5) {
                throw new RuntimeException("Fallo simulado");
            }
            return "Operación exitosa";
        });
    }

    public CompletableFuture<String> fallback(Throwable t) {
        return CompletableFuture.completedFuture("Respuesta de reserva debido a: " + t.getMessage());
    }
}
