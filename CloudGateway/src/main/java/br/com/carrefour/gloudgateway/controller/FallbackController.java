package br.com.carrefour.gloudgateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/lancamentoFallBack")
    public String lancamentoFallBack() {
        return "Lançamento Service está fora do ar!";
    }

    @GetMapping("/fluxodecaixaserviceFallBack")
    public String fluxodecaixaserviceFallback() {
        return "Fluxo de Caixa Service está fora do ar!";
    }

}
