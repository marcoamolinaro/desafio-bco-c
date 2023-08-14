package br.com.carrefour.lancamentoservice.controller;

import br.com.carrefour.lancamentoservice.models.LancamentoRequest;
import br.com.carrefour.lancamentoservice.models.LancamentoResponse;
import br.com.carrefour.lancamentoservice.services.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lancamento")
public class LancamentoController {

    @Autowired
    private LancamentoService lancamentoService;
    @PostMapping
    public ResponseEntity<Long> adicionaLancamento(@RequestBody LancamentoRequest lancamentoRequest) {
        long lancamentoId = lancamentoService.adicionarLancamento(lancamentoRequest);
        return new ResponseEntity<>(lancamentoId, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LancamentoResponse> lerLancamentoPorId(@PathVariable("id") long lancamentoId) {
        LancamentoResponse lancamentoResponse = lancamentoService.lerLancamentoPorId(lancamentoId);
        return new ResponseEntity<>(lancamentoResponse, HttpStatus.OK);
    }
}
