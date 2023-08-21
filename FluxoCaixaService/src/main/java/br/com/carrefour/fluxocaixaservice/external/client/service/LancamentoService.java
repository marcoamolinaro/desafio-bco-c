package br.com.carrefour.fluxocaixaservice.external.client.service;

import br.com.carrefour.fluxocaixaservice.exception.CustomException;
import br.com.carrefour.fluxocaixaservice.external.client.model.LancamentoResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@CircuitBreaker(name = "external", fallbackMethod = "fallback")
@FeignClient("LANCAMENTO-SERVICE/lancamento")
public interface LancamentoService {
    @GetMapping
    ResponseEntity<List<LancamentoResponse>> lerTodosLancamentos();

    default void fallback(Exception e) {
        throw new CustomException("Lançamento está fora do ar!", "UNAVAILABLE", 500);
    }
}