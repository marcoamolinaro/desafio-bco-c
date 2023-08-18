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

        log.info("Obtendo " + lancamentoResponses.size() +  " lançamento(s)");

        Map<String, Double> consolidado = new HashMap<>();
        List<FluxoDeCaixaResponse> fluxoDeCaixaResponses = new ArrayList<>();

        consolidado = consolidarLancamentos(lancamentoResponses, consolidado);

        for (Map.Entry<String, Double> map : consolidado.entrySet()) {
            FluxoDeCaixaResponse fluxoDeCaixaResponse = FluxoDeCaixaResponse
                    .builder()
                    .dataLancamento(map.getKey())
                    .valor(map.getValue())
                    .build();
            fluxoDeCaixaResponses.add(fluxoDeCaixaResponse);
        }

        log.info("Retornando " + fluxoDeCaixaResponses.size() + " lançamento(s) consolidado(s)");

        return fluxoDeCaixaResponses;
    }

    private Map<String, Double> consolidarLancamentos(List<LancamentoResponse> lancamentoResponses, Map<String, Double> consolidado) {
        double saldo = 0.0;

        Map<String, Double> mapConsolidado = new HashMap<>();

        for (LancamentoResponse l : lancamentoResponses) {
            String data = l.getDataLancamento().toString().substring(0, 10);
            if (mapConsolidado.containsKey(data)) {
                saldo = mapConsolidado.get(data) + l.getValor();
            } else {
                saldo = l.getValor();
            }
            mapConsolidado.put(data, saldo);
        }

        return mapConsolidado;
    }
}
