package br.com.carrefour.fluxocaixaservice.service;

import br.com.carrefour.fluxocaixaservice.model.FluxoDeCaixaResponse;
import br.com.carrefour.fluxocaixaservice.external.client.model.LancamentoResponse;
import br.com.carrefour.fluxocaixaservice.external.client.service.LancamentoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Log4j2
public class FluxoDeCaixaServiceImpl implements FluxoDeCaixaService {

    @Autowired
    private LancamentoService lancametoService;

    @Override
    public List<LancamentoResponse> lerLancamentos() {
        log.info("Lendo lançamentos por Fluxo de Caixa");
        ResponseEntity<List<LancamentoResponse>> lancamentoResponses =lancametoService.lerTodosLancamentos();
        log.info(lancamentoResponses.getBody());
        return lancamentoResponses.getBody();
    }

    @Override
    public List<FluxoDeCaixaResponse> consolidadoDiario() {
        log.info("Obter Lançamentos");
        List<LancamentoResponse> lancamentoResponses = lancametoService.lerTodosLancamentos().getBody();

        Map<String, Double> consolidado = new HashMap<>();
        List<FluxoDeCaixaResponse> fluxoDeCaixaResponses = new ArrayList<>();
        double saldo = 0.0;
        for (LancamentoResponse l : lancamentoResponses) {
            String data = l.getDataLancamento().toString().substring(0, 10);
            log.info("Data [" + data + "]");
            if (consolidado.containsKey(data)) {
                saldo = consolidado.get(data) + l.getValor();
            } else {
                saldo = l.getValor();
            }
            consolidado.put(data, saldo);
        }
        for (Map.Entry<String, Double> map : consolidado.entrySet()) {
            FluxoDeCaixaResponse fluxoDeCaixaResponse = FluxoDeCaixaResponse
                    .builder()
                    .dataLancamento(map.getKey())
                    .valor(map.getValue())
                    .build();
            fluxoDeCaixaResponses.add(fluxoDeCaixaResponse);
        }
        return fluxoDeCaixaResponses;
    }
}
