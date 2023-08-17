package br.com.carrefour.fluxocaixaservice.service;

import br.com.carrefour.fluxocaixaservice.model.FluxoDeCaixaResponse;
import br.com.carrefour.fluxocaixaservice.external.client.model.LancamentoResponse;

import java.util.List;

public interface FluxoDeCaixaService {
    List<LancamentoResponse> lerLancamentos();

    List<FluxoDeCaixaResponse> consolidadoDiario();
}
