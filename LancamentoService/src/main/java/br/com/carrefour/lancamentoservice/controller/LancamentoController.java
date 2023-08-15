package br.com.carrefour.lancamentoservice.controller;

import br.com.carrefour.lancamentoservice.model.LancamentoRequest;
import br.com.carrefour.lancamentoservice.model.LancamentoResponse;
import br.com.carrefour.lancamentoservice.service.LancamentoService;
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

    @PutMapping("/{id}")
    public ResponseEntity<Void> alterarLancamentoPorId(@PathVariable("id") long lancamentoId,
                                                       @RequestBody LancamentoRequest lancamentoRequest) {
        lancamentoService.alterarLancamentoPorId(lancamentoId, lancamentoRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLancamentoPorId(@PathVariable("id") long lancamentoId) {
        lancamentoService.deletarLancamentoPorId(lancamentoId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
