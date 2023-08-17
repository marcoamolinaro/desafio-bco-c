package br.com.carrefour.fluxocaixaservice.controller;

import br.com.carrefour.fluxocaixaservice.model.FluxoDeCaixaResponse;
import br.com.carrefour.fluxocaixaservice.external.client.model.LancamentoResponse;
import br.com.carrefour.fluxocaixaservice.service.FluxoDeCaixaService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fluxodecaixa")
@Log4j2
public class FluxoDeCaixaController {

    @Autowired
    private FluxoDeCaixaService fluxoDeCaixaService;

    @GetMapping
    public ResponseEntity<List<LancamentoResponse>> lerLancementos() {
        List<LancamentoResponse> lancamentoResponses = fluxoDeCaixaService.lerLancamentos();
        return new ResponseEntity<>(lancamentoResponses, HttpStatus.OK);
    }

    @GetMapping("/consolidadodiario")
    public ResponseEntity<List<FluxoDeCaixaResponse>> consolidadoDiario() {
        List<FluxoDeCaixaResponse> lancamentos = fluxoDeCaixaService.consolidadoDiario();
        return new ResponseEntity<>(lancamentos, HttpStatus.OK);
    }
}
