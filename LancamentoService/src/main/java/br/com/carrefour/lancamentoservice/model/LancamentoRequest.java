package br.com.carrefour.lancamentoservice.model;

import lombok.Data;

import java.time.Instant;

@Data
public class LancamentoRequest {
    private Instant dataLancamento;
    private String descricao;
    private double valor;
}
