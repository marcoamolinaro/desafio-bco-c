package br.com.carrefour.lancamentoservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LancamentoResponse {
    private long lancamentoId;
    private String descricao;
    private double valor;
}
