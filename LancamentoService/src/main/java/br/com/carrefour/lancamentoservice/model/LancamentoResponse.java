package br.com.carrefour.lancamentoservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LancamentoResponse {
    private long lancamentoId;
    private Instant dataLancamento;
    private String descricao;
    private double valor;
}
