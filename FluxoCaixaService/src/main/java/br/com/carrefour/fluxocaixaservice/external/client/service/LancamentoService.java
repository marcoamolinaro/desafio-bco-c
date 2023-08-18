package br.com.carrefour.fluxocaixaservice.external.client.service;

import br.com.carrefour.fluxocaixaservice.external.client.model.LancamentoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("LANCAMENTO-SERVICE/lancamento")
public interface LancamentoService {
    @GetMapping
    List<LancamentoResponse> lerTodosLancamentos();
}