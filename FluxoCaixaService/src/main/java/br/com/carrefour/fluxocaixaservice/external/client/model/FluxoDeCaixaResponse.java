package br.com.carrefour.fluxocaixaservice.external.client.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FluxoDeCaixaResponse {
    private String dataLancamento;
    private double valor;
}
