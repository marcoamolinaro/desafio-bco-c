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
public class LancamentoResponse {
    private Long lancamentoId;
    private Instant dataLancamento;
    private String descricao;
    private double valor;
}
